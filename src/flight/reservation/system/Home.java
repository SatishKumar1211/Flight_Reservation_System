package flight.reservation.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener{
    
    public Home() {
        getContentPane().setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icons/front.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1281, 676);
        getContentPane().add(image);
        
        JLabel heading = new JLabel("Flight Rservation System");
        heading.setBounds(450, 40, 1000, 40);
        heading.setForeground(Color.BLACK);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 36));
        image.add(heading);
        
        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);
        
        JMenu details = new JMenu("Enquiry");
        menubar.add(details);
        
        JMenuItem flightDetails = new JMenuItem("Current Flight Details");
        flightDetails.addActionListener(this);
        details.add(flightDetails);
        
        JMenuItem customerDetails = new JMenuItem("Add Customer Details");
        customerDetails.addActionListener(this);
        details.add(customerDetails);
        
        JMenuItem bookFlight = new JMenuItem("Book Flight");
        bookFlight.addActionListener(this);
        details.add(bookFlight);
        
        JMenuItem journeyDetails = new JMenuItem("Check Journey Details");
        journeyDetails.addActionListener(this);
        details.add(journeyDetails);
        
        JMenuItem ticketCancellation = new JMenuItem("Cancel Flight Ticket");
        ticketCancellation.addActionListener(this);
        details.add(ticketCancellation);
        
        JMenu ticket = new JMenu("Ticket");
        menubar.add(ticket);
        
        JMenuItem boardingPass = new JMenuItem("Boarding Pass");
        boardingPass.addActionListener(this);
        ticket.add(boardingPass);
        
        
        setExtendedState(JFrame.MAXIMIZED_BOTH); //for fullscreen
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
    	String text = ae.getActionCommand();
    	
        if (text.equals("Boarding Pass")) {
            new BoardingPass();
        }
        
        if (text.equals("Add Customer Details")) {
            new AddCustomer();
        } else if (text.equals("Current Flight Details")) {
            new FlightInfo();
        } else if (text.equals("Book Flight")) {
            new BookFlight();
        } else if (text.equals("Check Journey Details")) {
            new JourneyDetails();
        } else if (text.equals("Cancel Flight Ticket")) {
            new Cancel();
        }
        
    }
    
    public static void main(String[] args) {
        new Home();
    }
}
