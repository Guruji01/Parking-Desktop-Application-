package Form4;

public class Carcustbean 
{
    String Cust_Name, DOS, DOE, Type, Days, Bill ;
    
	public Carcustbean(String cust_Name, String dOS, String dOE, String type, String days, String bill) {
		super();
		Cust_Name = cust_Name;
		DOS = dOS;
		DOE = dOE;
		Type = type;
		Days = days;
		Bill = bill;
	}
	
	public Carcustbean()
	{
		
	}

	public String getCust_Name() {
		return Cust_Name;
	}

	public void setCust_Name(String cust_Name) {
		Cust_Name = cust_Name;
	}

	public String getDOS() {
		return DOS;
	}

	public void setDOS(String dOS) {
		DOS = dOS;
	}

	public String getDOE() {
		return DOE;
	}

	public void setDOE(String dOE) {
		DOE = dOE;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getDays() {
		return Days;
	}

	public void setDays(String days) {
		Days = days;
	}

	public String getBill() {
		return Bill;
	}

	public void setBill(String bill) {
		Bill = bill;
	} 
    
    
    
}
