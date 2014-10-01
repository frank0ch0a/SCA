package org.sca.sca.model;

import java.util.ArrayList;

public class RegionModel {

	private String id_reg;
	private String name_reg;
	private String abr_reg;
	private String slug_reg;
	private String dir_reg;
	private String phone_reg;
	private String city_reg;
	private String country_reg;
	private String district_reg;
	private String lat_reg;
	private String lon_reg;
	private String id_person_reg;
	private String name_person_reg;
	private String lastname_person_reg;
	private String hasimg_reg;
	private String extimg_reg;
	private String big;
	private String t01;
	private String t02;
	private String t03;
	private ArrayList<Architect> persons;

	public RegionModel(String id_reg, String name_reg, String abr_reg,
			String slug_reg, String dir_reg, String phone_reg, String city_reg,
			String country_reg, String district_reg, String lat_reg,
			String lon_reg, String id_person_reg, String name_person_reg,
			String lastname_person_reg, String hasimg_reg, String extimg_reg,
			String big, String t01, String t02, String t03,
			ArrayList<Architect> persons) {
		super();
		this.id_reg = id_reg;
		this.name_reg = name_reg;
		this.abr_reg = abr_reg;
		this.slug_reg = slug_reg;
		this.dir_reg = dir_reg;
		this.phone_reg = phone_reg;
		this.city_reg = city_reg;
		this.country_reg = country_reg;
		this.district_reg = district_reg;
		this.lat_reg = lat_reg;
		this.lon_reg = lon_reg;
		this.id_person_reg = id_person_reg;
		this.name_person_reg = name_person_reg;
		this.lastname_person_reg = lastname_person_reg;
		this.hasimg_reg = hasimg_reg;
		this.extimg_reg = extimg_reg;
		this.big = big;
		this.t01 = t01;
		this.t02 = t02;
		this.t03 = t03;
		this.persons = persons;
	}

	public String getId_reg() {
		return id_reg;
	}

	public void setId_reg(String id_reg) {
		this.id_reg = id_reg;
	}

	public String getName_reg() {
		return name_reg;
	}

	public void setName_reg(String name_reg) {
		this.name_reg = name_reg;
	}

	public String getAbr_reg() {
		return abr_reg;
	}

	public void setAbr_reg(String abr_reg) {
		this.abr_reg = abr_reg;
	}

	public String getSlug_reg() {
		return slug_reg;
	}

	public void setSlug_reg(String slug_reg) {
		this.slug_reg = slug_reg;
	}

	public String getDir_reg() {
		return dir_reg;
	}

	public void setDir_reg(String dir_reg) {
		this.dir_reg = dir_reg;
	}

	public String getPhone_reg() {
		return phone_reg;
	}

	public void setPhone_reg(String phone_reg) {
		this.phone_reg = phone_reg;
	}

	public String getCity_reg() {
		return city_reg;
	}

	public void setCity_reg(String city_reg) {
		this.city_reg = city_reg;
	}

	public String getCountry_reg() {
		return country_reg;
	}

	public void setCountry_reg(String country_reg) {
		this.country_reg = country_reg;
	}

	public String getDistrict_reg() {
		return district_reg;
	}

	public void setDistrict_reg(String district_reg) {
		this.district_reg = district_reg;
	}

	public String getLat_reg() {
		return lat_reg;
	}

	public void setLat_reg(String lat_reg) {
		this.lat_reg = lat_reg;
	}

	public String getLon_reg() {
		return lon_reg;
	}

	public void setLon_reg(String lon_reg) {
		this.lon_reg = lon_reg;
	}

	public String getId_person_reg() {
		return id_person_reg;
	}

	public void setId_person_reg(String id_person_reg) {
		this.id_person_reg = id_person_reg;
	}

	public String getName_person_reg() {
		return name_person_reg;
	}

	public void setName_person_reg(String name_person_reg) {
		this.name_person_reg = name_person_reg;
	}

	public String getLastname_person_reg() {
		return lastname_person_reg;
	}

	public void setLastname_person_reg(String lastname_person_reg) {
		this.lastname_person_reg = lastname_person_reg;
	}

	public String getHasimg_reg() {
		return hasimg_reg;
	}

	public void setHasimg_reg(String hasimg_reg) {
		this.hasimg_reg = hasimg_reg;
	}

	public String getExtimg_reg() {
		return extimg_reg;
	}

	public void setExtimg_reg(String extimg_reg) {
		this.extimg_reg = extimg_reg;
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

	public ArrayList<Architect> getPersons() {
		return persons;
	}

	public void setPersons(ArrayList<Architect> persons) {
		this.persons = persons;
	}

}
