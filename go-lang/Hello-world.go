package main

import (
	"bufio"
	"fmt"
	"log"
	"math"
	"os"
	"strconv"
	"time"
)

const pi = 3.14
const MAXVALUE = 3

// This is struct data type , will see this finally while closing
type NobleHouses struct {
	place     string
	houseHead string
	symbol    string
	motto     string
}

func main() {

	// the line separator key is a statement terminator
	fmt.Println("Hello world !!! ")

	// Four Types: Boolean, Numebric (Integer and Floting type), String and
	// Derived type (Pointer,Array,Structure,Union,Function,Slice,Interface,Map,Channel)

	var intSample int16 //define Signed 16-bit integers
	intSample = 40
	var averageGain, averageLoss float32 // Define Float
	averageGain = 20.02
	averageLoss = 30.03
	fmt.Println(intSample)
	fmt.Println(averageGain + averageLoss)

	// Define and Assign new variable
	stringSample := "Assign and define new variable"
	fmt.Println(stringSample)

	//Arthimatic operations
	fmt.Println("Arthimatic Operation = ", 1+1)
	//Concatination Operation
	fmt.Println("Appeinding Strings :: " + "Hello" + " World")
	fmt.Println("Float Operations :: ", 200.23/23.4)
	//Boolean
	fmt.Println("Below are three Boolean Operation with AND OR and NOR Operators")
	fmt.Println("true && false :: ", true && false)
	fmt.Println("true || false :: ", true || false)
	fmt.Println("!false :: ", !false)
	//Mathematical Operations
	fmt.Println("The Value of the pie is :: ", pi)
	//Define Constants and usage
	fmt.Println("The Sine Value of an Integer is :: ", math.Sin(24))
	//Demonstate Various Forms of For Loop
	forLoopVariants()
	// "if is Not a loop If Is a conditional clause"
	ifClauseDemo()
	//Work With time API & demonstrate Switch case
	workWithTime()

	// retrive the command line arguement details
	var serverDetailsInstance string
	tempObject := " "
	for i := 1; i < len(os.Args); i++ {
		serverDetailsInstance += tempObject + os.Args[i]
	}
	fmt.Println(serverDetailsInstance)

	// Demonstrate routines
	for i := 0; i < 10; i++ {
		count(i)
	}

	//Demonstrating Single Dimentaional Arrays
	create1DArray := func() []int {
		array := []int{0, 1, 2, 3, 4}
		return array
	}
	fmt.Println("Single Dimentiona Array :: ", create1DArray())
	//Demonstrating 3D Dimenation Arrays
	create3DArrays := func() [3][3][3]int {
		var array [3][3][3]int
		for iIndex := 0; iIndex < 3; iIndex++ {
			for jIndex := 0; jIndex < 3; jIndex++ {
				for kIndex := 0; kIndex < 3; kIndex++ {
					array[iIndex][jIndex][kIndex] = iIndex + jIndex + kIndex
				}
			}
		}
		return array
	}
	fmt.Println("Three dimentional Array :: ", create3DArrays())

	//Demonstating Map and its Functions
	constructingMap := func() {
		mapInstance := make(map[string]string)
		mapInstance["Peter_Dinklage"] = "Tyrion Lannister"
		mapInstance["Lena_Headey"] = "Cersei Lannister"
		mapInstance["Emilia_Clarke"] = "Daenerys Targaryen"
		mapInstance["Kit_Harington"] = "Jon Snow"
		fmt.Println("The values in the map are :: ", mapInstance)
		//Delete Operations in the Map
		delete(mapInstance, "Kit_Harington")
		fmt.Println("The values of the map after deletion is :: ", mapInstance)

		mapInstance1 := map[string]string{"HOUSE_STARK": "Ned", "HOUSE_LANNISTER": "Tyrion",
			"HOUSE_BARATHEON": "Robert", "HOUSE_TARGARYEN": "Daenerys"}
		fmt.Println("The Values in the map are :: ", mapInstance1)
	}

	constructingMap()
	//Demonstraction On Slices Function
	sliceInstance := make([]string, 5)
	fmt.Println(sliceInstance)
	sliceInstance[0] = "DEAL OR NO DEAL"
	sliceInstance[1] = "DOCTOR WHO"
	sliceInstance[2] = "RUBBER"
	sliceInstance[3] = "THE NAKED CIVIL SERVANT"
	sliceInstance[4] = "MONTY PYTHON'S FLYING CIRCUS"
	fmt.Println("set:", sliceInstance)
	fmt.Println(sliceInstance)
	fmt.Println("get:", sliceInstance[1])
	//Find the Length of the Slice
	fmt.Println("The length Of The Slice is ", len(sliceInstance))
	//Clone the Slice and create another instance
	clonedSlice := make([]string, len(sliceInstance))
	copy(clonedSlice, sliceInstance)
	fmt.Println("Cloned Instance :: ", clonedSlice)
	//Extracted a Range of data within Slices
	clonedSlice = sliceInstance[2:4]
	fmt.Println("Cloned Instance :: Ranged ", clonedSlice)
	//Extracting Excluding data
	clonedSlice = sliceInstance[:4]
	fmt.Println("Cloned Instance :: Excluding data", clonedSlice)
	clonedSlice = sliceInstance[2:]
	fmt.Println("Cloned Instance :: Excluding data", clonedSlice)
	//Declaring and initializaing In a Single Instance
	clonedInstance1 := []string{"Jamie", "Cersie", "Arya", "Sansa", "Tyrian", "Rob", "Nerd"}
	fmt.Println("Cloned Instance 1 :: ", clonedInstance1)

	//Ranges on Strings :: Revelas the Character Code
	stirngInstance := "Brian Stark"
	for instance := range stirngInstance {
		fmt.Println(stirngInstance[instance])
	}

	//Ranges on Sting with index
	for index, value := range "CERSIE_LANNISTER" {
		fmt.Println(index, value)
	}

	//Ranges on Slices
	sliceInstance = []string{"Cerci", "Tormen", "Joffrey", "Margaery", "Myrcella"}
	for instance1 := range sliceInstance {
		//strconv.Itoa - In order to Convert Integer in to String
		fmt.Println(strconv.Itoa(instance1) + " IS " + sliceInstance[instance1])
	}

	//Ranges on Map - Iterate using the Keys
	mapinstance := map[string]string{"Stark of Winterfell": "Rulers of The North",
		"Tully of Riverrun": "rulers of The Riverlands", "Arryn of the Eyrie": "rulers of The Vale",
		"Lannister of Casterly Rock": "rulers of The Westernlands", "Baratheon of Storm's End": "rulers of The Stormlands",
		"Tyrell of Highgarden": "rulers of The Reach", "Martell of Sunspear": "rulers of Dorne"}
	for instance2 := range mapinstance {
		fmt.Println(instance2 + " " + mapinstance[instance2])
	}

	//Ranges on Map - Iterate using the Keys and Values
	for key, value := range mapinstance {
		fmt.Println(key + " " + value)
	}

	//Pointers on simple Primitive Variables
	instanceVariable := 30
	var pointerVariable *int
	pointerVariable = &instanceVariable
	fmt.Println("The value of the Pointer Vabale is :: ", pointerVariable)
	fmt.Println("Access the variable uSing the Pointer variable:: ", *pointerVariable)

	//Pointers on Arrays
	integerArray := []int{100, 200, 300}
	var integerArrayPointer [3]*int
	for index := 0; index <= 3; index++ {
		fmt.Println("The value from the array is :: ", integerArray[index])
		integerArrayPointer[index] = &integerArray[index]
		fmt.Println("The value ", integerArray[index], " is Placed at the address :: ", integerArrayPointer[index])
	}

	// Methods and variable Arguements
	resultInstaance := performOpertaion()
	fmt.Println(resultInstaance)
	fmt.Println("The Sum of Two Elements is :: ", sumOfElements(10, 46))
	fmt.Println("The Sum of three Elements is :: ", sumOfElements(10, 46, 56))
	fmt.Println("The Sum of Four Elements is :: ", sumOfElements(10, 46, 89, 98))
	arrayOfElements := []int{10, 20, 20, 34, 12, 67, 78, 90}
	fmt.Println("The Sum of Array Elements is :: ", sumOfElements(arrayOfElements...))

	// File operations
	parseFileData("C:/Users/571695/Desktop/One-Snippet-Pro/go-lang/")

	// return two objects from a Method
	sum, product := twoOperations(21, 32)
	fmt.Println("The Sum of two numbers is :: ", strconv.Itoa(sum)+" and the product is :: ", strconv.Itoa(product))

	var houseStark NobleHouses
	var houseTargaryen NobleHouses

	// Set information in struct
	houseStark.place = "Winterfell"
	houseStark.houseHead = "Eddard (Ned) Stark"
	houseStark.symbol = "gray direwolf"
	houseStark.motto = "Winter Is Coming"

	houseTargaryen.place = "Valyria "
	houseTargaryen.houseHead = "King Aerys"
	houseTargaryen.symbol = "red three-headed dragon"
	houseTargaryen.motto = "Fire and Blood"

	// retrive struct information
	fmt.Printf(houseStark.place)
	fmt.Printf(houseTargaryen.motto)

	// pass struct information as the function paramater
	getStructData(houseStark)

	// pass struct reference as pointers to get the struct value
	getStructDataUsingPointers(&houseStark)

	name := Name("John")

	name.print() // John

}

