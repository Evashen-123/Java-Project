//imports
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Home extends JFrame implements ActionListener,ItemListener,KeyListener,MouseListener
{
	//declare components to use
private JLabel lblTime=new JLabel();
private JLabel lblHeading=new JLabel("Employee Pay Roll Calculator ");
private JLabel lblDate=new JLabel();
private JPanel panel=new JPanel(new GridBagLayout());
private JLabel lblNum=new JLabel("Enter Employee Number");
private JLabel lblName=new JLabel("Enter Employee Name");
private JLabel lblContact=new JLabel("Enter Employee Contact");
private JLabel lblHours=new JLabel("Enter Hours");
private JLabel lblRate=new JLabel("Enter Rate");
private JLabel lblType=new JLabel("Select an Employee");
private JLabel lblSalary=new JLabel();
private JLabel lblPercent=new JLabel("Enter Percentage commission");
private JLabel lblTotal=new JLabel("Enter total sales");
private JLabel lblAlert=new JLabel();
private JTextField txtPercent=new JTextField(10);
private JTextField txtTotal=new JTextField(10);
private JTextField txtNum=new JTextField(10);
private JTextField txtName=new JTextField(10);
private JTextField txtContact=new JTextField(10);
private JTextField txtHours=new JTextField(10);
private JTextField txtRate=new JTextField(10);
private JButton btnCalc=new JButton("Calculate");
private JButton btnMenu=new JButton("Menu");
String [] Type={"Select Employee","OverTime","Commission"};
private JComboBox cmbType=new JComboBox(Type);
//declare variables
int time=0;
String timeofDay="";
int EmpNum;
String EmpName;
String Contact;
int hours;
int rate;
double percent;
double sales;
//GridBag layout manager used to arrange components
GridBagConstraints c =new GridBagConstraints();

	public Home() 
	{
		//name of frame
		super("Pay Roll Calculator");
		//sets the frame to appear in the center of the screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    int height = screenSize.height;
		int width = screenSize.width;
		setSize((width/2)+100, (height/2)+100);
	    this.setLocationRelativeTo(null);
	    //displays the frame
		setVisible(true);
		//sets the font type and font size that components use
		lblHeading.setFont(new Font("Times New Roman ", Font.BOLD, 36));
		panel.setBackground(Color.lightGray);
		lblNum.setFont(new Font("Arial", Font.PLAIN, 18));
		lblDate.setFont(new Font("Lucida Handwriting", Font.BOLD, 20));
		lblTime.setFont(new Font("Lucida Handwriting", Font.BOLD, 20));
		lblName.setFont(new Font("Arial", Font.PLAIN, 18));
		lblContact.setFont(new Font("Arial", Font.PLAIN, 18));
		lblHours.setFont(new Font("Arial", Font.PLAIN, 18));
		lblRate.setFont(new Font("Arial", Font.PLAIN, 18));
		lblPercent.setFont(new Font("Arial", Font.PLAIN, 18));
		lblTotal.setFont(new Font("Arial", Font.PLAIN, 18));
		lblType.setFont(new Font("Arial", Font.PLAIN, 18));
		lblSalary.setFont(new Font("Lucida Handwriting", Font.BOLD, 18));
		btnCalc.setFont(new Font("Arial", Font.BOLD, 18));
		btnMenu.setFont(new Font("Arial", Font.BOLD, 18));
		//disables the commission text fields 
		lblPercent.setEnabled(false);
		txtPercent.setEnabled(false);
		lblTotal.setEnabled(false);
		txtTotal.setEnabled(false);
		
		//GridBag layout manager used to arrange components
		c.gridx=0;
		c.gridy=0;
		panel.add(lblDate,c);
		
		c.gridx=4;
		c.gridy=0;
		panel.add(lblTime,c);
		
		c.gridx=1;
		c.gridy=1;
		panel.add(lblHeading,c);
		
		c.gridx=1;
		c.gridy=4;
		panel.add(lblNum,c);

		c.gridx=2;
		c.gridy=4;
		panel.add(txtNum,c);

		c.gridx=1;
		c.gridy=5;
		panel.add(lblName,c);

		c.gridx=2;
		c.gridy=5;
		panel.add(txtName,c);

		c.gridx=1;
		c.gridy=6;
		panel.add(lblContact,c);

		c.gridx=2;
		c.gridy=6;
		panel.add(txtContact,c);

		c.gridx=1;
		c.gridy=7;
		panel.add(lblHours,c);

		c.gridx=2;
		c.gridy=7;
		panel.add(txtHours,c);

		c.gridx=1;
		c.gridy=8;
		panel.add(lblRate,c);

		c.gridx=2;
		c.gridy=8;
		panel.add(txtRate,c);

		c.gridx=1;
		c.gridy=9;
		panel.add(lblType,c);

		c.gridx=2;
		c.gridy=9;
		panel.add(cmbType,c);

		c.gridx=1;
		c.gridy=10;
		panel.add(lblPercent,c);
		
		c.gridx=2;
		c.gridy=10;
		panel.add(txtPercent,c);
		
		c.gridx=1;
		c.gridy=11;
		panel.add(lblTotal,c);
		
		c.gridx=2;
		c.gridy=11;
		panel.add(txtTotal,c);
		
		
		c.gridx=1;
		c.gridy=12;
		panel.add(btnCalc,c);
		
		c.gridx=2;
		c.gridy=12;
		panel.add(lblSalary,c);
		
		c.gridx=1;
		c.gridy=14;
		panel.add(lblAlert,c);
		
		c.gridx=0;
		c.gridy=14;
		 panel.add(btnMenu,c);

	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    //adds the necessary listeners to the components
	    btnMenu.addActionListener(this);
	    txtNum.addKeyListener(this);
	    txtName.addKeyListener(this);
	    txtContact.addKeyListener(this);
	    txtRate.addKeyListener(this);
	    txtPercent.addKeyListener(this);
	    txtTotal.addKeyListener(this);
	    txtHours.addKeyListener(this);
	    btnCalc.addActionListener(this);
	    panel.addMouseListener(this);
	    lblNum.addMouseListener(this);
	    lblName.addMouseListener(this);
	    lblContact.addMouseListener(this);
	    lblRate.addMouseListener(this);
	    lblHours.addMouseListener(this);
	    txtNum.addMouseListener(this);
	    txtName.addMouseListener(this);
	    txtContact.addMouseListener(this);
	    txtRate.addMouseListener(this);
	    txtHours.addMouseListener(this);
	    txtPercent.addMouseListener(this);
	    lblPercent.addMouseListener(this);
	    txtTotal.addMouseListener(this);
	    lblTotal.addMouseListener(this);
	    cmbType.addMouseListener(this);
	    btnCalc.addMouseListener(this);
	    cmbType.addItemListener(this);
	    add(panel);
	    
	    //creates a new thread
	    new Thread()
	    {
	    	public void run()
	    	{
	    		while (time==0)
	    		{
	    			//gets the necessary date and time information
	    		   Calendar cal=new GregorianCalendar();
	 			   int second=cal.get(Calendar.SECOND);
	 			   int minute=cal.get(Calendar.MINUTE);
	 			   int hour=cal.get(Calendar.HOUR);
	 			   int year=cal.get(Calendar.YEAR);
	 			   int month=cal.get(Calendar.MONTH);
	 			   int day=cal.get(Calendar.DAY_OF_MONTH);
	 			   int am_pm=cal.get(Calendar.AM_PM); 
	 			   //determines whether it is PM or AM
	 			   if(am_pm==0)
	 			   {
	 				  timeofDay="AM";
	 			   }
	 			   else if(am_pm==1)
	 			   {
	 				  timeofDay="PM";
	 			   }
	 			   //displays the time and date information
	 			   lblTime.setText(hour+":"+minute+":"+second+" "+timeofDay);
	 			   lblDate.setText(day+"/"+month+"/"+year);
	    		}
	    	}
	    //starts the thread
	    }.start();
	}
	
public void actionPerformed(ActionEvent e)
{
	//checks which button is clicked by user
	if(e.getSource()==btnCalc)
	{
		//gets data from text fields  
    EmpNum=Integer.parseInt(txtNum.getText());
    EmpName=txtName.getText();
    Contact=txtContact.getText();
    hours=Integer.parseInt(txtHours.getText());
    rate=Integer.parseInt(txtRate.getText());
    
	if(cmbType.getSelectedIndex()==1)
	{
		//creates an instance of the overTime class
		OverTime obj=new OverTime(EmpNum, EmpName, Contact, hours, rate);
		//calls the method in the class and displays the salary
		lblSalary.setText("Salary:"+"R"+Double.toString(obj.CalcSalary()));
		//writes the salary information to a text field
		 String details=EmpNum+"\t"+EmpName+"\t"+Contact+"\t"+hours+"\t"+rate+"\t"+"R"+String.format("%.2f",obj.CalcSalary());  
		 try
		 {
			PrintWriter pw=new PrintWriter(new FileWriter("Salary.txt",true));
			pw.println(details);
			
			pw.close();
		 }
		 catch(IOException a)
		 {
			 JOptionPane.showMessageDialog(null, "cannot write to file!");
		 }
		
	}
	 if(cmbType.getSelectedIndex()==2)
	{
		 percent=Integer.parseInt(txtPercent.getText());
		 sales=Double.parseDouble(txtTotal.getText());
		//creates an instance of the Commission class
		 Commission comm =new Commission(EmpNum, EmpName, Contact, hours, rate,percent,sales);
		//calls the method in the class and displays the salary
	    lblSalary.setText("Salary:"+"R"+Double.toString(comm.CalcSalary()));
		//writes the salary information to a text field
	    String details=EmpNum+"\t"+EmpName+"\t"+Contact+" \t"+hours+"\t"+rate+"\t"+"R"+String.format("%.2f",comm.CalcSalary());  
	    
	    try
		 {
	    	PrintWriter pw=new PrintWriter(new FileWriter("Salary.txt",true));
			pw.println(details);
			
			pw.close();
		 }
		 catch(IOException a)
		 {
			 JOptionPane.showMessageDialog(null, "cannot write to file!");
		 }
	}
	}
	else
		if(e.getSource()==btnMenu)
		{
			//navigates to next frame
			Menu m=new Menu();
			m.setVisible(true);
			this.dispose();
		}
}

public static void main(String[] args) 
{
	//runs the Home class
	new Home();
}

public void itemStateChanged(ItemEvent e) {
	if(cmbType.getSelectedIndex()==1)
	{
		//disables the commission text fields 
		lblPercent.setEnabled(false);
		txtPercent.setEnabled(false);
		lblTotal.setEnabled(false);
		txtTotal.setEnabled(false);
	}
	else if(cmbType.getSelectedIndex()==2)
		{
		//enables the commission text fields 
			lblPercent.setEnabled(true);
			txtPercent.setEnabled(true);
			lblTotal.setEnabled(true);
			txtTotal.setEnabled(true);
		}
}

public void keyPressed(KeyEvent evt) {
	
	
}

public void keyReleased(KeyEvent evt) {
	
	
}

public void keyTyped(KeyEvent evt) 
{
	Object source=evt.getSource();
	char a =evt.getKeyChar();
	//validation
	//checks if valid data is being entered into text field by user
	if(source==txtNum)
	{
		if (!(Character.isDigit(a)||(a==KeyEvent.VK_BACK_SPACE)||a==KeyEvent.VK_DELETE))
		{
			//does not write the letter if it is an invalid character
         evt.consume();
         //displays an error message 
         JOptionPane.showMessageDialog(null, "numbers only!");
        } 
	}
	if(source==txtName)
	{
		if (!(Character.isLetter(a)||(a==KeyEvent.VK_BACK_SPACE)||a==KeyEvent.VK_DELETE))
		{
			//does not write the letter if it is an invalid character
         evt.consume();
         //displays an error message 
         JOptionPane.showMessageDialog(null, "Alphabets only!");
        } 
	}
	if(source==txtContact)
	{
		if (!(Character.isDigit(a)||(a==KeyEvent.VK_BACK_SPACE)||a==KeyEvent.VK_DELETE))
		{
			//does not write the letter if it is an invalid character
         evt.consume();
         //displays an error message 
         JOptionPane.showMessageDialog(null, "numbers only!");
        } 
	}
	if(source==txtHours)
	{
		if (!(Character.isDigit(a)||(a==KeyEvent.VK_BACK_SPACE)||a==KeyEvent.VK_DELETE))
		{
			//does not write the letter if it is an invalid character
         evt.consume();
         //displays an error message 
         JOptionPane.showMessageDialog(null, "numbers only!");
        } 
	}
	if(source==txtRate)
	{
		if (!(Character.isDigit(a)||(a==KeyEvent.VK_BACK_SPACE)||a==KeyEvent.VK_DELETE))
		{
         evt.consume();
         //displays an error message 
         JOptionPane.showMessageDialog(null, "numbers only!");
        } 
	}
	if(source==txtPercent)
	{
		if (!(Character.isDigit(a)||(a==KeyEvent.VK_BACK_SPACE)||a==KeyEvent.VK_DELETE))
		{
			//does not write the letter if it is an invalid character
         evt.consume();
         //displays an error message 
         JOptionPane.showMessageDialog(null, "numbers only!");
        } 
	}
	if(source==txtTotal)
	{
		if (!(Character.isDigit(a)||(a==KeyEvent.VK_BACK_SPACE)||a==KeyEvent.VK_DELETE))
		{
			//does not write the letter if it is an invalid character
         evt.consume();
         //displays an error message 
         JOptionPane.showMessageDialog(null, "numbers only!");
        } 
	}
}

@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseEntered(MouseEvent e) {
//checks if the mouse is in the frame
	panel.setBackground(Color.LIGHT_GRAY);
	lblAlert.setText(null);
}

@Override
public void mouseExited(MouseEvent e) {
	//checks if the mouse has left the frame
   	panel.setBackground(Color.darkGray);
	//display help message
	lblAlert.setText("Mouse has left the window");
	lblAlert.setForeground(Color.red);
	lblAlert.setFont(new Font("Arial", Font.BOLD, 24));
    
}

@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
}