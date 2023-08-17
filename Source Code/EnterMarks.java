package university.of.technology;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class EnterMarks extends JFrame implements ActionListener{
    
    Choice crollno;
    JComboBox cbsemester;
    JButton submit,cancel;
    JTextField tfsub1,tfsub2,tfsub3,tfsub4,tfsub5,tfmarks1,tfmarks2,tfmarks3,tfmarks4,tfmarks5;
    
    EnterMarks(){
        
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
        
        JLabel heading = new JLabel("UNIVERSITY OF TECHNOLOGY ");
        heading.setBounds(50,10,700,50);
        heading.setFont(new Font("Tahoma",Font.BOLD,40));
        add(heading);
        
        JLabel subheading = new JLabel("Empowering Innovation through Technology");
        subheading.setBounds(50,60,700,50);
        subheading.setFont(new Font("Tahoma",Font.PLAIN,26));
        add(subheading);
        
        JLabel subsubheading = new JLabel("ENTER MARKS OF STUDENT");
        subsubheading.setBounds(175, 140, 500, 50);
        subsubheading.setFont(new Font("Tahoma",Font.BOLD,30));
        add(subsubheading);
        
        JLabel lblroll = new JLabel("Select Roll Number");
        lblroll.setBounds(200,250,200,20);
        lblroll.setFont(new Font("serif",Font.BOLD,20));
        add(lblroll);
        
        crollno = new Choice();
        crollno.setBounds(400,250,150,20);
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
        
        JLabel lblsemester = new JLabel("Select Semester");
        lblsemester.setBounds(200,300,200,20);
        lblsemester.setFont(new Font("serif",Font.BOLD,20));
        add(lblsemester);
        
        String semester[] = {"1st Semester","2nd Semester","3rd Semester","4th Semester","5th Semester","6th Semester","7th Semester","8th Semester"};
        cbsemester = new JComboBox(semester);
        cbsemester.setBounds(400,300,150,20);
        cbsemester.setBackground(Color.WHITE);
        add(cbsemester);
        
        JLabel lblsubject = new JLabel("Enter Subject");
        lblsubject.setBounds(225,350,200,40);
        lblsubject.setFont(new Font("serif",Font.PLAIN,20));
        add(lblsubject);
        
        JLabel lblmarks = new JLabel("Enter Marks");
        lblmarks.setBounds(450,350,200,40);
        lblmarks.setFont(new Font("serif",Font.PLAIN,20));
        add(lblmarks);
        
        tfsub1 = new JTextField();
        tfsub1.setBounds(175,400,200,20);
        add(tfsub1);
        
        tfsub2 = new JTextField();
        tfsub2.setBounds(175,430,200,20);
        add(tfsub2);
        
        tfsub3 = new JTextField();
        tfsub3.setBounds(175,460,200,20);
        add(tfsub3);
        
        tfsub4 = new JTextField();
        tfsub4.setBounds(175,490,200,20);
        add(tfsub4);
        
        tfsub5 = new JTextField();
        tfsub5.setBounds(175,520,200,20);
        add(tfsub5);
        
        tfmarks1 = new JTextField();
        tfmarks1.setBounds(390,400,200,20);
        add(tfmarks1);
        
        tfmarks2 = new JTextField();
        tfmarks2.setBounds(390,430,200,20);
        add(tfmarks2);
        
        tfmarks3 = new JTextField();
        tfmarks3.setBounds(390,460,200,20);
        add(tfmarks3);
        
        tfmarks4 = new JTextField();
        tfmarks4.setBounds(390,490,200,20);
        add(tfmarks4);
        
        tfmarks5 = new JTextField();
        tfmarks5.setBounds(390,520,200,20);
        add(tfmarks5);
        
        submit = new JButton("Submit");
        submit.setBounds(215, 560, 150, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("serif", Font.BOLD, 15));
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(400, 560, 150, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("serif", Font.BOLD, 15));
        add(cancel);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
         if (ae.getSource()== submit){
                          
             try{
                 
                 String query1 = "Insert into subject values('"+crollno.getSelectedItem()+"','"+cbsemester.getSelectedItem()+"','"+tfsub1.getText()+"','"+tfsub2.getText()+"','"+tfsub3.getText()+"','"+tfsub4.getText()+"','"+tfsub5.getText()+"')";
                 String query2 = "Insert into marks values('"+crollno.getSelectedItem()+"','"+cbsemester.getSelectedItem()+"','"+tfmarks1.getText()+"','"+tfmarks2.getText()+"','"+tfmarks3.getText()+"','"+tfmarks4.getText()+"','"+tfmarks5.getText()+"')";
                 
                 Conn c = new Conn();
                 c.s.executeUpdate(query1);
                 c.s.executeUpdate(query2);
                 
                 JOptionPane.showMessageDialog(null, "Marks Inserted Successfully");
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
        new EnterMarks();
    }
    
}

