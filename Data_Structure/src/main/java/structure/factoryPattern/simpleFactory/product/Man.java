package structure.factoryPattern.simpleFactory.product;


import structure.factoryPattern.simpleFactory.abstractProduct.Ancestor;

/**
 * Created by WenChen on 2018/3/30.
 *
 * 说明：该类为具体产品类
 */
public class Man implements Ancestor {

    @Override
    public void doSomething() {
        System.out.println("I am Man");
    }

}
