package marchsoft.modules.tiku.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import lombok.RequiredArgsConstructor;
import marchsoft.enums.ResultEnum;
import marchsoft.exception.BadRequestException;
import marchsoft.modules.tiku.entity.ESlideshow;
import marchsoft.modules.tiku.entity.EStudyData;
import marchsoft.modules.tiku.mapper.ESlideshowMapper;
import marchsoft.modules.tiku.mapper.EStudyDataMapper;
import marchsoft.modules.tiku.service.IESlideshowService;
import marchsoft.base.BasicServiceImpl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import marchsoft.response.Result;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
* <p>
* 轮播图 服务实现类
* </p>
*
* @author m
* @since 2022-03-29
*/
@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = "slideshow")
public class ESlideshowServiceImpl extends BasicServiceImpl<ESlideshowMapper, ESlideshow> implements IESlideshowService {

    private final ESlideshowMapper eSlideshowMapper;
    private final EStudyDataMapper eStudyDataMapper;

    public static <E> Result<E> success(E data){
        return new Result<>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(), data);
    }

    @Override
    @Cacheable(key = "'all:alls'")
    public List<ESlideshow> getAllSlide() {
        return eSlideshowMapper.selectList(null);
    }

    @Override
    @Cacheable(key = "'all:' + #page.current + #page.size + #page.orders ")
    public IPage<ESlideshow> getAll(IPage<ESlideshow> page) {
        IPage<ESlideshow> eSlideshowIPage = eSlideshowMapper.getAllPage(page);
        return eSlideshowIPage;
    }

    @Override
    @CacheEvict(key = "'all'",allEntries = true)
    public void addSlideshow(ESlideshow eSlideshow) {
        if (ObjectUtil.isNotNull(eSlideshow.getStudyDataId())){
            EStudyData eStudyData = eStudyDataMapper.selectById(eSlideshow.getStudyDataId());
            if (ObjectUtil.isNull(eStudyData)){
                throw new BadRequestException(ResultEnum.STUDY_DATA_NOT_EXIST);
            }
        }
        LambdaQueryWrapper<ESlideshow> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ESlideshow::getSort,eSlideshow.getSort());
        ESlideshow eSlideshow1 = eSlideshowMapper.selectOne(queryWrapper);
        if (ObjectUtil.isNotNull(eSlideshow1)) {
            throw new BadRequestException(ResultEnum.STUDY_DATA_IS_EXIST);
        }
        if (ObjectUtil.isNotNull(eSlideshow.getStudyDataId())){
            LambdaQueryWrapper<ESlideshow> queryWrapper1 = new LambdaQueryWrapper<>();
            queryWrapper1.eq(ESlideshow::getStudyDataId,eSlideshow.getStudyDataId());
            ESlideshow eSlideshow2 = eSlideshowMapper.selectOne(queryWrapper1);
            if (ObjectUtil.isNotNull(eSlideshow2)){
                throw new BadRequestException(ResultEnum.SLIDE_SHOW_STUDY_DATA_IS_EXIST);
            }
        }
        int i = eSlideshowMapper.insert(eSlideshow);
        if (i<1){
            throw new BadRequestException(ResultEnum.INSERT_OPERATION_FAIL);
        }
    }

    @Override
    @CacheEvict(key = "'all'",allEntries = true)
    public void updateSlideshow(ESlideshow eSlideshow) {
        ESlideshow oldeSlideshow = eSlideshowMapper.selectById(eSlideshow);
        //判断studyDataId值不能为空
        if (ObjectUtil.isNotNull(eSlideshow.getStudyDataId())){
            EStudyData eStudyData = eStudyDataMapper.selectById(eSlideshow.getStudyDataId());
            if (ObjectUtil.isNull(eStudyData)){
                throw new BadRequestException(ResultEnum.STUDY_DATA_NOT_EXIST);
            }
        }
        //判断学习资料id在轮播图中是否重复
        LambdaQueryWrapper<ESlideshow> queryWrapper1 = new LambdaQueryWrapper<>();
        queryWrapper1.eq(ESlideshow::getStudyDataId,eSlideshow.getStudyDataId());
        ESlideshow eSlideshow2 = eSlideshowMapper.selectOne(queryWrapper1);
        if (ObjectUtil.isNotNull(eSlideshow2) && !eSlideshow.getStudyDataId().equals(oldeSlideshow.getStudyDataId())){
            throw new BadRequestException(ResultEnum.SLIDE_SHOW_STUDY_DATA_IS_EXIST);
        }
        //判断轮播图中现有的学习资料id是否与数据库中重复
        //判断旧值的轮播图顺序是否与新值的轮播图顺序一致
        if (!oldeSlideshow.getSort().equals(eSlideshow.getSort())){
            LambdaQueryWrapper<ESlideshow> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(ESlideshow::getSort,eSlideshow.getSort());
            ESlideshow eSlideshow1 = eSlideshowMapper.selectOne(queryWrapper);
            if (ObjectUtil.isNotNull(eSlideshow1) && !eSlideshow.getStudyDataId().equals(oldeSlideshow.getStudyDataId())) {
                throw new BadRequestException(ResultEnum.STUDY_DATA_IS_EXIST);
            }
        }
        int i = eSlideshowMapper.updateById(eSlideshow);
        if (i<1){
            throw new BadRequestException(ResultEnum.UPDATE_OPERATION_FAIL);
        }
    }

    @Override
    @CacheEvict(key = "'all'",allEntries = true)
    public void deleteSlideshow(Set<Long> ids) {
        eSlideshowMapper.deleteBatchIds(ids);
    }


}

