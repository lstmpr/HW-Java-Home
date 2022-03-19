package com.epam.data;


public abstract class Heroes {
    private String nameOfHero;
    private int range;
    private int defence;
    private int attackFromWiki;
    private int attack;
    private int health;
    private int speed;
    private int position;
    private Heroes enemy;
    private boolean hasAttackUltimate;

    public Heroes(String nameOfHero, int range, int defence, int attackFromWiki, int attack, int health, int speed, int position, boolean hasAttackUltimate) {
        this.nameOfHero = nameOfHero;
        this.range = range;
        this.defence = defence;
        this.attackFromWiki = attackFromWiki;
        this.attack = attack;
        this.health = health;
        this.speed = speed;
        this.position = position;
        this.hasAttackUltimate = hasAttackUltimate;
    }

    public Heroes() {
    }

    public void hit() {
        this.attack = this.attackFromWiki;

        int tpm = this.attack;

        if (this.hasAttackUltimate) {
            tpm = this.attack;
            int[] tmp1 = {this.attackFromWiki, this.attackFromWiki * 2};

            int randHeroes = (int) Math.floor(Math.random() * tmp1.length);

            if (randHeroes == 1) {
                this.attack = tmp1[1];
            } else {
                this.attack = tmp1[0];
            }
        }

        if (enemy.defence >= this.attack) {
            System.out.println("");
            System.out.println("Бой");
            System.out.println("До атаки - бьющий: " + this.nameOfHero + "; Атака = " + this.attack);
            System.out.println("До атаки - защищающийся: " + enemy.nameOfHero + "; Защита = " + enemy.defence + ";  Здоровье = " + enemy.health);

            enemy.defence -= this.attack;

            System.out.println("После атаки - бьющий : " + this.nameOfHero + "; Атака = " + this.attack);
            System.out.println("После атаки - защищающийся : " + enemy.nameOfHero + "; Защита = " + enemy.defence + "; Здоровье = " + enemy.health);

        } else {
            System.out.println("");
            System.out.println("Бой");
            System.out.println("До атаки - бьющий: " + this.nameOfHero + "; Атака = " + this.attack);
            System.out.println("До атаки - защищающийся: " + enemy.nameOfHero + "; Защита = " + enemy.defence + "; Здоровье = " + enemy.health);

            int temp = this.attack - enemy.defence;
            enemy.health -= temp;
            enemy.defence = 0;

            System.out.println("После атаки - бьющий: " + this.nameOfHero + "; Атака = " + this.attack);
            System.out.println("После атаки - защищающийся: " + enemy.nameOfHero + "; Защита = " + enemy.defence + "; Здоровье = " + enemy.health);
        }

        this.attack = tpm;


    }

    public void motion() {

        if ((Math.abs(this.position - enemy.position) > this.range)) {

            if (Math.abs(this.position - enemy.position) > this.speed) {
                System.out.println("");
                System.out.println("Перемещение");
                System.out.println("Была координата: " + this.nameOfHero + " " + this.position);
                if (this.position > enemy.position) {
                    this.position -= this.speed;
                } else {
                    this.position += this.speed;
                }
                System.out.println("Стала координата: " + this.nameOfHero + " " + this.position);
            } else {
                System.out.println("");
                System.out.println("Перемещение");
                System.out.println("Была координата: " + this.nameOfHero + " " + this.position);
                if (this.position > enemy.position) {
                    this.position = enemy.position + 1;
                } else {
                    this.position = enemy.position - 1;
                }
                System.out.println("Стала координата: " + this.nameOfHero + " " + this.position);

            }
        }
    }

    public static Heroes die(Heroes hero) {
        if (hero.health <= 0) {
            System.out.println("");
            System.out.println(hero.nameOfHero + " погиб, победу одержал: " + hero.enemy.nameOfHero);
            return null;

        } else {
            System.out.println("");
            System.out.println("Герой не может умереть, его здоровье = " + hero.health);
            return hero;
        }

    }

    public String getNameOfHero() {
        return nameOfHero;
    }

    public void setNameOfHero(String nameOfHero) {
        this.nameOfHero = nameOfHero;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Heroes getEnemy() {
        return enemy;
    }

    public void setEnemy(Heroes enemy) {
        this.enemy = enemy;
    }

    public int getAttackFromWiki() {
        return attackFromWiki;
    }

    public void setAttackFromWiki(int attackFromWiki) {
        this.attackFromWiki = attackFromWiki;
    }

    public boolean isHasAttackUltimate() {
        return hasAttackUltimate;
    }

    public void setHasAttackUltimate(boolean hasAttackUltimate) {
        this.hasAttackUltimate = hasAttackUltimate;
    }
}
