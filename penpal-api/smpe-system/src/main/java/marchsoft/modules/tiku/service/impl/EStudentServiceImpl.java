package marchsoft.modules.tiku.service.impl;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.RequiredArgsConstructor;
import marchsoft.base.PageVO;
import marchsoft.enums.ResultEnum;
import marchsoft.exception.BadRequestException;
import marchsoft.modules.tiku.entity.Dto.SafeCase.SafeCaseQueryCriteria;
import marchsoft.modules.tiku.entity.Dto.Student.AddStudentDto;
import marchsoft.modules.tiku.entity.Dto.Student.StudentDto;
import marchsoft.modules.tiku.entity.Dto.Student.StudentQueryCriteria;
import marchsoft.modules.tiku.entity.ESafeCase;
import marchsoft.modules.tiku.entity.EStudent;
import marchsoft.modules.tiku.entity.vo.SafeCaseVO;
import marchsoft.modules.tiku.entity.vo.StudentVO;
import marchsoft.modules.tiku.mapper.EStudentMapper;
import marchsoft.modules.tiku.service.IEStudentService;
import marchsoft.base.BasicServiceImpl;
import marchsoft.modules.tiku.service.mapstruct.StudentMapStruct;
import marchsoft.utils.FileUtils;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * <p>
 * 学生基本信息表 服务实现类
 * </p>
 *
 * @author m
 * @since 2022-03-29
 */
@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = "student")
public class EStudentServiceImpl extends BasicServiceImpl<EStudentMapper, EStudent> implements IEStudentService {

    private final EStudentMapper eStudentMapper;
    private final StudentMapStruct studentMapStruct;


    @Override
    @CacheEvict(key = "'name'",allEntries = true)
    public void insert(AddStudentDto studentDto) {
        LambdaQueryWrapper<EStudent> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(EStudent::getStudentNum,studentDto.getStudentNum());
        EStudent student = this.getOne(queryWrapper);
        if (ObjectUtil.isNotNull(student)){
            // 根据排序字段查询已有的数据库，能得到一条数据，表示前端传过来的不符合要求
            throw new BadRequestException(ResultEnum.STUDENTNUM_IS_EXIST);
        }
        EStudent student1 = studentMapStruct.addDtoToEntity(studentDto);
        int i = eStudentMapper.insert(student1);
        if (i<1){
            throw new BadRequestException(ResultEnum.INSERT_OPERATION_FAIL);
        }
    }

    @Override
    @CacheEvict(key = "'name'",allEntries = true)
    public void update(EStudent student) {
        if (ObjectUtil.isNull(student.getId())) {
            throw new BadRequestException(ResultEnum.BAD_REQUEST);
        }
        EStudent byId = this.getById(student.getId());
        if (!byId.getStudentNum().equals(student.getStudentNum())) {
            //当学号被修改时
            // 判断字段是否重复
            LambdaQueryWrapper<EStudent> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(EStudent::getStudentNum,student.getStudentNum());
            EStudent type = this.getOne(queryWrapper);
            if (ObjectUtil.isNotNull(type)) {
                // 根据排序字段查询已有的数据库，能得到一条数据，表示前端传过来的不符合要求
                throw new BadRequestException(ResultEnum.STUDENTNUM_IS_EXIST);
            }
        }

        eStudentMapper.updateById(student);
    }

    @Override
    @CacheEvict(key = "'name'",allEntries = true)
    public void delete(Set<Long> ids) {
        eStudentMapper.deleteBatchIds(ids);
    }

    @Override
    public Long findStudentIdByStudentNumAndDeptId(String username, Long deptId) {
        LambdaQueryWrapper<EStudent> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(EStudent::getStudentNum,username).eq(EStudent::getUniversityId,deptId);
        EStudent eStudent = this.getOne(queryWrapper);
        if (ObjectUtil.isNull(eStudent)){
            throw new BadRequestException(ResultEnum.USER_NOT_EXIST);
        }
        return eStudent.getId();
    }

