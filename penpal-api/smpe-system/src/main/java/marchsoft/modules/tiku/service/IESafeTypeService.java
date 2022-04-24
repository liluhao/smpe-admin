package marchsoft.modules.tiku.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import marchsoft.base.PageVO;
import marchsoft.modules.tiku.entity.Dto.SafeType.AddSafeTypeDto;
import marchsoft.modules.tiku.entity.Dto.SafeType.ESafeTypeDto;
import marchsoft.modules.tiku.entity.Dto.SafeType.SafeTypeQueryCriteria;
import marchsoft.modules.tiku.entity.Dto.TypeStatusDto;
import marchsoft.modules.tiku.entity.ESafeType;
import marchsoft.base.IBasicService;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 安全类别 服务类
 * </p>
 *
 * @author m
 * @since 2022-03-29
 */
public interface IESafeTypeService extends IBasicService<ESafeType> {

    /* 
    * @Description: 获取当前状态为显示的分类名称 
    * @Param: [] 
    * @returns: java.util.List<marchsoft.modules.tiku.entity.Dto.SafeType.ESafeTypeDto>
    * @Author: m 
    * @Date: 2022/4/1 16:48
    */
    List<ESafeTypeDto> queryAllName();

    /*
    * @Description: 新增安全分类
    * @Param: [eSafeType]
    * @returns: void
    * @Author: m
    * @Date: 2022/4/11 17:16
    */
    void insert(AddSafeTypeDto eSafeType);

    /*
    * @Description: 修改安全分类
    * @Param: [safeType]
    * @returns: void
    * @Author: m
    * @Date: 2022/4/11 17:16
    */
    void updateSafeType(ESafeType safeType);

    /*
    * @Description: 修改安全分类显示状态
    * @Param: [typeStatusDto]
    * @returns: void
    * @Author: m
    * @Date: 2022/4/11 17:16
    */
    void updateShow(TypeStatusDto typeStatusDto);

    /*
    * @Description: 删除安全分类
    * @Param: [ids]
    * @returns: void
    * @Author: m
    * @Date: 2022/4/11 17:17
    */
    void delete(Set<Long> ids);

    /* 
    * @Description: 分页查询安全分类
    * @Param: [criteria, pageVO] 
    * @returns: com.baomidou.mybatisplus.core.metadata.IPage<marchsoft.modules.tiku.entity.ESafeType> 
    * @Author: m 
    * @Date: 2022/4/11 17:21
    */
    IPage<ESafeType> selectSafeType(SafeTypeQueryCriteria criteria, PageVO pageVO);


}
