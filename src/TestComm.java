//import used to test methods
import static org.junit.Assert.*;
import org.junit.Test;

public class TestComm {

	@Test
	public void test() {
		//Test data
		Commission e=new Commission(1, "john", "0786654532", 40, 100,10,1000);
	     String res=String.format("%.2f", e.CalcSalary());
	     //method used to check if the expected result will equal to the actual result 
	    assertEquals("4100.00", res);
	}
}
