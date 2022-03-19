package com.epam.action;

import com.epam.data.Heroes;
import com.epam.heroes.Pegasus;
import com.epam.heroes.SilvanElf;

public class Action {
    public static void action() {

        SilvanElf silvanElf = new SilvanElf("Эльф", 25, 5, (int) (Math.random() * (5 - 3 + 1)) + 3, 0, 15, 6, 0, true);
        Pegasus pegasus = new Pegasus("Пегас", 1, 8, (int) (Math.random() * (9 - 5 + 1)) + 5, 0, 30, 8, 25, false);

        Heroes[] heroes = {silvanElf, pegasus};
        int randHeroes = (int) Math.floor(Math.random() * heroes.length);

        Heroes first;
        Heroes second;

        if (randHeroes == 1) {
            first = heroes[1];
            second = heroes[0];
            System.out.println("");
            System.out.println("Первым ходит " + pegasus.getNameOfHero());
            System.out.println("Противник: " + silvanElf.getNameOfHero());
        } else {
            first = heroes[0];
            second = heroes[1];
            System.out.println("");
            System.out.println("Первым ходит " + silvanElf.getNameOfHero());
            System.out.println("Противник: " + pegasus.getNameOfHero());
        }

        silvanElf.setEnemy(pegasus);

        pegasus.setEnemy(silvanElf);

        Heroes tmp;

        while (silvanElf.getHealth() > 0 && pegasus.getHealth() > 0) {

            if (first.getRange() < Math.abs(first.getPosition() - second.getPosition())) {
                first.motion();
            } else {
                first.hit();
            }

            tmp = first;
            first = second;
            second = tmp;

        }

        if (silvanElf.getHealth() <= 0) {
            silvanElf = (SilvanElf) Heroes.die(silvanElf);
        } else {
            pegasus = (Pegasus) Heroes.die(pegasus);
        }

    }
}
