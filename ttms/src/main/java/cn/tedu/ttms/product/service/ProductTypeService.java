package cn.tedu.ttms.product.service;

import java.util.List;
import java.util.Map;

import cn.tedu.ttms.product.entity.ProductType;

public interface ProductTypeService {
	public List<Map<String, Object>> findObjects() ;
	public List<Map<String, Object>> findParentType();
	public void doSaveFormEditData(ProductType proType);
	public Map<String,Object> findObjectById(Integer id);
	public void updateObjects(ProductType proType);
	public void deleteById(Integer id);
}
