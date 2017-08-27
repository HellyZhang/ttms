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
		//根据id查找记录
		//获得文件真实路径
		//构建文件对象关联真实路径
		//检测文件是否存在,存在则下载
		Attachement a = service.Download(id);
		String path = a.getFilePath();
		File file = new File(path);
		//返回文件时,要求返回特定表头
		//设置响应消息头,下载时固定写法(必须写!!)
		response.setContentType("appliction/octet-stream");
		response.setHeader("Content-disposition","attachment;filename="+file.getName());
		Path paths = Paths.get(file.getPath());
		return Files.readAllBytes(paths);
		//return file;
	}
	
}
