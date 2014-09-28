package org.sca.sca.model;

import java.util.LinkedList;
import java.util.List;

public class EventModel {

	private String mId_event =null;
	private String mName_event=null;
	private String mDate_i_event = null;
	private String mDate_e_event= null;
	private String mDate_pi_event = null;
	private String mDate_pe_event = null;
	private String mDesc_event = null;
	private String mHasimg_event = null;
	private String mExtimg_event = null;
	private String mId_frame_event = null;
	List<String> mImages = new LinkedList<String>();
	List<String> mExtimg_frame_event = new LinkedList<String>();
	List<String> mImg = new LinkedList<String>();
	public EventModel(String id_event, String name_event, String date_i_event,
			String date_e_event, String date_pi_event, String date_pe_event,
			String desc_event, String hasimg_event, String extimg_event,
			String id_frame_event, List<String> images,
			List<String> extimg_frame_event, List<String> img) {
		super();
		mId_event = id_event;
		mName_event = name_event;
		mDate_i_event = date_i_event;
		mDate_e_event = date_e_event;
		mDate_pi_event = date_pi_event;
		mDate_pe_event = date_pe_event;
		mDesc_event = desc_event;
		mHasimg_event = hasimg_event;
		mExtimg_event = extimg_event;
		mId_frame_event = id_frame_event;
		mImages = images;
		mExtimg_frame_event = extimg_frame_event;
		mImg = img;
	}
	public String getId_event() {
		return mId_event;
	}
	public void setId_event(String id_event) {
		mId_event = id_event;
	}
	public String getName_event() {
		return mName_event;
	}
	public void setName_event(String name_event) {
		mName_event = name_event;
	}
	public String getDate_i_event() {
		return mDate_i_event;
	}
	public void setDate_i_event(String date_i_event) {
		mDate_i_event = date_i_event;
	}
	public String getDate_e_event() {
		return mDate_e_event;
	}
	public void setDate_e_event(String date_e_event) {
		mDate_e_event = date_e_event;
	}
	public String getDate_pi_event() {
		return mDate_pi_event;
	}
	public void setDate_pi_event(String date_pi_event) {
		mDate_pi_event = date_pi_event;
	}
	public String getDate_pe_event() {
		return mDate_pe_event;
	}
	public void setDate_pe_event(String date_pe_event) {
		mDate_pe_event = date_pe_event;
	}
	public String getDesc_event() {
		return mDesc_event;
	}
	public void setDesc_event(String desc_event) {
		mDesc_event = desc_event;
	}
	public String getHasimg_event() {
		return mHasimg_event;
	}
	public void setHasimg_event(String hasimg_event) {
		mHasimg_event = hasimg_event;
	}
	public String getExtimg_event() {
		return mExtimg_event;
	}
	public void setExtimg_event(String extimg_event) {
		mExtimg_event = extimg_event;
	}
	public String getId_frame_event() {
		return mId_frame_event;
	}
	public void setId_frame_event(String id_frame_event) {
		mId_frame_event = id_frame_event;
	}
	
	
	
	

		
	
}
