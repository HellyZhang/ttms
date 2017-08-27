package cn.tedu.ttms.product.entity;

import java.util.Date;

public class ProductType {
	private Integer id;
	private String name;
	private Integer parentId;
	private Integer sort;
	private String note;
	private String createdUser;
	private Date createdsTime;
	private String modifiedUser;
	private Date modifiedTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}

	public Date getCreatedsTime() {
		return createdsTime;
	}

	public void setCreatedsTime(Date createdsTime) {
		this.createdsTime = createdsTime;
	}

	public String getModifiedUser() {
		return modifiedUser;
	}

	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}

	public Date getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	@Override
	public String toString() {
		return "ProductType [id=" + id + ", name=" + name + ", parentId=" + parentId + ", sort=" + sort + ", note="
				+ note + ", createdUser=" + createdUser + ", createdsTime=" + createdsTime + ", modifiedUser="
				+ modifiedUser + ", modifiedTime=" + modifiedTime + "]";
	}
}
