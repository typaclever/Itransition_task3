package com.company;

import java.util.Arrays;

public class Validator {
    private static void checkLengthCorrectness(int length) throws InputArgsException {
        if (length < 3) {
            throw new InputArgsException("You entered too few parameters, please try again!\nIt should be like : \"1 2 3 4 5 6 7\"");
        } else if (length % 2 == 0) {
            throw new InputArgsException("You entered the wrong number of parameters, please try again!\nIt should be like : \"1 2 3 4 5 6 7\"");
        }
    }

    private static void checkRepl(String[] input) throws InputArgsException {
        if (Arrays.stream(input).distinct().count() != input.length) {
            throw new InputArgsException("Some parameters that you entered are repeated, please try again!\nIt should be like \"1 2 3 4 5 6 7\"");
        }
    }

    public static boolean checkArgsCorrectness(String[] input) {

        try {
            checkRepl(input);
            checkLengthCorrectness(input.length);
        } catch (InputArgsException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}

