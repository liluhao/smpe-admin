package marchsoft.modules.tiku.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import marchsoft.modules.tiku.entity.ERepository;
import marchsoft.modules.tiku.entity.ESafeCase;
import marchsoft.base.BasicMapper;
import marchsoft.modules.tiku.entity.vo.RepositoryVO;
import marchsoft.modules.tiku.entity.vo.SafeCaseVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ESafeCaseMapper extends BasicMapper<ESafeCase> {

    @Select("SELECT sc.id, title, content, safe_type, sc.pic_path, keywords, tags, dislike, page_view, sc.create_time, " +
            "NAME AS safe_name " +
            "FROM e_safe_case sc " +
            "LEFT JOIN e_safe_type st " +
            "ON sc.safe_type = st.id  " +
//            "WHERE sc.is_deleted = 0 " +
            "${ew.customSqlSegment}")
    IPage<SafeCaseVO> selectSafeCasePage(IPage<Object> buildPage,@Param(Constants.WRAPPER) QueryWrapper<ESafeCase> query);
}
