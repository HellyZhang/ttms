package cn.tedu.ttms.team.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.ttms.common.entity.JSONResult;
import cn.tedu.ttms.common.entity.PageObject;
import cn.tedu.ttms.team.entity.Team;
import cn.tedu.ttms.team.service.TeamService;

@Controller
@RequestMapping("/team/")
public class TeamController {
	@Resource(name = "teamService")
	private TeamService service;

	@RequestMapping("listUI")
	public String listUI() {
		return "team/team_list";
	}

	@RequestMapping("showEidtForm")
	public String showEidtForm() {
		return "team/team_edit";
	}

	@RequestMapping("findObjects")
	@ResponseBody
	public JSONResult finfObjects(Team team, PageObject page) {
		Map<String, Object> map = service.FindObjects(team, page);
		return new JSONResult(map);
	}

	@RequestMapping("insertObjects")
	@ResponseBody
	public JSONResult insertObjects(Team team) {
		service.InsertObjects(team);
		return new JSONResult();
	}

	@RequestMapping("findAllProName")
	@ResponseBody
	public JSONResult findProjectNameAndId() {
		List<Map<String, Object>> list = service.findProNameAndId();
		return new JSONResult(list);
	}

	@RequestMapping("doAddTeams")
	@ResponseBody
	public JSONResult doAddTeams(Team team) {
		service.InsertObjects(team);
		return new JSONResult();
	}

}
