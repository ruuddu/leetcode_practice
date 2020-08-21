package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GuessWord {

    //    public void findSecretWord(String[] wordlist, Master master) {
//
//        List<String> candidateList = new ArrayList<>();
//        Random rand = new Random();
//
//        for (String word : wordlist) {
//            candidateList.add(word);
//        }
//
//        for (int i = 0; i < 5; i++) {
//            int len = candidateList.size();
//            String nextGuess = candidateList.get(rand.nextInt(len));
//            String nextGuess2 = candidateList.get(rand.nextInt(len));
//            //String nextGuess3 = candidateList.get(rand.nextInt(len));
//
//            int score = master.guess(nextGuess);
//            int score2 = master.guess(nextGuess2);
//
//            if (score == 6 || score2 == 6) {
//                break;
//            }
//
//            List<String> nextList = new ArrayList<>();
//            for (String word : candidateList) {
//                if (match(word, nextGuess) == score && match(word, nextGuess2) == score2) {
//                    nextList.add(word);
//                }
//            }
//            candidateList = nextList;
//        }
//    }

    private int match(String s1, String s2) {

        int score = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                score++;
            }
        }
        return score;
    }
}
