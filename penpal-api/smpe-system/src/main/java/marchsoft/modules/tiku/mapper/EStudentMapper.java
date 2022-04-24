package marchsoft.modules.tiku.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import marchsoft.modules.tiku.entity.EStudent;
import marchsoft.base.BasicMapper;
import marchsoft.modules.tiku.entity.vo.StudentVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 学生基本信息表 Mapper 接口
 * </p>
 *
 * @author m
 * @since 2022-03-29
 */
@Component
public interface EStudentMapper extends BasicMapper<EStudent> {

    @Select("SELECT * FROM e_student WHERE is_deleted = 0")
    IPage<EStudent> getAllPage(IPage<EStudent> page);

    @Select("SELECT sd.id, user_id, university_id, sd.name, id_card,college, major, student_num," +
            " admission_num, enrollment_year, sex, sd.create_time, sd.update_time, d.name AS university_name  " +
            "FROM e_student sd LEFT JOIN sys_dept d ON sd.university_id = d.id  ${ew.customSqlSegment}")
    IPage<StudentVO> selectStudentPage(IPage<Object> buildPage, @Param(Constants.WRAPPER) QueryWrapper<EStudent> query);
}
