package marchsoft.modules.tiku.service.mapstruct;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import marchsoft.modules.system.entity.dto.UserDTO;
import marchsoft.modules.tiku.entity.Dto.Student.AddStudentDto;
import marchsoft.modules.tiku.entity.Dto.Student.StudentDto;
import marchsoft.modules.tiku.entity.EStudent;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-19T10:15:38+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_161 (Oracle Corporation)"
)
@Component
public class StudentMapStructImpl implements StudentMapStruct {

    @Override
    public UserDTO toUserDto(EStudent student) {
        if ( student == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setCreateBy( student.getCreateBy() );
        userDTO.setCreateTime( student.getCreateTime() );
        userDTO.setUpdateTime( student.getUpdateTime() );
        userDTO.setId( student.getId() );

        return userDTO;
    }

    @Override
    public EStudent addDtoToEntity(AddStudentDto studentDto) {
        if ( studentDto == null ) {
            return null;
        }

        EStudent eStudent = new EStudent();

        eStudent.setUniversityId( studentDto.getUniversityId() );
        eStudent.setName( studentDto.getName() );
        eStudent.setIdCard( studentDto.getIdCard() );
        eStudent.setCollege( studentDto.getCollege() );
        eStudent.setMajor( studentDto.getMajor() );
        eStudent.setStudentNum( studentDto.getStudentNum() );
        eStudent.setAdmissionNum( studentDto.getAdmissionNum() );
        eStudent.setEnrollmentYear( studentDto.getEnrollmentYear() );
        eStudent.setSex( studentDto.getSex() );

        return eStudent;
    }

    @Override
    public List<StudentDto> toDto(List<EStudent> students) {
        if ( students == null ) {
            return null;
        }

        List<StudentDto> list = new ArrayList<StudentDto>( students.size() );
        for ( EStudent eStudent : students ) {
            list.add( eStudentToStudentDto( eStudent ) );
        }

        return list;
    }

    protected StudentDto eStudentToStudentDto(EStudent eStudent) {
        if ( eStudent == null ) {
            return null;
        }

        StudentDto studentDto = new StudentDto();

        studentDto.setCreateBy( eStudent.getCreateBy() );
        studentDto.setCreateTime( eStudent.getCreateTime() );
        studentDto.setUpdateTime( eStudent.getUpdateTime() );
        studentDto.setName( eStudent.getName() );
        studentDto.setIdCard( eStudent.getIdCard() );
        studentDto.setStudentNum( eStudent.getStudentNum() );

        return studentDto;
    }
}
