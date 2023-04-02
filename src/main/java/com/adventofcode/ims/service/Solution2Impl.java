package com.adventofcode.ims.service;

import java.util.List;

public class Solution2Impl {

    public static void main(String[] args) {

        List<String> boxIds = List.of("abcdef", "bababc", "abbcde", "abcccd", "aabcdd", "abcdee", "ababab");

        int twoLetterSum = 0;
        int threeLetterSum = 0;

        for (String boxId : boxIds) {
            int[] counts = new int[26];

            for (int i = 0; i < boxId.length(); i++) {
                counts[boxId.charAt(i) - 'a']++;
            }

            boolean hasTwoLetter = false;
            boolean hasThreeLetter = false;

            for (int count : counts) {
                if (count == 2 && !hasTwoLetter) {
                    twoLetterSum++;
                    hasTwoLetter = true;
                } else if (count == 3 && !hasThreeLetter) {
                    threeLetterSum++;
                    hasThreeLetter = true;
                }

                // if both 2 and 3 letters have been found, we can stop counting
                if (hasTwoLetter && hasThreeLetter) {
                    break;
                }
            }
        }

        int answer = twoLetterSum * threeLetterSum;
        System.out.println(answer);
    }
}
