package com.dpattern.structural.flyweight;

/**
 * Intent: Use sharing to support large numbers of fine-grained objects efficiently. It is used to minimize
 * memory usage or computational expenses by sharing as much as possible with similar objects.
 *
 * https://github.com/iluwatar/java-design-patterns/tree/master/flyweight
 *
 * @author Srinath.Rayabarapu
 */
public class FlyWeightPatternMain {

    public static void main(String[] args) {
        PotionFactory factory = new PotionFactory();
        factory.createPotion(PotionType.HEALING).drink();
        factory.createPotion(PotionType.HOLY_WATER).drink();
        factory.createPotion(PotionType.INVISIBILITY).drink();
        factory.createPotion(PotionType.HEALING).drink();
        factory.createPotion(PotionType.HOLY_WATER).drink();
        factory.createPotion(PotionType.INVISIBILITY).drink();
        factory.createPotion(PotionType.HEALING).drink();
    }

}