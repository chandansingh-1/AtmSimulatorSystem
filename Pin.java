
package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Pin extends JFrame implements ActionListener{
    
    JPasswordField pass,rePin;
    JButton change,back;                               
    JLabel heading,newPin,reEnter;
    String pin;
    Pin(String pin){
        this.pin = pin;
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("AtmSimulatorSystem/icons/bankImg.jpg"));
        Image imageBack = img.getImage().getScaledInstance(1380, 760, Image.SCALE_DEFAULT);
        ImageIcon iIcon = new ImageIcon(imageBack);
        JLabel background = new JLabel(iIcon);
        background.setBounds(0,0,1380,760);
        add(background);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("AtmSimulatorSystem/icons/atm1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(820, 740, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l4 = new JLabel(i3);
        l4.setBounds(350, 20, 820, 740);
        background.add(l4);
        
        heading = new JLabel("CHANGE YOUR PIN");
        heading.setFont(new Font("System", Font.BOLD, 15));
        heading.setForeground(Color.BLACK);
        
        newPin = new JLabel("New PIN:");
        newPin.setFont(new Font("System", Font.BOLD, 15));
        newPin.setForeground(Color.BLACK);
        
        reEnter = new JLabel("Re-Enter New PIN:");
        reEnter.setFont(new Font("System", Font.BOLD, 15));
        reEnter.setForeground(Color.BLACK);
        
        pass = new JPasswordField();
        pass.setFont(new Font("Raleway", Font.BOLD, 18));
        
        rePin = new JPasswordField();
        rePin.setFont(new Font("Raleway", Font.BOLD, 18));
        
        change = new JButton("CHANGE");
        back = new JButton("BACK");
        
        change.addActionListener(this);
        back.addActionListener(this);
        
        setLayout(null);
        
        heading.setBounds(220,40,300,30);
        l4.add(heading);
        
        newPin.setBounds(180,100,200,35);
        l4.add(newPin);
        
        reEnter.setBounds(180,135,200,35);
        l4.add(reEnter);
        
        pass.setBounds(340,100,150,25);
        l4.add(pass);
        
        rePin.setBounds(340,140,150,25);
        l4.add(rePin);
        
        change.setBounds(345,260,145,25);
        l4.add(change);
        
        back.setBounds(345,290,145,25);
        l4.add(back);
        
//        setSize(860,750);
//        setLocation(500,0);
        setExtendedState(JFrame.MAXIMIZED_BOTH);//full screen frame
        setUndecorated(true);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        try{        
            String npin = pass.getText();
            String rpin = rePin.getText();
            
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }
            
            if(ae.getSource()==change){
                if (pass.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                }
                if (rePin.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Re-Enter new PIN");
                }
                
                Conn c1 = new Conn();
                String q1 = "update bank set pin = '"+rpin+"' where pin = '"+pin+"' ";
                String q2 = "update login set pin = '"+rpin+"' where pin = '"+pin+"' ";
                String q3 = "update signup3 set pin = '"+rpin+"' where pin = '"+pin+"' ";

                c1.s.executeUpdate(q1);
                c1.s.executeUpdate(q2);
                c1.s.executeUpdate(q3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transactions(rpin).setVisible(true);
            
            }else if(ae.getSource()==back){
                new Transactions(pin).setVisible(true);
                setVisible(false);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new Pin("").setVisible(true);
    }
}

