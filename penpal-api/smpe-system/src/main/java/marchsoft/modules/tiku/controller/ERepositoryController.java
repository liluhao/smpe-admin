package marchsoft.modules.tiku.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import marchsoft.annotation.rest.AnonymousGetMapping;
import marchsoft.base.PageVO;
import marchsoft.modules.tiku.entity.Dto.Repository.AddRepositoryDto;
import marchsoft.modules.tiku.entity.Dto.Repository.RepositoryQueryCriteria;
import marchsoft.modules.tiku.entity.vo.RepositoryVO;
import marchsoft.response.Result;
import marchsoft.utils.SecurityUtils;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

import marchsoft.modules.tiku.service.IERepositoryService;
import marchsoft.modules.tiku.entity.ERepository;

import java.util.Set;


/**
* <p>
* 题库 前端控制器
* </p>
* @author m
* @since 2022-03-29
*/
@RequiredArgsConstructor
@RestController
@Slf4j
@Api(tags = "题库模块")
@RequestMapping("/api/eRepository")
public class ERepositoryController {
    private final IERepositoryService eRepositoryService;

    @ApiOperation("分页条件获取题库")
    @AnonymousGetMapping
    public Result<IPage<RepositoryVO>> getAll(RepositoryQueryCriteria criteria, PageVO pageVO) {
        IPage<RepositoryVO> page = eRepositoryService.selectRepository(criteria,pageVO);
        return Result.success(page);
    }

    @ApiOperation("新增题库")
    @PostMapping
    public Result<Object> add(@RequestBody AddRepositoryDto repository) {
        eRepositoryService.addRepository(repository);
        return Result.success();
    }

    @ApiOperation("修改题库")
    @PutMapping
    public Result<Object> edit(@RequestBody ERepository eRepository){
        log.info("【修改题库 /api/eRepository】操作人id：{}，被修改题库id：{}", SecurityUtils.getCurrentUserId(),
                eRepository.getId());
        eRepositoryService.updateRepository(eRepository);
        return Result.success();
    }

    @ApiOperation("删除题库")
    @DeleteMapping
    public Result<Object> del(@RequestBody Set<Long> ids){
        log.info("【删除题库 /api/eRepository】操作人id：{}，被删除题库id：{}", SecurityUtils.getCurrentUserId(),
                ids);
        eRepositoryService.delete(ids);
        return Result.success();
    }
}
