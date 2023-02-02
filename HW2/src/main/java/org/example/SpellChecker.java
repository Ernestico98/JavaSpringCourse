package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SpellChecker {
    @Autowired
    @Qualifier("oxfordDictionary")
    private final Dictionary dictionary;

    public SpellChecker(OxfordDictionary dictionary) {
        this.dictionary = dictionary;
    }

    public void checkSpelling() {
        System.out.println(this.dictionary.getDictionaryName());
    }

}
