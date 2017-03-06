package com.hly.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hly.activemq.MessageSender;

@Controller
@RequestMapping("/test/*")
public class TestController {
	Logger logger = Logger.getLogger(TestController.class);
	
	@Autowired
	MessageSender sender;

	@RequestMapping(value = "login")
	@ResponseBody
	public Map<String, Object> doLogin() {
		logger.error("123423423432423423");
		System.out.println("11111111");
		sender.userLogin(1, "sb");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "0000");
		map.put("msg", "success");
		return map;
	}
}
