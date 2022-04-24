package marchsoft.service.mapstruct;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import marchsoft.entity.bo.SysLogBO;
import marchsoft.entity.dto.SysLogDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-19T10:15:29+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_161 (Oracle Corporation)"
)
@Component
public class SysLogMapStructImpl implements SysLogMapStruct {

    @Override
    public SysLogBO toEntity(SysLogDTO dto) {
        if ( dto == null ) {
            return null;
        }

        SysLogBO sysLogBO = new SysLogBO();

        sysLogBO.setCreateBy( dto.getCreateBy() );
        sysLogBO.setCreateTime( dto.getCreateTime() );
        sysLogBO.setUpdateTime( dto.getUpdateTime() );
        sysLogBO.setId( dto.getId() );
        sysLogBO.setDescription( dto.getDescription() );
        sysLogBO.setLogType( dto.getLogType() );
        sysLogBO.setMethod( dto.getMethod() );
        sysLogBO.setParams( dto.getParams() );
        sysLogBO.setRequestTime( dto.getRequestTime() );
        sysLogBO.setRequestIp( dto.getRequestIp() );
        sysLogBO.setAddress( dto.getAddress() );
        sysLogBO.setBrowser( dto.getBrowser() );
        sysLogBO.setExceptionDetail( dto.getExceptionDetail() );
        sysLogBO.setUsername( dto.getUsername() );

        return sysLogBO;
    }

    @Override
    public SysLogDTO toDto(SysLogBO entity) {
        if ( entity == null ) {
            return null;
        }

        SysLogDTO sysLogDTO = new SysLogDTO();

        sysLogDTO.setCreateBy( entity.getCreateBy() );
        sysLogDTO.setCreateTime( entity.getCreateTime() );
        sysLogDTO.setUpdateTime( entity.getUpdateTime() );
        sysLogDTO.setId( entity.getId() );
        sysLogDTO.setUsername( entity.getUsername() );
        sysLogDTO.setDescription( entity.getDescription() );
        sysLogDTO.setLogType( entity.getLogType() );
        sysLogDTO.setMethod( entity.getMethod() );
        sysLogDTO.setParams( entity.getParams() );
        sysLogDTO.setRequestTime( entity.getRequestTime() );
        sysLogDTO.setRequestIp( entity.getRequestIp() );
        sysLogDTO.setAddress( entity.getAddress() );
        sysLogDTO.setBrowser( entity.getBrowser() );
        sysLogDTO.setExceptionDetail( entity.getExceptionDetail() );

        return sysLogDTO;
    }

    @Override
    public List<SysLogBO> toEntity(List<SysLogDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<SysLogBO> list = new ArrayList<SysLogBO>( dtoList.size() );
        for ( SysLogDTO sysLogDTO : dtoList ) {
            list.add( toEntity( sysLogDTO ) );
        }

        return list;
    }

    @Override
    public List<SysLogDTO> toDto(List<SysLogBO> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<SysLogDTO> list = new ArrayList<SysLogDTO>( entityList.size() );
        for ( SysLogBO sysLogBO : entityList ) {
            list.add( toDto( sysLogBO ) );
        }

        return list;
    }
}
