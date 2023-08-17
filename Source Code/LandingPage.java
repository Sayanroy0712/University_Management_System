package university.of.technology;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LandingPage extends JFrame implements ActionListener {
    
    JButton login, signup;
    
    LandingPage(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)size.getWidth();
        int height = (int)size.getHeight();
        setSize(width, height );
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/classroom.jpg"));
        Image i2 = i1.getImage().getScaledInstance(320,220, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(800,5, 320, 220);
        add(image);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/corridor2.jpg"));
        Image i5 = i4.getImage().getScaledInstance(260,180, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image1 = new JLabel(i6);
        image1.setBounds(975, 245, 260, 180);
        add(image1);
        
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/library3.jpg"));
        Image i8 = i7.getImage().getScaledInstance(300,250, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel image3 = new JLabel(i9);
        image3.setBounds(900, 450, 300, 180);
        add(image3);
        
        JLabel heading = new JLabel("<html>UNIVERSITY<br/>OF<br/>TECHNOLOGY</html>");
        heading.setBounds(70,20,450,250);
        heading.setFont(new Font("Tahoma",Font.BOLD,60));
        add(heading);
        
        JLabel subheading = new JLabel("Empowering Innovation through Technology");
        subheading.setBounds(70,160,700,250);
        subheading.setFont(new Font("Tahoma",Font.PLAIN,26));
        add(subheading);
        
        login = new JButton("Login");
        login.setBounds(100, 550, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        login.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(login);
        
        signup = new JButton("Sign Up");
        signup.setBounds(300, 550, 120, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        signup.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(signup);
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
         if (ae.getSource()== login){
             new Login();
             setVisible(false);
         }
         else if (ae.getSource()== signup){
             new Signup();
             setVisible(false);
         }
    }
    
    public static void main(String args[]){
        new LandingPage();
    }
    
}
