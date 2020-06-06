package com.doing.parse.dao;

import com.doing.parse.domain.DBUtils;
import com.doing.parse.domain.Ontology;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EvaluationDapImpl {

	public boolean save(String filepath,String username,String filename) throws SQLException{
		String[] array={username,filepath,filename};
		String[] pathArray={filepath};
		ResultSet res=(ResultSet) DBUtils.executeQuery("select * from ontologyfile where filePath=?",pathArray);
		if(!res.next())
		DBUtils.insert("insert into ontologyfile(username,filePath,filename) value(?,?,?)", array);
		return true;
	}
	public List<Ontology> getOnto(String username) throws SQLException{
		List<Ontology> ontoList=new ArrayList<Ontology>();
		String [] array={username};
		ResultSet result=(ResultSet) DBUtils.executeQuery("select * from ontologyfile where username=?",array);
		while(result.next()){
			Ontology ontology = new Ontology();
			ontology.setName(result.getString("filename"));
			ontology.setPath(result.getString("filePath"));
			ontoList.add(ontology);
		}
		return ontoList;
	}
	public boolean isExit(String filepath) throws SQLException{
		String [] array = {filepath};
		ResultSet result=(ResultSet) DBUtils.executeQuery("select * from ontologyfile where filePath=?",array);
		if(result.next())
			return true;
		else
			return false;
	}
}
