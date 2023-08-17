package university.of.technology;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class TeacherDetails extends JFrame implements ActionListener{
    
    Choice cempid;
    JTable table;
    JButton search, print, update, add, cancel;
    
    TeacherDetails(){
        
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
       
        JLabel searchby = new JLabel("Search by Employee ID");
        searchby.setBounds(50,150,180,20);
        searchby.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(searchby);
        
        cempid = new Choice();
        cempid.setBounds(240,150,150,25);
        add(cempid);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from teacher");
            while(rs.next()){
                cempid.add(rs.getString("empId"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        table = new JTable();
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from teacher");
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
             String query = "Select * from teacher where empId = '"+cempid.getSelectedItem()+"'";
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
             new AddTeacher();
         }
         else if (ae.getSource()== update){
             setVisible(false);
             new UpdateTeacher();
         }
         else{
             setVisible(false);
         }
    }
    
    public static void main(String args[]){
        new TeacherDetails();
    }
}
