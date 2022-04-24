package marchsoft.modules.tiku.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import marchsoft.base.PageVO;
import marchsoft.modules.tiku.entity.Dto.StudyData.StudyDataStatusDto;
import marchsoft.modules.tiku.entity.Dto.StudyData.StudyDataQueryCriteria;
import marchsoft.modules.tiku.entity.EStudyData;
import marchsoft.base.IBasicService;
import marchsoft.modules.tiku.entity.vo.StudyDataVO;


import java.util.Set;

public interface IEStudyDataService extends IBasicService<EStudyData> {

    IPage<StudyDataVO> queryAll(StudyDataQueryCriteria criteria, PageVO pageVO);

    IPage<StudyDataVO> selectStudyData(StudyDataQueryCriteria criteria, PageVO pageVO);

    void addStudyData(EStudyData eStudyData);

    void updateStudyData(EStudyData eStudyData);

    void updateIntroduce(StudyDataStatusDto dataStatusDto);

    void deleteById(Set<Long> ids);

}
