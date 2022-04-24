package marchsoft.modules.tiku.entity.Dto.StudyData;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class StudyDataStatusDto {

    @NotNull
    private Long id;

    @NotNull
    private Boolean isIntroduce;

}
