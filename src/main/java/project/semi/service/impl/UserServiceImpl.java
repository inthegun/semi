package project.semi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import project.semi.domain.user.User;
import project.semi.domain.user.request.UserRequest;
import project.semi.domain.user.response.UserResponse;
import project.semi.repo.UserRepository;
import project.semi.service.UserService;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Long joinUser(UserRequest user) {
        user.encodingPassword(passwordEncoder);
        return userRepository.save(user.toEntity()).getId();
    }

    /**
     * 로그인
     * @param userRequest
     * @return
     */
    @Override
    public UserResponse login(UserRequest userRequest) {
        User user = findByEmail(userRequest.getEmail());
        String encodePassword = user.getPassword();
        if( !passwordEncoder.matches(userRequest.getPassword(), encodePassword)){
            return null;
        }
        user.clearPassword();
        return new UserResponse(user);
    }

    /**
     * Email 로 사용자 찾음
     * @param email
     * @return
     */
    @Override
    public User findByEmail(String email) {
        User entity = userRepository.findByEmail(email).orElseThrow( () ->
            new IllegalArgumentException("사용자 없음 ")
        );
        return entity;
    }


}
