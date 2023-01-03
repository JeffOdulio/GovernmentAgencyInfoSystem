package javaapplication22;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GovAgencyInfoSystem extends JFrame{
    
    //for main window
    JFrame mainWindow = new JFrame("SSS Member Registration");
    JLabel rph = new JLabel("Republic of the Philippines");
    JLabel welcome = new JLabel("Social Security System");
    JButton register = new JButton("Register");
    JButton login = new JButton("Log in");
    JPanel mainPnl1 = new JPanel();
    
    //for registration window
    JFrame window = new JFrame("Sign up form");
    JTextField userTextField = new JTextField(20);
    JPasswordField passTextField = new JPasswordField(20);
    JLabel userLabel = new JLabel("Username");
    JLabel passLabel = new JLabel("Password");
    JButton signUp = new JButton("Sign up");
    JButton cancel = new JButton("Cancel");
    JLabel regWindow = new JLabel("Register");
    JLabel fNem = new JLabel("First Name");
    JLabel lNem = new JLabel("Last Name");
    JLabel mail = new JLabel("Email");
    JTextField nemF = new JTextField(20);
    JTextField nemL = new JTextField(20);
    JTextField Mail = new JTextField(20);    
    JTextField mailName = new JTextField(20);
    JTextArea at = new JTextArea("@");
    JTextArea com = new JTextArea(".com");
    
    
    //for logging in window
    JFrame ownAcc = new JFrame("Log in");
    JTextField logUserField = new JTextField(20);
    JPasswordField logPassField = new JPasswordField(20);
    JLabel lblUserField = new JLabel("Username");
    JLabel lblPassField = new JLabel("Password");
    JButton login2 = new JButton("Log in");
    JButton cancel2 = new JButton("Cancel");
    
    //for logged in window
    JFrame Accepted = new JFrame();
    JLabel welcoming = new JLabel("Welcome");
    JButton menuOne = new JButton("Logout");
    JButton menuTwo = new JButton("Delete account");
    JPanel addOn = new JPanel();
    
    JLabel totalLoan = new JLabel("Total loan");
    JTextArea tLoan = new JTextArea("0.00");
    JLabel howMuch = new JLabel("Insert loan");
    JTextField insertLoan = new JTextField(20);
    
    JFrame paymentConfirmation = new JFrame();
    JLabel uSure = new JLabel();
    JLabel spacer = new JLabel("                                 ");
    
    JButton addLoan = new JButton("Add loan");
    JButton payNow = new JButton("Pay loan");
    JButton payOkay = new JButton("Okay");
    JButton payCancel = new JButton("Cancel");
                
    double d = 0.05;            
    double d2;
    double d3;
    double d4;
    double d5;
    String s2;
    String s3;
    
    //for deleting account
    JFrame accDelete = new JFrame("Delete account");
    JLabel reInsert = new JLabel("Insert username and password to continue...");
    JLabel UserN = new JLabel("Username");
    JLabel PassW = new JLabel("Password");
    JTextField delName = new JTextField(20);
    JTextField delPass = new JTextField(20);
    JButton reCancel = new JButton("Cancel");
    JButton okay = new JButton("Okay");
    
    
    //delete confirmation
    JFrame delConfirm = new JFrame();
    JLabel kumpirmasyon = new JLabel("Are you sure you want to delete this account?");    
    JButton reNo = new JButton("No");
    JButton reYes = new JButton("Yes");
    
    //logos and whatnots
    JLabel lblLogo = new JLabel();
    JLabel lblMember = new JLabel("Member login");
    JLabel lblMyAccount = new JLabel();
    JLabel lblMainIcon = new JLabel();
    
    //fonts
    Font SSS = new Font("Times New Roman",Font.BOLD, 25);
    Font RPH = new Font("Times New Roman",Font.BOLD, 15);
    Font buttons = new Font("Courier New",Font.BOLD, 13);
    Font mimbir = new Font("Georgia",Font.BOLD, 25);
    Font fontUserInfo = new Font("Georgia",Font.BOLD,20);
    Font warningText = new Font("Verdana",Font.BOLD,14);
    
    //checkboxes
    JCheckBox checkBox1 = new JCheckBox("I'm not a robot");
    JCheckBox checkBox2 = new JCheckBox("I'm not a robot");
    
    //possible tab panes
    JPanel firstPanel = new JPanel();
    JPanel secondPanel = new JPanel();
    
    JLabel lblFirstPnl = new JLabel("Member's Information");
    JLabel lblSecondPnl = new JLabel("Available loans");
    
    JTabbedPane tabPane = new JTabbedPane();
    
    
    //filewriter
    JTextArea lOne = new JTextArea("Name: ");
    JTextArea lTwo = new JTextArea("Email: ");    
    
    FileWriter fileWriter;
    String line1;
    String line2;
    
    JLabel eto = new JLabel();
    JLabel etoRin = new JLabel();
    //main window
    GovAgencyInfoSystem(){
        
        mainWindow.setLayout(null);
        
        mainPnl1.setBounds(350, 0, 640, 800);
        mainPnl1.setBackground(Color.white);
        mainWindow.add(mainPnl1);
        
        lblMainIcon.setIcon(new ImageIcon("C:\\SSS Information System (mock)\\WelcomeSign1.png"));
        mainPnl1.add(lblMainIcon);
        
        register.addActionListener(new regis());
        login.addActionListener(new log());
        cancel.addActionListener(new cancelled());
        login2.addActionListener(new acceptIt());
        cancel2.addActionListener(new cancelledIt());
        checkBox1.addActionListener(new chkBx());
        checkBox2.addActionListener(new chkBx1() );
        menuOne.addActionListener(new logOut());
        menuTwo.addActionListener(new delAcc());
        reCancel.addActionListener(new reCancellation());
        okay.addActionListener(new ok());
        reYes.addActionListener(new yes());
        reNo.addActionListener(new no());
        payOkay.addActionListener(new PayOkay());
        payCancel.addActionListener(new PayCancel());
        payNow.addActionListener(new PayNow());
        addLoan.addActionListener(new AddLoan());
        
        lblLogo.setIcon(new ImageIcon("C:\\SSS Information System (mock)\\SSSLogo80.png"));
        
        register.setBounds(130, 400, 100, 50);
        login.setBounds(130, 500, 100, 50);
        welcome.setBounds(10, 125, 250, 25);
        rph.setBounds(10, 100, 250, 25);
        lblLogo.setBounds(10, 10, 100, 80);
        lblMember.setBounds(90, 300, 200, 50);
        checkBox1.setBounds(125, 600, 130, 50);
        
        rph.setFont(RPH);
        welcome.setFont(SSS);
        login.setFont(buttons);
        register.setFont(buttons);
        lblMember.setFont(mimbir);
        
        mainWindow.add(lblLogo);
        mainWindow.add(rph);
        mainWindow.add(welcome);
        mainWindow.add(lblMember);
        mainWindow.add(register);
        mainWindow.add(login);
        mainWindow.add(checkBox1);
        
        mainWindow.setBackground(Color.white);
        mainWindow.setSize(1000, 800);
        mainWindow.setLocation(300, 50);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setVisible(true);
        mainWindow.setResizable(false);
        
        register.setEnabled(false);
        login.setEnabled(false);
        
    }
    public static void main(String[] args){
        GovAgencyInfoSystem gov = new GovAgencyInfoSystem();
    }

    
    //sub windows
    class regis implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent a){
        userTextField.setText("");
        passTextField.setText("");
        window.setLayout(null);
        
        signUp.addActionListener(new okay());
        
        checkBox2.setBounds(50, 300, 150, 25);
        window.add(checkBox2);
        
        regWindow.setBounds(230, 10, 80, 25);  
        window.add(regWindow);
        
        userLabel.setBounds(10, 50, 80, 25);
        window.add(userLabel);
        
        userTextField.setBounds(100, 50, 165, 25);
        window.add(userTextField);
        
        passLabel.setBounds(10, 100, 80, 25);
        window.add(passLabel);
        
        passTextField.setBounds(100, 100, 165, 25);
        window.add(passTextField);
        
        signUp.setBounds(225, 400, 100, 25);
        window.add(signUp);
        
        fNem.setBounds(10, 150, 80, 25);
        window.add(fNem);
        
        nemF.setBounds(100, 150, 165, 25);
        window.add(nemF);
        
        lNem.setBounds(10, 200, 80, 25);
        window.add(lNem);
        
        nemL.setBounds(100, 200, 165, 25);
        window.add(nemL);
        
        mail.setBounds(10, 250, 80, 25);
        window.add(mail);
        
        Mail.setBounds(100, 250, 165, 25);
        window.add(Mail);
        
        at.setEditable(false);
        at.setBounds(265, 250, 20, 25);
        window.add(at);
        
        mailName.setBounds(285, 250, 100, 25);
        window.add(mailName);

        com.setEditable(false);
        com.setBounds(385, 250, 40, 25);
        window.add(com);
        
        cancel.setBounds(50, 400, 100, 25);
        window.add(cancel);

        window.setLocation(800, 200);
        window.setSize(500, 500);
        window.setVisible(true);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        mainWindow.setEnabled(false);
        register.setEnabled(false);
        login.setEnabled(false);
        signUp.setEnabled(false);

    }
    }
    
    class log implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent l){
        ownAcc.setLayout(null);
        
        lblUserField.setBounds(10, 50, 80, 25);
        ownAcc.add(lblUserField);
        
        logUserField.setBounds(100, 50, 165, 25);
        ownAcc.add(logUserField);
        
        lblPassField.setBounds(10, 100, 80, 25);
        ownAcc.add(lblPassField);
        
        logPassField.setBounds(100, 100, 165, 25);
        ownAcc.add(logPassField);
        
        login2.setBounds(225, 300, 100, 25);
        ownAcc.add(login2);
        
        cancel2.setBounds(50, 300, 100, 25);
        ownAcc.add(cancel2);
        
        ownAcc.setLocation(800, 200);
        ownAcc.setSize(400, 400);
        ownAcc.setVisible(true);
        ownAcc.setResizable(false);
        ownAcc.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); 
        
        register.setEnabled(false);
        login.setEnabled(false);

    }
    }
    
    class acceptIt implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent j){
        if(j.getActionCommand()==login2.getActionCommand()){

            File file = new File("C:\\SSS Information System (mock)\\"+logUserField.getText()+logPassField.getText()+".txt");
            if(file.exists() && !file.isDirectory()){
                
   
                try {
                    line1 = Files.readAllLines(Paths.get("C:\\SSS Information System (mock)\\"+logUserField.getText()+logPassField.getText()+".txt")).get(0);
                } catch (IOException ex) {
                    Logger.getLogger(GovAgencyInfoSystem.class.getName()).log(Level.SEVERE, (Supplier<String>) ex);
                }
                try {
                    line2 = Files.readAllLines(Paths.get("C:\\SSS Information System (mock)\\"+logUserField.getText()+logPassField.getText()+".txt")).get(1);
                } catch (IOException ex) {
                    Logger.getLogger(GovAgencyInfoSystem.class.getName()).log(Level.SEVERE, (Supplier<String>) ex);
                }
                
                Accepted.setLayout(null);
                 
                addOn.setVisible(true);
                addOn.setSize(400, 600);
                addOn.setLocation(540, 100);
                addOn.setBackground(Color.white);
                Accepted.add(addOn);
                
                lblMyAccount.setBounds(200, 600, 640, 800);
                lblMyAccount.setIcon(new ImageIcon("C:\\SSS Information System (mock)\\YourAccountSign1.png"));
                addOn.add(lblMyAccount);
                
                firstPanel.setBackground(Color.white);
                firstPanel.setLayout(new GridLayout(15,15));
                firstPanel.add(lblFirstPnl);
                
                lblFirstPnl.setForeground(Color.BLUE);
                lblFirstPnl.setFont(SSS);
                   
                secondPanel.setBackground(Color.WHITE);
                secondPanel.setLayout(new GridLayout(15,15));
                secondPanel.add(lblSecondPnl);
                
                lblSecondPnl.setForeground(Color.BLUE);
                lblSecondPnl.setFont(SSS);
                
                lOne.setForeground(Color.DARK_GRAY);
                lTwo.setForeground(Color.DARK_GRAY);
                lOne.setFont(fontUserInfo);
                lTwo.setFont(fontUserInfo);
                lOne.append(line1);
                lTwo.append(line2);
                lOne.setEditable(false);
                lTwo.setEditable(false);
                firstPanel.add(lOne);
                firstPanel.add(lTwo);
                
                totalLoan.setBounds(10, 30, 80, 25);
                tLoan.setBounds(100, 30, 80, 25);
                howMuch.setBounds(10, 70, 80, 25);
                insertLoan.setBounds(100, 70, 50, 25);
                
                totalLoan.setFont(fontUserInfo);
                tLoan.setFont(fontUserInfo);
                tLoan.setEditable(false);
                howMuch.setFont(fontUserInfo);
                insertLoan.setFont(fontUserInfo);
                
                secondPanel.add(totalLoan);
                secondPanel.add(tLoan);
                secondPanel.add(howMuch);
                secondPanel.add(insertLoan);
                secondPanel.add(spacer);
                secondPanel.add(addLoan);
                secondPanel.add(spacer);
                secondPanel.add(payNow);
                
                
                tabPane.add("Member info", firstPanel);
                tabPane.add("Loans", secondPanel);
                Accepted.add(tabPane);
                
                tabPane.setSize(1000, 400);
                tabPane.setVisible(true);
                tabPane.setBounds(0, 60, 500, 700);
                
                menuOne.setBounds(890, 5, 80, 25);
                menuTwo.setBounds(890, 40, 80, 25);
                welcoming.setBounds(10, 10, 80, 25);
                Accepted.add(welcoming);
                Accepted.add(menuOne);
                Accepted.add(menuTwo);
                
                Accepted.setLocation(300, 50);
                Accepted.setSize(1000, 800);
                Accepted.setVisible(true);
                Accepted.setResizable(false);
                Accepted.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                
                ownAcc.dispose();
                mainWindow.setEnabled(false);
                login.setEnabled(false);
                register.setEnabled(false);
                
            } 
            else
            {JOptionPane.showMessageDialog(null, "Account does not exist");}

        }
    }
    }
    
    class AddLoan implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent s){
        try{
            Integer.valueOf(insertLoan.getText());
                if (tLoan.toString().equals("0.00")){
                    try{
                        d2 = Double.parseDouble(insertLoan.getText());
                        d3 = d*d2+d2;
                        s2 = String.valueOf(d3);
                        tLoan.append(s2);
                        JOptionPane.showMessageDialog(null, "Successfully registered new loan");
                    }catch (NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Other symbols detected, insert numericals only");
                    }
                }
                else{
                    try{
                        d2 = Double.parseDouble(insertLoan.getText());
                        d3 = d*d2+d2;
                        s2 = String.valueOf(d3);
                        d4 = Double.parseDouble(tLoan.getText());
                        d5 = d3+d4;
                        s3 = String.valueOf(d5);
                        tLoan.setText(s3);
                        JOptionPane.showMessageDialog(null, "Successfully added loan");
                    }catch (NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Other symbols detected, insert numericals only");
                    }
                }    
        }catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Other symbols detected, insert numericals only");
        }
        insertLoan.setText("");
        }
        }
    class PayNow implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent s){
        if (!tLoan.getText().equals("0.00")){
            paymentConfirmation.setLayout(null);
            paymentConfirmation.setSize(300, 180);
            paymentConfirmation.setLocation(800, 200);
            
            uSure = new JLabel("Confirm payment for amount? "+tLoan.getText());
            uSure.setBounds(10, 10, 300, 25);
            paymentConfirmation.add(uSure);

            payCancel.setBounds(20, 100, 80, 25);
            paymentConfirmation.add(payCancel);
            payOkay.setBounds(180, 100, 80, 25);
            paymentConfirmation.add(payOkay);

            paymentConfirmation.setVisible(true);
            paymentConfirmation.setResizable(false);
            paymentConfirmation.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
        else{
            JOptionPane.showMessageDialog(null, "You have no current loan" );
        }
    }
    }
    class PayOkay implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent s){
        tLoan.setText("0.00");
        insertLoan.setText("");
        paymentConfirmation.dispose();
    }
    }
    class PayCancel implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent s){
        paymentConfirmation.dispose();
    }
    }
    
    
    
    //Account deletion
    class delAcc implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent y){
        accDelete.setLayout(null);
        accDelete.add(reInsert);
        
        UserN.setBounds(10, 50, 80, 25);
        accDelete.add(UserN);
        delName.setBounds(90, 50, 165, 25);
        accDelete.add(delName);
        
        PassW.setBounds(10, 100, 80, 25);
        accDelete.add(PassW);
        delPass.setBounds(90, 100, 165, 25);
        accDelete.add(delPass);
        
        reCancel.setBounds(70, 250, 80, 25);
        accDelete.add(reCancel);
        okay.setBounds(230, 250, 80, 25);
        accDelete.add(okay);  
        
        accDelete.setResizable(false);
        accDelete.setLocation(800, 200);
        accDelete.setSize(400, 350);
        accDelete.setVisible(true);
        accDelete.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    }
    
    class reCancellation implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent u){
        delName.setText("");
        delPass.setText("");
        accDelete.dispose();
    }
    }
    class ok implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent t){
        delConfirm.setLayout(null);
        
        kumpirmasyon.setFont(warningText);
        kumpirmasyon.setBounds(10, 10, 400, 25);
        delConfirm.add(kumpirmasyon);
        
        eto = new JLabel(line1);
        etoRin = new JLabel(line2);
        
        eto.setForeground(Color.red);
        eto.setFont(warningText);
        eto.setBounds(10, 35, 400, 25);
        delConfirm.add(eto);
        
        etoRin.setForeground(Color.red);
        etoRin.setFont(warningText);
        etoRin.setBounds(10, 60, 400, 25);
        delConfirm.add(etoRin);
        
        reYes.setBounds(230, 150, 80, 25);
        delConfirm.add(reYes);
        
        reNo.setBounds(70, 150, 80, 25);
        delConfirm.add(reNo);
        
        delConfirm.setLocation(800, 300);
        delConfirm.setSize(400, 250);
        delConfirm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        delConfirm.setVisible(true);
    }
    }
        class yes implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent q){
                File delThis = new File("C:\\SSS Information System (mock)\\"+delName.getText()+delPass.getText()+".txt");
                if(delThis.exists()){
                    if (delThis.delete()){
                        delName.setText("");
                        delPass.setText("");
                        logUserField.setText("");
                        logPassField.setText("");
                        lOne.setText("");
                        lTwo.setText("");
                        eto.setText("");
                        etoRin.setText("");
                        mailName.setText("");
                        lOne.setText("Name: ");
                        lTwo.setText("Email: ");
                        insertLoan.setText("");
                        tLoan.setText("0.00");
                        spacer.setText("");
                        addOn.add(lblMyAccount);
                        firstPanel.repaint();
                        firstPanel.revalidate();
                        Accepted.dispose();
                        mainWindow.setEnabled(true);
                        checkBox1.setSelected(false);
                        accDelete.dispose();
                        delConfirm.dispose();
                        JOptionPane.showMessageDialog(null, "Account deleted");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Failed to delete account");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Account does not exist");
                }
            }
        }
        class no implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent w){
                delConfirm.dispose();
            }
        }
    //Check boxes
    class chkBx implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent v){
        if(checkBox1.isSelected()){
            register.setEnabled(true);
            login.setEnabled(true);
        }
        else{
            register.setEnabled(false);
            login.setEnabled(false);
        }
    }
    }

    class chkBx1 implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent x){
        if(checkBox2.isSelected()){
            signUp.setEnabled(true);
        }
        else{
            signUp.setEnabled(false);
        }
    }
    }

    
    //logout and cancellations
    class logOut implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent p){
        lOne.setText("Name: ");
        lTwo.setText("Email: ");
        logUserField.setText("");
        logPassField.setText("");
        insertLoan.setText("");
        mailName.setText("");
        tLoan.setText("0.00");
        firstPanel.repaint();
        firstPanel.revalidate();
        Accepted.dispose();
        addOn.add(lblMyAccount);
        mainWindow.setEnabled(true);
        checkBox1.setSelected(false);
        
    }
    }
      
    class cancelledIt implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent k){
        logUserField.setText("");
        logPassField.setText("");
        ownAcc.dispose();
        checkBox1.setSelected(false);
        login.setEnabled(false);
        register.setEnabled(false);
    }
    }
    
    class cancelled implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent b){
        userTextField.setText("");
        passTextField.setText("");
        nemF.setText("");
        nemL.setText("");
        Mail.setText("");
        
        window.dispose();
        checkBox1.setSelected(false);
        mainWindow.setEnabled(true);
        
    }
    }
    
    
    //main file writer
    class okay implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand()==signUp.getActionCommand()){
            String uT = userTextField.getText();
            String pT = passTextField.getText();
            String nF = nemF.getText();
            String nL = nemL.getText();
            String emel = Mail.getText();
            String emelN = mailName.getText();
            
            
            if(uT.isBlank() || pT.isBlank() || nF.isBlank() || nL.isBlank() || emel.isBlank() || emelN.isBlank()){
                JOptionPane.showMessageDialog(null, "Please fill in all the blanks");
            }
            else{
                try{
                    File myFile = new File(userTextField.getText()+passTextField.getText()+".txt");
                    if(myFile.createNewFile()){
                        try{ 
                            fileWriter = new FileWriter("C:\\SSS Information System (mock)\\"+myFile, true);
                            fileWriter.append(nemF.getText()+" "+nemL.getText()+"\n");
                            fileWriter.append(Mail.getText()+"@"+mailName.getText()+".com");
                            fileWriter.close();
                            JOptionPane.showMessageDialog(null, "File Written Successfully");
                            window.dispose();
                            mainWindow.setEnabled(true);
                            checkBox1.setSelected(false);
                            userTextField.setText("");
                            passTextField.setText("");
                            nemF.setText("");
                            nemL.setText("");
                            Mail.setText("");
                        }catch(Exception b){JOptionPane.showMessageDialog(null, b+"");}
                    } else{JOptionPane.showMessageDialog(null, "Account already exists");}
                }catch (IOException i){
          
                } 
            }

        }
    } 
    }
}
