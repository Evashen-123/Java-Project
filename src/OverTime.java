public class OverTime extends Employee
{
	//parameterised constructor to pass values into the frame
	public OverTime(int num, String name, String con, int hrs, int r) 
	{
		 //calls the base class constructor
		super(num, name, con, hrs, r);
	}
	//method to calculate the salary if employee is OverTime
	public double CalcSalary()
	{
		//checks if hours worked is greater than 40
		if(hours<=40)
		{
			return(super.CalcSalary());
		}
		else
		{
			//calculates the overtime pay 
			return(rate*40)+((hours-40)*rate*1.5);
		}
	}
}
