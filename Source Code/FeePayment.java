package university.of.technology;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class FeePayment extends JFrame implements ActionListener{
    
    Choice crollno;
    JComboBox cbcourse, cbbranch, cbsemester;
    JLabel labeltotal;
    JButton pay, update,cancel;
    
    FeePayment(){
        
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)size.getWidth();
        int height = (int)size.getHeight();
        setSize(width, height );
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("UNIVERSITY OF TECHNOLOGY ");
        heading.setBounds(325,50,700,50);
        heading.setFont(new Font("Tahoma",Font.BOLD,40));
        add(heading);
        
        JLabel subheading = new JLabel("Empowering Innovation through Technology");
        subheading.setBounds(375,90,700,50);
        subheading.setFont(new Font("Tahoma",Font.PLAIN,24));
        add(subheading);
        
        JLabel subsubheading = new JLabel("PAY SEMESTER FEE");
        subsubheading.setBounds(450, 150, 500, 50);
        subsubheading.setFont(new Font("serif",Font.BOLD,30));
        add(subsubheading);
        
        
        JLabel lblroll = new JLabel("Select Roll Number");
        lblroll.setBounds(450,240,150,20);
        lblroll.setFont(new Font("serif",Font.BOLD,16));
        add(lblroll);
        
        crollno = new Choice();
        crollno.setBounds(600,240,150,20);
        add(crollno);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from student");
            while(rs.next()){
                crollno.add(rs.getString("rollno"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(450, 280, 150, 20);
        lblname.setFont(new Font("serif",Font.BOLD,16));
        add(lblname);
        
        JLabel tfname = new JLabel();
        tfname.setBounds(600, 280, 150, 20);
        tfname.setFont(new Font("serif",Font.PLAIN,16));
        add(tfname);
        
        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(450, 320, 150, 20);
        lblfname.setFont(new Font("serif",Font.BOLD,16));
        add(lblfname);
        
        JLabel tffname = new JLabel();
        tffname.setBounds(600, 320, 150, 20);
        tffname.setFont(new Font("serif",Font.PLAIN,16));
        add(tffname);
        
        try{
            Conn c = new Conn();
            String query = "Select * from student where rollno = '"+crollno.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                tfname.setText(rs.getString("name"));
                tffname.setText(rs.getString("fname"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        crollno.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                try{
                    Conn c = new Conn();
                    String query = "Select * from student where rollno = '"+crollno.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()){
                        tfname.setText(rs.getString("name"));
                        tffname.setText(rs.getString("fname"));
                    }
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        
        JLabel lblcourse = new JLabel("Course");
        lblcourse.setBounds(450, 360, 150, 20);
        lblcourse.setFont(new Font("serif",Font.BOLD,16));
        add(lblcourse);
        
        String course[] = {"BTech","BCA","Bsc","BBA","MTech","MCA","MSc"};
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(600,360,150,20);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);
        
        JLabel lblbranch = new JLabel("Department");
        lblbranch.setBounds(450, 400, 150, 20);
        lblbranch.setFont(new Font("serif",Font.BOLD,16));
        add(lblbranch);
        
        String branch[] = {"Computer Science","Electronics","Mechanical","Civil","IT","BCA","BSc","BBA","MCA","MSc"};
        cbbranch = new JComboBox(branch);
        cbbranch.setBounds(600,400,150,20);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);

        JLabel lblsemester = new JLabel("Semester");
        lblsemester.setBounds(450,440,150,20);
        lblsemester.setFont(new Font("serif",Font.BOLD,16));
        add(lblsemester);
        
        String semester[] = {"semester1","semester2","semester3","semester4","semester5","semester6","semester7","semester8"};
        cbsemester = new JComboBox(semester);
        cbsemester.setBounds(600,440,150,20);
        cbsemester.setBackground(Color.WHITE);
        add(cbsemester);
        
        JLabel lbltotal = new JLabel("Total Payble");
        lbltotal.setBounds(450,480,150,20);
        lbltotal.setFont(new Font("serif",Font.BOLD,16));
        add(lbltotal);
        
        labeltotal = new JLabel();
        labeltotal.setBounds(600,480,150,20);
        labeltotal.setFont(new Font("serif",Font.BOLD,16));
        add(labeltotal);
        
        update = new JButton("Update");
        update.setBounds(450, 540, 100, 30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        update.setFont(new Font("serif", Font.BOLD, 15));
        add(update);
        
        pay = new JButton("Pay Fee");
        pay.setBounds(560, 540, 100, 30);
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.WHITE);
        pay.addActionListener(this);
        pay.setFont(new Font("serif", Font.BOLD, 15));
        add(pay);
        
        cancel = new JButton("Back");
        cancel.setBounds(670, 540, 100, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("serif", Font.BOLD, 15));
        add(cancel);
        
        setVisible(true);
        
    }
    
     public void actionPerformed(ActionEvent ae){
         if (ae.getSource()== update){
                       
             String course = (String)cbcourse.getSelectedItem();
             String semester = (String)cbsemester.getSelectedItem();
             
             try{
                 Conn c = new Conn();
                 ResultSet rs = c.s.executeQuery("Select * from fee where course='"+course+"'");
                 while(rs.next()){
                     labeltotal.setText(rs.getString(semester));
                 }
             }
             catch(Exception e){
                 e.printStackTrace();
             }
             
         }
         else if (ae.getSource()== pay){
             String rollno = crollno.getSelectedItem();
             String course = (String)cbcourse.getSelectedItem();
             String semester = (String)cbsemester.getSelectedItem();
             String branch = (String)cbbranch.getSelectedItem();
             String total = labeltotal.getText();
             
             try{
                 Conn c = new Conn();
                 c.s.executeUpdate("Insert into collegefee values('"+rollno+"','"+course+"','"+branch+"','"+semester+"','"+total+"')");
                 JOptionPane.showMessageDialog(null,"Payment Done Successfully");
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
        new FeePayment();
    }
    
}
