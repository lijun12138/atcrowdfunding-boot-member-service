package com.atguigu.atcrowdfunding.member.service;

import java.util.List;
import java.util.Map;

import com.atguigu.atcrowdfunding.common.bean.Cert;
import com.atguigu.atcrowdfunding.common.bean.Member;
import com.atguigu.atcrowdfunding.common.bean.MemberCert;
import com.atguigu.atcrowdfunding.common.bean.Ticket;

public interface MemberService {

	Member queryByLoginacct(String loginacct);

	Ticket queryTicket(Map<String,Object> param);

	void insertTicket(Ticket ticket);

	void update(Member member);

	void updateTicket(Ticket ticket);

	List<Cert> queryCert(String accttype);

	void insertMemberCert(List<MemberCert> mcs);

	void deleteMemberCert(MemberCert memberCert);

	List<MemberCert> queryMemberCert(Integer id);

	Member queryMember(Integer memberid);

	Member queryMemberByParam(Map<String, Object> map);
	
	boolean reg(Member member);

	boolean check(String loginacct);

}
