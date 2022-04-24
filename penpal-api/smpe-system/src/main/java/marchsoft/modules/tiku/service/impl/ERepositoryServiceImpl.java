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
import marchsoft.modules.tiku.entity.Dto.Repository.AddRepositoryDto;
import marchsoft.modules.tiku.entity.Dto.Repository.RepositoryQueryCriteria;
import marchsoft.modules.tiku.entity.ERepository;
import marchsoft.modules.tiku.entity.vo.RepositoryVO;
import marchsoft.modules.tiku.mapper.ERepositoryMapper;
import marchsoft.modules.tiku.service.IERepositoryService;
import marchsoft.base.BasicServiceImpl;
import marchsoft.modules.tiku.service.mapstruct.RepositoryMapStruct;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = "repository")
public class ERepositoryServiceImpl extends BasicServiceImpl<ERepositoryMapper, ERepository> implements IERepositoryService {

    private final ERepositoryMapper eRepositoryMapper;
    private final RepositoryMapStruct repositoryMapStruct;

    @Override
    //@Cacheable(key = "'name:'+ #criteria.name + #pageVO.size + #pageVO.current + #pageVO.orders")
    public IPage<RepositoryVO> selectRepository(RepositoryQueryCriteria criteria, PageVO pageVO) {
        LambdaQueryWrapper<ERepository> queryWrapper = buildERepositoryCriteria(criteria);
        if (StrUtil.isNotBlank(criteria.getName())) {
            queryWrapper.like(ERepository::getQuesContent,criteria.getName());
        }
        IPage<RepositoryVO> repositoryVOIPage = queryAll(criteria, pageVO);
        return repositoryVOIPage;
    }

    @Override
    @CacheEvict(key = "'name'",allEntries = true)
    public void addRepository(AddRepositoryDto repository) {

        ERepository eRepository = repositoryMapStruct.addDtoToEntity(repository);
        int insert = eRepositoryMapper.insert(eRepository);
        if (insert < 1) {
            throw new BadRequestException(ResultEnum.INSERT_OPERATION_FAIL);
        }
    }

    @Override
    @CacheEvict(key = "'name'",allEntries = true)
    public void updateRepository(ERepository repository) {
        if (ObjectUtil.isNull(repository.getId())) {
            throw new BadRequestException(ResultEnum.BAD_REQUEST);
        }
        int i = eRepositoryMapper.updateById(repository);
        if(i<1) {
            throw new BadRequestException(ResultEnum.UPDATE_OPERATION_FAIL);
        }
    }

    @Override
//    @CacheEvict(key = "'name'",allEntries = true)
    public void delete(Set<Long> ids) {
//        1.
//        eRepositoryMapper.deleteBatchIds(ids);
//        2.
        this.removeByIds(ids);
    }

    private LambdaQueryWrapper<ERepository> buildERepositoryCriteria(RepositoryQueryCriteria criteria) {
        LambdaQueryWrapper<ERepository> queryWrapper = new LambdaQueryWrapper<>();

        if (ObjectUtil.isNotNull(criteria.getId())) {
            queryWrapper.eq(ERepository::getId,criteria.getId());
        }

        if (ObjectUtil.isNotNull(criteria.getSafeTypeId())) {
            queryWrapper.eq(ERepository::getSafeTypeId,criteria.getSafeTypeId());
        }

        if (StrUtil.isNotBlank(criteria.getQuesContent())) {
            //默认使用like匹配
            queryWrapper.like(ERepository::getQuesContent, criteria.getQuesContent());
        }

        if (ObjectUtil.isNotNull(criteria.getQuesType())) {
            queryWrapper.eq(ERepository::getQuesType, criteria.getQuesType());
        }
//        if (ObjectUtil.isNotNull(criteria.getStartTime()) && ObjectUtil.isNotNull(criteria.getEndTime())) {
//            queryWrapper.between(ERepository::getCreateTime, criteria.getStartTime(), criteria.getEndTime());
//        }

        return queryWrapper;
    }

    public IPage<RepositoryVO> queryAll(RepositoryQueryCriteria criteria, PageVO pageVO) {
        QueryWrapper<Object> query = new QueryWrapper<>();
        LambdaQueryWrapper<ERepository> queryWrapper = buildERepositoryCriteria(criteria);

        if(ObjectUtil.isNotNull(criteria.getSafeTypeId())){
            query.and(qw->qw.eq("r.safe_type",criteria.getSafeTypeId()));
        }
        query.eq("r.is_deleted",false);
        return eRepositoryMapper.selectRepositoryPage(pageVO.buildPage(),query,queryWrapper);
    }
}

