package com.doing.parse.dao;


import com.doing.parse.domain.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpecDaoImpl {
	public boolean save(String specId,String filepath,String username,String subSpec) throws SQLException {
		String[] array={specId,filepath,username,subSpec};
		String[] arraySpec={specId,username};
		ResultSet result=(ResultSet) DBUtils.executeQuery("select * from spec where SpecID=? and username=?",arraySpec);
		if(!result.next())
		DBUtils.insert("insert into spec(SpecID,username) value(?,?)", arraySpec);
		String[] pathArray={filepath};
		ResultSet res=(ResultSet) DBUtils.executeQuery("select * from specification where filePath=?",pathArray);
		if(!res.next())
		DBUtils.insert("insert into specification(SpecID,filePath,username,subSpec) value(?,?,?,?)", array);
		return true;
	}
	public List<Spec> getSpec(String username) throws SQLException{
		List<Spec> specList=new ArrayList<Spec>();
		String [] array={username};
		ResultSet result=(ResultSet) DBUtils.executeQuery("select SpecID from spec where username=?",array);
		while(result.next()){
			Spec spec=new Spec();
			spec.setSpecid(result.getString("SpecID"));
			String [] subarray={username,spec.getSpecid()};
			ResultSet subres=(ResultSet) DBUtils.executeQuery("select filePath,subSpec from specification where username=? and SpecID=?",subarray);
			while(subres.next()){
				Subspec subspec=new Subspec();
				subspec.setName(subres.getString("subSpec"));
				subspec.setPath(subres.getString("filePath"));
				spec.getSubspec().add(subspec);
			}
			specList.add(spec);
		}
		return specList;
	}
	

	
	public boolean specIsExit(String filepath) throws SQLException{
		String [] array = {filepath};
		ResultSet result=(ResultSet) DBUtils.executeQuery("select * from specification where filePath=?",array);
		if(result.next())
			return true;
		else
			return false;
	}
	public boolean deleteSubSpec(String filepath){
		String [] array={filepath};
		boolean is=DBUtils.delete("delete from specification where filePath=?", array);
		return is;
	}
	public boolean deleteSpec(String specId){
		String [] array={specId};
		boolean is=DBUtils.delete("delete from specification where specID=?", array);
		boolean ist=DBUtils.delete("delete from spec where specID=?", array);
		return is||ist;
	}
		public List<Spec> getAxiomList(String username) throws SQLException{
		List<Spec> specList=new ArrayList<Spec>(); 
		String [] array={username};
		ResultSet result=(ResultSet) DBUtils.executeQuery("select SpecID from spec where username=?",array);
		while(result.next()){
			Spec spec=new Spec();
			spec.setSpecid(result.getString("SpecID"));
			String [] subarray={username,spec.getSpecid()};
			ResultSet subres=(ResultSet) DBUtils.executeQuery("select filePath,subSpec from specification where username=? and SpecID=?",subarray);
			while(subres.next()){
				Subspec subspec=new Subspec();
				subspec.setName(subres.getString("subSpec"));
				subspec.setPath(subres.getString("filePath"));
				spec.getSubspec().add(subspec);
				String [] sortarray={username,spec.getSpecid(),subspec.getName()};
				ResultSet sort=(ResultSet) DBUtils.executeQuery("select DISTINCT SID from sort where username=? and SpecID=? and SubSpecID=?",sortarray);
				while (sort.next()) {
					Sid sid=new Sid();
					String sortname=sort.getString("SID");
					sid.setName(sortname);
					subspec.getSid().add(sid);
					String [] axiomarray={username,spec.getSpecid(),subspec.getName(),sortname};
					ResultSet axiom=(ResultSet) DBUtils.executeQuery("select DISTINCT AxIndex from equation where username=? and SpecID=? and SubSpecID=? and SID=?",axiomarray);
					while (axiom.next()) {
						String axindex=axiom.getString("AxIndex");
						Axiom axiom2=new Axiom();
						axiom2.setName(axindex);
						sid.getAxioms().add(axiom2);
						String [] equarray={username,spec.getSpecid(),subspec.getName(),sortname,axindex};
						ResultSet equ=(ResultSet) DBUtils.executeQuery("select DISTINCT EqIndex from equation where username=? and SpecID=? and SubSpecID=? and SID=? and AxIndex=?",equarray);
						while (equ.next()) {
							String equa=equ.getString("EqIndex");
							Equation equation=new Equation();
							equation.setName(equa);
							axiom2.getEquations().add(equation);
				
						}
					}
				}
			}
			specList.add(spec);
		}
		return specList;
	}

		
}
