package cn.tedu.ttms.product.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product/")
public class ProductController {
	@RequestMapping("listUI")
	public String showTables() {
		return "product/product_list";
	}
	@RequestMapping("loadForm")
	public String loadForm(){
		return "product/product_edit";
	}
	
}
