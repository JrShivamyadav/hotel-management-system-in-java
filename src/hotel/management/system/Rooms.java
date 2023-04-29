package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import  java.sql.*;
import net.proteanit.sql.*;
public class Rooms extends JFrame  implements ActionListener {

    JFrame frame;
    JTable table;
    JButton back;

    Rooms() {
        frame = new JFrame();
        frame.setBounds(300, 200, 1050, 600);
        frame.setVisible(true);
        Container c = frame.getContentPane();
        c.setBackground(Color.WHITE);
        c.setLayout(null);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500,0,600,600);
        c.add(image);

        JLabel l1 =new JLabel("RoomNumber");
        l1.setBounds(0,10,120,20);
        c.add(l1);

        JLabel l2 =new JLabel("Availaility");
        l2.setBounds(110,10,120,20);
        c.add(l2);

        JLabel l3 =new JLabel("Status");
        l3.setBounds(210,10,120,20);
        c.add(l3);

        JLabel l4 =new JLabel("Price");
        l4.setBounds(310,10,120,20);
        c.add(l4);
        JLabel l5 =new JLabel("Bed Type");
        l5.setBounds(410,10,120,20);
        c.add(l5);


        table =new JTable();
        table.setBounds(0,40,500,400);
        c.add(table);
        try{
            conn cn = new conn();
            ResultSet rs=cn.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception ee){
            ee.printStackTrace();
        }
        frame.setResizable(false);

        back= new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200,500,120,30);
        back.addActionListener(this);
        c.add(back);

    }
    public  static void main(String[] args){
        new Rooms();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
      frame.setVisible(false);
      new reception();
    }
}
