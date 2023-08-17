package university.of.technology;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateStudent extends JFrame implements ActionListener{
    
    JTextField tfaddress,tfphone,tfemail,tfcourse,tfbranch;
    JLabel roll;
    JButton submit,cancel;
    Choice cempid;
    
    UpdateStudent(){
        
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)size.getWidth();
        int height = (int)size.getHeight();
        setSize(width, height );
        
        setLayout(null);
        
        JLabel heading = new JLabel("UNIVERSITY OF TECHNOLOGY ");
        heading.setBounds(325,50,700,50);
        heading.setFont(new Font("Tahoma",Font.BOLD,40));
        add(heading);
        
        JLabel subheading = new JLabel("UPDATE STUDENT DETAILS");
        subheading.setBounds(420, 130, 500, 50);
        subheading.setFont(new Font("serif",Font.BOLD,30));
        add(subheading);
        
        JLabel lblroll = new JLabel("Select Roll Number");
        lblroll.setBounds(430,200,200,20);
        lblroll.setFont(new Font("serif",Font.BOLD,20));
        add(lblroll);
        
        cempid = new Choice();
        cempid.setBounds(630,200,200,20);
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
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(250, 250, 100, 30);
        lblname.setFont(new Font("serif",Font.BOLD,20));
        add(lblname);
        
        JLabel tfname = new JLabel();
        tfname.setBounds(400, 250, 150, 30);
        tfname.setFont(new Font("serif",Font.PLAIN,20));
        add(tfname);
        
        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(650, 250, 200, 30);
        lblfname.setFont(new Font("serif",Font.BOLD,20));
        add(lblfname);
        
        JLabel tffname = new JLabel();
        tffname.setBounds(850, 250, 150, 30);
        tffname.setFont(new Font("serif",Font.PLAIN,20));
        add(tffname);
        
        JLabel lblrollno = new JLabel("Roll Number");
        lblrollno.setBounds(250, 300, 200, 30);
        lblrollno.setFont(new Font("serif",Font.BOLD,20));
        add(lblrollno);
        
        roll = new JLabel();
        roll.setBounds(400, 300, 200, 30);
        roll.setFont(new Font("serif",Font.PLAIN,20));
        add(roll);
        
        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(650, 300, 200, 30);
        lbldob.setFont(new Font("serif",Font.BOLD,20));
        add(lbldob);
        
        JLabel dcdob = new JLabel();
        dcdob.setBounds(850, 300, 150, 30);
        dcdob.setFont(new Font("serif",Font.PLAIN,20));
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
        
        JLabel tfx = new JLabel();
        tfx.setBounds(850, 400, 150, 30);
        tfx.setFont(new Font("serif",Font.PLAIN,20));
        add(tfx);
        
        JLabel lblxii = new JLabel("Class XII %");
        lblxii.setBounds(250, 450, 200, 30);
        lblxii.setFont(new Font("serif",Font.BOLD,20));
        add(lblxii);
        
        JLabel tfxii = new JLabel();
        tfxii.setBounds(400, 450, 150, 30);
        tfxii.setFont(new Font("serif",Font.PLAIN,20));
        add(tfxii);
        
        JLabel lblaadhar = new JLabel("Aadhar Number");
        lblaadhar.setBounds(650, 450, 200, 30);
        lblaadhar.setFont(new Font("serif",Font.BOLD,20));
        add(lblaadhar);
        
        JLabel tfaadhar = new JLabel();
        tfaadhar.setBounds(850, 450, 150, 30);
        tfaadhar.setFont(new Font("serif",Font.PLAIN,20));
        add(tfaadhar);
        
        JLabel lblcourse = new JLabel("Education");
        lblcourse.setBounds(250, 500, 200, 30);
        lblcourse.setFont(new Font("serif",Font.BOLD,20));
        add(lblcourse);
        
        tfcourse = new JTextField();
        tfcourse.setBounds(400,500,150,30);
        add(tfcourse);
        
        JLabel lblbranch = new JLabel("Department");
        lblbranch.setBounds(650, 500, 200, 30);
        lblbranch.setFont(new Font("serif",Font.BOLD,20));
        add(lblbranch);
        
        tfbranch = new JTextField();
        tfbranch.setBounds(850,500,150,30);
        add(tfbranch);
        
        
        try{
            Conn c = new Conn();
            String query = "Select * from student where rollno = '"+cempid.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                tfname.setText(rs.getString("name"));
                tffname.setText(rs.getString("fname"));
                dcdob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                tfx.setText(rs.getString("class_x"));
                tfxii.setText(rs.getString("class_xii"));
                tfaadhar.setText(rs.getString("aadhar"));
                roll.setText(rs.getString("rollno"));
                tfcourse.setText(rs.getString("course"));
                tfbranch.setText(rs.getString("branch"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        cempid.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                try{
                    Conn c = new Conn();
                    String query = "Select * from student where rollno = '"+cempid.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()){
                        tfname.setText(rs.getString("name"));
                        tffname.setText(rs.getString("fname"));
                        dcdob.setText(rs.getString("dob"));
                        tfaddress.setText(rs.getString("address"));
                        tfphone.setText(rs.getString("phone"));
                        tfemail.setText(rs.getString("email"));
                        tfx.setText(rs.getString("class_x"));
                        tfxii.setText(rs.getString("class_xii"));
                        tfaadhar.setText(rs.getString("aadhar"));
                        roll.setText(rs.getString("rollno"));
                        tfcourse.setText(rs.getString("course"));
                        tfbranch.setText(rs.getString("branch"));
                    }
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        
        submit = new JButton("Update");
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
             String rollno = roll.getText();
             String address = tfaddress.getText();
             String phone = tfphone.getText();
             String email = tfemail.getText();
             String course = tfcourse.getText();
             String branch = tfbranch.getText();
                          
             try{
                 
                 String query = "Update student set address = '"+address+"',phone = '"+phone+"',email = '"+email+"',course = '"+course+"', branch = '"+branch+"' Where rollno='"+rollno+"'";
                 
                 Conn c = new Conn();
                 c.s.executeUpdate(query);
                 
                 JOptionPane.showMessageDialog(null, "Student Details Updated Successfully");
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
        new UpdateStudent();
    }
}


