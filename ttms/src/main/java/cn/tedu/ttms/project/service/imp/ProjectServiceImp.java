package cn.tedu.ttms.project.service.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.ttms.common.entity.PageObject;
import cn.tedu.ttms.project.dao.ProjectDAO;
import cn.tedu.ttms.project.entity.Project;
import cn.tedu.ttms.project.service.ProjectService;

@Service("projectService")
public class ProjectServiceImp implements ProjectService {
	@Resource(name = "projectDAO")
	private ProjectDAO prodao;

	public List<Project> findAllObjects() {
		List<Project> list = prodao.FindAllObjects();
		return list;
	}

	/**
	 * 查询所有项目信息 返回项目列表和页面信息
	 */
	public Map<String, Object> findPagesObjects(PageObject page) {
		if (page.getPagesSize() == 0) {
			throw new RuntimeException("pagesSize不能为0");
		}
		page.setRowCount(prodao.countObjects());
		List<Project> list = prodao.FindPageObjects(page);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("List_Projects", list);
		map.put("pageObject", page);
		return map;
	}

	/**
	 * 查询符合某些条件的项目信息
	 * 
	 */
	public Map<String, Object> findSomePagesObjects(Project pro, PageObject page) {
		if (page.getPagesSize() == 0) {
			throw new RuntimeException("pagesSize不能为0");
		}
		page.setRowCount(prodao.countSomeObjects(page, pro));
		List<Project> list = prodao.FindSomeObjects(page, pro);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("List_Projects", list);
		map.put("pageObject", page);
		System.out.println("PageObject:" + page);
		return map;
	}

	public void ValidById(String[] ids, Integer valid) {
		if (ids == null || ids.length == 0) {
			throw new RuntimeException("必须给定ID值");
		}
		if (valid != 0 && valid != 1) {
			throw new RuntimeException("属性值不合法");
		}
		int row = prodao.ValidById(ids, valid);
		if (row == -1) {
			throw new RuntimeException("修改失败");
		}
	}

	public void SaveProject(Project pro) {
		if (pro == null) {
			throw new RuntimeException("请输入数据");
		}
		System.out.println("pro1" + pro);
		if (pro.getBeginDate() != null && pro.getBeginDate() != null
				&& pro.getBeginDate().getTime() >= pro.getEndDate().getTime()) {
			throw new RuntimeException("请检查项目开始时间和结束时间");
		}
		System.out.println("pro1" + pro);
		int i = prodao.saveProject(pro);
		System.out.println(pro);
		if (i < 0) {
			throw new RuntimeException("保存失败");
		}
	}

	public Project findObjectById(Integer id) {
		if (id == null) {
			throw new RuntimeException("ID为空");
		}
		Project pro = prodao.FindById(id);
		if (pro == null) {
			throw new RuntimeException("未找到项目");
		}
		return pro;
	}

	public void updateProject(Project pro) {
		if (pro == null) {
			throw new RuntimeException("项目为空");
		}
		int i = prodao.UpdateObjects(pro);
		if (i <= 0) {
			throw new RuntimeException("修改失败!");
		}
	}

	public int InsertObject(Project project) {
		return 0;
	}

}
