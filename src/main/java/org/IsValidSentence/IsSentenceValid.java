package org.IsValidSentence;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IsSentenceValid {
    /*
     * Method to filter through valid and invalid sentences
     *
     * Criteria that has to be met:
     * String starts with a capital letter.
     * String has an even number of quotation marks.
     * String ends with one of the following sentence termination characters: ".", "?", "!"
     * String has no period characters other than the last character.
     * Numbers below 13 are spelled out (”one”, “two”, "three”, etc…).
     */
    public static boolean checkIfSentenceIsValid(String sentence) {
        //Using Guard clauses below to filter out the sentence. By the end the result should be true.

        //Ensure the string starts with a letter
        if (!Character.isLetter(sentence.charAt(0))){
            return false;
        }

        //Ensure that the first char letter is a capital
        if (!Character.isUpperCase(sentence.charAt(0))){
            return false;
        }

        //Ensure that if the last char in the string is not within a list of symbols return false
        if (Arrays.stream(new String[]{"!", ".", "?"}).noneMatch(sentence.substring(sentence.length() - 1)::contains)){
            return false;
        }

        //Ensure that the string cannot contain a dot symbol before the end
        if (sentence.substring(0, sentence.length() - 1).contains(".")) {
            return false;
        }

        //Ensure that the string cannot contain numbers between 0 and <13
        if (!isNumericInString(sentence)) {
            return false;
        }

        //Ensure that if the string contains a " then there must be an even count.
        if ((sentence.chars().filter(ch -> ch == '"').count() % 2) != 0) {
            return false;
        }

        //Return true of all of the above criteria is met
        return true;
    }

    private static boolean isNumericInString(String word) {
        Pattern digitPattern = Pattern.compile("\\d+");
        Matcher digitPatternMatcher = digitPattern.matcher(word);

        //While the string contains a digit, then check if the number is less than 13.
        while (digitPatternMatcher.find()) {
            if (Integer.parseInt(digitPatternMatcher.group()) < 13) {
                return false;
            }
        }
        return true;
    }
}
