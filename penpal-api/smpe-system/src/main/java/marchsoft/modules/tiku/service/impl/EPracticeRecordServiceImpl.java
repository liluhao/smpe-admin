package marchsoft.modules.tiku.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.RequiredArgsConstructor;
import marchsoft.base.PageVO;
import marchsoft.modules.tiku.entity.Dto.PracticeRecordQueryCriteria;
import marchsoft.modules.tiku.entity.EPracticeRecord;
import marchsoft.modules.tiku.entity.EStudent;
import marchsoft.modules.tiku.mapper.EPracticeRecordMapper;
import marchsoft.modules.tiku.service.IEPracticeRecordService;
import marchsoft.base.BasicServiceImpl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
* <p>
* 题库练习记录 服务实现类
* </p>
*
* @author m
* @since 2022-03-29
*/
@Service
@RequiredArgsConstructor
public class EPracticeRecordServiceImpl extends BasicServiceImpl<EPracticeRecordMapper, EPracticeRecord> implements IEPracticeRecordService {

    private final EPracticeRecordMapper ePracticeRecordMapper;

    @Override
//    @Cacheable(key = "'name:'+ #criteria.name + #pageVO.size + #pageVO.current + #pageVO.orders")
    public IPage<EPracticeRecord> selectPracticeRecord(PracticeRecordQueryCriteria criteria, PageVO pageVO) {
        LambdaQueryWrapper<EPracticeRecord> queryWrapper = new LambdaQueryWrapper<>();
        if (StrUtil.isNotBlank(criteria.getName())) {
            queryWrapper.like(EPracticeRecord::getFinishQuesAnswer,criteria.getName());
        }
        IPage<EPracticeRecord> ePracticeRecordIPage = ePracticeRecordMapper.selectPage(pageVO.buildPage(), queryWrapper);
        return ePracticeRecordIPage;
    }
}

