package structure.factoryPattern.factoryMethod.factory;

import structure.factoryPattern.factoryMethod.abstractFactory.abstractFactory;
import structure.factoryPattern.factoryMethod.abstractProduct.abstractProduct;
import structure.factoryPattern.factoryMethod.product.Pear;

/**
 * Created by WenChen on 2018/3/30.
 */
public class PearFactory implements abstractFactory {
    @Override
    public abstractProduct factory() {
        abstractProduct f = new Pear();
        System.out.println("PearFactory generater Pear");
        return f;
    }
}
