package cn.tedu.ttms.product.service.imp;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.ttms.product.dao.ProductTypeDAO;
import cn.tedu.ttms.product.entity.ProductType;
import cn.tedu.ttms.product.service.ProductTypeService;

@Service("productTypeService")
public class ProductTypeServiceImp implements ProductTypeService{
	@Resource(name = "productTypeDAO")
	ProductTypeDAO proTypedao;

	public List<Map<String, Object>> findObjects() {
		List<Map<String, Object>> list = proTypedao.findObjects();

		return list;
	}

	public List<Map<String, Object>> findParentType() {
		List<Map<String, Object>> list = proTypedao.selectParenType();
		return list;
	}
	public void doSaveFormEditData(ProductType proType){
		if(proType==null){
			throw new RuntimeException("没有保存对象");
		}
		int i = proTypedao.InsertObjects(proType);
		if(i<1){
			throw new RuntimeException("保存失败");
		}
	}
	public Map<String,Object> findObjectById(Integer id){
		if(id==null){
			throw new RuntimeException("id为空");
		}
		System.out.println("service:"+id);
		Map<String,Object> map = proTypedao.findObjectById(id);
		System.out.println("service2:"+id);
		if(map==null){
			throw new RuntimeException("未查到对象");
		}
		return map;
	}
	public void updateObjects(ProductType proType){
		if(proType==null){
			throw new RuntimeException("更改对象为空");
		}
		int i = proTypedao.updateObjects(proType);
		if(i<1){
			throw new RuntimeException("修改不成功");
		}
	}
	public void deleteById(Integer id){
		if(id==null){
			throw new RuntimeException("请指定ID");
		}
		int count =proTypedao.findChilds(id);
		if(count>0){
			throw new RuntimeException("请先删除子元素");
		}
		int i = proTypedao.deleteById(id);
		if(i<1){
			throw new RuntimeException("删除不成功");
		}
	}
}
