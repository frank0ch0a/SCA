package org.sca.sca.model;

import java.io.Serializable;

public class ContestModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8951303072336630835L;
	private String mIdContext = null;
	private String mName_contest = null;
	private String mDate_i_contest = null;
	private String mDate_e_contest = null;
	private String mDate_pi_contest = null;
	private String mDate_pf_contest = null;
	private String mUrl_contest = null;
	private String mDesc_contest = null;
	private String mDate_if_contest = null;
	private String mDate_ef_contest = null;
	private String mBig;
	private String mT01;
	private String mT02;
	private String mT03;

	public ContestModel() {
	}

	public String getmIdContext() {
		return mIdContext;
	}

	public void setmIdContext(String mIdContext) {
		this.mIdContext = mIdContext;
	}

	public String getmName_contest() {
		return mName_contest;
	}

	public void setmName_contest(String mName_contest) {
		this.mName_contest = mName_contest;
	}

	public String getmDate_i_contest() {
		return mDate_i_contest;
	}

	public void setmDate_i_contest(String mDate_i_contest) {
		this.mDate_i_contest = mDate_i_contest;
	}

	public String getmDate_e_contest() {
		return mDate_e_contest;
	}

	public void setmDate_e_contest(String mDate_e_contest) {
		this.mDate_e_contest = mDate_e_contest;
	}

	public String getmDate_pi_contest() {
		return mDate_pi_contest;
	}

	public void setmDate_pi_contest(String mDate_pi_contest) {
		this.mDate_pi_contest = mDate_pi_contest;
	}

	public String getmDate_pf_contest() {
		return mDate_pf_contest;
	}

	public void setmDate_pf_contest(String mDate_pf_contest) {
		this.mDate_pf_contest = mDate_pf_contest;
	}

	public String getmUrl_contest() {
		return mUrl_contest;
	}

	public void setmUrl_contest(String mUrl_contest) {
		this.mUrl_contest = mUrl_contest;
	}

	public String getmDesc_contest() {
		return mDesc_contest;
	}

	public void setmDesc_contest(String mDesc_contest) {
		this.mDesc_contest = mDesc_contest;
	}

	public String getmDate_if_contest() {
		return mDate_if_contest;
	}

	public void setmDate_if_contest(String mDate_if_contest) {
		this.mDate_if_contest = mDate_if_contest;
	}

	public String getmDate_ef_contest() {
		return mDate_ef_contest;
	}

	public void setmDate_ef_contest(String mDate_ef_contest) {
		this.mDate_ef_contest = mDate_ef_contest;
	}

	public String getmBig() {
		return ActivitiesModel.IMAGE_URL + mBig;
	}

	public void setmBig(String mBig) {
		this.mBig = mBig;
	}

	public String getmT01() {
		return ActivitiesModel.IMAGE_URL + mT01;
	}

	public void setmT01(String mT01) {
		this.mT01 = mT01;
	}

	public String getmT02() {
		return ActivitiesModel.IMAGE_URL + mT02;
	}

	public void setmT02(String mT02) {
		this.mT02 = mT02;
	}

	public String getmT03() {
		return ActivitiesModel.IMAGE_URL + mT03;
	}

	public void setmT03(String mT03) {
		this.mT03 = mT03;
	}

}
