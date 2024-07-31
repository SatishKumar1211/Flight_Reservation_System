package flight.reservation.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;

public class JourneyDetails extends JFrame implements ActionListener{
    JTable table;
    JTextField pnr;
    JButton show;
    
    public JourneyDetails() {
        
        getContentPane().setBackground(new Color(138, 217, 255));
        getContentPane().setLayout(null);
        
        JLabel lblpnr = new JLabel("PNR Number");
        lblpnr.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblpnr.setBounds(52, 84, 100, 25);
        getContentPane().add(lblpnr);
        
        pnr = new JTextField();
        pnr.setBounds(162, 84, 120, 25);
        getContentPane().add(pnr);
        
        show = new JButton("Show Details");
        show.setBackground(Color.BLACK);
        show.setForeground(Color.WHITE);
        show.setBounds(359, 84, 120, 25);
        show.addActionListener(this);
        getContentPane().add(show);
        
        table = new JTable();
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 142, 786, 150);
        jsp.setBackground(Color.WHITE);
        getContentPane().add(jsp);
        
        JLabel lblPnrEnquiry = new JLabel("PNR ENQUIRY");
        lblPnrEnquiry.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblPnrEnquiry.setBounds(285, 11, 231, 46);
        getContentPane().add(lblPnrEnquiry);
        
        setSize(800, 600);
        setLocation(300, 50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from reservation where PNR = '"+pnr.getText()+"'");
            
            if (!rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "Reservation not Found!!");
                return;
            }
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new JourneyDetails();
    }
}
