package org.sca.sca.model;

import java.util.LinkedList;
import java.util.List;

public class Regions {
	
	private String mId_reg= null;
	private String mName_rege =null;
	private String mAbr_reg = null;
	private String mSlug_reg = null;
	private String mDir_reg = null;
	private String mPhone_reg = null ;
	private String mCity_reg = null;
	private String mCountry_region = null;
	private String mdistrict_region= null;
	private String mLat_reg = null; 
	private String mLong_reg = null;
	private String mId_person_reg = null;
	private String mName_person_reg = null;
	private String mHasimg_reg =null;
	private String mExtimg_reg = null;
	private String image = null;
	List<String> mImages = new LinkedList<String>();
	
	
   public Regions(String id_reg, String name_rege, String abr_reg,
			String slug_reg, String dir_reg, String phone_reg, String city_reg,
			String country_region, String mdistrict_region, String lat_reg,
			String long_reg, String id_person_reg, String name_person_reg,
			String hasimg_reg, String extimg_reg, List<String> images, String img) {
		super();
		mId_reg = id_reg;
		mName_rege = name_rege;
		mAbr_reg = abr_reg;
		mSlug_reg = slug_reg;
		mDir_reg = dir_reg;
		mPhone_reg = phone_reg;
		mCity_reg = city_reg;
		mCountry_region = country_region;
		this.mdistrict_region = mdistrict_region;
		mLat_reg = lat_reg;
		mLong_reg = long_reg;
		mId_person_reg = id_person_reg;
		mName_person_reg = name_person_reg;
		mHasimg_reg = hasimg_reg;
		mExtimg_reg = extimg_reg;
		mImages = images;
		image = img;
	}

	public String getId_reg() {
		return mId_reg;
	}

	public void setId_reg(String id_reg) {
		mId_reg = id_reg;
	}

	public String getName_rege() {
		return mName_rege;
	}

	public void setName_rege(String name_rege) {
		mName_rege = name_rege;
	}

	public String getAbr_reg() {
		return mAbr_reg;
	}

	public void setAbr_reg(String abr_reg) {
		mAbr_reg = abr_reg;
	}

	public String getSlug_reg() {
		return mSlug_reg;
	}

	public void setSlug_reg(String slug_reg) {
		mSlug_reg = slug_reg;
	}

	public String getDir_reg() {
		return mDir_reg;
	}

	public void setDir_reg(String dir_reg) {
		mDir_reg = dir_reg;
	}

	public String getPhone_reg() {
		return mPhone_reg;
	}

	public void setPhone_reg(String phone_reg) {
		mPhone_reg = phone_reg;
	}

	public String getCity_reg() {
		return mCity_reg;
	}

	public void setCity_reg(String city_reg) {
		mCity_reg = city_reg;
	}

	public String getCountry_region() {
		return mCountry_region;
	}

	public void setCountry_region(String country_region) {
		mCountry_region = country_region;
	}

	public String getMdistrict_region() {
		return mdistrict_region;
	}

	public void setMdistrict_region(String mdistrict_region) {
		this.mdistrict_region = mdistrict_region;
	}

	public String getLat_reg() {
		return mLat_reg;
	}

	public void setLat_reg(String lat_reg) {
		mLat_reg = lat_reg;
	}

	public String getLong_reg() {
		return mLong_reg;
	}

	public void setLong_reg(String long_reg) {
		mLong_reg = long_reg;
	}

	public String getId_person_reg() {
		return mId_person_reg;
	}

	public void setId_person_reg(String id_person_reg) {
		mId_person_reg = id_person_reg;
	}

	public String getName_person_reg() {
		return mName_person_reg;
	}

	public void setName_person_reg(String name_person_reg) {
		mName_person_reg = name_person_reg;
	}

	public String getHasimg_reg() {
		return mHasimg_reg;
	}

	public void setHasimg_reg(String hasimg_reg) {
		mHasimg_reg = hasimg_reg;
	}

	public String getExtimg_reg() {
		return mExtimg_reg;
	}

	public void setExtimg_reg(String extimg_reg) {
		mExtimg_reg = extimg_reg;
	}
	
	
	@Override
	public String toString() {
		return getName_rege();
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
	

}
