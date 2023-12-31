package com.ksp.behavioralpatterns;
//Receiver
class Light {
 public void turnOn() {
     System.out.println("Light is on");
 }

 public void turnOff() {
     System.out.println("Light is off");
 }
}

//Command interface
interface Command {
 void execute();
}

//Concrete Command A
class TurnOnLightCommand implements Command {
 private Light light;

 public TurnOnLightCommand(Light light) {
     this.light = light;
 }

 @Override
 public void execute() {
     light.turnOn();
 }
}

//Concrete Command B
class TurnOffLightCommand implements Command {
 private Light light;

 public TurnOffLightCommand(Light light) {
     this.light = light;
 }

 @Override
 public void execute() {
     light.turnOff();
 }
}

//Invoker
class RemoteControl {
 private Command command;

 public void setCommand(Command command) {
     this.command = command;
 }

 public void pressButton() {
     command.execute();
 }
}

//Client
public class CommandExample {
 public static void main(String[] args) {
     // Receiver
     Light light = new Light();

     // Commands
     Command turnOnCommand = new TurnOnLightCommand(light);
     Command turnOffCommand = new TurnOffLightCommand(light);

     // Invoker
     RemoteControl remoteControl = new RemoteControl();

     // Using the commands through the invoker
     remoteControl.setCommand(turnOnCommand);
     remoteControl.pressButton(); // Output: Light is on

     remoteControl.setCommand(turnOffCommand);
     remoteControl.pressButton(); // Output: Light is off
 }
}

