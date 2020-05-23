package MainClasses;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomeState extends StateManager implements ActionListener{
    private GamePanel gsm;
    private JPanel homeScreen;
    private JButton continueBtn;
    public HomeState(GamePanel gsm) {
        super(gsm);
        this.gsm = gsm;
    }

    @Override
    public JPanel GetContent() {
        this.homeScreen = new JPanel();
        this.homeScreen.setSize(this.gsm.getWidth(),this.gsm.getHeight());
        this.homeScreen.setBackground(Color.yellow);

        JLabel text = new JLabel();
        text.setText("Welcome To Adventures Game");
        text.setFont(new Font("Courier", Font.BOLD, 40));
        this.homeScreen.add(text);

        this.continueBtn = new JButton("Continue");
        this.continueBtn.addActionListener(this);
        this.homeScreen.add(this.continueBtn);
        return this.homeScreen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.gsm.setState(States.CHOOSING_CHARACTER);
    }

}
