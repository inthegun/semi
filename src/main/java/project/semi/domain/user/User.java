package project.semi.domain.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String name;
    private String password;
    private Gender gender;
    private String birthday;

    @Builder
    public User( String email, String name, String password, Gender gender, String birthday) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.birthday = birthday;
    }
}
