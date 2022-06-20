package com.example.cvproject.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;





import lombok.Data;

@Entity
@Table(name = "user")
@Data

//Belirlenen değişkenleri databaseden çekip geri veri yollamak için source kısmından getter setter komutlarını otomatik olarak oluşturduk.

public class User {
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getEgitimBilgileri() {
		return egitimBilgileri;
	}
	public void setEgitimBilgileri(String egitimBilgileri) {
		this.egitimBilgileri = egitimBilgileri;
	}
	public String getTecrube() {
		return Tecrube;
	}
	public void setTecrube(String tecrube) {
		Tecrube = tecrube;
	}
	public String getCepNo() {
		return cepNo;
	}
	public void setCepNo(String cepNo) {
		this.cepNo = cepNo;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}


	@Id
	@Column(name="id")//id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	String userName;
	String name;
	String surName;
	String password;
	String mail;
	String egitimBilgileri;
	String Tecrube;
	String cepNo;
	String Beceri;
	public String getBeceri() {
		return Beceri;
	}
	public void setBeceri(String beceri) {
		Beceri = beceri;
	}


	
	
}
