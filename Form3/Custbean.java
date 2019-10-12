package Form3;

public class Custbean 
{

  String Cust_Name, Dos, Check_In, Check_Out, Hours, Type, Bill;
  
  
  

public Custbean(String cust_Name, String dos, String check_In, String check_Out, String hours, String type,
		String bill) {
	super();
	Cust_Name = cust_Name;
	Dos = dos;
	Check_In = check_In;
	Check_Out = check_Out;
	Hours = hours;
	Type = type;
	Bill = bill;
}

       public Custbean()
       {
	 
       }

public String getCust_Name() {
	return Cust_Name;
}

public void setCust_Name(String cust_Name) {
	Cust_Name = cust_Name;
}

public String getDos() {
	return Dos;
}

public void setDos(String dos) {
	Dos = dos;
}

public String getCheck_In() {
	return Check_In;
}

public void setCheck_In(String check_In) {
	Check_In = check_In;
}

public String getCheck_Out() {
	return Check_Out;
}

public void setCheck_Out(String check_Out) {
	Check_Out = check_Out;
}

public String getHours() {
	return Hours;
}

public void setHours(String hours) {
	Hours = hours;
}

public String getType() {
	return Type;
}

public void setType(String type) {
	Type = type;
}

public String getBill() {
	return Bill;
}

public void setBill(String bill) {
	Bill = bill;
}
  

	

}
