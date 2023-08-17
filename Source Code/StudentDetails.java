package university.of.technology;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class StudentDetails extends JFrame implements ActionListener{
    
    Choice crollno;
    JTable table;
    JButton search, print, update, add, cancel;
    
    StudentDetails(){
        
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)size.getWidth();
        int height = (int)size.getHeight();
        setSize(width, height );
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("UNIVERSITY OF TECHNOLOGY ");
        heading.setBounds(50,30,550,50);
        heading.setFont(new Font("Tahoma",Font.BOLD,32));
        add(heading);
        
        JLabel subheading = new JLabel("Empowering Innovation through Technology");
        subheading.setBounds(50,70,700,50);
        subheading.setFont(new Font("Tahoma",Font.PLAIN,24));
        add(subheading);
       
        JLabel roll = new JLabel("Search by Roll Number");
        roll.setBounds(50,150,180,20);
        add(roll);
        
        crollno = new Choice();
        crollno.setBounds(240,150,150,25);
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
        
        table = new JTable();
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,300,width,500);
        add(jsp);
        
        search = new JButton("Search");
        search.setBounds(375,250,80,20);
        search.addActionListener(this);
        add(search);
         
        print = new JButton("Print");
        print.setBounds(475,250,80,20);
        print.addActionListener(this);
        add(print);
        
        add = new JButton("Add");
        add.setBounds(575,250,80,20);
        add.addActionListener(this);
        add(add);
        
        update = new JButton("Update");
        update.setBounds(675,250,80,20);
        update.addActionListener(this);
        add(update);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(775,250,80,20);
        cancel.addActionListener(this);
        add(cancel);
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
         if (ae.getSource()== search){
             String query = "Select * from student where rollno = '"+crollno.getSelectedItem()+"'";
             try{
                 Conn c = new Conn();
                 ResultSet rs = c.s.executeQuery(query);
                 table.setModel(DbUtils.resultSetToTableModel(rs));
             }
             catch(Exception e){
                 e.printStackTrace();
             }
         }
         else if (ae.getSource()== print){
             try{
                 table.print();
             }
             catch(Exception e){
                 e.printStackTrace();
             }
         }
         else if (ae.getSource()== add){
             setVisible(false);
             new AddStudent();
         }
         else if (ae.getSource()== update){
             setVisible(false);
             new UpdateStudent();
         }
         else{
             setVisible(false);
         }
    }
    
    public static void main(String args[]){
        new StudentDetails();
    }
}
