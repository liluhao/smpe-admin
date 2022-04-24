package marchsoft.modules.tiku.entity.Dto.Student;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class AddStudentDto {

    @ApiModelProperty(value = "高校id（关联user表部门id）")
    @NotNull(message = "高校id不能为空")
    private Long universityId;

    @ApiModelProperty(value = "姓名")
    @NotBlank(message = "姓名不能为空")
    private String name;

    @ApiModelProperty(value = "身份证号")
    @NotBlank(message = "身份证号不能为空")
    private String idCard;

    @ApiModelProperty(value = "学院")
    @NotBlank(message = "学院不能为空")
    private String college;

    @ApiModelProperty(value = "专业")
    @NotBlank(message = "专业不能为空")
    private String major;

    @ApiModelProperty(value = "学号(?)")
    @NotBlank(message = "学号不能为空")
    private String studentNum;

    @ApiModelProperty(value = "准考证号")
    @NotBlank(message = "准考证号不能为空")
    private String admissionNum;

    @ApiModelProperty(value = "入学年份")
    @NotBlank(message = "入学年份不能为空")
    private String enrollmentYear;

    @ApiModelProperty(value = "性别   0：男，1：女，默认0")
    @NotNull(message = "性别不能为空")
    private Boolean sex;
}