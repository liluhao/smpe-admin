package marchsoft.modules.tiku.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.File;

/**
 * Description：
 *
 * @author m
 * Date: 2022/3/31 11:06
 **/

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class FileMessage {

    @ApiModelProperty(value = "ID")
    private Long id;

    @ApiModelProperty(value = "文件别名")
    private String name;

    @ApiModelProperty(value = "路径")
    private String path;

}