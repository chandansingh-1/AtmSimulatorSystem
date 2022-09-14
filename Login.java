package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JLabel heading,cardNo,pin;
    JTextField cardNumber;
    JPasswordField pinPassword;
    JButton signIn,clear,signUp;
  
    Login(){
        setTitle("AUTOMATED TELLER MACHINE");
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("AtmSimulatorSystem/icons/Bank.jpg"));
        Image imageBack = img.getImage().getScaledInstance(1380, 700, Image.SCALE_DEFAULT);
        ImageIcon iIcon = new ImageIcon(imageBack);
        JLabel background = new JLabel(iIcon);
        background.setBounds(0,0,1380,700);
        add(background);
        
        JPanel panel = new JPanel();
        panel.setBounds(450, 100, 450,500);
        panel.setBackground(Color.WHITE);
        background.add(panel);
        panel.setLayout(null);
        
        //taking image as icon
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("AtmSimulatorSystem/icons/bankLogo.png"));
        //setting the size of icon(converting imageIcon into image)
        Image image = imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(image);//converting image into imageIcon
        JLabel l11 = new JLabel(i3);//JLabel takes imageIcon object as parameter
        
        panel.add(l11);
        l11.setBounds(175, 10, 100, 100);
        
        heading = new JLabel("WELCOME TO ATM");
        heading.setFont(new Font("Osward", Font.BOLD, 30));
        heading.setBounds(100,110,300,40);
        panel.add(heading);
        
        cardNo = new JLabel("Card No:");
        cardNo.setFont(new Font("Raleway", Font.BOLD, 25));
        cardNo.setBounds(50,200,150,30);
        panel.add(cardNo);
        
        cardNumber = new JTextField(15);
        cardNumber.setBounds(170,200,230,30);
        cardNumber.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(cardNumber);
        
        pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        pin.setBounds(50,240,150,30);
        panel.add(pin);
        
        pinPassword = new JPasswordField(15);
        pinPassword.setFont(new Font("Arial", Font.BOLD, 14));
        pinPassword.setBounds(170,240,230,30);
        panel.add(pinPassword);
                
        signIn = new JButton("SIGN IN");
        signIn.setBackground(Color.BLACK);
        signIn.setForeground(Color.WHITE);
        
        clear = new JButton("CLEAR");
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        
        signUp = new JButton("SIGN UP");
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.WHITE);
        
        setLayout(null);
        
        signIn.setFont(new Font("Arial", Font.BOLD, 14));
        signIn.setBounds(110,330,100,30);
        panel.add(signIn);
        
        clear.setFont(new Font("Arial", Font.BOLD, 14));
        clear.setBounds(240,330,100,30);
        panel.add(clear);
        
        signUp.setFont(new Font("Arial", Font.BOLD, 14));
        signUp.setBounds(110,370,230,30);
        panel.add(signUp);
        
        signIn.addActionListener(this);
        clear.addActionListener(this);
        signUp.addActionListener(this);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);//full screen frame
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        try{        
            if(ae.getSource()==signIn){
                Conn c1 = new Conn();
                String cardno  = cardNumber.getText();
                String pin  = pinPassword.getText();// pin is a passowd type
                String q  = "select * from login where cardno = '"+cardno+"' and pin = '"+pin+"'";

                ResultSet rs = c1.s.executeQuery(q);//return a result
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            }else if(ae.getSource()==clear){
                cardNumber.setText("");
                pinPassword.setText("");
            }else if(ae.getSource()==signUp){
                setVisible(false);
                new Signup().setVisible(true);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Login().setVisible(true);
    }

    
}



