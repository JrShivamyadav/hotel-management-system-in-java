package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployee extends JFrame implements  ActionListener {
     JFrame frame;
    JTextField tfname,tfemail,tfphone,tfage,tfsalary,tfadhar;
    JRadioButton rbmale,rbfemale;
    JButton submit;
    JComboBox cbjob;
    AddEmployee(){
        frame =new JFrame();
        frame.setBounds(280,160,970,640);
        frame.setVisible(true);
        Container c= frame.getContentPane();
        c.setBackground(Color.WHITE);
        c.setLayout(null);

        JLabel lbltitle= new JLabel("Add Employee");
        lbltitle.setBounds(300,20,400,60);
        lbltitle.setFont(new Font("Broadway",Font.PLAIN,40));
        c.add(lbltitle);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(70,140,70,30);
        lblname.setFont(new Font("Arial",Font.PLAIN,20));
        c.add(lblname);
        tfname = new JTextField();
        tfname.setBounds(180,140,180,30);
        c.add(tfname);

        JLabel lblage = new JLabel("Age");
        lblage.setBounds(70,180,100,30);
        lblage.setFont(new Font("Arial",Font.PLAIN,20));
        c.add(lblage);
        tfage = new JTextField();
        tfage.setBounds(180,180,180,30);
        c.add(tfage);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(70,230,100,30);
        lblgender.setFont(new Font("Arial",Font.PLAIN,20));
        c.add(lblgender);
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(180,230,70,30);
        rbmale.setFont(new Font("Arial",Font.PLAIN,15));
        rbmale.setBackground(Color.WHITE);
        c.add(rbmale);
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(250,230,100,30);
        rbfemale.setFont(new Font("Arial",Font.PLAIN,15));
        rbfemale.setBackground(Color.WHITE);
        c.add(rbfemale);

        ButtonGroup bg =new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);

        JLabel lbljob = new JLabel("Job");
        lbljob.setBounds(70,280,100,30);
        lbljob.setFont(new Font("Arial",Font.PLAIN,20));
        c.add(lbljob);
        String str[]={"Select Option","Front DEsk Clerks","Porters","Housekeeping","Kitchen Staff","Room Services","chefs","Waiter/Waiteress","Manager","Accountant"};
        cbjob = new JComboBox(str);
        cbjob.setBounds(180,280,180,30);
        cbjob.setBackground(Color.WHITE);
        c.add(cbjob);

        JLabel lblsalary = new JLabel("Salary");
        lblsalary.setBounds(70,330,100,30);
        lblsalary.setFont(new Font("Arial",Font.PLAIN,20));
        c.add(lblsalary);
        tfsalary = new JTextField();
        tfsalary.setBounds(180,330,180,30);
        c.add(tfsalary);

        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(70,380,100,30);
        lblemail.setFont(new Font("Arial",Font.PLAIN,20));
        c.add(lblemail);
        tfemail = new JTextField();
        tfemail.setBounds(180,380,180,30);
        c.add(tfemail);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(70,430,100,30);
        lblphone.setFont(new Font("Arial",Font.PLAIN,20));
        c.add(lblphone);
        tfphone = new JTextField();
        tfphone.setBounds(180,430,180,30);
        c.add(tfphone);


        JLabel lbladhar = new JLabel("Adhar");
        lbladhar.setBounds(70,480,100,30);
        lbladhar.setFont(new Font("Arial",Font.PLAIN,20));
        c.add(lbladhar);
        tfadhar = new JTextField();
        tfadhar.setBounds(180,480,180,30);
        c.add(tfadhar);

        submit =new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
         submit.addActionListener(this);
        submit.setBounds(100,540,200,30);
        c.add(submit);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(520,520,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(450,120,460,440);
        c.add(image);
        frame.setResizable(false);

    }

    public static void main(String [] args){
        new AddEmployee();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
  if(e.getSource()==submit) {
      String name = tfname.getText();
      String age = tfage.getText();
      String salary = tfsalary.getText();
      String phone = tfphone.getText();
      String email = tfemail.getText();
      String adhar = tfadhar.getText();

      String gender = null;

      if (rbfemale.isSelected()) {
          gender = "Female";
      } else if (rbmale.isSelected()) {
          gender = "Male";
      }
      String job = (String) cbjob.getSelectedItem();

      try {
          conn c = new conn();
          String query = "insert into employee values('" + name + "', '" + age + "', '" + gender + "', '" + job + "','" + salary + "', '" + email + "', '" + phone + "', '" + adhar + "')";
          c.s.executeUpdate(query);
          JOptionPane.showMessageDialog(null, "Employee added sucessfully");
          setVisible(false);
      } catch (Exception ae) {
          ae.printStackTrace();

      }
      frame.setVisible(false);
  }

    }
}

