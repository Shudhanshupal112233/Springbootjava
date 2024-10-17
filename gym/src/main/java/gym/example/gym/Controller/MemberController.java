package gym.example.gym.Controller;

import gym.example.gym.Models.Member;
import gym.example.gym.Services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("member")
@RestController
public class MemberController {
    @Autowired
    MemberService memberService;

    @PostMapping("/add")
    public String addStudent(@RequestBody Member member) {

        String result = memberService.addmember(member);
        return result;
    }

    @DeleteMapping("/delete")
    public void deletemember(@RequestParam int memberId){
        memberService.deletemember(memberId);
    }



}
