package com.neu.service;

import java.util.List;

import com.neu.po.Register;

public interface RegisterService {
	List<Register> getAll();
	
	int insert(Register register);
	
	List<Register> getByCaseNumber(String num);
	
	int updataVisitState(int id,int visitstate);
}
