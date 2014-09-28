package org.sca.sca.model;

import java.util.LinkedList;
import java.util.List;

public class ActivitiesModel {
	
	private String mId_activity = null;
	private String mTitle_activity = null;
	private String mHour_i_activity = null;
	private String mHour_f_activity = null;
	private String mDate_n_activity = null;
	private String mLocation_activity = null;
	private String mLat_activity = null;
	private String mLon_activity =null;
	private String mZoom_activity = null;
	private String mDesc_activity = null;
	private String mId_person_activity= null;
	private String mName_person_activity= null;
	private String mLastname_person_activity = null;
	private String mId_event_activity =null ;
	private String mName_event_activity= null;
	private String mHasimg_activity =null;
	private String mExtimg_activity = null;
	private String mInx_day = null;
	List<String> mEventimages = new LinkedList<String>();
	private String mHour_i_activity_format = null;
	private String mHour_f_activity_format = null;
	public ActivitiesModel(String id_activity, String title_activity,
			String hour_i_activity, String hour_f_activity,
			String date_n_activity, String location_activity,
			String lat_activity, String lon_activity, String zoom_activity,
			String desc_activity, String id_person_activity,
			String name_person_activity, String lastname_person_activity,
			String id_event_activity, String name_event_activity,
			String hasimg_activity, String extimg_activity, String inx_day,
			List<String> eventimages, String hour_i_activity_format,
			String hour_f_activity_format) {
		super();
		mId_activity = id_activity;
		mTitle_activity = title_activity;
		mHour_i_activity = hour_i_activity;
		mHour_f_activity = hour_f_activity;
		mDate_n_activity = date_n_activity;
		mLocation_activity = location_activity;
		mLat_activity = lat_activity;
		mLon_activity = lon_activity;
		mZoom_activity = zoom_activity;
		mDesc_activity = desc_activity;
		mId_person_activity = id_person_activity;
		mName_person_activity = name_person_activity;
		mLastname_person_activity = lastname_person_activity;
		mId_event_activity = id_event_activity;
		mName_event_activity = name_event_activity;
		mHasimg_activity = hasimg_activity;
		mExtimg_activity = extimg_activity;
		mInx_day = inx_day;
		mEventimages = eventimages;
		mHour_i_activity_format = hour_i_activity_format;
		mHour_f_activity_format = hour_f_activity_format;
	}
	public String getId_activity() {
		return mId_activity;
	}
	public void setId_activity(String id_activity) {
		mId_activity = id_activity;
	}
	public String getTitle_activity() {
		return mTitle_activity;
	}
	public void setTitle_activity(String title_activity) {
		mTitle_activity = title_activity;
	}
	public String getHour_i_activity() {
		return mHour_i_activity;
	}
	public void setHour_i_activity(String hour_i_activity) {
		mHour_i_activity = hour_i_activity;
	}
	public String getHour_f_activity() {
		return mHour_f_activity;
	}
	public void setHour_f_activity(String hour_f_activity) {
		mHour_f_activity = hour_f_activity;
	}
	public String getDate_n_activity() {
		return mDate_n_activity;
	}
	public void setDate_n_activity(String date_n_activity) {
		mDate_n_activity = date_n_activity;
	}
	public String getLocation_activity() {
		return mLocation_activity;
	}
	public void setLocation_activity(String location_activity) {
		mLocation_activity = location_activity;
	}
	public String getLat_activity() {
		return mLat_activity;
	}
	public void setLat_activity(String lat_activity) {
		mLat_activity = lat_activity;
	}
	public String getLon_activity() {
		return mLon_activity;
	}
	public void setLon_activity(String lon_activity) {
		mLon_activity = lon_activity;
	}
	public String getZoom_activity() {
		return mZoom_activity;
	}
	public void setZoom_activity(String zoom_activity) {
		mZoom_activity = zoom_activity;
	}
	public String getDesc_activity() {
		return mDesc_activity;
	}
	public void setDesc_activity(String desc_activity) {
		mDesc_activity = desc_activity;
	}
	public String getId_person_activity() {
		return mId_person_activity;
	}
	public void setId_person_activity(String id_person_activity) {
		mId_person_activity = id_person_activity;
	}
	public String getName_person_activity() {
		return mName_person_activity;
	}
	public void setName_person_activity(String name_person_activity) {
		mName_person_activity = name_person_activity;
	}
	public String getLastname_person_activity() {
		return mLastname_person_activity;
	}
	public void setLastname_person_activity(String lastname_person_activity) {
		mLastname_person_activity = lastname_person_activity;
	}
	public String getId_event_activity() {
		return mId_event_activity;
	}
	public void setId_event_activity(String id_event_activity) {
		mId_event_activity = id_event_activity;
	}
	public String getName_event_activity() {
		return mName_event_activity;
	}
	public void setName_event_activity(String name_event_activity) {
		mName_event_activity = name_event_activity;
	}
	public String getHasimg_activity() {
		return mHasimg_activity;
	}
	public void setHasimg_activity(String hasimg_activity) {
		mHasimg_activity = hasimg_activity;
	}
	public String getExtimg_activity() {
		return mExtimg_activity;
	}
	public void setExtimg_activity(String extimg_activity) {
		mExtimg_activity = extimg_activity;
	}
	public String getInx_day() {
		return mInx_day;
	}
	public void setInx_day(String inx_day) {
		mInx_day = inx_day;
	}
	public String getHour_i_activity_format() {
		return mHour_i_activity_format;
	}
	public void setHour_i_activity_format(String hour_i_activity_format) {
		mHour_i_activity_format = hour_i_activity_format;
	}
	public String getHour_f_activity_format() {
		return mHour_f_activity_format;
	}
	public void setHour_f_activity_format(String hour_f_activity_format) {
		mHour_f_activity_format = hour_f_activity_format;
	}
	
	






}
