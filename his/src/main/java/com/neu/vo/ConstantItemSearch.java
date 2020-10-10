package com.neu.vo;

import lombok.Data;

@Data
public class ConstantItemSearch {

	private int pageNum;
	private int pageSize;
	private String CodeOrName;
	private Integer typeId;
}
