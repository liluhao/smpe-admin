package marchsoft.modules.system.service.mapstruct;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import marchsoft.modules.system.entity.Dept;
import marchsoft.modules.system.entity.dto.DeptDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-19T10:15:38+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_161 (Oracle Corporation)"
)
@Component
public class DeptMapStructImpl implements DeptMapStruct {

    @Override
    public Dept toEntity(DeptDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Dept dept = new Dept();

        dept.setCreateBy( dto.getCreateBy() );
        dept.setCreateTime( dto.getCreateTime() );
        dept.setUpdateTime( dto.getUpdateTime() );
        dept.setId( dto.getId() );
        dept.setPid( dto.getPid() );
        dept.setSubCount( dto.getSubCount() );
        dept.setName( dto.getName() );
        dept.setDeptSort( dto.getDeptSort() );
        dept.setEnabled( dto.getEnabled() );

        return dept;
    }

    @Override
    public DeptDTO toDto(Dept entity) {
        if ( entity == null ) {
            return null;
        }

        DeptDTO deptDTO = new DeptDTO();

        deptDTO.setCreateBy( entity.getCreateBy() );
        deptDTO.setCreateTime( entity.getCreateTime() );
        deptDTO.setUpdateTime( entity.getUpdateTime() );
        deptDTO.setId( entity.getId() );
        deptDTO.setName( entity.getName() );
        deptDTO.setEnabled( entity.getEnabled() );
        deptDTO.setDeptSort( entity.getDeptSort() );
        deptDTO.setPid( entity.getPid() );
        deptDTO.setSubCount( entity.getSubCount() );

        return deptDTO;
    }

    @Override
    public List<Dept> toEntity(List<DeptDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Dept> list = new ArrayList<Dept>( dtoList.size() );
        for ( DeptDTO deptDTO : dtoList ) {
            list.add( toEntity( deptDTO ) );
        }

        return list;
    }

    @Override
    public List<DeptDTO> toDto(List<Dept> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<DeptDTO> list = new ArrayList<DeptDTO>( entityList.size() );
        for ( Dept dept : entityList ) {
            list.add( toDto( dept ) );
        }

        return list;
    }
}
