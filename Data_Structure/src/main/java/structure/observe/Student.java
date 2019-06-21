package structure.observe;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by WenChen on 2019/5/23.
 */
public class Student implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Student get msg"+o.getClass().getSimpleName()+":"+arg);
    }
}
