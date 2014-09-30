package org.sca.sca.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class ActivitiesModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8600066343877655717L;

	public static final String IMAGE_URL = "http://sca-events.s3.amazonaws.com";

	private String mId_activity = null;
	private String mTitle_activity = null;
	private String mHour_i_activity = null;
	private String mHour_f_activity = null;
	private String mDate_n_activity = null;
	private String mLocation_activity = null;
	private String mLat_activity = null;
	private String mLon_activity = null;
	private String mZoom_activity = null;
	private String mDesc_activity = null;
	private String mId_person_activity = null;
	private String mName_person_activity = null;
	private String mLastname_person_activity = null;
	private String mId_event_activity = null;
	private String mName_event_activity = null;
	private String mHasimg_activity = null;
	private String mExtimg_activity = null;
	private String mInx_day = null;
	List<String> mEventimages = new LinkedList<String>();
	private String mHour_i_activity_format = null;
	private String mHour_f_activity_format = null;
	private String mBig;
	private String mT01;
	private String mT02;
	private String mT03;

	public ActivitiesModel() {
	}

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

	public String getmId_activity() {
		return mId_activity;
	}

	public void setmId_activity(String mId_activity) {
		this.mId_activity = mId_activity;
	}

	public String getmTitle_activity() {
		return mTitle_activity;
	}

	public void setmTitle_activity(String mTitle_activity) {
		this.mTitle_activity = mTitle_activity;
	}

	public String getmHour_i_activity() {
		return mHour_i_activity;
	}

	public void setmHour_i_activity(String mHour_i_activity) {
		this.mHour_i_activity = mHour_i_activity;
	}

	public String getmHour_f_activity() {
		return mHour_f_activity;
	}

	public void setmHour_f_activity(String mHour_f_activity) {
		this.mHour_f_activity = mHour_f_activity;
	}

	public String getmDate_n_activity() {
		return mDate_n_activity;
	}

	public void setmDate_n_activity(String mDate_n_activity) {
		this.mDate_n_activity = mDate_n_activity;
	}

	public String getmLocation_activity() {
		return mLocation_activity;
	}

	public void setmLocation_activity(String mLocation_activity) {
		this.mLocation_activity = mLocation_activity;
	}

	public String getmLat_activity() {
		return mLat_activity;
	}

	public void setmLat_activity(String mLat_activity) {
		this.mLat_activity = mLat_activity;
	}

	public String getmLon_activity() {
		return mLon_activity;
	}

	public void setmLon_activity(String mLon_activity) {
		this.mLon_activity = mLon_activity;
	}

	public String getmZoom_activity() {
		return mZoom_activity;
	}

	public void setmZoom_activity(String mZoom_activity) {
		this.mZoom_activity = mZoom_activity;
	}

	public String getmDesc_activity() {
		return mDesc_activity;
	}

	public void setmDesc_activity(String mDesc_activity) {
		this.mDesc_activity = mDesc_activity;
	}

	public String getmId_person_activity() {
		return mId_person_activity;
	}

	public void setmId_person_activity(String mId_person_activity) {
		this.mId_person_activity = mId_person_activity;
	}

	public String getmName_person_activity() {
		return mName_person_activity;
	}

	public void setmName_person_activity(String mName_person_activity) {
		this.mName_person_activity = mName_person_activity;
	}

	public String getmLastname_person_activity() {
		return mLastname_person_activity;
	}

	public void setmLastname_person_activity(String mLastname_person_activity) {
		this.mLastname_person_activity = mLastname_person_activity;
	}

	public String getmId_event_activity() {
		return mId_event_activity;
	}

	public void setmId_event_activity(String mId_event_activity) {
		this.mId_event_activity = mId_event_activity;
	}

	public String getmName_event_activity() {
		return mName_event_activity;
	}

	public void setmName_event_activity(String mName_event_activity) {
		this.mName_event_activity = mName_event_activity;
	}

	public String getmHasimg_activity() {
		return mHasimg_activity;
	}

	public void setmHasimg_activity(String mHasimg_activity) {
		this.mHasimg_activity = mHasimg_activity;
	}

	public String getmExtimg_activity() {
		return mExtimg_activity;
	}

	public void setmExtimg_activity(String mExtimg_activity) {
		this.mExtimg_activity = mExtimg_activity;
	}

	public String getmInx_day() {
		return mInx_day;
	}

	public void setmInx_day(String mInx_day) {
		this.mInx_day = mInx_day;
	}

	public List<String> getmEventimages() {
		return mEventimages;
	}

	public void setmEventimages(List<String> mEventimages) {
		this.mEventimages = mEventimages;
	}

	public String getmHour_i_activity_format() {
		return mHour_i_activity_format;
	}

	public void setmHour_i_activity_format(String mHour_i_activity_format) {
		this.mHour_i_activity_format = mHour_i_activity_format;
	}

	public String getmHour_f_activity_format() {
		return mHour_f_activity_format;
	}

	public void setmHour_f_activity_format(String mHour_f_activity_format) {
		this.mHour_f_activity_format = mHour_f_activity_format;
	}

	public String getmBig() {
		return IMAGE_URL + mBig;
	}

	public void setmBig(String mBig) {
		this.mBig = mBig;
	}

	public String getmT01() {
		return IMAGE_URL + mT01;
	}

	public void setmT01(String mT01) {
		this.mT01 = mT01;
	}

	public String getmT02() {
		return IMAGE_URL + mT02;
	}

	public void setmT02(String mT02) {
		this.mT02 = mT02;
	}

	public String getmT03() {
		return IMAGE_URL + mT03;
	}

	public void setmT03(String mT03) {
		this.mT03 = mT03;
	}

}
