package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;

public class Customerform extends JFrame  implements ActionListener{

        JFrame frame;
        JTextField tfname,tfnumber ,tfcountry,tfdeposit;
        JLabel checktime;
        JComboBox cbid  ;

        Choice cbroomnumber;
        JRadioButton rbMale,rbFemale;

        JButton add,Cancel ;
        Customerform(){
            frame=new JFrame();
            frame.setBounds(300,160,950,650);
            frame.setVisible(true);
            Container c= frame.getContentPane();
            c.setBackground(Color.WHITE);
            c.setLayout(null);

            JLabel lbltitle = new JLabel("New Customer Form");
            lbltitle.setBounds(260,0,500,60);
            lbltitle.setFont(new Font("Broadway",Font.PLAIN,30));
            c.add(lbltitle);

            JLabel lblid = new JLabel("Id");
            lblid .setBounds(70,100,150,30);
            lblid .setFont(new Font("Arial",Font.PLAIN,17));
            c.add(lblid );
            String str1[]={"Select Option","Aadhar Card","Passport","Driving Licence","Voter-id Card","Ration Card"};
            cbid = new JComboBox(str1);
            cbid .setBounds(250,100,180,30);
            cbid .setBackground(Color.WHITE);
            c.add( cbid );

            JLabel lblnumber = new JLabel("Id Number");
            lblnumber.setBounds(70,150,100,30);
            lblnumber.setFont(new Font("Arial",Font.PLAIN,17));
            c.add(lblnumber);
            tfnumber = new JTextField();
            tfnumber.setBounds(250,150,180,30);
            c.add(tfnumber);

            JLabel lblname = new JLabel("Name");
            lblname.setBounds(70,200,120,30);
            lblname.setFont(new Font("Arial",Font.PLAIN,17));
            c.add(lblname);
            tfname = new JTextField();
            tfname.setBounds(250,200,180,30);
            c.add(tfname);




            JLabel lblgender = new JLabel("Gender");
            lblgender.setBounds(70,250,150,30);
            lblgender.setFont(new Font("Arial",Font.PLAIN,17));
            c.add(lblgender);
            rbMale= new JRadioButton("Male");
            rbMale .setBounds(250,250,70,30);
            rbMale .setBackground(Color.WHITE);
            c.add( rbMale);

            rbFemale= new JRadioButton("Female");
            rbFemale .setBounds(340,250,180,30);
            rbFemale.setBackground(Color.WHITE);
            c.add( rbFemale);

            ButtonGroup group =new ButtonGroup();
            group.add(rbMale);
            group.add(rbFemale);

            JLabel lblcuntry = new JLabel("Country");
            lblcuntry .setBounds(70,300,160,30);
            lblcuntry .setFont(new Font("Arial",Font.PLAIN,17));
            c.add( lblcuntry );
            tfcountry = new JTextField();
            tfcountry.setBounds(250,300,180,30);
            c.add( tfcountry );

            JLabel lblroomnumber = new JLabel("Room Number");
            lblroomnumber.setBounds(70,350,180,30);
            lblroomnumber.setFont(new Font("Arial",Font.PLAIN,17));
            c.add(lblroomnumber);
            cbroomnumber = new Choice();

            try {
                 conn cn =new conn();
                 String query="select * from room where availability='Available'";
                ResultSet s= cn.s.executeQuery(query);
                while(s.next()){
                    cbroomnumber.add(s.getString("roomnumber"));
                }
            }catch (Exception ee){
                ee.printStackTrace();
            }
            cbroomnumber.setBounds(250,350,180,30);
            cbroomnumber.setBackground(Color.WHITE);
            c.add(cbroomnumber);

            JLabel lbltime = new JLabel("Checkin Time");
            lbltime.setBounds(70,400,180,30);
            lbltime.setFont(new Font("Arial",Font.PLAIN,17));
            c.add(lbltime);

            Date date =new Date();

            checktime = new JLabel(""+ date);
            checktime.setBounds(250,400,180,30);
            checktime.setFont(new Font("Arial",Font.PLAIN,17));
            c.add( checktime);



            JLabel lbldeposit = new JLabel("Deposit");
            lbldeposit .setBounds(70,450,100,30);
            lbldeposit.setFont(new Font("Arial",Font.PLAIN,17));
            c.add(lbldeposit );
            tfdeposit = new JTextField();
            tfdeposit.setBounds(250,450,180,30);
            c.add( tfdeposit);

            add =new JButton("Add Customer");
            add.setBackground(Color.BLACK);
            add.setForeground(Color.WHITE);
            add.setBounds(70,520,160,35);
            add.addActionListener(this);
            c.add(add);

            Cancel =new JButton("Back");
            Cancel .setBackground(Color.BLACK);
            Cancel .setForeground(Color.WHITE);
            Cancel .setBounds(260,520,160,35);
            Cancel.addActionListener(this);
            c.add(Cancel );

            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
            Image i2 = i1.getImage().getScaledInstance(430,400,Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image =new JLabel(i3);
            image.setBounds(490,70,430,500);
            c.add(image);

            frame.setResizable(false);
        }




    public static  void main(String[] args){
        new Customerform();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == add) {
            String id = (String) cbid.getSelectedItem();
            String name = tfname.getText();
            String number = tfnumber.getText();
            String country = tfcountry.getText();
            String deposit = tfdeposit.getText();
            String gender = null;

            if (rbFemale.isSelected()) {
                gender = "Female";
            } else if (rbMale.isSelected()) {
                gender = "Male";
            }
            String room = (String) cbroomnumber.getSelectedItem();
            String  time =checktime.getText();
            try{
                conn c =new conn();
                String query ="insert into customer values('"+id+"','"+name+"','"+number+"','"+gender+"', '"+country+"','"+room+"','"+time+"', '"+deposit+"')";
                String query1 ="update room set availability='Occupied' where roomnumber='"+room+"'";
                c.s.executeUpdate(query);
                c.s.executeUpdate(query1);

                JOptionPane.showMessageDialog(null,"Customer added sucessfully");
                frame.setVisible(false);
                new reception();
            }catch (Exception ae){
                ae.printStackTrace();
            }

        } else if (e.getSource()==Cancel) {
            frame.setVisible(false);
            new reception();
        }
    }
}
