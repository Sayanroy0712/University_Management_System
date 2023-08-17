package university.of.technology;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class ExamDetails extends JFrame implements ActionListener{
    
    JTextField search;
    JButton submit,cancel;
    JTable table;
    
    ExamDetails(){
        
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)size.getWidth();
        int height = (int)size.getHeight();
        setSize(width, height );
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("UNIVERSITY OF TECHNOLOGY");
        heading.setBounds(325,30,700,50);
        heading.setFont(new Font("Tahoma",Font.BOLD,40));
        add(heading);
        
        JLabel subheading = new JLabel("Empowering Innovation through Technology");
        subheading.setBounds(400,70,700,50);
        subheading.setFont(new Font("Tahoma",Font.PLAIN,24));
        add(subheading);
        
        JLabel subsubheading = new JLabel("CHECK RESULT");
        subsubheading.setBounds(500, 150, 400, 50);
        subsubheading.setFont(new Font("serif",Font.BOLD,30));
        add(subsubheading);
        
        JLabel roll = new JLabel("Enter Roll Number");
        roll.setBounds(540,260,200,30);
        roll.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(roll);
        
        search = new JTextField();
        search.setBounds(520,300,200,30);
        search.setFont(new Font("serif",Font.PLAIN,20));
        add(search);
        
        submit = new JButton("Show Result");
        submit.setBounds(400, 450, 175, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("serif", Font.BOLD, 18));
        add(submit);
        
        cancel = new JButton("Back");
        cancel.setBounds(650, 450, 175, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("serif", Font.BOLD, 18));
        add(cancel);
        
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
         if (ae.getSource()== submit){
             setVisible(false);            
             new Marks(search.getText());
         }
         else if (ae.getSource()== cancel){
             setVisible(false);
         }
    }
    
    public static void main(String args[]){
        
        new ExamDetails();
        
    }
    
}

