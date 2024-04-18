package the.member.MemberShip.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import the.member.MemberShip.controller.form.MemberForm;
import the.member.MemberShip.dto.MemberDto;
import the.member.MemberShip.entity.Member;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member,String> {

    @Query("select new the.member.memberShip.dto.MemberDto(m.loginId, m.password, m.nickname, m.name, m.tell, m.email)" +
            " from Member m" +
            " order by m.createDate, m.name ")
    List<MemberDto> findAllDto(Pageable pageable);

    @Query("select new the.member.memberShip.dto.MemberDto(m.loginId, m.password, m.nickname, m.name, m.tell, m.email)" +
            " from Member m" +
            " where m.loginId = :id")
    MemberDto findOneDto(String id);

    @Modifying
    @Query("update Member m set " +
            "m.loginId = form.loginId, " +
            "m.password = form.password, " +
            "m.nickname = form.nickname, " +
            "m.name = form.name, " +
            "m.tell = form.tell, " +
            "m.email = form.email " +
            "where m.id = :memberId")
    void updateMember(String memberId, MemberForm form);
}
