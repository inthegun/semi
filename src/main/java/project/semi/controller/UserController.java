package project.semi.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import project.semi.domain.user.request.UserRequest;
import project.semi.domain.user.response.UserResponse;
import project.semi.service.UserService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    /**
     * 회원가입
     * @param user
     * @return
     */
    @PostMapping("/join")
    public Long joinUser(@RequestBody UserRequest user){
        return userService.joinUser(user);
    }

    /**
     * 로그인
     * @param userRequest
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/login")
    public UserResponse login(@RequestBody UserRequest userRequest, HttpServletRequest request,
                              HttpServletResponse response){

        UserResponse user = userService.login(userRequest);
        // Cookie 및 Session
        if(user != null){
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            return user;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
