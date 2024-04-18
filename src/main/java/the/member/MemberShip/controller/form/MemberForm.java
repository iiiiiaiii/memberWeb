package the.member.MemberShip.controller.form;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberForm {
    private String loginId;
    private String password;
    private String nickname;
    private String name;
    private String tell;
    private String email;

    public MemberForm(String loginId, String password, String nickName, String name, String tell, String email) {
        this.loginId = loginId;
        this.password = password;
        this.nickname = nickName;
        this.name = name;
        this.tell = tell;
        this.email = email;
    }
}
