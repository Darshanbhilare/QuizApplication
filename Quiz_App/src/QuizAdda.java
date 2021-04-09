import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizAdda extends JFrame implements ActionListener {
    JButton b1,b2;
    JTextField t1;
    JLabel l1,l2,l3;
    QuizAdda(){
        setVisible(true);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE); // used to change background color of frame
        setBounds(200,100,1000,500); // helps to place frame on screen
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpeg"));
        l1 = new JLabel(i1);
        l1.setBounds(0,0,500,500);
        add(l1);

        l2 = new JLabel("Quiz Adda");
        l2.setBounds(650,40,300,45);
        l2.setFont(new Font("Viner Hand ITC",Font.BOLD,40));
        l2.setForeground(new Color(30,144,254));
        add(l2);

        l3 = new JLabel("Enter Your Name");
        l3.setBounds(690,145,300,20);
        l3.setFont(new Font("Mongolian Baiti",Font.BOLD,18));
        l3.setForeground(new Color(30,144,254));
        add(l3);

        t1 = new JTextField();
        t1.setBounds(610,190,300,25);
        t1.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(t1);

        b1= new JButton("Rules");
        b1.setBounds(610,260,120,25);
        b1.setBackground(new Color(30,144,254));
        b1.setForeground(Color.WHITE);
        add(b1);

        b2= new JButton("Exit");
        b2.setBounds(790,260,120,25);
        b2.setBackground(new Color(30,144,254));
        b2.setForeground(Color.WHITE);
        add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b1){

            String name = t1.getText();
            this.setVisible(false);
            new Rules(name);

        }else{
            System.exit(0);
        }

    }
    public static void main(String[] args) {
        new QuizAdda();
    }
}
