package com.itwillbs.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Inject
	private SqlSession sqlSession;
	
	
	private static final Logger logger = LoggerFactory.getLogger(MemberDAOImpl.class);
	
	
	private final static String NAMESPACE = "com.itwillbs.mapper.MemberMapper";

	// 회원가입
	@Override
	public void insertMember(MemberVO vo) {
		sqlSession.insert(NAMESPACE+".insertMember", vo);
	}

	// 로그인
	@Override
	public MemberVO loginMember(MemberVO vo) {
		MemberVO resultVO = sqlSession.selectOne(NAMESPACE+".loginMember",vo);
		
		return resultVO;
	}

	// 특정 회원 정보 조회
	@Override
	public MemberVO getMember(String id) {
		MemberVO resultVO = sqlSession.selectOne(NAMESPACE+"getMember",id);
		return resultVO;
	}

	// 회원 수정
	@Override
	public int updateMember(MemberVO vo) {
		return sqlSession.update(NAMESPACE+".updateMember",vo);
	}

	// 회원 탈퇴
	@Override
	public int deleteMember(MemberVO vo) {
		return sqlSession.delete(NAMESPACE+".deleteMember",vo);	
	}

	// 회원 목록 조회
	@Override
	public List<MemberVO> memberList() {
		
		return sqlSession.selectList(NAMESPACE+".getMemberList");
	}
	
	
}
