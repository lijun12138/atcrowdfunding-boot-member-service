package com.atguigu.atcrowdfunding.member.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.atcrowdfunding.common.bean.Cert;
import com.atguigu.atcrowdfunding.common.bean.Member;
import com.atguigu.atcrowdfunding.common.bean.MemberCert;
import com.atguigu.atcrowdfunding.common.bean.Ticket;
import com.atguigu.atcrowdfunding.common.util.MD5Util;
import com.atguigu.atcrowdfunding.member.dao.MemberDao;
import com.atguigu.atcrowdfunding.member.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;
	
	@Override
	public Member queryByLoginacct(String loginacct) {
		return memberDao.queryByLoginacct(loginacct);
	}

	@Override
	public Ticket queryTicket(Map<String,Object> param) {
		return memberDao.queryTicket(param);
	}

	@Override
	public void insertTicket(Ticket ticket) {
		memberDao.insertTicket(ticket);
	}

	@Override
	public void update(Member member) {
		memberDao.update(member);
	}

	@Override
	public void updateTicket(Ticket ticket) {
		memberDao.updateTicket(ticket);
	}

	@Override
	public List<Cert> queryCert(String accttype) {
		return memberDao.queryCert(accttype);
	}

	@Override
	public void insertMemberCert(List<MemberCert> mcs) {
		memberDao.insertMemberCert(mcs);
	}

	@Override
	public void deleteMemberCert(MemberCert memberCert) {
		memberDao.deleteMemberCert(memberCert);
	}

	@Override
	public List<MemberCert> queryMemberCert(Integer id) {
		return memberDao.queryMemberCert(id);
	}

	@Override
	public Member queryMember(Integer memberid) {
		return memberDao.queryMember(memberid);
	}

	@Override
	public Member queryMemberByParam(Map<String, Object> map) {
		return memberDao.queryMemberByParam(map);
	}
	@Override
	public boolean reg(Member member) {
		String userpswd = member.getUserpswd();
		Member member2 = memberDao.queryByLoginacct(member.getLoginacct());
		if(member2!=null) {
			return false;
		}
		String md5pswd = MD5Util.digest(userpswd);
		member.setUserpswd(md5pswd);
		int insert = memberDao.insert(member);
		if(insert!=0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean check(String loginacct) {
		Member member = memberDao.queryByLoginacct(loginacct);
		if(member!=null) {
			return false;
		}else {
			return true;
		}
	}

}
