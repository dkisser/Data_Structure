package structure.listener;

import java.util.EventListener;

/**
 * Created by WenChen on 2019/5/24.
 */
public interface StatusListener extends EventListener {
    void changeStatus(ChangeEvent event);
}
