package structure.listener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by WenChen on 2019/5/24.
 */
public class Source {
    private List<StatusListener> list = new ArrayList<>();

    public Source addListenner (StatusListener listener){
        list.add(listener);
        return this;
    }

    public void onClick (){
        ChangeEvent event = new ChangeEvent(this);
        event.setStatus("click");
        notifyListener(event);
    }

    public void onMove (){
        ChangeEvent event = new ChangeEvent(this);
        event.setStatus("move");
        notifyListener(event);
    }

    private void notifyListener (ChangeEvent event){
        Iterator<StatusListener> it = list.iterator();
        while (it.hasNext()){
            StatusListener listener = it.next();
            listener.changeStatus(event);
        }
    }

    public static void main (String[] args){
        Source source = new Source();
        source.addListenner((o)->{
            System.out.println(o.getStatus());
        }).addListenner((o)->{
            System.out.println(o+"111");
        });
        source.onClick();
        source.onMove();
    }
}
