package marchsoft.modules.tiku.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.RequiredArgsConstructor;
import marchsoft.base.PageVO;
import marchsoft.enums.ResultEnum;
import marchsoft.exception.BadRequestException;
import marchsoft.modules.tiku.entity.Dto.SafeType.AddSafeTypeDto;
import marchsoft.modules.tiku.entity.Dto.SafeType.ESafeTypeDto;
import marchsoft.modules.tiku.entity.Dto.SafeType.SafeTypeQueryCriteria;
import marchsoft.modules.tiku.entity.Dto.TypeStatusDto;
import marchsoft.modules.tiku.entity.ESafeType;
import marchsoft.modules.tiku.mapper.ESafeTypeMapper;
import marchsoft.modules.tiku.service.IESafeTypeService;
import marchsoft.base.BasicServiceImpl;
import marchsoft.modules.tiku.service.mapstruct.SafeTypeMapStruct;
import marchsoft.response.Result;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
* <p>
* 安全类别 服务实现类
* </p>
*
* @author m
* @since 2022-03-29
*/
@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = "type")
public class ESafeTypeServiceImpl extends BasicServiceImpl<ESafeTypeMapper, ESafeType> implements IESafeTypeService {

    private final ESafeTypeMapper eSafeTypeMapper;
    private final SafeTypeMapStruct safeTypeMapStruct;
    private AddSafeTypeDto safeTypeDto;

    public static <E> Result<E> success(E data){
        return new Result<>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(), data);
    }

//    @Override
//    @Cacheable(key = "'name:alls'")
//    public List<ESafeType> getAllSafeType() {
//        return eSafeTypeMapper.selectList(null);
//    }

//    @Override
//    @Cacheable(key = "'name:' + #page.current + #page.size + #page.orders ")
//    public IPage<ESafeType> getAll(IPage<ESafeType> page) {
//        IPage<ESafeType> eSafeTypeIpage = eSafeTypeMapper.getAllPage(page);
//        return eSafeTypeIpage;
//    }

    @Override
    @Cacheable(key = "'name:all'")
    public List<ESafeTypeDto> queryAllName() {
        // 状态为显示，没有被删除的
        // 方式一： 使用wrapper
        LambdaQueryWrapper<ESafeType> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ESafeType::getIsShow,1);
        List<ESafeType> eSafeTypes = eSafeTypeMapper.selectList(queryWrapper);
        List<ESafeTypeDto> eSafeTypeDtos = safeTypeMapStruct.entityToDto(eSafeTypes);

        // 方式二：手写sql
//        eSafeTypeMapper.queryAllName();
        return eSafeTypeDtos;
    }

    @Override
    @CacheEvict(key = "'name'",allEntries = true)
    public void insert(AddSafeTypeDto safeTypeDto) {
        LambdaQueryWrapper<ESafeType> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ESafeType::getSeqNum,safeTypeDto.getSeqNum());
        ESafeType safeType = this.getOne(queryWrapper);
        if (ObjectUtil.isNull(safeType)){
            throw new BadRequestException(ResultEnum.SORT_IS_EXIST);
        }
        ESafeType safeType1 = safeTypeMapStruct.addDtoToEitity(safeTypeDto);
        int i = eSafeTypeMapper.insert(safeType1);
        if (i<1){
            throw new BadRequestException(ResultEnum.INSERT_OPERATION_FAIL);
        }
    }

    @Override
    @CacheEvict(key = "'name'",allEntries = true)
    public void updateSafeType(ESafeType safeType) {
        if (ObjectUtil.isNull(safeType.getId())) {
            throw new BadRequestException(ResultEnum.BAD_REQUEST);
        }
        ESafeType byId = this.getById(safeType.getId());
        if (!byId.getSeqNum().equals(safeType.getSeqNum())) {
            // 更新修改了排序字段
            // 判断分类排序字段是否重复
            LambdaQueryWrapper<ESafeType> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(ESafeType::getSeqNum,safeType.getSeqNum());
            ESafeType type = this.getOne(queryWrapper);
            if (ObjectUtil.isNotNull(type)) {
                // 根据排序字段查询已有的数据库，能得到一条数据，表示前端传过来的分类排序不符合要求
                throw new BadRequestException(ResultEnum.SORT_IS_EXIST);
            }
        }

        eSafeTypeMapper.updateById(safeType);
    }

    @Override
    @CacheEvict(key = "'name'",allEntries = true)
    public void updateShow(TypeStatusDto typeStatusDto) {
        eSafeTypeMapper.updateShow(typeStatusDto);
    }

    @Override
    @CacheEvict(key = "'name'",allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public void delete(Set<Long> ids) {
//        eSafeTypeMapper.deleteBatchIds(ids);
        this.removeByIds(ids);
    }

    @Override
    @Cacheable(key = "'name:'+ #criteria.name + #pageVO.size + #pageVO.current + #pageVO.orders")
    public IPage<ESafeType> selectSafeType(SafeTypeQueryCriteria criteria, PageVO pageVO) {
        LambdaQueryWrapper<ESafeType> queryWrapper = new LambdaQueryWrapper<>();
        if (StrUtil.isNotBlank(criteria.getName())) {
            queryWrapper.like(ESafeType::getName,criteria.getName());
        }
        IPage<ESafeType> eSafeTypeIPage = eSafeTypeMapper.selectPage(pageVO.buildPage(),queryWrapper);
        return eSafeTypeIPage;
    }

}

