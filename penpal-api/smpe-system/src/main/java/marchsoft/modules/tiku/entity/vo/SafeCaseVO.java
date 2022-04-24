package marchsoft.modules.tiku.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import marchsoft.modules.tiku.entity.ESafeCase;

@Data
public class SafeCaseVO extends ESafeCase {

    @ApiModelProperty(value = "安全类型")
    private String safeName;

}