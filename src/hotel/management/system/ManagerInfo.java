package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import  java.sql.*;
import net.proteanit.sql.*;
public class ManagerInfo extends JFrame  implements ActionListener {

    JFrame frame;
    JTable table;
    JButton back;

    ManagerInfo() {
        frame = new JFrame();
        frame.setBounds(300, 200, 1050, 600);
        frame.setVisible(true);
        Container c = frame.getContentPane();
        c.setBackground(Color.WHITE);
        c.setLayout(null);


        JLabel l1 =new JLabel("Name");
        l1.setBounds(30,10,120,20);
        c.add(l1);

        JLabel l2 =new JLabel("Age");
        l2.setBounds(150,10,120,20);
        c.add(l2);

        JLabel l3 =new JLabel("Gender");
        l3.setBounds(270,10,120,20);
        c.add(l3);

        JLabel l4 =new JLabel("Job");
        l4.setBounds(400,10,120,20);
        c.add(l4);

        JLabel l5 =new JLabel("Salary");
        l5.setBounds(520,10,120,20);
        c.add(l5);

        JLabel l6 =new JLabel("Email");
        l6.setBounds(650,10,120,20);
        c.add(l6);

        JLabel l7 =new JLabel("Phone");
        l7.setBounds(770,10,120,20);
        c.add(l7);

        JLabel l8 =new JLabel("Aadhar");
        l8.setBounds(900,10,120,20);
        c.add(l8);


        table =new JTable();
        table.setBounds(20,40,1000,400);
        c.add(table);
        try{
            conn cn = new conn();
            ResultSet rs=cn.s.executeQuery("select * from employee where job ='Manager'");
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
        new ManagerInfo();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        frame.setVisible(false);
        new reception();
    }
}


