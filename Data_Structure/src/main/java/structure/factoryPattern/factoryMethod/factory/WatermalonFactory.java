package structure.factoryPattern.factoryMethod.factory;

import com.wc.factoryPattern.factoryMethod.abstractFactory.abstractFactory;
import com.wc.factoryPattern.factoryMethod.abstractProduct.abstractProduct;
import com.wc.factoryPattern.factoryMethod.product.Watermalon;

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
