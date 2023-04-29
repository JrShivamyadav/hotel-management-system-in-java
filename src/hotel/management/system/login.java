package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {
    JFrame frame;
    JTextField username;
    JPasswordField password;
    JButton btnlogin, btnCancel;

    login() {
        frame = new JFrame();
        frame.setBounds(170, 100, 1000, 500);
        frame.setVisible(true);
        Container c = frame.getContentPane();
        c.setBackground(Color.orange);
        c.setLayout(null);

        JLabel title = new JLabel("Login");
        title.setBounds(420, 10, 300, 100);
        Font fonttitle = new Font("Bodoni MT Black", Font.BOLD, 45);
        title.setFont(fonttitle);
        c.add(title);

        JLabel User = new JLabel("Username");
        User.setBounds(100, 170, 150, 30);
        Font font = new Font("Arial", Font.PLAIN, 20);
        User.setFont(font);
        c.add(User);

        username = new JTextField();
        username.setBounds(270, 170, 250, 30);
        c.add(username);

        JLabel pass = new JLabel("Password");
        pass.setBounds(100, 250, 150, 30);
        pass.setFont(font);
        c.add(pass);

        password = new JPasswordField();
        password.setBounds(270, 250, 250, 30);
        c.add(password);

        btnlogin = new JButton("Login");
        btnlogin.setBounds(150, 380, 150, 40);
        Font btnfont = new Font("Arial", Font.BOLD, 15);
        btnlogin.setFont(btnfont);
        btnlogin.setBackground(Color.BLACK);
        btnlogin.setForeground(Color.WHITE);
        btnlogin.addActionListener(this);
        c.add(btnlogin);

        btnCancel = new JButton("Cancel");
        btnCancel.setBounds(330, 380, 150, 40);
        btnCancel.setFont(btnfont);
        btnCancel.setBackground(Color.BLACK);
        btnCancel.setForeground(Color.WHITE);
        btnCancel.addActionListener(this);

        c.add(btnCancel);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/key.png"));
        Image i1 = icon.getImage().getScaledInstance(150, 200, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel image = new JLabel(i2);
        image.setBounds(700, 130, 200, 200);
        c.add(image);

        frame.setResizable(false);
    }

    public static void main(String[] args) {
        new login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnlogin) {
            String user = username.getText();
            String pass=password.getText();
            try{
             conn c=new conn();

             String query ="select * from login where username='"+user+"' and password ='"+ pass+"'";

            ResultSet rs = c.s.executeQuery(query);
            if(rs.next()){
                  frame.setVisible(false);
                  new Dashboard();
            }
            else {
                JOptionPane.showMessageDialog(null,"Invalid username or password");
            frame.setVisible(false);
            }
            }catch (Exception ae){
                ae.printStackTrace();
            }
        } else if (e.getSource() == btnCancel)
            {
                frame.setVisible(false);

        }
    }
}
