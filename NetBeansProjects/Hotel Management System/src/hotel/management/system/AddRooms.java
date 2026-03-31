
package hotel.management.system;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class AddRooms extends JFrame implements ActionListener{
    
    JButton add, cancel;
    JTextField troom, tprice;
    JComboBox typecombo, availablecombo, cleancombo;
    
    
    AddRooms() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Rooms");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        heading.setBounds(150,20,200,30);
        add(heading);
        
         JLabel lblroomno= new JLabel("Room Numbers ");
        lblroomno.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblroomno.setBounds(60,80,120,20);
        add(lblroomno);
        
         troom = new JTextField();
        troom.setBounds(200,80,150,30);
        add(troom);
        
                   JLabel lblavailable = new JLabel("Availability");
	lblavailable.setForeground(new Color(25, 25, 112));
	lblavailable.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblavailable.setBounds(60, 130, 120, 30);
	add(lblavailable);
        
                    String availableOptions[] = {"Available", "Occupied"};
                     availablecombo = new JComboBox(availableOptions);
                    availablecombo.setBounds(200,130,150,30);
                    availablecombo.setBackground(Color.WHITE);
                    add(availablecombo);
        
                    JLabel lblclean = new JLabel("Cleaning Status");
	lblclean.setForeground(new Color(25, 25, 112));
	lblclean.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblclean.setBounds(60, 180, 120, 30);
	add(lblclean);
        
                    String cleanOptions[] = {"Cleaned", "Dirty"};
                     cleancombo = new JComboBox(cleanOptions);
                    cleancombo.setBounds(200,180,150,30);
                    cleancombo.setBackground(Color.WHITE);
                    add(cleancombo);
                    
         JLabel lblprice= new JLabel("Price  ");
        lblprice.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblprice.setBounds(60,230,120,20);
        add(lblprice);
        
         tprice = new JTextField();
        tprice.setBounds(200,230,150,30);
        add(tprice);
        
                   JLabel lbltype = new JLabel("Bed Type ");
	lbltype.setForeground(new Color(25, 25, 112));
	lbltype.setFont(new Font("Tahoma", Font.BOLD, 14));
	lbltype.setBounds(60, 280, 120, 30);
	add(lbltype);
        
                    String typeOptions[] = {"Single Bed", "Double Bed"};
                     typecombo = new JComboBox(typeOptions);
                    typecombo.setBounds(200,280,150,30);
                    typecombo.setBackground(Color.WHITE);
                    add(typecombo);
                    
                     add = new JButton("Add Rooms");
                    add.setForeground(Color.WHITE);
                    add.setBackground(Color.BLACK);
                   add.addActionListener(this);
                    add.setBounds(60,350,130,30);
                    add(add);
                    
                     cancel = new JButton("Cancel ");
                    cancel.setForeground(Color.WHITE);
                    cancel.setBackground(Color.BLACK);
                    cancel.addActionListener(this);
                    cancel.setBounds(220,350,130,30);
                    add(cancel);
                    
                    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/room1.jpg"));
                    Image i2 = i1.getImage().getScaledInstance(800, 700, Image.SCALE_DEFAULT);
                    ImageIcon i3 = new ImageIcon(i2);
                    JLabel image = new JLabel(i3);
                    image.setBounds(400,30,570,360);
                    add(image);
                    
      
        
        
        
        
        
        setBounds(370,250,990,470);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if  (ae.getSource() == add ){
            String roomnumber = troom.getText();
            String availability = (String) availablecombo.getSelectedItem();
            String status = (String) cleancombo.getSelectedItem();
            String price = tprice.getText();
            String type = (String) typecombo.getSelectedItem();
            
            try{
                
                Conn conn = new Conn();
                String str = "insert into room values ( '"+roomnumber+"', '"+availability +"', '"+status+"','"+price+"', '"+type+"')";
                
                conn.s.executeUpdate(str);
                
                JOptionPane.showMessageDialog(null, "New Room Added Successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
            
    
} else{
    setVisible(false);
}
}
    
    public static void main(String [] args){
        new AddRooms();
    } 
    
}


    
