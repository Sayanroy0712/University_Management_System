package university.of.technology;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Marks extends JFrame implements ActionListener{
    
    String rollno;
    JButton cancel;
    
    Marks(String rollno){
        this.rollno = rollno;
        
        setSize(600,700);
        setLocation(350,0);
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("UNIVERSITY OF TECHNOLOGY ");
        heading.setBounds(50,30,550,50);
        heading.setFont(new Font("Tahoma",Font.BOLD,32));
        
        JLabel subheading = new JLabel("Empowering Innovation through Technology");
        subheading.setBounds(85,70,700,50);
        subheading.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(subheading);
        add(heading);
        
        JLabel subsubheading = new JLabel("Result of Examination");
        subsubheading.setBounds(180, 135, 500, 20);
        subsubheading.setFont(new Font("serif",Font.BOLD,24));
        add(subsubheading);
        
        JLabel lblname = new JLabel();
        lblname.setBounds(50, 180, 500, 25);
        lblname.setFont(new Font("serif",Font.PLAIN,18));
        add(lblname);
        
        JLabel lblfname = new JLabel();
        lblfname.setBounds(50, 210, 500, 25);
        lblfname.setFont(new Font("serif",Font.PLAIN,18));
        add(lblfname);
        
        JLabel lblrollno = new JLabel("Roll Number :   "+ rollno);
        lblrollno.setBounds(50, 240, 500, 25);
        lblrollno.setFont(new Font("serif",Font.PLAIN,18));
        add(lblrollno);
        
        JLabel lblsemester = new JLabel();
        lblsemester.setBounds(50, 270, 500, 20);
        lblsemester.setFont(new Font("serif",Font.PLAIN,18));
        add(lblsemester);
        
        JLabel lblcourse = new JLabel();
        lblcourse.setBounds(50, 300, 500, 25);
        lblcourse.setFont(new Font("serif",Font.PLAIN,18));
        add(lblcourse);
        
        JLabel lblbranch = new JLabel();
        lblbranch.setBounds(50, 330, 500, 25);
        lblbranch.setFont(new Font("serif",Font.PLAIN,18));
        add(lblbranch);
        
        try{
            Conn c = new Conn();
                ResultSet rs3 = c.s.executeQuery("Select * from student where rollno = '"+rollno+"'");
                while(rs3.next()){
                    lblname.setText("Name :          "+ rs3.getString("name"));
                    lblfname.setText("Father's Name : "+ rs3.getString("fname"));
                    lblcourse.setText("Course :        "+ rs3.getString("course"));
                    lblbranch.setText("Branch :        "+ rs3.getString("branch"));
                }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel sub1 = new JLabel();
        sub1.setBounds(650, 400, 500, 20);
        sub1.setFont(new Font("serif",Font.PLAIN,18));
        add(sub1);
        
        JLabel sub2 = new JLabel();
        sub2.setBounds(650, 430, 500, 20);
        sub2.setFont(new Font("serif",Font.PLAIN,18));
        add(sub2);
        
        JLabel sub3 = new JLabel();
        sub3.setBounds(650, 460, 500, 20);
        sub3.setFont(new Font("serif",Font.PLAIN,18));
        add(sub3);
        
        JLabel sub4 = new JLabel();
        sub4.setBounds(650, 490, 500, 20);
        sub4.setFont(new Font("serif",Font.PLAIN,18));
        add(sub4);
        
        JLabel sub5 = new JLabel();
        sub5.setBounds(650, 520, 500, 20);
        sub5.setFont(new Font("serif",Font.PLAIN,18));
        add(sub5);
        
        try{
            Conn c = new Conn();
            ResultSet rs1 = c.s.executeQuery("Select * from subject where rollno = '"+rollno+"'");
            while(rs1.next()){
                sub1.setText(rs1.getString("subject1"));
                sub2.setText(rs1.getString("subject2"));
                sub3.setText(rs1.getString("subject3"));
                sub4.setText(rs1.getString("subject4"));
                sub5.setText(rs1.getString("subject5"));
            }
            
            ResultSet rs2 = c.s.executeQuery("Select * from marks where rollno = '"+rollno+"'");
            while(rs2.next()){
                sub1.setText(sub1.getText() + ":      " + rs2.getString("marks1"));
                sub2.setText(sub2.getText() + ":      " + rs2.getString("marks2"));
                sub3.setText(sub3.getText() + ":          " + rs2.getString("marks3"));
                sub4.setText(sub4.getText() + ":  " + rs2.getString("marks4"));
                sub5.setText(sub5.getText() + ":      " + rs2.getString("marks5"));
                lblsemester.setText("Semester :      "+ rs2.getString("semester"));
                
                
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        cancel = new JButton("Back");
        cancel.setBounds(225, 560, 120, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("serif", Font.BOLD, 15));
        add(cancel);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
         setVisible(false);
    }
    
    public static void main(String args[]){
        new Marks("");
    }
    
}

