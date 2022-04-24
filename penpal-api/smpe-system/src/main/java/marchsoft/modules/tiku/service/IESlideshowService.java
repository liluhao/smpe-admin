package marchsoft.modules.tiku.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import marchsoft.modules.tiku.entity.ESlideshow;
import marchsoft.base.IBasicService;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 轮播图 服务类
 * </p>
 *
 * @author m
 * @since 2022-03-29
 */
public interface IESlideshowService extends IBasicService<ESlideshow> {

    /* 
    * @Description: 获取全部轮播图 
    * @Param: [] 
    * @returns: java.util.List<marchsoft.modules.tiku.entity.ESlideshow> 
    * @Author: m 
    * @Date: 2022/3/31 11:00
    */
    List<ESlideshow> getAllSlide();

    /* 
    * @Description:  根据条件获取轮播图
    * @Param: [page] 
    * @returns: com.baomidou.mybatisplus.core.metadata.IPage<marchsoft.modules.tiku.entity.ESlideshow> 
    * @Author: m 
    * @Date: 2022/3/31 11:00
    */
    IPage<ESlideshow> getAll(IPage<ESlideshow> page);

    /* 
    * @Description: 新增轮播图
    * @Param: [eSlideshow] 
    * @returns: void 
    * @Author: m 
    * @Date: 2022/3/31 11:02
    */
    void addSlideshow(ESlideshow eSlideshow);

    /* 
    * @Description: 修改轮播图
    * @Param: [eSlideshow] 
    * @returns: void 
    * @Author: m 
    * @Date: 2022/3/31 11:02
    */
    void updateSlideshow(ESlideshow eSlideshow);

    /* 
    * @Description: 删除轮播图
    * @Param: [ids] 
    * @returns: void 
    * @Author: m 
    * @Date: 2022/3/31 11:02
    */
    void deleteSlideshow(Set<Long> ids);

}
