package org.example;

import org.springframework.stereotype.Component;

@Component
public class UrbanDictionary implements Dictionary{
    @Override
    public String getDictionaryName() {
        return "UrbanDictionary";
    }
}
