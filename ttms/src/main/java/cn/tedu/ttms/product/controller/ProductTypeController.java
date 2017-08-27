package cn.tedu.ttms.product.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.ttms.common.entity.JSONResult;
import cn.tedu.ttms.product.entity.ProductType;
import cn.tedu.ttms.product.service.ProductTypeService;

@Controller
@RequestMapping("/productType/")
public class ProductTypeController {
	@Resource(name = "productTypeService")
	private ProductTypeService proTypeservice;

	@RequestMapping("listUI")
	public String showTables() {
		return "product/product_type_list";
	}

	@RequestMapping("typeEdit")
	public String typeEdit() {
		return "product/product_type_edit";
	}

	@RequestMapping("findObjects")
	@ResponseBody
	public JSONResult findObjects() {
		List<Map<String, Object>> list = proTypeservice.findObjects();
		return new JSONResult(list);
	}

	@RequestMapping("loadparentType")
	@ResponseBody
	public JSONResult loadparentType() {
		List<Map<String, Object>> list = proTypeservice.findParentType();
		return new JSONResult(list);
	}

	@RequestMapping("doSaveFormEditData")
	@ResponseBody
	public JSONResult doSaveFormEditData(ProductType proType) {
		System.out.println(proType);
		proTypeservice.doSaveFormEditData(proType);
		return new JSONResult();
	}
	@RequestMapping("findObjectById")
	@ResponseBody
	public JSONResult findObjectById(Integer id){
		System.out.println(id);
		Map<String,Object> map = proTypeservice.findObjectById(id);
		return new JSONResult(map);
	}
	@RequestMapping("updateObjects")
	@ResponseBody
	public JSONResult updateObjects(ProductType proType){
		proTypeservice.updateObjects(proType);
		return new JSONResult();
	}
	@RequestMapping("deleteById")
	@ResponseBody
	public JSONResult deleteById(Integer id){
		proTypeservice.deleteById(id);
		return new JSONResult();
	}
	
}
