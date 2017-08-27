package cn.tedu.ttms.project.controller;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.ttms.common.entity.JSONResult;
import cn.tedu.ttms.common.entity.PageObject;
import cn.tedu.ttms.project.entity.Project;
import cn.tedu.ttms.project.service.imp.ProjectServiceImp;

@Controller
@RequestMapping("/project/")
public class ProjectController {
	@Resource(name = "projectService")
	private ProjectServiceImp service;

	@RequestMapping("listUI")
	public String showTables() {
		return "project/project_list";
	}

	@RequestMapping("showEidtForm")
	public String showEidtForm() {
		return "project/project_edit";
	}

	/**
	 * 查询所有项目 页面返回的JSON数据,会自动调用与其属性名对应的set方法 所以视图页面请求时返回参数要确认key名与实体类的属性方法相对应
	 */
	@RequestMapping("getObject")
	@ResponseBody
	public JSONResult getPagesObjects(Project pro, PageObject page) throws IOException {
		Map<String, Object> map = service.findSomePagesObjects(pro, page);
		return new JSONResult(map);
	}

	@RequestMapping("validById")
	@ResponseBody
	public JSONResult validById(String[] ids, Integer valid) {
		System.out.println("禁用启用:" + ids.toString());
		service.ValidById(ids, valid);
		return new JSONResult();
	}

	@RequestMapping("addProject")
	@ResponseBody
	public JSONResult addObjects(Project pro) {
		System.out.println("保存项目:" + pro);
		service.SaveProject(pro);
		return new JSONResult();
	}

	@RequestMapping("updateProject")
	@ResponseBody
	public JSONResult updateObjects(Project pro) {
		System.out.println("修改项目:" + pro);
		service.updateProject(pro);
		return new JSONResult();
	}

	@RequestMapping("findProjectById")
	@ResponseBody
	public JSONResult findObjectById(Integer id) {
		Project project = service.findObjectById(id);
		return new JSONResult(project);
	}
}
