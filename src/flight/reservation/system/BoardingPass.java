package flight.reservation.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class BoardingPass extends JFrame implements ActionListener{
    
    JTextField tfpnr;
    JLabel tfname, tfnationality, lblsrc, lbldest, labelfname, labelfcode, labeldate;
    JButton fetchButton;
    
    public BoardingPass() {
//    	System.out.println("BoardingPass constructor called"); // Debug output
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Aerial Ascend Airways");
        heading.setBounds(380, 10, 325, 39);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        getContentPane().add(heading);
        
        JLabel subheading = new JLabel("Boarding Pass");
        subheading.setBounds(360, 50, 300, 30);
        subheading.setFont(new Font("Tahoma", Font.PLAIN, 24));
        subheading.setForeground(Color.BLUE);
        getContentPane().add(subheading);
        
        JLabel lblaadhar = new JLabel("PNR DETAILS");
        lblaadhar.setBounds(60, 100, 150, 25);
        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        getContentPane().add(lblaadhar);
        
        tfpnr = new JTextField();
        tfpnr.setBounds(220, 100, 150, 25);
        getContentPane().add(tfpnr);
        
        fetchButton = new JButton("Enter");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(380, 100, 120, 25);
        fetchButton.addActionListener(this);
        getContentPane().add(fetchButton);
        
        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(60, 140, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        getContentPane().add(lblname);
        
        tfname = new JLabel();
        tfname.setBounds(220, 140, 150, 25);
        getContentPane().add(tfname);
        
        JLabel lblnationality = new JLabel("NATIONALITY");
        lblnationality.setBounds(60, 180, 150, 25);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        getContentPane().add(lblnationality);
        
        tfnationality = new JLabel();
        tfnationality.setBounds(220, 180, 150, 25);
        getContentPane().add(tfnationality);
        
        JLabel lbladdress = new JLabel("SRC");
        lbladdress.setBounds(60, 220, 150, 25);
        lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        getContentPane().add(lbladdress);
        
        lblsrc = new JLabel();
        lblsrc.setBounds(220, 220, 150, 25);
        getContentPane().add(lblsrc);
        
        JLabel lblgender = new JLabel("DEST");
        lblgender.setBounds(380, 220, 150, 25);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        getContentPane().add(lblgender);
        
        lbldest = new JLabel();
        lbldest.setBounds(540, 220, 150, 25);
        getContentPane().add(lbldest);
        
        JLabel lblfname = new JLabel("Flight Name");
        lblfname.setBounds(60, 260, 150, 25);
        lblfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        getContentPane().add(lblfname);
        
        labelfname = new JLabel();
        labelfname.setBounds(220, 260, 150, 25);
        getContentPane().add(labelfname);
        
        JLabel lblfcode = new JLabel("Flight Code");
        lblfcode.setBounds(380, 260, 150, 25);
        lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        getContentPane().add(lblfcode);
        
        labelfcode = new JLabel();
        labelfcode.setBounds(540, 260, 150, 25);
        getContentPane().add(labelfcode);
        
        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60, 300, 150, 25);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        getContentPane().add(lbldate);
        
        labeldate = new JLabel();
        labeldate.setBounds(220, 300, 150, 25);
        getContentPane().add(labeldate);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icons/Airlines.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 230, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(560, 10, 416, 403);
        getContentPane().add(lblimage);
        
        JLabel lblduration = new JLabel("Flight Duration");
        lblduration.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblduration.setBounds(60, 336, 111, 30);
        getContentPane().add(lblduration);
        
        JLabel labelduration = new JLabel("");
        labelduration.setBounds(220, 336, 150, 25);
        getContentPane().add(labelduration);
        
        setSize(1000, 450);
        setLocation(150, 150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        String pnr = tfpnr.getText();

        try {
            Conn conn = new Conn();

            String query1 = "select * from reservation where PNR = '"+pnr+"'";
//            String query2 = "";
            
            ResultSet rs1 = conn.s.executeQuery(query1);
//            ResultSet rs2 = conn.s.executeQuery(query2);
            if (rs1.next()) {
                tfname.setText(rs1.getString("name")); 
                tfnationality.setText(rs1.getString("nationality")); 
                lblsrc.setText(rs1.getString("src")); 
                lbldest.setText(rs1.getString("des"));  
                labelfname.setText(rs1.getString("flightname"));  
                labelfcode.setText(rs1.getString("flightcode"));  
                labeldate.setText(rs1.getString("ddate")); 
            } else {
                JOptionPane.showMessageDialog(null, "Please enter correct PNR");                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new BoardingPass();
    }
}
