package com.doing.parse.asParse;

import java.util.ArrayList;

public class EquationSysTab {
	ArrayList<CondEquation> condEquas;
	ArrayList<LetEquation> letEquas;
	
	public EquationSysTab()
	{
		condEquas=new ArrayList<CondEquation>();
		letEquas=new ArrayList<LetEquation>();
	}
	
	public void addConEqua(CondEquation ce)
	{
		condEquas.add(ce);
	}
	
	public void addLetEqua(LetEquation le)
	{
		letEquas.add(le);
	}
	
	public void writeAxiomToDB(String specID,String subSpecID,String sortName,int axIndex,int eqIndex,String userName)
	{
		//局部var和等式写到数据库	
		for(int i=0;i<letEquas.size();i++)   
		{
			letEquas.get(i).writeAxiomToDB(specID,subSpecID, sortName,axIndex, eqIndex,userName);
		}
		for(int i=0;i<condEquas.size();i++)
		{
			condEquas.get(i).writeAxiomToDB(specID,subSpecID, sortName,axIndex, eqIndex,userName);
		}
	}
}
