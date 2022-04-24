package marchsoft.modules.tiku.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import marchsoft.base.PageVO;
import marchsoft.modules.tiku.entity.Dto.PracticeRecordQueryCriteria;
import marchsoft.modules.tiku.entity.EPracticeRecord;
import marchsoft.base.IBasicService;

/**
 * <p>
 * 题库练习记录 服务类
 * </p>
 *
 * @author m
 * @since 2022-03-29
 */
public interface IEPracticeRecordService extends IBasicService<EPracticeRecord> {
    
    
    /* 
    * @Description: 分页获取练习记录 
    * @Param: [criteria, pageVO] 
    * @returns: com.baomidou.mybatisplus.core.metadata.IPage<marchsoft.modules.tiku.entity.EPracticeRecord> 
    * @Author: m 
    * @Date: 2022/4/13 15:49
    */
    IPage<EPracticeRecord> selectPracticeRecord(PracticeRecordQueryCriteria criteria, PageVO pageVO);

}
