package marchsoft.modules.tiku.entity.Dto.StudyData;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class StudyDataQueryCriteria {
    @ApiModelProperty(value = "文章标题")
    private String name;

    private String keywords;

    private Long safeTypeId;

    private Long id;

    private String title;

    private String username;

    private Integer dataType;
}
