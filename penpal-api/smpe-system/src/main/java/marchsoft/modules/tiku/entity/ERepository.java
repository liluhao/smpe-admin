package marchsoft.modules.tiku.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import marchsoft.base.BasicModel;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="ERepository对象", description="题库")
public class ERepository extends BasicModel<ERepository> {

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

//    @ApiModelProperty(value = "更新时间")
//    @TableField(fill = FieldFill.INSERT_UPDATE)
//    private LocalDateTime updateTime;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
