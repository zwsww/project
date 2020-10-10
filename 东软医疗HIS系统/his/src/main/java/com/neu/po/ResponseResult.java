package com.neu.po;

import lombok.Data;

@Data
public class ResponseResult {

	private String result = "ok";
	private Object data;
}
