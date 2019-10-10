package Form2;

import java.time.LocalDate;

public class Cusbean
{
	String cust_name, gender;
	String phone, address ,v_type, model_name, model_no, dos,stime,pathh;
	
	
	
	
	
	
	
	public Cusbean(String cust_name, String gender, String phone, String address, String v_type, String model_name,
			String model_no, String dos, String stime, String pathh) {
		super();
		this.cust_name = cust_name;
		this.gender = gender;
		this.phone = phone;
		this.address = address;
		this.v_type = v_type;
		this.model_name = model_name;
		this.model_no = model_no;
		this.dos = dos;
		this.stime = stime;
		this.pathh = pathh;
	}
	
	public Cusbean()
	{
		
	}


	public String getCust_name() {
		return cust_name;
	}
	
	
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getV_type() {
		return v_type;
	}
	public void setV_type(String v_type) {
		this.v_type = v_type;
	}
	public String getModel_name() {
		return model_name;
	}
	public void setModel_name(String model_name) {
		this.model_name = model_name;
	}
	public String getModel_no() {
		return model_no;
	}
	public void setModel_no(String model_no) {
		this.model_no = model_no;
	}
	public String getDos() {
		return dos;
	}
	public void setDos(String dos) {
		this.dos = dos;
	}
	public String getStime() {
		return stime;
	}
	public void setStime(String stime) {
		this.stime = stime;
	}
	public String getPathh() {
		return pathh;
	}
	public void setPathh(String pathh) {
		this.pathh = pathh;
	}
	
	
	
	}