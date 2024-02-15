package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService{

	
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	@Inject
	private MemberDAO mdao;

	@Override
	public void joinMember(MemberVO vo) {
		mdao.insertMember(vo);
	}

	@Override
	public MemberVO loginMember(MemberVO vo) {
		
		return mdao.loginMember(vo);
	}

	@Override
	public MemberVO getMember(String id) {
		
		return mdao.getMember(id);
	}

	@Override
	public int updateMember(MemberVO vo) {
		
		return mdao.updateMember(vo);
	}

	@Override
	public int deleteMember(MemberVO vo) {
		
		return mdao.deleteMember(vo);
	}

	@Override
	public List<MemberVO> memberList() {
		
		return mdao.memberList();
	}
	
	
	
	
}
