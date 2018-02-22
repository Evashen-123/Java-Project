//imports 
import java.awt.*;
import java.io.*;
import java.util.Scanner;
import java.awt.event.*;
import javax.swing.*;
public class Admin  extends JFrame implements ActionListener{
	
	//Declare components to use
	JLabel lbladmin =new JLabel("Admin Page");
	JButton btnView =new JButton("View Employee detials");
	private JTextArea txaDetails=new JTextArea("Number:"+"\t"+"Name"+"\t"+"Contact"+"\t"+"Hours"+"\t"+"Rate"+"\t"+"Salary"+"\n");
	private JButton btnMenu=new JButton("Menu");
	private JButton btnAverage=new JButton("Average Salary");
	private JLabel lblAv=new JLabel("  ");
	double [] Average=new double[50];
	JPanel panel =new JPanel(new GridBagLayout());
	//declare variables
	double ave=0;

	public Admin() {
		//JFrame name
	super ("admin");
	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 //sets the size of frame
	 setSize(1500,800);
	 //sets the frame to the center of the screen
	 this.setLocationRelativeTo(null);
	 //sets the font type and font size for the components
	 btnView.setFont(new Font("Arial", Font.PLAIN, 24));
	 lbladmin.setFont(new Font("Arial", Font.PLAIN, 48));
	 txaDetails.setFont(new Font("Arial", Font.PLAIN, 36));
	 btnMenu.setFont(new Font("Arial", Font.PLAIN, 24));
	 btnAverage.setFont(new Font("Arial", Font.PLAIN, 24));
	 lblAv.setFont(new Font("Arial", Font.PLAIN, 24));
	 //Displays the frame
	setVisible(true);
	//Use of gridBag layout manager
	GridBagConstraints c =new GridBagConstraints();
	//Adds the components to the frame using GridBag layout manager
	panel.add(lbladmin);
	c.gridx=0;
	c.gridy=1;
	panel.add(btnView,c);
	
	c.gridx=0;
	c.gridy=2;
	panel.add(txaDetails,c);
	
	c.gridx=0;
	c.gridy=4;
	panel.add(lblAv,c);
	
	c.gridx=0;
	c.gridy=3;
	panel.add(btnAverage,c);
	
	c.gridx=0;
	c.gridy=5;
	panel.add(btnMenu,c);
	//adds the listeners to the components
	btnMenu.addActionListener(this);
	btnAverage.addActionListener(this);
	btnView.addActionListener(this);
	//adds the panel to the frame
	add(panel);
	}

	public static void main(String[] args) {
	//calls the class constructor to run the application
      new Admin();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	  //checks which button is clicked by the user
		 if(e.getSource()==btnAverage)
			{
				lblAv.setText("Average employee salary:"+"R"+ String.format("%.2f", ave)+"");
			
			}
		 else if(e.getSource()==btnMenu)
		{
			 //navigates to the next frame
			Menu m=new Menu();
			m.setVisible(true);
			this.dispose();
		}
		 else 
			 if(e.getSource()==btnView)
			 {
				 //reads the data from the text file
				 try
				 {
					 int i=0;
					 Scanner sc =new Scanner(new FileReader("Salary.txt"));
					 while(sc.hasNext())
					 {
						 //reads each line from text file
						 String line=sc.nextLine();
						 txaDetails.append(line+"\n");
						 int sal=line.lastIndexOf("R");
						 String salary=line.substring(sal+1);
						 //stores the salary of the employees in an array
						Average[i]=Double.parseDouble(salary);
						 double sum=0;
						 i++;
						
						 for(int j=0;j<i;j++)
							{
							 //calculates the sum of salaries
								sum+=Average[j];
							}
						 ///calculates the average of all salaries
						 ave=sum/i;
					 }
				 }
				 catch(FileNotFoundException aa)
				 {
					 //displays a message if read cannot be read/found
					 JOptionPane.showMessageDialog(null, "File not found!");
				 }
			 }
	}

}
