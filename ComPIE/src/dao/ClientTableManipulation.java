package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import daoBean.ClientBean;

public class ClientTableManipulation {

	Connection c = null;

	public void ClientTableManipulation() {
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:compuPIEMetaInfo.db");
			c.setAutoCommit(true);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public ClientBean getClientInfo(String id) {
		ClientTableManipulation();
		ClientBean info = new ClientBean();
		Statement stmt = null;
		ResultSet rs;
		try {
			stmt = c.createStatement();
			rs = stmt.executeQuery("SELECT * FROM CLIENT_INFO where id =" + id + ";");
			while (rs.next()) {
				info.setId(rs.getInt("id"));
				info.setCity(rs.getString("city"));
				info.setLastname(rs.getString("lastname"));
				info.setMiddleName(rs.getString("middlename"));
				info.setFirstname(rs.getString("firstname"));
				info.setClientId(rs.getString("clientId"));
				info.setGender(rs.getString("gender"));
				info.setMaritalStatus(rs.getString("maritalStatus"));
				info.setOccupatiion(rs.getString("occupatiion"));
				SimpleDateFormat sdf1 = new SimpleDateFormat("yyy-MM-dd");
				java.util.Date date = sdf1.parse(rs.getString("dob"));
				info.setDob(new Date(date.getTime()));
				info.setStreet(rs.getString("street"));
				info.setCity(rs.getString("city"));
				info.setStateName(rs.getString("stateName"));
				info.setZipcode(rs.getString("zipcode"));
				info.setPhone(rs.getString("phone"));
				info.setEthnicity(rs.getString("ethnicity"));
				info.setReferredBy(rs.getString("referredBy"));
				info.setAdditional(rs.getString("additional"));
				info.setNoOfChildrenInCare(rs.getInt("noOfChildrenInCare"));
				info.setEmploymentStatus(rs.getString("employmentStatus"));
				info.setHighestLevelOfEducation(rs.getString("highestLevelOfEducation"));
				info.setLivingArrangement(rs.getString("livingArrangement"));
				info.setAssessedBy(rs.getString("assessedBy"));
			}
			rs.close();
			stmt.close();
			c.close();
		} catch (SQLException | ParseException e) {
			e.printStackTrace();
		}

		return info;
	}

	public int getmaxId() {
		ClientTableManipulation();
		int id = 0;
		Statement stmt = null;
		ResultSet rs;
		try {
			stmt = c.createStatement();
			rs = stmt.executeQuery("SELECT max(id) FROM CLIENT_INFO;");
			while (rs.next()) {
				id = rs.getInt(1);
			}
			rs.close();
			stmt.close();
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	public boolean saveNewClient(ClientBean info) {
		ClientTableManipulation();
		Statement stmt = null;
		int update = 0;
		try {
			stmt = c.createStatement();
			update = stmt.executeUpdate(createStringTOSave(info));
			stmt.close();
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (update > 0);
	}

	public boolean updateNewClient(ClientBean info) {
		ClientTableManipulation();
		Statement stmt = null;
		int update = 0;
		try {
			stmt = c.createStatement();
			update = stmt.executeUpdate(createStringToUpdate(info));
			stmt.close();
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (update > 0);
	}

	private String createStringTOSave(ClientBean info) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(
				"insert into CLIENT_INFO (id,lastname,middlename,firstname,clientId,gender,maritalStatus,dob,occupatiion,street,city,stateName,zipcode,phone,ethnicity,referredBy,additional,"
						+ "noOfChildrenInCare,highestLevelOfEducation,employmentStatus,livingArrangement,assessedBy) values");
		buffer.append("(" + (getmaxId() + 1));
		buffer.append(",\"" + info.getLastname() + "\"");
		buffer.append(",\"" + info.getMiddleName() + "\"");
		buffer.append(",\"" + info.getFirstname() + "\"");
		buffer.append(",\"" + info.getClientId() + "\"");
		buffer.append(",\"" + info.getGender() + "\"");
		buffer.append(",\"" + info.getMaritalStatus() + "\"");
		buffer.append(",\"" + info.getDob() + "\"");
		buffer.append(",\"" + info.getOccupatiion() + "\"");
		buffer.append(",\"" + info.getStreet() + "\"");
		buffer.append(",\"" + info.getCity() + "\"");
		buffer.append(",\"" + info.getStateName() + "\"");
		buffer.append(",\"" + info.getZipcode() + "\"");
		buffer.append(",\"" + info.getPhone() + "\"");
		buffer.append(",\"" + info.getEthnicity() + "\"");
		buffer.append(",\"" + info.getReferredBy() + "\"");
		buffer.append(",\"" + info.getAdditional() + "\" ");
		buffer.append("," + info.getNoOfChildrenInCare());
		buffer.append(",\"" + info.getHighestLevelOfEducation() + "\"");
		buffer.append(",\"" + info.getEmploymentStatus() + "\"");
		buffer.append(",\"" + info.getLivingArrangement() + "\"");
		buffer.append(",\"" + info.getAssessedBy() + "\");");
		return buffer.toString();
	}

	private String createStringToUpdate(ClientBean info) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("update CLIENT_INFO set ");
		buffer.append("id=" + info.getId());
		buffer.append(",lastname=\"" + info.getLastname() + "\"");
		buffer.append(",middlename=\"" + info.getMiddleName() + "\"");
		buffer.append(",firstname=\"" + info.getFirstname() + "\"");
		buffer.append(",clientId=\"" + info.getClientId() + "\"");
		buffer.append(",gender=\"" + info.getGender() + "\"");
		buffer.append(",maritalStatus=\"" + info.getMaritalStatus() + "\"");
		buffer.append(",dob=\"" + info.getDob() + "\"");
		buffer.append(",occupatiion=\"" + info.getOccupatiion() + "\"");
		buffer.append(",street=\"" + info.getStreet() + "\"");
		buffer.append(",city=\"" + info.getCity() + "\"");
		buffer.append(",stateName=\"" + info.getStateName() + "\"");
		buffer.append(",zipcode=\"" + info.getZipcode() + "\"");
		buffer.append(",phone=\"" + info.getPhone() + "\"");
		buffer.append(",ethnicity=\"" + info.getEthnicity() + "\"");
		buffer.append(",referredBy=\"" + info.getReferredBy() + "\"");
		buffer.append(",additional=\"" + info.getAdditional() + "\" ");
		buffer.append(",noOfChildrenInCare=" + info.getNoOfChildrenInCare());
		buffer.append(",highestLevelOfEducation=\"" + info.getHighestLevelOfEducation() + "\"");
		buffer.append(",employmentStatus=\"" + info.getEmploymentStatus() + "\"");
		buffer.append(",livingArrangement=\"" + info.getLivingArrangement() + "\"");
		buffer.append(",assessedBy=\"" + info.getAssessedBy() + "\"");
		buffer.append(" where id =" + info.getId() + ";");
		return buffer.toString();
	}

}
