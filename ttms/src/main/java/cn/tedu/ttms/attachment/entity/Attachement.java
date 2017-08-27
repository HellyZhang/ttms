package cn.tedu.ttms.attachment.entity;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import cn.tedu.ttms.common.entity.DateFormatJson;

public class Attachement {
	private static final long serialVersionUID = 1L;
	private Integer id;
	/**��������*/
	private String title;
	/**�ļ���ʵ����*/
	private String fileName;
	/**�ļ���������*/
	private String contentType;
	/**�ļ��ڷ������ϵĴ洢��ַ*/
	private String filePath;
	/**�ļ�ժҪ��Ϣ*/
	private String fileDigest;
	/**��������(1:��Ʒ����,2:�����̸���,3:��Ӧ�̸���)*/
	private Integer athType;
	/**���������������(�������ھ�����ĸ���Ʒ)*/
	private Integer belongId;
	/**�����Ĵ���ʱ��*/
	private Date createdTime;
	/**�������޸�ʱ��*/
	private Date modifiedTime;
	/**�����Ĵ�����*/
	private String createdUser;
	/**�������޸���*/
    private String modifiedUser;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileDigest() {
		return fileDigest;
	}
	public void setFileDigest(String fileDigest) {
		this.fileDigest = fileDigest;
	}
	public Integer getAthType() {
		return athType;
	}
	public void setAthType(Integer athType) {
		this.athType = athType;
	}
	public Integer getBelongId() {
		return belongId;
	}
	public void setBelongId(Integer belongId) {
		this.belongId = belongId;
	}
	@JsonSerialize(using = DateFormatJson.class)
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	@JsonSerialize(using = DateFormatJson.class)
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public String getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	public String getModifiedUser() {
		return modifiedUser;
	}
	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Attachement [id=" + id + ", title=" + title + ", fileName=" + fileName + ", contentType=" + contentType
				+ ", filePath=" + filePath + ", fileDisgest=" + fileDigest + ", athType=" + athType + ", belongId="
				+ belongId + ", createdTime=" + createdTime + ", modifiedTime=" + modifiedTime + ", createdUser="
				+ createdUser + ", modifiedUser=" + modifiedUser + "]";
	}
    
}
