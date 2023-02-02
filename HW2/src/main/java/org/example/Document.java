package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Document {

    @Autowired
    public final SpellChecker spellChecker;

    public Document(SpellChecker spellChecker) {
        this.spellChecker = spellChecker;
        System.out.println("Document is created!");
    }

    public void Greet() {
        System.out.println("Hello from Document Class");
    }

}
