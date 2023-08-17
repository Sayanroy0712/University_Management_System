package university.of.technology;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton login, cancel;
    JTextField tfusername, tfpassword;
    JComboBox cb;
    
    Login(){
        
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
        
        JLabel lblbranch = new JLabel("Login As ");
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
        
        login = new JButton("Login");
        login.setBounds(150, 500, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        login.setFont(new Font("serif", Font.BOLD, 15));
        add(login);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(300, 500, 120, 30);
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
         if (ae.getSource()== login){
             String username = tfusername.getText();
             String password = tfpassword.getText();
             String user = (String)cb.getSelectedItem();
             
             String query = "Select * From login Where username = '"+username+"'and password='"+password+"'";
             
             try{
                 Conn c = new Conn();
                 ResultSet rs = c.s.executeQuery(query);
                 
                 if(rs.next()){
                     // Data exists
                     setVisible(false);
                     if(user.equals("Faculty")){
                        new Project();
                     }
                     else{
                        new Project2();
                     }
                 }
                 else{
                     // Data doesn't exist
                     JOptionPane.showMessageDialog(null, "Invalid Username or Password !");
                     setVisible(false);
                 }
             }
             catch(Exception e){
                 e.printStackTrace();
             }
             
         }
         else if (ae.getSource()== cancel){
             setVisible(false);
         }
    }
    
    public static void main(String args[]){
        new Login();
    }
}
