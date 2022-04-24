package marchsoft.modules.tiku.service.mapstruct;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import marchsoft.modules.tiku.entity.Dto.SafeType.AddSafeTypeDto;
import marchsoft.modules.tiku.entity.Dto.SafeType.ESafeTypeDto;
import marchsoft.modules.tiku.entity.ESafeType;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-19T10:15:38+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_161 (Oracle Corporation)"
)
@Component
public class SafeTypeMapStructImpl implements SafeTypeMapStruct {

    @Override
    public List<ESafeTypeDto> entityToDto(List<ESafeType> eSafeTypeList) {
        if ( eSafeTypeList == null ) {
            return null;
        }

        List<ESafeTypeDto> list = new ArrayList<ESafeTypeDto>( eSafeTypeList.size() );
        for ( ESafeType eSafeType : eSafeTypeList ) {
            list.add( eSafeTypeToESafeTypeDto( eSafeType ) );
        }

        return list;
    }

    @Override
    public ESafeType addDtoToEitity(AddSafeTypeDto safeTypeDto) {
        if ( safeTypeDto == null ) {
            return null;
        }

        ESafeType eSafeType = new ESafeType();

        eSafeType.setName( safeTypeDto.getName() );
        eSafeType.setPicPath( safeTypeDto.getPicPath() );
        eSafeType.setRooterPath( safeTypeDto.getRooterPath() );
        eSafeType.setRepositoryPath( safeTypeDto.getRepositoryPath() );
        eSafeType.setForShort( safeTypeDto.getForShort() );
        eSafeType.setSeqNum( safeTypeDto.getSeqNum() );
        eSafeType.setIsShow( safeTypeDto.getIsShow() );

        return eSafeType;
    }

    protected ESafeTypeDto eSafeTypeToESafeTypeDto(ESafeType eSafeType) {
        if ( eSafeType == null ) {
            return null;
        }

        ESafeTypeDto eSafeTypeDto = new ESafeTypeDto();

        eSafeTypeDto.setId( eSafeType.getId() );
        eSafeTypeDto.setName( eSafeType.getName() );

        return eSafeTypeDto;
    }
}