    @Override
//    @Cacheable(key = "'name:'+ #criteria.name + #pageVO.size + #pageVO.current + #pageVO.orders")
    public IPage<StudentVO> selectStudent(StudentQueryCriteria criteria, PageVO pageVO) {
//        QueryWrapper<EStudent> query = buildEStudentCriteria(criteria);
//        LambdaQueryWrapper<EStudent> lambda = query.lambda();
//        if (StrUtil.isNotBlank(criteria.getName())) {
//            lambda.like(EStudent::getName,criteria.getName());
//        }
        QueryWrapper<EStudent> query = new QueryWrapper<>();
        IPage<StudentVO> studentVOIPage = queryAll(criteria, pageVO);
        return studentVOIPage;
    }

    @Override
    public void download(List<StudentDto> studentDtos, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (StudentDto studentDto : studentDtos) {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("名字", studentDto.getName());
            map.put("学号",studentDto.getStudentNum());
            map.put("身份证号",studentDto.getIdCard());
//            map.put("部门状态", studentDto.getEnabled() ? "启用" : "停用");
            map.put("创建日期", ObjectUtil.isNull(studentDto.getCreateTime()) ? null :
                    LocalDateTimeUtil.format(studentDto.getCreateTime()
                            , DatePattern.NORM_DATETIME_FORMATTER));
            list.add(map);
        }
        FileUtils.downloadExcel(list, response);
    }

    @Override
    public List<StudentDto> queryAll(StudentQueryCriteria criteria, Boolean isQuery) {
        List<EStudent> students = this.eStudentMapper.selectList(analysisQueryCriteria(criteria));
        return studentMapStruct.toDto(students);
    }

    @Override
    public LambdaQueryWrapper<EStudent> analysisQueryCriteria(StudentQueryCriteria criteria) {
        LambdaQueryWrapper<EStudent> wrapper = new LambdaQueryWrapper<>();

        if (StrUtil.isNotBlank(criteria.getName())) {
            // 默认使用Like匹配
            wrapper.like(EStudent::getName, criteria.getName());
        }

        return wrapper;
    }

    private QueryWrapper<EStudent> buildEStudentCriteria(StudentQueryCriteria criteria) {
        QueryWrapper<EStudent> query = new QueryWrapper<>();
        LambdaQueryWrapper<EStudent> lambda = query.lambda();

        if (ObjectUtil.isNotNull(criteria.getId())) {
            lambda.eq(EStudent::getId,criteria.getId());
        }

        if (ObjectUtil.isNotNull(criteria.getUniversityId())) {
            lambda.eq(EStudent::getUniversityId,criteria.getUniversityId());
        }

//        if (StrUtil.isNotBlank(criteria.getName())) {
//            lambda.like(EStudent::getName, criteria.getName());
//        }
        if (ObjectUtil.isNotNull(criteria.getName())){
            query.like("sd.name",criteria.getName());
        }

        if (ObjectUtil.isNotNull(criteria.getAdmissionNum())) {
            lambda.like(EStudent::getAdmissionNum, criteria.getAdmissionNum());
        }

        if (ObjectUtil.isNotNull(criteria.getIdCard())) {
            lambda.like(EStudent::getIdCard, criteria.getIdCard());
        }

        if (ObjectUtil.isNotNull(criteria.getStudentNum())) {
            lambda.like(EStudent::getStudentNum, criteria.getStudentNum());
        }

        if (ObjectUtil.isNotNull(criteria.getUniversityId())) {
            lambda.eq(EStudent::getUniversityId, criteria.getUniversityId());
        }

        if (ObjectUtil.isNotNull(criteria.getCollege())) {
            lambda.like(EStudent::getCollege, criteria.getCollege());
        }
        if (ObjectUtil.isNotNull(criteria.getEnrollmentYear())){
            lambda.like(EStudent::getEnrollmentYear,criteria.getEnrollmentYear());
        }

        //todo 入学年度查找
        query.eq("sd.is_deleted",false);
        return query;
    }

    public IPage<StudentVO> queryAll(StudentQueryCriteria criteria, PageVO pageVO) {
        QueryWrapper<EStudent> query = buildEStudentCriteria(criteria);

        return eStudentMapper.selectStudentPage(pageVO.buildPage(),query);
    }

}


