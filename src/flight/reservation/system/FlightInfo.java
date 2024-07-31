package flight.reservation.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class FlightInfo extends JFrame{
    
    public FlightInfo() {
    	setBackground(new Color(115, 185, 255));
        
        getContentPane().setBackground(Color.WHITE);
        getContentPane().setLayout(null);
        
        JTable table = new JTable();
        
        try {
            Conn conn = new Conn();
            
            ResultSet rs = conn.s.executeQuery("select f_code as 'Flight Code', f_name as 'Flight Name', source as 'FROM', destination as 'TO', duration as 'Duration (hours)'  from flight");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 0, 786, 356);
        getContentPane().add(jsp);
        
        setSize(800, 393);
        setLocation(400, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new FlightInfo();
    }
}
