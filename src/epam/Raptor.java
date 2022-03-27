package epam;

import static java.lang.System.*;

public class Raptor implements AbilitiesOfCreatures {
    int health = 14;
    public int damagePoints = 5;
    int defencePoints = 6;
    int superpowerPoints = 8;
    int goodGuyPointOfAppearing = 0;
    String goodGuyAnswer = "\t # Hi man! Can I help you?? That is to say 'what a hell are you doing here?!' #\n";

    public int getDamage(int enemyDamagePoints) {
        health -= enemyDamagePoints;
        return health;
    }

    @Override
    public void defend() {

    }

    @Override
    public void move() {
        goodGuyPointOfAppearing += 1;
    }

    @Override
    public void detectEnemy() {

    }

    @Override
    public void dieOut() {
        String finalGoodBye = "\tGame Over";
        out.println(finalGoodBye);
    }

    @Override
    public int useSuperpower(int maxEnemyHealth) {
        return maxEnemyHealth -= superpowerPoints;
    }

    public int getEnemySuperpowerDamage(int enemySuperpowerPoints) {
        health -= enemySuperpowerPoints;
        return health;
    }

    public String getGoodGuyAnswer() {
        return goodGuyAnswer;
    }
}
