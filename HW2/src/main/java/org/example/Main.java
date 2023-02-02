package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Main {

    @Autowired
    Document document;

    public static void main(String[] args) {
//        No Dependency injection
//        Dictionary dictionary = new OxfordDictionary();
//        SpellChecker spellChecker = new SpellChecker(dictionary);
//        Document document = new Document(spellChecker);

//        Dependency injection
        var context = new AnnotationConfigApplicationContext(AppConfig.class);

        var m = context.getBean(Main.class);
        m.document.Greet();
        m.document.spellChecker.checkSpelling();
    }
}