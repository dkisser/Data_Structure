package structure.factoryPattern.factoryMethod.product;

import structure.factoryPattern.factoryMethod.abstractProduct.abstractProduct;

/**
 * Created by WenChen on 2018/3/30.
 */
public class Pear implements abstractProduct {


    @Override
    public void grow() {
        System.out.println("Pear grow");
    }

    @Override
    public void plant() {
        System.out.println("Pear plant");
    }

    @Override
    public void harvest() {
        System.out.println("Pear harvest");
    }
}
