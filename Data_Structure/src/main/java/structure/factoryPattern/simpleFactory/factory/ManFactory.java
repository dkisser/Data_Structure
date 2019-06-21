package structure.factoryPattern.simpleFactory.factory;

import com.wc.factoryPattern.simpleFactory.abstractProduct.Ancestor;
import com.wc.factoryPattern.simpleFactory.product.Man;
import com.wc.factoryPattern.simpleFactory.product.Woman;

/**
 * Created by WenChen on 2018/3/30.
 *
 * 功能：该类为工厂类，负责生成具体实例
 *
 */
public class ManFactory {

    private ManFactory(){

    }

    public static Ancestor newInstance (int type){
        Ancestor product = null;
        switch(type){
            case 1:
                product = new Man();
                break;
            case 2:
                product = new Woman();
                break;
        }
        return product;
    }

}
