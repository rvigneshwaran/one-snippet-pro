import time; #required inorder to use time module
import calendar; #required inorder to use calender module
import math as mathInstance #user can import and rename and use the object
import os as osInstance #required inorder to use os module
import shutil as fileUtils #required in order to use high level file operations
import re as regexInstance #required in order to use regular expression
 
#Prints the content  (If you are running versions below 3)
#print "Hello, Python!"
 
#Prints the content (If you are running new version of Python)
print ("Hello World")
 
#Single and Multiline Commnets (All characters after the # and up to the end of the physical line is considered to be commented)
#print("Single line Comment")
#print("Multi Line Comment")
 
# ways of initializing the variables (5 Standard datatypes : Numbers,String,List,Tuple,Dictionary)
serialName = "Game of Thrones" #string data type
currentSeason = 7 #integer data type
averageDeathPerSeason = 177.57 #flating point datatype
gameOfThrones = aSongOfIceAndFire = createdBy = "George R. R. Martin" #multiLineAssignmnet
serialName,currentSeason,averageDeathPerSeason = " Game of Thrones ",7,177.57
 
# ways of concatinating and printing variables
print("Serial Name :: ",serialName," Current Season : ",currentSeason," Average Death Per Season : ",averageDeathPerSeason)
print(gameOfThrones,aSongOfIceAndFire)
 
# datatypes : Four types in the category numbers (int,long,float,complex)
 
# When user has multiline statements line continuation character (\) will solve the issue
total = "Game of Thrones " + \
        "used seven writers " + \
        "in six seasons"
print(total)
 
# datatypes : String
houseStark = 'EddardNedStark' #create String with single quote
houseStark = "EddardNedStark" #create String with double quote
 
#When we have multiple lines this triple quote is useful, we dont need a line contination character
houseStark = """EddardNedStark"""  #create String with triple quote
houseStark = '''EddardNedStark'''  #create String with triple quote
 
# Python allows negative indexing for its sequences,The index of -1 refers to the last item, -2 to the second last item and so on
print(houseStark)          # Prints full string
print(houseStark[0])      # Prints first character of the string
print(houseStark[-1])      # Prints last character of the string
print(houseStark[2:5])     # Prints characters starting from 3rd to 5th
print(houseStark[5:-2])   # Prints characters starting from 6th to 2nd last character
print(houseStark[2:])      # Prints string starting from 3rd character
print(houseStark * 2)     # Prints string two times
print(houseStark + "FROM WINTERFELL") # Prints concatenated string
print(houseStark * 2.5) #throws error "TypeError: string indices must be integers"
print(houseStark[125]) #throws error "IndexError: string index out of range"
print("Ned" in houseStark) #returns true if the string contains "Ned"
print("Ned" not in houseStark) #returns false as the string contains "Ned"
 
#Strings are immutable in python.
#houseStark[5] = 'a' #throws error "TypeError: 'str' object does not support item assignment"
#del my_string[1] #throws error "TypeError: 'str' object doesn't support item deletion"
 
