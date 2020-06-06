package com.doing.parse.asParse;


import com.doing.parse.domain.DBUtils;

import java.util.ArrayList;

public class CondEquation {
	ConditionSysTab cond;
	ArrayList<ConditionSysTab> ifCondList;
	
	public CondEquation()
	{
		cond=new ConditionSysTab();
		ifCondList=new ArrayList<ConditionSysTab>();
	}
	
	public void setCond(ConditionSysTab c)
	{
		cond=c;
	}
	
	public void addIfCond(ConditionSysTab c)
	{
		ifCondList.add(c);
	}
	
	//将不是let-in局部等式中的cond等式存入数据库
	public void writeAxiomToDB(String specID,String subSpecID,String sortName,int axIndex,int eqIndex,String userName)
	{
		String sql;
		{
			System.out.println(cond.getLeftTerm()+","+cond.getLeftType()+","+cond.getReOp()+","+cond.getRightTerm()+","+cond.getRightType());
		}
		sql="insert into Equation(AxIndex,EqIndex,SubEqIndex,CondIndex,SpecID,SubSpecID,SID,LTerm,LTType,Relation,RTerm,RTType,Flag,username) values (?,?, ?,?, ? ,? ,? ,? ,? ,? ,? ,? ,? ,?)";
		DBUtils.executeUpdate1(sql,axIndex,eqIndex,0,1,specID ,subSpecID,sortName,cond.getLeftTerm(),cond.getLeftType(),cond.getReOp(),cond.getRightTerm(),cond.getRightType(),"condition",userName);
		for(int i=0;i<ifCondList.size();i++)
		{
			DBUtils.executeUpdate1(sql,axIndex,eqIndex,0,i,specID ,subSpecID,sortName,ifCondList.get(i).getLeftTerm(),ifCondList.get(i).getLeftType(),ifCondList.get(i).getReOp(),ifCondList.get(i).getRightTerm(),ifCondList.get(i).getRightType(),"ifcondition",userName);
		}
	}
	//将let-in局部等式中的cond等式存入数据库	
	public void writeAxiomToDB(String specID,String subSpecID,String sortName,int axIndex,int eqIndex,int subEqIndex,String userName)
	{
		String sql;
		sql="insert into Equation(AxIndex,EqIndex,SubEqIndex,CondIndex,SpecID,SubSpecID,SID,LTerm,LTType,Relation,RTerm,RTType,Flag,username) values (?,?, ?,?, ? ,? ,? ,? ,? ,? ,? ,? ,? ,?)";
		DBUtils.executeUpdate1(sql,axIndex,eqIndex,0,1,specID ,subSpecID,sortName,cond.getLeftTerm(),cond.getLeftType(),cond.getReOp(),cond.getRightTerm(),cond.getRightType(),"condition",userName);
		for(int i=0;i<ifCondList.size();i++)
		{
			DBUtils.executeUpdate1(sql,axIndex,eqIndex,subEqIndex,i,specID ,subSpecID,sortName,ifCondList.get(i).getLeftTerm(),ifCondList.get(i).getLeftType(),ifCondList.get(i).getReOp(),ifCondList.get(i).getRightTerm(),ifCondList.get(i).getRightType(),"ifcondition",userName);
		}
	}
}
