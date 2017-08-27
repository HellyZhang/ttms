package team.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.ttms.team.dao.TeamDAO;

public class FindObject {
	ClassPathXmlApplicationContext ctx;
	TeamDAO dao;

	@Before
	public void init() {
		ctx = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		dao = (TeamDAO) ctx.getBean("teamDAO");
		System.out.println(dao);
	}

	@Test
	public void findObjects() {
		// List<Map<String, Object>> list = dao.FindObjects();
		// System.out.println(list);
	}
}
