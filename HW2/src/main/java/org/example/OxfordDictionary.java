package org.example;

import org.springframework.stereotype.Component;

@Component
public class OxfordDictionary implements Dictionary{
    @Override
    public String getDictionaryName() {
        return "OxfordDictionary";
    }
}
