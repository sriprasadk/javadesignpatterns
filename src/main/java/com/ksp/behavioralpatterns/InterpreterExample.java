package com.ksp.behavioralpatterns;

//Abstract expression interface
interface Expression {
 int interpret();
}

//Terminal expression for a number
class NumberExpression implements Expression {
 private int number;

 public NumberExpression(int number) {
     this.number = number;
 }

 @Override
 public int interpret() {
     return number;
 }
}

//Non-terminal expression for addition
class AddExpression implements Expression {
 private Expression left;
 private Expression right;

 public AddExpression(Expression left, Expression right) {
     this.left = left;
     this.right = right;
 }

 @Override
 public int interpret() {
     return left.interpret() + right.interpret();
 }
}

//Non-terminal expression for subtraction
class SubtractExpression implements Expression {
 private Expression left;
 private Expression right;

 public SubtractExpression(Expression left, Expression right) {
     this.left = left;
     this.right = right;
 }

 @Override
 public int interpret() {
     return left.interpret() - right.interpret();
 }
}

//Client
public class InterpreterExample {
 public static void main(String[] args) {
     // Constructing the expression tree: 5 + (10 - 2)
     Expression expression = new AddExpression(new NumberExpression(5),
             new SubtractExpression(new NumberExpression(10), new NumberExpression(2)));

     int result = expression.interpret();
     System.out.println("Result: " + result); // Output: 13
 }
}
