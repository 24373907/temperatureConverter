import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class tempConverter implements ActionListener{
    JTextField input;
    JLabel output, conversion;
    JButton convert, switchInput;
    Boolean celciusToFarenheit = true;

    public tempConverter() {

        JFrame frame = new JFrame("Temp Converter");

        input = new JTextField("Input temp here");
        input.setBounds(50, 100, 150, 20);

        output = new JLabel();
        output.setBounds(50, 150, 150, 20);

        conversion = new JLabel();
        conversion.setText("Celcius to Farenheit");
        conversion.setBounds(50, 50, 150,20);


        convert = new JButton("Convert");
        convert.setBounds(50, 200, 200, 50);
        convert.addActionListener(this);

        switchInput = new JButton("Switch");
        switchInput.setBounds(50, 251, 200, 50);
        switchInput.addActionListener(this);

        frame.add(input);
        frame.add(conversion);
        frame.add(output);
        frame.add(convert);
        frame.add(switchInput);
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        new tempConverter();
    }

    public void actionPerformed(ActionEvent event) {

        double ans;
        String scale;

        if (event.getSource() == convert) {

            String strinput = input.getText();

            try {

                double input = Double.parseDouble(strinput);

                if (celciusToFarenheit) {

                    scale = "Farenheit";
                    ans = 32 + (input * ((double) 9/5));
                } else {

                    scale = "Celcius";
                    ans = (input - 32) * ((double) 5/9);
                }

                ans = Math.round(ans*100.0) /100.0;


                output.setText(ans + "° " + scale);

            }  catch (NumberFormatException e) {

                output.setText("Not a valid number");
            }
        } else {

            if (celciusToFarenheit) {
                celciusToFarenheit = false;
                conversion.setText("Farenheit to Celcius");
            } else {
                celciusToFarenheit = true;
                conversion.setText("Celcius to Farenheit");
            }

        }
    }
}
