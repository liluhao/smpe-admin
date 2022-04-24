package marchsoft.modules.tiku.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import marchsoft.annotation.rest.AnonymousGetMapping;
import marchsoft.base.PageVO;
import marchsoft.modules.tiku.entity.Dto.SafeCase.AddSafeCaseDto;
import marchsoft.modules.tiku.entity.Dto.SafeCase.SafeCaseQueryCriteria;
import marchsoft.modules.tiku.entity.ESafeCase;
import marchsoft.modules.tiku.entity.vo.SafeCaseVO;
import marchsoft.response.Result;
import marchsoft.utils.SecurityUtils;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

import marchsoft.modules.tiku.service.IESafeCaseService;

import javax.validation.Valid;
import java.util.Set;

@RequiredArgsConstructor
@RestController
@Slf4j
@Api(tags = "安全案例模块")
@RequestMapping("/api/eSafeCase")
public class ESafeCaseController {
    private final IESafeCaseService eSafeCaseService;

    @ApiOperation("分页条件获取安全案例数据")
    @AnonymousGetMapping
    public Result<IPage<SafeCaseVO>> getAll(SafeCaseQueryCriteria criteria, PageVO pageVO) {

        log.info("【分页查询安全案例 /api/eSafeCase】操作人id：{}，安全类型：{}", SecurityUtils.getCurrentUserId(),
                criteria.getSafeTypeId());
        IPage<SafeCaseVO> page = eSafeCaseService.selectSafeCase(criteria,pageVO);
        return Result.success(page);
    }

    @ApiOperation(value = "新增安全案例信息")
    @PostMapping
    public Result<Object> insert(@RequestBody @Valid AddSafeCaseDto safeCase) {
        log.info("【新增安全案例 /api/eSafeCase】操作人id：{} 新增了一条安全案例", SecurityUtils.getCurrentUserId());
        eSafeCaseService.insert(safeCase);
        return Result.success();
    }

    @ApiOperation(value = "修改安全案例信息")
    @PutMapping
    public Result<Object> update(@RequestBody ESafeCase safeCase) {
        log.info("【修改安全案例 /api/eSafeCase】操作人id：{}，被修改的安全案例id：{}", SecurityUtils.getCurrentUserId(),
                safeCase.getId());
        eSafeCaseService.updateSafeCase(safeCase);
        return Result.success();
    }


    @ApiOperation(value = "删除安全案例信息，允许批量删除")
    @DeleteMapping
    public Result<Object> del(@RequestBody Set<Long> ids) {
        log.info("【删除安全案例 /api/eSafeCase】操作人id：{}，被删除安全案例id：{}", SecurityUtils.getCurrentUserId(),
                ids);
        eSafeCaseService.del(ids);
        return Result.success();
    }
}