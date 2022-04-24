package marchsoft.modules.tiku.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import marchsoft.base.BasicModel;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 轮播图
 * </p>
 *
 * @author m
 * @since 2022-03-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="ESlideshow对象", description="轮播图")
public class ESlideshow extends BasicModel<ESlideshow> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "文章标题")
    private String title;

    @ApiModelProperty(value = "图片路径")
    private String picPath;

    @ApiModelProperty(value = "学习资料id")
    private Long studyDataId;

    @ApiModelProperty(value = "轮播图顺序（1：第一张，2：第二张，3：第三张）")
    private Integer sort;

//    @ApiModelProperty(value = "创建时间")
//    private LocalDateTime createTime;
//
//    @ApiModelProperty(value = "更新时间")
//    private LocalDateTime updateTime;
//
//    @ApiModelProperty(value = "创建者")
//    private Long createBy;
//
//    @ApiModelProperty(value = "更新者")
//    private Long updateBy;
//
//    @ApiModelProperty(value = "逻辑删除  删除(1)  未删除（0）")
//    @TableField("is_deleted")
//    private Boolean deleted;

    @ApiModelProperty(value = "学习资料路径")
    private String path;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
