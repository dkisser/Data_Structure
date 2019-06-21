package structure.factoryPattern.factoryMethod.product;

import structure.factoryPattern.factoryMethod.abstractProduct.abstractProduct;

/**
 * Created by WenChen on 2018/3/30.
 */
public class Apple implements abstractProduct {


    @Override
    public void grow() {
        System.out.println("Apple grow");
    }

    @Override
    public void plant() {
        System.out.println("Apple plant");
    }

    @Override
    public void harvest() {
        System.out.println("Apple harvest");
    }
}
