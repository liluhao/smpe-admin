package marchsoft.modules.tiku.entity.Dto.Student;

import lombok.Data;
import marchsoft.base.BaseDTO;

import java.io.Serializable;

@Data
public class StudentDto extends BaseDTO implements Serializable {

    private String name;

    private String idCard;

    private String studentNum;

}