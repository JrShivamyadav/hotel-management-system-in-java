package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.ScatteringByteChannel;
import java.sql.*;
import java.util.Date;
import java.sql.ResultSet;

public class Checkout extends  JFrame implements ActionListener {
  JFrame frame;
  JButton checkout,back;

    JLabel lblcheckin,lblcheckouttime,lblroomnumber;


  Choice customer;
    Checkout(){
        frame =new JFrame();
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setBounds(300,200,860,400);
        frame.setLayout(null);
        frame.setVisible(true);

        JLabel text = new JLabel("Checkout");
        text.setBounds(100,20,100,30);
        text.setForeground(Color.blue);
        text.setFont(new Font("Arial",Font.BOLD,20));
        frame.add(text);

        JLabel lblid= new JLabel("Customer id");
        lblid.setBounds(30,80,100,30);
        lblid.setFont(new Font("Arial",Font.PLAIN,17));
        frame.add(lblid);

        customer = new Choice();
        customer.setBounds(180,80,170,30);
        frame.add(customer);




        JLabel lblroom= new JLabel("Room Number");
        lblroom.setBounds(30,130,100,30);
        lblroom.setFont(new Font("Arial",Font.PLAIN,17));
        frame.add(lblroom);
        lblroomnumber= new JLabel();
        lblroomnumber.setBounds(180,130,200,30);
        frame.add(lblroomnumber);

        JLabel lblcheck= new JLabel("Checkin Time");
        lblcheck.setBounds(30,180,200,30);
        lblcheck.setFont(new Font("Arial",Font.PLAIN,17));
        frame.add(lblcheck);
        lblcheckin= new JLabel();
        lblcheckin.setBounds(180,180,200,30);
        frame.add(lblcheckin);

        JLabel lblcheckout= new JLabel("Checkout Time");
        lblcheckout.setBounds(30,230,200,30);
        lblcheckout.setFont(new Font("Arial",Font.PLAIN,17));
        frame.add(lblcheckout);
        Date date= new Date();
        lblcheckouttime= new JLabel(""+ date);
        lblcheckouttime.setBounds(180,230,200,30);
        frame.add(lblcheckouttime);

        checkout= new JButton("Checkout");
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.setBounds(80,300,100,30);
        checkout.addActionListener(this);
        frame.add(checkout);

        back= new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(240,300,100,30);
        back.addActionListener(this);
        frame.add(back);



        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i5= i4.getImage().getScaledInstance(400,250,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image1 =new JLabel(i6);
        image1.setBounds(400,50,400,250);
        frame.add(image1);

        try{
            conn c=new conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                customer.add(rs.getString("number"));
                lblroomnumber.setText(rs.getString("room"));
                lblcheckin.setText(rs.getString("time"));
            }

        }catch (Exception ee){
            ee.printStackTrace();
        }

        frame.setResizable(false);
    }
    public  static  void  main(String []args){
        new Checkout();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==checkout){
            String query="delete from customer where number ='"+customer.getSelectedItem()+"'";
            String query1="update room set availability ='Available' where roomnumber ='"+lblroomnumber.getText()+"'" ;
            try{
                conn c = new conn();
                c.s.executeUpdate(query);
                c.s.executeUpdate(query1);

                JOptionPane.showMessageDialog(null,"CheckOut Done");

                frame.setVisible(false);
                new reception();
            }catch (Exception ee){
                ee.printStackTrace();
            }

        }
        else  {
            frame.setVisible(false);
            new reception();
        }

    }
}
