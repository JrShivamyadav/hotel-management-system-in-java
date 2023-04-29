package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hotel_Management_System extends JFrame  implements ActionListener {
    JFrame frame;
    Hotel_Management_System(){
        frame =new JFrame();
       frame.setBounds(100,100,1366,565);
        frame.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));

        JLabel image =new JLabel(i1);
        image.setBounds(0,0,1366,565);
       frame.add(image);

        JLabel text=new JLabel("Hotel Management System");
        text.setBounds( 30,450,700,90);
       image.add(text);
      text.setForeground(Color.WHITE);
      text.setFont(new Font("Broadway",Font.PLAIN,40));

      JButton btnnext= new JButton("Next");
      btnnext.setBounds(960,480,150,35);
      image.add(btnnext);
      btnnext.setBackground(Color.ORANGE);
        btnnext.setForeground(Color.WHITE);
        btnnext.setFont(new Font("Arial",Font.PLAIN,20));
        btnnext.addActionListener(this);
       frame.setVisible(true);

        while (true){
            text.setVisible(false);
            try{
                Thread.sleep(500);
            }catch (Exception e){
                e.printStackTrace();
            }
            text.setVisible(true);
            try{
                Thread.sleep(500);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
 frame.setVisible(false);


    new login();
    }
 public  static void main(String[] args){
     new Hotel_Management_System();
 }


}