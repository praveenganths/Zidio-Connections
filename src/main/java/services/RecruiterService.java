package services;


import DTO.RecruiterDTO;
import entity.Recruiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.RecruiterRepository;

import java.util.Optional;

@Service
public class RecruiterService {

    @Autowired
    private RecruiterRepository recruiterRepository;


    public RecruiterDTO createRecruiter(RecruiterDTO dto) {
        Recruiter recruiter = new Recruiter(dto.id,dto.name,dto.email,dto.phone,dto.companyName,dto.companyDescription,dto.companyWebsite);
        recruiter=recruiterRepository.save(recruiter);
        return new RecruiterDTO(
                recruiter.getId(),
                recruiter.getName(),
                recruiter.getEmail(),
                recruiter.getPhone(),
                recruiter.getCompanyName(),
                recruiter.getCompanydescription(),
                recruiter.getCompantWebsite());
    }

    public RecruiterDTO getRecruiterByEmail(String email) {
        Recruiter recruiter = recruiterRepository.findByEmail(email);
        if(recruiter == null)return null;
        return new RecruiterDTO(
                recruiter.getId(),
                recruiter.getName(),
                recruiter.getEmail(),
                recruiter.getPhone(),
                recruiter.getCompanyName(),
                recruiter.getCompanydescription(),
                recruiter.getCompantWebsite());
    }

    public RecruiterDTO getRecruiterById(Long id) {
        Optional<Recruiter> optionalRecruiter = recruiterRepository.findById(id);
        if(!optionalRecruiter.isPresent())return null;
        Recruiter recruiter =new Recruiter();
        return new RecruiterDTO(recruiter.getId(),
                recruiter.getName(),
                recruiter.getEmail(),
                recruiter.getPhone(),
                recruiter.getCompanyName(),
                recruiter.getCompanydescription(),
                recruiter.getCompantWebsite());

    }

}
