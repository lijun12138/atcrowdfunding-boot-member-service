package com.atguigu.atcrowdfunding.member.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.atguigu.atcrowdfunding.common.bean.Cert;
import com.atguigu.atcrowdfunding.common.bean.Member;
import com.atguigu.atcrowdfunding.common.bean.MemberCert;
import com.atguigu.atcrowdfunding.common.bean.Ticket;

public interface MemberDao {

	@Select("select * from t_member where loginacct = #{loginacct}")
	Member queryByLoginacct(String loginacct);

	Ticket queryTicket( Map<String,Object> param);

	@Insert("insert into t_ticket(memberid,piid,status,pstep) values(#{memberid},#{piid},#{status},#{pstep})")
	void insertTicket(Ticket ticket);

	void update(Member member);

	void updateTicket(Ticket ticket);

	List<Cert> queryCert(String accttype);

	void insertMemberCert(@Param("mcs")List<MemberCert> mcs);

	void deleteMemberCert(MemberCert memberCert);

	List<MemberCert> queryMemberCert(Integer id);

	@Select("select * from t_member where id = #{memberid}")
	Member queryMember(Integer memberid);

	@Select("select * from t_member where loginacct = #{loginacct} and userpswd=#{userpswd}")
	Member queryMemberByParam(Map<String, Object> map);

	int insert(Member record);
}
