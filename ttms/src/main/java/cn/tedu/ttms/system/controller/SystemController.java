package cn.tedu.ttms.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SystemController {

	@RequestMapping("index")
	public String findAll() {
		return "index";
	}
}
