package university.of.technology;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Project extends JFrame implements ActionListener{
    
    JButton view, update, leave, marks, details, cancel;
    
    Project(){
        
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
        heading.setBounds(50,30,550,50);
        heading.setFont(new Font("Tahoma",Font.BOLD,32));
        add(heading);
        
        JLabel subheading = new JLabel("Empowering Innovation through Technology");
        subheading.setBounds(50,70,700,50);
        subheading.setFont(new Font("Tahoma",Font.PLAIN,24));
        add(subheading);
        
        JLabel subsubheading = new JLabel("Welcome to Faculty Dashboard");
        subsubheading.setBounds(50,120,700,50);
        subsubheading.setFont(new Font("Tahoma",Font.BOLD,30));
        add(subsubheading);
        
        view = new JButton("View Details");
        view.setBounds(50, 260, 200, 40);
        view.setBackground(Color.BLACK);
        view.setForeground(Color.WHITE);
        view.addActionListener(this);
        view.setFont(new Font("serif", Font.BOLD, 20));
        add(view);
        
        update = new JButton("Update Details");
        update.setBounds(50, 320, 200, 40);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        update.setFont(new Font("serif", Font.BOLD, 20));
        add(update);
        
        leave = new JButton("Apply for Leave");
        leave.setBounds(50, 380, 200, 40);
        leave.setBackground(Color.BLACK);
        leave.setForeground(Color.WHITE);
        leave.addActionListener(this);
        leave.setFont(new Font("serif", Font.BOLD, 20));
        add(leave);
        
        details = new JButton("Leave Details");
        details.setBounds(50, 440, 200, 40);
        details.setBackground(Color.BLACK);
        details.setForeground(Color.WHITE);
        details.addActionListener(this);
        details.setFont(new Font("serif", Font.BOLD, 20));
        add(details);
        
        marks = new JButton("Enter Marks");
        marks.setBounds(50, 500, 200, 40);
        marks.setBackground(Color.BLACK);
        marks.setForeground(Color.WHITE);
        marks.addActionListener(this);
        marks.setFont(new Font("serif", Font.BOLD, 20));
        add(marks);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(50, 560, 200, 40);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("serif", Font.BOLD, 15));
        add(cancel);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
         if (ae.getSource()== view){
             new TeacherDetails();
             setVisible(false);
         }
         else if (ae.getSource()== update){
             new UpdateTeacher();
             setVisible(false);
         }
         else if (ae.getSource()== leave){
             new TeacherLeave();
             setVisible(false);
         }
         else if (ae.getSource()== details){
             new TeacherLeaveDetails();
             setVisible(false);
         }
         else if (ae.getSource()== marks){
             new EnterMarks();
             setVisible(false);
         }
         else if (ae.getSource()== cancel){
             setVisible(false);
         }
    }
    
    public static void main(String args[]){
        new Project();
    }
}
