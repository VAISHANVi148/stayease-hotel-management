
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class AddCustomers extends JFrame implements ActionListener{
    
   JComboBox comboid;
   JTextField tnum, tname, tcountry, tdeposit;
   JRadioButton rmale, rfemale;
   Choice croom;
   JLabel lblcheckinitem, lbltime;
   JButton add, back;
    AddCustomers(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel text = new JLabel("NEW CUSTOMER FORM");
        text.setBounds(100,20,300,30);
        text.setFont (new Font("Raleway", Font.PLAIN, 20));
        add(text);
        
        
          
        JLabel lblid = new JLabel("ID");
        lblid.setBounds(35,80,100,20);
        lblid.setFont (new Font("Raleway", Font.PLAIN, 20));
        add(lblid);
        
        String options[] = {"Aadhar Card", "Passport", "Driving License", "Voter-id Card", "Ration Card"};
        comboid = new JComboBox(options);  // add
        comboid.setBounds(200,  80, 150, 25);
        comboid.setBackground(Color.WHITE);
        add(comboid);
        
         JLabel lblnum = new JLabel("Number");
        lblnum.setBounds(35,120,100,20);
        lblnum.setFont (new Font("Raleway", Font.PLAIN, 20));
        add(lblnum);
        
        tnum = new JTextField();
        tnum.setBounds(200,120,150,25);
        add(tnum);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(35,160,100,20);
        lblname.setFont (new Font("Raleway", Font.PLAIN, 20));
        add(lblname);
        
        tname = new JTextField();
        tname.setBounds(200,160,150,25);
        add(tname);
        
             JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(35,200,100,20);
        lblgender.setFont (new Font("Raleway", Font.PLAIN, 20));
        add(lblgender);
        
        rmale = new JRadioButton("Male");
        rmale.setBackground(Color.WHITE);
        rmale.setBounds(200,200,60,25);
        add(rmale);
        
         rfemale = new JRadioButton("Female");
        rfemale.setBackground(Color.WHITE);
        rfemale.setBounds(270,200,100,25);
        add(rfemale);
        
         JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(35,240,100,20);
        lblcountry.setFont (new Font("Raleway", Font.PLAIN, 20));
        add(lblcountry);
        
        tcountry = new JTextField();
        tcountry.setBounds(200,240,150,25);
        add(tcountry);
        
         JLabel lblroom = new JLabel(" Room Number");
        lblroom.setBounds(35,280,150,20);
        lblroom.setFont (new Font("Raleway", Font.PLAIN, 20));
        add(lblroom);
        
        croom = new Choice();
        
        try{
            
            Conn conn = new Conn();
            String query = "select * from room where availability =  'Available' ";
            ResultSet rs = (ResultSet) conn.s.executeQuery(query);
            while(rs.next()){
                croom.add(rs.getNString("roomnumber"));
            }
            
        } catch(Exception e){
            e.printStackTrace();
        }
        croom.setBounds(200,280,150,25);
        add(croom);
        
         lbltime = new JLabel(" Chekin Time");
        lbltime.setBounds(35,320,150,20);
        lbltime.setFont (new Font("Raleway", Font.PLAIN, 20));
        add(lbltime);
        
        Date date = new Date();
        
        //1 + 2 + 3 + 4 +
        
        lblcheckinitem = new JLabel(" " + date);
        lblcheckinitem.setBounds(200,320,150,25);
        lblcheckinitem.setFont (new Font("Raleway", Font.PLAIN, 16));
        add(lblcheckinitem);
        
        JLabel lbldeposit = new JLabel("Deposit");
        lbldeposit.setBounds(35,360,100,20);
        lbldeposit.setFont (new Font("Raleway", Font.PLAIN, 20));
        add(lbldeposit);
        
        tdeposit = new JTextField();
        tdeposit.setBounds(200,360,150,25);
        add(tdeposit);
        
        add = new JButton("Add");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(50, 410, 120, 30);
        add.addActionListener(this);
        add(add);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(260, 410, 120, 30);
        back.addActionListener(this);
        add(back);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,300,400);
        add(image);
        
        
        
        
       
  setBounds(350,200,800,550);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            String id = (String) comboid.getSelectedItem();
            String number = tnum.getText();
            String name = tname.getText();
            String gender  = null;
            
            if(rmale.isSelected()){
                gender = "Male";
            }
            else{
                gender = "Female";
            }
            String country = tcountry.getText();
            String room = croom.getSelectedItem();
            String time = lblcheckinitem.getText();
            String deposit = tdeposit.getText();
            
            try {
                String query = "insert into customerdata values  (' " + id + " ' , ' " + number + " ' ,' " + name +" ' , ' " + gender +" ' ,  ' " + country +" ' , ' " + room +" ', ' "+time+" ' , ' "+ deposit+" ')";               
                 
                String query2 = "update room set availability  = ' Occupied'  where roomnumber = ' " + room+" ' ";
                
                Conn conn = new Conn();
                
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "New Customer Added Successfully");
                
                setVisible(false);
                new Reception();
            
            }catch (Exception e){
                e.printStackTrace();
            }
            
        }
        else if (ae.getSource() == back ){
               setVisible(false);
                new Reception();
    }
    }
    
    public static void main(String[]args){
        new AddCustomers();
    }
    
}
