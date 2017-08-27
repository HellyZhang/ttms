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
		/**1.�ϴ��ļ�*/
		//��ȡ�ϴ��ļ���
		String fileName = mfile.getOriginalFilename();
		System.out.println("�ϴ��ļ����ļ���:"+fileName);
		//�ϴ��ļ��Ĵ�С
		byte[] fileByte =null;
		//�ϴ���Ŀ���ļ�
		File dest;
		//�ϴ�·��
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String str = sdf.format(now);
		String realPath = "d:/upload/myfile/"+str+"/"+UUID.randomUUID().toString()+"."+FilenameUtils.getExtension(fileName);
		//�ļ�ժҪ
		String digest =null;
		try{
			//�ϴ��ļ�������
			fileByte = mfile.getBytes();
			digest =DigestUtils.md5Hex(fileByte);
			//�ϴ�
			dest = new File(realPath);
			if(!dest.getParentFile().exists()){
				dest.getParentFile().mkdirs();
			}
			//����ժҪ�ж��ļ��Ƿ��Ѵ���
			if(attdao.findObjectByDigest(digest)>0){
				throw new RuntimeException("�ļ��Ѵ���");
			}
			//�ϴ��ļ�
			mfile.transferTo(dest);
		}catch(IOException e){
			e.printStackTrace();
			throw new RuntimeException("Upload ERROR");
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		/**���浽���ݿ�*/
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
			throw new RuntimeException("id ����Ϊ��");
		}
		Attachement a = attdao.findObjectById(id);
		if(a==null){
			throw new RuntimeException("��¼������");
		}
		File file = new File(a.getFilePath());
		if(!file.exists()){
			throw new RuntimeException("�ļ�������");
		}
		return a;
	}
}
