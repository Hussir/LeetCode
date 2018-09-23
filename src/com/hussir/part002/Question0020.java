package com.hussir.part002;

import java.util.Stack;

/**
 * Description:
 *
 *     Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 *     An input string is valid if:
 *
 *     1. Open brackets must be closed by the same type of brackets.
 *     2. Open brackets must be closed in the correct order.
 *
 *     Note that an empty string is also considered valid.
 */
public class Question0020 {

    public static boolean isValid(String s) {

        if (s == null || s.length() == 0) return true;

        Stack<Character> assistStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char curChar = s.charAt(i);

            switch (curChar) {
                case '(' : assistStack.push(curChar);break;
                case '[' : assistStack.push(curChar);break;
                case '{' : assistStack.push(curChar);break;
                case ')' : {
                    if (assistStack.isEmpty() || assistStack.pop() != '(') {
                        return false;
                    }
                } break;
                case ']' : {
                    if (assistStack.isEmpty() || assistStack.pop() != '[') {
                        return false;
                    }
                } break;
                case '}' : {
                    if (assistStack.isEmpty() || assistStack.pop() != '{') {
                        return false;
                    }
                }
            }
        }

        return assistStack.isEmpty();
    }
}
