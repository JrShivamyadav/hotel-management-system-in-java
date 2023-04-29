package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRoom extends JFrame  implements ActionListener {

    JFrame frame;
 JTextField tfname,tfprice ;
 JComboBox  cbavailble,cbstatus,cbbed ;

 JButton add,Cancel ;
    AddRoom(){
        frame=new JFrame();
        frame.setBounds(300,160,950,620);
        frame.setVisible(true);
        Container c= frame.getContentPane();
        c.setBackground(Color.WHITE);
        c.setLayout(null);

        JLabel lbltitle = new JLabel("Add Rooms");
        lbltitle.setBounds(340,20,400,60);
        lbltitle.setFont(new Font("Broadway",Font.PLAIN,40));
        c.add(lbltitle);

        JLabel lblname = new JLabel("Room Number");
        lblname.setBounds(70,140,120,30);
        lblname.setFont(new Font("Arial",Font.PLAIN,17));
        c.add(lblname);
        tfname = new JTextField();
        tfname.setBounds(250,140,180,30);
        c.add(tfname);

        JLabel lblavilable = new JLabel("Availble");
        lblavilable.setBounds(70,200,100,30);
        lblavilable.setFont(new Font("Arial",Font.PLAIN,17));
        c.add(lblavilable);
        String str[]={"Select Option","Available","Occupied"};
        cbavailble = new JComboBox(str);
        cbavailble.setBounds(250,200,180,30);
        cbavailble.setBackground(Color.WHITE);
        c.add( cbavailble);

        JLabel lblclean = new JLabel("Cleaning Status");
        lblclean.setBounds(70,260,150,30);
        lblclean.setFont(new Font("Arial",Font.PLAIN,17));
        c.add(lblclean);
        String str1[]={"Select Option","Cleaned","Dirty"};
        cbstatus = new JComboBox(str1);
        cbstatus.setBounds(250,260,180,30);
        cbstatus.setBackground(Color.WHITE);
        c.add( cbstatus);

        JLabel lblprice = new JLabel("Price");
        lblprice.setBounds(70,320,100,30);
        lblprice.setFont(new Font("Arial",Font.PLAIN,17));
        c.add(lblprice);
        tfprice = new JTextField();
        tfprice .setBounds(250,320,180,30);
        c.add( tfprice );

        JLabel lblbed = new JLabel("Bed Type");
        lblbed.setBounds(70,380,100,30);
        lblbed.setFont(new Font("Arial",Font.PLAIN,17));
        c.add(lblbed);
        String str2[]={"Select Option","Single Bed","Double Bed"};
        cbbed = new JComboBox(str2);
        cbbed.setBounds(250,380,180,30);
        cbbed.setBackground(Color.WHITE);
        c.add( cbbed);

        add =new JButton("Add Room");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(100,480,120,35);
        add.addActionListener(this);
        c.add(add);

        Cancel =new JButton("Cancel");
        Cancel .setBackground(Color.BLACK);
        Cancel .setForeground(Color.WHITE);
        Cancel .setBounds(280,480,120,35);
        Cancel.addActionListener(this);
        c.add(Cancel );

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        Image i2 = i1.getImage().getScaledInstance(430,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(490,60,430,440);
        c.add(image);

    frame.setResizable(false);
    }




    public  static void main(String[] args){
        new AddRoom();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==add){
           String roomnumber= tfname.getText();
           String availability =(String) cbavailble.getSelectedItem();
           String status = (String) cbstatus.getSelectedItem();
           String price = tfprice.getText();
           String type = (String) cbbed.getSelectedItem();

            try {
                conn c = new conn();
                String query ="insert into room values('"+roomnumber+"', '"+availability+"','"+status+"','"+price+"','"+type+"')";
                c.s.executeUpdate(query);

 JOptionPane.showMessageDialog(null,"New Room Added Sucessfully");
           frame.setVisible(false);
            }
            catch (Exception e){
                e.printStackTrace();
            }

        }else if(ae.getSource()==Cancel){
            frame.setVisible(false);
        }

        }
    }

