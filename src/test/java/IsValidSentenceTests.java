import org.junit.Assert;
import org.junit.Test;
import org.IsValidSentence.IsSentenceValid;

public class IsValidSentenceTests {

    @Test()
    public void ensureInvalidSentencesFail(){
        String[] invalidSentences = new String[]{
                "The quick brown fox said \"hello Mr. lazy dog\".",
                "the quick brown fox said “hello Mr lazy dog\".",
                "\"The quick brown fox said “hello Mr lazy dog.\"",
                "One lazy dog is too few, 12 is too many.",
                "Are there 11, 12, or 13 lazy dogs?",
                "There is no punctuation in this sentence", "!The big dog!"};

        for (String sentence : invalidSentences){
            Assert.assertFalse(IsSentenceValid.checkIfSentenceIsValid(sentence));
        }
    }

    @Test
    public void ensureValidSentencesPass(){
        String[] validSentences = new String[]{
                "The quick brown fox said \"hello Mr lazy dog\".",
                "The quick brown fox said hello Mr lazy dog.",
                "One lazy dog is too few, 13 is too many.",
                "One lazy dog is too few, thirteen is too many.",
                "How many \"lazy dogs\" are there?"};

        for (String sentence : validSentences){
            Assert.assertTrue(IsSentenceValid.checkIfSentenceIsValid(sentence));
        }
    }
}
