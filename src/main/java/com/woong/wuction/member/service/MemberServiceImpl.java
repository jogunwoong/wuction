package com.woong.wuction.member.service;

import org.apache.ibatis.session.SqlSession;

import com.woong.wuction.common.MybatisTemplate;
import com.woong.wuction.member.model.dao.MemberDao;
import com.woong.wuction.member.model.vo.Member;

public class MemberServiceImpl implements MemberService {
	private MemberDao mDao = new MemberDao();

	@Override
	public Member loginMember(Member m) {
		Member loginUser = null;
		
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		loginUser = mDao.loginMember(sqlSession, m);
		
		sqlSession.commit();
		sqlSession.close();
		
		return loginUser;
	}

	@Override
	public Member idFind(Member m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member pwdFind(Member m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertMember(Member m) {
		int result = 0;
		
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		result = mDao.insertMember(sqlSession, m);
		
		if(result > 0) {
			sqlSession.commit();
		}
		
		sqlSession.close();
		
		return result;
	}

	@Override
	public Member updateMember(Member m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteMember(String id, String pwd) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Member idCheck(Member m) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		Member mem = mDao.idCheck(sqlSession, m);
		
		sqlSession.close();
		
		return mem;
	}

	@Override
	public Member updatePassword(String userId, String userPwd, String newPassword) {
		// TODO Auto-generated method stub
		return null;
	}

}
