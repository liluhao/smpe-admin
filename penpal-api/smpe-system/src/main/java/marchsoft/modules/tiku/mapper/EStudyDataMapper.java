package marchsoft.modules.tiku.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import marchsoft.modules.tiku.entity.Dto.StudyData.StudyDataStatusDto;
import marchsoft.modules.tiku.entity.EStudyData;
import marchsoft.base.BasicMapper;
import marchsoft.modules.tiku.entity.vo.StudyDataVO;
import org.apache.catalina.Wrapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import org.springframework.stereotype.Component;

@Component
public interface EStudyDataMapper extends BasicMapper<EStudyData> {


    @Update("UPDATE e_study_data SET is_introduce = #{isIntroduce} WHERE id = #{id}")
    int updateIntroduce(StudyDataStatusDto dataStatusDto);

    @Select("SELECT sd.id, title, content, safe_type_id, keywords, " +
            "tags, sd.cover_pic_link, sd.video_path, " +
            "sd.data_type, sd.data_source, is_introduce, " +
            "dislike, page_view, sd.create_time, " +
            "NAME AS safe_name  " +
            "FROM e_study_data sd " +
            "LEFT JOIN e_safe_type st " +
            "ON sd.safe_type_id = st.id  " +
            "${ew.customSqlSegment}")
    IPage<StudyDataVO> queryPage(IPage<Object> buildPage, @Param(Constants.WRAPPER) QueryWrapper<Object> query, @Param(Constants.WRAPPER) LambdaQueryWrapper<EStudyData> criteria);

}
