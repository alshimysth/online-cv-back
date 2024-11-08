package com.example.online_cv_server.api.projects;

import java.util.List;

import com.example.online_cv_server.NotFoundException;
import com.example.online_cv_server.entities.Projects;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class ProjectsService {

    private final ProjectsRepository projectsRepository;

    public ProjectsService(final ProjectsRepository projectsRepository) {
        this.projectsRepository = projectsRepository;
    }

    public List<ProjectsModel> findAll() {
        final List<Projects> projectses = projectsRepository.findAll(Sort.by("id"));
        return projectses.stream()
                .map(projects -> mapToModel(projects, new ProjectsModel()))
                .toList();
    }

    public ProjectsModel get(final Integer id) {
        return projectsRepository.findById(id)
                .map(projects -> mapToModel(projects, new ProjectsModel()))
                .orElseThrow(NotFoundException::new);
    }

    public Integer create(final ProjectsModel projectsModel) {
        final Projects projects = new Projects();
        mapToEntity(projectsModel, projects);
        return projectsRepository.save(projects).getId();
    }

    public void update(final Integer id, final ProjectsModel projectsModel) {
        final Projects projects = projectsRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(projectsModel, projects);
        projectsRepository.save(projects);
    }

    public void delete(final Integer id) {
        projectsRepository.deleteById(id);
    }

    private ProjectsModel mapToModel(final Projects projects, final ProjectsModel projectsModel) {
        projectsModel.setId(projects.getId());
        projectsModel.setProjectName(projects.getProjectName());
        projectsModel.setDescription(projects.getDescription());
        projectsModel.setTechnologiesUsed(projects.getTechnologiesUsed());
        projectsModel.setStartDate(projects.getStartDate());
        projectsModel.setEndDate(projects.getEndDate());
        projectsModel.setLink(projects.getLink());
        return projectsModel;
    }

    private Projects mapToEntity(final ProjectsModel projectsModel, final Projects projects) {
        projects.setProjectName(projectsModel.getProjectName());
        projects.setDescription(projectsModel.getDescription());
        projects.setTechnologiesUsed(projectsModel.getTechnologiesUsed());
        projects.setStartDate(projectsModel.getStartDate());
        projects.setEndDate(projectsModel.getEndDate());
        projects.setLink(projectsModel.getLink());
        return projects;
    }

}
