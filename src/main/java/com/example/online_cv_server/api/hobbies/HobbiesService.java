package com.example.online_cv_server.api.hobbies;

import java.util.List;

import com.example.online_cv_server.NotFoundException;
import com.example.online_cv_server.entities.Hobbies;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class HobbiesService {

    private final HobbiesRepository hobbiesRepository;

    public HobbiesService(final HobbiesRepository hobbiesRepository) {
        this.hobbiesRepository = hobbiesRepository;
    }

    public List<HobbiesModel> findAll() {
        final List<Hobbies> hobbieses = hobbiesRepository.findAll(Sort.by("id"));
        return hobbieses.stream()
                .map(hobbies -> mapToModel(hobbies, new HobbiesModel()))
                .toList();
    }

    public HobbiesModel get(final Integer id) {
        return hobbiesRepository.findById(id)
                .map(hobbies -> mapToModel(hobbies, new HobbiesModel()))
                .orElseThrow(NotFoundException::new);
    }

    public Integer create(final HobbiesModel hobbiesModel) {
        final Hobbies hobbies = new Hobbies();
        mapToEntity(hobbiesModel, hobbies);
        return hobbiesRepository.save(hobbies).getId();
    }

    public void update(final Integer id, final HobbiesModel hobbiesModel) {
        final Hobbies hobbies = hobbiesRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(hobbiesModel, hobbies);
        hobbiesRepository.save(hobbies);
    }

    public void delete(final Integer id) {
        hobbiesRepository.deleteById(id);
    }

    private HobbiesModel mapToModel(final Hobbies hobbies, final HobbiesModel hobbiesModel) {
        hobbiesModel.setId(hobbies.getId());
        hobbiesModel.setHobbyName(hobbies.getHobbyName());
        hobbiesModel.setDescription(hobbies.getDescription());
        return hobbiesModel;
    }

    private Hobbies mapToEntity(final HobbiesModel hobbiesModel, final Hobbies hobbies) {
        hobbies.setHobbyName(hobbiesModel.getHobbyName());
        hobbies.setDescription(hobbiesModel.getDescription());
        return hobbies;
    }

}
