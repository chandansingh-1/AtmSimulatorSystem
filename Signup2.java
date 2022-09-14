
package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Signup2 extends JFrame implements ActionListener{
    
    JLabel heading,religionLabel,categoryLabel,incomeLabel,educateLabel,occupationLabel,panLabel,adharLabel,citizenLabel,existAccountL,l11,form,formVal;
    JButton next;
    JRadioButton yesRB,noRB,alreadyYesRB,alreadyNoRB;
    JTextField panText,aadharText;
    JComboBox religionCB,categoryCB,incomeCB,educateCB,occupationCB;
    String formno;
    Signup2(String formno){
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("AtmSimulatorSystem/icons/Bank.jpg"));
        Image imageBack = img.getImage().getScaledInstance(1380, 700, Image.SCALE_DEFAULT);
        ImageIcon iIcon = new ImageIcon(imageBack);
        JLabel background = new JLabel(iIcon);
        background.setBounds(0,0,1380,700);
        add(background);
        
        JPanel panel = new JPanel();
        panel.setBounds(400, 20, 800,700);
        panel.setBackground(Color.WHITE);
        background.add(panel);
        panel.setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("AtmSimulatorSystem/icons/bankLogo.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l14 = new JLabel(i3);
        l14.setBounds(150, 0, 100, 100);
        panel.add(l14);
        
        
        this.formno = formno;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        heading = new JLabel("Page 2: Additonal Details");
        heading.setFont(new Font("Raleway", Font.BOLD, 22));
        
        religionLabel = new JLabel("Religion:");
        religionLabel.setFont(new Font("Raleway", Font.BOLD, 18));
        
        categoryLabel = new JLabel("Category:");
        categoryLabel.setFont(new Font("Raleway", Font.BOLD, 18));
        
        incomeLabel = new JLabel("Income:");
        incomeLabel.setFont(new Font("Raleway", Font.BOLD, 18));
        
        educateLabel = new JLabel("Educational");
        educateLabel.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l11 = new JLabel("Qualification:");
        l11.setFont(new Font("Raleway", Font.BOLD, 18));
        
        occupationLabel = new JLabel("Occupation:");
        occupationLabel.setFont(new Font("Raleway", Font.BOLD, 18));
        
        panLabel = new JLabel("PAN Number:");
        panLabel.setFont(new Font("Raleway", Font.BOLD, 18));
        
        adharLabel = new JLabel("Aadhar Number:");
        adharLabel.setFont(new Font("Raleway", Font.BOLD, 18));
        
        citizenLabel = new JLabel("Senior Citizen:");
        citizenLabel.setFont(new Font("Raleway", Font.BOLD, 18));
        
        existAccountL = new JLabel("Existing Account:");
        existAccountL.setFont(new Font("Raleway", Font.BOLD, 18));
        
        form = new JLabel("Form No:");
        form.setFont(new Font("Raleway", Font.BOLD, 13));
        
        formVal = new JLabel(formno);
        formVal.setFont(new Font("Raleway", Font.BOLD, 13));
        
        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        
        panText = new JTextField();
        panText.setFont(new Font("Raleway", Font.BOLD, 14));
        
        aadharText = new JTextField();
        aadharText.setFont(new Font("Raleway", Font.BOLD, 14));
        
        yesRB = new JRadioButton("Yes");
        yesRB.setFont(new Font("Raleway", Font.BOLD, 14));
        yesRB.setBackground(Color.WHITE);
        
        noRB = new JRadioButton("No");
        noRB.setFont(new Font("Raleway", Font.BOLD, 14));
        noRB.setBackground(Color.WHITE);
        
        ButtonGroup groupcitizen = new ButtonGroup();
        groupcitizen.add(yesRB);
        groupcitizen.add(noRB);
        
        alreadyYesRB = new JRadioButton("Yes");
        alreadyYesRB.setFont(new Font("Raleway", Font.BOLD, 14));
        alreadyYesRB.setBackground(Color.WHITE);
        
        alreadyNoRB = new JRadioButton("No");
        alreadyNoRB.setFont(new Font("Raleway", Font.BOLD, 14));
        alreadyNoRB.setBackground(Color.WHITE);
        
        ButtonGroup groupAcc = new ButtonGroup();
        groupAcc.add(alreadyYesRB);
        groupAcc.add(alreadyNoRB);
        
        
        String religion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        religionCB = new JComboBox(religion);
        religionCB.setBackground(Color.WHITE);
        religionCB.setFont(new Font("Raleway", Font.BOLD, 14));
        
        String category[] = {"General","OBC","SC","ST","Other"};
        categoryCB = new JComboBox(category);
        categoryCB.setBackground(Color.WHITE);
        categoryCB.setFont(new Font("Raleway", Font.BOLD, 14));
        
        String income[] = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000","Above 10,00,000"};
        incomeCB = new JComboBox(income);
        incomeCB.setBackground(Color.WHITE);
        incomeCB.setFont(new Font("Raleway", Font.BOLD, 14));
        
        String education[] = {"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
        educateCB = new JComboBox(education);
        educateCB.setBackground(Color.WHITE);
        educateCB.setFont(new Font("Raleway", Font.BOLD, 14));
        
        String occupation[] = {"Salaried","Self-Employmed","Business","Student","Retired","Others"};
        occupationCB = new JComboBox(occupation);
        occupationCB.setBackground(Color.WHITE);
        occupationCB.setFont(new Font("Raleway", Font.BOLD, 14));
       
        
        setLayout(null);
        
        
        form.setBounds(600,10,60,30);
        panel.add(form);
        
        formVal.setBounds(660,10,60,30);
        panel.add(formVal);
        
        heading.setBounds(280,30,600,40);
        panel.add(heading);
        
        religionLabel.setBounds(100,120,100,30);
        panel.add(religionLabel);
        
        religionCB.setBounds(350,120,320,30);
        panel.add(religionCB);
        
        categoryLabel.setBounds(100,170,100,30);
        panel.add(categoryLabel);
        
        categoryCB.setBounds(350,170,320,30);
        panel.add(categoryCB);
        
        incomeLabel.setBounds(100,220,100,30);
        panel.add(incomeLabel);
        
        incomeCB.setBounds(350,220,320,30);
        panel.add(incomeCB);
        
        educateLabel.setBounds(100,270,150,30);
        panel.add(educateLabel);
        
        educateCB.setBounds(350,270,320,30);
        panel.add(educateCB);
        
        l11.setBounds(100,290,150,30);
        panel.add(l11);
        
        occupationLabel.setBounds(100,340,150,30);
        panel.add(occupationLabel);
        
        occupationCB.setBounds(350,340,320,30);
        panel.add(occupationCB);
        
        panLabel.setBounds(100,390,150,30);
        panel.add(panLabel);
        
        panText.setBounds(350,390,320,30);
        panel.add(panText);
        
        adharLabel.setBounds(100,440,180,30);
        panel.add(adharLabel);
        
        aadharText.setBounds(350,440,320,30);
        panel.add(aadharText);
        
        citizenLabel.setBounds(100,490,150,30);
        panel.add(citizenLabel);
        
        yesRB.setBounds(350,490,100,30);
        panel.add(yesRB);
        
        noRB.setBounds(460,490,100,30);
        panel.add(noRB);
        
        existAccountL.setBounds(100,540,180,30);
        panel.add(existAccountL);
        
        alreadyYesRB.setBounds(350,540,100,30);
        panel.add(alreadyYesRB);
        
        alreadyNoRB.setBounds(460,540,100,30);
        panel.add(alreadyNoRB);
        
        next.setBounds(570,600,100,30);
        panel.add(next);
        
        next.addActionListener(this);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);//full screen frame
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String religion = (String)religionCB.getSelectedItem(); 
        String category = (String)categoryCB.getSelectedItem();
        String income = (String)incomeCB.getSelectedItem();
        String education = (String)educateCB.getSelectedItem();
        String occupation = (String)occupationCB.getSelectedItem();
        
        String pan = panText.getText();
        String aadhar = aadharText.getText();
        
        String scitizen = "";
        if(yesRB.isSelected()){ 
            scitizen = "Yes";
        }
        else if(noRB.isSelected()){ 
            scitizen = "No";
        }
           
        String eaccount = "";
        if(alreadyYesRB.isSelected()){ 
            eaccount = "Yes";
        }else if(alreadyNoRB.isSelected()){ 
            eaccount = "No";
        }
        
        try{
            if(aadharText.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            }else{
                Conn c1 = new Conn();
                String q1 = "insert into signup2 values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+pan+"','"+aadhar+"','"+scitizen+"','"+eaccount+"')";
                c1.s.executeUpdate(q1);
                
                new Signup3(formno).setVisible(true);
                setVisible(false);
            }
                
      
            
        }catch(Exception ex){
             ex.printStackTrace();
        }
    
               
    }
    
    
    public static void main(String[] args){
        new Signup2("").setVisible(true);
    }
}

