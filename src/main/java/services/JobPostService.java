package services;

import DTO.JobPostDTO;
import entity.JobPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.JobPostRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobPostService {
    @Autowired
    private JobPostRepository jobPostRepository;

    public JobPostDTO postJob(JobPostDTO dto) {
        JobPost jobPost = new JobPost(
                dto.id,
                dto.jobTitle,
                dto.jobType,dto.
                jobDescription,dto.jobLocation,
                dto.companyName,
                dto.postedByEmail,
                dto.postedDate);

        JobPost saved =jobPostRepository.save(jobPost);
        return mapToDTO(saved);
    }

    public List<JobPostDTO>getByPostedByEmail(String email){
        return jobPostRepository.findByPostedByEmail(email).stream().map(this::mapToDTO).collect(Collectors.toList());
    }
    public List<JobPostDTO>getByJobTitle(String jobTitle){
        return jobPostRepository.findByJobTitle(jobTitle).stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public List<JobPostDTO>getByJobType(String jobType){
        return jobPostRepository.findByJobType(jobType).stream().map(this::mapToDTO).collect(Collectors.toList());
    }
    public List<JobPostDTO> getByCompanyName(String companyName){
        return jobPostRepository.findByCompanyName(companyName).stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    private JobPostDTO mapToDTO(JobPost jobPost) {
        return new JobPostDTO(
                jobPost.getId(),
                jobPost.getJobTitle(),
                jobPost.getJobType(),
                jobPost.getJobDescription(),
                jobPost.getJobLocation(),
                jobPost.getCompanyName(),
                jobPost.getPostedByemail(),
                jobPost.getPostedDate()
        );
    }


}
