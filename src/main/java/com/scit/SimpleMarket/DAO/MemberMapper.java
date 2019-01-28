package com.scit.SimpleMarket.DAO;

import java.util.ArrayList;

import com.scit.SimpleMarket.VO.Member;

public interface MemberMapper {
	public Member loginAdmin(Member member); // 관리자 로그인
	public int insertMemeber(Member member); // 사용자 회원가입
	public Member loginMember(Member memeber); // 사용자 로그인
	public ArrayList<Member> selectCustomerList(); // 회원목록 출력
}
