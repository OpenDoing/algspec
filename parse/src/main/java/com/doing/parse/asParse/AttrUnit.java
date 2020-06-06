package com.doing.parse.asParse;

public class AttrUnit {
	private String attrName;
	private String typeName;
	private String indexString;
	
	public AttrUnit() {
		// TODO Auto-generated constructor stub
		attrName=new String();
		typeName=new String("");
		indexString=new String("");
	}
	
	public void setAttrName(String name)
	{
		attrName=name;
	}
	
	public void setTypeName(String type)
	{
		typeName=type;
	}
	
	public void setIndexString(String index)
	{
		indexString=index;
	}
	
	public String getAttrName()
	{
		return attrName;
	}
	
	public String getAttrType()
	{
		return typeName;
	}
	
	public String getAttrIndexString()
	{
		return indexString;
	}
}
