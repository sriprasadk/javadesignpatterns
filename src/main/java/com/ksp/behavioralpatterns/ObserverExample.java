package com.ksp.behavioralpatterns;

import java.util.ArrayList;
import java.util.List;

// Subject (Publisher)
interface Subject {
    void register(Observer observer);
    void unregister(Observer observer);
    void notifyObservers();
}

// Concrete Subject
class NewspaperPublisher implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String latestEdition;

    public void setLatestEdition(String latestEdition) {
        this.latestEdition = latestEdition;
        notifyObservers();
    }

    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(latestEdition);
        }
    }
}

// Observer
interface Observer {
    void update(String latestEdition);
}

// Concrete Observer
class Subscriber implements Observer {
    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String latestEdition) {
        System.out.println("Hey " + name + "! New edition available: " + latestEdition);
    }
}

// Client
public class ObserverExample {
    public static void main(String[] args) {
        NewspaperPublisher publisher = new NewspaperPublisher();

        Observer subscriber1 = new Subscriber("Alice");
        Observer subscriber2 = new Subscriber("Bob");

        publisher.register(subscriber1);
        publisher.register(subscriber2);

        publisher.setLatestEdition("Edition 1"); // Notifies both subscribers

        publisher.unregister(subscriber1); // Unsubscribing Alice
        publisher.setLatestEdition("Edition 2"); // Notifies only Bob
    }
}
