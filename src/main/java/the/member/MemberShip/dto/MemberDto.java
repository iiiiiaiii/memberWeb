package the.member.MemberShip.dto;

import lombok.Getter;

@Getter
public class MemberDto {
    private String loginId;
    private String password;
    private String nickname;
    private String name;
    private String tell;
    private String email;

    protected MemberDto() {

    }

    public MemberDto(String loginId, String password, String nickname, String name, String tell, String email) {
        this.loginId = loginId;
        this.password = password;
        this.nickname = nickname;
        this.name = name;
        this.tell = tell;
        this.email = email;
    }
}
