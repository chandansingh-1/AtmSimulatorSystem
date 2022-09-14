
package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{
    
    JTextField enterAmount;
    JButton deposit,back;
    JLabel heading;
    String pin;
    Deposit(String pin){
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
        JLabel label = new JLabel(i3);
        label.setBounds(350, 20, 820, 740);
        background.add(label);
        
        heading = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        heading.setForeground(Color.BLACK);
        heading.setFont(new Font("System", Font.BOLD, 14));
        
        enterAmount = new JTextField();
        enterAmount.setFont(new Font("Raleway", Font.BOLD, 14));
        
        deposit = new JButton("DEPOSIT");
        back = new JButton("BACK");
        
        setLayout(null);
        
        heading.setBounds(175,60,300,30);
        label.add(heading);
        
        enterAmount.setBounds(200,110,240,25);
        label.add(enterAmount);
        
        deposit.setBounds(345,260,145,25);
        label.add(deposit);
        
        back.setBounds(345,290,145,25);
        label.add(back);
        
        deposit.addActionListener(this);
        back.addActionListener(this);
        
        //setSize(860,750);
        setExtendedState(JFrame.MAXIMIZED_BOTH);//full screen frame
        setUndecorated(true);
//        setLocation(400,0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{        
            String amount = enterAmount.getText();
            Date date = new Date();
            if(ae.getSource()==deposit){
                if(enterAmount.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
                }else{
                    Conn c1 = new Conn();
                    c1.s.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Deposit', '"+amount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Deposited Successfully");
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }
            }else if(ae.getSource()==back){
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
            
    }
    
    public static void main(String[] args){
        new Deposit("").setVisible(true);
    }
}