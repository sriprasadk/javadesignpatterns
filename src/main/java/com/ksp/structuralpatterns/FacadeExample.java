package com.ksp.structuralpatterns;

/*
 * The Facade pattern provides a simplified interface to a complex subsystem.
 */
//Subsystem component 1
class CPU {
 public void freeze() {
     System.out.println("CPU is freezing...");
 }

 public void jump(long position) {
     System.out.println("Jumping to position: " + position);
 }

 public void execute() {
     System.out.println("CPU is executing commands...");
 }
}

//Subsystem component 2
class HardDrive {
 public int read(long lba, int size) {
     System.out.println("Reading data from HDD - LBA: " + lba + ", Size: " + size);
     return size ;
 }
}

//Subsystem component 3
class Memory {
 public void load(long position, int data) {
     System.out.println("Loading data into memory at position: " + position);
 }
}

//Facade
class ComputerFacade {
 private CPU cpu;
 private Memory memory;
 private HardDrive hardDrive;

 public ComputerFacade() {
     this.cpu = new CPU();
     this.memory = new Memory();
     this.hardDrive = new HardDrive();
 }

 public void start() {
     cpu.freeze();
     memory.load(0, hardDrive.read(0, 1024));
     cpu.jump(0);
     cpu.execute();
 }
}

//Client
public class FacadeExample {
 public static void main(String[] args) {
     ComputerFacade computer = new ComputerFacade();
     computer.start();
 }
}
