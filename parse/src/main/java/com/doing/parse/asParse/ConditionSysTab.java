package com.doing.parse.asParse;

public class ConditionSysTab {
	String leftTerm;
	String rightTerm;
	String leftType;
	String rightType;
	String relationOp;	
	String connector;
	
	public ConditionSysTab()
	{
		leftTerm="";
		rightTerm="";
		leftType="";
		rightType="";
		relationOp="";
		connector="";
	}
	
	public void setLeftTerm(String term)
	{
		leftTerm=term;
	}
	
	public void setRightTerm(String term)
	{
		rightTerm=term;
	}
	
	public void setLeftType(String type)
	{
		leftType=type;
	}
	
	public void setRightType(String type)
	{
		rightType=type;
	}
	
	public void setReOp(String op)
	{
		relationOp=op;
	}
	
	public void setConnector(String c)
	{
		connector+=c;
	}
	
	public String getLeftTerm() 
	{
		return leftTerm;
	}

	public String getLeftType() 
	{
		return leftType;
	}
	
	public String getRightTerm() 
	{
		return rightTerm;
	}
	
	public String getRightType() 
	{
		return rightType;
	}
	
	public String getReOp() 
	{
		return relationOp;
	}
	public boolean checkType()
	{
		if(leftType.equalsIgnoreCase("Null")||rightType.equalsIgnoreCase("Null"))
			return true;
		if(leftType.equalsIgnoreCase(rightType))
			return true;
		else return false;
	}
	
}
