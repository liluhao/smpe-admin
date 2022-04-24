package marchsoft.modules.tiku.service.mapstruct;

import marchsoft.modules.tiku.entity.Dto.StudyData.EStudyDataDto;
import marchsoft.modules.tiku.entity.EStudyData;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StudyDataMapStruct {

    /**
     *功能描述: 实体类转Dto
     *
     * @param eStudyDataList eStudyDataList
     * @return List
     * @author mfei
     * @date 2022/4/1
     */
    List<EStudyDataDto> entityToDto(List<EStudyData> eStudyDataList);



}
