package cn.tedu.ttms.team.service;

import java.util.List;
import java.util.Map;

import cn.tedu.ttms.common.entity.PageObject;
import cn.tedu.ttms.team.entity.Team;

public interface TeamService {
	public Map<String, Object> FindObjects(Team team, PageObject page);

	public void InsertObjects(Team team);

	public List<Map<String, Object>> findProNameAndId();

	public void SaveTeams(Team team);
}
