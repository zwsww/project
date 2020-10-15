package com.neu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neu.mapper.RegisterMapper;
import com.neu.po.Register;
import com.neu.po.RegisterExample;

@Service
public class RegisterServiceImpl implements RegisterService {
	@Autowired
	private RegisterMapper registerMapper;

	@Override
	public List<Register> getAll() {
		RegisterExample example = new RegisterExample();
		return registerMapper.selectByExample(example);
	}

	@Override
	public int insert(Register register) {
		
		return registerMapper.insert(register);
	}

	@Override
	public List<Register> getByCaseNumber(String num) {
		RegisterExample example = new RegisterExample();
		
		example.or().andCasenumberEqualTo(num);
		
		return registerMapper.selectByExample(example);
	}

	@Override
	public int updataVisitState(int id, int visitstate) {

		Register register = new Register();
		register.setId(id);
		register.setVisitstate(visitstate);

		return registerMapper.updateByPrimaryKeySelective(register);
	}

	

}
