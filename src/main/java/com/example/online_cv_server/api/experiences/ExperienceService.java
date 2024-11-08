package com.example.online_cv_server.api.experiences;

import java.util.List;

import com.example.online_cv_server.NotFoundException;
import com.example.online_cv_server.entities.Experience;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class ExperienceService {

    private final ExperienceRepository experienceRepository;

    public ExperienceService(final ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    public List<ExperienceModel> findAll() {
        final List<Experience> experiences = experienceRepository.findAll(Sort.by("id"));
        return experiences.stream()
                .map(experience -> mapToModel(experience, new ExperienceModel()))
                .toList();
    }

    public ExperienceModel get(final Integer id) {
        return experienceRepository.findById(id)
                .map(experience -> mapToModel(experience, new ExperienceModel()))
                .orElseThrow(NotFoundException::new);
    }

    public Integer create(final ExperienceModel experienceModel) {
        final Experience experience = new Experience();
        mapToEntity(experienceModel, experience);
        return experienceRepository.save(experience).getId();
    }

    public void update(final Integer id, final ExperienceModel experienceModel) {
        final Experience experience = experienceRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(experienceModel, experience);
        experienceRepository.save(experience);
    }

    public void delete(final Integer id) {
        experienceRepository.deleteById(id);
    }

    private ExperienceModel mapToModel(final Experience experience, final ExperienceModel experienceModel) {
        experienceModel.setId(experience.getId());
        experienceModel.setJobTitle(experience.getJobTitle());
        experienceModel.setCompanyName(experience.getCompanyName());
        experienceModel.setStartDate(experience.getStartDate());
        experienceModel.setEndDate(experience.getEndDate());
        experienceModel.setLocation(experience.getLocation());
        experienceModel.setDescription(experience.getDescription());
        return experienceModel;
    }

    private Experience mapToEntity(final ExperienceModel experienceModel, final Experience experience) {
        experience.setJobTitle(experienceModel.getJobTitle());
        experience.setCompanyName(experienceModel.getCompanyName());
        experience.setStartDate(experienceModel.getStartDate());
        experience.setEndDate(experienceModel.getEndDate());
        experience.setLocation(experienceModel.getLocation());
        experience.setDescription(experienceModel.getDescription());
        return experience;
    }

}
