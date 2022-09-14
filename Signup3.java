
package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class Signup3 extends JFrame implements ActionListener{
    
    JLabel heading,accountL,cardL,cardNumL,cardTextL,textL,pinL,xxxxL,atmL,serviceL,formL,formNumberL;
    JRadioButton savingAccount,fd,currAccount,rdAccount;
    JButton submit,cancel;
    JCheckBox atmCard,internet,mobile,email,cheque,statement,declaration;
    String formno;
    Signup3(String formno){
        this.formno = formno;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("AtmSimulatorSystem/icons/Bank.jpg"));
        Image imageBack = img.getImage().getScaledInstance(1380, 700, Image.SCALE_DEFAULT);
        ImageIcon iIcon = new ImageIcon(imageBack);
        JLabel background = new JLabel(iIcon);
        background.setBounds(0,0,1380,700);
        add(background);
        
        JPanel panel = new JPanel();
        panel.setBounds(400, 10, 850, 740);
        panel.setBackground(Color.WHITE);
        background.add(panel);
        panel.setLayout(null);
    
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("AtmSimulatorSystem/icons/bankLogo.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l14 = new JLabel(i3);
        l14.setBounds(150, 0, 100, 100);
        panel.add(l14);
        
        heading = new JLabel("Page 3: Account Details");
        heading.setFont(new Font("Raleway", Font.BOLD, 22));
        
        accountL = new JLabel("Account Type:");
        accountL.setFont(new Font("Raleway", Font.BOLD, 18));
        
        cardL = new JLabel("Card Number:");
        cardL.setFont(new Font("Raleway", Font.BOLD, 18));
        
        cardNumL = new JLabel("XXXX-XXXX-XXXX-4184");
        cardNumL.setFont(new Font("Raleway", Font.BOLD, 18));
        
        cardTextL = new JLabel("(Your 16-digit Card number)");
        cardTextL.setFont(new Font("Raleway", Font.BOLD, 12));
        
        textL = new JLabel("It would appear on ATM Card/Cheque Book and Statements");
        textL.setFont(new Font("Raleway", Font.BOLD, 12));
        
        pinL = new JLabel("PIN:");
        pinL.setFont(new Font("Raleway", Font.BOLD, 18));
        
        xxxxL = new JLabel("XXXX");
        xxxxL.setFont(new Font("Raleway", Font.BOLD, 18));
    
        atmL = new JLabel("(4-digit password)");
        atmL.setFont(new Font("Raleway", Font.BOLD, 12));
    
        serviceL = new JLabel("Services Required:");
        serviceL.setFont(new Font("Raleway", Font.BOLD, 18));
        
        formL = new JLabel("Form No:");
        formL.setFont(new Font("Raleway", Font.BOLD, 14));
        
        formNumberL = new JLabel(formno);
        formNumberL.setFont(new Font("Raleway", Font.BOLD, 14));
        
        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        
        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        
        
        atmCard = new JCheckBox("ATM CARD");
        atmCard.setBackground(Color.WHITE);
        atmCard.setFont(new Font("Raleway", Font.BOLD, 16));
        
        internet = new JCheckBox("Internet Banking");
        internet.setBackground(Color.WHITE);
        internet.setFont(new Font("Raleway", Font.BOLD, 16));
        
        mobile = new JCheckBox("Mobile Banking");
        mobile.setBackground(Color.WHITE);
        mobile.setFont(new Font("Raleway", Font.BOLD, 16));
        
        email = new JCheckBox("EMAIL Alerts");
        email.setBackground(Color.WHITE);
        email.setFont(new Font("Raleway", Font.BOLD, 16));
        
        cheque = new JCheckBox("Cheque Book");
        cheque.setBackground(Color.WHITE);
        cheque.setFont(new Font("Raleway", Font.BOLD, 16));
        
        statement = new JCheckBox("E-Statement");
        statement.setBackground(Color.WHITE);
        statement.setFont(new Font("Raleway", Font.BOLD, 16));
        
        declaration = new JCheckBox("I hereby declares that the above entered details correct to th best of my knowledge.",true);
        declaration.setBackground(Color.WHITE);
        declaration.setFont(new Font("Raleway", Font.BOLD, 12));
         
        
        savingAccount = new JRadioButton("Saving Account");
        savingAccount.setFont(new Font("Raleway", Font.BOLD, 16));
        savingAccount.setBackground(Color.WHITE);
        
        fd = new JRadioButton("Fixed Deposit Account");
        fd.setFont(new Font("Raleway", Font.BOLD, 16));
        fd.setBackground(Color.WHITE);
        
        currAccount = new JRadioButton("Current Account");
        currAccount.setFont(new Font("Raleway", Font.BOLD, 16));
        currAccount.setBackground(Color.WHITE);
        
        rdAccount = new JRadioButton("Recurring Deposit Account");
        rdAccount.setFont(new Font("Raleway", Font.BOLD, 16));
        rdAccount.setBackground(Color.WHITE);
        
        ButtonGroup groupgender = new ButtonGroup();
        groupgender.add(savingAccount);
        groupgender.add(fd);
        groupgender.add(currAccount);
        groupgender.add(rdAccount);
        
        setLayout(null);
        
        formL.setBounds(700,10,70,30);
        panel.add(formL);
        
        formNumberL.setBounds(770,10,40,30);
        panel.add(formNumberL);
        
        heading.setBounds(280,40,400,40);
        panel.add(heading); 
        
        accountL.setBounds(100,100,200,30);
        panel.add(accountL);
        
        savingAccount.setBounds(100,140,150,30);
        panel.add(savingAccount);
        
        fd.setBounds(350,140,300,30);
        panel.add(fd);
        
        currAccount.setBounds(100,180,250,30);
        panel.add(currAccount);
        
        rdAccount.setBounds(350,180,250,30);
        panel.add(rdAccount);
        
        cardL.setBounds(100,260,200,30);
        panel.add(cardL);
        
        cardNumL.setBounds(330,260,250,30);
        panel.add(cardNumL);
        
        cardTextL.setBounds(100,290,200,20);
        panel.add(cardTextL);
        
        textL.setBounds(330,290,500,20);
        panel.add(textL);
        
        pinL.setBounds(100,330,200,30);
        panel.add(pinL);
        
        xxxxL.setBounds(330,330,200,30);
        panel.add(xxxxL);
        
        atmL.setBounds(100,360,200,20);
        panel.add(atmL);
        
        serviceL.setBounds(100,410,200,30);
        panel.add(serviceL);
        
        atmCard.setBounds(100,460,200,30);
        panel.add(atmCard);
        
        internet.setBounds(350,460,200,30);
        panel.add(internet);
        
        mobile.setBounds(100,510,200,30);
        panel.add(mobile);
        
        email.setBounds(350,510,200,30);
        panel.add(email);
        
        cheque.setBounds(100,560,200,30);
        panel.add(cheque);
        
        statement.setBounds(350,560,200,30);
        panel.add(statement);
        
        declaration.setBounds(100,600,600,20);
        panel.add(declaration);
        
        submit.setBounds(250,630,100,30);
        panel.add(submit);
        
        cancel.setBounds(420,630,100,30);
        panel.add(cancel);
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);//full screen frame
        setVisible(true);
        
        submit.addActionListener(this);
        cancel.addActionListener(this);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        String atype = null;
        if(savingAccount.isSelected()){ 
            atype = "Saving Account";
        }
        else if(fd.isSelected()){ 
            atype = "Fixed Deposit Account";
        }
        else if(currAccount.isSelected()){ 
            atype = "Current Account";
        }else if(rdAccount.isSelected()){ 
            atype = "Recurring Deposit Account";
        }
        
        Random ran = new Random();
        long first7 = (ran.nextLong() % 90000000L) + 5040936000000000L;
        String cardno = "" + Math.abs(first7);
        
        long first3 = (ran.nextLong() % 9000L) + 1000L;
        String pin = "" + Math.abs(first3);
        
        String facility = "";
        if(atmCard.isSelected()){ 
            facility = facility + " ATM Card";
        }
        if(internet.isSelected()){ 
            facility = facility + " Internet Banking";
        }
        if(mobile.isSelected()){ 
            facility = facility + " Mobile Banking";
        }
        if(email.isSelected()){ 
            facility = facility + " EMAIL Alerts";
        }
        if(cheque.isSelected()){ 
            facility = facility + " Cheque Book";
        }
        if(statement.isSelected()){ 
            facility = facility + " E-Statement";
        }
        
        try{
            if(ae.getSource()==submit){
                
                if(atype.equals("")){
                    JOptionPane.showMessageDialog(null, "Fill all the required fields");
                }else{
                    Conn c1 = new Conn();
                    String q1 = "insert into signup3 values('"+formno+"','"+atype+"','"+cardno+"','"+pin+"','"+facility+"')";  
                    String q2 = "insert into login values('"+formno+"','"+cardno+"','"+pin+"')";
                    c1.s.executeUpdate(q1);
                    c1.s.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardno + "\n Pin:"+ pin);
                    
                    new Deposit(pin).setVisible(true);
                    setVisible(false);
                }
            
            }else if(ae.getSource()==cancel){
                System.exit(0);
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }
    
    public static void main(String[] args){
        new Signup3("").setVisible(true);
    }
    
}



