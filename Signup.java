package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class Signup extends JFrame implements ActionListener{
    
    JLabel formNo,personalDetail,name,fName,dob,gender,email,marital,address,city,pinCode,state;
    JTextField nameText,fatherText,emailText,addressText,cityText,pinText,stateText;
    JRadioButton male,female,married,unmarried,other;
    JButton next;
    JDateChooser dateChooser;
    
    
    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000L;
    String first = "" + Math.abs(first4);
    
    Signup(){
        
        setTitle("NEW ACCOUNT APPLICATION FORM");
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("AtmSimulatorSystem/icons/Bank.jpg"));
        Image imageBack = img.getImage().getScaledInstance(1380, 700, Image.SCALE_DEFAULT);
        ImageIcon iIcon = new ImageIcon(imageBack);
        JLabel background = new JLabel(iIcon);
        background.setBounds(0,0,1380,700);
        add(background);
        
        JPanel panel = new JPanel();
        panel.setBounds(450, 10, 750,730);
        panel.setBackground(Color.WHITE);
        background.add(panel);
        panel.setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("AtmSimulatorSystem/icons/bankLogo.png"));
        Image i2 = i1.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l11 = new JLabel(i3);
        l11.setBounds(20, 0, 80, 80);
        panel.add(l11);
        
        formNo = new JLabel("APPLICATION FORM NO. "+first);
        formNo.setFont(new Font("Raleway", Font.BOLD, 30));
        
        personalDetail = new JLabel("Page 1: Personal Details");
        personalDetail.setFont(new Font("Raleway", Font.BOLD, 22));
        
        name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 18));
        
        fName = new JLabel("Father's Name:");
        fName.setFont(new Font("Raleway", Font.BOLD, 18));
        
        dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 18));
        
        gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 18));
        
        email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway", Font.BOLD, 18));
        
        marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway", Font.BOLD, 18));
        
        address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 18));
        
        city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 18));
        
        pinCode = new JLabel("Pin Code:");
        pinCode.setFont(new Font("Raleway", Font.BOLD, 18));
        
        state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 18));
        
        
        nameText = new JTextField();
        nameText.setFont(new Font("Raleway", Font.BOLD, 14));
        
        fatherText = new JTextField();
        fatherText.setFont(new Font("Raleway", Font.BOLD, 14));
        
        emailText = new JTextField();
        emailText.setFont(new Font("Raleway", Font.BOLD, 14));
        
        addressText = new JTextField();
        addressText.setFont(new Font("Raleway", Font.BOLD, 14));
        
        cityText = new JTextField();
        cityText.setFont(new Font("Raleway", Font.BOLD, 14));
        
        pinText = new JTextField();
        pinText.setFont(new Font("Raleway", Font.BOLD, 14));
        
        stateText = new JTextField();
        stateText.setFont(new Font("Raleway", Font.BOLD, 14));
        
       
        
        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        
        male = new JRadioButton("Male");
        male.setFont(new Font("Raleway", Font.BOLD, 14));
        male.setBackground(Color.WHITE);
        
        female = new JRadioButton("Female");
        female.setFont(new Font("Raleway", Font.BOLD, 14));
        female.setBackground(Color.WHITE);
        
        ButtonGroup groupgender = new ButtonGroup();
        groupgender.add(male);
        groupgender.add(female);
        
        married = new JRadioButton("Married");
        married.setFont(new Font("Raleway", Font.BOLD, 14));
        married.setBackground(Color.WHITE);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setFont(new Font("Raleway", Font.BOLD, 14));
        unmarried.setBackground(Color.WHITE);
        
        other = new JRadioButton("Other");
        other.setFont(new Font("Raleway", Font.BOLD, 14));
        other.setBackground(Color.WHITE);
        
        ButtonGroup groupstatus = new ButtonGroup();
        groupstatus.add(married);
        groupstatus.add(unmarried);
        groupstatus.add(other);
        
        dateChooser = new JDateChooser();
	//dateChooser.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
	dateChooser.setForeground(new Color(105, 105, 105));
	dateChooser.setBounds(137, 337, 200, 40);
	panel.add(dateChooser);
        
        setLayout(null);
        formNo.setBounds(140,15,600,40);
        panel.add(formNo);
        
        personalDetail.setBounds(260,70,600,30);
        panel.add(personalDetail);
        
        name.setBounds(100,130,100,30);
        panel.add(name);
        
        nameText.setBounds(300,130,400,30);
        panel.add(nameText);
        
        fName.setBounds(100,180,200,30);
        panel.add(fName);
        
        fatherText.setBounds(300,180,400,30);
        panel.add(fatherText);
        
        dob.setBounds(100,230,200,30);
        panel.add(dob);
        
        dateChooser.setBounds(300, 230, 400, 30);
        
        gender.setBounds(100,280,200,30);
        panel.add(gender);
        
        male.setBounds(300,280,60,30);
        panel.add(male);
        
        female.setBounds(450,280,90,30);
        panel.add(female);
        
        email.setBounds(100,330,200,30);
        panel.add(email);
        
        emailText.setBounds(300,330,400,30);
        panel.add(emailText);
        
        marital.setBounds(100,380,200,30);
        panel.add(marital);
        
        married.setBounds(300,380,100,30);
        panel.add(married);
        
        unmarried.setBounds(450,380,100,30);
        panel.add(unmarried);
        
        other.setBounds(635,380,100,30);
        panel.add(other);
        
        
        
        address.setBounds(100,430,200,30);
        panel.add(address);
        
        addressText.setBounds(300,430,400,30);
        panel.add(addressText);
        
        city.setBounds(100,480,200,30);
        panel.add(city);
        
        cityText.setBounds(300,480,400,30);
        panel.add(cityText);
        
        pinCode.setBounds(100,530,200,30);
        panel.add(pinCode);
        
        pinText.setBounds(300,530,400,30);
        panel.add(pinText);
        
        state.setBounds(100,580,200,30);
        panel.add(state);
        
        stateText.setBounds(300,580,400,30);
        panel.add(stateText);
        
        next.setBounds(620,640,80,30);
        panel.add(next);
        
        next.addActionListener(this);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);//full screen frame
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String formno = first;
        String name = nameText.getText();
        String fname = fatherText.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){ 
            gender = "Male";
        }else if(female.isSelected()){ 
            gender = "Female";
        }
            
        String email = emailText.getText();
        String marital = null;
        if(married.isSelected()){ 
            marital = "Married";
        }else if(unmarried.isSelected()){ 
            marital = "Unmarried";
        }else if(other.isSelected()){ 
            marital = "Other";
        }
           
        String address = addressText.getText();
        String city = cityText.getText();
        String pincode = pinText.getText();
        String state = stateText.getText();
        

        try{
           
            if(pinText.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            }else{
                Conn c1 = new Conn();
                String q1 = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pincode+"','"+state+"')";
                c1.s.executeUpdate(q1);
                
                new Signup2(first).setVisible(true);
                setVisible(false);
            }
            
        }catch(Exception e){
             e.printStackTrace();
        }
        
    }
    
    
    public static void main(String[] args){
        new Signup().setVisible(true);
    }
}

