package marchsoft.modules.tiku.entity.Dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PracticeRecordQueryCriteria {

    @ApiModelProperty(value = "练习记录")
    private String name;

    private String username;
}