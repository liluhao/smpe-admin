package marchsoft.modules.tiku.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import marchsoft.annotation.rest.AnonymousGetMapping;
import marchsoft.base.PageVO;
import marchsoft.modules.tiku.entity.Dto.PracticeRecordQueryCriteria;
import marchsoft.response.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

import marchsoft.modules.tiku.service.IEPracticeRecordService;
import marchsoft.modules.tiku.entity.EPracticeRecord;


/**
* <p>
* 题库练习记录 前端控制器
* </p>
* @author m
* @since 2022-03-29
*/
@RequiredArgsConstructor
@RestController
@Slf4j
@Api(tags = "题库练习记录模块")
@RequestMapping("/api/ePracticeRecord")
public class EPracticeRecordController {
    private final IEPracticeRecordService ePracticeRecordService;

    @ApiOperation("分页条件获取题库练习记录")
    @AnonymousGetMapping
    public Result<Object> getAll(PracticeRecordQueryCriteria criteria, PageVO pageVO){
        IPage<EPracticeRecord> all = ePracticeRecordService.selectPracticeRecord(criteria,pageVO);
        return Result.success(all);
    }

}