#common python String methods
seasonOneEpisodeTwo = "the Kingsroad"
print(seasonOneEpisodeTwo.lower()) #Converts all uppercase letters in string to lowercase.
print(seasonOneEpisodeTwo.upper()) #Converts lowercase letters in string to uppercase.
print(seasonOneEpisodeTwo.split()) #Splits string according to delimiter str (space if not provided)
print("You#Win#or#You#Die".split("#")) #Splits string according to delimiter str (space if not provided)
print(" ".join(seasonOneEpisodeTwo)) #Merges (concatenates) the string representations of elements.
print(seasonOneEpisodeTwo.find('Kings')) #Determine if str occurs in string
print(seasonOneEpisodeTwo.capitalize()) #Capitalizes first letter of string
print(seasonOneEpisodeTwo.count("a")) #Counts how many times str occurs in string
print(seasonOneEpisodeTwo.endswith("road")) #Determines if string or a substring of string ends with suffix
print(seasonOneEpisodeTwo.isalnum()) #Returns true if string has at least 1 character and all characters are alphanumeric and false otherwise.
print(seasonOneEpisodeTwo.isalpha()) #Returns true if string has at least 1 character and all characters are alphabetic and false otherwise.
print(seasonOneEpisodeTwo.isdigit()) #Returns true if string contains only digits and false otherwise.
print(seasonOneEpisodeTwo.islower()) #Returns true if string has at least 1 cased character and all cased characters are in lowercase and false otherwise.
print(seasonOneEpisodeTwo.isnumeric()) #Returns true if a unicode string contains only numeric characters and false otherwise.
print(seasonOneEpisodeTwo.isspace()) #Returns true if string contains only whitespace characters and false otherwise.
print(seasonOneEpisodeTwo.istitle()) #Returns true if string is properly "titlecased" and false otherwise.
print(len(seasonOneEpisodeTwo)) #Returns the length of the string
print(max(seasonOneEpisodeTwo)) #Returns the max alphabetical character from the string seasonOneEpisodeTwo.
print(min(seasonOneEpisodeTwo)) #RReturns the min alphabetical character from the string seasonOneEpisodeTwo.
print(seasonOneEpisodeTwo.isdecimal()) #Returns true if a unicode string contains only decimal characters and false otherwise.
 
#pythonLists : similar to arrays but lists can hold items of hetrogeneous data type
listInstanceFirst = ["David Benioff & D. B. Weiss","Tim Van Patten"]
listInstanceSecond = ["Brian Kirk","Daniel Minahan","Alan Taylor"]
listConsolidated = listInstanceFirst + listInstanceSecond
nestedListInstance = ["Fire and Blood", ["Robb", "the king", "Jaime","captured by the Starks"], [10],'T'] #create a nested list
 
print(listInstanceFirst) #prints the whole list
print(listInstanceFirst[0]) #prints first element in the list
print(listInstanceFirst[-1]) #prints the last element in the list
print(listConsolidated[2:5])
print(listConsolidated[1:]) #prints from the elements starting from 2nd position
print(listConsolidated[:-5]) #prints from negining to the fourth
print(listConsolidated[:]) #prints element from beginning to the end
 
#add of delete any elements from the list
seasonOneEpisodesList = ["The Kingsroad","The Wolf and the Lion","A Golden Crown","You Win or You Die","The Pointy End",
"Baelor","Fire and Blood"]
seasonOneEpisodesList[0] = "Winter Is Coming" #insert in the respective index of the list
print(seasonOneEpisodesList)
seasonOneEpisodesList[1:4] = ["Lord Snow","Cripples, Bastards, and Broken Things"] #insert multiple items in position of the list
print(seasonOneEpisodesList)
seasonOneEpisodesList.append("The Kingsroad")
print(seasonOneEpisodesList)
seasonOneEpisodesList.append(["The Wolf and the Lion","A Golden Crown","You Win or You Die"])
print(seasonOneEpisodesList)
del seasonOneEpisodesList[0:2] # delete mltiple items in the list
print(seasonOneEpisodesList)
 
#More functions to manage a list
newListInstance = ['R','o','b','e','r','t','B','a','r','a','t','h','e','o','n']
newListInstance.remove('o') #removes the respective element from the list
print(newListInstance.pop(1)) #pops out respective element in the lisst
print(newListInstance.pop()) #pops out last element from the list
newListInstance.clear() # removes all the element from the list
print(newListInstance)
appendNewListInstance = ['H','a','m','m','e','r']
newListInstance.append(appendNewListInstance) # Add all elements of a list to the another list
print(newListInstance)
newListInstance.insert(4,appendNewListInstance) #Insert an item at the defined index
print(newListInstance)
print(appendNewListInstance.index('H')) #Returns the index of the first matched item
appendNewListInstance.sort()  #Sort items in a list in ascending order
print(appendNewListInstance)
appendNewListInstance.sort(reverse=True) #sort in descending order
print(appendNewListInstance)
newListInstance.reverse() #Reverse the order of items in the list
print(newListInstance)
print(newListInstance.copy()) #Returns a shallow copy of the list
 
