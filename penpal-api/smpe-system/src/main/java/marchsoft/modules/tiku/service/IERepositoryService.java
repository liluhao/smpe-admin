package marchsoft.modules.tiku.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import marchsoft.base.PageVO;
import marchsoft.modules.tiku.entity.Dto.Repository.AddRepositoryDto;
import marchsoft.modules.tiku.entity.Dto.Repository.RepositoryQueryCriteria;
import marchsoft.modules.tiku.entity.ERepository;
import marchsoft.base.IBasicService;
import marchsoft.modules.tiku.entity.vo.RepositoryVO;

import java.util.Set;

public interface IERepositoryService extends IBasicService<ERepository> {

    IPage<RepositoryVO> selectRepository(RepositoryQueryCriteria criteria, PageVO pageVO);

    void addRepository(AddRepositoryDto repository);

    void updateRepository(ERepository eRepository);

    void delete(Set<Long> ids);

}
