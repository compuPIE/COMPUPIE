package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import daoBean.CaseHistoryBean;

public class CaseHistoryTableManipulation {
	Connection c = null;

	public CaseHistoryTableManipulation() {
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:compuPIEMetaInfo.db");
			c.setAutoCommit(true);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public CaseHistoryBean getClientInfo(String id) {

		CaseHistoryBean info = new CaseHistoryBean();
		Statement stmt = null;
		ResultSet rs;
		try {
			stmt = c.createStatement();
			rs = stmt.executeQuery("SELECT * FROM CASE_HISTORY where clientId =" + id + ";");
			while (rs.next()) {
				info.setId(rs.getInt("id"));
				info.setCurrentSituation(rs.getString("currentSituation"));
				info.setClientId(rs.getString("clientId"));
				info.setReasonForRefer(rs.getString("reasonForRefer"));
				info.setRelevantHistory(rs.getString("relevantHistory"));
				info.setTraumaHistory(rs.getString("traumaHistory"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return info;
	}

	public int getmaxId() {
		int id = 0;
		Statement stmt = null;
		ResultSet rs;
		try {
			stmt = c.createStatement();
			rs = stmt.executeQuery("SELECT max(id) FROM CASE_HISTORY;");
			while (rs.next()) {
				id = rs.getInt(1);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	public boolean saveNewClient(CaseHistoryBean info) {
		Statement stmt = null;
		int update = 0;
		try {
			stmt = c.createStatement();
			update = stmt.executeUpdate(createStringTOSave(info));
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (update > 0);
	}

	public boolean updateNewClient(CaseHistoryBean info) {
		Statement stmt = null;
		int update = 0;
		try {
			stmt = c.createStatement();
			update = stmt.executeUpdate(createStringToUpdate(info));
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (update > 0);
	}

	private String createStringTOSave(CaseHistoryBean info) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(
				"insert into CASE_HISTORY (id,clientId,reasonForRefer,currentSituation,relevantHistory,traumaHistory) ");
		buffer.append("(" + getmaxId() + 1);
		buffer.append("," + info.getClientId());
		buffer.append(",\"" + info.getReasonForRefer() + "\"");
		buffer.append(",\"" + info.getCurrentSituation()+ "\"");
		buffer.append(",\"" + info.getRelevantHistory() + "\"");
		buffer.append(",\"" + info.getTraumaHistory() + "\");");
		return buffer.toString();
	}

	private String createStringToUpdate(CaseHistoryBean info) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("update CASE_HISTORY set ");
		buffer.append(",clientId=" + info.getClientId());
		buffer.append(",reasonForRefer=\"" + info.getReasonForRefer() + "\"");
		buffer.append(",currentSituation=\"" + info.getCurrentSituation()+ "\"");
		buffer.append(",relevantHistory=\"" + info.getRelevantHistory() + "\"");
		buffer.append(",traumaHistory=\"" + info.getTraumaHistory() + "\"");
		buffer.append(" where id =" + info.getId()+";");
		return buffer.toString();
	}

}
