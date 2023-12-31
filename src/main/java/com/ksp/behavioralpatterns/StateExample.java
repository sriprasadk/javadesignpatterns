package com.ksp.behavioralpatterns;

//Context
class TrafficLight {
 private State state;

 public TrafficLight() {
     state = new RedState();
 }

 public void setState(State state) {
     this.state = state;
 }

 public void request() {
     state.handleRequest(this);
 }
}

//State interface
interface State {
 void handleRequest(TrafficLight light);
}

//Concrete State A
class RedState implements State {
 @Override
 public void handleRequest(TrafficLight light) {
     System.out.println("Red Light - Stop!");
     light.setState(new GreenState());
 }
}

//Concrete State B
class GreenState implements State {
 @Override
 public void handleRequest(TrafficLight light) {
     System.out.println("Green Light - Go!");
     light.setState(new YellowState());
 }
}

//Concrete State C
class YellowState implements State {
 @Override
 public void handleRequest(TrafficLight light) {
     System.out.println("Yellow Light - Prepare to stop!");
     light.setState(new RedState());
 }
}

//Client
public class StateExample {
 public static void main(String[] args) {
     TrafficLight trafficLight = new TrafficLight();

     trafficLight.request(); // Output: Red Light - Stop!
     trafficLight.request(); // Output: Green Light - Go!
     trafficLight.request(); // Output: Yellow Light - Prepare to stop!
     trafficLight.request(); // Output: Red Light - Stop! (cycle continues)
 }
}

