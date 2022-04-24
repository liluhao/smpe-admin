package marchsoft.modules.tiku.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.RequiredArgsConstructor;
import marchsoft.base.PageVO;
import marchsoft.enums.ResultEnum;
import marchsoft.exception.BadRequestException;
import marchsoft.modules.tiku.entity.Dto.SafeCase.AddSafeCaseDto;
import marchsoft.modules.tiku.entity.Dto.SafeCase.SafeCaseQueryCriteria;
import marchsoft.modules.tiku.entity.ESafeCase;
import marchsoft.modules.tiku.entity.vo.SafeCaseVO;
import marchsoft.modules.tiku.mapper.ESafeCaseMapper;
import marchsoft.modules.tiku.service.IESafeCaseService;
import marchsoft.base.BasicServiceImpl;
import marchsoft.modules.tiku.service.mapstruct.SafeCaseMapStruct;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = "case")
public class ESafeCaseServiceImpl extends BasicServiceImpl<ESafeCaseMapper, ESafeCase> implements IESafeCaseService {

    private final ESafeCaseMapper eSafeCaseMapper;
    private final SafeCaseMapStruct safeCaseMapStruct;

    @Override
//    @Cacheable(key = "'name:'+ #criteria.name + #pageVO.size + #pageVO.current + #pageVO.orders")
    public IPage<SafeCaseVO> selectSafeCase(SafeCaseQueryCriteria criteria, PageVO pageVO) {
        QueryWrapper<ESafeCase> query = buildESafeCaseCriteria(criteria);
        LambdaQueryWrapper<ESafeCase> lambda = query.lambda();
        if (StrUtil.isNotBlank(criteria.getTitle())) {
            lambda.like(ESafeCase::getTitle,criteria.getTitle());
        }
        IPage<SafeCaseVO> safeCaseVOIPage = queryAll(criteria, pageVO);
        return safeCaseVOIPage;
    }

    @Override
//    @CacheEvict(key = "'name'",allEntries = true)
    public void insert(AddSafeCaseDto safeCaseDto) {
        ESafeCase safeCase = safeCaseMapStruct.addDtoToEntity(safeCaseDto);
        int insert = eSafeCaseMapper.insert(safeCase);
        if (insert < 1) {
            throw new BadRequestException(ResultEnum.INSERT_OPERATION_FAIL);
        }
    }

    @Override
//    @CacheEvict(key = "'name'",allEntries = true)
    public void updateSafeCase(ESafeCase safeCase) {
        if (ObjectUtil.isNull(safeCase.getId())) {
            throw new BadRequestException(ResultEnum.BAD_REQUEST);
        }
        eSafeCaseMapper.updateById(safeCase);
    }


    @Override
    @CacheEvict(key = "'name'",allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public void del(Set<Long> ids) {
        this.removeByIds(ids);
    }

    private QueryWrapper<ESafeCase> buildESafeCaseCriteria(SafeCaseQueryCriteria criteria) {
        QueryWrapper<ESafeCase> query = new QueryWrapper<>();
        LambdaQueryWrapper<ESafeCase> lambda = query.lambda();

        if (ObjectUtil.isNotNull(criteria.getId())) {
            lambda.eq(ESafeCase::getId,criteria.getId());
        }

        if (ObjectUtil.isNotNull(criteria.getSafeTypeId())) {
            lambda.eq(ESafeCase::getSafeType,criteria.getSafeTypeId());
        }

        if (StrUtil.isNotBlank(criteria.getKeywords())) {
            //默认使用like匹配
            lambda.like(ESafeCase::getKeywords, criteria.getKeywords());
        }

        if (ObjectUtil.isNotNull(criteria.getTitle())) {
            lambda.eq(ESafeCase::getTitle, criteria.getTitle());
        }


        return query;
    }

    public IPage<SafeCaseVO> queryAll(SafeCaseQueryCriteria criteria, PageVO pageVO) {
        QueryWrapper<ESafeCase> query = buildESafeCaseCriteria(criteria);
        query.eq("sc.is_deleted",false);
        return eSafeCaseMapper.selectSafeCasePage(pageVO.buildPage(),query);
    }

}

