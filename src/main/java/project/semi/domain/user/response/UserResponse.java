package project.semi.domain.user.response;

import lombok.Getter;
import project.semi.domain.user.Gender;
import project.semi.domain.user.User;

@Getter
public class UserResponse {
    private Long id;
    private String name;
    private String email;
    private String birthday;
    private Gender gender;
    private String password;

    public UserResponse(User entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.birthday = entity.getBirthday();
        this.gender = entity.getGender();
        this.password = entity.getPassword();
    }

}
