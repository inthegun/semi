package project.semi.domain.user.request;

import io.micrometer.common.util.StringUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import project.semi.domain.user.Gender;
import project.semi.domain.user.User;

@Getter
@NoArgsConstructor
public class UserRequest {
    private String name; // 이름
    private String email; // e-mail
    private String password;
    private String birthday;
    private Gender gender;

    public void encodingPassword(PasswordEncoder passwordEncoder){
        if(StringUtils.isEmpty(password)){
            return;
        }
        password = passwordEncoder.encode(password);
    }

    public User toEntity(){
        return User.builder()
                .birthday(birthday)
                .email(email)
                .gender(gender)
                .name(name)
                .password(password)
                .build();
    }

}
