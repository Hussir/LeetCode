package com.hussir.part002;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 *     Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 *
 *     A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 */
public class Question0017 {

    public static List<String> letterCombinations(String digits) {

        List<String> resultList = new ArrayList<>();

        if (digits == null || digits.length() == 0) return resultList;

        char[][] numbers= new char[10][4];

        numbers[2] = new char[]{'a', 'b', 'c', '#'};
        numbers[3] = new char[]{'d', 'e', 'f', '#'};
        numbers[4] = new char[]{'g', 'h', 'i', '#'};
        numbers[5] = new char[]{'j', 'k', 'l', '#'};
        numbers[6] = new char[]{'m', 'n', 'o', '#'};
        numbers[7] = new char[]{'p', 'q', 'r', 's'};
        numbers[8] = new char[]{'t', 'u', 'v', '#'};
        numbers[9] = new char[]{'w', 'x', 'y', 'z'};

        int curDigit = digits.charAt(0) - '0';

        resultList.add("" + numbers[curDigit][0]);
        resultList.add("" + numbers[curDigit][1]);
        resultList.add("" + numbers[curDigit][2]);

        if (numbers[curDigit][3] != '#') {
            resultList.add("" + numbers[curDigit][3]);
        }

        letterCombinations(resultList, digits.substring(1), numbers);

        return resultList;
    }

    private static void letterCombinations(List<String> strList, String digits, char[][] nums) {

        if (digits.length() == 0) return;

        int curDigit = digits.charAt(0) - '0';

        int size = strList.size();

        for (int i = 0; i < size; i++) {

            String curStr = strList.get(0);

            String nowStr0 = curStr + nums[curDigit][0];
            String nowStr1 = curStr + nums[curDigit][1];
            String nowStr2 = curStr + nums[curDigit][2];

            strList.add(nowStr0);
            strList.add(nowStr1);
            strList.add(nowStr2);

            if (nums[curDigit][3] != '#') {
                strList.add(curStr + nums[curDigit][3]);
            }

            strList.remove(0);
        }

        letterCombinations(strList, digits.substring(1), nums);
    }
}
