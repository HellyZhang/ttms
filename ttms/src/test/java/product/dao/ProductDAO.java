package product.dao;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.ttms.product.dao.ProductTypeDAO;

public class ProductDAO {
	ClassPathXmlApplicationContext ac;
	ProductTypeDAO dao;

	@Before
	public void init() {
		ac = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		dao = ac.getBean("productTypeDAO", ProductTypeDAO.class);
	}

	@Test
	public void findObjects() {
		List<Map<String, Object>> list = dao.findObjects();
		System.out.println(list);
	}
}
