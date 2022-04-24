package marchsoft.modules.system.service.mapstruct;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;
import marchsoft.modules.system.entity.Dept;
import marchsoft.modules.system.entity.Job;
import marchsoft.modules.system.entity.Role;
import marchsoft.modules.system.entity.bo.UserBO;
import marchsoft.modules.system.entity.dto.DeptSmallDTO;
import marchsoft.modules.system.entity.dto.JobSmallDTO;
import marchsoft.modules.system.entity.dto.RoleSmallDTO;
import marchsoft.modules.system.entity.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-19T10:15:37+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_161 (Oracle Corporation)"
)
@Component
public class UserMapStructImpl implements UserMapStruct {

    @Autowired
    private RoleMapStruct roleMapStruct;
    @Autowired
    private DeptMapStruct deptMapStruct;
    @Autowired
    private JobMapStruct jobMapStruct;

    @Override
    public UserBO toEntity(UserDTO dto) {
        if ( dto == null ) {
            return null;
        }

        UserBO userBO = new UserBO();

        userBO.setCreateBy( dto.getCreateBy() );
        userBO.setCreateTime( dto.getCreateTime() );
        userBO.setUpdateTime( dto.getUpdateTime() );
        userBO.setId( dto.getId() );
        userBO.setDeptId( dto.getDeptId() );
        userBO.setUsername( dto.getUsername() );
        userBO.setNickName( dto.getNickName() );
        userBO.setGender( dto.getGender() );
        userBO.setPhone( dto.getPhone() );
        userBO.setEmail( dto.getEmail() );
        userBO.setAvatarPath( dto.getAvatarPath() );
        userBO.setPassword( dto.getPassword() );
        userBO.setIsAdmin( dto.getIsAdmin() );
        userBO.setEnabled( dto.getEnabled() );
        userBO.setPwdResetTime( dto.getPwdResetTime() );
        userBO.setDept( deptSmallDTOToDept( dto.getDept() ) );
        userBO.setRoles( roleSmallDTOSetToRoleSet( dto.getRoles() ) );
        userBO.setJobs( jobSmallDTOSetToJobSet( dto.getJobs() ) );

        return userBO;
    }

    @Override
    public UserDTO toDto(UserBO entity) {
        if ( entity == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setCreateBy( entity.getCreateBy() );
        userDTO.setCreateTime( entity.getCreateTime() );
        userDTO.setUpdateTime( entity.getUpdateTime() );
        userDTO.setId( entity.getId() );
        userDTO.setRoles( roleSetToRoleSmallDTOSet( entity.getRoles() ) );
        userDTO.setJobs( jobSetToJobSmallDTOSet( entity.getJobs() ) );
        userDTO.setDept( deptToDeptSmallDTO( entity.getDept() ) );
        userDTO.setDeptId( entity.getDeptId() );
        userDTO.setUsername( entity.getUsername() );
        userDTO.setNickName( entity.getNickName() );
        userDTO.setEmail( entity.getEmail() );
        userDTO.setPhone( entity.getPhone() );
        userDTO.setGender( entity.getGender() );
        userDTO.setAvatarPath( entity.getAvatarPath() );
        userDTO.setPassword( entity.getPassword() );
        userDTO.setEnabled( entity.getEnabled() );
        userDTO.setIsAdmin( entity.getIsAdmin() );
        userDTO.setPwdResetTime( entity.getPwdResetTime() );

        return userDTO;
    }

    @Override
    public List<UserBO> toEntity(List<UserDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<UserBO> list = new ArrayList<UserBO>( dtoList.size() );
        for ( UserDTO userDTO : dtoList ) {
            list.add( toEntity( userDTO ) );
        }

        return list;
    }

    @Override
    public List<UserDTO> toDto(List<UserBO> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( entityList.size() );
        for ( UserBO userBO : entityList ) {
            list.add( toDto( userBO ) );
        }

        return list;
    }

    protected Dept deptSmallDTOToDept(DeptSmallDTO deptSmallDTO) {
        if ( deptSmallDTO == null ) {
            return null;
        }

        Dept dept = new Dept();

        dept.setId( deptSmallDTO.getId() );
        dept.setName( deptSmallDTO.getName() );

        return dept;
    }

    protected Role roleSmallDTOToRole(RoleSmallDTO roleSmallDTO) {
        if ( roleSmallDTO == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( roleSmallDTO.getId() );
        role.setName( roleSmallDTO.getName() );
        role.setLevel( roleSmallDTO.getLevel() );
        role.setDataScope( roleSmallDTO.getDataScope() );

        return role;
    }

    protected Set<Role> roleSmallDTOSetToRoleSet(Set<RoleSmallDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<Role> set1 = new HashSet<Role>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( RoleSmallDTO roleSmallDTO : set ) {
            set1.add( roleSmallDTOToRole( roleSmallDTO ) );
        }

        return set1;
    }

    protected Job jobSmallDTOToJob(JobSmallDTO jobSmallDTO) {
        if ( jobSmallDTO == null ) {
            return null;
        }

        Job job = new Job();

        job.setId( jobSmallDTO.getId() );
        job.setName( jobSmallDTO.getName() );

        return job;
    }

    protected Set<Job> jobSmallDTOSetToJobSet(Set<JobSmallDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<Job> set1 = new HashSet<Job>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( JobSmallDTO jobSmallDTO : set ) {
            set1.add( jobSmallDTOToJob( jobSmallDTO ) );
        }

        return set1;
    }

    protected RoleSmallDTO roleToRoleSmallDTO(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleSmallDTO roleSmallDTO = new RoleSmallDTO();

        roleSmallDTO.setId( role.getId() );
        roleSmallDTO.setName( role.getName() );
        roleSmallDTO.setLevel( role.getLevel() );
        roleSmallDTO.setDataScope( role.getDataScope() );

        return roleSmallDTO;
    }

    protected Set<RoleSmallDTO> roleSetToRoleSmallDTOSet(Set<Role> set) {
        if ( set == null ) {
            return null;
        }

        Set<RoleSmallDTO> set1 = new HashSet<RoleSmallDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Role role : set ) {
            set1.add( roleToRoleSmallDTO( role ) );
        }

        return set1;
    }

    protected JobSmallDTO jobToJobSmallDTO(Job job) {
        if ( job == null ) {
            return null;
        }

        JobSmallDTO jobSmallDTO = new JobSmallDTO();

        jobSmallDTO.setId( job.getId() );
        jobSmallDTO.setName( job.getName() );

        return jobSmallDTO;
    }

    protected Set<JobSmallDTO> jobSetToJobSmallDTOSet(Set<Job> set) {
        if ( set == null ) {
            return null;
        }

        Set<JobSmallDTO> set1 = new HashSet<JobSmallDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Job job : set ) {
            set1.add( jobToJobSmallDTO( job ) );
        }

        return set1;
    }

    protected DeptSmallDTO deptToDeptSmallDTO(Dept dept) {
        if ( dept == null ) {
            return null;
        }

        DeptSmallDTO deptSmallDTO = new DeptSmallDTO();

        deptSmallDTO.setId( dept.getId() );
        deptSmallDTO.setName( dept.getName() );

        return deptSmallDTO;
    }
}
