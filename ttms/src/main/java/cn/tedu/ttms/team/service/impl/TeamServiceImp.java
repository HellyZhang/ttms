package cn.tedu.ttms.team.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.ttms.common.entity.PageObject;
import cn.tedu.ttms.project.dao.ProjectDAO;
import cn.tedu.ttms.project.entity.Project;
import cn.tedu.ttms.team.dao.TeamDAO;
import cn.tedu.ttms.team.entity.Team;
import cn.tedu.ttms.team.service.TeamService;

@Service("teamService")
public class TeamServiceImp implements TeamService {
	@Resource(name = "teamDAO")
	private TeamDAO teamdao;
	@Resource(name = "projectDAO")
	ProjectDAO prodao;

	public Map<String, Object> FindObjects(Team team, PageObject page) {
		List<Map<String, Object>> list = teamdao.FindObjects(team, page);
		page.setRowCount(teamdao.CountObjects(team));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("pageObject", page);
		return map;
	}

	public void InsertObjects(Team team) {
		int i = 0;
		if (team != null) {
			i = teamdao.InsertObjects(team);
		} else {
			throw new RuntimeException("至少插入一个团信息");
		}

		if (i == -1) {
			throw new RuntimeException("插入数据失败!");
		}
	}

	public Project findProjectById(int id) {
		Project pro = prodao.FindById(id);
		return pro;
	}

	public List<Map<String, Object>> findProNameAndId() {
		List<Map<String, Object>> list = prodao.findProNameAndId();
		return list;
	}

	public void SaveTeams(Team team) {
		if (team == null) {
			throw new RuntimeException("团不能为空");
		}
		int i = teamdao.InsertObjects(team);
		if (i <= 0) {
			throw new RuntimeException("保存失败");
		}
	}
}
