package com.ksp.behavioralpatterns;

import java.util.ArrayList;
import java.util.List;

// Iterator interface
interface Iterator {
    boolean hasNext();
    Object next();
}

// Aggregate interface
interface Container {
    Iterator getIterator();
}

// Concrete Iterator
class NumberIterator implements Iterator {
    private List<Integer> numbers;
    private int position;

    public NumberIterator(List<Integer> numbers) {
        this.numbers = numbers;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < numbers.size();
    }

    @Override
    public Object next() {
        if (hasNext()) {
            return numbers.get(position++);
        }
        return null;
    }
}

// Concrete Aggregate
class NumberContainer implements Container {
    private List<Integer> numbers;

    public NumberContainer() {
        numbers = new ArrayList<>();
    }

    public void addNumber(int number) {
        numbers.add(number);
    }

    @Override
    public Iterator getIterator() {
        return new NumberIterator(numbers);
    }
}

// Client
public class IteratorExample {
    public static void main(String[] args) {
        NumberContainer numberContainer = new NumberContainer();
        numberContainer.addNumber(1);
        numberContainer.addNumber(2);
        numberContainer.addNumber(3);

        Iterator iterator = numberContainer.getIterator();
        while (iterator.hasNext()) {
            System.out.println("Number: " + iterator.next());
        }
    }
}
