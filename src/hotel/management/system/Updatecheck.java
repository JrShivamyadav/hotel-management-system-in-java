package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Updatecheck  extends JFrame implements ActionListener {
    JFrame frame;
    JTextField tfroom,tfname,tfcheckin ,tfpaid,tfpending;
    Choice customer;
    JButton check,update,back;

    Updatecheck(){
       frame= new JFrame();
       frame.getContentPane().setBackground(Color.WHITE);
       frame.setBounds(300,200,980,500);
       frame.setLayout(null);

       JLabel lblText = new JLabel("Update Status");
        lblText.setFont(new Font("Tohma",Font.BOLD,20));
        lblText.setForeground(Color.blue);
        lblText.setBounds(90,0,200,30);
        frame.add( lblText);

        JLabel lblid= new JLabel("Customer ID");
        lblid.setBounds(30,50,80,30);
        frame.add(lblid);

        customer = new Choice();
        customer.setBounds(180,50,170,30);
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
        lblroom.setBounds(30,90,100,30);
        frame.add(lblroom);
        tfroom = new JTextField();
        tfroom.setBounds(180,90,170,30);
        frame.add(tfroom);

        JLabel lblname= new JLabel("Name");
        lblname.setBounds(30,140,100,30);
        frame.add(lblname);
        tfname = new JTextField();
        tfname.setBounds(180,140,170,30);
        frame.add(tfname);

        JLabel lblcheckin= new JLabel("Checkin");
        lblcheckin.setBounds(30,190,100,30);
        frame.add(lblcheckin);
        tfcheckin = new JTextField();
        tfcheckin .setBounds(180,190,170,30);
        frame.add(tfcheckin);

        JLabel lblpaid= new JLabel("Amount Paid");
        lblpaid.setBounds(30,240,100,30);
        frame.add(lblpaid);
        tfpaid= new JTextField();
        tfpaid .setBounds(180,240,170,30);
        frame.add(tfpaid);

        JLabel lblpendeing= new JLabel("Pending Amount");
        lblpendeing.setBounds(30,290,100,30);
        frame.add(lblpendeing);
        tfpending= new JTextField();
        tfpending .setBounds(180,290,170,30);
        frame.add(tfpending);

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

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        JLabel image =new JLabel(i1);
        image.setBounds(400,50,500,300);
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
             tfname.setText(rs.getString("name"));
             tfcheckin.setText(rs.getString("time"));
             tfpaid.setText(rs.getString("deposit"));
         }
         ResultSet r =c.s.executeQuery("select * from room where roomnumber='"+tfroom.getText()+"' ");
    while (r.next()){
        String price=r.getString("price");
        int ammountpaid = Integer.parseInt(price)-Integer.parseInt(tfpaid.getText());
        tfpending.setText(""+ammountpaid);
    }
     }catch (Exception ae){
         ae.printStackTrace();
     }

 } else if (e.getSource()==update) {
     String number =customer.getSelectedItem();
     String room = tfroom.getText();
     String name = tfname.getText();
     String checkin = tfcheckin.getText();
     String deposit= tfpaid.getText();
try{
    conn c =new conn();
    c.s.executeUpdate("update customer set room='"+room+"',name='"+name+"', time='"+checkin+"',deposit='"+deposit+"' where number='"+number+"'");

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
        new Updatecheck();
    }
}
