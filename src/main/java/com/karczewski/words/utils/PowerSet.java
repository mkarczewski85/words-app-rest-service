package com.karczewski.words.utils;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PowerSet {

    public static Set<String> powerSet(String s) {
        long numSubsets = 1L << s.length();
        return powerSet(s, numSubsets - 1);
    }

    private static Set<String> powerSet(String s, long active) {
        if (active < 0) {
            return new TreeSet<>();
        }

        StringBuilder subset = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (isSet(active, i)) {
                subset.append(s.charAt(i));
            }
        }
        Set<String> subsets = powerSet(s, active - 1);
        subsets.add(sort(subset));
        return subsets;
    }

    private static boolean isSet(long bits, int i) {
        return (bits & (1L << i)) != 0;
    }

    private static String sort(StringBuilder subset) {

        return Stream.of(subset.toString().split(""))
                .sorted()
                .collect(Collectors.joining());
    }

}
