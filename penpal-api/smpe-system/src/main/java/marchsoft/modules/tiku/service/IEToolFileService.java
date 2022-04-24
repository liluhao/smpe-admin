package marchsoft.modules.tiku.service;

import marchsoft.modules.tiku.entity.EToolFile;
import marchsoft.base.IBasicService;
import marchsoft.modules.tiku.entity.vo.FileMessage;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 本地存储 服务类
 * </p>
 *
 * @author m
 * @since 2022-03-29
 */

public interface IEToolFileService extends IBasicService<EToolFile> {

    /*
    * @Description: 更新文件
    * @Param: [file]
    * @returns: marchsoft.modules.tiku.entity.vo.FileMessage
    * @Author: m
    * @Date: 2022/4/13 15:48
    */
    FileMessage upload(MultipartFile file);
}