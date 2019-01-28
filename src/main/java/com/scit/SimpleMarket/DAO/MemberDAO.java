package com.scit.SimpleMarket.DAO;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.scit.SimpleMarket.VO.Member;

@Repository
public class MemberDAO {
	@Autowired
	SqlSession sqlSession;
	// 관리자 로그인
	public Member loginAdmin(Member member) {
		Member lMember = null;
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		
		try {
			lMember = mapper.loginAdmin(member);
		} catch (Exception e) {
			System.out.println("관리자 로그인 에러");
			System.out.println(member);
			System.out.println(lMember);
			e.printStackTrace();
		}
		return lMember;
	}
	// 사용자 회원가입
	public int insertMember(Member member) {
		int result = 0;
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		try {
			result = mapper.insertMemeber(member);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("회원가입 에러");
		}
		return result;
	}
	// 사용자 로그인
	public Member loginMember(Member member) {
		Member lMember = null;
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		try {
			lMember = mapper.loginMember(member);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("사용자 로그인 에러");
		}
		return lMember;
	}
	// 회원목록 출력
	public ArrayList<Member> selectCustomerList(){
		ArrayList<Member> list = null;
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		try {
			list = mapper.selectCustomerList();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("회원목록 출력 에러");
		}
		return list;
	}
}//end
