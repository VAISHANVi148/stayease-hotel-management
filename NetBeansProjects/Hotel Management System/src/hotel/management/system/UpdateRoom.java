
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;



public class UpdateRoom extends JFrame implements ActionListener{

      Choice ccustomer;
        JTextField troom, tstatus, tpaid, tpending, tavailable;
        JButton back, update, check;
   
    
    UpdateRoom(){
        
      
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel text  = new JLabel("Update Room  Status");
        text.setFont(new Font ("Tahoma", Font.PLAIN, 25));
        text.setBounds(30,20,250,30);
        text.setForeground(Color.BLUE);
        add(text);
        
        JLabel lblid = new JLabel("Customer Id");
        lblid.setBounds(30,80,100,20);
        add(lblid);
        
        ccustomer = new Choice();
        ccustomer.setBounds(200,80,150,25);
        add(ccustomer);
        
     try {
    Conn c = new Conn();
    java.sql.ResultSet rs = c.s.executeQuery("select * from customerdata");

    while (rs.next()) {
        ccustomer.add(rs.getString("number"));
    }

} catch (Exception e) {
    e.printStackTrace();
}
       
       JLabel lblroom = new JLabel("Room Numbers");
        lblroom.setBounds(30,130,100,20);
        add(lblroom);
        
        troom = new JTextField();
        troom.setBounds(200,130,150,25);
        add(troom);
        
         JLabel lblname = new JLabel("Availability");
        lblname.setBounds(30,180,100,20);
        add(lblname);
        
        tavailable = new JTextField();
        tavailable.setBounds(200,180,150,25);
        add(tavailable);
        
        
            JLabel lblcheckin = new JLabel("Cleaning Status ");
        lblcheckin.setBounds(30,230,100,20);
        add(lblcheckin);
        
        tstatus = new JTextField();
        tstatus.setBounds(200,230,150,25);
        add(tstatus);
        
        
        
        
        check = new JButton("Check");
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        check.setBounds(30,300,100,30);
        check.addActionListener(this);
        add(check);
        
         update = new JButton("Update");
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.setBounds(150,300,100,30);
        update.addActionListener(this);
        add(update);
        
         back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(270,300,100,30);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,500,300);
        add(image);
        
      
        
        setBounds(300,200,980,450);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == check){
            String id = ccustomer.getSelectedItem();
           String query = "select * from customerdata where number = '" + id + "'";
            
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()){
                    troom.setText(rs.getString("room_no"));
                
                    
                } 
       ResultSet rs2 = c.s.executeQuery(
    "select * from room where roomnumber = '" + troom.getText().trim() + "'"
);
                while(rs2.next()){
             tavailable.setText(rs2.getString("availability"));
             tstatus.setText(rs2.getString("cleaning_status"));
            }
            } catch (Exception e) {
                   e.printStackTrace();
            }
            
        
        }
        else if(ae.getSource() == update) {
    
        
 String room = troom.getText().trim();
String availability = tavailable.getText().trim();
String status = tstatus.getText().trim();

try {
    Conn c = new Conn();

    String query = "update room set availability = '" + availability + 
                   "', cleaning_status = '" + status + 
                   "' where roomnumber = '" + room + "'";

    int rows = c.s.executeUpdate(query);
    System.out.println("Rows updated: " + rows);

    if(rows > 0){
        JOptionPane.showMessageDialog(null, "Room Updated Successfully");
    } else {
        JOptionPane.showMessageDialog(null, "Update Failed! Check Room Number");
    }

} catch(Exception e){
    e.printStackTrace();
}
}
        else{
    
    setVisible(false);
    new Reception();
                
                
                }
                
                }
        
    
    public static void main(String[] args){
        
        new UpdateRoom();
        
    }
    
}
