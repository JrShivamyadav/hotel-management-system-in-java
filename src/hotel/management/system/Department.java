package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import  java.sql.*;
import net.proteanit.sql.*;
public class Department extends JFrame  implements ActionListener {

    JFrame frame;
    JTable table;
    JButton back;

    Department() {
        frame = new JFrame();
        frame.setBounds(300, 200, 700, 600);
        frame.setVisible(true);
        Container c = frame.getContentPane();
        c.setBackground(Color.WHITE);
        c.setLayout(null);



        JLabel l1 =new JLabel("Department");
        l1.setBounds(160,10,120,20);
        c.add(l1);

        JLabel l2 =new JLabel("Budget");
        l2.setBounds(360,10,120,20);
        c.add(l2);




        table =new JTable();
        table.setBounds(30,40,680,400);
        c.add(table);
        try{
            conn cn = new conn();
            ResultSet rs=cn.s.executeQuery("select * from department");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception ee){
            ee.printStackTrace();
        }
        frame.setResizable(false);

        back= new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(250,500,120,30);
        back.addActionListener(this);
        c.add(back);

    }
    public  static void main(String[] args){
        new Department() ;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        frame.setVisible(false);
        new reception();
    }
}

