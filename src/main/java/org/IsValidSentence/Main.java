package org.IsValidSentence;

public class Main {
    public static void main(String[] args) {

        String[] validSentences = new String[]{
                "The quick brown fox said \"hello Mr lazy dog\".",
                "The quick brown fox said hello Mr lazy dog.",
                "One lazy dog is too few, 13 is too many.",
                "One lazy dog is too few, thirteen is too many.",
                "How many \"lazy dogs\" are there?"};

        String[] invalidSentences = new String[]{
                "The quick brown fox said \"hello Mr. lazy dog\".",
                "the quick brown fox said “hello Mr lazy dog\".",
                "\"The quick brown fox said “hello Mr lazy dog.\"",
                "One lazy dog is too few, 12 is too many.",
                "Are there 11, 12, or 13 lazy dogs?",
                "There is no punctuation in this sentence"};

        for (String sentence : validSentences){
            System.out.println(sentence + " is " + IsSentenceValid.checkIfSentenceIsValid(sentence));
        }
        System.out.println("\n");
        for (String sentence : invalidSentences){
            System.out.println(sentence + " is " + IsSentenceValid.checkIfSentenceIsValid(sentence));
        }
    }




}