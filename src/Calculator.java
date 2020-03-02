import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Calculator extends JPanel  {

    private JButton print;
    private JButton calculate;
    private static JButton add;
    private JLabel diameter;
    private JLabel hWC;
    private JTextField diameterLabel;
    private JLabel rOF;
    private JLabel fL;
    private JTextField hWCLabel;
    private JTextField rOFLabel;
    private JTextField fLLabel;
    private JTextArea answer;
    private JTextField lengthOfPipe;
    private JLabel lOP;
    private JTextArea finalAnswer;
    private int counter;
    private JLabel file;
    private JTextField fileName;
    public Calculator() {
        //construct components
        print = new JButton ("Print");
        calculate = new JButton ("Calculate");
        add = new JButton ("Add");
        diameter = new JLabel ("Diameter");
        hWC = new JLabel ("Hazen-Williams");
        diameterLabel = new JTextField (5);
        rOF = new JLabel ("Rate of Flow");
        hWCLabel = new JTextField (5);
        rOFLabel = new JTextField (5);
        answer = new JTextArea (5, 5);
        lengthOfPipe = new JTextField(5);
        lOP = new JLabel("Pipe Length");
        finalAnswer = new JTextArea();
        file = new JLabel("File Name");
        fileName = new JTextField();
        counter = 0;

        //adjust size and set layout
        setPreferredSize (new Dimension (700, 400));
        setLayout (null);

        //add components
        add (print);
        add (calculate);
        add (add);
        add (diameter);
        add (hWC);
        add (diameterLabel);
        add (rOF);
        add (hWCLabel);
        add (rOFLabel);
        add (answer);
        add (lengthOfPipe);
        add(lOP);
        add(finalAnswer);
        add(fileName);
        add(file);

        //set component bounds (only needed by Absolute Positioning)
        print.setBounds (550, 20, 100, 30);
        calculate.setBounds (550, 200, 100, 30);
        add.setBounds (550, 350, 100, 30);
        diameter.setBounds (20, 150, 100, 25);
        hWC.setBounds (20, 200, 100, 25);
        diameterLabel.setBounds (115, 150, 100, 25);
        rOF.setBounds (20, 250, 100, 25);
        hWCLabel.setBounds (115, 200, 100, 25);
        rOFLabel.setBounds (115, 250, 100, 25);
        answer.setBounds (280, 200, 200, 35);
        lOP.setBounds (20, 300, 100, 25);
        lengthOfPipe.setBounds(115,300,100,25);
        finalAnswer.setBounds (280, 300, 200, 35);
        fileName.setBounds (280, 100, 200, 35);
        file.setBounds (200, 100, 100, 25);

        String[] firstAnswers = new String[100];
        String [] secondAnswers = new String[100];

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstAnswers[counter] = answer.getText();
                secondAnswers[counter] = finalAnswer.getText();
                counter++;


            }

        });
        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                EasyWriter writer = new EasyWriter(fileName.getText());
                for(int i=0;i<firstAnswers.length;i++)
                {
                    if(firstAnswers[i]==null&&secondAnswers[i]==null)
                    {
                        i=100;
                    }
                    else {
                        writer.println(firstAnswers[i]);
                        writer.println(secondAnswers[i]);
                    }
                }
                writer.close();
            }
        });
        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double a = 1.85;
                double b = 4.87;
                double pressure = ((4.25*Math.pow(Double.parseDouble(rOFLabel.getText()),a))/(Math.pow(Double.parseDouble(hWCLabel.getText()),a)*Math.pow(Double.parseDouble(diameterLabel.getText()),b)));
                answer.setText(String.valueOf(pressure)+" psi/ft");
                double finalAnswers = (pressure * Double.parseDouble(lengthOfPipe.getText() ));
                finalAnswer.setText(String.valueOf(finalAnswers + " psi"));
            }
        });
        
    }


    public static void main (String[] args) {

        JFrame frame = new JFrame ("Hydraulic Pressure Calculator");
        BorderFactory.createLineBorder(Color.BLUE);
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new Calculator());
        frame.pack();
        frame.setVisible (true);

    }
}
