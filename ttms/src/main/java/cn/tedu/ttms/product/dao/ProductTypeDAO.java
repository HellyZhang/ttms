package cn.tedu.ttms.product.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.tedu.ttms.product.entity.ProductType;

public interface ProductTypeDAO {
	public List<Map<String, Object>> findObjects();

	public List<Map<String, Object>> selectParenType();
	public int InsertObjects(ProductType proType);
	public Map<String,Object> findObjectById(@Param("id")Integer id);
	public int updateObjects(ProductType proType);
	public int deleteById(Integer id);
	public int findChilds(Integer parentId);
}
