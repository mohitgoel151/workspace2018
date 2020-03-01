package leetcode.weekly._173;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * https://leetcode.com/problems/number-of-atoms/
 *
 */
public class Atoms {

    public static void main(String[] args) {
        
        
        String result = countOfAtoms("Mg(OH)2");
        System.out.println(result);
        String result1 = countOfAtoms("K4(ON(SO3)2)2");
        System.out.println(result1);

    }

    public static String countOfAtoms(String formula) {
        if (formula == null || formula.length() < 2) {
            return formula;
        }

        Map<String, Integer> map = getCountMap(formula);

        List<Map.Entry<String, Integer>> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(entry);
        }

        Collections.sort(list, new EntryComparator());
        StringBuilder builder = new StringBuilder();

        for (Map.Entry<String, Integer> entry : list) {
            builder.append(entry.getKey());
            if (entry.getValue() > 1) {
                builder.append(entry.getValue());
            }
        }
        return builder.toString();
    }

    public static Map<String, Integer> getCountMap(String formula) {

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < formula.length(); i++) {
            char aChar = formula.charAt(i);

            if (aChar == '(') {
                int closingIndex = getClosingIndex(formula, i);
                int multiplicationFactor = getMultiplicationFactor(formula, closingIndex + 1); // First cahr
                                                                                               // is expected
                                                                                               // to be
                                                                                               // numeric if >
                                                                                               // 1
                Map<String, Integer> intMap = getCountMap(formula.substring(i + 1, closingIndex));

                for (Map.Entry<String, Integer> en : intMap.entrySet()) {
                    int count = map.getOrDefault(en.getKey(), 0);
                    map.put(en.getKey(), count + multiplicationFactor * en.getValue());
                }

                i = closingIndex + String.valueOf(multiplicationFactor).length();

            } else if (Character.isAlphabetic(aChar)) {
                StringBuilder b = new StringBuilder();
                b.append(aChar);
                i++;
                for (; i < formula.length(); i++) {
                    if (Character.isAlphabetic(formula.charAt(i))) {
                        if (Character.isUpperCase(formula.charAt(i)) && b.length() > 0) {
                            int count = map.getOrDefault(b.toString(), 0);
                            map.put(b.toString(), count + 1);
                            i--;
                            b = new StringBuilder();
                            break;

                        } else {
                            b.append(formula.charAt(i));
                        }
                    } else if (Character.isDigit(formula.charAt(i))) {
                        int multiplicationFactor = getMultiplicationFactor(formula, i);
                        i += String.valueOf(multiplicationFactor).length();
                        int count = map.getOrDefault(b.toString(), 0);
                        map.put(b.toString(), count + multiplicationFactor);
                        b = new StringBuilder();
                        i--;
                        break;
                    } else { // ( got opening brace
                        int count = map.getOrDefault(b.toString(), 0);
                        map.put(b.toString(), count + 1);
                        i--;
                        
                        b = new StringBuilder();
                        break;
                    }
                }
                if(b.length() > 0) {
                    int count = map.getOrDefault(b.toString(), 0);
                    map.put(b.toString(), count + 1);
                }
            }

        }
        return map;
    }

    public static int getClosingIndex(String formula, int sIndex) {
        int openings = 0;
        int i = sIndex;
        for (; i < formula.length(); i++) {
            if (formula.charAt(i) == '(') {
                openings++;
            } else if (formula.charAt(i) == ')') {
                openings--;
                if (openings == 0) {
                    break;
                }
            }
        }
        return i;
    }

    public static int getMultiplicationFactor(String formula, int sIndex) {
        if (Character.isDigit(formula.charAt(sIndex)) == false) {
            return 1;
        } else {
            int j = sIndex;
            for (; j < formula.length(); j++) {
                if (Character.isDigit(formula.charAt(j)) == false) {
                    break;
                }
                
            }

            return Integer.parseInt(formula.substring(sIndex, j));
        }
        
    }

}

class EntryComparator implements Comparator<Map.Entry<String, Integer>> {

    public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
        return e1.getKey().compareTo(e2.getKey());
    }

}
