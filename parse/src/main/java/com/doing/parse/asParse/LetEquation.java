package com.doing.parse.asParse;

import com.doing.parse.domain.DBUtils;

import java.util.ArrayList;

public class LetEquation {
	ArrayList<String> localVarNL;
	ArrayList<VarSysTab> localVars;
	ArrayList<CondEquation> condEquas;
	
	public LetEquation()
	{
		localVarNL=new ArrayList<String>();
		localVars=new ArrayList<VarSysTab>();
		condEquas=new ArrayList<CondEquation>();
	}
	
	public void addConEqua(CondEquation c)
	{
		condEquas.add(c);
	}
	
	public boolean addLocalV(String s)
	{
		if(localVars.contains(s))
			return false;
		else {
			localVarNL.add(s);
			return true;
		}
	}
	
	public void addLocalVar(VarSysTab v)
	{
		localVars.add(v);
	}
	
	public String getLocalVarType(String s)
	{
		for (int i = 0; i < localVars.size(); i++) {
			if(localVars.get(i).getVarName().equals(s))
			{
				return localVars.get(i).getVarType();
			}
		}
		return "varType error!";
	}
	
	public boolean isLocalVar(String s)
	{
		if (localVarNL.contains(s)) 
			return true;
		else 
			return false;
	}
	
	public void writeAxiomToDB(String specID,String subSpecID,String sortName,int axIndex,int eqIndex,String userName)
	{
		String sql;
		for(int i=0;i<localVars.size();i++)
		{
			sql = "insert into variable(AxIndex,EqIndex,SpecID,SubSpecID,SID,VarID,Type,Term,Flag,username) values(?,?, ?, ?,?,?,?,?,?,?)";
			DBUtils.executeUpdate(sql,axIndex,eqIndex,specID ,subSpecID,sortName,localVars.get(i).getVarName(),localVars.get(i).getVarType(),localVars.get(i).getVarTerm(),"Local",userName);
		}
		for(int i=0;i<condEquas.size();i++)
		{
			condEquas.get(i).writeAxiomToDB(specID,subSpecID, sortName,axIndex, eqIndex,i,userName);
		}
	}
}
