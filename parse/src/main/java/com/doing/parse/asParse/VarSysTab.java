package com.doing.parse.asParse;

public class VarSysTab {
	String varName;
	String varTypeName;
	String varTerm;
	
	public VarSysTab()
	{
		varName="";
		varTypeName="";
		varTerm="";
	}
	
	public void setVarName(String name)
	{
		varName=name;
	}
	
	public String getVarName()
	{
		return varName;
	}
	
	public String getVarType()
	{
		return varTypeName;
	}
	
	public void setVarType(String type)
	{
		varTypeName=type;
	}
	
	public void setVarTerm(String s)
	{
		varTerm=s;
	}
	
	public String getVarTerm()
	{
		return varTerm;
	}

}
