import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rules extends JFrame implements ActionListener {
    JButton b1,b2;
    JLabel l1,l2;
    String username;
    Rules(String username){
        this.username = username;
        setVisible(true);
        setLayout(null);
        getContentPane().setBackground(new Color(204,255,255));
        setBounds(200,70,600,500);

        l1 = new JLabel("Welcome  "+ username + "  to  Quiz  Adda");
        l1.setBounds(50,20,600,30);
        l1.setForeground(new Color(30,144,254));
        l1.setFont(new Font("Viner Hand ITC",Font.BOLD,30));
        add(l1);

        l2 = new JLabel("");
        l2.setFont(new Font("Tahoma",Font.PLAIN,16));
        l2.setBounds(20,50,600,350);
        l2.setText(
                "<html>" +
                        "1. Answering time is only 20 seconds." + "<br><br>" +
                        "2. You will have one lifeline which is 50-50."+ "<br><br>" +
                        "3. Each question carries 10 mark."+ "<br><br>" +
                        "4. No negative marking for wrong answers."+ "<br><br>" +
                        "5. There are a total 10 questions."+ "<br><br>" +
                        "6. Click on the Next Question button to go to the next question."+ "<br><br>" +
                        "7. The total score for the quiz is based on your responses to all questions."+ "<br><br>" +
                        "8. Each question in the quiz is of multiple-choice or \"true or false\" format."+ "<br><br>" +
                "<html>"
        );
        add(l2);

        b1 = new JButton("Back");
        b1.setBounds(190,390,100,30);
        b1.setBackground(new Color(30,144,254));
        b1.setForeground(Color.WHITE);
        add(b1);

        b2 = new JButton("Start");
        b2.setBounds(320,390,100,30);
        b2.setBackground(new Color(30,144,254));
        b2.setForeground(Color.WHITE);
        add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);
    }

    public static void main(String[] args) {
        new Rules("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1){
            this.setVisible(false);
            new QuizAdda().setVisible(true);
        }else if(e.getSource()==b2){
            new Quiz(username).setVisible(true);
            this.setVisible(false);
        }

    }
}
