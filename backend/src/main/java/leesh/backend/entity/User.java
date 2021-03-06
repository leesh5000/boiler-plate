package leesh.backend.entity;

import leesh.backend.dto.UserDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "username", unique = true, length = 20)
    private String username;

    @Column(name = "password")
    private String password;

    @Builder
    private User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    //== 생성 매서드 ==//
    public static User createUser(String username, String password) {
        return User.builder()
                .username(username)
                .password(password)
                .build();
    }

    //== 연관관계 매서드 ==//

    //== toDto ==//
    public UserDto toDto() {
        return UserDto.builder()
                .id(this.getId())
                .username(this.getUsername())
                .build();
    }
}
