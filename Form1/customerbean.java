package Form1;

import java.time.LocalDate;

public class customerbean 
{
	String cust_Name, gender;
	String phone, address ,v_Type, model_Name, model_No, dos,pathh;
	
	
	
	public customerbean(String cust_Name, String gender, String phone, String address, String v_Type, String model_Name,
			String model_No, String dos, String pathh) {
		super();
		this.cust_Name = cust_Name;
		this.gender = gender;
		this.phone = phone;
		this.address = address;
		this.v_Type = v_Type;
		this.model_Name = model_Name;
		this.model_No = model_No;
		this.dos = dos;
		this.pathh = pathh;
	}



public String getCust_Name() 
    {
		return cust_Name;
	}

	public void setCust_Name(String cust_Name) 
	{
		this.cust_Name = cust_Name;
	}


	public String getGender() 
	{
		return gender;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}





	public String getV_Type()
	{
		return v_Type;
	}
	public void setV_Type(String v_Type)
	{
		this.v_Type = v_Type;
	}


	public String getModel_Name() 
	{
		return model_Name;
	}
	public void setModel_Name(String model_Name)
	{
		this.model_Name = model_Name;
	}


	public String getModel_No() 
	{
		return model_No;
	}
	public void setModel_No(String model_No)
	{
		this.model_No = model_No;
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDos() 
	{
		return dos;
	}
	public void setDos(String dos)
	{
		this.dos = dos;
	}

	public String getPathh() 
	{
		return pathh;
	}
	public void setPathh(String pathh)
	{
		this.pathh = pathh;
	}


	public String getPhone() 
	{
		return phone;
	}
	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	
}