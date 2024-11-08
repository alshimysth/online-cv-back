package com.example.online_cv_server.api.skills;

import java.util.List;

import com.example.online_cv_server.NotFoundException;
import com.example.online_cv_server.entities.Skills;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class SkillsService {

    private final SkillsRepository skillsRepository;

    public SkillsService(final SkillsRepository skillsRepository) {
        this.skillsRepository = skillsRepository;
    }

    public List<SkillsModel> findAll() {
        final List<Skills> skillses = skillsRepository.findAll(Sort.by("id"));
        return skillses.stream()
                .map(skills -> mapToModel(skills, new SkillsModel()))
                .toList();
    }

    public SkillsModel get(final Integer id) {
        return skillsRepository.findById(id)
                .map(skills -> mapToModel(skills, new SkillsModel()))
                .orElseThrow(NotFoundException::new);
    }

    public Integer create(final SkillsModel skillsModel) {
        final Skills skills = new Skills();
        mapToEntity(skillsModel, skills);
        return skillsRepository.save(skills).getId();
    }

    public void update(final Integer id, final SkillsModel skillsModel) {
        final Skills skills = skillsRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(skillsModel, skills);
        skillsRepository.save(skills);
    }

    public void delete(final Integer id) {
        skillsRepository.deleteById(id);
    }

    private SkillsModel mapToModel(final Skills skills, final SkillsModel skillsModel) {
        skillsModel.setId(skills.getId());
        skillsModel.setSkillName(skills.getSkillName());
        skillsModel.setCategory(skills.getCategory());
        skillsModel.setProficiencyLevel(skills.getProficiencyLevel());
        return skillsModel;
    }

    private Skills mapToEntity(final SkillsModel skillsModel, final Skills skills) {
        skills.setSkillName(skillsModel.getSkillName());
        skills.setCategory(skillsModel.getCategory());
        skills.setProficiencyLevel(skillsModel.getProficiencyLevel());
        return skills;
    }

}
