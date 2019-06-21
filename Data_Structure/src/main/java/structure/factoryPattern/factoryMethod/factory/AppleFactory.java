package structure.factoryPattern.factoryMethod.factory;

import structure.factoryPattern.factoryMethod.abstractFactory.abstractFactory;
import structure.factoryPattern.factoryMethod.abstractProduct.abstractProduct;
import structure.factoryPattern.factoryMethod.product.Apple;

/**
 * Created by WenChen on 2018/3/30.
 */
public class AppleFactory implements abstractFactory {
    @Override
    public abstractProduct factory() {
        abstractProduct f = new Apple();
        System.out.println("AppleFactory generater Apple");
        return f;
    }
}
