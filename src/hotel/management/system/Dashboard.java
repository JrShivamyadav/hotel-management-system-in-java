package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame  implements ActionListener {

    JMenuItem reception,addemployee,addroom,adddrivers;
    Dashboard(){
        setBounds(0,0,1550,820);
        setLayout(null);
        ImageIcon icon =new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i1= icon.getImage().getScaledInstance(1550,820,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel image = new JLabel(i2);
        image.setBounds(0,0,1550,820);
         add(image);

         JLabel title = new JLabel("Taj Groups are welcomes you");
         title.setBounds(380,30,800,100);
         Font font=new Font("Broadway",Font.TRUETYPE_FONT,50);
         title.setForeground(Color.WHITE);
         title.setFont(font);
        image.add(title);

        JMenuBar mb =new JMenuBar();
        mb.setBounds(0,0,1550,30);
        image.add(mb);

        Font font1 =new Font("Arial",Font.BOLD,15);

        JMenu hotel =new JMenu("Hotel Management");
        hotel.setForeground(Color.red);
        hotel.setFont(font1);
        mb.add(hotel);

        reception =new JMenuItem("Reception");
        reception.addActionListener(this);
        reception.setFont(font1);
        hotel.add(reception);



        JMenu admin =new JMenu("Admin");
        admin.setForeground(Color.blue);
        admin.setFont(font1);
        mb.add(admin);
         addemployee =new JMenuItem("Add Employee");
        addemployee.addActionListener(this);
        addemployee.setFont(font1);
        admin.add(addemployee);
        addroom =new JMenuItem("Add Rooms");
        addroom.setFont(font1);
        addroom.addActionListener(this);
        admin.add(addroom);
        adddrivers =new JMenuItem("Add Drivers");
        adddrivers.setFont(font1);
        adddrivers.addActionListener(this);
        admin.add(adddrivers);

        setVisible(true);

    }






    public static void main(String[] args) {
        new Dashboard();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
 if(ae.getActionCommand().equals("Add Employee")){
     new AddEmployee();
 } else if (ae.getActionCommand().equals("Add Rooms")) {
     new AddRoom();
 }
 else if (ae.getActionCommand().equals("Add Drivers")) {
     new AddDrivers();
 }else if (ae.getActionCommand().equals("Reception")) {
     new reception();
 }
    }
}
