package MainClasses;
import javax.swing.JPanel;

public abstract class StateManager {
    protected GamePanel gsm;
    public StateManager(GamePanel gsm){
        this.gsm = gsm;
    }

    public abstract JPanel GetContent();
}
