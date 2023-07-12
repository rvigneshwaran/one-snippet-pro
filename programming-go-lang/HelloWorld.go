package main

import (
	"fmt"
	"strings"
)

const (
	version = "1.2.3" // Version constant
	pi      = 3.14    // Pi constant
	maximum = 100      // Maximum constant
)

// User represents a user in the system.
type User struct {
	ID       int
	Username string
	Email    string
}

// Post represents a post in a social media platform.
type Post struct {
	ID      int
	Author  User
	Content string
	Likes   int
}

// Comment represents a comment on a post.
type Comment struct {
	ID      int
	Author  User
	Content string
}

// Product represents a product in an e-commerce platform.
type Product struct {
	ID    int
	Name  string
	Price float64
}

// Order represents an order made by a user.
type Order struct {
	ID       int
	User     User
	Products []Product
}

// Circle represents a circle shape.
type Circle struct {
	Radius float64
}

// Rectangle represents a rectangle shape.
type Rectangle struct {
	Width  float64
	Height float64
}

// Triangle represents a triangle shape.
type Triangle struct {
	Base   float64
	Height float64
}

// Shape is an interface for different shapes.
type Shape interface {
	Area() float64
	Perimeter() float64
}

// Circle methods
func (c Circle) Area() float64 {
	return 3.14 * c.Radius * c.Radius
}

func (c Circle) Perimeter() float64 {
	return 2 * 3.14 * c.Radius
}

// Rectangle methods
func (r Rectangle) Area() float64 {
	return r.Width * r.Height
}

func (r Rectangle) Perimeter() float64 {
	return 2 * (r.Width + r.Height)
}

// Triangle methods
func (t Triangle) Area() float64 {
	return 0.5 * t.Base * t.Height
}

func (t Triangle) Perimeter() float64 {
	return t.Base + 2*sqrt(t.Base*t.Base/4+t.Height*t.Height)
}

// sqrt is a helper function to calculate square root.
func sqrt(x float64) float64 {
	return x * x
}

// Library represents a library with books and members.
type Library struct {
	Name    string
	Books   []Book
	Members []User
}

// Book represents a book in the library.
type Book struct {
	Title  string
	Author string
}

// Loan represents a book loan made by a member.
type Loan struct {
	Book   Book
	Member User
	Due    string
}

// Library methods
func (l *Library) AddBook(book Book) {
	l.Books = append(l.Books, book)
}

func (l *Library) AddMember(member User) {
	l.Members = append(l.Members, member)
}

func (l *Library) DisplayBooks() {
	fmt.Println("Library Books:")
	for _, book := range l.Books {
		fmt.Printf("Title: %s, Author: %s\n", book.Title, book.Author)
	}
}

func (l *Library) DisplayMembers() {
	fmt.Println("Library Members:")
	for _, member := range l.Members {
		fmt.Printf("Username: %s, Email: %s\n", member.Username, member.Email)
	}
}

// Invoice represents an invoice for a purchase.
type Invoice struct {
	ID        int
	Customer  string
	Items     []Product
	TotalCost float64
}

// Invoice methods
func (i *Invoice) AddItem(item Product) {
	i.Items = append(i.Items, item)
	i.TotalCost += item.Price
}

func (i Invoice) PrintInvoice() {
	fmt.Println("Invoice ID:", i.ID)
	fmt.Println("Customer:", i.Customer)
	fmt.Println("Items:")
	for _, item := range i.Items {
		fmt.Printf("- %s ($%.2f)\n", item.Name, item.Price)
	}
	fmt.Println("Total Cost: $", i.TotalCost)
}

// Configuration represents the system configuration.
type Configuration struct {
	Settings map[string]string
}

// Configuration methods
func (c *Configuration) SetSetting(key, value string) {
	c.Settings[key] = value
}

func (c *Configuration) GetSetting(key string) string {
	return c.Settings[key]
}

// Task represents a task to be done.
type Task struct {
	ID       int
	Title    string
	Assignee User
	Done     bool
}

// Task methods
func (t *Task) Complete() {
	t.Done = true
}

