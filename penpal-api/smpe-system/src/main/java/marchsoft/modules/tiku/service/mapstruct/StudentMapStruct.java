package marchsoft.modules.tiku.service.mapstruct;

import marchsoft.modules.system.entity.dto.UserDTO;
import marchsoft.modules.tiku.entity.Dto.Student.AddStudentDto;
import marchsoft.modules.tiku.entity.Dto.Student.StudentDto;
import marchsoft.modules.tiku.entity.EStudent;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * Description：
 *
 * @author m
 * Date: 2022/4/6 14:47
 **/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StudentMapStruct {

    UserDTO toUserDto(EStudent student);

    EStudent addDtoToEntity(AddStudentDto studentDto);

    List<StudentDto> toDto(List<EStudent> students);


}
