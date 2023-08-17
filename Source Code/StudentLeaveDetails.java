package university.of.technology;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class StudentLeaveDetails extends JFrame implements ActionListener{
    
    Choice cempid;
    JTable table;
    JButton search, print, cancel;
    
    StudentLeaveDetails(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)size.getWidth();
        int height = (int)size.getHeight();
        setSize(width, height );
       
        JLabel heading = new JLabel("UNIVERSITY OF TECHNOLOGY ");
        heading.setBounds(50,30,550,50);
        heading.setFont(new Font("Tahoma",Font.BOLD,32));
        add(heading);
        
        JLabel subheading = new JLabel("Empowering Innovation through Technology");
        subheading.setBounds(50,70,700,50);
        subheading.setFont(new Font("Tahoma",Font.PLAIN,24));
        add(subheading);
       
        JLabel searchby = new JLabel("Search by Roll Number");
        searchby.setBounds(50,150,180,20);
        searchby.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(searchby);
        
        cempid = new Choice();
        cempid.setBounds(240,150,150,25);
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
        
        table = new JTable();
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from studentleave");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,300,width,500);
        add(jsp);
        
        search = new JButton("Search");
        search.setBounds(475,250,80,20);
        search.addActionListener(this);
        add(search);
         
        print = new JButton("Print");
        print.setBounds(575,250,80,20);
        print.addActionListener(this);
        add(print);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(675,250,80,20);
        cancel.addActionListener(this);
        add(cancel);
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
         if (ae.getSource()== search){
             String query = "Select * from studentleave where rollno = '"+cempid.getSelectedItem()+"'";
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
         else{
             setVisible(false);
         }
    }
    
    public static void main(String args[]){
        new StudentLeaveDetails();
    }
}


