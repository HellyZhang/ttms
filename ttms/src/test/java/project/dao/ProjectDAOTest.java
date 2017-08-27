package project.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.ttms.common.entity.PageObject;
import cn.tedu.ttms.project.dao.ProjectDAO;
import cn.tedu.ttms.project.entity.Project;

public class ProjectDAOTest {
	ClassPathXmlApplicationContext ctx;
	ProjectDAO dao;

	@Before
	public void init() {
		ctx = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		dao = (ProjectDAO) ctx.getBean("projectDAO");
		System.out.println(dao);
	}

	@Test
	public void Testss() {
		Project pro = new Project();
		PageObject pobj = new PageObject();
		List<Project> list = dao.FindSomeObjects(pobj, pro);
		System.out.println(list);
	}

	@Test
	public void testInsertObject() throws Exception {
		// 2.���DAO����
		ProjectDAO projectDao = (ProjectDAO) ctx.getBean("projectDAO");
		// 3.����entity����
		Project entity = new Project();
		entity.setId(5);
		entity.setCode("TT-20170711-CHN-BJ-016");
		entity.setName("̩��������ʯ��");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		entity.setBeginDate(sdf.parse("2017-05-12"));
		entity.setEndDate(sdf.parse("2017-09-19"));
		entity.setValid(1);
		entity.setNote("̩��������ʯ��...........");
		entity.setCreatedUser("admin");
		entity.setModifiedUser("admin");
		// 4.������д�뵽���ݿ�

	}

	/** ���Բ�ѯ���� */
	@Test
	public void testFindObjects() {
		List<Project> list = dao.FindAllObjects();
		System.out.println(list);
		Assert.assertNotEquals(null, list);
	}

	/** ����ģ����ѯ���� */
	@Test
	public void testFindSomeObjects() {
		PageObject page = new PageObject();
		Project pro = new Project();
		System.out.println(page);
		System.out.println(pro);
		int i = dao.countSomeObjects(page, pro);
		List<Project> list = dao.FindSomeObjects(page, pro);
		System.out.println(list.size());
		System.out.println(list);
		System.out.println(i);
	}

	@Test
	// 测试修改Valid(禁用/启用)
	public void ValidById() {
		Project pro = new Project();
		System.out.println(pro);
		String[] str = new String[] { "1", "2" };
		int valid = 1;
		System.out.println(dao.FindAllObjects());
		int i = dao.ValidById(str, valid);
		System.out.println(i);
		System.out.println(dao.FindAllObjects());
	}

	@Test
	public void save() {
		Project pro = new Project();
		pro.setCode("TMS_OPPP_12");
		pro.setName("海南三日游");
		pro.setBeginDate(new Date());
		pro.setEndDate(new Date());
		pro.setValid(0);
		pro.setNote("test");
		dao.saveProject(pro);
	}

	// ����context(Ҳ�����Ȳ�д)
	@After
	public void destory() {
		ctx.close();
	}
}
