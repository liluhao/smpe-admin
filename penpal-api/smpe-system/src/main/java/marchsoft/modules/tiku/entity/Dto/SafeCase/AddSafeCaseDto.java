package marchsoft.modules.tiku.entity.Dto.SafeCase;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class AddSafeCaseDto {

    @ApiModelProperty(value = "案例标题")
    @NotBlank(message = "案例标题不能为空")
    private String title;

    @ApiModelProperty(value = "案例内容")
    @NotBlank(message = "案例内容不能为空")
    private String content;

    @ApiModelProperty(value = "安全分类id")
    @NotNull(message = "安全分类id不能为空")
    private Long safeType;

    @ApiModelProperty(value = "案例封面图片")
    private String picPath;

    @ApiModelProperty(value = "关键词")
    @NotBlank(message = "关键词不能为空")
    private String keywords;

    @ApiModelProperty(value = "获赞量")
    private Integer tags;

    @ApiModelProperty(value = "踩踩数")
    private Integer dislike;

    @ApiModelProperty(value = "浏览量")
    private Integer pageView;
}