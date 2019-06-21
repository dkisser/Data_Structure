package structure.observe;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by WenChen on 2019/5/23.
 */
public class Worker implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Worker get msg"+o.getClass().getSimpleName()+":"+arg);
    }
}
