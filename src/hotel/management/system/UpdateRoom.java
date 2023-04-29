package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateRoom  extends JFrame implements ActionListener {
    JFrame frame;
    JTextField tfroom,tfavailable,tfStatus;
    Choice customer;
    JButton check,update,back;

    UpdateRoom(){
        frame= new JFrame();
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setBounds(300,200,980,500);
        frame.setLayout(null);

        JLabel lblText = new JLabel("Update Room Status");
        lblText.setFont(new Font("Tohma",Font.BOLD,20));
        lblText.setForeground(Color.blue);
        lblText.setBounds(90,0,250,30);
        frame.add( lblText);

        JLabel lblid= new JLabel("Customer ID");
        lblid.setBounds(30,80,80,30);
        frame.add(lblid);

        customer = new Choice();
        customer.setBounds(180,80,170,30);
        frame.add(customer);
        try{
            conn c=new conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                customer.add(rs.getString("number"));
            }

        }catch (Exception ee){
            ee.printStackTrace();
        }

        JLabel lblroom= new JLabel("Room Number");
        lblroom.setBounds(30,140,100,30);
        frame.add(lblroom);
        tfroom = new JTextField();
        tfroom.setBounds(180,140,170,30);
        frame.add(tfroom);

        JLabel lblavailable= new JLabel("Availability");
        lblavailable.setBounds(30,200,100,30);
        frame.add(lblavailable);
        tfavailable = new JTextField();
        tfavailable.setBounds(180,200,170,30);
        frame.add(tfavailable);

        JLabel lblStatus= new JLabel("Cleaning Status");
        lblStatus.setBounds(30,260,100,30);
        frame.add(lblStatus);
        tfStatus = new JTextField();
        tfStatus .setBounds(180,260,170,30);
        frame.add(tfStatus);




        check= new JButton("Check");
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setBounds(30,370,100,30);
        check.addActionListener(this);
        frame.add(check);

        update= new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(145,370,100,30);
        update.addActionListener(this);
        frame.add(update);

        back= new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(260,370,100,30);
        back.addActionListener(this);
        frame.add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(480,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(450,70,480,300);
        frame.add(image);

        frame.setVisible(true);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==check){
            String id = customer.getSelectedItem();
            try {
                conn c = new conn();
                String query = "select * from customer where number='" + id + "'";
                ResultSet rs = c.s.executeQuery(query);
                while (rs.next()){
                    tfroom.setText(rs.getString("room"));
                }
                ResultSet r =c.s.executeQuery("select * from room where roomnumber='"+tfroom.getText()+"' ");
                while (r.next()){
                    tfavailable.setText(r.getString("availability"));
                    tfStatus.setText(r.getString("status"));

                }
            }catch (Exception ae){
                ae.printStackTrace();
            }

        } else if (e.getSource()==update) {
            String number =customer.getSelectedItem();
            String room = tfroom.getText();
            String available=tfavailable.getText();
            String  status=tfStatus.getText();

            try{
                conn c =new conn();
                c.s.executeUpdate("update room set availability='"+available+"',status='"+status+"' where roomnumber='"+room+"' ");



                JOptionPane.showMessageDialog(null,"Data updated Sucessfully");
                frame.setVisible(false);
                new reception();
            }catch (Exception ae){
                ae.printStackTrace();
            }

        } else if (e.getSource()==back) {
            frame.setVisible(false);
            new reception();
        }

    }
    public static  void main(String [] args){
        new UpdateRoom();
    }
}
