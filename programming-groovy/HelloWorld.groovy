// Variables
def ironThroneOccupied = true
def rulerName = "Daenerys"

// Data Types
def age = 25
def isDragonOwner = true
def dragons = [3, 2, 1]

// Control Flow
// Method to check the age for ruling
def checkAge(age) {
    if (age >= 18) {
        println "You are old enough to rule."
    } else {
        println "You are too young to rule."
    }
}

// Functions
// Method to claim the throne
def claimThrone(claimantName) {
    return "The ruler of the Seven Kingdoms is: ${claimantName}"
}

// String Interpolation
// Method to greet the ruler
def greetRuler(name) {
    println "Hail, ${name}!"
}

// Collections and Iteration
// Method to list the dragons
def listDragons(dragons) {
    dragons.each { dragonCount ->
        println "Number of dragons: ${dragonCount}"
    }
}

// Object-Oriented Programming

// Classes and Inheritance
// Class representing a house
class House {
    def name

    // Constructor for the House class
    House(name) {
        this.name = name
    }

    // Method to display the sigil of the house
    def displaySigil() {
        println "The house displays its sigil."
    }
}

// Class representing House Stark, inheriting from House
class Stark extends House {
    // Override the displaySigil() method for House Stark
    def displaySigil() {
        println "Winter is coming!"
    }
}

// Exception Handling
// Method to conquer opponents
def conquer(opponentCount) {
    try {
        if (opponentCount <= 0) {
            throw new Exception("No opponents to conquer.")
        }
        println "Victory! The opponent count is: ${opponentCount}"
    } catch (Exception e) {
        println "Error: ${e.message}"
    }
}

// Closures
// Anonymous closure to greet
def greetAnonymous = {
    println "Greetings from an anonymous closure!"
}

// Version-Specific Snippets

// Groovy 2: Type Annotations
// Method with type annotation to gather an army
@groovy.transform.TypeChecked
def gatherArmy(int size) {
    return "Army size: ${size}"
}

// Groovy 3: Named Parameters
// Method with named parameter to plan a conquest
def planConquest(int opponentCount) {
    return "Planning the conquest with ${opponentCount} opponents."
}

// Groovy 3.0: Null-safe Operator
// Method to print a title with null-safe operator
def printTitle(String title) {
    if (title != null) {
        println "Title: ${title}"
    } else {
        println "No title available."
    }
}

// Groovy 3.0: Elvis Operator
// Set ruler to null
def ruler = null
// Use the Elvis operator to assign a default value to rulerName if ruler is null
def rulerName = ruler ?: "Unknown"
println "Current ruler: ${rulerName}"

// Groovy 4: Improved null handling with the `?` operator
// Set dragons to null
def dragons = null
// Use the null-safe operator to access the size of dragons, and assign 0 if dragons is null
println "Number of dragons: ${dragons?.size() ?: 0}"

println "Is the Iron Throne occupied? ${ironThroneOccupied ? 'Yes' : 'No'}"
println "Current ruler: ${rulerName}"

age = 25
println "Age: ${age}"

checkAge(age)

def claimThroneResult = claimThrone("Jon Snow")
println claimThroneResult

greetRuler("Cersei Lannister")

def dragons = [3, 2, 1]
listDragons(dragons)

def stark = new Stark("House Stark")
stark.displaySigil()

conquer(5)

greetAnonymous()

// Groovy 2: Multiple Assignment
def (firstName, lastName) = "Tyrion Lannister".split(" ")
println "First name: ${firstName}"
println "Last name: ${lastName}"

// Groovy 3.0: Safe Navigation Operator
def castle = null
println "Castle name: ${castle?.name ?: 'Unknown'}"

// Groovy 3.0: Switch Expressions
// Method to get the house name based on the given house
def getHouseName(house) {
    return house switch {
        "Stark" -> "Winterfell"
        "Lannister" -> "Casterly Rock"
        "Targaryen" -> "Dragonstone"
        default -> "Unknown house"
    }
}

def houseName = getHouseName("Stark")
println "House name: ${houseName}"

// Groovy 4: Records
// Define a record class for a book
record Book(String name) {}
def book = new Book("A Game of Thrones")
println "Book name: ${book.name}"

// Groovy 4: Pattern Matching
// Method to process a value and print its type
def processValue(value) {
    value.match {
        Integer i -> println "Integer value: ${i}"
        Double d -> println "Double value: ${d}"
        String s -> println "String value: ${s}"
        Boolean b -> println "Boolean value: ${b}"
        List l -> println "List value: ${l}"
        null -> println "Null value"
        default -> println "Unknown type"
    }
}

processValue(10)
processValue(3.14)
processValue("Winter is coming")
processValue(true)
processValue([1, 2, 3])
processValue(null)
println gatherArmy(100)
println planConquest(5)
printTitle("A Clash of Kings")
printTitle(null)

// Groovy 3.0: Arrow Functions
// Arrow function to greet
def greetArrow = { -> "Greetings from an arrow function!" }
println greetArrow()

class Ruler {
    String name
    int age

    // Constructor for the Ruler class
    Ruler(String name, int age) {
        this.name = name
        this.age = age
    }
}

def ruler = new Ruler("Aegon", 30)
println "Ruler: ${ruler.name}, ${ruler.age}"

// Groovy 2: ExpandoMetaClass
// Import the Expando annotation
import groovy.transform.Expando
// Define a Character class with the Expando annotation
@Expando
class Character {
    String name
}

def jonSnow = new Character()
jonSnow.name = "Jon Snow"
println "Character name: ${jonSnow.name}"

// Groovy 3: MetaClass Extensions
// Import the Extension annotation
import groovy.transform.Extension
// Define a StringExtensions class with the Extension annotation
@Extension
class StringExtensions {
    String shout() {
        return this.toUpperCase() + "!"
    }
}

def name = "Arya"
println name.shout()

// Groovy 3: New AST Transformations
// Apply the CompileStatic annotation
@groovy.transform.CompileStatic
def multiply(int a, int b) {
    return a * b
}

def result = multiply(5, 3)
println "Result: ${result}"

// Groovy 4: Fiber-based Concurrency
// Import the TimeCategory class
import groovy.time.TimeCategory

def printWithDelay(String message, int delayMillis) {
    use(TimeCategory) {
        sleep(delayMillis)
    }
    println message
}

def main = {
    println "Starting execution..."
    printWithDelay("Delayed message", 2000)
    println "Continuing execution..."
}

def fiber = main.start()

// Groovy 4: Memory Management with GC DSL
// Import the GroovyGC class
import groovy.groovygc.GroovyGC

def garbageCollector = GroovyGC.current()
garbageCollector.when {
    duration > 5.seconds
    println "Performing garbage collection..."
    garbageCollector.collect()
}

// Groovy 4: Improved AST transformations
// Apply the Builder annotation to create a builder for the Castle class
@groovy.transform.builder.Builder
class Castle {
    String name
    int rooms
    boolean isMovable

    // Constructor for the Castle class
    Castle(String name, int rooms) {
        this.name = name
        this.rooms = rooms
        this.isMovable = false
    }
}

// Use the builder to create a new instance of the Castle class
def castle = Castle.builder()
    .name("Winterfell")
    .rooms(100)
    .isMovable(true)
    .build()

println "Created castle: ${castle.name}, ${castle.rooms} rooms, movable: ${castle.isMovable}"