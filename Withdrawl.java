
package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
import java.sql.*;

public class Withdrawl extends JFrame implements ActionListener{
    
    JTextField amountEnter;
    JButton withdraw,back;
    JLabel heading1,heading2;
    String pin;
    Withdrawl(String pin){
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
        JLabel l3 = new JLabel(i3);
        l3.setBounds(350, 20, 820, 740);
        background.add(l3);
        
        heading1 = new JLabel("MINIMUM WITHDRAWAL IS RS 1,000");
        heading1.setForeground(Color.BLACK);
        heading1.setFont(new Font("System", Font.BOLD, 14));
        
        heading2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        heading2.setForeground(Color.BLACK);
        heading2.setFont(new Font("System", Font.BOLD, 14));
        
        amountEnter = new JTextField();
        amountEnter.setFont(new Font("Raleway", Font.BOLD, 14));
        
        withdraw = new JButton("WITHDRAW");
        back = new JButton("BACK");
        
        setLayout(null);
        
        heading1.setBounds(190,60,300,20);
        l3.add(heading1);
        
        heading2.setBounds(200,95,300,20);
        l3.add(heading2);
        
        amountEnter.setBounds(190,130,270,25);
        l3.add(amountEnter);
        
        withdraw.setBounds(345,260,145,25);
        l3.add(withdraw);
        
        back.setBounds(345,290,145,25);
        l3.add(back);
        
        withdraw.addActionListener(this);
        back.addActionListener(this);
        
//        setSize(860,750);
//        setLocation(400,0);
        setExtendedState(JFrame.MAXIMIZED_BOTH);//full screen frame
        setUndecorated(true);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        try{        
            String amount = amountEnter.getText();
            Date date = new Date();
            if(ae.getSource()==withdraw){
                if(amountEnter.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount,you want to Withdraw");
                }
                else if(Integer.parseInt(amount) < 1000)
                    JOptionPane.showMessageDialog(null, "Please Enter amount more than Rs 1000");     
                else{
                    Conn c1 = new Conn();
                    
                    ResultSet rs = c1.s.executeQuery("select * from bank where pin = '"+pin+"'");
                    int balance = 0;
                    while(rs.next()){
                       if(rs.getString("type").equals("Deposit")){
                           balance += Integer.parseInt(rs.getString("amount"));
                       }else{
                           balance -= Integer.parseInt(rs.getString("amount"));
                       }
                    }
                    if(balance < Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null, "Insuffient Balance");
                        return;
                    }
                    
                    c1.s.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Withdrawl', '"+amount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
                    
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }
            }else if(ae.getSource()==back){
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
        }catch(Exception e){
                e.printStackTrace();
                System.out.println("error: "+e);
        }
            
    }

    
    
    public static void main(String[] args){
        new Withdrawl("").setVisible(true);
    }
}
