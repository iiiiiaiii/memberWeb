package the.member.MemberShip.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import the.member.MemberShip.controller.form.MemberForm;
import the.member.MemberShip.dto.MemberDto;
import the.member.MemberShip.entity.Member;
import the.member.MemberShip.service.MemberService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/api/user/join")
    public ResponseEntity<String> memberJoin(MemberForm form) {
        memberService.save(form);
        return ResponseEntity.status(HttpStatus.CREATED).body("Member created successfully");
    }

    @GetMapping("/api/user/list")
    public String memberList(Model model, @RequestParam(defaultValue = "5") int page,
                             @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<MemberDto> allDto = memberService.findAllDto(pageable);
        model.addAttribute("allDto", allDto);
        return "memberList";
    }

    @PostMapping("/api/user/{loginId}")
    public String updateMember(@PathVariable("loginId") String loginId,
                               MemberForm memberForm,
                               Model model) {
        MemberDto memberDto = memberService.update(loginId, memberForm);
        model.addAttribute("memberDto", memberDto);
        return "memberInfo";
    }
}
