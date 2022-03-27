package epam;

import static java.lang.System.*;

public class Serpent implements AbilitiesOfCreatures {
    public int maxEnemyHealth = 20;
    public int enemyDamagePoints = 5;
    int enemySuperpowerPoints = 7;
    int enemyPointOfAppearing = 25;

    public int getDamage(int damagePoints) {
        maxEnemyHealth -= damagePoints;
        return maxEnemyHealth;
    }

    public int getSuperpowerDamage(int superpowerPoints) {
        maxEnemyHealth -= superpowerPoints;
        return maxEnemyHealth;
    }

    @Override
    public void defend() {
    }

    @Override
    public void move() {
        enemyPointOfAppearing -= 1;
    }

    @Override
    public void detectEnemy() {

    }

    @Override
    public void dieOut() {
        String fareWell = "\tSerpent is not around anymore.";
        out.println(fareWell);
    }

    @Override
    public int useSuperpower(int maxEnemyHealth) {
        return maxEnemyHealth;
    }

    public int getMaxEnemyHealth() {
        return maxEnemyHealth;
    }

    public void setMaxEnemyHealth(int maxEnemyHealth) {
        this.maxEnemyHealth = maxEnemyHealth;
    }
}
