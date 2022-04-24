package marchsoft.modules.system.service.mapstruct;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import marchsoft.modules.system.entity.Job;
import marchsoft.modules.system.entity.dto.JobSmallDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-19T10:15:38+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_161 (Oracle Corporation)"
)
@Component
public class JobSmallMapStructImpl implements JobSmallMapStruct {

    @Override
    public Job toEntity(JobSmallDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Job job = new Job();

        job.setId( dto.getId() );
        job.setName( dto.getName() );

        return job;
    }

    @Override
    public JobSmallDTO toDto(Job entity) {
        if ( entity == null ) {
            return null;
        }

        JobSmallDTO jobSmallDTO = new JobSmallDTO();

        jobSmallDTO.setId( entity.getId() );
        jobSmallDTO.setName( entity.getName() );

        return jobSmallDTO;
    }

    @Override
    public List<Job> toEntity(List<JobSmallDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Job> list = new ArrayList<Job>( dtoList.size() );
        for ( JobSmallDTO jobSmallDTO : dtoList ) {
            list.add( toEntity( jobSmallDTO ) );
        }

        return list;
    }

    @Override
    public List<JobSmallDTO> toDto(List<Job> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<JobSmallDTO> list = new ArrayList<JobSmallDTO>( entityList.size() );
        for ( Job job : entityList ) {
            list.add( toDto( job ) );
        }

        return list;
    }
}
