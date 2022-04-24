package marchsoft.modules.tiku.service.mapstruct;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import marchsoft.modules.tiku.entity.Dto.StudyData.EStudyDataDto;
import marchsoft.modules.tiku.entity.EStudyData;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-19T10:15:38+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_161 (Oracle Corporation)"
)
@Component
public class StudyDataMapStructImpl implements StudyDataMapStruct {

    @Override
    public List<EStudyDataDto> entityToDto(List<EStudyData> eStudyDataList) {
        if ( eStudyDataList == null ) {
            return null;
        }

        List<EStudyDataDto> list = new ArrayList<EStudyDataDto>( eStudyDataList.size() );
        for ( EStudyData eStudyData : eStudyDataList ) {
            list.add( eStudyDataToEStudyDataDto( eStudyData ) );
        }

        return list;
    }

    protected EStudyDataDto eStudyDataToEStudyDataDto(EStudyData eStudyData) {
        if ( eStudyData == null ) {
            return null;
        }

        EStudyDataDto eStudyDataDto = new EStudyDataDto();

        eStudyDataDto.setId( eStudyData.getId() );

        return eStudyDataDto;
    }
}
