package daoBean;

public class CaseHistoryBean {

	private int id;
	private String clientId;
	private String reasonForRefer;
	private String currentSituation;
	private String relevantHistory;
	private String traumaHistory;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the clientId
	 */
	public String getClientId() {
		return clientId;
	}
	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	/**
	 * @return the reasonForRefer
	 */
	public String getReasonForRefer() {
		return reasonForRefer;
	}
	/**
	 * @param reasonForRefer the reasonForRefer to set
	 */
	public void setReasonForRefer(String reasonForRefer) {
		this.reasonForRefer = reasonForRefer;
	}
	/**
	 * @return the currentSituation
	 */
	public String getCurrentSituation() {
		return currentSituation;
	}
	/**
	 * @param currentSituation the currentSituation to set
	 */
	public void setCurrentSituation(String currentSituation) {
		this.currentSituation = currentSituation;
	}
	/**
	 * @return the relevantHistory
	 */
	public String getRelevantHistory() {
		return relevantHistory;
	}
	/**
	 * @param relevantHistory the relevantHistory to set
	 */
	public void setRelevantHistory(String relevantHistory) {
		this.relevantHistory = relevantHistory;
	}
	/**
	 * @return the traumaHistory
	 */
	public String getTraumaHistory() {
		return traumaHistory;
	}
	/**
	 * @param traumaHistory the traumaHistory to set
	 */
	public void setTraumaHistory(String traumaHistory) {
		this.traumaHistory = traumaHistory;
	}
}
