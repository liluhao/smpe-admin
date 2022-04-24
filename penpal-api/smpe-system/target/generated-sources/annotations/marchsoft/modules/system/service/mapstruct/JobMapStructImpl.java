package marchsoft.modules.system.service.mapstruct;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import marchsoft.modules.system.entity.Job;
import marchsoft.modules.system.entity.dto.JobDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-19T10:15:38+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_161 (Oracle Corporation)"
)
@Component
public class JobMapStructImpl implements JobMapStruct {

    @Override
    public Job toEntity(JobDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Job job = new Job();

        job.setCreateBy( dto.getCreateBy() );
        job.setCreateTime( dto.getCreateTime() );
        job.setUpdateTime( dto.getUpdateTime() );
        job.setId( dto.getId() );
        job.setName( dto.getName() );
        job.setEnabled( dto.getEnabled() );
        job.setJobSort( dto.getJobSort() );

        return job;
    }

    @Override
    public JobDTO toDto(Job entity) {
        if ( entity == null ) {
            return null;
        }

        JobDTO jobDTO = new JobDTO();

        jobDTO.setCreateBy( entity.getCreateBy() );
        jobDTO.setCreateTime( entity.getCreateTime() );
        jobDTO.setUpdateTime( entity.getUpdateTime() );
        jobDTO.setId( entity.getId() );
        jobDTO.setJobSort( entity.getJobSort() );
        jobDTO.setName( entity.getName() );
        jobDTO.setEnabled( entity.getEnabled() );

        return jobDTO;
    }

    @Override
    public List<Job> toEntity(List<JobDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Job> list = new ArrayList<Job>( dtoList.size() );
        for ( JobDTO jobDTO : dtoList ) {
            list.add( toEntity( jobDTO ) );
        }

        return list;
    }

    @Override
    public List<JobDTO> toDto(List<Job> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<JobDTO> list = new ArrayList<JobDTO>( entityList.size() );
        for ( Job job : entityList ) {
            list.add( toDto( job ) );
        }

        return list;
    }
}
