package org.sca.sca.model;

import java.util.LinkedList;
import java.util.List;

public class ArchitecsModel {
	
	private String mId_person = null;
	private String mName_person = null;
	private String mLast_name_person = null;
	private String mBio_person = null;
	private String mId_reg_person = null;
	private  String mId_photo = null;
	private String mName_photo = null ;
	private String MId_person_photo = null ;
	private String mName_reg_person = null;
	List<String> mImages = new LinkedList<String>();
	public ArchitecsModel(String id_person, String name_person,
			String last_name_person, String bio_person, String id_reg_person,
			String id_photo, String name_photo, String mId_person_photo,
			String name_reg_person, List<String> images) {
		super();
		mId_person = id_person;
		mName_person = name_person;
		mLast_name_person = last_name_person;
		mBio_person = bio_person;
		mId_reg_person = id_reg_person;
		mId_photo = id_photo;
		mName_photo = name_photo;
		MId_person_photo = mId_person_photo;
		mName_reg_person = name_reg_person;
		mImages = images;
	}
	public String getId_person() {
		return mId_person;
	}
	public void setId_person(String id_person) {
		mId_person = id_person;
	}
	public String getName_person() {
		return mName_person;
	}
	public void setName_person(String name_person) {
		mName_person = name_person;
	}
	public String getLast_name_person() {
		return mLast_name_person;
	}
	public void setLast_name_person(String last_name_person) {
		mLast_name_person = last_name_person;
	}
	public String getBio_person() {
		return mBio_person;
	}
	public void setBio_person(String bio_person) {
		mBio_person = bio_person;
	}
	public String getId_reg_person() {
		return mId_reg_person;
	}
	public void setId_reg_person(String id_reg_person) {
		mId_reg_person = id_reg_person;
	}
	public String getId_photo() {
		return mId_photo;
	}
	public void setId_photo(String id_photo) {
		mId_photo = id_photo;
	}
	public String getName_photo() {
		return mName_photo;
	}
	public void setName_photo(String name_photo) {
		mName_photo = name_photo;
	}
	public String getMId_person_photo() {
		return MId_person_photo;
	}
	public void setMId_person_photo(String mId_person_photo) {
		MId_person_photo = mId_person_photo;
	}
	public String getName_reg_person() {
		return mName_reg_person;
	}
	public void setName_reg_person(String name_reg_person) {
		mName_reg_person = name_reg_person;
	}
	
	
	
	
	

}
