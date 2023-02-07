package view;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import model.LengthGenerator;
import model.LowerCaseDecorator;
import model.NumberDecorator;
import model.PasswordGenerator;
import model.SymbolDecorator;
import model.UpperCaseDecorator;

public class GUI {
    private JFrame frame;
    private GridLayout layout = new GridLayout(0, 2);

    private void createAndShowGUI() {
        this.frame = new JFrame("Password Generator");
        Container pane = this.frame.getContentPane();
        JPanel panel = new JPanel();
        panel.setLayout(layout);

        panel.add(new JLabel("Password Length: "));
        var sLength = new JSpinner(new SpinnerNumberModel(16, 1, 100, 1));
        panel.add(sLength);
        panel.add(new JLabel("Include Symbols: "));
        var cbSymbol = new JCheckBox("( e.g. @#$% )");
        panel.add(cbSymbol);
        panel.add(new JLabel("Include Numbers: "));
        var cbNumber = new JCheckBox("( e.g. 123456 )");
        panel.add(cbNumber);
        panel.add(new JLabel("Include Uppercase Characters: "));
        var cbUppercase = new JCheckBox("( e.g. ABCDEFGH )");
        panel.add(cbUppercase);
        panel.add(new JLabel("Include Lowercase Characters: "));
        var cbLowercase = new JCheckBox("( e.g. abcdefgh )");
        panel.add(cbLowercase);
        var bStart = new JButton("Your New Password: ");
        panel.add(bStart);
        var out = new JTextField();
        panel.add(out);
        bStart.addActionListener(ev -> {
            var num = (Integer) sLength.getValue();
            PasswordGenerator pg = new LengthGenerator(num);
            if (cbSymbol.isSelected()) {
                pg = new SymbolDecorator(pg);
            } else if (cbNumber.isSelected()) {
                pg = new NumberDecorator(pg);
            } else if (cbUppercase.isSelected()) {
                pg = new UpperCaseDecorator(pg);
            } else if (cbLowercase.isSelected()) {
                pg = new LowerCaseDecorator(pg);
            }
            out.setText(pg.execute());
        });

        pane.add(panel);

        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.pack();
        this.frame.setVisible(true);
    }

    public static void main(String[] args) {
        var gui = new GUI();
        gui.createAndShowGUI();
    }
}