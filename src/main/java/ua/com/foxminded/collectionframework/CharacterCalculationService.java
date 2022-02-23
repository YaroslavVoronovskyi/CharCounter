package ua.com.foxminded.collectionframework;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CharacterCalculationService {
    
    private static final String SEPARATOR = System.lineSeparator();
    private Map<String, String> cache = new HashMap<>();
    
    private void checkExpressionByNull(String expression) {
        if (expression == null) {
            throw new IllegalArgumentException("Expression can not be null!");
        }
    }
    
    public String build(String expression) {
        checkExpressionByNull(expression);
        if (cache.containsKey(expression)) {
            return cache.get(expression);
        }
        Map<Character, Integer> resultCharactersCalculation = calculateCharactersStats(expression);
        String result = buildStatsView(resultCharactersCalculation);
        saveInCache(expression, result);
        return result;
    }
    
    private Map<Character, Integer> calculateCharactersStats(String expression) {
        Map<Character, Integer> resultCharactersCalculation = new LinkedHashMap<>();
        for (char symbol : expression.toCharArray()) {
            if (resultCharactersCalculation.containsKey(symbol)) {
                resultCharactersCalculation.put(symbol, resultCharactersCalculation.get(symbol) + 1);
            } else {
                resultCharactersCalculation.put(symbol, 1);
            }
        }
        return resultCharactersCalculation;
    }
    
    private String buildStatsView(Map<Character, Integer> countedChars) {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : countedChars.entrySet()) {
            result.append(String.format("\"%s\" - %s%s", entry.getKey(), entry.getValue(), SEPARATOR));
        }
        return result.toString();
    }
    
    private void saveInCache(String expression, String result) {
        cache.put(expression, result);
    }
}
