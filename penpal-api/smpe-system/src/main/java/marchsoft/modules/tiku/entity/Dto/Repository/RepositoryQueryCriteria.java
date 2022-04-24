package marchsoft.modules.tiku.entity.Dto.Repository;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Description：
 *
 * @author m
 * Date: 2022/4/12 19:21
 **/

@Data
public class RepositoryQueryCriteria {

    @ApiModelProperty(value = "题库内容")
    private String name;

    private String username;

    private Long id;

    private Long safeTypeId;

    private String quesContent;

    private Integer quesType;

    private String safeName;

}