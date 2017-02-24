package com.zqs.core.service.member.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.zqs.core.dao.member.IMemberInfoMapper;
import com.zqs.core.service.member.IMemberService;
import com.zqs.core.utils.json.JacksonUtils;
import com.zqs.pojo.member.MemberInfo;

public class DefaultMemberServiceImpl implements IMemberService {
	
	@Autowired
	private IMemberInfoMapper memberInfoMapper;
	
	
	@Override
	public String load(Map<String,Object> map) {
		MemberInfo member = memberInfoMapper.loadAll(map);
		
		return JacksonUtils.object2json(member);
	}

}
