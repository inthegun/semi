package project.semi.service;

import project.semi.domain.user.request.UserRequest;
import project.semi.domain.user.response.UserResponse;

public interface UserService {

    Long joinUser(UserRequest user);

    UserResponse login(UserRequest userRequest);

    UserResponse findByEmail(String email);
}
