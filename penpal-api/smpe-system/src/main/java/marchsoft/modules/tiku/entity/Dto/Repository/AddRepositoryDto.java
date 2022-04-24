package marchsoft.modules.tiku.entity.Dto.Repository;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Description：
 *
 * @author m
 * Date: 2022/4/12 19:46
 **/

@Data
public class AddRepositoryDto {

    @ApiModelProperty(value = "安全分类id")
    @NotBlank(message = "安全分类id不能为空")
    private Long safeTypeId;

    @ApiModelProperty(value = "题型(1:单选 2:多选 3:判断)")
    @NotBlank(message = "题型不能为空")
    private Integer quesType;

    @ApiModelProperty(value = "题干")
    @NotBlank(message = "题干不能为空")
    private String quesContent;

    @ApiModelProperty(value = "选项")
    @NotBlank(message = "选项不能为空")
    private String options;

    @ApiModelProperty(value = "答案")
    @NotBlank(message = "答案不能为空")
    private String answer;

    @ApiModelProperty(value = "是否审核(0:未审核,1:已审核)")
    private Boolean isCheck;

}