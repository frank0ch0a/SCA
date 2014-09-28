package org.sca.sca.model;

import java.util.LinkedList;
import java.util.List;

public class ContestModel {
	
	private String mIdContext = null;
	private String mName_contest = null;
	private String mDate_i_contest = null;
	private String mDate_e_contest= null;
	private String mDate_pi_contest = null;
	private String mDate_pf_contest = null;
	private String mUrl_contest = null;
	private String mDesc_contest = null;
	List<String> mImages = new LinkedList<String>();
	private String mDate_if_contest = null;
	private String mDate_ef_contest =null;
	public ContestModel(String idContext, String name_contest,
			String date_i_contest, String date_e_contest,
			String date_pi_contest, String date_pf_contest, String url_contest,
			String desc_contest, List<String> images, String date_if_contest,
			String date_ef_contest) {
		super();
		mIdContext = idContext;
		mName_contest = name_contest;
		mDate_i_contest = date_i_contest;
		mDate_e_contest = date_e_contest;
		mDate_pi_contest = date_pi_contest;
		mDate_pf_contest = date_pf_contest;
		mUrl_contest = url_contest;
		mDesc_contest = desc_contest;
		mImages = images;
		mDate_if_contest = date_if_contest;
		mDate_ef_contest = date_ef_contest;
	}
	public String getIdContext() {
		return mIdContext;
	}
	public void setIdContext(String idContext) {
		mIdContext = idContext;
	}
	public String getName_contest() {
		return mName_contest;
	}
	public void setName_contest(String name_contest) {
		mName_contest = name_contest;
	}
	public String getDate_i_contest() {
		return mDate_i_contest;
	}
	public void setDate_i_contest(String date_i_contest) {
		mDate_i_contest = date_i_contest;
	}
	public String getDate_e_contest() {
		return mDate_e_contest;
	}
	public void setDate_e_contest(String date_e_contest) {
		mDate_e_contest = date_e_contest;
	}
	public String getDate_pi_contest() {
		return mDate_pi_contest;
	}
	public void setDate_pi_contest(String date_pi_contest) {
		mDate_pi_contest = date_pi_contest;
	}
	public String getDate_pf_contest() {
		return mDate_pf_contest;
	}
	public void setDate_pf_contest(String date_pf_contest) {
		mDate_pf_contest = date_pf_contest;
	}
	public String getUrl_contest() {
		return mUrl_contest;
	}
	public void setUrl_contest(String url_contest) {
		mUrl_contest = url_contest;
	}
	public String getDesc_contest() {
		return mDesc_contest;
	}
	public void setDesc_contest(String desc_contest) {
		mDesc_contest = desc_contest;
	}
	public String getDate_if_contest() {
		return mDate_if_contest;
	}
	public void setDate_if_contest(String date_if_contest) {
		mDate_if_contest = date_if_contest;
	}
	public String getDate_ef_contest() {
		return mDate_ef_contest;
	}
	public void setDate_ef_contest(String date_ef_contest) {
		mDate_ef_contest = date_ef_contest;
	}
	
	
	
	

}
