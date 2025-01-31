import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numberbuttons= new JButton[10];
    JButton[] functionButons= new JButton[9];
    JButton addButton,subButton,mulButton,divButton;
    JButton decButton,equButton,delButton,clrButton,negButton;
    JPanel panel;

    Font myFont = new Font("Courier",Font.BOLD,30);
    double num1=0,num2=0,result=0;
    char operator;

    Calculator(){

        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50,25,300,50);
        textField.setFont(myFont);
        textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");
        negButton = new JButton("-");
        functionButons[0]=addButton;
        functionButons[1]=subButton;
        functionButons[2]=mulButton;
        functionButons[3]=divButton;
        functionButons[4]=decButton;
        functionButons[5]=equButton;
        functionButons[6]=delButton;
        functionButons[7]=clrButton;
        functionButons[8]=negButton;

        for (int i=0;i<9;i++){
            functionButons[i].addActionListener(this);
            functionButons[i].setFont(myFont);
            functionButons[i].setFocusable(false);
        }

        for (int i=0;i<10;i++){
            numberbuttons[i]=new JButton(String.valueOf(i));
            numberbuttons[i].addActionListener(this);
            numberbuttons[i].setFont(myFont);
            numberbuttons[i].setFocusable(false);
        }

        delButton.setBounds(130,430,130,50);
        clrButton.setBounds(270,430,110,50);
        negButton.setBounds(20,430,100,50);

        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));

        panel.add(numberbuttons[1]);
        panel.add(numberbuttons[2]);
        panel.add(numberbuttons[3]);
        panel.add(addButton);
        panel.add(numberbuttons[4]);
        panel.add(numberbuttons[5]);
        panel.add(numberbuttons[6]);
        panel.add(subButton);
        panel.add(numberbuttons[7]);
        panel.add(numberbuttons[8]);
        panel.add(numberbuttons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberbuttons[0]);
        panel.add(equButton);
        panel.add(divButton);


        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);
    }
    public static void main (String[] args){

        Calculator cal = new Calculator();
    }
    public void actionPerformed(ActionEvent e){

        for (int i=0;i<10;i++){
            if (e.getSource()==numberbuttons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
            if (e.getSource()==decButton){
                textField.setText(textField.getText().concat("."));
            }
            if (e.getSource()==addButton){
                num1=Double.parseDouble(textField.getText());
                operator='+';
                textField.setText("");
            }
            if (e.getSource()==subButton){
                num1=Double.parseDouble(textField.getText());
                operator='-';
                textField.setText("");
            }
            if (e.getSource()==mulButton){
                num1=Double.parseDouble(textField.getText());
                operator='*';
                textField.setText("");
            }
            if (e.getSource()==negButton){
                double temp= Double.parseDouble(textField.getText());
                temp=temp*-1;
                textField.setText(String.valueOf(temp));
            }
            if (e.getSource()==divButton){
                num1=Double.parseDouble(textField.getText());
                operator='/';
                textField.setText("");
            }
            if (e.getSource()==equButton) {
                num2 = Double.parseDouble(textField.getText());

                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        result = num1 / num2;
                        break;
                }
                textField.setText(String.valueOf(result));
                num1 = result;
            }
            if (e.getSource()==clrButton){
                textField.setText("");
            }
            if (e.getSource()==delButton){
                String s = textField.getText();
                textField.setText("");
                for (int i=0;i< s.length();i++){
                    textField.setText(textField.getText().concat(String.valueOf(s.charAt(i))));
                }
            }

    }


}
