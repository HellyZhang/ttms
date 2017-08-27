package cn.tedu.ttms.team.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.tedu.ttms.common.entity.PageObject;
import cn.tedu.ttms.team.entity.Team;

public interface TeamDAO {
	public List<Map<String, Object>> FindObjects(@Param("team") Team team, @Param("page") PageObject page);

	public int InsertObjects(Team team);

	public int CountObjects(@Param("team") Team team);
}
