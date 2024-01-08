package com.dpattern.structural.flyweight;

/**
 * different potion types
 *
 * @author Srinath.Rayabarapu
 */
public class InvisiblePotionImpl implements IPotion {
    @Override
    public void drink() {
        System.out.println("You are Invisible! - " + System.identityHashCode(this));
    }
}