package structure.observe;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by WenChen on 2019/5/23.
 */
public class Weather extends Observable{

    private Observable instance;


    public Observable addObserver1(Observer o) {
        super.addObserver(o);
        return this;
    }

    public static void main (String[] args){
        Weather weather = new Weather();
        weather.addObserver1(new Student())
                .addObserver(new Worker());
        weather.setChanged();
        weather.notifyObservers("sdfjdsj");
    }


}
