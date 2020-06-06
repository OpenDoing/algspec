package com.doing.parse.domain;

import java.util.ArrayList;
import java.util.List;

public class Spec {
	private String specid;
	private List<Subspec> subspec=new ArrayList<Subspec>();
	
	


	public String getSpecid() {
		return specid;
	}
	public void setSpecid(String specid) {
		this.specid = specid;
	}
	public List<Subspec> getSubspec() {
		return subspec;
	}
	public void setSubspec(List<Subspec> subspec) {
		this.subspec = subspec;
	}

    
	
}
