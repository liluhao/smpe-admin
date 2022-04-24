package marchsoft.modules.tiku.service.mapstruct;

import marchsoft.modules.tiku.entity.Dto.Repository.AddRepositoryDto;
import marchsoft.modules.tiku.entity.ERepository;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RepositoryMapStruct {

    ERepository addDtoToEntity(AddRepositoryDto repositoryDto);
}