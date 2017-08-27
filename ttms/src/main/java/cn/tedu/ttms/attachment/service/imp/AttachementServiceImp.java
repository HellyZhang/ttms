package cn.tedu.ttms.attachment.service.imp;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cn.tedu.ttms.attachment.dao.AttachementDAO;
import cn.tedu.ttms.attachment.entity.Attachement;
import cn.tedu.ttms.attachment.service.AttachementService;
@Service("attachementService")
public class AttachementServiceImp implements AttachementService{
	@Resource(name="attachementDAO")
	private AttachementDAO attdao;
	public void saveObject(String title,Integer athType,Integer belongId,MultipartFile mfile){
		/**1.上传文件*/
		//获取上传文件名
		String fileName = mfile.getOriginalFilename();
		System.out.println("上传文件的文件名:"+fileName);
		//上传文件的大小
		byte[] fileByte =null;
		//上传的目标文件
		File dest;
		//上传路径
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String str = sdf.format(now);
		String realPath = "d:/upload/myfile/"+str+"/"+UUID.randomUUID().toString()+"."+FilenameUtils.getExtension(fileName);
		//文件摘要
		String digest =null;
		try{
			//上传文件的内容
			fileByte = mfile.getBytes();
			digest =DigestUtils.md5Hex(fileByte);
			//上传
			dest = new File(realPath);
			if(!dest.getParentFile().exists()){
				dest.getParentFile().mkdirs();
			}
			//根据摘要判断文件是否已存在
			if(attdao.findObjectByDigest(digest)>0){
				throw new RuntimeException("文件已存在");
			}
			//上传文件
			mfile.transferTo(dest);
		}catch(IOException e){
			e.printStackTrace();
			throw new RuntimeException("Upload ERROR");
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		/**保存到数据库*/
		Attachement atta = new Attachement();
		atta.setTitle(title);
		atta.setFileName(fileName);
		atta.setAthType(athType);
		atta.setBelongId(belongId);
		atta.setContentType("product");
		atta.setFilePath(realPath);
		atta.setFileDigest(digest);
		atta.setCreatedUser("admin");
		atta.setModifiedUser("no");
		attdao.insertObject(atta);
	}
	public List<Attachement> findAllObjects(){
		List<Attachement> list = attdao.findObjects();
		return list;
	}
	public List<Attachement> BatchDownload(Integer[] ids){
		return null;
	}
	public Attachement Download(Integer id){
		if(id==null){
			throw new RuntimeException("id 不能为空");
		}
		Attachement a = attdao.findObjectById(id);
		if(a==null){
			throw new RuntimeException("记录不存在");
		}
		File file = new File(a.getFilePath());
		if(!file.exists()){
			throw new RuntimeException("文件不存在");
		}
		return a;
	}
}
