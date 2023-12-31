package com.ksp.behavioralpatterns;

import java.util.HashMap;
import java.util.Map;

// Flyweight interface
interface TextCharacter {
    void display();
}

// Concrete Flyweight
class ConcreteCharacter implements TextCharacter {
    private char character;

    public ConcreteCharacter(char character) {
        this.character = character;
    }

    @Override
    public void display() {
        System.out.print(character);
    }
}

// Flyweight Factory
class CharacterFactory {
    private Map<Character, TextCharacter> characters = new HashMap<>();

    public TextCharacter getCharacter(char c) {
        if (!characters.containsKey(c)) {
            characters.put(c, new ConcreteCharacter(c));
        }
        return characters.get(c);
    }
}

// Client
public class FlyweightExample {
    public static void main(String[] args) {
        String text = "Hello, world!";
        CharacterFactory characterFactory = new CharacterFactory();

        for (char c : text.toCharArray()) {
            TextCharacter character = characterFactory.getCharacter(c);
            character.display();
        }
    }
}

