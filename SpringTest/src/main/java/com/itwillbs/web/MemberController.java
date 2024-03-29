package com.itwillbs.web;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.service.MemberService;

@Controller
@RequestMapping("/member/")
public class MemberController {

	@Inject
	private MemberService mService;
	
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	// http://localhost:8088/member/join
	// 회원가입 
	@GetMapping("join")
	public void joinGET() {
		
	}
	
	@PostMapping("join")
	public String joinPOST(MemberVO vo, RedirectAttributes rttr) {
		mService.joinMember(vo);
		
		rttr.addFlashAttribute("msg","회원가입이 완료되었습니다.");
		return "redirect:/member/login";
	}
	
	// 로그인
	@GetMapping("login")
	public void loginGET() {
		
	}
	
	@PostMapping("login")
	public String loginPOST(MemberVO vo, HttpSession session, RedirectAttributes rttr) {
		MemberVO resultVO = mService.loginMember(vo);
		
		String addr = ""; 
		if(resultVO == null) {
			rttr.addFlashAttribute("msg","아이디나 비밀번호가 맞지 않습니다.");
			addr = "/member/login";
		}
		if(resultVO != null) {
			session.setAttribute("id", resultVO.getUserid());
			addr = "/member/main";
		}
		return "redirect:"+addr;
	}
	
	// 메인
	@GetMapping("main")
	public void mainGET() {
		
	}
	
	// 로그아웃
	@GetMapping("logout")
	public String logoutGET(HttpSession session, RedirectAttributes rttr) {
		session.invalidate();
		
		rttr.addFlashAttribute("msg","로그아웃 되었습니다.");
		
		return "redirect:/member/login";
	}
	
	// 회원 정보 조회
	@GetMapping("info")
	public void memberInfoGET(HttpSession session, Model model) {
		String id = (String)session.getAttribute("id");
		MemberVO resultVO = mService.getMember(id);
		model.addAttribute("member", resultVO);
	}
	
	// 회원 정보 수정
	@GetMapping("update")
	public void updateGET(HttpSession session, Model model) {
		String id = (String)session.getAttribute("id");
		MemberVO resultVO = mService.getMember(id);
		model.addAttribute("member", resultVO);
	}
	
	@PostMapping("update")
	public String updatePOST(MemberVO vo, RedirectAttributes rttr) {
		String addr = "";
		
		int result = mService.updateMember(vo);
		if(result == 1) {
			rttr.addFlashAttribute("msg", "회원수정이 완료되었습니다.");
			addr="/member/main";
		}
		if(result != 1) {
			rttr.addFlashAttribute("msg","비밀번호가 잘못되었습니다.");
			addr="/member/update";
		}
	
		return "redirect:"+addr;
	}
	
	// 회원 탈퇴
	@GetMapping("delete")
	public void deleteGET() {
		
	}
	
	@PostMapping("delete")
	public String deletePOST(MemberVO vo, RedirectAttributes rttr) {
		String addr = "";
		int result = mService.deleteMember(vo);
		if(result == 1) {
			rttr.addFlashAttribute("msg", "회원 탈퇴가 완료되었습니다.");
			addr = "/member/login";
		}
		if(result != 1) {
			rttr.addFlashAttribute("msg", "비밀번호가 잘못되었습니다.");
			addr = "/member/delete";
		}
		return "redirect:"+addr;
	}
	
	// 회원 목록
	@GetMapping("list")
	public String listGET(HttpSession session, Model model) {
		String id = (String)session.getAttribute("id");
		String addr = "";
		if(!id.equals("admin")) {
			addr = "redirect:/member/main";
		}
		if(id.equals("admin")) {
			model.addAttribute("list", mService.memberList());
			addr = "/member/list";
		}
		return addr;
	}
	
}
