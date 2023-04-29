package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import  java.sql.*;
import net.proteanit.sql.*;
public class CustomerInfo extends JFrame  implements ActionListener {

    JFrame frame;
    JTable table;
    JButton back;

    CustomerInfo() {
        frame = new JFrame();
        frame.setBounds(300, 200, 1050, 600);
        frame.setVisible(true);
        Container c = frame.getContentPane();
        c.setBackground(Color.WHITE);
        c.setLayout(null);


        JLabel l1 =new JLabel("Id");
        l1.setBounds(30,10,120,20);
        c.add(l1);

        JLabel l2 =new JLabel("Name");
        l2.setBounds(150,10,120,20);
        c.add(l2);

        JLabel l3 =new JLabel("Number");
        l3.setBounds(270,10,120,20);
        c.add(l3);

        JLabel l4 =new JLabel("Gender");
        l4.setBounds(400,10,120,20);
        c.add(l4);

        JLabel l5 =new JLabel("Country");
        l5.setBounds(520,10,120,20);
        c.add(l5);

        JLabel l6 =new JLabel("Room No.");
        l6.setBounds(650,10,120,20);
        c.add(l6);

        JLabel l7 =new JLabel("Checkin Time");
        l7.setBounds(770,10,120,20);
        c.add(l7);

        JLabel l8 =new JLabel("Deposit");
        l8.setBounds(900,10,120,20);
        c.add(l8);


        table =new JTable();
        table.setBounds(20,40,1000,400);
        c.add(table);
        try{
            conn cn = new conn();
            ResultSet rs=cn.s.executeQuery("select * from  customer");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception ee){
            ee.printStackTrace();
        }
        frame.setResizable(false);

        back= new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(420,500,120,30);
        back.addActionListener(this);
        c.add(back);

    }
    public  static void main(String[] args){
        new CustomerInfo();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        frame.setVisible(false);
        new reception();
    }
}


