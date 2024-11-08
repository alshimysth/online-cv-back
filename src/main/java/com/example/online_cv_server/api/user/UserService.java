package com.example.online_cv_server.api.user;

import java.util.List;

import com.example.online_cv_server.NotFoundException;
import com.example.online_cv_server.entities.User;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserModel> findAll() {
        final List<User> users = userRepository.findAll(Sort.by("id"));
        return users.stream()
                .map(user -> mapToModel(user, new UserModel()))
                .toList();
    }

    public UserModel get(final Integer id) {
        return userRepository.findById(id)
                .map(user -> mapToModel(user, new UserModel()))
                .orElseThrow(NotFoundException::new);
    }

    public Integer create(final UserModel userModel) {
        final User user = new User();
        mapToEntity(userModel, user);
        return userRepository.save(user).getId();
    }

    public void update(final Integer id, final UserModel userModel) {
        final User user = userRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(userModel, user);
        userRepository.save(user);
    }

    public void delete(final Integer id) {
        userRepository.deleteById(id);
    }

    private UserModel mapToModel(final User user, final UserModel userModel) {
        userModel.setId(user.getId());
        userModel.setFirstName(user.getFirstName());
        userModel.setLastName(user.getLastName());
        userModel.setEmail(user.getEmail());
        userModel.setPhone(user.getPhone());
        userModel.setAddress(user.getAddress());
        userModel.setLinkedin(user.getLinkedin());
        userModel.setGithub(user.getGithub());
        userModel.setSummary(user.getSummary());
        userModel.setProfilePicture(user.getProfilePicture());
        return userModel;
    }

    private User mapToEntity(final UserModel userModel, final User user) {
        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLastName());
        user.setEmail(userModel.getEmail());
        user.setPhone(userModel.getPhone());
        user.setAddress(userModel.getAddress());
        user.setLinkedin(userModel.getLinkedin());
        user.setGithub(userModel.getGithub());
        user.setSummary(userModel.getSummary());
        user.setProfilePicture(userModel.getProfilePicture());
        return user;
    }

}