type Name string

func (name Name) print() {
	fmt.Println(name)
}

func getStructData(nobleHouseInstace NobleHouses) {
	fmt.Printf(nobleHouseInstace.place)
	fmt.Printf(nobleHouseInstace.motto)
}

// Structures to pointers usage
func getStructDataUsingPointers(houseStark *NobleHouses) {
	fmt.Printf(houseStark.place)
	fmt.Printf(houseStark.motto)
}

// Return two Objects in a Method
func twoOperations(input1, input2 int) (sum, prod int) {
	return input1 + input2, input1 * input2
}

func forLoopVariants() {
	index := 1
	for index <= 10 {
		fmt.Println("The Valie Of index Now is :: ", index)
		index = index + 1
	}
	for mIndex := 0; mIndex <= 10; mIndex++ {
		fmt.Println("The Valie Of Index Now is :: ", mIndex)
	}
	for {
		fmt.Println("loop")
		break
	}
}

func ifClauseDemo() {
	inputValue := -17
	if inputValue < 0 {
		fmt.Println("The Input Number is Negative")
	} else if inputValue > 0 {
		fmt.Println("The Input Number Is Positive")
	} else {
		fmt.Println("The Input Number is Zero")
	}
}

func workWithTime() {
	timeInstance := time.Now()
	switch {
	case timeInstance.Hour() < 12:
		fmt.Println("Good Morning")
	default:
		fmt.Println("Good Evening")
	}
	weekdayInstance := timeInstance.Weekday()
	switch weekdayInstance {
	case time.Saturday, time.Sunday:
		fmt.Println("Happy Week End")
	default:
		fmt.Println("Work is Fun")
	}
}

