package university.of.technology;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable{
    
    Thread t;
    Splash() {
        
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)size.getWidth();
        int height = (int)size.getHeight();
        setSize(width, height );
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/page1(3).jpg"));
        Image i2 = i1.getImage().getScaledInstance(width,height, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        
        t = new Thread(this);
        t.start();
        
        setVisible(true);
        
        int x = 1;
        for(int i = 2; i <= 500; i+=4,x+=1){
            try{
            Thread.sleep(20);
            }catch(Exception e){}
        }
    } 
    
    public void run(){
        try{
            Thread.sleep(5000);
            setVisible(false);
            new LandingPage();
        }catch(Exception e){}
        
    }
    
    public static void main(String args[]){
        new Splash(); 
    }
}
