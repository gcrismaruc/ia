package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vlad on 1/4/2017.
 */
public class Parser {
    private BufferedReader bufferedReader;

    public List<Clause> readFile(String filepath) {
        List<Clause> clauses = new ArrayList<>();

        try {
            bufferedReader = new BufferedReader(new FileReader(filepath));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.isEmpty()) {
                    clauses.add(parseLine(line));
                }
            }

            return clauses;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Clause parseLine(String line) {
        String[] predicateStrings = line.split("OR");
        List<Predicate> predicateList = new ArrayList<>();
        Predicate predicate;
        Unifiable terms[];

        boolean isNegative = false;

        for (String predicateString : predicateStrings) {
            if (predicateString.startsWith("NOT")) {
                isNegative = true;
                predicateString = predicateString.substring(4);
            }

            String predicateSymbolAndTerms[] =  predicateString.split("\\(");

            Constant predicateSymbol = new Constant(predicateSymbolAndTerms[0].trim());
            predicateSymbolAndTerms[1] = predicateSymbolAndTerms[1].replaceAll("[)]", "");
            String termStrings[] = predicateSymbolAndTerms[1].split(",");

            terms = new Unifiable[termStrings.length];
            for (int i = 0; i < termStrings.length; ++i) {
                if (termStrings[i].equals(termStrings[i].toUpperCase())) {
                    terms[i] = new Variable(termStrings[i].trim());
                } else if (termStrings[i].length() > 1) {
                    terms[i] = new Constant(termStrings[i].trim());
                }
            }

            predicateList.add(new Predicate(predicateSymbol, isNegative, terms));
        }

        return new Clause(predicateList);
    }
}
