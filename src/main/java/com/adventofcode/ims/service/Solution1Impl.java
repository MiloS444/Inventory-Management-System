package com.adventofcode.ims.service;

import java.util.Arrays;
import java.util.List;

public class Solution1Impl {

    /*
    abcdef contains no letters that appear exactly two or three times. - 0 0
    bababc contains two a and three b, so it counts for both.          - 1 1
    abbcde contains two b, but no letter appears exactly three times.  - 1 0
    abcccd contains three c, but no letter appears exactly two times.  - 0 1
    aabcdd contains two a and two d, but it only counts once.          - 1 0
    abcdee contains two e.                                             - 1 0
    ababab contains three a and three b, but it only counts once.      - 0 1
    * */

    public static void main(String[] args) {

        // Test cases
//         List<String> boxIds = List.of("aba", "ab", "abc", "abb", "abbb", "abbc", "bbbaaa");
        List<String> boxIds = List.of("abcdef", "bababc", "abbcde", "abcccd", "aabcdd", "abcdee", "ababab");

        int[] twoLetters = new int[boxIds.size()];
        int[] threeLetter = new int[boxIds.size()];

        int k = 0;
        for (String boxId : boxIds) {
            for (int i = 0; i < boxId.length(); i++) {

                char letter = boxId.charAt(i);
                long count = countStringOccurrence(boxId, String.valueOf(letter), 4);

                if (count == 2) {
                    twoLetters[k] = 1;
                }

                if (count == 3) {
                    threeLetter[k] = 1;
                }

                // If both 2 and 3 letters occurrence have been found, we can stop counting
                if (twoLetters[k] == 1 && threeLetter[k] == 1) {
                    break;
                }

            }
            k++;
        }

        int answer = Arrays.stream(twoLetters).sum() * Arrays.stream(threeLetter).sum();

        System.out.println(answer);
    }

    static int countStringOccurrence(final String source, final String toFind, final int threshold) {

        int lastIndex = 0;
        int count = 0;

        while (lastIndex != -1) {

            lastIndex = source.indexOf(toFind, lastIndex);

            if (lastIndex != -1) {
                count++;
                lastIndex = lastIndex + toFind.length();
            }

            // Only interested in number of occurrence of  1 < toFind < t threshold
            if (count == threshold) {
                return 0;
            }
        }

        if (count == 1) {
            return 0;
        }
        return count;
    }
}
