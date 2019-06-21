package structure.factoryPattern.factoryMethod.product;

import structure.factoryPattern.factoryMethod.abstractProduct.abstractProduct;

/**
 * Created by WenChen on 2018/3/30.
 */
public class Watermalon implements abstractProduct {


    @Override
    public void grow() {
        System.out.println("Watermalon grow");
    }

    @Override
    public void plant() {
        System.out.println("Watermalon plant");
    }

    @Override
    public void harvest() {
        System.out.println("Watermalon harvest");
    }
}
