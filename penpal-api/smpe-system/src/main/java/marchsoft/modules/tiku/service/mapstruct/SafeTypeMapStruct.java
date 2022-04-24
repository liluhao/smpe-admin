package marchsoft.modules.tiku.service.mapstruct;

import marchsoft.modules.tiku.entity.Dto.SafeType.AddSafeTypeDto;
import marchsoft.modules.tiku.entity.Dto.SafeType.ESafeTypeDto;
import marchsoft.modules.tiku.entity.ESafeType;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * Description：
 *
 * @author m
 * Date: 2022/4/1 16:47
 **/

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SafeTypeMapStruct {

    /* 
    * @Description: 实体类转Dto 
    * @Param: [eSafeTypeList] 
    * @returns: java.util.List<marchsoft.modules.tiku.entity.Dto.SafeType.ESafeTypeDto>
    * @Author: m 
    * @Date: 2022/4/1 16:55
    */
    List<ESafeTypeDto> entityToDto(List<ESafeType> eSafeTypeList);

    /*
    * @Description: AddSafeTypeDto转ESafeType
    * @Param: [safeTypeDto]
    * @returns: marchsoft.modules.tiku.entity.ESafeType
    * @Author: m
    * @Date: 2022/4/4 9:46
    */
    ESafeType addDtoToEitity(AddSafeTypeDto safeTypeDto);

}
