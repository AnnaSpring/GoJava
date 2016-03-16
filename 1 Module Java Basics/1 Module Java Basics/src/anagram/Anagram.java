package anagram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Anagram {

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(
                System.in));
        String userInput = null;
        try {
            userInput = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] words = userInput.split(" ");
        for (int i = 0; i < words.length; i++) {
            System.out.print(printAnagram(words[i]) + " ");
        }
    }

    public static String printAnagram(String string) {
        return new StringBuilder(string).reverse().toString();
    }
}
