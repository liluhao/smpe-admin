package marchsoft.modules.tiku.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import marchsoft.modules.tiku.entity.Dto.Repository.ERepositoryDto;

@Data
public class RepositoryVO extends ERepositoryDto {

    @ApiModelProperty(value = "安全类型")
    private String safeName;

}