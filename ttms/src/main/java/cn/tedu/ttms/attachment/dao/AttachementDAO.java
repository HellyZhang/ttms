package cn.tedu.ttms.attachment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.ttms.attachment.entity.Attachement;

public interface AttachementDAO {
	public int findObjectByDigest(@Param("fileDigest")String fileDigest);
	public int insertObject(Attachement attachement);
	public List<Attachement> findObjects();
	public List<Attachement> findObjectByIds(@Param("ids")Integer[] ids);
	public Attachement findObjectById(Integer id);
}
