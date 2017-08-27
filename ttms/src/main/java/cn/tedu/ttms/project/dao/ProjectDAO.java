package cn.tedu.ttms.project.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.tedu.ttms.common.entity.PageObject;
import cn.tedu.ttms.project.entity.Project;

public interface ProjectDAO {
	public List<Project> FindPageObjects(PageObject p);

	public List<Project> FindAllObjects();

	public int countObjects();

	public List<Project> FindSomeObjects(@Param("pageObject") PageObject page, @Param("project") Project pro);

	public int countSomeObjects(@Param("pageObject") PageObject page, @Param("project") Project pro);

	public Project FindById(int id);

	public int ValidById(@Param("ids") String[] ids, @Param("valid") int valid);

	public int UpdateObjects(Project project);

	public int saveProject(Project pro);

	public List<Map<String, Object>> findProNameAndId();
}
