package com.jk.tree.model;

import com.jk.tree.util.LayuiTree;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tree implements Serializable {

	private static final long serialVersionUID = 5022263275397027486L;


	private Long id;

	private Long pid; //父节点id

	private String title;

	private String href;

	private List<Tree> children;

	private Map<String, Object> attributes = new HashMap<String, Object>(); // 添加到节点的自定义属性


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public List<Tree> getChildren() {
		return children;
	}

	public void setChildren(List<Tree> children) {
		this.children = children;
	}

	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	@Override
	public String toString() {
		return "Tree{" +
				"id=" + id +
				", pid=" + pid +
				", title='" + title + '\'' +
				", href='" + href + '\'' +
				", children=" + children +
				", attributes=" + attributes +
				'}';
	}
}