func count(index int) {
	for i := 0; i < 10; i++ {
		fmt.Println(index, " :: Printing Index value :: ", i)
		time.Sleep(time.Millisecond * 1000)
	}
}

func evaluateInputs(input1 int, input2 int, operator string) (int, int, int) {
	if operator == "+" {
		return input1, input2, input1 + input2
	} else {
		return input1, input2, input1 - input2
	}
}

func sumOfElements(inputElements ...int) int {
	sum := 0
	for index := range inputElements {
		sum = sum + inputElements[index]
	}
	return sum
}

func performOpertaion() string {
	input1, input2, operationResult := evaluateInputs(10, 5, "+")
	fmt.Println(input1)
	fmt.Println(input2)
	fmt.Println(operationResult)
	input1, input2, operationResult = evaluateInputs(10, 5, "-")
	fmt.Println(input1)
	fmt.Println(input2)
	fmt.Println(operationResult)
	return "Excecuted Succesfully"
}

// Parse the contends of the file using the Reader API.
func parseFileData(fileName string) {
	file, err := os.Open(fileName)
	if err != nil {
		log.Fatal(err)
	}
	defer file.Close()
	scanner := bufio.NewScanner(file)
	for scanner.Scan() {
		fmt.Println(scanner.Text())
	}
	if err := scanner.Err(); err != nil {
		log.Fatal(err)
	}
}
