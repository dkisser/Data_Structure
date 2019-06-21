package structure.listener;

import java.util.EventObject;

/**
 * Created by WenChen on 2019/5/24.
 */
public class ChangeEvent extends EventObject{
    private String status;

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ChangeEvent(Object source) {
        super(source);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
