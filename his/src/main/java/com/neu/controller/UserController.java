package com.neu.controller;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neu.po.ResponseResult;
import com.neu.po.User;
import com.neu.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService service;

	@RequestMapping("login")
	public ResponseResult login(String username, String password, String checkCode, HttpSession session) {
		ResponseResult result = new ResponseResult();
		String code = (String) session.getAttribute("code");

		if (!(code != null && code.equals(checkCode))) {
			result.setResult("error");
			result.setData("验证码错误！");

			return result;
		}

		User user = service.login(username, password);

		if (user == null) {
			result.setResult("error");
			result.setData("用户名或密码输入错误，登录失败！");
		} else {
			result.setData(user);
		}
		return result;
	}

	@RequestMapping("checkCode")
	public boolean checkCode(String checkCode, HttpSession session) {
		String code = (String) session.getAttribute("code");

		if (!(code != null && code.equals(checkCode))) {
			return false;
		}
		return true;
	}

	@RequestMapping("getCode")
	public ResponseEntity<byte[]> getCode(HttpSession session) throws IOException {
		char[] arr = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

		StringBuilder stb = new StringBuilder();

		int n;
		for (int i = 0; i < 4; i++) {
			n = (int) (Math.random() * arr.length);
			stb.append(arr[n]);
		}
		session.setAttribute("code", stb.toString());

		BufferedImage buImage = new BufferedImage(90, 20, BufferedImage.TYPE_INT_RGB);
		// 得到画布
		Graphics g = buImage.getGraphics();
		// 把字符串写入到画布中
		g.drawString(stb.toString(), 20, 15);
		// 创建一个字节数组输出流
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ImageIO.write(buImage, "jpeg", bos);
		return new ResponseEntity<byte[]>(bos.toByteArray(), HttpStatus.CREATED);

	}
}
