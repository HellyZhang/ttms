package attachement;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.ttms.attachment.dao.AttachementDAO;
import cn.tedu.ttms.attachment.entity.Attachement;

public class TestAttachementDao {
	ClassPathXmlApplicationContext ac;
	AttachementDAO dao;
	@Before
	public void init(){
		ac = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		dao = ac.getBean("attachementDAO", AttachementDAO.class);
	}
	@Test
	public void insert(){
		Attachement a = new Attachement();
		a.setTitle("test");
		a.setContentType("txt");
		a.setFileDigest("efrf23124acz");
		int i = dao.insertObject(a);
	}
}
