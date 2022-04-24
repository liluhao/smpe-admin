package marchsoft.modules.tiku.controller;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import marchsoft.annotation.rest.AnonymousGetMapping;
import marchsoft.base.PageVO;
import marchsoft.enums.ResultEnum;
import marchsoft.exception.BadRequestException;
import marchsoft.response.Result;
import marchsoft.utils.SecurityUtils;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

import marchsoft.modules.tiku.service.IESlideshowService;
import marchsoft.modules.tiku.entity.ESlideshow;

import java.util.Set;


/**
* <p>
* 轮播图 前端控制器
* </p>
* @author m
* @since 2022-03-29
*/
@RequiredArgsConstructor
@RestController
@Slf4j
@Api(tags = "轮播图模块")
@RequestMapping("/api/eSlideshow")
public class ESlideshowController {
    private final IESlideshowService eSlideshowService;

    @ApiOperation("获取全部的轮播图")
    @GetMapping("/test")
    public Result<Object> test() {
        Long userId = SecurityUtils.getCurrentUserId();
        return Result.success(userId);
    }

    @ApiOperation("根据条件获取轮播图")
    @AnonymousGetMapping("/all")
    public Result<Object> getAll(PageVO pageVO){
        IPage<ESlideshow> all = eSlideshowService.getAll(pageVO.buildPage());
        return Result.success(all);
    }

    @ApiOperation("新增轮播图")
    @PostMapping
    public Result<Object> addSlideshow(@RequestBody ESlideshow eSlideshow) {
        eSlideshowService.addSlideshow(eSlideshow);
        return Result.success();
    }

    @ApiOperation("修改轮播图")
    @PutMapping
    public Result<Object> updateSlideShow(@RequestBody ESlideshow eSlideshow) {
        log.info("【修改轮播图 /api/eSlideshow】操作人id:{},被修改轮播图id:{}", SecurityUtils.getCurrentUserId(),eSlideshow.getId());
        eSlideshowService.updateSlideshow(eSlideshow);
        return Result.success();
    }

    @ApiOperation("删除轮播图")
    @DeleteMapping
    public Result<Object> deleteSlideShow(@RequestBody Set<Long> ids) {
        if (CollectionUtil.isEmpty(ids)){
            log.error(StrUtil.format("【删除轮播图失败】轮播图id不能为空。操作人id:{},删除轮播图id:{}",SecurityUtils.getCurrentUserId(), ids));
            throw new BadRequestException(ResultEnum.PARAM_IS_BLANK);
        }
        eSlideshowService.deleteSlideshow(ids);
        return Result.success();
    }
}
