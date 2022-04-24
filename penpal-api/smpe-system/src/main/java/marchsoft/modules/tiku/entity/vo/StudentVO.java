package marchsoft.modules.tiku.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import marchsoft.modules.tiku.entity.EStudent;

import java.util.EmptyStackException;

@Data
public class StudentVO extends EStudent {
    @ApiModelProperty(value = "学校名称")
    private String universityName;
}
