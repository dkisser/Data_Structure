package structure.factoryPattern.factoryMethod.factory;

import com.wc.factoryPattern.factoryMethod.abstractFactory.abstractFactory;
import com.wc.factoryPattern.factoryMethod.abstractProduct.abstractProduct;
import com.wc.factoryPattern.factoryMethod.product.Pear;

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
