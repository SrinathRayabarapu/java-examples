package com.dpattern.structural.flyweight;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

/**
 * core factory in this pattern - creates potion objects
 *
 * @author Srinath.Rayabarapu
 */
public class PotionFactory {

    private final Map<PotionType, IPotion> map;

    public PotionFactory() {
        map = new EnumMap<>(PotionType.class);
    }

    public IPotion createPotion(PotionType potionType) {
        IPotion potion = map.get(potionType);
        if (Objects.isNull(potion)) {
            switch (potionType) {
                case HEALING:
                    potion = new HealingPotionImpl();
                    map.put(potionType, potion);
                    break;
                case HOLY_WATER:
                    potion = new HolyWaterPotionImpl();
                    map.put(potionType, potion);
                    break;
                case INVISIBILITY:
                    potion = new InvisiblePotionImpl();
                    map.put(potionType, potion);
                    break;
            }
        }
        return potion;
    }

}
