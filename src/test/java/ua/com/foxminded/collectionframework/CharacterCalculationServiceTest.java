package ua.com.foxminded.collectionframework;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

public class CharacterCalculationServiceTest {
    
    CharacterCalculationService characterCalculationService = new CharacterCalculationService();
    
    @Test
    public void createTestForOneWord() {
        String actual = "java";
        String expected = "\"j\" - 1" + System.lineSeparator() + "\"a\" - 2" + System.lineSeparator()
                + "\"v\" - 1" + System.lineSeparator() + "";
        assertEquals(expected, characterCalculationService.build(actual));
    }
    
    @Test
    public void createTestForOneSentence() {
        String actual = "JUnit 5, the next generation of JUnit, facilitates writing developer tests with new and shiny features.";
        String expected = "\"J\" - 2" + System.lineSeparator() + "\"U\" - 2" + System.lineSeparator()
                + "\"n\" - 9" + System.lineSeparator() + "\"i\" - 9" + System.lineSeparator() + "\"t\" - 12"
                + System.lineSeparator() + "\" \" - 15" + System.lineSeparator() + "\"5\" - 1"
                + System.lineSeparator() + "\",\" - 2" + System.lineSeparator() + "\"h\" - 3"
                + System.lineSeparator() + "\"e\" - 12" + System.lineSeparator() + "\"x\" - 1"
                + System.lineSeparator() + "\"g\" - 2" + System.lineSeparator() + "\"r\" - 4"
                + System.lineSeparator() + "\"a\" - 5" + System.lineSeparator() + "\"o\" - 3"
                + System.lineSeparator() + "\"f\" - 3" + System.lineSeparator() + "\"c\" - 1"
                + System.lineSeparator() + "\"l\" - 2" + System.lineSeparator() + "\"s\" - 5"
                + System.lineSeparator() + "\"w\" - 3" + System.lineSeparator() + "\"d\" - 2"
                + System.lineSeparator() + "\"v\" - 1" + System.lineSeparator() + "\"p\" - 1"
                + System.lineSeparator() + "\"y\" - 1" + System.lineSeparator() + "\"u\" - 1"
                + System.lineSeparator() + "\".\" - 1" + System.lineSeparator() + "";
        assertEquals(expected, characterCalculationService.build(actual));
    }
    
    @Test
    void createTestForOneLetter() {
        String actual = "a";
        String expected = "\"a\" - 1" + System.lineSeparator() + "";
        assertEquals(expected, characterCalculationService.build(actual));
    }
    
    @Test
    void creaTestForFewLetters() {
        String actual = "aaa";
        String expected = "\"a\" - 3" + System.lineSeparator() + "";
        assertEquals(expected, characterCalculationService.build(actual));
    }
    
    @Test
    void createTestForOneWordWithSpecialCaracters() {
        String actual = "qwe1rty!";
        String expected = "\"q\" - 1" + System.lineSeparator() + "\"w\" - 1" + System.lineSeparator()
                + "\"e\" - 1" + System.lineSeparator() + "\"1\" - 1" + System.lineSeparator() + "\"r\" - 1"
                + System.lineSeparator() + "\"t\" - 1" + System.lineSeparator() + "\"y\" - 1"
                + System.lineSeparator() + "\"!\" - 1" + System.lineSeparator() + "";
        assertEquals(expected, characterCalculationService.build(actual));
    }
    
    @Test
    void createTestFewWordsWithSpecialCaracters() {
        String actual = "Hello world!";
        String expected = "\"H\" - 1" + System.lineSeparator() + "\"e\" - 1" + System.lineSeparator()
                + "\"l\" - 3" + System.lineSeparator() + "\"o\" - 2" + System.lineSeparator() + "\" \" - 1"
                + System.lineSeparator() + "\"w\" - 1" + System.lineSeparator() + "\"r\" - 1"
                + System.lineSeparator() + "\"d\" - 1" + System.lineSeparator() + "\"!\" - 1"
                + System.lineSeparator() + "";
        assertEquals(expected, characterCalculationService.build(actual));
    }
    
    @Test
    public void checkTestCacheAssertSameForOneWord() {
        String expressionFirst = characterCalculationService.build("Java");
        String expressionSecond = characterCalculationService.build("Java");
        assertSame(expressionFirst, expressionSecond);
    }
}
