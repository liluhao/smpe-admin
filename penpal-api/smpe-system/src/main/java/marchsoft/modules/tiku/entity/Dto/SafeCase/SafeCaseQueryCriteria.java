package marchsoft.modules.tiku.entity.Dto.SafeCase;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SafeCaseQueryCriteria {

    @ApiModelProperty(value = "案例名称")
    private String name;

    private String username;

    private String title;

    private String keywords;

    private Long safeTypeId;

    private Long id;

}