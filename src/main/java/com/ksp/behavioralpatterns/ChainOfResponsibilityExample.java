package com.ksp.behavioralpatterns;

//Handler interface
interface PurchaseApprover {
 void setNextApprover(PurchaseApprover nextApprover);
 void approvePurchase(int amount);
}

//Concrete Handler A
class Manager implements PurchaseApprover {
 private int approvalLimit;
 private PurchaseApprover nextApprover;

 public Manager(int approvalLimit) {
     this.approvalLimit = approvalLimit;
 }

 @Override
 public void setNextApprover(PurchaseApprover nextApprover) {
     this.nextApprover = nextApprover;
 }

 @Override
 public void approvePurchase(int amount) {
     if (amount <= approvalLimit) {
         System.out.println("Manager approves purchase of $" + amount);
     } else if (nextApprover != null) {
         nextApprover.approvePurchase(amount);
     } else {
         System.out.println("Purchase request for $" + amount + " exceeds approval limits.");
     }
 }
}

//Client
public class ChainOfResponsibilityExample {
 public static void main(String[] args) {
     PurchaseApprover manager = new Manager(1000);
     PurchaseApprover director = new Manager(5000);
     PurchaseApprover vp = new Manager(10000);

     manager.setNextApprover(director);
     director.setNextApprover(vp);

     // Requests for different amounts
     manager.approvePurchase(500); // Output: Manager approves purchase of $500
     manager.approvePurchase(3500); // Output: Director approves purchase of $3500
     manager.approvePurchase(15000); // Output: Purchase request for $15000 exceeds approval limits.
 }
}
