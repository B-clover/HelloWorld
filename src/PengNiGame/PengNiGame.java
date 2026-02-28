package PengNiGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PengNiGame {
    public static void main(String[] args) {
        System.out.println("PengNiGame");
        int firstwin = 0, secondwin = 0;
        ArrayList<Integer> choices = new ArrayList<>();
        choices.add(0);
        choices.add(1);
        Random random = new Random();
        for (int j = 0; j < 100000; j++) {
            int choice1 = choices.get(random.nextInt(choices.size()));
            int choice2 = choices.get(random.nextInt(choices.size()));
            int choice3 = choices.get(random.nextInt(choices.size()));

            List<Integer> gamer1 = Arrays.asList(choice1, choice2, choice3);
            List<Integer> gamer2 = Arrays.asList(1-choice2, choice1, choice2);
            // 开始抛硬币
            List<Integer> game = new ArrayList<>();
            for (int i = 0; i < 3; i++) game.add(choices.get(random.nextInt(choices.size())));
            while (true){
                if (game.equals(gamer1)){
                    firstwin ++;
                    break;
                } else if(game.equals(gamer2)){
                    secondwin++;
                    break;
                }
                game.remove(0);
                game.add(choices.get(random.nextInt(choices.size())));
            }
        }
        System.out.printf("玩家1胜利次数：%d %n", firstwin);
        System.out.printf("玩家2胜利次数：%d ", secondwin);
    }

}
