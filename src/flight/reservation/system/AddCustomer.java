package flight.reservation.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener{
    
    JTextField tfname, tfphone, tfaadhar, tfnationality, tfaddress;
    JRadioButton rbmale, rbfemale;
    private JTextField tfemail;
    
    public AddCustomer() {
        getContentPane().setBackground(new Color(147, 220, 255));
        getContentPane().setLayout(null);
        
        JLabel heading = new JLabel("ADD CUSTOMER DETAILS");
        heading.setBounds(220, 20, 500, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        heading.setForeground(Color.BLACK);
        getContentPane().add(heading);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(507, 80, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        getContentPane().add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(709, 82, 150, 25);
        getContentPane().add(tfname);
        
        JLabel lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(507, 130, 150, 25);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        getContentPane().add(lblnationality);
        
        tfnationality = new JTextField();
        tfnationality.setBounds(709, 132, 150, 25);
        getContentPane().add(tfnationality);
        
        JLabel lblaadhar = new JLabel("Aadhar Number");
        lblaadhar.setBounds(507, 180, 150, 25);
        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        getContentPane().add(lblaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(709, 182, 150, 25);
        getContentPane().add(tfaadhar);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(507, 230, 150, 25);
        lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        getContentPane().add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(709, 232, 150, 25);
        getContentPane().add(tfaddress);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(507, 280, 150, 25);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        getContentPane().add(lblgender);
        
        ButtonGroup gendergroup = new ButtonGroup();
        
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(709, 282, 70, 25);
        rbmale.setBackground(Color.WHITE);
        getContentPane().add(rbmale);
        
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(789, 282, 70, 25);
        rbfemale.setBackground(Color.WHITE);
        getContentPane().add(rbfemale);
        
        gendergroup.add(rbmale);
        gendergroup.add(rbfemale);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(507, 328, 150, 25);
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        getContentPane().add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(709, 330, 150, 25);
        getContentPane().add(tfphone);
        
        JLabel lblemail = new JLabel("Email id");
        lblemail.setBounds(507, 381, 150, 25);
        lblemail.setFont(new Font("Tahoma", Font.PLAIN, 16));
        getContentPane().add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(709, 383, 150, 25);
        getContentPane().add(tfemail);
        
        JButton save = new JButton("SAVE");
        save.setBackground(Color.BLACK);
        save.setForeground(Color.WHITE);
        save.setBounds(611, 452, 150, 30);
        save.addActionListener(this);
        getContentPane().add(save);
        
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icons/icons/customer.png"));
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(45, 66, 396, 486);
        getContentPane().add(lblimage);
        
        setSize(900, 600);
        setLocation(200, 50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        String name = tfname.getText();
        String nationality = tfnationality.getText();
        String phone = tfphone.getText();
        String address = tfaddress.getText();
        String aadhar = tfaadhar.getText();
        String gender = null;
        if (rbmale.isSelected()) {
            gender = "Male";
        } else {
            gender = "Female";
        }
        
        try {
            Conn conn = new Conn();
            
            String query = "insert into passenger values('"+name+"', '"+nationality+"', '"+phone+"', '"+address+"', '"+aadhar+"', '"+gender+"')";
        
            conn.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
        
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new AddCustomer();
    }
}