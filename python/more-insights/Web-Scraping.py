from bs4 import BeautifulSoup as webscraper
import requests
import re as regexInstance
 
responseInstance  = requests.get("https://en.wikipedia.org/wiki/World_of_A_Song_of_Ice_and_Fire")
data = responseInstance.text
parseData = webscraper(data,"lxml")
 
 
#get the type of the parsed data
type(parseData)
 
#Find the lenth of the contends
len(parseData.contents)
 
#prettify the parsed HTML from the page and print it
print(parseData.prettify())
 
#Filters to travers the DOM Element
print(parseData.find("span", { "id" : "Maps" }).parent,"\n")
print(parseData.find("span", { "id" : "Maps" }).contents,"\n")
print(parseData.find("span", { "id" : "Maps" }).descendants,"\n")
print(parseData.find("span", { "id" : "Maps" }).next_sibling,"\n")
print(parseData.find("span", { "id" : "Maps" }).prev_sibling,"\n")
 
#find all the span elements which has the class "mw-headline" and print the text
for link in parseData.findAll("span", { "class" : "mw-headline" }):
    print(link.text)
 
#find all the elements with Id maps
print(parseData.find_all(id="Maps"))
 
# Get the title text
print(parseData.head)
print(parseData.body.b)
print(parseData.title.text)
print(parseData.title.name)
print(parseData.title.string) #A string corresponds to a bit of text within a tag.
print(parseData.title.parent.name)
print(parseData.p)
print(parseData.a)
print(parseData.get_text()) # Extract the text from the HTML Element
 
#Retrieve the contends inside a head tag
headTag = parseData.head
print(headTag.contents) #display the contends inside the head tag
 
# Using regular Expression to retrive elements
for tag in parseData.find_all(regexInstance.compile("^b")):
  print(tag.name)
 
def classWithNoId(element):
  return element.has_attr('class') and not tag.element('id')
 
print(parseData.find_all(classWithNoId))
 
#using select to find the element
print(parseData.select("body h1"))
print(parseData.select("html head title"))
print(parseData.select("div:nth-of-type(3)"))
print(parseData.select("body > h1"))
 
#find the siblings of the tags
print(parseData.select("#content ~ .mw-body"))
 
print(parseData.select("#siteNotice"))
print(parseData.select("div#siteNotice"))