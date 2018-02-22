public class Employee 
{
	//declare variables
	protected int EmpNum;
	protected String EmpName;
	protected String Contact;
	protected int hours;
	protected int rate;
	//parameterised constructor to pass values into the frame
	public Employee(int num,String name,String con,int hrs,int r) 
	{
		EmpNum=num;
		EmpName=name;
		Contact=con;
		hours=hrs;
		rate=r;
	}
	//method to calculate the basic salary 
	public double CalcSalary()
	{
		return(hours*rate);
	}
}
