package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Transactions extends JFrame implements ActionListener{

    JLabel heading;
    JButton deposit,cashWithdraw,fastCash,miniSt,pinchange,balEnquiry,exit;
    String pin;
    Transactions(String pin){
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
        JLabel l2 = new JLabel(i3);
        l2.setBounds(350, 20, 820, 740);
        background.add(l2);
        
        heading = new JLabel("Please Select Your Transaction");
        heading.setForeground(Color.BLACK);
        heading.setFont(new Font("System", Font.BOLD, 16));
        
       
        deposit = new JButton("DEPOSIT");
        cashWithdraw = new JButton("CASH WITHDRAWL");
        fastCash = new JButton("FAST CASH");
        miniSt = new JButton("MINI STATEMENT");
        pinchange = new JButton("PIN CHANGE");
        balEnquiry = new JButton("BALANCE ENQUIRY");
        exit = new JButton("EXIT");
        
        setLayout(null);
        
        heading.setBounds(190,60,300,30);
        l2.add(heading);
        
        deposit.setBounds(140,190,145,25);
        l2.add(deposit);
        
        cashWithdraw.setBounds(345,190,145,25);
        l2.add(cashWithdraw);
        
        fastCash.setBounds(140,225,145,25);
        l2.add(fastCash);
        
        miniSt.setBounds(345,225,145,25);
        l2.add(miniSt);
        
        pinchange.setBounds(140,260,145,25);
        l2.add(pinchange);
        
        balEnquiry.setBounds(345,260,145,25);
        l2.add(balEnquiry);
        
        exit.setBounds(345,290,145,25);
        l2.add(exit);
        
        
        deposit.addActionListener(this);
        cashWithdraw.addActionListener(this);
        fastCash.addActionListener(this);
        miniSt.addActionListener(this);
        pinchange.addActionListener(this);
        balEnquiry.addActionListener(this);
        exit.addActionListener(this);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);//full screen frame
        setUndecorated(true);
        setVisible(true);
        
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==deposit){ 
            setVisible(false);
            new Deposit(pin).setVisible(true);
        }else if(ae.getSource()==cashWithdraw){ 
            setVisible(false);
            new Withdrawl(pin).setVisible(true);
        }else if(ae.getSource()==fastCash){ 
            setVisible(false);
            new FastCash(pin).setVisible(true);
        }else if(ae.getSource()==miniSt){ 
            new MiniStatement(pin).setVisible(true);
        }else if(ae.getSource()==pinchange){ 
            setVisible(false);
            new Pin(pin).setVisible(true);
        }else if(ae.getSource()==balEnquiry){ 
            this.setVisible(false);
            new BalanceEnquiry(pin).setVisible(true);
        }else if(ae.getSource()==exit){ 
            System.exit(0);
        }
    }
    
    public static void main(String[] args){
        new Transactions("").setVisible(true);
    }
}