// Post methods
func (p *Post) AddComment(comment Comment) {
	p.Comments = append(p.Comments, comment)
}

func (p Post) DisplayComments() {
	fmt.Println("Comments:")
	for _, comment := range p.Comments {
		fmt.Printf("- %s: %s\n", comment.Author.Username, comment.Content)
	}
}

// User methods
func (u *User) UpdateEmail(email string) {
	u.Email = email
}

// Product methods
func (p *Product) ApplyDiscount(percentage float64) {
	p.Price *= (1 - percentage)
}

var (
	autobots    []Transformer // Slice to store Autobots
	decepticons []Transformer // Slice to store Decepticons
)

// Transformer struct represents a Transformer with name, faction, and power attributes
type Transformer struct {
	Name    string
	Faction string
	Power   int
}

// printTransformerDetails prints the details of a given Transformer
func printTransformerDetails(t Transformer) {
	fmt.Printf("Transformer: %s\n", t.Name)
	fmt.Printf("Faction: %s\n", t.Faction)
	fmt.Printf("Power: %d\n\n", t.Power)
}

// mergeTransformers merges Autobots and Decepticons into a single slice
func mergeTransformers(autobots, decepticons []Transformer) []Transformer {
	return append(autobots, decepticons...)
}

// printAllTransformers prints the details of all Transformers
func printAllTransformers(transformers []Transformer) {
	for _, t := range transformers {
		printTransformerDetails(t)
	}
}

// countTransformers counts the total number of Transformers
func countTransformers(transformers []Transformer) int {
	return len(transformers)
}

// filterTransformers filters Transformers based on a keyword
func filterTransformers(transformers []Transformer, keyword string) []Transformer {
	var filtered []Transformer
	for _, t := range transformers {
		if strings.Contains(strings.ToLower(t.Name), keyword) {
			filtered = append(filtered, t)
		}
	}
	return filtered
}

// groupTransformersByFaction groups Transformers by faction
func groupTransformersByFaction(transformers []Transformer) map[string][]Transformer {
	groups := make(map[string][]Transformer)
	for _, t := range transformers {
		groups[t.Faction] = append(groups[t.Faction], t)
	}
	return groups
}

// printTransformersByFaction prints Transformers grouped by faction
func printTransformersByFaction(groups map[string][]Transformer) {
	for faction, transformers := range groups {
		fmt.Printf("%s Transformers:\n", faction)
		for _, t := range transformers {
			printTransformerDetails(t)
		}
	}
}

// calculateTotalPower calculates the total power of all Transformers
func calculateTotalPower(transformers []Transformer) int {
	totalPower := 0
	for _, t := range transformers {
		totalPower += t.Power
	}
	return totalPower
}

// findHighestPowerTransformer finds the Transformer with the highest power
func findHighestPowerTransformer(transformers []Transformer) Transformer {
	highestPower := 0
	var highestPowerTransformer Transformer
	for _, t := range transformers {
		if t.Power > highestPower {
			highestPower = t.Power
			highestPowerTransformer = t
		}
	}
	return highestPowerTransformer
}

// findTransformersWithMaxPower finds Transformers with the maximum power
func findTransformersWithMaxPower(transformers []Transformer) []Transformer {
	maxPower := 0
	for _, t := range transformers {
		if t.Power > maxPower {
			maxPower = t.Power
		}
	}

	var transformersWithMaxPower []Transformer
	for _, t := range transformers {
		if t.Power == maxPower {
			transformersWithMaxPower = append(transformersWithMaxPower, t)
		}
	}
	return transformersWithMaxPower
}

