package marchsoft.modules.tiku.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import marchsoft.base.PageVO;
import marchsoft.modules.tiku.entity.Dto.Student.AddStudentDto;
import marchsoft.modules.tiku.entity.Dto.Student.StudentDto;
import marchsoft.modules.tiku.entity.Dto.Student.StudentQueryCriteria;
import marchsoft.modules.tiku.entity.EStudent;
import marchsoft.base.IBasicService;
import marchsoft.modules.tiku.entity.vo.StudentVO;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 学生基本信息表 服务类
 * </p>
 *
 * @author m
 * @since 2022-03-29
 */
public interface IEStudentService extends IBasicService<EStudent> {

    void insert(AddStudentDto studentDto);

    void update(EStudent student);

    void delete(Set<Long> ids);

    Long findStudentIdByStudentNumAndDeptId(String username, Long deptId);

    IPage<StudentVO> selectStudent(StudentQueryCriteria criteria, PageVO pageVO);

    void download(List<StudentDto> queryAll, HttpServletResponse response) throws IOException;

    List<StudentDto> queryAll(StudentQueryCriteria criteria, Boolean isQuery);

    LambdaQueryWrapper<EStudent> analysisQueryCriteria(StudentQueryCriteria criteria);

}
