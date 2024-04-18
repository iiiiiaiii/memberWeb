package the.member.MemberShip.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Member extends BaseEntity {
    @GeneratedValue
    private Long memberNumber;

    @Id
    @Column(name="member_id")
    private String loginId;
    private String password;
    private String nickname;
    private String name;
    private String tell;
    private String email;

    public Member(String loginId, String password, String nickname, String name, String tell, String email) {
        this.loginId = loginId;
        this.password = password;
        this.nickname = nickname;
        this.name = name;
        this.tell = tell;
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