#data type : Python Tuples : similar to the list but enclosed within parentheses.
# Tuple are immutable, iterating through tuple is faster than with list , write protected,
# Tuples that contain immutable elements can be used as key for a dictionary
tupleInstance = ()
tupleInstance = ("Catelyn Stark", "Sansa Stark", "Arya Stark","Robb Stark","Bran Stark")
tupleInstance = (22, "Jaime Lannister", 45)
tupleInstance = ("Viserys Targaryen", [82, 14, 63], (134, 221, 312))
tupleInstance = 3, 4.6, "Tyrion Lannister"
a, b, c = tupleInstance
print(a)
print(b)
print(c)
 
#creating tuple with one elements has a problem
tupleInstance = ("Cersei Lannister")
print(type(tupleInstance)) # this will result in the data type string <class 'str'>
tupleInstance = ("Daenerys Targaryen",)
print(type(tupleInstance)) # this will result in the data type tuple <class 'tuple'>
tupleInstance = "Jon Snow",
print(type(tupleInstance)) #this will result in the data type tuple <class 'tuple'>
# We can manage tuble as we manage the list
 
#additionals methods in a tuple
print(any(tupleInstance)) #Return True if any element of the tuple is true. If the tuple is empty, return False.
print(all(tupleInstance)) #Return True if all elements of the tuple are true (or if the tuple is empty).
print(len(tupleInstance)) #Return the length (the number of items) in the tuple.
print(max((82, 14, 63))) #Return the largest item in the tuple.
print(min((82, 14, 63))) #Return the smallest item in the tuple
print(sorted(tupleInstance)) #Take elements in the tuple and return a new sorted list (does not sort the tuple itself).
print(sum((82, 14, 63))) #             Retrun the sum of all elements in the tuple.
 
#Convert an iterable (list, string, set, dictionary) to a tuple.
print(tuple("Daenerys Targaryen"));
print(tuple(["Catelyn Stark", "Sansa Stark", "Arya Stark","Robb Stark","Bran Stark"]));
 
 
# data type : Dictionary : hash table type.
dictionaryInstance = {}
dictionaryInstance = {1: 'Winter Is Coming',2:'The Kingsroad',3:'Lord Snow'}
dictionaryInstance = {1: 'Winter Is Coming','WinterIsComing':["White Walkers","Eddard Ned Stark","Jon Arryn"
"King Robert Baratheon"]}
print(dictionaryInstance.get('WinterIsComing')) #using get to access elements
print(dictionaryInstance['WinterIsComing']) # directing acces using the key in dictionary
 
#create dictionary using the dict command
dictionaryInstance = dict({6:'A Golden Crown', 7:'You Win or You Die',8:'The Pointy End',9:'Baelor',10:'Fire and Blood'})
print(dictionaryInstance.get(7))
dictionaryInstance = dict([(4,'Cripples, Bastards, and Broken Things'), (5,'The Wolf and the Lion')])
print(dictionaryInstance[5])
# To print keys and values of the dictionary
print(dictionaryInstance.keys())   # Prints all the keys of the disctionary
print(dictionaryInstance.values()) # Prints all the values of the disctionary
 
