package structure.factoryPattern.factoryMethod;

import structure.factoryPattern.factoryMethod.abstractFactory.abstractFactory;
import structure.factoryPattern.factoryMethod.abstractProduct.abstractProduct;
import structure.factoryPattern.factoryMethod.factory.AppleFactory;
import structure.factoryPattern.factoryMethod.factory.PearFactory;
import structure.factoryPattern.factoryMethod.factory.WatermalonFactory;

/**
 * Created by WenChen on 2018/3/30.
 */
public class Client {
    public static void main (String[] args){
        abstractFactory f1,f2,f3;
        abstractProduct o1,o2,o3;
        f1 = new AppleFactory();
        f2 = new PearFactory();
        f3 = new WatermalonFactory();
        o1 = f1.factory();
        o2 = f2.factory();
        o3 = f3.factory();
    }
}
