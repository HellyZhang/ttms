package cn.tedu.ttms.project.service;

import java.util.List;
import java.util.Map;

import cn.tedu.ttms.common.entity.PageObject;
import cn.tedu.ttms.project.entity.Project;

public interface ProjectService {
	public List<Project> findAllObjects();

	/**
	 * 封装业务逻辑
	 */
	public Map<String, Object> findPagesObjects(PageObject pobj);

	public Map<String, Object> findSomePagesObjects(Project pobj, PageObject page);

	public void SaveProject(Project pro);

	public int InsertObject(Project project);

	public void ValidById(String[] arr, Integer valid);

	public Project findObjectById(Integer id);

	public void updateProject(Project pro);
}
