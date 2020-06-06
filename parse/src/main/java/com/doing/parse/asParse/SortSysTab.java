package com.doing.parse.asParse;

import com.doing.parse.domain.DBUtils;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SortSysTab {
	String sortName;
	String obOpName;
	ArrayList<String> exSortNL;
	ArrayList<String> usSortNL;
	ArrayList<String> opNL;
	ArrayList<String> constOpNL;
	ArrayList<AttrUnit> attrOpUL;
	ArrayList<OperUnit> operOpUL;
	ArrayList<AxiomSet> axUL;
	
	public SortSysTab()
	{
		sortName="";
		obOpName="null";
		exSortNL=new ArrayList<String>();
		usSortNL=new ArrayList<String>();
		opNL=new ArrayList<String>();
		constOpNL=new ArrayList<String>();
		attrOpUL=new ArrayList<AttrUnit>();
		operOpUL=new ArrayList<OperUnit>();
		axUL=new ArrayList<AxiomSet>();
	}
	
	public SortSysTab(String name)
	{
		sortName=name;
		obOpName="null";
		exSortNL=new ArrayList<String>();
		usSortNL=new ArrayList<String>();
		opNL=new ArrayList<String>();
		constOpNL=new ArrayList<String>();
		attrOpUL=new ArrayList<AttrUnit>();
		operOpUL=new ArrayList<OperUnit>();
		axUL=new ArrayList<AxiomSet>();
	}
	
	public void setSortName(String sortName)
	{
		this.sortName=sortName;
	}
	
	public String getSortName()
	{
		return sortName;
	}
	
	public void setObOpName(String obOpName)
	{
		this.obOpName=obOpName;
	}
	
	public boolean addUniqSortToList(ArrayList<String> ALS,String s)
	{
		if(ALS.contains(s))
			return false;
		else {
			ALS.add(s);
			return true;
		} 	
	}
	
	public boolean addUniqUsSortToList(String sortName)
	{
		return addUniqSortToList(usSortNL,sortName);
	}
	
	public boolean addUniqExSortToList(String sortName)
	{
		return addUniqSortToList(exSortNL,sortName);
	}
	
	public boolean checkOpName(String name)
	{
		if(opNL.contains(name))
			return false;
		else 
		{
			opNL.add(name);
			return true;
		}
	}
	
	public void addConstOpName(String name)
	{
		constOpNL.add(name);	
	}
	
	public void addAttrOpUnit(AttrUnit au)
	{
		attrOpUL.add(au);
	}
	
	public boolean checkOpType(String type)                //检查attr操作的类型是否合法（基本数据类型或void或当前类子名或已经声明过的类子名）
	{
		if (type.equals("void")|type.equals(sortName))
			return true;
		else {
			for(int i=0;i<exSortNL.size();i++)
				if(type.equals(exSortNL.get(i))) return true;
			for(int i=0;i<usSortNL.size();i++)
				if(type.equals(usSortNL.get(i))) return true;
			return false;
		}
	}
	
	public boolean checkVarType(String type)                //检查变量类型是否合法
	{
		if (type.equals(sortName))
			return true;
		else {
			for(int i=0;i<exSortNL.size();i++)
				if(type.equals(exSortNL.get(i))) return true;
			for(int i=0;i<usSortNL.size();i++)
				if(type.equals(usSortNL.get(i))) return true;
			return false;
		}
	}

	public void setAttrOpType(String type)
	{
		for(int i=attrOpUL.size()-1;i>=0&&attrOpUL.get(i).getAttrType().equals("");i--)
		{
			attrOpUL.get(i).setTypeName(type);
		}
	}
	
	public void addOperOp(OperUnit ou)
	{
		operOpUL.add(ou);
	}
	
	public boolean isSort(String s)
	{
		if(sortName.equals(s))
			return true;
		else
			return false;
	}
	
	public String checkThisOperType(String s)
	{
		for(int i=0;i<constOpNL.size();i++)
		{
			if(constOpNL.get(i).equals(s))
				{return "ConstOp";}
		}
		for(int i=0;i<attrOpUL.size();i++)
		{
			if(attrOpUL.get(i).getAttrName().equals(s))
			{return attrOpUL.get(i).getAttrType();}
		}
		for(int i=0;i<operOpUL.size();i++)
		{
			if(operOpUL.get(i).getOperName().equals(s))
			{System.out.println("sortSysTab166"+operOpUL.get(i).getOperName());
				System.out.println("sortSysTab166"+operOpUL.get(i).getOperType());
				return operOpUL.get(i).getOperType();}
		}
		return "unknownOp!";
	}
	
	public String checkOperType(String s,String specID,String userID)    //检查类型
	{
		Queue<String> queue;
		queue=new  LinkedList<String>(); 
		for(int i=0;i<exSortNL.size();i++)
		{
			System.out.println(exSortNL.get(i));
			queue.add(exSortNL.get(i));
		}
		String type=checkThisOperType(s);
		while(type.equals("unknownOp!")&&!queue.isEmpty())
		{
			String tps=queue.poll();
			SortSysTab tpSortST=new SortSysTab();
			tpSortST.setSortName(tps);
			tpSortST.readSigFromDB(specID,userID);
			for (int i = 0; i < tpSortST.exSortNL.size(); i++) {
				queue.add(tpSortST.exSortNL.get(i));
			}
			type=tpSortST.checkThisOperType(s);
		}
		if(type.equals("unknownOp!"))            //判断是不是Definition中定义的公共类型
		{
			String tps="Definition";
			SortSysTab tpSortST=new SortSysTab();
			tpSortST.setSortName(tps);
			tpSortST.readSigFromDB(specID,userID);
			type=tpSortST.checkThisOperType(s);
		}
		return type;
	}
	
	public void addAxUnit(AxiomSet as)
	{
		axUL.add(as);
	}
	
	public void writeSortToDB(String specID,String subSpecID,String userID)
	{
		String sql;
		sql = "insert into sort(SpecID,SubSpecID,SID,ObserveOpID,username) values(?,?, ?, ?,? )";
		DBUtils.executeUpdate(sql,specID ,subSpecID,sortName, obOpName,userID);
		//extends和uses关系存入sortrelation表
		for(int i=0;i<exSortNL.size();i++)
		{
			sql= "insert into sortrelation(SpecID,SubSpecID,SID,RelatedSID,Flag,username) values(?,?, ?, ?,? ,?)";
			DBUtils.executeUpdate(sql,specID ,subSpecID,sortName,exSortNL.get(i),"extends",userID);
		}
		for(int i=0;i<usSortNL.size();i++)
		{
			sql= "insert into sortrelation(SpecID,SubSpecID,SID,RelatedSID,Flag,username) values(?,?, ?, ?,? ,?)";
			DBUtils.executeUpdate(sql,specID ,subSpecID,sortName,usSortNL.get(i),"uses",userID);
		}	
		//const操作存入operator表
		for(int i=0;i<constOpNL.size();i++)
		{
			sql= "insert into operator(SpecID,SubSpecID,SID,OpID,Flag,Type,username) values(?,?,?, ?, ?,? ,?)";
			DBUtils.executeUpdate(sql,specID ,subSpecID,sortName,constOpNL.get(i),"constant","NULL",userID);
		}
		for(int i=0;i<attrOpUL.size();i++)
		{
			sql= "insert into operator(SpecID,SubSpecID,SID,OpID,Flag,Type,OpIndex,username) values(?,?,?, ?, ?,? ,?,?)";
			DBUtils.executeUpdate(sql,specID ,subSpecID,sortName,attrOpUL.get(i).getAttrName(),"attribute",attrOpUL.get(i).getAttrType(),attrOpUL.get(i).getAttrIndexString(),userID);
		}
		for(int i=0;i<operOpUL.size();i++)
		{
			sql= "insert into operator(SpecID,SubSpecID,SID,OpID,Flag,Type,username) values(?,?,?, ?, ?,? ,?)";
			DBUtils.executeUpdate(sql,specID ,subSpecID,sortName,operOpUL.get(i).getOperName(),"general","NULL",userID);
			operOpUL.get(i).writeOpDomToDB(specID ,subSpecID,sortName,userID);
		}
		for(int i=0;i<axUL.size();i++)
		{
			axUL.get(i).writeAxiomToDB(specID ,subSpecID,sortName,userID);
		}
	}

	public void readSigFromDB(String specID,String subSpecID,String userID)  //从数据库衷读取当前类子的基调
	{

		String sql;
		ResultSet rs = null;
		//给observeOpID赋值
		sql="Select *  from sort where SpecID=? and SubSpecID=? and SID=? and username=?";
		String[] para = { specID,subSpecID,sortName,userID};
		rs = DBUtils.executeQuery(sql, para);
		try {
			while (rs.next()) {
				obOpName=rs.getString("observeOpID");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.close(rs);
		}
		//给usSortNL和exSortNL赋值
		sql="Select *  from sortrelation where SpecID=?  and SubSpecID=? and SID=? and username=?";
		rs = DBUtils.executeQuery(sql, para);
		try {
			while (rs.next()) {
				String flag=rs.getString("Flag");
				String relatedId=rs.getString("RelatedSID");
				if(flag.equals("uses"))
				{
					usSortNL.add(relatedId);
				}
				if(flag.equals("extends"))
				{
					exSortNL.add(relatedId);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.close( rs);
		}
		//给各种操作赋值
		sql="Select *  from operator where SpecID=?and SubSpecID=? and SID=? and username=?";
		rs = DBUtils.executeQuery(sql, para);
		try {
			while (rs.next()) {
				String opId=rs.getString("OpID");
				String flag=rs.getString("Flag");
				if(flag.equals("constant"))
				{
					opNL.add(opId);
					constOpNL.add(opId);
				}
				if(flag.equals("attribute"))
				{
					opNL.add(opId);
					AttrUnit au= new AttrUnit();
					au.setAttrName(opId);
					au.setTypeName(rs.getString("Type"));
					au.setIndexString(rs.getString("OpIndex"));
					attrOpUL.add(au);
				}
				if (flag.equals("general")) {
					opNL.add(opId);
					OperUnit ou=new OperUnit();
					ou.setOperName(opId);
					System.out.println("sortst315"+specID+subSpecID+sortName+opId+userID);
					ou.readOpDomainFromDB(specID,subSpecID,sortName,opId,userID);
					operOpUL.add(ou);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.close( rs);
		}
	}
	
	public void readSigFromDB(String specID,String userID)  //从数据库衷读取当前类子的基调
	{

		String sql;
		ResultSet rs = null;
		//给observeOpID赋值
		sql="Select *  from sort where SpecID=? and SID=? and username=?";
		String[] para = { specID,sortName,userID };
		rs = DBUtils.executeQuery(sql, para);
		try {
			while (rs.next()) {
				obOpName=rs.getString("observeOpID");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.close(rs);
		}
		//给usSortNL和exSortNL赋值
		sql="Select *  from sortrelation where SpecID=? and SID=? and username=?";
		rs = DBUtils.executeQuery(sql, para);
		try {
			while (rs.next()) {
				String flag=rs.getString("Flag");
				String relatedId=rs.getString("RelatedSID");
				if(flag.equals("uses"))
				{
					usSortNL.add(relatedId);
				}
				if(flag.equals("extends"))
				{
					exSortNL.add(relatedId);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.close(rs);
		}
		//给各种操作赋值
		sql="Select *  from operator where SpecID=?and SID=?and username=?";
		rs = DBUtils.executeQuery(sql, para);
		try {
			while (rs.next()) {
				String opId=rs.getString("OpID");
				String flag=rs.getString("Flag");
				if(flag.equals("constant"))
				{
					opNL.add(opId);
					constOpNL.add(opId);
				}
				if(flag.equals("attribute"))
				{
					opNL.add(opId);
					AttrUnit au= new AttrUnit();
					au.setAttrName(opId);
					au.setTypeName(rs.getString("Type"));
					au.setIndexString(rs.getString("OpIndex"));
					attrOpUL.add(au);
				}
				if (flag.equals("general")) {
					opNL.add(opId);
					OperUnit ou=new OperUnit();
					ou.setOperName(opId);
					ou.readOpDomainFromDB(specID,sortName,opId,userID);
					operOpUL.add(ou);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.close(rs);
		}
	}
}