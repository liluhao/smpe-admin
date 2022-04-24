package marchsoft.modules.tiku.entity.Dto.SafeType;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Description：
 *
 * @author m
 * Date: 2022/4/4 9:03
 **/

@Data
public class AddSafeTypeDto {

    @ApiModelProperty(value = "分类名称")
    @NotBlank(message = "分类名称不能为空")
    private String name;

    @ApiModelProperty(value = "logo")
    @NotBlank(message = "logo不能为空")
    private String picPath;

    @ApiModelProperty(value = "路由路径")
    @NotBlank(message = "路由路径不能为空")
    private String rooterPath;

    @ApiModelProperty(value = "题库图标路径")
    @NotBlank(message = "题库图标路径不能为空")
    private String repositoryPath;

    @ApiModelProperty(value = "分类名简称")
    @NotBlank(message = "分类图简称不能为空")
    private String forShort;

    @ApiModelProperty(value = "图标序号")
    @NotNull(message = "图标序号不能为空")
    private Integer seqNum;

    @ApiModelProperty(value = "是否显示：显示（1），隐藏（0）")
    private Boolean isShow;
}