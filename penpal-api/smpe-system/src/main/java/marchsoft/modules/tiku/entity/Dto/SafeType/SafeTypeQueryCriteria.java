package marchsoft.modules.tiku.entity.Dto.SafeType;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Description：
 *
 * @author m
 * Date: 2022/4/1 16:41
 **/
@Data
public class SafeTypeQueryCriteria {

    @ApiModelProperty(value = "分类名称")
    private String name;

    private String username;
}