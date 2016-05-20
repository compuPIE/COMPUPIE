package pages.helper;

import java.util.ArrayList;
import java.util.List;

import daoBean.Factor1Bean;
import daoBean.Factor2Bean;
import daoBean.Factor3Bean;
import daoBean.Factor4Bean;
import pages.Home;

public class Validator {

	Home page;

	List<String> msgs = new ArrayList<String>();

	public Validator(Home pag) {
		this.page = pag;
		validateFactor1();
		validateFactor2();
		validateFactor3();
		validateFactor4();
	}

	/**
	 * @return the msgs
	 */
	public List<String> getMsgs() {
		return msgs;
	}

	/**
	 * @param msgs
	 *            the msgs to set
	 */
	public void setMsgs(List<String> msgs) {
		this.msgs = msgs;
	}

	private void validateFactor1() {
		if (page.pages_1.getPanel1().isHasToUpdate()) {
			Factor1Bean bean = page.pages_1.getPanel1().getCurrentValues();
			if (bean.getSocialRoleDescription().equalsIgnoreCase("Select")) {
				msgs.add("Factor 1: Select Social Role Description");
			}
			if (bean.getProblemType().equalsIgnoreCase("Select")) {
				msgs.add("Factor 1: Select Problem type");
			}
			if (bean.getSocialRoleProblemType().equalsIgnoreCase("Select")) {
				msgs.add("Factor 1: Select Social Role problem type");
			}
			if (bean.getCopingAbitity().equalsIgnoreCase("Select")) {
				msgs.add("Factor 1: Select Coping ability");
			}
			if (bean.getDuration().equalsIgnoreCase("Select")) {
				msgs.add("Factor 1: Select Duration");
			}
			if (bean.getPriority().equalsIgnoreCase("Select")) {
				msgs.add("Factor 1: Select priority");
			}
			if (bean.getServerity().equalsIgnoreCase("Select")) {
				msgs.add("Factor 1: Select Severity");
			}
		}
	}

	private void validateFactor2() {
		if (page.pages_1.getPanel2().isHasToUpdate()) {
			Factor2Bean bean = page.pages_1.getPanel2().getCurrentValues();
			if (bean.getProblemCategory().equalsIgnoreCase("Select")) {
				msgs.add("Factor 2: Select Problem category");
			}
			if (bean.getProblemType().equalsIgnoreCase("Select")) {
				msgs.add("Factor 2: Select Problem type");
			}
			if (bean.getCopingAbitity().equalsIgnoreCase("Select")) {
				msgs.add("Factor 2: Select Coping ability");
			}
			if (bean.getDuration().equalsIgnoreCase("Select")) {
				msgs.add("Factor 2: Select Duration");
			}
			if (bean.getPriority().equalsIgnoreCase("Select")) {
				msgs.add("Factor 2: Select priority");
			}
			if (bean.getServerity().equalsIgnoreCase("Select")) {
				msgs.add("Factor 2: Select Severity");
			}

		}
		page.pages_1.getPanel2().setHasToUpdate(false);
	}

	private void validateFactor3() {
		if (page.pages_1.getPanel3().isHasToUpdate()) {
			Factor3Bean bean = page.pages_1.getPanel3().getCurrentValues();
			if (bean.getdsmDiagnosis().equalsIgnoreCase("Select")) {
				msgs.add("Factor 3: Select Diagnosis");
			}
			if (bean.getdiagnosisSource().equalsIgnoreCase("Select")) {
				msgs.add("Factor 3: Select Diagnosis source");
			}
			if (bean.getCopingAbitity().equalsIgnoreCase("Select")) {
				msgs.add("Factor 3: Select Coping ability");
			}
			if (bean.getDuration().equalsIgnoreCase("Select")) {
				msgs.add("Factor 3: Select Duration");
			}
			if (bean.getPriority().equalsIgnoreCase("Select")) {
				msgs.add("Factor 3: Select priority");
			}
			if (bean.getServerity().equalsIgnoreCase("Select")) {
				msgs.add("Factor 3: Select Severity");
			}
		}
	}

	private void validateFactor4() {
		if (page.pages_1.getPanel4().isHasToUpdate()) {
			Factor4Bean bean = page.pages_1.getPanel4().getCurrentValues();
			if (bean.getDiagnosis().equalsIgnoreCase("Select")) {
				msgs.add("Factor 4: Select Diagnosis");
			}
			if (bean.getdiagnosisSource().equalsIgnoreCase("Select")) {
				msgs.add("Factor 4: Select Diagnosis source");
			}
			if (bean.getCopingAbitity().equalsIgnoreCase("Select")) {
				msgs.add("Factor 4: Select Coping ability");
			}
			if (bean.getDuration().equalsIgnoreCase("Select")) {
				msgs.add("Factor 4: Select Duration");
			}
			if (bean.getPriority().equalsIgnoreCase("Select")) {
				msgs.add("Factor 4: Select priority");
			}
			if (bean.getServerity().equalsIgnoreCase("Select")) {
				msgs.add("Factor 2: Select Severity");
			}
		}
	}
}
