package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.MemberVO;

public interface MemberService {

	// 회원가입
	public void joinMember(MemberVO vo);
	
	// 로그인
	public MemberVO loginMember(MemberVO vo);
	
	// 특정 회원 정보 조회
	public MemberVO getMember(String id);
	
	// 회원 정보 수정
	public int updateMember(MemberVO vo);
	
	// 회원 탈퇴
	public int deleteMember(MemberVO vo);	
	
	// 회원 목록 
	public List<MemberVO> memberList();
}
