package structure.factoryPattern.simpleFactory;

import structure.factoryPattern.simpleFactory.abstractProduct.Ancestor;
import structure.factoryPattern.simpleFactory.factory.ManFactory;

/**
 * Created by WenChen on 2018/3/30.
 *
 * 说明：该类为具体的客户端类
 */
public class Client {

    public static void main (String[] args){
        //我现在想要创建一个实例，我们通过实例化工厂角色来实现
        Ancestor factory = ManFactory.newInstance(1);
        factory.doSomething();
    }
}
