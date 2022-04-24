package marchsoft.modules.tiku.service.mapstruct;

import marchsoft.modules.tiku.entity.Dto.SafeCase.AddSafeCaseDto;
import marchsoft.modules.tiku.entity.ESafeCase;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SafeCaseMapStruct {

    ESafeCase addDtoToEntity(AddSafeCaseDto safeCaseDto);

}
