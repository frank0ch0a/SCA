package org.sca.sca.model;

import java.util.LinkedList;
import java.util.List;

public class News {
	
	private String id_news= null;
    private String title_news = null;
    private String content_news = null;
    private String date_news = null;
    private String id_user_news = null;
    private String name_user_news = null;
    private String lastname_user_news= null;
    private String hasimg_news= null;
    private String extimg_news = null;
    private String image = null;
    private List<String> img = new LinkedList<String>();
    
    public News(String id_news, String title_news, String content_news, String date_news, String id_user_news, String name_user_news, String lastname_user_news,
    		String hasimg_news, String extimg_news, List<String> img, String image){
    	
    	this.id_news= id_news;
    	this.title_news = title_news;
    	this.content_news = content_news;
    	this.date_news = date_news;
    	this.id_user_news = id_user_news;
    	this.name_user_news = name_user_news;
    	this.lastname_user_news= lastname_user_news;
    	this.hasimg_news= hasimg_news;
    	this.extimg_news = extimg_news;
    	this.img = img;
    	this.image = image;
    }

	public String getId_news() {
		return id_news;
	}

	public void setId_news(String id_news) {
		this.id_news = id_news;
	}

	public String getTitle_news() {
		return title_news;
	}

	public void setTitle_news(String title_news) {
		this.title_news = title_news;
	}

	public String getContent_news() {
		return content_news;
	}

	public void setContent_news(String content_news) {
		this.content_news = content_news;
	}

	public String getDate_news() {
		return date_news;
	}

	public void setDate_news(String date_news) {
		this.date_news = date_news;
	}

	public String getId_user_news() {
		return id_user_news;
	}

	public void setId_user_news(String id_user_news) {
		this.id_user_news = id_user_news;
	}

	public String getName_user_news() {
		return name_user_news;
	}

	public void setName_user_news(String name_user_news) {
		this.name_user_news = name_user_news;
	}

	public String getLastname_user_news() {
		return lastname_user_news;
	}

	public void setLastname_user_news(String lastname_user_news) {
		this.lastname_user_news = lastname_user_news;
	}

	public String getHasimg_news() {
		return hasimg_news;
	}

	public void setHasimg_news(String hasimg_news) {
		this.hasimg_news = hasimg_news;
	}

	public String getExtimg_news() {
		return extimg_news;
	}

	public void setExtimg_news(String extimg_news) {
		this.extimg_news = extimg_news;
	}

	public List<String> getImg() {
		return img;
	}

	public void setImg(List<String> img) {
		this.img = img;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
    
}
