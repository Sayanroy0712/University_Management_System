package university.of.technology;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Signup extends JFrame implements ActionListener{
    
    JButton login, cancel;
    JTextField tfusername, tfpassword;
    JComboBox cb;
    
    Signup(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("UNIVERSITY OF TECHNOLOGY ");
        heading.setBounds(50,30,550,50);
        heading.setFont(new Font("Tahoma",Font.BOLD,32));
        
        JLabel subheading = new JLabel("Empowering Innovation through Technology");
        subheading.setBounds(55,70,700,50);
        subheading.setFont(new Font("Tahoma",Font.PLAIN,24));
        add(subheading);
        add(heading);
        
        JLabel lblbranch = new JLabel("User ");
        lblbranch.setBounds(150, 350, 200, 30);
        lblbranch.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblbranch);
        
        String branch[] = {"Faculty","Student"};
        cb = new JComboBox(branch);
        cb.setBounds(250,350,150,25);
        cb.setBackground(Color.WHITE);
        add(cb);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(150, 250, 100, 20);
        lblusername.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(250, 250, 150, 25);
        add(tfusername);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(150, 300, 100, 20);
        lblpassword.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblpassword);
        
        tfpassword = new JPasswordField();
        tfpassword.setBounds(250, 300, 150, 25);
        add(tfpassword);
        
        login = new JButton("Add New Student Details");
        login.setBounds(70, 500, 200, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        login.setFont(new Font("serif", Font.BOLD, 15));
        add(login);
        
        cancel = new JButton("Add New Faculty Details");
        cancel.setBounds(300, 500, 200, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("serif", Font.BOLD, 15));
        add(cancel);
        
        setSize(600,700);
        setLocation(350,0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String username = tfusername.getText();
             String password = tfpassword.getText();
             String user = (String)cb.getSelectedItem();
             
             String query = "Insert into login2 values('"+username+"','"+password+"','"+user+"')";
             
             try{
                 Conn c = new Conn();
                 c.s.executeUpdate(query);
             }
             catch(Exception e){
                 e.printStackTrace();
             }
             
         if (ae.getSource()== login){
             new AddStudent();
             setVisible(false);
         }
         else if (ae.getSource()== cancel){
             new AddTeacher();
             setVisible(false);
         }
    }
    
    public static void main(String args[]){
        new Signup();
    }
}

