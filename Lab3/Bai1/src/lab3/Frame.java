/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author NguyenVanDuong.15520154
 */
public class Frame extends JFrame{

    JFrame f;
    public Frame() {
//        this.setSize(350,250);
//        this.setTitle("Hello Java GUI");
    }
    
    public void LoginForm() {
        f = new JFrame("Login"); 	
        f.setSize(350,150);
        
	JPanel panel = new JPanel(); 
        panel.setBackground(Color.white);
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(3,3,3,3);
        
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        JLabel lblTitle = new JLabel("Login Form");
        lblTitle.setHorizontalAlignment(JLabel.CENTER);
        panel.add(lblTitle, gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        JLabel lblUser = new JLabel("Username: ");
        panel.add(lblUser, gbc);
        
        gbc.gridx = 1;
        JTextField txtUser = new JTextField("", 15);
        panel.add(txtUser, gbc);
        
        gbc.gridy = 2;
        gbc.gridx = 0;
        JLabel lblPass = new JLabel("Password: ");
        panel.add(lblPass, gbc);
        
        gbc.gridx = 1;
        JPasswordField txtPass = new JPasswordField();
        panel.add(txtPass, gbc);
        
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        JButton btnOk = new JButton("OK");
        btnOk.setHorizontalAlignment(JButton.CENTER);
        btnOk.setPreferredSize(new Dimension(60, 25));
        panel.add(btnOk, gbc);
        btnOk.addActionListener(new ActionListener() {
            private int clicked = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputUsername = txtUser.getText();
                String inputPassword = new String(txtPass.getPassword());
                String username = "Adminuser";
                String password = "admin";
                if( !(username.equals(inputUsername) && password.equals(inputPassword)) ){
                    JOptionPane.showMessageDialog(null, "Thông tin đăng nhập sai!", "Thông báo", 1);
                    if(++this.clicked == 3){
                        f.setVisible(false);
                    }
                } else {
                    f.setVisible(false);
                    Frame fr = new Frame();
                    fr.StudenInfoForm();
                }
            }
        });

        f.add(panel);
        f.setVisible(true);
    }
    
    public void StudenInfoForm() {
        f = new JFrame("Đăng ký"); 	
        f.setSize(450,450);
        
	JPanel panel = new JPanel(); 
        panel.setBackground(Color.decode("#b5ccf7"));
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        
        // Row 0
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        JLabel lblTitle = new JLabel("Accept Student Data");
        lblTitle.setHorizontalAlignment(JLabel.CENTER);
        panel.add(lblTitle, gbc);
        
        // Row 1
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        JLabel lblUser = new JLabel("Name: ");
        panel.add(lblUser, gbc);
        
        gbc.gridx = 1;
        JTextField txtName = new JTextField("", 25);
        panel.add(txtName, gbc);
        
        // Row 2
        gbc.gridy = 2;
        gbc.gridx = 0;
        JLabel lblAge = new JLabel("Age: ");
        panel.add(lblAge, gbc);
        
        gbc.gridx = 1;
        JTextField txtAge = new JTextField("", 25);
        panel.add(txtAge, gbc);
        
        // Row 3
        gbc.gridy = 3;
        gbc.gridx = 0;
        JLabel lblAddress = new JLabel("Address: ");
        panel.add(lblAddress, gbc);
        
        gbc.gridx = 1;
        JTextField txtAddress = new JTextField("", 25);
        panel.add(txtAddress, gbc);
        
        // Row 4
        gbc.gridy = 4;
        JLabel titleGender = new JLabel("Gender: ");
        panel.add(titleGender, gbc);
        
        // Row 5
        gbc.gridy = 5;
        gbc.gridx = 1;
        JRadioButton rdMale = new JRadioButton("Male", true);
        JRadioButton rdFemale = new JRadioButton("Female");
        ButtonGroup bG = new ButtonGroup();
        bG.add(rdMale);
        bG.add(rdFemale);
        JPanel genderPanel = new JPanel();
        genderPanel.setLayout(new FlowLayout());
        genderPanel.add(rdMale);
        genderPanel.add(rdFemale);
        
        panel.add(genderPanel, gbc);
        
        // Row 6
        gbc.gridy = 6;
        gbc.gridx = 0;
        JLabel txtCourse = new JLabel("Course ");
        panel.add(txtCourse, gbc);
        
        gbc.gridx = 1;
        Object[] item = new Object[] {
            "Web Application Developer",
            "Database Administrator",
            "Network Administrator",
            "Windows Application Developer"
        };
        JComboBox cbbCourses = new JComboBox(item);
        panel.add(cbbCourses, gbc);
        
        // Row 7
        gbc.gridy = 7;
        gbc.gridx = 0;
        JLabel txtTimeSlot = new JLabel("Time Slot ");
        panel.add(txtTimeSlot, gbc);
        
        gbc.gridx = 1;
        Object[] itemTimeSlot = new Object[] {
            "7:00 – 9:00",
            "9:00 – 11:00",
            "11:00 – 1:00",
            "1:00 – 3:00",
            "3:00 – 5:00"
        };
        JList lstTimeSlot = new JList(itemTimeSlot);
        panel.add(lstTimeSlot, gbc);
        
        // Row 8
        gbc.gridy = 8;
        JLabel titleFacilities = new JLabel("Facilities ");
        panel.add(titleFacilities, gbc);
        
        // Row 9
        gbc.gridy = 9;
        gbc.gridx = 1;
        JCheckBox cbLibrary = new JCheckBox("Library");
        JCheckBox cbCDrome = new JCheckBox("Computer Drome");
        ButtonGroup bGF = new ButtonGroup();
        bGF.add(cbLibrary);
        bGF.add(cbCDrome);
        JPanel facilitiesPanel = new JPanel();
        facilitiesPanel.setLayout(new FlowLayout());
        facilitiesPanel.add(cbLibrary);
        facilitiesPanel.add(cbCDrome);
        panel.add(facilitiesPanel, gbc);
        
        // Row 10
        gbc.gridy = 10;
        gbc.gridx = 1;
        JButton btnOK    = new JButton("OK");
        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = txtName.getText();
                String age  = txtAge.getText();
                String address = txtAddress.getText();
                if(name.equals("") || age.equals("") || address.equals("")){
                    JOptionPane.showMessageDialog(null, "Không được để trống!", "Warning", 0);
                } else {
                    JOptionPane.showMessageDialog(null, "Name: " + name 
                                            + ", Age: " + age + ", Address: " + address, "OK", 1);
                }
            }
        });
        JButton btnClose = new JButton("Close");
        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
            }
        });
        JPanel panelButton = new JPanel();
        panelButton.setBackground(Color.decode("#b5ccf7"));
        panelButton.setLayout(new FlowLayout());
        panelButton.add(btnOK);
        panelButton.add(btnClose);
        panel.add(panelButton, gbc);
        
        f.add(panel);
        f.setVisible(true);
    }
}
