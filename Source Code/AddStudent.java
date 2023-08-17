package university.of.technology;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.*;

public class AddStudent extends JFrame implements ActionListener{
    
    JTextField tfname,tffname,tfaddress,tfphone,tfemail,tfx,tfxii,tfaadhar;
    JLabel roll;
    JDateChooser dcdob;
    JComboBox cbcourse,cbbranch;
    JButton submit,cancel;
    
    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L);
    
    AddStudent(){
        
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)size.getWidth();
        int height = (int)size.getHeight();
        setSize(width, height );
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("UNIVERSITY OF TECHNOLOGY ");
        heading.setBounds(325,50,700,50);
        heading.setFont(new Font("Tahoma",Font.BOLD,40));
        add(heading);
        
        JLabel subheading = new JLabel("NEW STUDENT DETAILS");
        subheading.setBounds(450, 130, 500, 50);
        subheading.setFont(new Font("serif",Font.BOLD,30));
        add(subheading);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(250, 250, 100, 30);
        lblname.setFont(new Font("serif",Font.BOLD,20));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(400, 250, 150, 30);
        add(tfname);
        
        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(650, 250, 200, 30);
        lblfname.setFont(new Font("serif",Font.BOLD,20));
        add(lblfname);
        
        tffname = new JTextField();
        tffname.setBounds(850, 250, 150, 30);
        add(tffname);
        
        JLabel lblroll = new JLabel("Roll Number");
        lblroll.setBounds(250, 300, 200, 30);
        lblroll.setFont(new Font("serif",Font.BOLD,20));
        add(lblroll);
        
        roll = new JLabel("1202100400"+first4);
        roll.setBounds(400, 300, 200, 30);
        roll.setFont(new Font("serif",Font.BOLD,20));
        add(roll);
        
        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(650, 300, 200, 30);
        lbldob.setFont(new Font("serif",Font.BOLD,20));
        add(lbldob);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(850, 300, 150, 30);
        add(dcdob);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(250, 350, 200, 30);
        lbladdress.setFont(new Font("serif",Font.BOLD,20));
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(400, 350, 150, 30);
        add(tfaddress);
        
        JLabel lblphone = new JLabel("Phone Number");
        lblphone.setBounds(650, 350, 200, 30);
        lblphone.setFont(new Font("serif",Font.BOLD,20));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(850, 350, 150, 30);
        add(tfphone);
        
        JLabel lblemail = new JLabel("Email ID");
        lblemail.setBounds(250, 400, 200, 30);
        lblemail.setFont(new Font("serif",Font.BOLD,20));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(400, 400, 150, 30);
        add(tfemail);
        
        JLabel lblx = new JLabel("Class X %");
        lblx.setBounds(650, 400, 200, 30);
        lblx.setFont(new Font("serif",Font.BOLD,20));
        add(lblx);
        
        tfx = new JTextField();
        tfx.setBounds(850, 400, 150, 30);
        add(tfx);
        
        JLabel lblxii = new JLabel("Class XII %");
        lblxii.setBounds(250, 450, 200, 30);
        lblxii.setFont(new Font("serif",Font.BOLD,20));
        add(lblxii);
        
        tfxii = new JTextField();
        tfxii.setBounds(400, 450, 150, 30);
        add(tfxii);
        
        JLabel lblaadhar = new JLabel("Aadhar Number");
        lblaadhar.setBounds(650, 450, 200, 30);
        lblaadhar.setFont(new Font("serif",Font.BOLD,20));
        add(lblaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(850, 450, 150, 30);
        add(tfaadhar);
        
        JLabel lblcourse = new JLabel("Course");
        lblcourse.setBounds(250, 500, 200, 30);
        lblcourse.setFont(new Font("serif",Font.BOLD,20));
        add(lblcourse);
        
        String course[] = {"B.Tech","BCA","BSc","BBA","M.Tech","MCA","MSc"};
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(400,500,150,30);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);
        
        JLabel lblbranch = new JLabel("Department");
        lblbranch.setBounds(650, 500, 200, 30);
        lblbranch.setFont(new Font("serif",Font.BOLD,20));
        add(lblbranch);
        
        String branch[] = {"Computer Science","Electronics","Mechanical","Civil","IT","BCA","BSc","BBA","MCA","MSc"};
        cbbranch = new JComboBox(branch);
        cbbranch.setBounds(850,500,150,30);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);
        
        submit = new JButton("Submit");
        submit.setBounds(475, 575, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("serif", Font.BOLD, 15));
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(675, 575, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("serif", Font.BOLD, 15));
        add(cancel);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
         if (ae.getSource()== submit){
             String name = tfname.getText();
             String fname = tffname.getText();
             String rollno = roll.getText();
             String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
             String address = tfaddress.getText();
             String phone = tfphone.getText();
             String email = tfemail.getText();
             String x = tfx.getText();
             String xii = tfxii.getText();
             String aadhar = tfaadhar.getText();
             String course = (String)cbcourse.getSelectedItem();
             String branch = (String)cbbranch.getSelectedItem();
                          
             try{
                 
                 String query = "Insert into student values('"+name+"','"+fname+"','"+rollno+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+x+"','"+xii+"','"+aadhar+"','"+course+"','"+branch+"')";
                 
                 Conn c = new Conn();
                 c.s.executeUpdate(query);
                 
                 JOptionPane.showMessageDialog(null, "Student Details Inserted Successfully");
                 setVisible(false);
                 
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
        new AddStudent();
    }
}

