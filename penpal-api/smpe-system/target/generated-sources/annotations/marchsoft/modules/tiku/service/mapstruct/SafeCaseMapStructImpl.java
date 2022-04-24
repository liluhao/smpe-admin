package marchsoft.modules.tiku.service.mapstruct;

import javax.annotation.Generated;
import marchsoft.modules.tiku.entity.Dto.SafeCase.AddSafeCaseDto;
import marchsoft.modules.tiku.entity.ESafeCase;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-19T10:15:38+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_161 (Oracle Corporation)"
)
@Component
public class SafeCaseMapStructImpl implements SafeCaseMapStruct {

    @Override
    public ESafeCase addDtoToEntity(AddSafeCaseDto safeCaseDto) {
        if ( safeCaseDto == null ) {
            return null;
        }

        ESafeCase eSafeCase = new ESafeCase();

        eSafeCase.setTitle( safeCaseDto.getTitle() );
        eSafeCase.setContent( safeCaseDto.getContent() );
        eSafeCase.setSafeType( safeCaseDto.getSafeType() );
        eSafeCase.setPicPath( safeCaseDto.getPicPath() );
        eSafeCase.setKeywords( safeCaseDto.getKeywords() );
        eSafeCase.setTags( safeCaseDto.getTags() );
        eSafeCase.setDislike( safeCaseDto.getDislike() );
        eSafeCase.setPageView( safeCaseDto.getPageView() );

        return eSafeCase;
    }
}
