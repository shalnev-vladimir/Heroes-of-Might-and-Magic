package epam;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random random = new Random();
        Raptor goodGuy = new Raptor();
        Serpent enemy = new Serpent();

        String enemyName = "Serpent";
        int distanceToEnemy = enemy.enemyPointOfAppearing - goodGuy.goodGuyPointOfAppearing;

        out.println("Welcome to the Heroes of Might and Magic!!!");
        out.println("-------------------------------------------------------------------------------------------");
        out.println("\t # " + enemyName + " has appeared! #\n");
        out.println("\t # Distance to enemy " + distanceToEnemy + " #\n");

        while (distanceToEnemy != 1) {
            goodGuy.move();
            distanceToEnemy -= 1;
            enemy.move();
            distanceToEnemy -= 1;
            out.println("\t # Distance to enemy " + distanceToEnemy + " #");
        }

        out.println(goodGuy.getGoodGuyAnswer());
        int randomAnswer = random.nextInt(2);
        if (randomAnswer == 1) {
            out.println("\t # Serpent: I am just walking around #");
            out.println("\t # Raptor: Happy to hear that. I'm going to have a cup of coffee. Would you join me? #");
            out.println("\t # You are so kind :-} I'd happy to accept an invitation #");
        } else {
            out.println("\t # Serpent: I have come to kill you, all your family, and to destroy your castle! #");
            out.println("\t # Raptor: Enough talking let's fight! #");

            while (enemy.maxEnemyHealth > 0 || goodGuy.health > 0) {
                out.println("\tYour HP " + goodGuy.health);
                out.println("\t" + enemyName + "'s HP " + enemy.maxEnemyHealth);
                out.println("\n\tWhat would you like to do?");
                out.println("\t1. Attack.");
                out.println("\t2. Defence.");
                out.println("\t3. Use superpower.");

                // пользователь выбирает, что он собирается сделать
                String input = in.nextLine();
                if (!input.equals("1")) {
                    if (input.equals("2")) {
                        goodGuy.defend();
                    } else if (input.equals("3")) {
                        enemy.getSuperpowerDamage(goodGuy.superpowerPoints);
                        out.println("\tYou struck " + enemyName + " for " + goodGuy.superpowerPoints + " damage.");
                    } else {
                        out.println("Invalid input. Try one more time.");
                    }
                } else {
                    enemy.getDamage(goodGuy.damagePoints);
                    out.println("\tYou struck the " + enemyName + " for " + goodGuy.damagePoints + " damage.");
                }

                // если жизни врага закончились, игра останавливается
                if (enemy.maxEnemyHealth <= 0) {
                    enemy.dieOut();
                    break;
                }

                // враг совершает какие-то рандомные действия
                int randomEnemyMethod = random.nextInt(3);
                if (randomEnemyMethod == 1) {
                    goodGuy.getDamage(enemy.enemyDamagePoints);
                    out.println("\tYou have been attacked by the " + enemyName + " for " + enemy.enemyDamagePoints +
                            " points damage.");
                } else if (randomEnemyMethod == 2) {
                    goodGuy.defend();
                    out.println("\t" + enemyName + " defend himself.");
                } else {
                    goodGuy.getEnemySuperpowerDamage(enemy.enemySuperpowerPoints);
                    out.println("\t" + enemyName + " used his superpower. You have been attacked for "
                            + enemy.enemySuperpowerPoints + " points damage.");
                }

                 // если жизни пользователя закончились, игра заканчивается
                 if (goodGuy.health <= 0) {
                    goodGuy.dieOut();
                    break;
                }
            }
        }
    }
}
