package MainClasses;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener{
    private States currentState;

    private StateManager[] gameStates;

    private final int WIDTH = 1000;
    private final int HEIGHT = 1000;
    private JFrame frame;

    public GamePanel(JFrame frame) {
        super();
        this.frame = frame;

        this.setLayout(null);
        this.setSize(this.WIDTH,this.HEIGHT);

        gameStates = new StateManager[(States.values().length)];
        currentState = States.HOMESTATE;
        loadState(currentState);
    }

    public void loadState(States state) {
        if(state == States.HOMESTATE){
            gameStates[state.getValue()] = new HomeState(this);
        }else if(state == States.CHOOSING_CHARACTER){
            gameStates[state.getValue()] = new ChooseCharacter(this.frame,this);
        }

        this.removeAll();
        this.add(gameStates[state.getValue()].GetContent());
        this.updateUI();
    }

    public void setState(States state) {
        currentState = state;
        loadState(currentState);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public int getWidth() {
        return WIDTH;
    }

    public int getHeight() {
        return HEIGHT;
    }

}
