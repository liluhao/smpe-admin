package marchsoft.modules.tiku.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import marchsoft.annotation.rest.AnonymousGetMapping;
import marchsoft.base.PageVO;
import marchsoft.modules.tiku.entity.Dto.StudyData.StudyDataStatusDto;
import marchsoft.modules.tiku.entity.Dto.StudyData.StudyDataQueryCriteria;
import marchsoft.modules.tiku.entity.EStudyData;
import marchsoft.modules.tiku.entity.vo.StudyDataVO;
import marchsoft.modules.tiku.mapper.EStudyDataMapper;
import marchsoft.modules.tiku.service.IEStudyDataService;
import marchsoft.response.Result;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;


/**
 * <p>
 * 学习资料表 前端控制器
 * </p>
 * @author mfei
 * @since 2022-03-29
 */
@RequiredArgsConstructor
@RestController
@Slf4j
@Api(tags = "学习资料表模块")
@RequestMapping("/api/eStudyData")
public class EStudyDataController {
    private final IEStudyDataService eStudyDataService;
    private final EStudyDataMapper eStudyDataMapper;

    @ApiOperation("分页条件获取分类数据")
    @AnonymousGetMapping
    public Result<IPage<StudyDataVO>> getAll(StudyDataQueryCriteria criteria, PageVO pageVO) {
        IPage<StudyDataVO> page = eStudyDataService.selectStudyData(criteria,pageVO);
        return Result.success(page);
    }

    @ApiOperation("获取所有的分类名称")
    @AnonymousGetMapping("/allNames")
    public Result<Object> queryAll(IPage<Object> buildPage, QueryWrapper<Object> query, LambdaQueryWrapper<EStudyData> criteria) {
        IPage<StudyDataVO> page = eStudyDataMapper.queryPage(buildPage,query,criteria);
        return Result.success(page);
    }

    @ApiOperation("新增")
    @PostMapping
    public Result<Object> addStudyData(@RequestBody EStudyData eStudyData) {
        eStudyDataService.addStudyData(eStudyData);
        return Result.success();
    }

    @ApiOperation(value = "更新是否展示字段")
    @PutMapping("/changeIntroduce")
    public Result<Object> updateData(@RequestBody @Valid StudyDataStatusDto dataStatusDto) {
        eStudyDataService.updateIntroduce(dataStatusDto);
        return Result.success();
    }

    @ApiOperation(value = "更新分类信息")
    @PutMapping
    public Result<Object> update(@RequestBody EStudyData eStudyData) {
        eStudyDataService.updateStudyData(eStudyData);
        return Result.success();
    }

    @ApiOperation(value = "删除分类信息，允许批量删除")
    @DeleteMapping
    public Result<Object> delete(@RequestBody Set<Long> ids) {
        eStudyDataService.deleteById(ids);
        return Result.success();
    }

}
