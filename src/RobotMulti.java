import java.lang.Runnable;

public class RobotMulti extends Robot implements Runnable {
    public RobotMulti(String type, Food toMake) {
        super(type, toMake);
    }
}