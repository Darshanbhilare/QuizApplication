import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz extends JFrame implements ActionListener {
    JButton next,lifeline,submit;
    JLabel qno,question;
    public static  int timer=20;
    public static  int ans_given = 0;
    public static int score = 0;
    JRadioButton opt1,opt2,opt3,opt4;
    ButtonGroup options;
    public static int count =0;
    String q[][] = new String[10][5];
    String pa[][] = new String[10][1];
    String qa[][] = new String[10][2];
    String username;

    Quiz(String username){
        this.username = username;
        setBounds(250,30,900,700);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,300,Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0,0,900,300);
        add(l1);

        qno = new JLabel("");
        qno.setFont(new Font("Tahoma",Font.PLAIN,18));
        qno.setBounds(50,320,40,30);
        add(qno);

        question = new JLabel("");
        question.setFont(new Font("Tahoma",Font.PLAIN,18));
        question.setBounds(80,320,700,30);
        add(question);

        q[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        q[0][1] = "JVM";
        q[0][2] = "JDB";
        q[0][3] = "JDK";
        q[0][4] = "JRE";

        q[1][0] = "What is the return type of the hashCode() method in the Object class?";
        q[1][1] = "int";
        q[1][2] = "Object";
        q[1][3] = "long";
        q[1][4] = "void";

        q[2][0] = "Which package contains the Random class?";
        q[2][1] = "java.util package";
        q[2][2] = "java.lang package";
        q[2][3] = "java.awt package";
        q[2][4] = "java.io package";

        q[3][0] = "An interface with no fields or methods is known as?";
        q[3][1] = "Runnable Interface";
        q[3][2] = "Abstract Interface";
        q[3][3] = "Marker Interface";
        q[3][4] = "CharSequence Interface";

        q[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        q[4][1] = "Stack";
        q[4][2] = "String memory";
        q[4][3] = "Random storage space";
        q[4][4] = "Heap memory";

        q[5][0] = "Which of the following is a marker interface?";
        q[5][1] = "Runnable interface";
        q[5][2] = "Remote interface";
        q[5][3] = "Readable interface";
        q[5][4] = "Result interface";

        q[6][0] = "Which keyword is used for accessing the features of a package?";
        q[6][1] = "import";
        q[6][2] = "package";
        q[6][3] = "extends";
        q[6][4] = "export";

        q[7][0] = "In java, jar stands for?";
        q[7][1] = "Java Archive Runner";
        q[7][2] = "Java Archive";
        q[7][3] = "Java Application Resource";
        q[7][4] = "Java Application Runner";

        q[8][0] = "Which of the following is a mutable class in java?";
        q[8][1] = "java.lang.StringBuilder";
        q[8][2] = "java.lang.Short";
        q[8][3] = "java.lang.Byte";
        q[8][4] = "java.lang.String";

        q[9][0] = "Which of the following option leads to the portability and security of Java?";
        q[9][1] = "Bytecode is executed by JVM";
        q[9][2] = "The applet makes the Java code secure and portable";
        q[9][3] = "Use of exception handling";
        q[9][4] = "Dynamic binding between objects";

        qa[0][1] = "JDB";
        qa[1][1] = "int";
        qa[2][1] = "java.util package";
        qa[3][1] = "Marker Interface";
        qa[4][1] = "Heap memory";
        qa[5][1] = "Remote interface";
        qa[6][1] = "import";
        qa[7][1] = "Java Archive";
        qa[8][1] = "java.lang.StringBuilder";
        qa[9][1] = "Bytecode is executed by JVM";


         opt1 = new JRadioButton("");
        opt1.setBounds(90,360,400,30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog",Font.PLAIN,17));
        add(opt1);

         opt2 = new JRadioButton("");
        opt2.setBounds(90,400,400,30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog",Font.PLAIN,17));
        add(opt2);

         opt3 = new JRadioButton("");
        opt3.setBounds(90,440,400,30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog",Font.PLAIN,17));
        add(opt3);

         opt4 = new JRadioButton("");
        opt4.setBounds(90,480,400,30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog",Font.PLAIN,17));
        add(opt4);

        options = new ButtonGroup();
        options.add(opt1);
        options.add(opt2);
        options.add(opt3);
        options.add(opt4);

         next = new JButton("Next");
         next.setBounds(650,400,200,40);
         next.setFont(new Font("Tahoma",Font.PLAIN,18));
         next.setBackground(new Color(30,144,254));
         next.setForeground(Color.WHITE);
         add(next);

        lifeline = new JButton("50-50 LifeLine");
        lifeline.setBounds(650,470,200,40);
        lifeline.setFont(new Font("Tahoma",Font.PLAIN,18));
        lifeline.setBackground(new Color(30,144,254));
        lifeline.setForeground(Color.WHITE);
        add(lifeline);

        submit = new JButton("Submit");
        submit.setEnabled(false);
        submit.setBounds(650,540,200,40);
        submit.setFont(new Font("Tahoma",Font.PLAIN,18));
        submit.setBackground(new Color(30,144,254));
        submit.setForeground(Color.WHITE);
        add(submit);

        next.addActionListener(this);
        lifeline.addActionListener(this);
        submit.addActionListener(this);

        start(0);

    }
    public void start(int count){
        qno.setText(""+(count+1)+". ");
        question.setText(q[count][0]);
        opt1.setLabel(q[count][1]);
        opt1.setActionCommand(q[count][1]);
        opt2.setLabel(q[count][2]);
        opt2.setActionCommand(q[count][2]);
        opt3.setLabel(q[count][3]);
        opt3.setActionCommand(q[count][3]);
        opt4.setLabel(q[count][4]);
        opt4.setActionCommand(q[count][4]);
        options.clearSelection();
    }

    public static void main(String[] args) {
        new Quiz("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ( e.getSource() == next){
            repaint();
            ans_given = 1;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            if(options.getSelection() == null){
                pa[count][0] = "";
            }else {
                pa[count][0] = options.getSelection().getActionCommand();
            }
            if ( count == 8 ){
                submit.setEnabled(true);
                next.setEnabled(false);
            }

            count++;
            start(count);

        }else if(e.getSource() == lifeline){
            if ( count == 2 || count == 4 || count == 6 || count == 8 || count == 9){
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            }else{
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            lifeline.setEnabled(false);
        }
        else if ( e.getSource() == submit){
            if(options.getSelection() == null){
                pa[count][0] = "";
            }else {
                pa[count][0] = options.getSelection().getActionCommand();
            }

            for(int i=0 ; i< pa.length ; i++){
                if(pa[i][0].equals(qa[i][1])){
                    score += 10;
                }else{
                    score += 0;
                }
            }
            this.setVisible(false);
            new Score(username,score).setVisible(true);
        }

    }
    public void paint(Graphics g){
        super.paint(g);
        String time = "Time Left - "+timer+" sec";
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma",Font.BOLD,22));
        if(timer > 0){
            g.drawString(time,660,410);
        }
        else{
            g.drawString("Times Up!!",660,410);
        }
        timer--;
        try{
            Thread.sleep(1000);
            repaint();
        }
        catch( Exception e){
            e.printStackTrace();
        }
        if(ans_given == 1){
            ans_given = 0;
            timer =20;
        }
        else if( timer < 0){
            timer = 20;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            if ( count == 8 ){
                submit.setEnabled(true);
                next.setEnabled(false);
            }
            if( count == 9){
                if(options.getSelection() == null){
                    pa[count][0] = "";
                }else {
                    pa[count][0] = options.getSelection().getActionCommand();
                }

                for(int i=0 ; i< pa.length ; i++){
                    if(pa[i][0].equals(qa[i][1])){
                        score += 10;
                    }else{
                        score += 0;
                    }
                }
                this.setVisible(false);
                new Score(username , score).setVisible(true);
            }
            else{
                if(options.getSelection() == null){
                    pa[count][0] = "";
                }else {
                    pa[count][0] = options.getSelection().getActionCommand();
                }
                count++;
                start(count);
            }

        }
    }

}
