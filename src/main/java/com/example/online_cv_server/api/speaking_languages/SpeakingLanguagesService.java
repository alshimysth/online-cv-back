package com.example.online_cv_server.api.speaking_languages;

import java.util.List;

import com.example.online_cv_server.NotFoundException;
import com.example.online_cv_server.entities.SpeakingLanguages;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class SpeakingLanguagesService {

    private final SpeakingLanguagesRepository speakingLanguagesRepository;

    public SpeakingLanguagesService(final SpeakingLanguagesRepository speakingLanguagesRepository) {
        this.speakingLanguagesRepository = speakingLanguagesRepository;
    }

    public List<SpeakingLanguagesModel> findAll() {
        final List<SpeakingLanguages> speakingLanguageses = speakingLanguagesRepository.findAll(Sort.by("id"));
        return speakingLanguageses.stream()
                .map(speakingLanguages -> mapToModel(speakingLanguages, new SpeakingLanguagesModel()))
                .toList();
    }

    public SpeakingLanguagesModel get(final Integer id) {
        return speakingLanguagesRepository.findById(id)
                .map(speakingLanguages -> mapToModel(speakingLanguages, new SpeakingLanguagesModel()))
                .orElseThrow(NotFoundException::new);
    }

    public Integer create(final SpeakingLanguagesModel speakingLanguagesModel) {
        final SpeakingLanguages speakingLanguages = new SpeakingLanguages();
        mapToEntity(speakingLanguagesModel, speakingLanguages);
        return speakingLanguagesRepository.save(speakingLanguages).getId();
    }

    public void update(final Integer id, final SpeakingLanguagesModel speakingLanguagesModel) {
        final SpeakingLanguages speakingLanguages = speakingLanguagesRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(speakingLanguagesModel, speakingLanguages);
        speakingLanguagesRepository.save(speakingLanguages);
    }

    public void delete(final Integer id) {
        speakingLanguagesRepository.deleteById(id);
    }

    private SpeakingLanguagesModel mapToModel(final SpeakingLanguages speakingLanguages,
            final SpeakingLanguagesModel speakingLanguagesModel) {
        speakingLanguagesModel.setId(speakingLanguages.getId());
        speakingLanguagesModel.setLanguageName(speakingLanguages.getLanguageName());
        speakingLanguagesModel.setProficiencyLevel(speakingLanguages.getProficiencyLevel());
        return speakingLanguagesModel;
    }

    private SpeakingLanguages mapToEntity(final SpeakingLanguagesModel speakingLanguagesModel,
            final SpeakingLanguages speakingLanguages) {
        speakingLanguages.setLanguageName(speakingLanguagesModel.getLanguageName());
        speakingLanguages.setProficiencyLevel(speakingLanguagesModel.getProficiencyLevel());
        return speakingLanguages;
    }

}
