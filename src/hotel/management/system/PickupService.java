package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class PickupService extends JFrame implements ActionListener {

    JFrame frame;
    JTable table;
    JButton submit, back;

    Choice carType;
    JCheckBox availble;
    PickupService() {
        frame = new JFrame();
        frame.setBounds(300, 200, 1050, 600);
        frame.setVisible(true);
        Container c = frame.getContentPane();
        c.setBackground(Color.WHITE);
        c.setLayout(null);

        JLabel text =new JLabel("Pickup Service");
        text.setFont(new Font("Tohma",Font.BOLD,20));
        text.setBounds(400,30,200,20);
        c.add(text);

        JLabel lblbed=new JLabel(" Type of car");
        lblbed.setFont(new Font("Tohma",Font.PLAIN,15));
        lblbed.setBounds(50,100,100,20);
        c.add(lblbed);

        carType =new Choice();
        carType.setBounds(150,100,200,20);
        carType.setBackground(Color.WHITE);
        c.add(carType);
        try{
        conn cn=new conn();
        String query="select * from driver";
        ResultSet rs = cn.s.executeQuery(query);
        while (rs.next()){
            carType.add(rs.getString("carmodel"));
        }
        }
catch (Exception e){
            e.printStackTrace();
}

        JLabel l1 =new JLabel("Drvier Name");
        l1.setBounds(20,160,120,20);
        c.add(l1);

        JLabel l2 =new JLabel("Age");
        l2.setBounds(160,160,120,20);
        c.add(l2);

        JLabel l3 =new JLabel("Gender");
        l3.setBounds(310,160,120,20);
        c.add(l3);

        JLabel l4 =new JLabel("Car Company");
        l4.setBounds(450,160,120,20);
        c.add(l4);
        JLabel l5 =new JLabel("Car Model");
        l5.setBounds(600,160,120,20);
        c.add(l5);

        JLabel l6 =new JLabel("Availability");
        l6.setBounds(750,160,120,20);
        c.add(l6);

        JLabel l7 =new JLabel("Location");
        l7.setBounds(890,160,120,20);
        c.add(l7);


        table =new JTable();
        table.setBounds(20,180,1000,340);
        c.add(table);
        try{
            conn cn = new conn();
            ResultSet rs=cn.s.executeQuery("select * from driver ");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception ee){
            ee.printStackTrace();
        }
        frame.setResizable(false);

        submit= new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(320,520,120,30);
        submit.addActionListener(this);
        c.add(submit);

        back= new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(480,520,120,30);
        back.addActionListener(this);
        c.add(back);

    }
    public  static void main(String[] args){
        new PickupService();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){
            try{
                conn cn =new conn();
                String query="select * from driver where carmodel='"+carType.getSelectedItem()+"' ";
               ResultSet rs =cn.s.executeQuery(query);
               table.setModel(DbUtils.resultSetToTableModel(rs));

            }catch (Exception ee){
                ee.printStackTrace();
            }
        }
        else {
            frame.setVisible(false);
            new reception();
        }
    }

}
