package com.doing.parse.domain;

import java.util.ArrayList;
import java.util.List;

public class Subspec {
	private String name;
	private String path;
	private List<Sid> sid=new ArrayList<Sid>();
	
	public List<Sid> getSid() {
		return sid;
	}
	public void setSid(List<Sid> sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
}
