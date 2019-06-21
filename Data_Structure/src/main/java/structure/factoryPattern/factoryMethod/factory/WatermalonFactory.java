package structure.factoryPattern.factoryMethod.factory;

import structure.factoryPattern.factoryMethod.abstractFactory.abstractFactory;
import structure.factoryPattern.factoryMethod.abstractProduct.abstractProduct;
import structure.factoryPattern.factoryMethod.product.Watermalon;

/**
 * Created by WenChen on 2018/3/30.
 */
public class WatermalonFactory implements abstractFactory {
    @Override
    public abstractProduct factory() {
        abstractProduct f = new Watermalon();
        System.out.println("WatermalonFactory generater Watermalon");
        return f;
    }
}
