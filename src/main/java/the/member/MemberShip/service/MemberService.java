package the.member.MemberShip.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import the.member.MemberShip.controller.form.MemberForm;
import the.member.MemberShip.dto.MemberDto;
import the.member.MemberShip.entity.Member;
import the.member.MemberShip.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void save(MemberForm form) {
        Member newMember = new Member(form.getLoginId(),
                passwordEncoder.encode(form.getPassword()),
                form.getNickname(), form.getName(),
                form.getTell(), form.getEmail());
        memberRepository.save(newMember);
    }

    @Transactional
    public MemberDto update(String id,MemberForm memberForm) {
        memberRepository.updateMember(id,memberForm);
        return memberRepository.findOneDto(memberForm.getLoginId());
    }

    public List<MemberDto> findAllDto(Pageable pageable) {
        return memberRepository.findAllDto(pageable);
    }
}
