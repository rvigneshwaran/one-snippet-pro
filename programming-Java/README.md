# Java Concepts Showcase

This repository contains a Java program that demonstrates various concepts and features of the Java programming language. Each section of the program focuses on a specific concept, showcasing its usage and providing explanations. This readme provides an overview of the concepts covered and their respective code snippets.

## Table of Contents

1. [Variables and Constants](#variables-and-constants)
2. [Null Safety](#null-safety)
3. [Control Flow](#control-flow)
4. [Functions and Return Type](#functions-and-return-type)
5. [String Concatenation](#string-concatenation)
6. [Collections and Iteration](#collections-and-iteration)
7. [Object-Oriented Programming](#object-oriented-programming)
8. [Exception Handling](#exception-handling)
9. [Anonymous Classes](#anonymous-classes)
10. [Lambdas](#lambdas)
11. [Functional Interfaces](#functional-interfaces)
12. [Threads](#threads)
13. [Default and Static Methods in Interfaces](#default-and-static-methods-in-interfaces)
14. [Private Methods in Interfaces](#private-methods-in-interfaces)
15. [Local Variable Type Inference](#local-variable-type-inference)
16. [HTTP Client API](#http-client-api)
17. [Switch Expressions](#switch-expressions)
18. [Records](#records)
19. [Advanced Concepts](#advanced-concepts)

## Variables and Constants

Demonstrates the usage of variables and constants. It showcases the declaration and initialization of variables, as well as the usage of constants.

- `PI`: A constant variable with the value of 3.14159.
- `name`: A variable storing the name "John".

## Null Safety

Highlights the concept of null safety in Java. It demonstrates the usage of nullable variables and the importance of handling null values.

- `nullableName`: A nullable variable storing a name. (Currently set to `null`)

## Control Flow

Illustrates the usage of control flow statements, specifically `if-else` statements. It showcases the evaluation of a condition and execution of different code blocks based on the result.

- `checkAge(int age)`: A method that checks if a person is an adult or a minor based on their age.

## Functions and Return Type

Shows the creation of a method with a return type. It demonstrates the usage of parameters and the `return` statement.

- `sum(int a, int b)`: A method that calculates the sum of two integers.

## String Concatenation

Demonstrates string concatenation using the `+` operator. It showcases the merging of strings to create a new string.

- `greet(String name)`: A method that greets a person by concatenating their name with a greeting.

## Collections and Iteration

Illustrates the usage of collections and iteration. It showcases the creation of a list, adding elements to it, and iterating over the list.

- `iterateList()`: A method that creates a list of integers, adds elements to it, and iterates over the list.

## Object-Oriented Programming

Introduces the concept of object-oriented programming (OOP) in Java. It showcases the creation of classes, inheritance, and method overriding.

- `Animal` class: A base class representing an animal.
- `Cat` class: A subclass of `Animal` representing a cat. It overrides the `makeSound()` method.

## Exception Handling

Demonstrates the usage of exception handling in Java. It showcases the try-catch block to handle exceptions.

- `divide(int a, int b)`: A method that divides two integers and handles the `ArithmeticException`.

## Anonymous Classes

Introduces the concept of anonymous classes. It showcases the creation of a class without explicitly defining a separate class.

- `greetAnonymousClass()`: A method that creates an anonymous class implementing the `Runnable` interface and executes its `run()` method.

## Lambdas

Illustrates the usage of lambdas, a feature introduced in Java 8. It showcases the creation of lambda expressions to simplify code.

- `greetLambda()`: A method that creates a lambda expression representing a `Runnable` and executes its `run()` method.

## Functional Interfaces

Demonstrates the usage of functional interfaces, which are interfaces with a single abstract method. It showcases the creation and usage of functional interfaces.

- `Operation` interface: A functional interface with a method to perform an operation on two integers.
- `calculate(int a, int b, Operation operation)`: A method that performs an operation on two integers based on the provided functional interface.

## Threads

Highlights the concept of multithreading in Java. It demonstrates the creation and execution of a thread.

- `launchThread()`: A method that creates a new thread and executes its logic.

## Default and Static Methods in Interfaces

Introduces the concept of default and static methods in interfaces, which were introduced in Java 8. It showcases the usage of default and static methods in an interface.

- `Vehicle` interface: An interface with a default method `stop()` and a static method `repair()`.
- `Car` class: A class implementing the `Vehicle` interface.

## Private Methods in Interfaces

Introduces the concept of private methods in interfaces, which were introduced in Java 9. It showcases the usage of private methods in an interface.

- `Greeting` interface: An interface with a default method `sayHello()` and a private method `greet()`.
- `EnglishGreeting` class: A class implementing the `Greeting` interface.

## Local Variable Type Inference

Demonstrates the usage of local variable type inference, which was introduced in Java 10. It showcases the declaration and initialization of variables using the `var` keyword.

- `printStringLength()`: A method that declares a variable using local variable type inference and prints the length of a string.

## HTTP Client API

Illustrates the usage of the HTTP Client API, which was introduced in Java 11. It showcases the creation of an HTTP client and sending an asynchronous HTTP request.

- `sendHttpRequest()`: A method that sends an HTTP request to a specified URL using the HTTP Client API.

## Switch Expressions

Highlights the enhanced switch expressions introduced in Java 14. It showcases the usage of switch expressions to simplify code.

- `getDayOfWeek(int day)`: A method that returns the day of the week based on the provided day number using switch expressions.

## Records

Introduces the concept of records, which were introduced in Java 16. It showcases the usage of records to create immutable data classes.

- `Person` record: A record representing a person with a name and age.

## Advanced Concepts

This section demonstrates advanced concepts and features of Java.

### Generics

Illustrates the usage of generics in Java. It showcases the creation of a generic method that can work with different types.

- `printList(List<T> list)`: A generic method that prints the elements of a list.

### Streams

Demonstrates the usage of streams, a feature introduced in Java 8. It showcases the usage of streams for filtering and printing elements.

- `filterAndPrint(List<String> names)`: A method that filters names starting with 'A' using streams and prints them.

### Optional

Introduces the `Java 8: Optional` class, which provides a way to handle potentially null values more effectively. It showcases the usage of `Optional` to handle optional values.

- `processOptional(java.util.Optional<String> optionalName)`: A method that processes an optional name and prints its value if present.

## How to Use

To explore the concepts and run the program:

1. Clone this repository to your local machine.
2. Compile the Java program using a Java compiler.
3. Run the compiled program.
4. Observe the program's output, which includes the execution and results of each concept.

Feel free to modify and experiment with the code to gain a better understanding of the concepts presented.

## Further Learning

For more information on Java and its concepts, you can refer to the following resources:

- [Oracle Java Documentation](https://docs.oracle.com/en/java/)
- [Java Tutorials](https://docs.oracle.com/javase/tutorial/)
- [Java SE API Documentation](https://docs.oracle.com/en/java/javase/)

---

This Java program serves as a comprehensive showcase of various concepts and features of the Java programming language. Each section demonstrates a specific concept with accompanying code. Feel free to explore, learn, and experiment with the code to deepen your understanding of Java programming. Happy coding!
