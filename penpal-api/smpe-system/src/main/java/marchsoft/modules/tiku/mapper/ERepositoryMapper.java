package marchsoft.modules.tiku.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import marchsoft.modules.tiku.entity.ERepository;
import marchsoft.base.BasicMapper;
import marchsoft.modules.tiku.entity.vo.RepositoryVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface ERepositoryMapper extends BasicMapper<ERepository> {

    @Select("SELECT r.id, r.safe_type_id, r.ques_type, r.ques_content, r.options, r.answer, " +
            "r.is_check, r.create_time, r.update_time, r.create_by, r.update_time, r.is_deleted, " +
            "NAME AS safe_name " +
            "FROM  e_repository r " +
            "LEFT JOIN e_safe_type s " +
            "ON r.safe_type_id = s.id " +
//            "AND r.is_deleted = 0 " +
            "${ew.customSqlSegment} " )
    IPage<RepositoryVO> selectRepositoryPage(IPage<Object> buildPage, @Param(Constants.WRAPPER) QueryWrapper<Object> query,@Param(Constants.WRAPPER) LambdaQueryWrapper<ERepository> criteria);

}
