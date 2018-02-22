public class Commission extends Employee 
{
	//declare variables
	 double percentage;
	 double sales;
	//parameterised constructor to pass values into the frame
	public Commission(int num,String name,String con,int hrs,int r,double p,double s)
	{
    //calls the base class constructor
    super(num, name, con, hrs, r);
	percentage=p;
	sales=s;
	}
	
	//method to calculate the salary if employee is on commission
	public double CalcSalary()
	{
		return(super.CalcSalary()+((percentage/100)*sales));
	}
}
