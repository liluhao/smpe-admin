package marchsoft.modules.tiku.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import marchsoft.annotation.rest.AnonymousGetMapping;
import marchsoft.annotation.rest.AnonymousPostMapping;
import marchsoft.base.PageVO;
import marchsoft.modules.tiku.entity.Dto.Student.AddStudentDto;
import marchsoft.modules.tiku.entity.Dto.Student.StudentQueryCriteria;
import marchsoft.modules.tiku.entity.vo.StudentVO;
import marchsoft.modules.upload.service.FileService;
import marchsoft.response.Result;
import marchsoft.utils.FileUtils;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

import marchsoft.modules.tiku.service.IEStudentService;
import marchsoft.modules.tiku.entity.EStudent;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Set;


/**
 * <p>
 * 学生基本信息表 前端控制器
 * </p>
 * @author m
 * @since 2022-03-29
 */
@RequiredArgsConstructor
@RestController
@Slf4j
@Api(tags = "学生基本信息表模块")
@RequestMapping("/api/eStudent")
public class EStudentController {
    private final IEStudentService eStudentService;
    private final FileService fileService;

    @ApiOperation("分页条件获取学生基本信息")
    @AnonymousGetMapping
    public Result<Object> getAll(StudentQueryCriteria criteria,PageVO pageVO){
        IPage<StudentVO> all = eStudentService.selectStudent(criteria,pageVO);
        return Result.success(all);
    }

    @ApiOperation("新增安全分类")
    @PostMapping
    public Result<Object> addSafeType(@RequestBody @Valid AddStudentDto eStudent){
        eStudentService.insert(eStudent);
        return Result.success();
    }

    @ApiOperation(value = "更新分类信息",notes = "changxitong")
    @PutMapping
    public Result<Object> update(@RequestBody EStudent student) {
        eStudentService.update(student);
        return Result.success();
    }

    @ApiOperation(value = "删除分类信息，允许批量删除",notes = "changxitong")
    @DeleteMapping
    public Result<Object> del(@RequestBody Set<Long> ids) {
        eStudentService.delete(ids);
        return Result.success();
    }

    /*
     * @Description: 直接调用FileController.downloadFile方法导出文件
     * @Param:  [request, response]
     * @returns:  ResponseEntity<Resource>
     * @Author: m
     * @Date: 2022/4/15 9:11
     */
//    @ApiOperation("导出信息模板")
//    @AnonymousGetMapping("/download-template")
//    public ResponseEntity<Resource> downloadLoanExcel(HttpServletRequest request, HttpServletResponse response) {
//        // 这儿直接调用的是FileController中的方法。
//        // 模板名称是后端写死的值
//        return fileController.downloadFile("template.xlsx",request,response);
//    }

    /*
     * @Description:  调用FileService.loadFileAsResource方法导出文件
     * @Param: [request, response]
     * @returns: org.springframework.http.ResponseEntity<org.springframework.core.io.Resource>
     * @Author: m
     * @Date: 2022/4/15 9:12
     */
//   也可以调用Service层中的方法
//    @ApiOperation("导出信息模板")
//    @AnonymousGetMapping("/download-template")
//    public ResponseEntity<Resource> downloadLoanExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        // 调用fileService层方法 模板是后端写死的值
//        Resource resource = fileService.loadFileAsResource("template.xlsx");
//        // 导出文件的名字重命名为template1.xlsx
//        FileUtils.downloadFile(request,response,resource.getFile(),"template1.xlsx",false);
//        // 第四个参数表示传给前端显示的名称
//        return null;
//    }
//
//    @ApiOperation("导出信息模板")
//    @AnonymousGetMapping("/download")
//    public ResponseEntity<Resource> download(HttpServletResponse response, StudentQueryCriteria criteria) throws IOException {
//        eStudentService.download(eStudentService.queryAll(criteria,false),response);
//        return null;
//    }
//
//    @AnonymousPostMapping("/upload")
//    @ResponseBody
//    public Result<Object> importLoad(@RequestPart MultipartFile file) throws Exception {
//        // easyExcel解析
//        EasyExcel.read(file.getInputStream(), StudentExcel.class,new StudentDataListener()).sheet().doRead();
//
//        return Result.success();
//    }

}
