package entity;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;




@Entity
@Table(name = "OGRENCI")
public class Data {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	
	@Column
	private String surname;
	
	@Column
	private String phone;
	
	@Column
	private String city;
	
	@Column
	private String district;
	
	@Column
	private String description;
	
	
	public Data() {
		super();
	}
	public Data(int id,String name, String surname, String phone, String city, String district, String description) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.city = city;
		this.district = district;
		this.description = description;
		
	}
	public Data(String name, String surname, String phone, String city, String district, String description) {
		super();
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.city = city;
		this.district = district;
		this.description = description;
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Contact [name=" + getName() + ", surname=" + getSurname() + ", phone=" + getPhone() + ",city=" + getCity() + ",district=" + getDistrict() + ", description=" + getDescription() + "]";
	}
	
}

