package com.dpattern.structural.flyweight;

/**
 * different potion types
 *
 * @author Srinath.Rayabarapu
 */
public class HolyWaterPotionImpl implements IPotion {
    @Override
    public void drink() {
        System.out.println("You are blessed! - " + System.identityHashCode(this));
    }
}
