package com.doing.parse.asParse;


import com.doing.parse.domain.DBUtils;

import java.sql.ResultSet;
import java.util.ArrayList;

public class SpecSysTab {
	private String specID;        //当前specID
	private String subSpecID;     //当前subSpecID
	private String userID;
	private ArrayList<String> sortNL;  //spec中所有sort名
	private ArrayList<String> operNL;  //spec中所有oper名
	
	public SpecSysTab(){
		specID = "";
		subSpecID="";
		userID="";
		sortNL=new ArrayList<String>();
		operNL=new ArrayList<String>();
	}
	
	public SpecSysTab(String specID,String subSpecID,String userID)
	{
		this.specID=specID;
		this.subSpecID=subSpecID;
		this.userID=userID;
		sortNL=new ArrayList<String>();
		operNL=new ArrayList<String>();
	}
	
	public boolean isUniqSortName(String name)  //判断sort名是否唯一
	{
		if(sortNL.contains(name))
			return false;
		else
			return true;
	}
	
	public boolean isUniqOperName(String name) //判断oper名是否唯一
	{
		if(operNL.contains(name))
			return false;
		else 
			return true;
	}
	
	public boolean addUniqSN(String sortName)   //将sort名add到其数组
	{
		if(isUniqSortName(sortName)&isUniqOperName(sortName))
		{
			sortNL.add(sortName);
			return true;
		}
		else 
			return false;
	}
	
	public void addOperName(String operName)   //将oper名add到其数组
	{
		operNL.add(operName);
	}
	
	public void clear()  //清空数据库中该specID、subSpecID中已经有的内容
	{
		String sql;
		sql="delete from sort where SpecID=? and SubSpecID=? and username=?";
		DBUtils.executeUpdate(sql, specID,subSpecID,userID);
		sql="delete from sort where SpecID=? and SubSpecID=?and username=?";
		DBUtils.executeUpdate(sql, specID,subSpecID,userID);
		sql="delete from sortrelation where SpecID=? and SubSpecID=?and username=?";
		DBUtils.executeUpdate(sql, specID,subSpecID,userID);
		sql="delete from operator where SpecID=? and SubSpecID=?and username=?";
		DBUtils.executeUpdate(sql, specID,subSpecID,userID);
		sql="delete from opdomain where SpecID=? and SubSpecID=?and username=?";
		DBUtils.executeUpdate(sql, specID,subSpecID,userID);
		sql="delete from variable where SpecID=? and SubSpecID=?and username=?";
		DBUtils.executeUpdate(sql, specID,subSpecID,userID);
		sql="delete from equation where SpecID=? and SubSpecID=?and username=?";
		DBUtils.executeUpdate(sql, specID,subSpecID,userID);
	}
	
	//提取数据库中已有的该specID下不同的subspec文件中sortname和opername
	public void getExistSubSpec()   
	{
		String sql;
		ResultSet rs = null;
		
		sql="Select *  from sort where SpecID=?and username=?";
		String[] para = { specID ,userID};
		rs = DBUtils.executeQuery(sql, para);
		try {
			while (rs.next()) {
				String sortName=rs.getString("SID");
				if(!sortName.equals("definition"))
					sortNL.add(sortName);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.close(null, null, rs);
		}
		
		sql="Select *  from operator where SpecID=?and username=?";
		rs = DBUtils.executeQuery(sql, para);
		try {
			while (rs.next()) {
				String operName=rs.getString("OpID");
				operNL.add(operName);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.close(null, null, rs);
		}
		
	}
	
}
