package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class reception extends  JFrame implements ActionListener {

JFrame frame;
JButton btncustomerform,btnRooms,btndepartment,btnEmployees,btncustomerInfo,
        btnmanagerinfo ,btncheckout,btnupdatestatus, btnupdateroomstatus,
        btnpickupservice , btnsearchroom, btnlogout;
    reception(){
        frame=new JFrame();
        frame.setBounds(300,160,950,660);
        frame.setVisible(true);
        Container c= frame.getContentPane();
        c.setBackground(Color.WHITE);
        c.setLayout(null);

        btncustomerform =new JButton("New Customer Form");
        btncustomerform.setBackground(Color.BLACK);
        btncustomerform.setFont(new Font("Arial",Font.BOLD,14));
        btncustomerform.setForeground(Color.WHITE);
        btncustomerform.setBounds(40,10,240,35);
        btncustomerform.addActionListener(this);
        c.add(btncustomerform);

        btnRooms =new JButton("Rooms");
        btnRooms.setBackground(Color.BLACK);
        btnRooms.setFont(new Font("Arial",Font.BOLD,14));
        btnRooms.setForeground(Color.WHITE);
        btnRooms.setBounds(40,60,240,35);
        btnRooms.addActionListener(this);
        c.add(btnRooms);

        btndepartment =new JButton("Department");
        btndepartment.setBackground(Color.BLACK);
        btndepartment.setFont(new Font("Arial",Font.BOLD,14));
        btndepartment.setForeground(Color.WHITE);
        btndepartment.setBounds(40,110,240,35);
        btndepartment.addActionListener(this);
        c.add(btndepartment);


        btnEmployees =new JButton("All Employees");
        btnEmployees.setBackground(Color.BLACK);
        btnEmployees.setFont(new Font("Arial",Font.BOLD,14));
        btnEmployees.setForeground(Color.WHITE);
        btnEmployees.setBounds(40,160,240,35);
        btnEmployees.addActionListener(this);
        c.add(btnEmployees);

        btncustomerInfo =new JButton(" Customer Info");
        btncustomerInfo .setBackground(Color.BLACK);
        btncustomerInfo .setFont(new Font("Arial",Font.BOLD,14));
        btncustomerInfo .setForeground(Color.WHITE);
        btncustomerInfo .setBounds(40,210,240,35);
        btncustomerInfo .addActionListener(this);
        c.add(btncustomerInfo );


        btnmanagerinfo =new JButton("Manager Info");
        btnmanagerinfo.setBackground(Color.BLACK);
        btnmanagerinfo.setFont(new Font("Arial",Font.BOLD,14));
        btnmanagerinfo.setForeground(Color.WHITE);
        btnmanagerinfo.setBounds(40,260,240,35);
        btnmanagerinfo.addActionListener(this);
        c.add(btnmanagerinfo);

        btncheckout =new JButton("Checkout");
        btncheckout.setBackground(Color.BLACK);
        btncheckout.setFont(new Font("Arial",Font.BOLD,14));
        btncheckout.setForeground(Color.WHITE);
        btncheckout.setBounds(40,310,240,35);
        btncheckout.addActionListener(this);
        c.add(btncheckout);


        btnupdatestatus =new JButton("Update Satatus");
        btnupdatestatus.setBackground(Color.BLACK);
        btnupdatestatus.setFont(new Font("Arial",Font.BOLD,14));
        btnupdatestatus.setForeground(Color.WHITE);
        btnupdatestatus.setBounds(40,360,240,35);
        btnupdatestatus.addActionListener(this);
        c.add(btnupdatestatus);

        btnupdateroomstatus =new JButton("Update Room Status");
        btnupdateroomstatus.setBackground(Color.BLACK);
        btnupdateroomstatus.setFont(new Font("Arial",Font.BOLD,14));
        btnupdateroomstatus.setForeground(Color.WHITE);
        btnupdateroomstatus.setBounds(40,410,240,35);
        btnupdateroomstatus.addActionListener(this);
        c.add( btnupdateroomstatus);


        btnpickupservice =new JButton("Pickup Service");
        btnpickupservice.setBackground(Color.BLACK);
        btnpickupservice.setFont(new Font("Arial",Font.BOLD,14));
        btnpickupservice.setForeground(Color.WHITE);
        btnpickupservice.setBounds(40,460,240,35);
        btnpickupservice.addActionListener(this);
        c.add(btnpickupservice);

        btnsearchroom =new JButton("Search room");
        btnsearchroom.setBackground(Color.BLACK);
        btnsearchroom.setFont(new Font("Arial",Font.BOLD,14));
        btnsearchroom.setForeground(Color.WHITE);
        btnsearchroom.setBounds(40,510,240,35);
        btnsearchroom.addActionListener(this);
        c.add( btnsearchroom);

        btnlogout =new JButton("Logout");
        btnlogout.setBackground(Color.BLACK);
        btnlogout.setFont(new Font("Arial",Font.BOLD,14));
        btnlogout.setForeground(Color.WHITE);
        btnlogout.setBounds(40,560,240,35);
        btnlogout.addActionListener(this);
        c.add( btnlogout);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(320,10,580,580);
        c.add(image);

        frame.setResizable(false);
    }

    public  static  void  main(String [] args){
        new reception();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btncustomerform ){
            frame.setVisible(false);
            new Customerform();


        } else if (e.getSource()==btnRooms) {
            frame.setVisible(false);
            new Rooms();
        }else if (e.getSource()==btndepartment) {
            frame.setVisible(false);
            new Department();
        }
        else if (e.getSource()==btnEmployees) {
            frame.setVisible(false);
            new employeeinfo();
        }
        else if (e.getSource()==btnmanagerinfo) {
            frame.setVisible(false);
            new ManagerInfo();
        }
        else if (e.getSource()==btncustomerInfo) {
            frame.setVisible(false);
            new CustomerInfo();
        }
        else if (e.getSource()==btnsearchroom) {
            frame.setVisible(false);
            new SearchRoom();
        }
        else if (e.getSource()==btnupdatestatus) {
            frame.setVisible(false);
            new Updatecheck();
        }
        else if (e.getSource()==btnupdateroomstatus) {
            frame.setVisible(false);
            new UpdateRoom();
        }
        else if (e.getSource()==btnpickupservice) {
            frame.setVisible(false);
            new PickupService();
        }
        else if (e.getSource()==btncheckout) {
            frame.setVisible(false);
            new Checkout();
        }
        else if (e.getSource()==btnlogout) {
            frame.setVisible(false);
            new login();
        }
    }
}
