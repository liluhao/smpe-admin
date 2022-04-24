package marchsoft.modules.tiku.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import marchsoft.modules.tiku.entity.Dto.TypeStatusDto;
import marchsoft.modules.tiku.entity.ESafeType;
import marchsoft.base.BasicMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

/**
* <p>
* 安全类别 Mapper 接口
* </p>
*
* @author m
* @since 2022-03-29
*/
@Component
public interface ESafeTypeMapper extends BasicMapper<ESafeType> {

    @Insert("UPDATE e_safe_type SET is_show = #{isShow} WHERE id = #{safeTypeId}")
    int updateShow(TypeStatusDto typeStatusDto);

}
