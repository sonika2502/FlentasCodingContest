package codingcontest;

import java.util.*;

public class CodingContest {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < t; i++) {
            String pattern = sc.nextLine();
            String text = sc.nextLine();
            if (isPatternInText(pattern, text)) {
                System.out.print("YES ");
            } else {
                System.out.print("NO ");
            }
        }
    }

    public static boolean isPatternInText(String pattern, String text) {
        int[] patternCount = new int[26];
        int[] textCount = new int[26];

        if (pattern.length() > text.length()) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            patternCount[pattern.charAt(i) - 'a']++;
            textCount[text.charAt(i) - 'a']++;
        }

        for (int i = pattern.length(); i < text.length(); i++) {
            if (Arrays.equals(patternCount, textCount)) {
                return true;
            }

            textCount[text.charAt(i - pattern.length()) - 'a']--;
            textCount[text.charAt(i) - 'a']++;
        }

        return Arrays.equals(patternCount, textCount);
    }
}

