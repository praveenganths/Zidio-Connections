package repository;

import entity.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobPostRepository extends JpaRepository<JobPost,Long> {
    List<JobPost> findByPostedByEmail(String email);
    List<JobPost>findByJobTitle(String jobTitle);
    List<JobPost>findByJobType(String jobType);
    List<JobPost>findByCompanyName(String companyName);

}
