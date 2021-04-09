import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Score extends JFrame  implements ActionListener {
    JButton b1,b2;
    Score(String username , int score){
        setVisible(true);
        setLayout(null);
        setBounds(250,30,750,550);
        getContentPane().setBackground(Color.WHITE);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));
        Image i2 = i1.getImage().getScaledInstance(300,250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0,200,300,250);
        add(l1);

        JLabel l2 = new JLabel("Thank You "+username+" For Playing Quiz Adda");
        l2.setBounds(80,40,700,40);
        l2.setForeground(new Color(127,0,255));
        l2.setFont(new Font("Raleway",Font.PLAIN,30));
        add(l2);

        JLabel l3 = new JLabel("Your Score is "+score);
        l3.setBounds(380,200,300,30);
        l3.setFont(new Font("Jokerman",Font.PLAIN,26));
        l3.setForeground(new Color(199,21,133));
        add(l3);

        b1= new JButton("Play Again");
        b1.setBackground(new Color(30,144,254));
        b1.setForeground(Color.WHITE);
        b1.setBounds(360,270,120,30);
        b1.addActionListener(this);
        add(b1);

        b2= new JButton("Exit");
        b2.setBackground(new Color(30,144,254));
        b2.setForeground(Color.WHITE);
        b2.setBounds(500,270,120,30);
        b2.addActionListener(this);
        add(b2);
    }

    public static void main(String[] args) {
        new Score("",0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ( e.getSource() == b1){
        this.setVisible(false);
        new QuizAdda().setVisible(true);
        }else System.exit(0);
    }
}
