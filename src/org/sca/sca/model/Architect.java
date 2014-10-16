package org.sca.sca.model;

import java.io.Serializable;

public class Architect implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String id_person;
	private String name_person;
	private String lastname_person;
	private String bio_person;
	private String id_reg_person;
	private String name_reg_person;
	private String slug_reg_person;
	private String hasimg_person;
	private String extimg_person;
	private String big;
	private String t01;
	private String t02;
	private String t03;
	private String city;

	public Architect(String id_person, String name_person,
			String lastname_person, String bio_person, String id_reg_person,
			String name_reg_person, String slug_reg_person,
			String hasimg_person, String extimg_person, String big, String t01,
			String t02, String t03, String city) {
		super();
		this.id_person = id_person;
		this.name_person = name_person;
		this.lastname_person = lastname_person;
		this.bio_person = bio_person;
		this.id_reg_person = id_reg_person;
		this.name_reg_person = name_reg_person;
		this.slug_reg_person = slug_reg_person;
		this.hasimg_person = hasimg_person;
		this.extimg_person = extimg_person;
		this.big = big;
		this.t01 = t01;
		this.t02 = t02;
		this.t03 = t03;
	}

	public String getId_person() {
		return id_person;
	}

	public void setId_person(String id_person) {
		this.id_person = id_person;
	}

	public String getName_person() {
		return name_person;
	}

	public void setName_person(String name_person) {
		this.name_person = name_person;
	}

	public String getLastname_person() {
		return lastname_person;
	}

	public void setLastname_person(String lastname_person) {
		this.lastname_person = lastname_person;
	}

	public String getBio_person() {
		return bio_person;
	}

	public void setBio_person(String bio_person) {
		this.bio_person = bio_person;
	}

	public String getId_reg_person() {
		return id_reg_person;
	}

	public void setId_reg_person(String id_reg_person) {
		this.id_reg_person = id_reg_person;
	}

	public String getName_reg_person() {
		return name_reg_person;
	}

	public void setName_reg_person(String name_reg_person) {
		this.name_reg_person = name_reg_person;
	}

	public String getSlug_reg_person() {
		return slug_reg_person;
	}

	public void setSlug_reg_person(String slug_reg_person) {
		this.slug_reg_person = slug_reg_person;
	}

	public String getHasimg_person() {
		return hasimg_person;
	}

	public void setHasimg_person(String hasimg_person) {
		this.hasimg_person = hasimg_person;
	}

	public String getExtimg_person() {
		return extimg_person;
	}

	public void setExtimg_person(String extimg_person) {
		this.extimg_person = extimg_person;
	}

	public String getBig() {
		return ActivitiesModel.IMAGE_URL + big;
	}

	public void setBig(String big) {
		this.big = big;
	}

	public String getT01() {
		return ActivitiesModel.IMAGE_URL + t01;
	}

	public void setT01(String t01) {
		this.t01 = t01;
	}

	public String getT02() {
		return ActivitiesModel.IMAGE_URL + t02;
	}

	public void setT02(String t02) {
		this.t02 = t02;
	}

	public String getT03() {
		return ActivitiesModel.IMAGE_URL + t03;
	}

	public void setT03(String t03) {
		this.t03 = t03;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
