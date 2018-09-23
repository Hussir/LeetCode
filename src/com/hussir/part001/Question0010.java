package com.hussir.part001;

/**
 * Description:
 *     Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 *         '.' Matches any single character.
 *         '*' Matches zero or more of the preceding element.
 *
 *     The matching should cover the entire input string (not partial).
 */
public class Question0010 {

    public boolean isMatch(String s, String p) {
        return isMatch(s, 0, p, 0);
    }

    private boolean isMatch(String s, int beginIndexOfS, String p, int beginIndexOfP) {

        if (beginIndexOfS == s.length() && beginIndexOfP == p.length()) {
            return true;
        }

        if (beginIndexOfS == s.length()) {

            if (beginIndexOfP < p.length() - 1 && p.charAt(beginIndexOfP + 1) == '*') {
                return isMatch(s, beginIndexOfS, p, beginIndexOfP + 2);
            }

            return false;
        }

        if (beginIndexOfP == p.length()) return false;

        if (s.charAt(beginIndexOfS) == p.charAt(beginIndexOfP) || p.charAt(beginIndexOfP) == '.') {

            if (beginIndexOfP < p.length() - 1 && p.charAt(beginIndexOfP + 1) == '*') {
                    return isMatch(s, beginIndexOfS + 1, p, beginIndexOfP) ||
                           isMatch(s, beginIndexOfS + 1, p, beginIndexOfP + 2) ||
                           isMatch(s, beginIndexOfS, p, beginIndexOfP + 2);
            } else {
                return isMatch(s, beginIndexOfS + 1, p, beginIndexOfP + 1);
            }
        } else {

            if (beginIndexOfP < p.length() - 1 && p.charAt(beginIndexOfP + 1) == '*') {
                return isMatch(s, beginIndexOfS, p, beginIndexOfP + 2);
            }

            return false;
        }
    }
}
