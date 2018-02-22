//imports
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {

	//Declare variables
	private JLabel lblHead=new JLabel("Login");
	private JLabel lblUserName=new JLabel("User Name:");
	private JTextField txtUser=new JTextField(10);
	private JPasswordField txtPass=new JPasswordField(10);
	private JLabel lblPass=new JLabel("Password:");
	private JButton btnlog=new JButton("Login");
	private JPanel panel=new JPanel();
	private JButton btnMenu=new JButton("Menu");
	
	public Login() {
		//name of frame
		super("Login ");
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 //sets the size of frame
		setSize(300,300);
		setVisible(true);
		//sets the font of components
		lblHead.setFont(new Font("Arial", Font.BOLD, 54));
		lblUserName.setFont(new Font("Arial", Font.PLAIN, 24));
		lblPass.setFont(new Font("Arial", Font.PLAIN, 24));
		btnlog.setFont(new Font("Arial", Font.PLAIN, 24));
		btnMenu.setFont(new Font("Arial", Font.PLAIN, 24));
	    this.setLocationRelativeTo(null);
	    //adds components to the panel
		panel.add(lblHead);
		panel.add(lblUserName);
		panel.add(txtUser);
		panel.add(lblPass);
		panel.add(txtPass);
		 panel.add(btnMenu);
		panel.add(btnlog);
		//adds listeners to the components
		btnlog.addActionListener(this);
		btnMenu.addActionListener(this);
	   //adds the panel to the frame
		add(panel);
	}

	public static void main(String[] args) {
	//runs the Login class
        new Login();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	if(e.getSource()==btnlog)
	{
		//Gets the data from login text fields
	String user=txtUser.getText();
	String password=txtPass.getText();
	
	//checks if the login user name and password is correct
	if(user.equalsIgnoreCase("admin")&&(password.equalsIgnoreCase("pass")))
	{
		//directs admin to admin page if login successful
		Admin obj =new Admin();
		obj.setVisible(true);
		this.dispose();
	}
	else
	{
		//displays an error message if login information is incorrect
		JOptionPane.showMessageDialog(null, "Incorrect username or password!");
	}
	}
	
	else if(e.getSource()==btnMenu)
	{
		//directs user to menu
		Menu m=new Menu();
		m.setVisible(true);
		this.dispose();
	}
	}

}
