package com.codestates.index;


import com.codestates.member.dto.MemberDto;
import com.codestates.member.entity.Member;
import com.codestates.member.mapper.MemberMapper;
import com.codestates.member.service.MemberService;
import com.codestates.stamp.Stamp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
public class IndexController {
    private final MemberService memberService;
    private final MemberMapper mapper;

    public IndexController(MemberService memberService, MemberMapper mapper) {
        this.memberService = memberService;
        this.mapper = mapper;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "loginForm";
    }

    @GetMapping("/order")
    public String orders() {
        return "orderForm";
    }

    @PostMapping("/order")
    public String afterorder() {
        return "redirect:/v11/orders?page=1&size=10";
    }

    @GetMapping("/coffee")
    public String coffees() {
        return "coffeeForm";
    }

    @PostMapping("/login")
    public String afterlogin() {
        return "redirect:/index";
    }

    @GetMapping("/user")
    public @ResponseBody String user() {
        return "user";
    }

    @GetMapping("/admin")
    public @ResponseBody String admin() {
        return "admin";
    }

    @GetMapping("/manager")
    public @ResponseBody String manager() {
        return "manager";
    }

    @GetMapping("/join")
    public String joinForm() {
        return "joinForm";
    }

    @PostMapping("/join")
    public String join(@Valid @RequestBody MemberDto.Post requestBody) {
        Member member = mapper.memberPostToMember(requestBody);
        member.setRole("ROLE_USER");
        member.setStamp(new Stamp());
        MemberDto.Response response = mapper.memberToMemberResponse(memberService.joinMember(member));
        return "redirect:/login";
    }
}
