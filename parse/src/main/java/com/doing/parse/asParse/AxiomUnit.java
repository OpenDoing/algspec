package com.doing.parse.asParse;

import com.doing.parse.domain.DBUtils;

import java.util.ArrayList;

public class AxiomUnit {
	ArrayList<String> globalVarNL;
	ArrayList<VarSysTab> globalVL;
	ArrayList<EquationSysTab> globalEL;
	
	public AxiomUnit()
	{
		globalVarNL=new ArrayList<String>();
		globalVL=new ArrayList<VarSysTab>();
		globalEL=new ArrayList<EquationSysTab>();
	}
	
	public boolean addGlobVarName(String name)
	{
		if(globalVarNL.contains(name))
			return false;
		else {
			globalVarNL.add(name);
			return true;
		}
		
	}
	public boolean checkLocalVarName(String name)
	{
		if(globalVarNL.contains(name))
			return false;
		else 
			return true;
	}
	public void addGlobVarST(VarSysTab vs)
	{
		globalVL.add(vs);
	}
	
	public void setVarType(String type)
	{
		for(int i=globalVL.size()-1;i>=0&&globalVL.get(i).getVarType().equals("");i--)
		{
			globalVL.get(i).setVarType(type);
		}
	}
	
	public void addGlobE(EquationSysTab ge)
	{
		globalEL.add(ge);
	}
	
	public boolean isGlobalVar(String s)
	{
		if(globalVarNL.contains(s))
			return true;
		else 
			return false;
	}
	
	public String getGlobalVarType(String s)
	{
		for (int i = 0; i < globalVL.size(); i++) {
			if(globalVL.get(i).getVarName().equals(s))
				return globalVL.get(i).getVarType();
		}
		return "varType error!";
	}
	
	public void writeAxiomToDB(String specID,String subSpecID,String sortName,int axIndex,String userName)
	{
		String sql;
		//全局var写到数据库
		for(int i=0;i<globalVL.size();i++)   
		{
			sql = "insert into variable(AxIndex,EqIndex,SpecID,SubSpecID,SID,VarID,Type,Term,Flag,username) values(?,?, ?, ?,?,?,?,?,?,?)";
			DBUtils.executeUpdate(sql,axIndex,0,specID ,subSpecID,sortName,globalVL.get(i).getVarName(),globalVL.get(i).getVarType(),"Null","Global",userName);
		}
		//局部var和等式写到数据库		
		for(int i=0;i<globalEL.size();i++)
		{
			globalEL.get(i).writeAxiomToDB(specID,subSpecID, sortName,axIndex, i,userName);
		}
	}
	
}
