package marchsoft.modules.tiku.entity.Dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Description：
 *
 * @author m
 * Date: 2022/4/4 10:58
 **/

@Data
public class TypeStatusDto {

    @NotNull
    private Long safeTypeId;

    @NotNull
    private Boolean isShow;
}