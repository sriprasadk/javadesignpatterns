package com.ksp.behavioralpatterns;

//Memento
class Memento {
 private String state;

 public Memento(String stateToSave) {
     state = stateToSave;
 }

 public String getState() {
     return state;
 }
}

//Originator
class Originator {
 private String state;

 public void setState(String state) {
     this.state = state;
 }

 public String getState() {
     return state;
 }

 public Memento saveStateToMemento() {
     return new Memento(state);
 }

 public void getStateFromMemento(Memento memento) {
     state = memento.getState();
 }
}

//Caretaker
class Caretaker {
 private Memento memento;

 public void setMemento(Memento memento) {
     this.memento = memento;
 }

 public Memento getMemento() {
     return memento;
 }
}

//Client
public class MementoExample {
 public static void main(String[] args) {
     Originator originator = new Originator();
     Caretaker caretaker = new Caretaker();

     // Setting the state
     originator.setState("State 1");

     // Save the state
     caretaker.setMemento(originator.saveStateToMemento());

     // Change the state
     originator.setState("State 2");

     // Restore saved state
     originator.getStateFromMemento(caretaker.getMemento());
     System.out.println("Current State: " + originator.getState()); // Output: Current State: State 1
 }
}
