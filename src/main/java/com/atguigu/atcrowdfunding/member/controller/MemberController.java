package com.atguigu.atcrowdfunding.member.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.atcrowdfunding.common.bean.Cert;
import com.atguigu.atcrowdfunding.common.bean.Member;
import com.atguigu.atcrowdfunding.common.bean.MemberCert;
import com.atguigu.atcrowdfunding.common.bean.Ticket;
import com.atguigu.atcrowdfunding.member.service.MemberService;

@RestController
public class MemberController {

	@Autowired
	private MemberService memberService;

	@RequestMapping("member/queryMember")
	Member queryMember(@RequestBody Integer memberid) {
		return memberService.queryMember(memberid);
	}

	@RequestMapping("member/queryMemberCert")
	public List<MemberCert> queryMemberCert(@RequestBody Integer id) {
		return memberService.queryMemberCert(id);
	}

	@RequestMapping("member/insertMemberCert")
	public void insertMemberCert(@RequestBody List<MemberCert> mcs) {
		// 在插入资质图片钱要删除掉之前上传过的图片
		memberService.deleteMemberCert(mcs.get(0));
		memberService.insertMemberCert(mcs);
	}

	@RequestMapping("member/queryCert")
	public List<Cert> queryCert(@RequestBody String accttype) {
		return memberService.queryCert(accttype);
	}

	@RequestMapping("member/updateTicket")
	public void updateTicket(@RequestBody Ticket ticket) {
		memberService.updateTicket(ticket);
	}

	@RequestMapping("member/update")
	public void update(@RequestBody Member member) {
		memberService.update(member);
	}

	@RequestMapping("login/{loginacct}")
	public Member login(@PathVariable("loginacct") String loginacct) {
		Member member = memberService.queryByLoginacct(loginacct);
		return member;
	}

	@RequestMapping("member/queryTicket")
	public Ticket queryTicket(@RequestBody Map<String, Object> param) {
		return memberService.queryTicket(param);
	}

	@RequestMapping("member/insertTicket")
	public void insertTicket(@RequestBody Ticket ticket) {
		memberService.insertTicket(ticket);
	}

	@RequestMapping("member/queryMemberByParam")
	public Member queryMemberByParam(@RequestBody Map<String, Object> map) {
		return memberService.queryMemberByParam(map);
	}

	@RequestMapping("member/check")
	public boolean check(@RequestBody String loginacct) {
		return memberService.check(loginacct);
	}

	@RequestMapping("member/reg")
	public boolean reg(@RequestBody Member member) {
		return memberService.reg(member);
	}
}
