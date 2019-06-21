package structure.factoryPattern.factoryMethod.factory;

import com.wc.factoryPattern.factoryMethod.abstractFactory.abstractFactory;
import com.wc.factoryPattern.factoryMethod.abstractProduct.abstractProduct;
import com.wc.factoryPattern.factoryMethod.product.Apple;

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
