package com.dpattern.structural.flyweight;

/**
 * different potion types
 *
 * @author Srinath.Rayabarapu
 */
public class HealingPotionImpl implements IPotion {
    @Override
    public void drink() {
        System.out.println("You are healed! - " + System.identityHashCode(this));
    }
}