#Arthimatic operators  a**b (exponential (power)) a//b (Floor Division)
a,b = 10,20
print(" a+b :",(a+b)," a–b :",(a-b)," a*b :",(a* b)," b/a :",(b / a)," b%a :",(b % a)," a**b :",(a**b)," a//b : ",a//b)
 
#Comparison Operators
print(" a == b :",(a == b)," a > b :",(a > b)," a < b :",(a < b)," a >= b :",(a >= b)," a <= b :",(a <= b))
 
#Bitwise Operators
print(" a & b :",(a & b)," a | b :",(a | b)," a ^ b :",(a ^ b)," ~a :",(~a)," a << 2 :",(a << 2)," a >> 2 :",(a >> 2))
 
#Membership Operators
listInstanceMem = [21,45,67,78,54,32]
print (75 in listInstanceMem) #Evaluates to true if it finds a variable in the specified sequence and false otherwise.
print (71 not in listInstanceMem) #Evaluates to true if it does not find a variable in the specified sequence and false otherwise.
 
#Identity Operators
print (a is b) #Evaluates to true if the variables on either side of the operator point to the same object and false otherwise.
print (a is not b) #Evaluates to false if the variables on either side of the operator point to the same object and true otherwise.
 
# Flow Control : if and else
# if Clause
king = "Robert Baratheon"
if king.endswith("Baratheon"):
    print("Yes,He is a baratheon")
print("This is a common block which is printed always")
 
#if else and elif
if king.endswith("Targaryen"):
    print("Yes,He is a Targaryen")
elif king.endswith("Stark"):
    print("Yes,He is a stark")
elif king.endswith("Baratheon"):
    print("Yes,He is a baratheon")
else:
    print("random people in got")
 
 
#Flow Control : for loop
stark = ["Catelyn Stark", "Sansa Stark", "Arya Stark","Robb Stark","Bran Stark"]
for indv in stark:
  print("Pointer is at :: ",indv)
 
print(range(10)) # generates sequence of numbers using range function
print(list(range(10))) # sets the range of numbers from 0 to 9 in a List and prints it
print(list(range(1,10))) # sets the range of numbers from index 1 to 9 in a List and prints it
print(list(range(2, 20, 3))) #firstParamter(2)=start,secondParamter(20)=stop,thirdParameter(3)=step
 
#using ranges to determine the length
for indv in  range(len(stark)):
  print("Pointer is at :: ",indv," value is : ",stark[indv])
 
#use for with else : "Else is executed when there is no break in the for loop"
for indv in range(len(stark)):
    print("killing :: ",stark[indv])
else:
    print("No starks left to kill !!! Red Wedding " )
 
# Flow control : While Loop
# While with optional else (The else part is executed if the condition in the while loop evaluates to False)
totalNumber,sumOfItems,index = 10,0,1
while index <= totalNumber:
    sumOfItems = sumOfItems + index
    index = index+1
else:
    print("Conditional false else")
print("The sumOfItems is", sumOfItems)
 
#Time functions
timeInstance = time.localtime(time.time())
print("Local current time :", timeInstance)
 
#Formattng Time according to the user requirement
timeInstance = time.asctime(time.localtime(time.time()) )
print("Local current time :", timeInstance)
 
#To Display calender of the respective month
calenderInstance = calendar.month(2017, 2)
print(calenderInstance)
 
# Function is a group of related statements that perform a specific task
# Function creation (def is a keyword) def functionname(parameter1,parameter2):
def greet(name):
  """This content is a docstring,generally docstrings are
     enclosed within triple quoteswhich can extend
                 up to multiple lines , this is strored in __doc__
     attribute"""
  print("Good morning ",name)
 
greet("Samwell Tarly")
 
# docstring attribute with method call
print(greet.__doc__)
 
# if we dont provide arguement to the method it results in TypeError, but we can provide default arguements
def greet(name, msg = "Good morning !!! "):
                print(msg + name)
 
greet("Samwell Tarly ","Good Noon !!! ")
greet("Samwell Tarly ")
 
#anonymous function : function without a name (represented using a keyword called lambda)
# will use the same function greet as the anonymous function
sendGreetings = lambda name : print ("Good Morning !!! ",name)
sendGreetings("Samwell Tarly ")
 
# Usage of map and Filter with anonymous functions
listRangeInstance = list(range(10))
filteredListinstance = list(filter(lambda x: (x%2 == 0),listRangeInstance))
mapListinstance = list(map(lambda x: x^2,listRangeInstance))
print("Map Applied Value ::",mapListinstance,"Filter Applied Value : ",filteredListinstance)
 
# Usage of variable arguements in a function
def sumOfItems(operation="add",*objectList):
                sum = 0
                for index in objectList :
                  sum = sum + index
                print("The Sum of all elements in the list is :: ",sum)
                #ret accessed globally from that function.
                print(globals())
                #If locals() is called from within a function, it will return all the names that can be accessed locally from that function.
                print(locals())
 
sumOfItems("add",10,20,30) # this will yield the sum as 60
sumOfItems("add",10,20,30,40) #this will yield the sum as 100
 
#Mathematical Functions
print(mathInstance.pi) #mathematical Constant
print(mathInstance.factorial(22)) # factorial of a number
print(mathInstance.sqrt(225)) #factorial of a number
print(mathInstance.isnan(22)) #check whether its a number or not
print(mathInstance.exp(2)) #exponent function
print(mathInstance.e) #mathematical Constant
 
#The dir() built-in function returns a sorted list of strings containing the names defined by a module.
print(dir(calendar))
 
#Basic File Operations and exceptions
try:
   fileInstance = open("test.txt",encoding = 'utf-8')
   #Read the file line by line
   for lineReader in fileInstance :
     print(lineReader, end = '')
 
   #method reads a file till the newline, including the newline character.
   print(fileInstance.readlines())
 
finally:
   fileInstance.close()
 
#Alternative way to open a file using "with" keyword,We don't need to explicitly call the close() method.
with open("pythonTags.txt",encoding = 'utf-8') as fileInstance:
  print(fileInstance.read()) #Read the contends in the file
  print(fileInstance.read(4)) #Read the first 4 data
  print(fileInstance.tell()) #Get the current file position
  print(fileInstance.seek(0)) #Bring the cursor to the zeroth position
  print(fileInstance.name) #get the fileName from the file instance
  print(fileInstance.closed) # to Know whethre the file is closed or not
  print(fileInstance.mode) # to Know the opening mode of the file
 
#Directory Operations
print(osInstance.getcwd()) # get the current working directory
print(osInstance.getcwdb()) # get the current working directory as byte object
#osInstance.chdir("C:\\")
#print(osInstance.getcwd()) #printing after changing the directory
print(osInstance.listdir()) # to list all the directoris and files
#osInstance.mkdir('test') #make a new directory
#osInstance.rename('test','modfied') rename a directory
#osInstance.remove('test.txt') #to remove a file
#osInstance.rmdir('modfied') #to remove a directory
#fileUtils.rmtree('test') #Delete an entire directory tree;
 
class Playaround:
  """This is a docString for class, we can access using
    __doc__ attribute"""
 
  def __init__(self,firstNum=10,secondNum=10):
                self.a = firstNum
                self.b = secondNum
 
  a,b = 20,30
 
  def add(self):
                print(a+b)
 
  def greet(self):
    print("Good Morning ,The Value of a is ",self.a,"The Value of b is ",self.b)
 
print("Playaround.a : ",Playaround.a,"Playaround.b : ",Playaround.b)
print("Playaround.add : ",Playaround.add) #call the method inside the class
print("Doc string of the class :: ",Playaround.__doc__) #display the doc string of the class
newObjectInstance = Playaround() # Object creation
print("The Value of a is ",newObjectInstance.a,"The Value of b is ",newObjectInstance.b)
print(newObjectInstance.add) #<bound method Playaround.add of <__main__.Playaround object at 0x004EA430>>
newObjectInstance.add() # method call from the object
newObjectInstance.greet() # method call from the object
 
#One More class Sample
class Targaryen:
  count = 0
 
  def __init__(self,name):
    self.name = name
    Targaryen.count += 1
 
  def displayTargaryanCount(self):
    print("The Count of the Targaryen is :: ",Targaryen.count)
 
  def displayTargaryan(self):
    print("The Targaryen is called :: ",self.name," Targaryen")
 
#Creating Objects
duncanInstance = Targaryen("Duncan")
rhaellaInstance = Targaryen("Rhaella")
aegonInstance = Targaryen("Aegon")
viserysInstance = Targaryen("Viserys")
 
#access using the object created
rhaegarInstance = Targaryen("Rhaegar")
rhaegarInstance.displayTargaryan()
 
# Manipulating attributes of an object
daenerysInstance = Targaryen("Daenerys")
print(hasattr(daenerysInstance, 'name')) # Returns true if 'name' attribute exists
print(getattr(daenerysInstance, 'name')) # Returns value of 'name' attribute
setattr(daenerysInstance, 'name', "Khaleesi") # Set attribute 'name' at Khaleesi
daenerysInstance.displayTargaryan()
#delattr(daenerysInstance, 'name') # Delete attribute 'age'
 
# Accessing the Glaobal varibale in the class
print("The Count of the Targaryen is ",Targaryen.count)
 
# More build in Attributes of the class
print("Targaryen.__doc__:", Targaryen.__doc__) #to get the class documentation
print("Targaryen.__name__:", Targaryen.__name__)  # to retrive the classname
print("Targaryen.__module__:", Targaryen.__module__) #to get the module name in which the class is defined
print("Targaryen.__dict__:", Targaryen.__dict__) #Dictionary containing the class's namespace.
 
#Inheritance #Stark Here is a Parent Class and Westeros is a Child Class
class Stark:
 
  def __init__(self,firstName,secondName):
    self.firstName = firstName
    self.secondName = secondName
 
  def displayFullName(self):
                return self.firstName + " " +  self.secondName
 
class Westeros(Stark):
 
  def __init__(self,firstName,secondName,placeName):
                Stark.__init__(self,firstName,secondName) #refer the parent class init
                self.placeName = placeName
 
  def getDetails(self):
    return "He is named :: ",self.displayFullName," from ",self.placeName
 
starkInstance = Stark("Ned","Stark")
print(starkInstance.displayFullName())
 
westerosInstance = Westeros("Catelyn","Stark","The Winterfell")
print(westerosInstance.getDetails())
 
#Regular Expression
inputLine = """Winterfell is the name given to the ancestral castle of House Stark.
It is built over a natural hot spring and the scalding water runs through the castle walls, warming halls and rooms."""
print(regexInstance.findall(r'is', inputLine)) # Find all instance of the word
matchInstance = regexInstance.search(r'is', inputLine) #Match the content any where
print(matchInstance.group(0))
#The match object can tell us the start and end indexes also here below is the sample
print(matchInstance.start())
print(matchInstance.end())
 
# parse by groups
westerosInformation = 'Essos, Climate: Mediterranean climate'
matchInstance = regexInstance.search(r'(\w+), (\w+): (\S+)', westerosInformation)
print("matchInstance.group(1) :: ",matchInstance.group(1))
print("matchInstance.group(2) :: ",matchInstance.group(2))
print("matchInstance.group(3) :: ",matchInstance.group(3))
# we can use find all with this snippet
print(regexInstance.findall(r'(\w+), (\w+): (\S+)', westerosInformation))
# we can set a name to that group and access by the name 
matchInstance = regexInstance.search(r'(?P<placeInWesteros>\w+), (?P<type>\w+): (?P<info>\S+)', westerosInformation)
print("matchInstance.group(1) :: ",matchInstance.group("placeInWesteros"))
print("matchInstance.group(2) :: ",matchInstance.group("type"))
print("matchInstance.group(3) :: ",matchInstance.group("info"))
 
# Iterators two methods __iter__() and __next__()
westerosList = ["The North ","Winterfell","The Iron Islands","The Riverlands","The Stormlands"]
iteratorInstance = iter(westerosList)
while True:
  try:
                pointer = next(iteratorInstance)
                print(pointer)
  except StopIteration:
                break