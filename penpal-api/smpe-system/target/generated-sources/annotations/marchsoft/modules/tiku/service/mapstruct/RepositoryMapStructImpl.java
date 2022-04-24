package marchsoft.modules.tiku.service.mapstruct;

import javax.annotation.Generated;
import marchsoft.modules.tiku.entity.Dto.Repository.AddRepositoryDto;
import marchsoft.modules.tiku.entity.ERepository;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-19T10:15:38+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_161 (Oracle Corporation)"
)
@Component
public class RepositoryMapStructImpl implements RepositoryMapStruct {

    @Override
    public ERepository addDtoToEntity(AddRepositoryDto repositoryDto) {
        if ( repositoryDto == null ) {
            return null;
        }

        ERepository eRepository = new ERepository();

        eRepository.setSafeTypeId( repositoryDto.getSafeTypeId() );
        eRepository.setQuesType( repositoryDto.getQuesType() );
        eRepository.setQuesContent( repositoryDto.getQuesContent() );
        eRepository.setOptions( repositoryDto.getOptions() );
        eRepository.setAnswer( repositoryDto.getAnswer() );
        eRepository.setIsCheck( repositoryDto.getIsCheck() );

        return eRepository;
    }
}