func main() {
	// Create instances of Transformers
	optimusPrime := Transformer{Name: "Optimus Prime", Faction: "Autobot", Power: 100}
	bumblebee := Transformer{Name: "Bumblebee", Faction: "Autobot", Power: 80}
	megatron := Transformer{Name: "Megatron", Faction: "Decepticon", Power: 95}
	starscream := Transformer{Name: "Starscream", Faction: "Decepticon", Power: 85}

	// Add Transformers to respective slices
	autobots = append(autobots, optimusPrime, bumblebee)
	decepticons = append(decepticons, megatron, starscream)

	// Print details of specific Transformers
	printTransformerDetails(optimusPrime)
	printTransformerDetails(megatron)

	// Merge Autobots and Decepticons into a single slice
	transformers := mergeTransformers(autobots, decepticons)

	// Print details of all Transformers
	printAllTransformers(transformers)

	// Count the total number of Transformers
	transformerCount := countTransformers(transformers)
	fmt.Println("Total Transformers:", transformerCount)

	// Filter Transformers based on a keyword
	filteredTransformers := filterTransformers(transformers, "bot")
	printAllTransformers(filteredTransformers)

	// Group Transformers by faction
	transformersByFaction := groupTransformersByFaction(transformers)
	printTransformersByFaction(transformersByFaction)

	// Calculate the total power of all Transformers
	powerSum := calculateTotalPower(transformers)
	fmt.Println("Total Power:", powerSum)

	// Find the Transformer with the highest power
	highestPower := findHighestPowerTransformer(transformers)
	fmt.Println("Transformer with the Highest Power:")
	printTransformerDetails(highestPower)

	// Find Transformers with the maximum power
	transformersWithMaxPower := findTransformersWithMaxPower(transformers)
	fmt.Println("Transformers with Maximum Power:")
	printAllTransformers(transformersWithMaxPower)

	// Example 1: Creating User instances
	user1 := User{ID: 1, Username: "john_doe", Email: "john@example.com"}
	user2 := User{ID: 2, Username: "jane_smith", Email: "jane@example.com"}

	// Example 2: Creating Post and Comment instances
	post := Post{ID: 1, Author: user1, Content: "Hello, world!", Likes: 10}
	comment1 := Comment{ID: 1, Author: user2, Content: "Nice post!"}
	comment2 := Comment{ID: 2, Author: user1, Content: "Thank you!"}
	post.AddComment(comment1)
	post.AddComment(comment2)

	// Example 3: Creating Product instances
	product1 := Product{ID: 1, Name: "Phone", Price: 999.99}
	product2 := Product{ID: 2, Name: "Laptop", Price: 1499.99}

	// Example 4: Creating Order instances
	order := Order{ID: 1, User: user1, Products: []Product{product1, product2}}

	// Example 5: Creating Circle, Rectangle, and Triangle instances
	circle := Circle{Radius: 5.0}
	rectangle := Rectangle{Width: 10.0, Height: 8.0}
	triangle := Triangle{Base: 6.0, Height: 4.0}

	// Example 6: Creating Library, Book, and Loan instances
	book1 := Book{Title: "1984", Author: "George Orwell"}
	book2 := Book{Title: "To Kill a Mockingbird", Author: "Harper Lee"}
	library := Library{Name: "Public Library"}
	library.AddBook(book1)
	library.AddBook(book2)
	library.AddMember(user1)
	library.AddMember(user2)

	// Example 7: Creating Invoice instance
	invoice := Invoice{ID: 1, Customer: "John Doe"}
	invoice.AddItem(product1)
	invoice.AddItem(product2)

	// Example 8: Creating Configuration instance
	configuration := Configuration{Settings: make(map[string]string)}
	configuration.SetSetting("language", "English")
	configuration.SetSetting("theme", "Dark")

	// Example 9: Creating Task instance
	task := Task{ID: 1, Title: "Write documentation", Assignee: user1}

	// Example 10: Updating struct fields and calling methods
	user1.UpdateEmail("john.doe@example.com")
	product1.ApplyDiscount(0.1)
	task.Complete()

	fmt.Println("User:", user1)
	fmt.Println("Post:", post)
	fmt.Println("Order:", order)
	fmt.Println("Circle Area:", circle.Area())
	fmt.Println("Rectangle Perimeter:", rectangle.Perimeter())
	fmt.Println("Triangle Area:", triangle.Area())
	library.DisplayBooks()
	library.DisplayMembers()
	invoice.PrintInvoice()
	fmt.Println("Language Setting:", configuration.GetSetting("language"))
	fmt.Println("Task Done:", task.Done)
}