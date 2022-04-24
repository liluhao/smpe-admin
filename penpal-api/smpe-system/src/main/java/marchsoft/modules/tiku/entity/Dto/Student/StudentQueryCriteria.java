package marchsoft.modules.tiku.entity.Dto.Student;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class StudentQueryCriteria {

    @ApiModelProperty(value = "姓名")
    private String name;

    private String username;

    private Long universityId;

    @ApiModelProperty(value = "身份证号")
    private String idCard;

    @ApiModelProperty(value = "学院")
    private String college;

    @ApiModelProperty(value = "学号(?)")
    private String studentNum;

    @ApiModelProperty(value = "准考证号")
    private String admissionNum;

    private Long id;

    @ApiModelProperty(value = "入学年份")
    private String enrollmentYear;


}