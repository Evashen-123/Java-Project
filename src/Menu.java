//imports
import java.awt.*;

import java.awt.event.*;
import javax.swing.*;

public class Menu extends JFrame implements ActionListener {
	//declare components to use
	private JButton btnCal=new JButton("To Pay Roll Calculator");
	private JButton btnAd=new JButton("Admin");
	private JLabel lblHeading=new JLabel("Main Menu");
	private JLabel lblBlank=new JLabel();
	private JPanel panel=new JPanel(new GridLayout(5, 1,1,25));
	
	public Menu() {
		//name of fame
		super("Menu");
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 //frame size
		setSize(500,500);
	    this.setLocationRelativeTo(null);
		setVisible(true);
		//sets components font size and type
		lblHeading.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeading.setFont(new Font("Arial", Font.PLAIN, 54));
		btnAd.setFont(new Font("Arial", Font.PLAIN, 24));
		btnCal.setFont(new Font("Arial", Font.PLAIN, 24));
	
	//adds components to the panel
		panel.add(lblHeading);
	    panel.add(btnAd);
	    panel.add(btnCal);
	    panel.add(lblBlank);
	   //add listeners 
	    btnAd.addActionListener(this);
	    btnCal.addActionListener(this);
	  
	    //add panel to frame
	   add(panel);
		
	}

	public static void main(String[] args) {
     //runs the Menu constructor
        new Menu();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//checks which button user clicks
		Object source=e.getSource();
		if(source==btnAd)
		{
			//user directed to Login frame
			Login obj =new Login();
			obj.setVisible(true);
			this.dispose();
		}
		else if(source==btnCal)
		{
			//user directed to Home frame
			Home obj =new Home();
			obj.setVisible(true);
			this.dispose();
		}
	}

}
