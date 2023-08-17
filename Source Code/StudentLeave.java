package university.of.technology;

import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class StudentLeave extends JFrame implements ActionListener{
    
    Choice cempid,ctime;
    JDateChooser dcdate;
    JButton submit,cancel;
    
    StudentLeave(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)size.getWidth();
        int height = (int)size.getHeight();
        setSize(width, height );
        
        JLabel heading = new JLabel("UNIVERSITY OF TECHNOLOGY ");
        heading.setBounds(325,50,700,50);
        heading.setFont(new Font("Tahoma",Font.BOLD,40));
        add(heading);
        
        JLabel subheading = new JLabel("APPLY FOR LEAVE");
        subheading.setBounds(500, 130, 500, 50);
        subheading.setFont(new Font("serif",Font.BOLD,30));
        add(subheading);

        
        JLabel lblrollno = new JLabel("Search by Roll Number");
        lblrollno.setBounds(550,230,200,30);
        lblrollno.setFont(new Font("serif", Font.BOLD, 20));
        add(lblrollno);
        
        cempid = new Choice();
        cempid.setBounds(550,260,200,30);
        add(cempid);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from student");
            while(rs.next()){
                cempid.add(rs.getString("rollno"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(550,310,200,20);
        lbldate.setFont(new Font("serif", Font.BOLD, 20));
        add(lbldate);
        
        dcdate = new JDateChooser();
        dcdate.setBounds(550, 340, 200, 20);
        add(dcdate);
        
        JLabel lbltime = new JLabel("Time Duration");
        lbltime.setBounds(550,390,200,20);
        lbltime.setFont(new Font("serif", Font.BOLD, 20));
        add(lbltime);
        
        ctime = new Choice();
        ctime.setBounds(550,420,200,20);
        ctime.add("Full Day");
        ctime.add("Half Day");
        add(ctime);
        
        
        submit = new JButton("Submit");
        submit.setBounds(500, 550, 100, 25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("serif", Font.BOLD, 20));
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(700, 550, 100, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("serif", Font.BOLD, 20));
        add(cancel);
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
         if (ae.getSource()== submit){
             String empId = cempid.getSelectedItem();
             String date = ((JTextField)dcdate.getDateEditor().getUiComponent()).getText();
             String duration = ctime.getSelectedItem();
               
             String query = "Insert into studentleave values('"+empId+"','"+date+"','"+duration+"')";
             
             try{
                 Conn c = new Conn();
                 c.s.executeUpdate(query);
                 
                 JOptionPane.showMessageDialog(null, "Leave Confirmed");
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
        new StudentLeave();
    }
}


