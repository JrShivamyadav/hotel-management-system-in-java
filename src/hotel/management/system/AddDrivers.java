package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDrivers extends JFrame  implements ActionListener {

    JFrame frame;
    JTextField tfname,tfage ,tfcompany,tfmodel,tflocation;
    JComboBox  cbgender,cbavailble ;

    JButton add,Cancel ;
    AddDrivers(){
        frame=new JFrame();
        frame.setBounds(300,160,950,650);
        frame.setVisible(true);
        Container c= frame.getContentPane();
        c.setBackground(Color.WHITE);
        c.setLayout(null);

        JLabel lbltitle = new JLabel("Add Drivers");
        lbltitle.setBounds(340,20,400,60);
        lbltitle.setFont(new Font("Broadway",Font.PLAIN,40));
        c.add(lbltitle);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(70,140,120,30);
        lblname.setFont(new Font("Arial",Font.PLAIN,17));
        c.add(lblname);
        tfname = new JTextField();
        tfname.setBounds(250,140,180,30);
        c.add(tfname);

        JLabel lblaage = new JLabel("Age");
        lblaage.setBounds(70,200,100,30);
        lblaage.setFont(new Font("Arial",Font.PLAIN,17));
        c.add(lblaage);
        tfage = new JTextField();
        tfage.setBounds(250,200,180,30);
        c.add(tfage);


        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(70,260,150,30);
        lblgender.setFont(new Font("Arial",Font.PLAIN,17));
        c.add(lblgender);
        String str1[]={"Select Option","Male","Female"};
        cbgender = new JComboBox(str1);
        cbgender.setBounds(250,260,180,30);
        cbgender.setBackground(Color.WHITE);
        c.add( cbgender);

        JLabel lblcompany = new JLabel("Car Company");
        lblcompany.setBounds(70,320,160,30);
        lblcompany.setFont(new Font("Arial",Font.PLAIN,17));
        c.add(lblcompany);
        tfcompany = new JTextField();
        tfcompany.setBounds(250,320,180,30);
        c.add( tfcompany );

        JLabel lblModel = new JLabel("Car Model");
        lblModel.setBounds(70,380,100,30);
        lblModel.setFont(new Font("Arial",Font.PLAIN,17));
        c.add(lblModel);
        tfmodel = new JTextField();
        tfmodel.setBounds(250,380,180,30);
        c.add( tfmodel);

        JLabel lblavilable = new JLabel("Availble");
        lblavilable.setBounds(70,440,100,30);
        lblavilable.setFont(new Font("Arial",Font.PLAIN,17));
        c.add(lblavilable);
        String str[]={"Select Option","Aailable","Busy","In 5 Min","In 10 Min" ,"In 15 Min","In 20 Min","In 30 Min"};
        cbavailble = new JComboBox(str);
        cbavailble.setBounds(250,440,180,30);
        cbavailble.setBackground(Color.WHITE);
        c.add( cbavailble);

        JLabel lbllocation = new JLabel("Location");
        lbllocation .setBounds(70,500,100,30);
        lbllocation .setFont(new Font("Arial",Font.PLAIN,17));
        c.add(lbllocation );
        tflocation = new JTextField();
        tflocation.setBounds(250,500,180,30);
        c.add( tflocation);

        add =new JButton("Add Driver");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(100,560,120,35);
        add.addActionListener(this);
        c.add(add);

        Cancel =new JButton("Cancel");
        Cancel .setBackground(Color.BLACK);
        Cancel .setForeground(Color.WHITE);
        Cancel .setBounds(280,560,120,35);
        Cancel.addActionListener(this);
        c.add(Cancel );

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(430,400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(490,90,430,500);
        c.add(image);

        frame.setResizable(false);
    }




    public  static void main(String[] args){
        new AddDrivers();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==add){
            String  name= tfname.getText();
            String age = tfage.getText();
            String gender = (String) cbgender.getSelectedItem();
            String carcompany = tfcompany.getText();
            String carmodel = tfmodel.getText();
            String availability= (String) cbavailble.getSelectedItem();
            String location = tflocation.getText();
            try {
                conn c = new conn();
                String query ="insert into driver values('"+name+"', '"+age+"','"+gender+"','"+carcompany+"','"+carmodel+"','"+availability+"','"+location+"')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null," Driver Added Sucessfully");
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

