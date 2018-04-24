package lesson16.HomeWork;

public class Solution {
    public static void main(String[] args) {

        String test = "f111 crash a blaaaaaaa bla d@ bla @#jjjj 124count111 count555 laa bl12 aa sd lala вk";

//        System.out.println(maxWord(test));
//        System.out.println(minWord(test));
//        System.out.println(countWords(test));
//        System.out.println(minWord(test));
        System.out.println(maxWord(test));
        System.out.println(minWord(test));


//        System.out.println(mostCountedWords(test));


        //


    }


    static int countWords(String input) {

        String[] results = input.split(" ");


        int count = 0;

        for (String result : results) {

            if (result != null && !result.equals("") && isWord(result)) {

                count++;
            }
        }

        return count;

    }

    static String maxWord(String input) {
        String[] results = input.split(" ");
        String maxWord = null;
        if (results.length == 0) return null;

        for (String result : results) {
            if (result.length() > 0 && isWord(result)) {
                maxWord = result;
                break;
            }
        }

        if (maxWord == null) return null;

        for (String result: results) {
            if (result.length() > maxWord.length() && isWord(result)) maxWord = result;
        }
        return maxWord;

    }

    static String minWord(String input) {
        String[] results = input.split(" ");
        String minWord = null;

        if (results.length == 0) return null;

        for (String result : results) {
            if (result.length() > 0 && isWord(result)) {
                minWord = result;
                break;
            }
        }

        if (minWord == null) return null;

        for (String result: results) {
            if (result.length() < minWord.length() && isWord(result)) minWord = result;
        }



        return minWord;

    }

    static boolean isWord(String input) {
        char[] letters = input.toCharArray();
        for (char letter : letters) {
            if (!Character.isLetter(letter)) return false;
        }

        return true;

    }

    static String mostCountedWords(String input) {
        String[] res = input.split(" ");
//        String word = res[0];


        return null;
    }


}
