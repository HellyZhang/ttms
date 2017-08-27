package cn.tedu.ttms.attachment.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import cn.tedu.ttms.attachment.entity.Attachement;

public interface AttachementService {
	public void saveObject(String title,Integer athType,Integer belongId,MultipartFile mfile);
	public List<Attachement> findAllObjects();
	public List<Attachement> BatchDownload(Integer[] ids);
	public Attachement Download(Integer id);
}
