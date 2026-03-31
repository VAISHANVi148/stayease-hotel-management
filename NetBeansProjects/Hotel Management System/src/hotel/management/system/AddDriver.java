
package hotel.management.system;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class AddDriver extends JFrame implements ActionListener{
    
    JButton add, cancel;
    JTextField tname, tprice,tage, tcompany, tmodel,tlocation;
    JComboBox typecombo, availablecombo, cleancombo, agecombo, gendercombo;
    
    
    AddDriver() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Drivers");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        heading.setBounds(150,10,200,30);
        add(heading);
        
         JLabel lblroomno= new JLabel("Name  ");
        lblroomno.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblroomno.setBounds(60,70,120,20);
        add(lblroomno);
        
         tname = new JTextField();
         tname.setBounds(200,80,150,30);
         add(tname);
        
                   JLabel lblage = new JLabel("Age");
	lblage.setForeground(new Color(25, 25, 112));
	lblage.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblage.setBounds(60, 110, 120, 30);
	add(lblage);
        
                    tage = new JTextField();
         tage.setBounds(200,110,150,30);
         add(tage);
        
                    JLabel lblclean = new JLabel(" Gender");
	lblclean.setForeground(new Color(25, 25, 112));
	lblclean.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblclean.setBounds(60, 150, 120, 30);
	add(lblclean);
        
                    String cleanOptions[] = {"Male", "Female"};
                     gendercombo = new JComboBox(cleanOptions);
                    gendercombo.setBounds(200,150,150,30);
                    gendercombo.setBackground(Color.WHITE);
                    add(gendercombo);
                    
         JLabel lblprice= new JLabel("Car Company  ");
        lblprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblprice.setBounds(60,190,120,20);
        add(lblprice);
        
         tcompany = new JTextField();
        tcompany.setBounds(200,190,150,30);
        add(tcompany);
        
        JLabel lbltype= new JLabel("Car Model  ");
        lbltype.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbltype.setBounds(60,230,120,20);
        add(lbltype);
        
                     tmodel = new JTextField();
        tmodel.setBounds(200,230,150,30);
        add(tmodel);
        
          JLabel lblavailable= new JLabel("Available  ");
        lblavailable.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblavailable.setBounds(60,270,120,20);
        add(lblavailable);
        
          String driverOptions[] = {"Available", "Busy"};
                     availablecombo = new JComboBox(driverOptions);
                    availablecombo .setBounds(200,270,150,30);
                    availablecombo .setBackground(Color.WHITE);
                    add(availablecombo );
                    
                    JLabel lbllocation= new JLabel("Location  ");
        lbllocation.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbllocation.setBounds(60,310,120,20);
        add(lbllocation);
        
                     tlocation = new JTextField();
        tlocation.setBounds(200,310,150,30);
        add(tlocation);
                    
        
        
        
        
                    
                    
                    
                     add = new JButton("Add Driver");
                    add.setForeground(Color.WHITE);
                    add.setBackground(Color.BLACK);
                   add.addActionListener(this);
                    add.setBounds(60,370,130,30);
                    add(add);
                    
                     cancel = new JButton("Cancel ");
                    cancel.setForeground(Color.WHITE);
                    cancel.setBackground(Color.BLACK);
                    cancel.addActionListener(this);
                    cancel.setBounds(220,370,130,30);
                    add(cancel);
                    
                    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/driver.jpg"));
                    Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
                    ImageIcon i3 = new ImageIcon(i2);
                    JLabel image = new JLabel(i3);
                    image.setBounds(400,40,550,330);
                    add(image);
                    
      
        
        
        
        
        
        setBounds(300,200,980,470);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if  (ae.getSource() == add ){
            String name = tname.getText();
            String age = tage.getText();
            String gender = (String) gendercombo.getSelectedItem();
            String company = tcompany.getText();
            String brand = tmodel.getText();
            String available = (String) availablecombo.getSelectedItem();
            String location = tlocation.getText();
            
            try{
                
                Conn conn = new Conn();
                 String str = "insert into driver values ('"+name+"','"+age+"','"+gender+"','"+company+"','"+brand+"','"+available+"','"+location+"')";                
                conn.s.executeUpdate(str);
                
                JOptionPane.showMessageDialog(null, "New Driver Added Successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
            
    
} else{
    setVisible(false);
}
}
    
    public static void main(String [] args){
        new AddDriver();
    } 
    
}
