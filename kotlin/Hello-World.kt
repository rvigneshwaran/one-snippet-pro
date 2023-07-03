// Variables and Constants
val PI = 3.14159 // Constant
var name = "John" // Variable

// Null Safety
var nullableName: String? = null

// Type Inference
val age = 25

// Control Flow
fun checkAge(age: Int) {
    if (age >= 18) {
        println("You are an adult.")
    } else {
        println("You are a minor.")
    }
}

// Function and Return Type
fun sum(a: Int, b: Int): Int {
    return a + b
}

// String Templates
fun greet(name: String) {
    println("Hello, $name!")
}

// Lambda Functions
val square: (Int) -> Int = { number -> number * number }

// Collections and Iteration
fun iterateList() {
    val numbers = listOf(1, 2, 3, 4, 5)
    for (number in numbers) {
        println(number)
    }
}

// Object-Oriented Programming
open class Animal(val name: String) {
    open fun makeSound() {
        println("The animal makes a sound.")
    }
}

class Cat(name: String) : Animal(name) {
    override fun makeSound() {
        println("Meow!")
    }
}

// Extension Functions
fun String.removeWhitespace(): String {
    return this.replace(" ", "")
}

// Exception Handling
fun divide(a: Int, b: Int): Int {
    return try {
        a / b
    } catch (e: ArithmeticException) {
        println("Cannot divide by zero!")
        -1
    }
}

// Higher-Order Functions
fun calculate(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}

// Coroutines
import kotlinx.coroutines.*

fun launchAsync() {
    println("Before coroutine")
    
    GlobalScope.launch {
        delay(1000)
        println("Inside coroutine")
    }
    
    println("After coroutine")
    Thread.sleep(2000)
}

// Data Classes
data class Person(val name: String, val age: Int)

// Companion Objects
class MyClass {
    companion object {
        fun sayHello() {
            println("Hello from companion object!")
        }
    }
}

// Sealed Classes
sealed class Result
data class Success(val data: String) : Result()
data class Error(val message: String) : Result()

fun processResult(result: Result) {
    when (result) {
        is Success -> println("Success: ${result.data}")
        is Error -> println("Error: ${result.message}")
    }
}

// Smart Casts
fun printLength(obj: Any) {
    if (obj is String) {
        println("Length: ${obj.length}")
    }
}

// Operator Overloading
data class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }
}

// Property Delegation
class Example {
    var property: String by Delegate()
}

class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name}' in $thisRef.")
    }
}

// Inline Functions
inline fun measureTime(block: () -> Unit) {
    val startTime = System.currentTimeMillis()
    block()
    val endTime = System.currentTimeMillis()
    println("Execution time: ${endTime - startTime} ms")
}

// Type Aliases
typealias CustomList = List<String>

fun processList(list: CustomList) {
    for (item in list) {
        println("Item: $item")
    }
}

// DSL (Domain-Specific Language)
data class PersonBuilder(var name: String = "", var age: Int = 0) {
    fun build(): Person {
        return Person(name, age)
    }
}

fun person(block: PersonBuilder.() -> Unit): Person {
    val personBuilder = PersonBuilder()
    personBuilder.block()
    return personBuilder.build()
}

// Enum Classes
enum class Color {
    RED, GREEN, BLUE
}

// Object Expressions
interface MyInterface {
    fun doSomething()
}

fun createObject(): MyInterface {
    return object : MyInterface {
        override fun doSomething() {
            println("Doing something...")
        }
    }
}

// Infix Functions
infix fun String.isEqual(other: String): Boolean {
    return this == other
}

// Late-Initialized Properties
class LateInitExample {
    lateinit var initializedProperty: String
    
    fun initialize() {
        initializedProperty = "Initialized"
    }
    
    fun printProperty() {
        println(initializedProperty)
    }
}

// Inline Classes
inline class PhoneNumber(val value: String)

fun call(phoneNumber: PhoneNumber) {
    println("Calling ${phoneNumber.value}")
}

// Annotations
@Target(AnnotationTarget.CLASS)
annotation class MyAnnotation

@MyAnnotation
class AnnotatedClass

// Type Checks and Casts
fun printType(obj: Any) {
    when (obj) {
        is Int -> println("Type: Int")
        is String -> println("Type: String")
        else -> println("Unknown Type")
    }
}

// Type Erasure
inline fun <reified T> checkType(value: Any) {
    if (value is T) {
        println("Value is of type ${T::class.simpleName}")
    } else {
        println("Value is not of type ${T::class.simpleName}")
    }
}

// Local Functions
fun outerFunction() {
    fun localFunction() {
        println("Local function")
    }
    
    localFunction()
}

// Ranges and Progressions
fun iterateRange() {
    for (i in 1..10) {
        println(i)
    }
}

fun main() {
    println("Pi: $PI")
    println("Name: $name")
    
    nullableName?.let { println("Nullable Name: $it") }
    
    println("Age: $age")
    
    checkAge(age)
    
    println("Sum: ${sum(5, 3)}")
    
    greet("Alice")
    
    println("Square: ${square(4)}")
    
    iterateList()
    
    val cat = Cat("Whiskers")
    cat.makeSound()
    
    val text = "Hello, World!"
    println("Text without whitespace: ${text.removeWhitespace()}")
    
    println("Result: ${divide(10, 2)}")
    
    val additionResult = calculate(5, 3) { a, b -> a + b }
    println("Addition Result: $additionResult")
    
    launchAsync()
    
    val person = Person("Alice", 30)
    println("Person: $person")
    
    MyClass.sayHello()
    
    val successResult = Success("Data")
    processResult(successResult)
    
    printLength("Hello")
    
    val point1 = Point(1, 2)
    val point2 = Point(3, 4)
    val point3 = point1 + point2
    println("Point: $point3")
    
    val example = Example()
    example.property = "Value"
    println(example.property)
    
    measureTime {
        println("Calculating...")
        Thread.sleep(1000)
        println("Done!")
    }
    
    val list: CustomList = listOf("One", "Two", "Three")
    processList(list)
    
    val customPerson = person {
        name = "Bob"
        age = 25
    }
    println("Custom Person: $customPerson")
    
    val color = Color.RED
    println("Color: $color")
    
    val obj = createObject()
    obj.doSomething()
    
    println("Hello" isEqual "Hello")
    
    val lateInitExample = LateInitExample()
    lateInitExample.initialize()
    lateInitExample.printProperty()
    
    val phoneNumber = PhoneNumber("123456789")
    call(phoneNumber)
    
    val annotatedClass = AnnotatedClass()
    println("Annotated: ${annotatedClass::class.annotations}")
    
    val value1: Any = 10
    printType(value1)
    
    checkType<String>("Hello")
    
    outerFunction()
    
    iterateRange()
}
