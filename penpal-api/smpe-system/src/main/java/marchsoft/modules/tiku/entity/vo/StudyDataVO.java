package marchsoft.modules.tiku.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import marchsoft.modules.tiku.entity.EStudyData;

@Data
public class StudyDataVO extends EStudyData {
    @ApiModelProperty(value = "安全类型")
    private String safeName;
}
