package marchsoft.modules.system.service.mapstruct;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;
import marchsoft.modules.system.entity.Dept;
import marchsoft.modules.system.entity.Menu;
import marchsoft.modules.system.entity.bo.RoleBO;
import marchsoft.modules.system.entity.dto.DeptDTO;
import marchsoft.modules.system.entity.dto.MenuDTO;
import marchsoft.modules.system.entity.dto.RoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-19T10:15:38+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_161 (Oracle Corporation)"
)
@Component
public class RoleMapStructImpl implements RoleMapStruct {

    @Autowired
    private MenuMapStruct menuMapStruct;
    @Autowired
    private DeptMapStruct deptMapStruct;

    @Override
    public RoleBO toEntity(RoleDTO dto) {
        if ( dto == null ) {
            return null;
        }

        RoleBO roleBO = new RoleBO();

        roleBO.setCreateBy( dto.getCreateBy() );
        roleBO.setCreateTime( dto.getCreateTime() );
        roleBO.setUpdateTime( dto.getUpdateTime() );
        roleBO.setId( dto.getId() );
        roleBO.setName( dto.getName() );
        roleBO.setLevel( dto.getLevel() );
        roleBO.setDescription( dto.getDescription() );
        roleBO.setDataScope( dto.getDataScope() );
        roleBO.setProtection( dto.getProtection() );
        roleBO.setMenus( menuDTOSetToMenuSet( dto.getMenus() ) );
        roleBO.setDepts( deptDTOSetToDeptSet( dto.getDepts() ) );

        return roleBO;
    }

    @Override
    public RoleDTO toDto(RoleBO entity) {
        if ( entity == null ) {
            return null;
        }

        RoleDTO roleDTO = new RoleDTO();

        roleDTO.setCreateBy( entity.getCreateBy() );
        roleDTO.setCreateTime( entity.getCreateTime() );
        roleDTO.setUpdateTime( entity.getUpdateTime() );
        roleDTO.setId( entity.getId() );
        roleDTO.setMenus( menuSetToMenuDTOSet( entity.getMenus() ) );
        roleDTO.setDepts( deptSetToDeptDTOSet( entity.getDepts() ) );
        roleDTO.setName( entity.getName() );
        roleDTO.setDataScope( entity.getDataScope() );
        roleDTO.setLevel( entity.getLevel() );
        roleDTO.setDescription( entity.getDescription() );
        roleDTO.setProtection( entity.getProtection() );

        return roleDTO;
    }

    @Override
    public List<RoleBO> toEntity(List<RoleDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<RoleBO> list = new ArrayList<RoleBO>( dtoList.size() );
        for ( RoleDTO roleDTO : dtoList ) {
            list.add( toEntity( roleDTO ) );
        }

        return list;
    }

    @Override
    public List<RoleDTO> toDto(List<RoleBO> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<RoleDTO> list = new ArrayList<RoleDTO>( entityList.size() );
        for ( RoleBO roleBO : entityList ) {
            list.add( toDto( roleBO ) );
        }

        return list;
    }

    protected Set<Menu> menuDTOSetToMenuSet(Set<MenuDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<Menu> set1 = new HashSet<Menu>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( MenuDTO menuDTO : set ) {
            set1.add( menuMapStruct.toEntity( menuDTO ) );
        }

        return set1;
    }

    protected Set<Dept> deptDTOSetToDeptSet(Set<DeptDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<Dept> set1 = new HashSet<Dept>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( DeptDTO deptDTO : set ) {
            set1.add( deptMapStruct.toEntity( deptDTO ) );
        }

        return set1;
    }

    protected Set<MenuDTO> menuSetToMenuDTOSet(Set<Menu> set) {
        if ( set == null ) {
            return null;
        }

        Set<MenuDTO> set1 = new HashSet<MenuDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Menu menu : set ) {
            set1.add( menuMapStruct.toDto( menu ) );
        }

        return set1;
    }

    protected Set<DeptDTO> deptSetToDeptDTOSet(Set<Dept> set) {
        if ( set == null ) {
            return null;
        }

        Set<DeptDTO> set1 = new HashSet<DeptDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Dept dept : set ) {
            set1.add( deptMapStruct.toDto( dept ) );
        }

        return set1;
    }
}
