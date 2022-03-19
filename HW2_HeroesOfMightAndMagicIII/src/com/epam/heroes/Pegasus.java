package com.epam.heroes;

import com.epam.data.Heroes;

public class Pegasus extends Heroes {

    private boolean hasAttackUltimate;

    public Pegasus(String nameOfHero, int range, int defence, int attackFromWiki, int attack, int health, int speed, int position, boolean hasAttackUltimate) {
        super(nameOfHero, range, defence, attackFromWiki, attack, health, speed, position, hasAttackUltimate);
        hasAttackUltimate = false;
    }

    public boolean isHasAttackUltimate() {
        return hasAttackUltimate;
    }

}
