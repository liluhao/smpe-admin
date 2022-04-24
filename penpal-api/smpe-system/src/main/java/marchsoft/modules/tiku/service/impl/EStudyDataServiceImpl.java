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
import marchsoft.modules.tiku.entity.Dto.StudyData.StudyDataStatusDto;
import marchsoft.modules.tiku.entity.Dto.StudyData.StudyDataQueryCriteria;
import marchsoft.modules.tiku.entity.EStudyData;
import marchsoft.modules.tiku.entity.vo.StudyDataVO;
import marchsoft.modules.tiku.mapper.EStudyDataMapper;
import marchsoft.modules.tiku.service.IEStudyDataService;
import marchsoft.base.BasicServiceImpl;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = "data")
public class EStudyDataServiceImpl extends BasicServiceImpl<EStudyDataMapper, EStudyData> implements IEStudyDataService {

    private final EStudyDataMapper eStudyDataMapper;

    private LambdaQueryWrapper<EStudyData> buildEStudyDataCriteria(StudyDataQueryCriteria criteria) {
        LambdaQueryWrapper<EStudyData> queryWrapper = new LambdaQueryWrapper<>();
        if (ObjectUtil.isNotNull(criteria.getId())) {
            queryWrapper.eq(EStudyData::getId, criteria.getId());
        }

        if (ObjectUtil.isNotNull(criteria.getSafeTypeId())) {
            queryWrapper.eq(EStudyData::getSafeTypeId, criteria.getSafeTypeId());
        }

        if (StrUtil.isNotBlank(criteria.getKeywords())) {
            //默认使用like匹配
            queryWrapper.like(EStudyData::getKeywords, criteria.getKeywords());
        }

        if (StrUtil.isNotBlank(criteria.getTitle())) {
            //默认使用like匹配
            queryWrapper.like(EStudyData::getTitle, criteria.getTitle());
        }

        if (ObjectUtil.isNotNull(criteria.getDataType())) {
            queryWrapper.eq(EStudyData::getDataType, criteria.getDataType());
        }

        return queryWrapper;
    }

    @Override
    public IPage<StudyDataVO> queryAll(StudyDataQueryCriteria criteria, PageVO pageVO) {
        LambdaQueryWrapper<EStudyData> queryWrapper = buildEStudyDataCriteria(criteria);
        QueryWrapper<Object> query = new QueryWrapper<>();

        if (ObjectUtil.isNotNull(criteria.getKeywords())) {
            query.and(e -> {
                e.like("sd.title", criteria.getKeywords()).or().like("sd.keywords", criteria.getKeywords());
            });
        }
        if (ObjectUtil.isNotNull(criteria.getSafeTypeId())) {
            query.and(qw -> qw.eq("sd.safe_type_id", criteria.getSafeTypeId()));
        }
        query.eq("sd.is_deleted", false);
        return eStudyDataMapper.queryPage(pageVO.buildPage(), query, queryWrapper);
    }

    @Override
    public IPage<StudyDataVO> selectStudyData(StudyDataQueryCriteria criteria, PageVO pageVO) {
        LambdaQueryWrapper<EStudyData> queryWrapper = buildEStudyDataCriteria(criteria);
        if (ObjectUtil.isNotNull(criteria.getTitle())) {
            queryWrapper.like(EStudyData::getTitle, criteria.getTitle());
        }
        IPage<StudyDataVO> studyDataVOIPage = queryAll(criteria, pageVO);
        return studyDataVOIPage;
    }

    @Override
    @CacheEvict(key = "'all'", allEntries = true)
    public void addStudyData(EStudyData eStudyData) {
        if (ObjectUtil.isNotNull(eStudyData.getId())) {
            eStudyData = eStudyDataMapper.selectById(eStudyData.getId());
            if (ObjectUtil.isNull(eStudyData)) {
                throw new BadRequestException(ResultEnum.STUDY_DATA_NOT_EXIST);
            }
        }
        int i = eStudyDataMapper.insert(eStudyData);
        if (i < 1) {
            throw new BadRequestException(ResultEnum.INSERT_OPERATION_FAIL);
        }
    }

    @Override
    @CacheEvict(key = "'name'", allEntries = true)
    public void updateIntroduce(StudyDataStatusDto dataStatusDto) {

        eStudyDataMapper.updateIntroduce(dataStatusDto);
    }

    @Override
    @CacheEvict(key = "'all'", allEntries = true)
    public void updateStudyData(EStudyData eStudyData) {
        EStudyData oldStudyData = eStudyDataMapper.selectById(eStudyData.getId());
        // 前端传过来的值studyDataId不为空，；并且和旧值不相同
        if (ObjectUtil.isNotNull(eStudyData.getId()) && !eStudyData.getId().equals(oldStudyData.getId())) {
            eStudyData = eStudyDataMapper.selectById(eStudyData.getId());
            if (ObjectUtil.isNull(eStudyData)) {
                throw new BadRequestException(ResultEnum.STUDY_DATA_NOT_EXIST);
            }
            // 判断studyDataId是否重复
            LambdaQueryWrapper<EStudyData> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(EStudyData::getId, eStudyData.getId());
            EStudyData eStudyData2 = eStudyDataMapper.selectOne(wrapper);
            if (ObjectUtil.isNotNull(eStudyData2)) {
                throw new BadRequestException(ResultEnum.SLIDE_SHOW_STUDY_DATA_IS_EXIST);
            }
        }
        int i = eStudyDataMapper.updateById(eStudyData);
        if (i < 1) {
            throw new BadRequestException(ResultEnum.INSERT_OPERATION_FAIL);
        }
    }

    @Override
    @CacheEvict(key = "'all'", allEntries = true)
    public void deleteById(Set<Long> ids) {
        for (Long id : ids) {
            eStudyDataMapper.deleteById(id);
        }
    }
}

