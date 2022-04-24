package marchsoft.modules.tiku.entity.Dto.Repository;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Description：
 *
 * @author m
 * Date: 2022/4/12 19:48
 **/

@Data
public class ERepositoryDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "安全分类id")
    private Long safeTypeId;

    @ApiModelProperty(value = "题型(1:单选 2:多选 3:判断)")
    private Integer quesType;

    @ApiModelProperty(value = "题干")
    private String quesContent;

    @ApiModelProperty(value = "选项")
    private String options;

    @ApiModelProperty(value = "答案")
    private String answer;

    @ApiModelProperty(value = "是否审核(0:未审核,1:已审核)")
    private Boolean isCheck;

}