package com.ksp.creationalpatterns;

/**
 * The Prototype pattern involves creating new objects by copying(clone) an existing object, known as the prototype
 * @author kakar
 *
 */
//Prototype interface
interface Prototype extends Cloneable {
 Prototype clone();
 void setName(String name);
 String getName();
}

//Concrete Prototype
class ConcretePrototype implements Prototype {
 private String name;

 public void setName(String name) {
     this.name = name;
 }

 public String getName() {
     return name;
 }

 
 public Prototype clone() {
     ConcretePrototype clone = new ConcretePrototype();
     clone.setName(this.name);
     return clone;
 }
}

//Client
public class PrototypeExample {
 public static void main(String[] args) {
     ConcretePrototype original = new ConcretePrototype();
     original.setName("Original Object");

     ConcretePrototype cloned = (ConcretePrototype) original.clone();
     cloned.setName("Cloned Object");

     System.out.println("Original Object: " + original.getName());
     System.out.println("Cloned Object: " + cloned.getName());
 }
}
