package com.example.online_cv_server.api.educations;

import java.util.List;

import com.example.online_cv_server.NotFoundException;
import com.example.online_cv_server.entities.Education;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class EducationService {

    private final EducationRepository educationRepository;

    public EducationService(final EducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }

    public List<EducationModel> findAll() {
        final List<Education> educations = educationRepository.findAll(Sort.by("id"));
        return educations.stream()
                .map(education -> mapToModel(education, new EducationModel()))
                .toList();
    }

    public EducationModel get(final Integer id) {
        return educationRepository.findById(id)
                .map(education -> mapToModel(education, new EducationModel()))
                .orElseThrow(NotFoundException::new);
    }

    public Integer create(final EducationModel educationModel) {
        final Education education = new Education();
        mapToEntity(educationModel, education);
        return educationRepository.save(education).getId();
    }

    public void update(final Integer id, final EducationModel educationModel) {
        final Education education = educationRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(educationModel, education);
        educationRepository.save(education);
    }

    public void delete(final Integer id) {
        educationRepository.deleteById(id);
    }

    private EducationModel mapToModel(final Education education, final EducationModel educationModel) {
        educationModel.setId(education.getId());
        educationModel.setInstitutionName(education.getInstitutionName());
        educationModel.setDegree(education.getDegree());
        educationModel.setFieldOfStudy(education.getFieldOfStudy());
        educationModel.setStartDate(education.getStartDate());
        educationModel.setEndDate(education.getEndDate());
        educationModel.setDescription(education.getDescription());
        return educationModel;
    }

    private Education mapToEntity(final EducationModel educationModel, final Education education) {
        education.setInstitutionName(educationModel.getInstitutionName());
        education.setDegree(educationModel.getDegree());
        education.setFieldOfStudy(educationModel.getFieldOfStudy());
        education.setStartDate(educationModel.getStartDate());
        education.setEndDate(educationModel.getEndDate());
        education.setDescription(educationModel.getDescription());
        return education;
    }

}
