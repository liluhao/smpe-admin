package marchsoft.modules.tiku.service;

import com.baomidou.mybatisplus.core.metadata.IPage;

import marchsoft.base.PageVO;
import marchsoft.modules.tiku.entity.Dto.SafeCase.AddSafeCaseDto;
import marchsoft.modules.tiku.entity.Dto.SafeCase.SafeCaseQueryCriteria;
import marchsoft.modules.tiku.entity.ESafeCase;
import marchsoft.base.IBasicService;
import marchsoft.modules.tiku.entity.vo.SafeCaseVO;

import java.util.Set;

public interface IESafeCaseService extends IBasicService<ESafeCase> {

    IPage<SafeCaseVO> selectSafeCase(SafeCaseQueryCriteria criteria, PageVO pageVO);

    void insert(AddSafeCaseDto eSafeCase);

    void updateSafeCase(ESafeCase safeCase);

    void del(Set<Long> ids);

}
