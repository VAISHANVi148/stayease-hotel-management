
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class HotelManagementSystem extends JFrame implements ActionListener {
     //JLabel l1;
     //JButton b1;
    
    
   HotelManagementSystem() {
               // setSize(1366,565);
               // setLocation(100,100);
                // setContentPane(300,300,1366,390);   frame size
                setBounds( 100,100,1366,844);
                setLayout(null);
             
               

		
                
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/h2.jpg"));
                JLabel img = new JLabel(i1);
                img.setBounds(0,0,1366,565);
                add(img);
                
                JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
                text.setBounds(20, 430, 1000, 90);
                text.setForeground(Color.BLACK);
                text.setFont(new Font("Serif",Font.PLAIN, 50));
                img.add(text);
                
                JButton next = new JButton("Next");
                next.setBounds(1150, 450, 150, 50);
                next.addActionListener(this);
                next.setForeground(Color.MAGENTA);
                next.setBackground(Color.WHITE);
                next.setFont(new Font("Serif",Font.PLAIN, 24));
                img.add(next);
                
                   
                setVisible(true);
              
                while(true){
                    text.setVisible(false);
                    try{
                        Thread.sleep(500);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    text.setVisible(true);
                    try{
                        Thread.sleep(500);
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                }
          
	}
   
   @Override
   public void actionPerformed(ActionEvent ae){
       setVisible(false);
       new Login();
   }
   
   

   
    public static void main(String[] args) {
        // TODO code application logic here
        HotelManagementSystem hotelManagementSystem = new HotelManagementSystem();
    }
    
}
