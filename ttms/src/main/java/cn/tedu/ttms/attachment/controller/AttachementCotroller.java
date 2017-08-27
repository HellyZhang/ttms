package cn.tedu.ttms.attachment.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.tedu.ttms.attachment.entity.Attachement;
import cn.tedu.ttms.attachment.service.AttachementService;
import cn.tedu.ttms.common.entity.JSONResult;
@Controller
@RequestMapping("attachement")
public class AttachementCotroller {
	@Resource(name="attachementService")
	private AttachementService service;
	@RequestMapping("loadUI")
	public String loadUpForm(){
		return "attachement/attachement_list";
	}
	@RequestMapping("upLoad")
	@ResponseBody
	public JSONResult upLoadFile(String title,Integer athType,Integer belongId, MultipartFile mfile,HttpServletRequest request){
		System.out.println("title:"+title);
		System.out.println("belongId:"+belongId);
		String path = request.getServletContext().getRealPath("/");
		System.out.println(path);
		service.saveObject(title, athType, belongId, mfile);
		return new JSONResult();
	}
	@RequestMapping("getObjects")
	@ResponseBody
	public JSONResult findObjects(){
		List<Attachement> list = service.findAllObjects();
		return new JSONResult(list);
	}
	@RequestMapping("download")
	@ResponseBody
	public byte[] doDownloadObjectById(Integer id,HttpServletResponse response) throws IOException{
		//����id���Ҽ�¼
		//����ļ���ʵ·��
		//�����ļ����������ʵ·��
		//����ļ��Ƿ����,����������
		Attachement a = service.Download(id);
		String path = a.getFilePath();
		File file = new File(path);
		//�����ļ�ʱ,Ҫ�󷵻��ض���ͷ
		//������Ӧ��Ϣͷ,����ʱ�̶�д��(����д!!)
		response.setContentType("appliction/octet-stream");
		response.setHeader("Content-disposition","attachment;filename="+file.getName());
		Path paths = Paths.get(file.getPath());
		return Files.readAllBytes(paths);
		//return file;
	}
	
}
