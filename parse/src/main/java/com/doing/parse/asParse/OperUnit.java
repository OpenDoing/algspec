package com.doing.parse.asParse;

import com.doing.parse.domain.DBUtils;

import java.sql.ResultSet;
import java.util.ArrayList;

public class OperUnit {
	private String operName;
	private ArrayList<String> domainTL;
	private ArrayList<String> codomainTL;

	public OperUnit() {
		operName = new String();
		domainTL = new ArrayList<String>();
		codomainTL = new ArrayList<String>();
	}

	public void setOperName(String name) {
		operName = name;
	}

//	public boolean addDomainType(String type) {
//		if (domainTL.contains(type))
//			return false;
//		else {
//			domainTL.add(type);
//			return true;
//		}
		

    public void addDomainType(String type) {
				domainTL.add(type);
	}
    
    public void addCoDomainType(String type) {
				codomainTL.add(type);
	}

//
//	public boolean addCoDomainType(String type) {
//		if (codomainTL.contains(type))
//			return false;
//		else {
//			codomainTL.add(type);
//			return true;
//		}
//    }

	public String getOperName() {
		return operName;
	}
	
	public String getOperType()
	{
		System.out.println("operunit51:"+codomainTL.get(0));
		return codomainTL.get(0);
	}

	public void writeOpDomToDB(String specID, String subSpecID, String sortName,String userID) {
		String sql = "insert into opdomain(SpecID,SubSpecID,SID,OpID,Flag,Type,username,DomainIndex) values(?,?,?, ?,?, ?,? ,?)";
		for (int i = 0; i < domainTL.size(); i++) {
			DBUtils.InsertOpDomain(sql, i, specID, subSpecID, sortName,
					operName, "domain",domainTL.get(i),userID);
		}
		for (int i = 0; i < codomainTL.size(); i++) {
			DBUtils.InsertOpDomain(sql, i, specID, subSpecID, sortName,
					operName, "codomain", codomainTL.get(i),userID);
		}
	}

	public void readOpDomainFromDB(String specID, String subSpecID,String sortID, String OpID,String userID) {
		String sql = "Select *  from opdomain where username=? and SpecID=?  and SubSpecID=? and SID=? and OpID=? order by DomainIndex asc";
		System.out.println(userID+specID+ subSpecID+sortID+OpID);
		String para[] = {userID,specID, subSpecID, sortID, OpID };
		ResultSet rs = DBUtils.executeQuery(sql, para);
		try {
			while (rs.next()) {
				String flag = rs.getString("Flag");
				String type = rs.getString("Type");
				if (flag.equals("domain")) {
					domainTL.add(type);
				}
				if (flag.equals("codomain")) {
					System.out.println("81"+type);
					codomainTL.add(type);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.close(null, null, rs);
		}
	}
	
	public void readOpDomainFromDB(String specID, String sortID, String OpID,String userID) {
		String sql = "Select *  from opdomain where SpecID=? and SID=? and username=? and OpID=? order by DomainIndex asc";
		String para[] = { specID, sortID,userID, OpID };
		ResultSet rs = DBUtils.executeQuery(sql, para);
		try {
			while (rs.next()) {
				String flag = rs.getString("Flag");
				String type = rs.getString("Type");
				if (flag.equals("domain")) {
					domainTL.add(type);
				}
				if (flag.equals("codomain")) {
					codomainTL.add(type);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//DBUtils.close(null, null, rs);
			DBUtils.close( rs);  //20151023add
		}
	}
}
