package com.doing.parse.asParse;

import java.util.ArrayList;

public class AxiomSet {
	ArrayList<AxiomUnit> axiomList;
	public AxiomSet()
	{
		axiomList=new ArrayList<AxiomUnit>();
	}
	
	public void addAxiomUnit(AxiomUnit au)
	{
		axiomList.add(au);
	}
	
	public void writeAxiomToDB(String specID,String subSpecID,String sortName,String userName)
	{
		for(int i=0;i<axiomList.size();i++)
		{
			axiomList.get(i).writeAxiomToDB(specID, subSpecID, sortName, i,userName);
		}
	}
}
