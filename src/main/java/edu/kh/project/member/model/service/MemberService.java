package edu.kh.project.member.model.service;

import edu.kh.project.member.model.dto.Member;

// Service Interface 사용 이유


// 1. 프로젝트에 규칙성을 부여하기 위해서

// 2. 클래스간의 결합도를 약화시키기 위해서 (객체 지향적 설계)

// 3. Spring AOP 사용을 위해

public interface MemberService {
	
	
	
	/** 로그인 서비스
	 * @param inputMember (email,pw)
	 * @return email, pw가 일치하는 회원 정보 또는 null;
	 */
	Member login(Member inputMember);
	
}