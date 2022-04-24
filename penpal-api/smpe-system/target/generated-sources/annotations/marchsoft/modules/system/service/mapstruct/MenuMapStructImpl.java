package marchsoft.modules.system.service.mapstruct;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import marchsoft.modules.system.entity.Menu;
import marchsoft.modules.system.entity.dto.MenuDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-19T10:15:38+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_161 (Oracle Corporation)"
)
@Component
public class MenuMapStructImpl implements MenuMapStruct {

    @Override
    public Menu toEntity(MenuDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Menu menu = new Menu();

        menu.setCreateBy( dto.getCreateBy() );
        menu.setCreateTime( dto.getCreateTime() );
        menu.setUpdateTime( dto.getUpdateTime() );
        menu.setId( dto.getId() );
        menu.setPid( dto.getPid() );
        menu.setSubCount( dto.getSubCount() );
        menu.setType( dto.getType() );
        menu.setTitle( dto.getTitle() );
        menu.setName( dto.getName() );
        menu.setComponent( dto.getComponent() );
        menu.setMenuSort( dto.getMenuSort() );
        menu.setIcon( dto.getIcon() );
        menu.setPath( dto.getPath() );
        menu.setIFrame( dto.getIFrame() );
        menu.setCache( dto.getCache() );
        menu.setHidden( dto.getHidden() );
        menu.setPermission( dto.getPermission() );

        return menu;
    }

    @Override
    public MenuDTO toDto(Menu entity) {
        if ( entity == null ) {
            return null;
        }

        MenuDTO menuDTO = new MenuDTO();

        menuDTO.setCreateBy( entity.getCreateBy() );
        menuDTO.setCreateTime( entity.getCreateTime() );
        menuDTO.setUpdateTime( entity.getUpdateTime() );
        menuDTO.setId( entity.getId() );
        menuDTO.setType( entity.getType() );
        menuDTO.setPermission( entity.getPermission() );
        menuDTO.setTitle( entity.getTitle() );
        menuDTO.setMenuSort( entity.getMenuSort() );
        menuDTO.setPath( entity.getPath() );
        menuDTO.setComponent( entity.getComponent() );
        menuDTO.setPid( entity.getPid() );
        menuDTO.setSubCount( entity.getSubCount() );
        menuDTO.setIFrame( entity.getIFrame() );
        menuDTO.setCache( entity.getCache() );
        menuDTO.setHidden( entity.getHidden() );
        menuDTO.setName( entity.getName() );
        menuDTO.setIcon( entity.getIcon() );

        return menuDTO;
    }

    @Override
    public List<Menu> toEntity(List<MenuDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Menu> list = new ArrayList<Menu>( dtoList.size() );
        for ( MenuDTO menuDTO : dtoList ) {
            list.add( toEntity( menuDTO ) );
        }

        return list;
    }

    @Override
    public List<MenuDTO> toDto(List<Menu> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<MenuDTO> list = new ArrayList<MenuDTO>( entityList.size() );
        for ( Menu menu : entityList ) {
            list.add( toDto( menu ) );
        }

        return list;
    }
}
