package main

import (
	"fmt"
	"strings"
	"math"
	"io/ioutil"
	"log"
	"os"
	"errors"
	"strconv"
	"flag"
	"sync"
	"time"
)

const (
	version = "1.2.3" // Version constant
	pi      = 3.14    // Pi constant
	maximum = 100      // Maximum constant
)

// Struct representing a character in the Harry Potter series
type Character struct {
	Name   string
	House  string
	Role   string
	Points int
}

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

func checkID() bool {
	fmt.Println("Checking ID...")
	return true
}

// Function to convert a string to uppercase
func toUppercase(str string) string {
	return strings.ToUpper(str)
}

// Function to reverse a string
func reverseString(str string) string {
	runes := []rune(str)
	for i, j := 0, len(runes)-1; i < j; i, j = i+1, j-1 {
		runes[i], runes[j] = runes[j], runes[i]
	}
	return string(runes)
}

// Function to check if a string is a palindrome
func isStringPalindrome(str string) bool {
	str = strings.ToLower(str)
	for i := 0; i < len(str)/2; i++ {
		if str[i] != str[len(str)-i-1] {
			return false
		}
	}
	return true
}

// Function to check if two strings are anagrams
func areStringsAnagrams(str1, str2 string) bool {
	str1 = strings.ToLower(str1)
	str2 = strings.ToLower(str2)

	if len(str1) != len(str2) {
		return false
	}

	count := make(map[rune]int)
	for _, ch := range str1 {
		count[ch]++
	}

	for _, ch := range str2 {
		if count[ch] == 0 {
			return false
		}
		count[ch]--
	}

	return true
}

// Function to count the number of words in a string
func countWordsInString(str string) int {
	fields := strings.Fields(str)
	return len(fields)
}

// Function to check if a string is a valid email address
func isValidEmailAddress(email string) bool {
	return strings.Contains(email, "@") && strings.Contains(email, ".")
}

// Function to get the ASCII codes of characters in a string
func getASCIICodes(str string) []int {
	asciiCodes := make([]int, len(str))
	for i, ch := range str {
		asciiCodes[i] = int(ch)
	}
	return asciiCodes
}

// Function to check if a string is a valid URL
func isValidURL(url string) bool {
	return strings.HasPrefix(url, "http://") || strings.HasPrefix(url, "https://")
}

// Function to remove duplicate characters from a string
func removeDuplicatesFromString(str string) string {
	uniqueChars := make(map[rune]bool)
	result := ""
	for _, ch := range str {
		if !uniqueChars[ch] {
			uniqueChars[ch] = true
			result += string(ch)
		}
	}
	return result
}

// Function to check if a string contains only letters
func isStringAlpha(str string) bool {
	for _, ch := range str {
		if !isLetter(ch) {
			return false
		}
	}
	return true
}

// Function to check if a character is a letter
func isLetter(ch rune) bool {
	return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')
}

// Function to check if a string contains only digits
func isStringNumeric(str string) bool {
	for _, ch := range str {
		if !isDigit(ch) {
			return false
		}
	}
	return true
}

// Function to check if a character is a digit
func isDigit(ch rune) bool {
	return ch >= '0' && ch <= '9'
}

// Function to check if a string contains only alphanumeric characters
func isStringAlphaNumeric(str string) bool {
	for _, ch := range str {
		if !isLetter(ch) && !isDigit(ch) {
			return false
		}
	}
	return true
}

// Function to capitalize the first letter of each word in a string
func capitalizeWords(str string) string {
	words := strings.Fields(str)
	for i, word := range words {
		words[i] = strings.Title(word)
	}
	return strings.Join(words, " ")
}

// Function to check if a string is a valid IP address
func isValidIPAddress(ip string) bool {
	parts := strings.Split(ip, ".")
	if len(parts) != 4 {
		return false
	}
	for _, part := range parts {
		num, err := strconv.Atoi(part)
		if err != nil || num < 0 || num > 255 {
			return false
		}
	}
	return true
}

// Function to trim leading and trailing zeros from a string
func trimLeadingTrailingZeros(str string) string {
	trimmed := strings.TrimLeft(str, "0")
	if trimmed == "" {
		return "0"
	}
	return trimmed
}

// Function to check if a string is a valid hexadecimal number
func isValidHexadecimal(str string) bool {
	match, _ := regexp.MatchString("^[0-9A-Fa-f]+$", str)
	return match
}

// Function to check if a string is a valid binary number
func isValidBinary(str string) bool {
	match, _ := regexp.MatchString("^[01]+$", str)
	return match
}

// Function to check if a string is a valid octal number
func isValidOctal(str string) bool {
	match, _ := regexp.MatchString("^[0-7]+$", str)
	return match
}

// Function to extract numbers from a string
func extractNumbers(str string) []int {
	numbers := make([]int, 0)
	numStr := ""
	for _, ch := range str {
		if isDigit(ch) {
			numStr += string(ch)
		} else {
			if numStr != "" {
				num, _ := strconv.Atoi(numStr)
				numbers = append(numbers, num)
				numStr = ""
			}
		}
	}
	if numStr != "" {
		num, _ := strconv.Atoi(numStr)
		numbers = append(numbers, num)
	}
	return numbers
}

// Function to extract letters from a string
func extractLetters(str string) []string {
	letters := make([]string, 0)
	for _, ch := range str {
		if isLetter(ch) {
			letters = append(letters, string(ch))
		}
	}
	return letters
}

// Function to pad a string with leading zeros
func padWithZeros(str string, length int) string {
	padLength := length - len(str)
	if padLength <= 0 {
		return str
	}
	padding := strings.Repeat("0", padLength)
	return padding + str
}

// Function to check if a string is a valid palindrome permutation
func isValidPalindromePermutation(str string) bool {
	str = strings.ReplaceAll(str, " ", "")
	str = strings.ToLower(str)

	frequency := make(map[rune]int)
	for _, ch := range str {
		frequency[ch]++
	}

	oddCount := 0
	for _, count := range frequency {
		if count%2 != 0 {
			oddCount++
		}
	}

	return oddCount <= 1
}

// Function to check if a string is a valid pangram
func isValidPangram(str string) bool {
	str = strings.ReplaceAll(str, " ", "")
	str = strings.ToLower(str)

	seen := make(map[rune]bool)
	for _, ch := range str {
		seen[ch] = true
	}

	return len(seen) == 26
}

// Function to repeat a string n times
func repeatString(str string, n int) string {
	return strings.Repeat(str, n)
}

// Function to check if a string is a valid Roman numeral
func isValidRomanNumeral(str string) bool {
	match, _ := regexp.MatchString("^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$", str)
	return match
}

// Function to check if a string is a valid IPv4 address
func isValidIPv4Address(ip string) bool {
	parts := strings.Split(ip, ".")
	if len(parts) != 4 {
		return false
	}
	for _, part := range parts {
		num, err := strconv.Atoi(part)
		if err != nil || num < 0 || num > 255 {
			return false
		}
	}
	return true
}

// Function to check if a string is a valid IPv6 address
func isValidIPv6Address(ip string) bool {
	parts := strings.Split(ip, ":")
	if len(parts) != 8 {
		return false
	}
	for _, part := range parts {
		match, _ := regexp.MatchString("^[0-9A-Fa-f]{1,4}$", part)
		if !match {
			return false
		}
	}
	return true
}

// Function to get the frequency of characters in a string
func getCharacterFrequency(str string) map[rune]int {
	frequency := make(map[rune]int)
	for _, ch := range str {
		frequency[ch]++
	}
	return frequency
}

// Function to check if a string is a valid credit card number
func isValidCreditCard(cardNumber string) bool {
	cardNumber = strings.ReplaceAll(cardNumber, "-", "")
	if len(cardNumber) < 13 || len(cardNumber) > 16 {
		return false
	}
	sum := 0
	odd := true
	for i := len(cardNumber) - 1; i >= 0; i-- {
		digit := int(cardNumber[i] - '0')
		if odd {
			digit *= 2
			if digit > 9 {
				digit = digit%10 + digit/10
			}
		}
		sum += digit
		odd = !odd
	}
	return sum%10 == 0
}

// Function to check if a string is a valid US phone number
func isValidPhoneNumber(phoneNumber string) bool {
	match, _ := regexp.MatchString("^(\\()\\d{3}(\\))\\s\\d{3}-\\d{4}$", phoneNumber)
	return match
}

// Function to check if a string is a valid social security number (SSN)
func isValidSSN(ssn string) bool {
	match, _ := regexp.MatchString("^\\d{3}-\\d{2}-\\d{4}$", ssn)
	return match
}

// Function to check if a string is a valid MAC address
func isValidMACAddress(macAddress string) bool {
	match, _ := regexp.MatchString("^([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})$", macAddress)
	return match
}

// Function to check if a string is a valid ISBN-10 or ISBN-13 number
func isValidISBN(isbn string) bool {
	isbn = strings.ReplaceAll(isbn, "-", "")
	if len(isbn) != 10 && len(isbn) != 13 {
		return false
	}

	if len(isbn) == 10 {
		sum := 0
		for i := 0; i < 9; i++ {
			digit := int(isbn[i] - '0')
			sum += digit * (10 - i)
		}
		lastDigit := int(isbn[9])
		if lastDigit == 'X' {
			lastDigit = 10
		} else {
			lastDigit -= '0'
		}
		sum += lastDigit

		return sum%11 == 0
	}

	if len(isbn) == 13 {
		sum := 0
		for i := 0; i < 12; i++ {
			digit := int(isbn[i] - '0')
			if i%2 == 0 {
				sum += digit
			} else {
				sum += digit * 3
			}
		}
		lastDigit := int(isbn[12] - '0')
		return (10-sum%10)%10 == lastDigit
	}

	return false
}

// Function to check if a string is a valid password
func isValidPassword(password string) bool {
	if len(password) < 8 || len(password) > 20 {
		return false
	}
	hasUpperCase := false
	hasLowerCase := false
	hasDigit := false
	hasSpecialChar := false
	for _, ch := range password {
		if ch >= 'A' && ch <= 'Z' {
			hasUpperCase = true
		} else if ch >= 'a' && ch <= 'z' {
			hasLowerCase = true
		} else if ch >= '0' && ch <= '9' {
			hasDigit = true
		} else if ch == '!' || ch == '@' || ch == '#' || ch == '$' || ch == '%' || ch == '^' || ch == '&' || ch == '*' {
			hasSpecialChar = true
		}
	}
	return hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar
}

// Calculates the Greatest Common Divisor (GCD) of two numbers using Euclidean algorithm.
func getGCD(a, b int) int {
	for b != 0 {
		a, b = b, a%b
	}
	return a
}

// Calculates the Least Common Multiple (LCM) of two numbers using GCD.
func getLCM(a, b int) int {
	gcd := getGCD(a, b)
	return a * b / gcd
}

// Converts a binary number to decimal.
func convertBinaryToDecimal(binary string) int {
	decimal := 0
	power := 1
	for i := len(binary) - 1; i >= 0; i-- {
		if binary[i] == '1' {
			decimal += power
		}
		power *= 2
	}
	return decimal
}

// Converts a decimal number to binary.
func convertDecimalToBinary(decimal int) string {
	binary := ""
	for decimal > 0 {
		remainder := decimal % 2
		binary = fmt.Sprintf("%d%s", remainder, binary)
		decimal /= 2
	}
	return binary
}

// Converts a hexadecimal number to decimal.
func convertHexadecimalToDecimal(hexadecimal string) int {
	decimal := 0
	power := 1
	for i := len(hexadecimal) - 1; i >= 0; i-- {
		digit := getHexadecimalDigitValue(hexadecimal[i])
		decimal += digit * power
		power *= 16
	}
	return decimal
}

// Converts a decimal number to hexadecimal.
func convertDecimalToHexadecimal(decimal int) string {
	hexadecimal := ""
	for decimal > 0 {
		remainder := decimal % 16
		hexadecimal = fmt.Sprintf("%s%s", getHexadecimalDigit(remainder), hexadecimal)
		decimal /= 16
	}
	return hexadecimal
}

// Converts an octal number to decimal.
func convertOctalToDecimal(octal string) int {
	decimal := 0
	power := 1
	for i := len(octal) - 1; i >= 0; i-- {
		digit := int(octal[i] - '0')
		decimal += digit * power
		power *= 8
	}
	return decimal
}

// Converts a decimal number to octal.
func convertDecimalToOctal(decimal int) string {
	octal := ""
	for decimal > 0 {
		remainder := decimal % 8
		octal = fmt.Sprintf("%d%s", remainder, octal)
		decimal /= 8
	}
	return octal
}

// Calculates the average of a list of numbers.
func calculateAverage(numbers []float64) float64 {
	sum := 0.0
	for _, num := range numbers {
		sum += num
	}
	return sum / float64(len(numbers))
}

// Calculates the median of a list of numbers.
func calculateMedian(numbers []float64) float64 {
	n := len(numbers)
	if n == 0 {
		return 0
	}
	sortedNumbers := make([]float64, n)
	copy(sortedNumbers, numbers)
	sort.Float64s(sortedNumbers)
	if n%2 == 0 {
		return (sortedNumbers[n/2-1] + sortedNumbers[n/2]) / 2.0
	}
	return sortedNumbers[n/2]
}

// Calculates the mode of a list of numbers.
func calculateMode(numbers []float64) []float64 {
	frequency := make(map[float64]int)
	for _, num := range numbers {
		frequency[num]++
	}
	mode := []float64{}
	maxFrequency := 0
	for num, freq := range frequency {
		if freq > maxFrequency {
			mode = []float64{num}
			maxFrequency = freq
		} else if freq == maxFrequency {
			mode = append(mode, num)
		}
	}
	return mode
}

// Calculates the standard deviation of a list of numbers.
func calculateStandardDeviation(numbers []float64) float64 {
	n := len(numbers)
	if n == 0 {
		return 0
	}
	average := calculateAverage(numbers)
	varianceSum := 0.0
	for _, num := range numbers {
		diff := num - average
		varianceSum += diff * diff
	}
	variance := varianceSum / float64(n)
	return math.Sqrt(variance)
}

// Calculates the permutation of n objects taken r at a time.
func calculatePermutation(n, r int) int {
	if n < r {
		return 0
	}
	permutation := 1
	for i := 0; i < r; i++ {
		permutation *= n - i
	}
	return permutation
}

// Calculates the combination of n objects taken r at a time.
func calculateCombination(n, r int) int {
	if n < r {
		return 0
	}
	r = min(r, n-r)
	combination := 1
	for i := 0; i < r; i++ {
		combination *= n - i
		combination /= i + 1
	}
	return combination
}

// Calculates the logarithmic exponential of a base raised to an exponent.
func calculateLogarithmicExponential(base, exponent float64) float64 {
	return math.Pow(base, exponent)
}

// Helper function to get the hexadecimal digit value.
func getHexadecimalDigitValue(digit byte) int {
	if digit >= '0' && digit <= '9' {
		return int(digit - '0')
	}
	if digit >= 'A' && digit <= 'F' {
		return int(digit-'A') + 10
	}
	if digit >= 'a' && digit <= 'f' {
		return int(digit-'a') + 10
	}
	return 0
}

// Helper function to get the hexadecimal digit.
func getHexadecimalDigit(value int) string {
	if value >= 0 && value <= 9 {
		return string(value + '0')
	}
	if value >= 10 && value <= 15 {
		return string(value-10+'A')
	}
	return ""
}

// Helper function to get the minimum of two integers.
func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

// Check if a file exists
func fileExists(filename string) bool {
	_, err := os.Stat(filename)
	return !os.IsNotExist(err)
}

// Check if a directory exists
func dirExists(dirname string) bool {
	fileInfo, err := os.Stat(dirname)
	if err != nil {
		return false
	}
	return fileInfo.IsDir()
}

// divide divides two numbers and returns the result.
// It returns an error if the divisor is zero.
func divide(dividend, divisor float64) (float64, error) {
	if divisor == 0 {
		return 0, errors.New("division by zero")
	}
	return dividend / divisor, nil
}

// InvalidAgeError represents an error indicating an invalid age.
type InvalidAgeError struct {
	Age int
}

// Error returns the error message for the InvalidAgeError.
func (e InvalidAgeError) Error() string {
	return fmt.Sprintf("Invalid age: %d", e.Age)
}

// validateAge validates the given age and returns an error if it is invalid.
func validateAge(age int) error {
	if age < 18 {
		return InvalidAgeError{Age: age}
	}
	return nil
}

// CustomError represents a custom error.
type CustomError struct {
	Message string
}

// Error returns the error message for the CustomError.
func (e CustomError) Error() string {
	return e.Message
}

// MultiError represents multiple errors.
type MultiError []error

// Error returns the error message for the MultiError.
func (e MultiError) Error() string {
	errStr := "Multiple errors occurred:"
	for _, err := range e {
		errStr += "\n- " + err.Error()
	}
	return errStr
}

// divideWithRecovery divides two numbers and recovers from a panic caused by a zero divisor.
// It returns an error if the divisor is zero or if a panic occurs.
func divideWithRecovery(dividend, divisor float64) (float64, error) {
	defer func() {
		if r := recover(); r != nil {
			err := fmt.Errorf("panic occurred: %v", r)
			fmt.Println("Recovered error:", err)
		}
	}()
	if divisor == 0 {
		panic("division by zero")
	}
	return dividend / divisor, nil
}

// processItem processes an item and returns an error if the item is invalid.
func processItem(item int) error {
	if item%2 == 0 {
		return errors.New("invalid item")
	}
	return nil
}

// ValidationErr represents a validation error with a field and message.
type ValidationErr struct {
	Field   string
	Message string
}

// Error returns the error message for the ValidationErr.
func (e ValidationErr) Error() string {
	return fmt.Sprintf("%s: %s", e.Field, e.Message)
}

// ValidationMessage returns a validation message for the ValidationErr.
func (e ValidationErr) ValidationMessage() string {
	return fmt.Sprintf("Validation error for field %s: %s", e.Field, e.Message)
}

// InvalidEmailError represents an error indicating an invalid email.
type InvalidEmailError struct {
	Email string
}

// Error returns the error message for the InvalidEmailError.
func (e InvalidEmailError) Error() string {
	return fmt.Sprintf("Invalid email: %s", e.Email)
}

// validateEmail validates the given email and returns an error if it is invalid.
func validateEmail(email string) error {
	if len(email) < 5 || email[:1] == "@" || email[len(email)-1:] == "@" {
		return InvalidEmailError{Email: email}
	}
	return nil
}

// handleAPIError handles an API error by calling the given error handler function.
// It returns an error if the error handler function returns an error.
func handleAPIError(message string, errorHandler func(error)) error {
	err := errors.New(message)
	errorHandler(err)
	return nil
}

// OpenFile opens a file with the given filename and returns it.
// It returns an error if the file cannot be opened.
func OpenFile(filename string) (string, error) {
	if filename == "" {
		return "", errors.New("filename cannot be empty")
	}
	return "file opened: " + filename, nil
}

// MultiError2 represents multiple errors using a slice.
type MultiError2 struct {
	Errors []error
}

// Error returns the error message for the MultiError2.
func (e MultiError2) Error() string {
	errStr := "Multiple errors occurred:"
	for _, err := range e.Errors {
		errStr += "\n- " + err.Error()
	}
	return errStr
}

// processWithPanic processes a request and panics if an error occurs.
// It recovers from the panic and returns it as an error.
func processWithPanic() error {
	defer func() {
		if r := recover(); r != nil {
			err := fmt.Errorf("panic occurred: %v", r)
			panic(err)
		}
	}()
	panic("Something went wrong")
}

// customHandler is a custom error handler implementation.
type customHandler struct{}

// HandleError handles an error by printing it.
func (h customHandler) HandleError(err error) {
	fmt.Println("Custom error handler:", err)
}

// handleWithHandler handles an error using the given error handler.
// It returns an error if the error handler returns an error.
func handleWithHandler(message string, errorHandler ErrorHandler) error {
	err := errors.New(message)
	errorHandler.HandleError(err)
	return nil
}

// ErrorHandler is an interface for handling errors.
type ErrorHandler interface {
	HandleError(error)
}

// customHandlerWithStack is a custom error handler implementation with stack trace.
type customHandlerWithStack struct{}

// HandleError handles an error by printing it with stack trace.
func (h customHandlerWithStack) HandleError(err error) {
	fmt.Printf("Custom error handler with stack trace: %v\n", err)
}

// processWithStack simulates a request processing and returns an error with stack trace.
func processWithStack() error {
	err := errors.New("request failed")
	return fmt.Errorf("error occurred: %w", err)
}

// ErrorType represents an error type.
type ErrorType string

const (
	// NotFoundError indicates a not found error.
	NotFoundError ErrorType = "NotFound"

	// PermissionError indicates a permission error.
	PermissionError ErrorType = "Permission"

	// ConnectionError indicates a connection error.
	ConnectionError ErrorType = "Connection"
)

// ErrorMessage returns the error message for the given error code.
func ErrorMessage(code ErrorCode) string {
	switch code {
	case 404:
		return "Not Found"
	case 403:
		return "Permission Denied"
	case 500:
		return "Internal Server Error"
	default:
		return "Unknown Error"
	}
}

// ErrorCode represents an error code.
type ErrorCode int

// User represents a user with a name.
type User struct {
	Name string
}

// Validate validates the user's name and returns an error if it is invalid.
func (u User) Validate() error {
	if u.Name == "" {
		return errors.New("name cannot be empty")
	}
	return nil
}

// handleError prints the given error.
func handleError(err error) {
	if err != nil {
		fmt.Println("Error:", err)
	}
}

func processJob(job Job) string {
	time.Sleep(500 * time.Millisecond)
	return fmt.Sprintf("Processed Job %d: %s", job.ID, job.Msg)
}

func worker(input <-chan int, output chan<- int) {
	for num := range input {
		result := num * 2
		output <- result
	}
}

func doWorkWithContext(ctx Context) {
	select {
	case <-ctx.Done():
		fmt.Println("Work canceled")
	case <-time.After(2 * time.Second):
		fmt.Println("Work completed")
	}
}

func doWorkWithContextCancellation(ctx Context) {
	for {
		select {
		case <-ctx.Done():
			fmt.Println("Work canceled")
			return
		default:
			fmt.Println("Working...")
			time.Sleep(500 * time.Millisecond)
		}
	}
}

func doWorkWithContextTimeout(ctx Context) {
	select {
	case <-ctx.Done():
		fmt.Println("Work canceled")
	case <-time.After(2 * time.Second):
		fmt.Println("Work completed")
	}
}

func doWorkWithContextDeadline(ctx Context) {
	select {
	case <-ctx.Done():
		fmt.Println("Work canceled")
	case <-time.After(2 * time.Second):
		fmt.Println("Work completed")
	}
}

func doTask(id int) {
	fmt.Println("Task", id)
	time.Sleep(500 * time.Millisecond)
}

func atomicIncrement(counter *int64) {
	atomic.AddInt64(counter, 1)
}

func processJob2(job int) int {
	time.Sleep(500 * time.Millisecond)
	return job * 2
}

func doWorkWithContextDeadlineAndCancellation(ctx Context) {
	for {
		select {
		case <-ctx.Done():
			fmt.Println("Work canceled")
			return
		default:
			fmt.Println("Working...")
			time.Sleep(500 * time.Millisecond)
		}
	}
}

func setupContextWithValue() Context {
	value := "value"
	ctx := context.WithValue(context.Background(), "key", value)
	return ctx
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

	// Example 1: Creating a slice using a composite literal
	numbers := []int{1, 2, 3, 4, 5}
	fmt.Println("Numbers:", numbers)

	// Example 2: Accessing elements of a slice
	fmt.Println("First element:", numbers[0])
	fmt.Println("Last element:", numbers[len(numbers)-1])

	// Example 3: Slicing a slice
	subSlice := numbers[1:3]
	fmt.Println("Subslice:", subSlice)

	// Example 4: Modifying the underlying array through a slice
	subSlice[0] = 10
	fmt.Println("Modified slice:", subSlice)
	fmt.Println("Original slice:", numbers)

	// Example 5: Appending elements to a slice
	numbers = append(numbers, 6, 7)
	fmt.Println("Appended slice:", numbers)

	// Example 6: Copying elements between slices
	clone := make([]int, len(numbers))
	copy(clone, numbers)
	fmt.Println("Clone:", clone)

	// Example 7: Modifying a slice with variadic append
	numbers = append(numbers, []int{8, 9, 10}...)
	fmt.Println("Variadic append:", numbers)

	// Example 8: Deleting elements from a slice
	indexToRemove := 2
	numbers = append(numbers[:indexToRemove], numbers[indexToRemove+1:]...)
	fmt.Println("Slice after deletion:", numbers)

	// Example 9: Iterating over a slice using range
	for index, value := range numbers {
		fmt.Printf("Index: %d, Value: %d\n", index, value)
	}

	// Example 10: Creating a multidimensional slice
	matrix := [][]int{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}
	fmt.Println("Matrix:", matrix)

	// Example 1: for loop with a condition
	for i := 0; i < 5; i++ {
		fmt.Println("Iteration", i)
	}

	// Example 2: for loop as a while loop
	j := 0
	for j < 5 {
		fmt.Println("Iteration", j)
		j++
	}

	// Example 3: for loop as a forever loop with a break statement
	k := 0
	for {
		if k >= 5 {
			break
		}
		fmt.Println("Iteration", k)
		k++
	}

	// Example 4: for loop with range over an array
	numbers := [5]int{1, 2, 3, 4, 5}
	for index, value := range numbers {
		fmt.Println("Index:", index, "Value:", value)
	}

	// Example 5: for loop with range over a slice
	names := []string{"Alice", "Bob", "Charlie"}
	for index, name := range names {
		fmt.Println("Index:", index, "Name:", name)
	}

	// Example 6: for loop with range over a map
	ages := map[string]int{"Alice": 25, "Bob": 30, "Charlie": 35}
	for name, age := range ages {
		fmt.Println("Name:", name, "Age:", age)
	}

	// Example 7: nested for loop for a 2D matrix
	matrix := [][]int{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}
	for i := 0; i < len(matrix); i++ {
		for j := 0; j < len(matrix[i]); j++ {
			fmt.Println("Element at [", i, "][", j, "]:", matrix[i][j])
		}
	}

	// Example 8: labeled for loop with break and continue statements
Loop:
	for i := 0; i < 3; i++ {
		for j := 0; j < 3; j++ {
			if i == 1 && j == 1 {
				continue Loop
			}
			fmt.Println("Iteration [", i, "][", j, "]")
		}
	}

	// Example 9: for loop with multiple initializations and post statements
	for i, j := 0, 10; i < 5; i, j = i+1, j-1 {
		fmt.Println("i:", i, "j:", j)
	}

	// Example 10: range loop with index omission
	colors := []string{"red", "green", "blue"}
	for _, color := range colors {
		fmt.Println("Color:", color)
	}

	// Example 11: range loop with value omission
	grades := map[string]int{"Alice": 85, "Bob": 92, "Charlie": 78}
	for name := range grades {
		fmt.Println("Name:", name)
	}

	// Example 12: for loop with conditional statements
	for i := 0; i < 10; i++ {
		if i%2 == 0 {
			fmt.Println("Even number:", i)
		} else {
			fmt.Println("Odd number:", i)
		}
	}

	// Example 13: for loop with labeled break statement
	for i := 0; i < 5; i++ {
		for j := 0; j < 5; j++ {
			if i+j == 5 {
				fmt.Println("Breaking loop at i=", i, "j=", j)
				break
			}
			fmt.Println("Iteration i=", i, "j=", j)
		}
	}

	// Example 14: for loop with labeled continue statement
	for i := 0; i < 5; i++ {
		for j := 0; j < 5; j++ {
			if i == 2 && j == 2 {
				fmt.Println("Continuing loop at i=", i, "j=", j)
				continue
			}
			fmt.Println("Iteration i=", i, "j=", j)
		}
	}

	// Example 15: for loop with early termination
	for i := 0; i < 10; i++ {
		if i > 5 {
			fmt.Println("Terminating loop at i=", i)
			break
		}
		fmt.Println("Iteration i=", i)
	}

	// Example 16: for loop with infinite loop and conditional break
	count := 0
	for {
		if count >= 10 {
			break
		}
		fmt.Println("Iteration count=", count)
		count++
	}

	// Example 17: for loop with multiple conditions
	for i, j := 0, 5; i < 5 && j > 0; i, j = i+1, j-1 {
		fmt.Println("i:", i, "j:", j)
	}

	// Example 18: for loop with a continue statement
	for i := 0; i < 10; i++ {
		if i%2 == 0 {
			continue
		}
		fmt.Println("Odd number:", i)
	}

	// Example 19: for loop with a nested break statement
	for i := 0; i < 5; i++ {
		for j := 0; j < 5; j++ {
			if i+j == 5 {
				fmt.Println("Breaking loop at i=", i, "j=", j)
				break
			}
			fmt.Println("Iteration i=", i, "j=", j)
		}
	}

	// Example 20: for loop with a nested continue statement
	for i := 0; i < 5; i++ {
		for j := 0; j < 5; j++ {
			if i == 2 && j == 2 {
				fmt.Println("Continuing loop at i=", i, "j=", j)
				continue
			}
			fmt.Println("Iteration i=", i, "j=", j)
		}
	}

	// Example 1: if statement
	num := 10
	if num > 0 {
		fmt.Println("Number is positive")
	}

	// Example 2: if-else statement
	num = -5
	if num > 0 {
		fmt.Println("Number is positive")
	} else {
		fmt.Println("Number is negative")
	}

	// Example 3: if-else if-else statement
	num = 0
	if num > 0 {
		fmt.Println("Number is positive")
	} else if num < 0 {
		fmt.Println("Number is negative")
	} else {
		fmt.Println("Number is zero")
	}

	// Example 4: nested if-else statement
	num = 15
	if num > 0 {
		if num%2 == 0 {
			fmt.Println("Number is positive and even")
		} else {
			fmt.Println("Number is positive and odd")
		}
	} else {
		fmt.Println("Number is non-positive")
	}

	// Example 5: switch statement with multiple cases
	day := "Tuesday"
	switch day {
	case "Monday":
		fmt.Println("It's Monday!")
	case "Tuesday":
		fmt.Println("It's Tuesday!")
	case "Wednesday":
		fmt.Println("It's Wednesday!")
	default:
		fmt.Println("It's another day!")
	}

	// Example 6: switch statement with fallthrough
	num = 5
	switch num {
	case 1:
		fmt.Println("Number is 1")
		fallthrough
	case 2:
		fmt.Println("Number is 2")
		fallthrough
	case 3:
		fmt.Println("Number is 3")
	default:
		fmt.Println("Number is not 1, 2, or 3")
	}

	// Example 7: switch statement with expressions
	age := 25
	switch {
	case age < 18:
		fmt.Println("You are underage")
	case age >= 18 && age < 60:
		fmt.Println("You are an adult")
	default:
		fmt.Println("You are a senior citizen")
	}

	// Example 8: switch statement with type assertions
	var data interface{}
	data = 42
	switch value := data.(type) {
	case int:
		fmt.Println("Data is an integer:", value)
	case string:
		fmt.Println("Data is a string:", value)
	default:
		fmt.Println("Data is of an unknown type")
	}

	// Example 9: conditional assignment with if-else
	temperature := 25
	var status string
	if temperature > 30 {
		status = "Hot"
	} else {
		status = "Cool"
	}
	fmt.Println("Status:", status)

	// Example 10: conditional assignment with ternary operator (Go 1.15+)
	temperature = 25
	status = "Cool"
	if temperature > 30 {
		status = "Hot"
	}
	fmt.Println("Status:", status)

	// Example 11: short-circuit evaluation with logical AND
	age = 25
	eligible := age >= 18 && checkID()
	fmt.Println("Eligible:", eligible)

	// Example 12: short-circuit evaluation with logical OR
	age = 15
	eligible = age >= 18 || checkID()
	fmt.Println("Eligible:", eligible)

	// Example 13: conditional statement with multiple conditions
	grade := 80
	if grade >= 90 {
		fmt.Println("Grade: A")
	} else if grade >= 80 && grade < 90 {
		fmt.Println("Grade: B")
	} else if grade >= 70 && grade < 80 {
		fmt.Println("Grade: C")
	} else if grade >= 60 && grade < 70 {
		fmt.Println("Grade: D")
	} else {
		fmt.Println("Grade: F")
	}

	// Example 14: conditional statement with short-circuit evaluation
	num1 := 10
	num2 := 0
	if num2 != 0 && num1/num2 > 1 {
		fmt.Println("Result:", num1/num2)
	} else {
		fmt.Println("Error: Division by zero")
	}

	// Example 15: conditional statement with switch and ranges
	score := 85
	switch {
	case score >= 90:
		fmt.Println("Grade: A")
	case score >= 80 && score < 90:
		fmt.Println("Grade: B")
	case score >= 70 && score < 80:
		fmt.Println("Grade: C")
	case score >= 60 && score < 70:
		fmt.Println("Grade: D")
	default:
		fmt.Println("Grade: F")
	}

	// Example 16: conditional statement with multiple conditions and short-circuit evaluation
	num1 = 10
	num2 = 5
	if num1 > 0 && num2 > 0 && num1+num2 > 10 {
		fmt.Println("Sum is greater than 10")
	} else {
		fmt.Println("Sum is less than or equal to 10")
	}

	// Example 17: conditional statement with multiple conditions and else if
	num1 = 5
	num2 = 10
	if num1 > 0 && num2 > 0 {
		fmt.Println("Both numbers are positive")
	} else if num1 < 0 && num2 < 0 {
		fmt.Println("Both numbers are negative")
	} else if num1 == 0 || num2 == 0 {
		fmt.Println("One of the numbers is zero")
	} else {
		fmt.Println("Numbers have mixed signs")
	}

	// Example 18: conditional statement with negation
	isRaining := false
	if !isRaining {
		fmt.Println("It is not raining")
	}

	// Example 19: conditional statement with parentheses for clarity
	num = 5
	if (num > 0 && num < 10) || num == 20 {
		fmt.Println("Number satisfies the condition")
	}

	// Example 20: conditional statement with complex conditions
	age = 25
	hasLicense := true
	if (age >= 18 && age < 60) && hasLicense {
		fmt.Println("You are eligible to drive")
	}

	// Example 1: Creating an empty map for Transformers
	autobots := make(map[string]string)
	fmt.Println("Autobots:", autobots)

	// Example 2: Adding Transformers to the map
	autobots["Optimus Prime"] = "Leader"
	autobots["Bumblebee"] = "Scout"
	autobots["Ironhide"] = "Weapons Specialist"
	fmt.Println("Autobots:", autobots)

	// Example 3: Accessing a Transformer's role
	fmt.Println("Optimus Prime is the", autobots["Optimus Prime"])

	// Example 4: Checking if a Transformer exists in the map
	_, exists := autobots["Megatron"]
	fmt.Println("Megatron exists in Autobots:", exists)

	// Example 5: Updating a Transformer's role
	autobots["Bumblebee"] = "Guardian"
	fmt.Println("Updated Autobots:", autobots)

	// Example 6: Removing a Transformer from the map
	delete(autobots, "Ironhide")
	fmt.Println("Autobots after removing Ironhide:", autobots)

	// Example 7: Counting the number of Autobots
	fmt.Println("Number of Autobots:", len(autobots))

	// Example 8: Iterating over the Autobots map
	fmt.Println("Autobots:")
	for name, role := range autobots {
		fmt.Println(name, "-", role)
	}

	// Example 9: Creating a map for Decepticons
	decepticons := map[string]string{
		"Megatron":   "Leader",
		"Starscream": "Air Commander",
		"Soundwave":  "Communications",
	}
	fmt.Println("Decepticons:", decepticons)

	// Example 10: Combining Autobots and Decepticons
	transformers := make(map[string]string)
	for name, role := range autobots {
		transformers[name] = role
	}
	for name, role := range decepticons {
		transformers[name] = role
	}
	fmt.Println("Transformers:", transformers)

	// Example 11: Clearing the Transformers map
	for key := range transformers {
		delete(transformers, key)
	}
	fmt.Println("Transformers after clearing:", transformers)

	// Example 12: Map with structs as values
	type Transformer struct {
		Name string
		Role string
	}
	transformerMap := make(map[string]Transformer)
	transformerMap["Optimus Prime"] = Transformer{Name: "Optimus Prime", Role: "Leader"}
	transformerMap["Bumblebee"] = Transformer{Name: "Bumblebee", Role: "Guardian"}
	transformerMap["Megatron"] = Transformer{Name: "Megatron", Role: "Leader"}
	fmt.Println("Transformer Map:", transformerMap)

	// Example 13: Map with functions as values
	transformerActions := make(map[string]func())
	transformerActions["Transform"] = func() {
		fmt.Println("Transforming...")
	}
	transformerActions["Attack"] = func() {
		fmt.Println("Attacking...")
	}
	transformerActions["Defend"] = func() {
		fmt.Println("Defending...")
	}
	fmt.Println("Transformer Actions:", transformerActions)

	// Example 14: Map with nested maps
	nestedMap := make(map[string]map[string]string)
	nestedMap["Autobots"] = make(map[string]string)
	nestedMap["Decepticons"] = make(map[string]string)
	nestedMap["Autobots"]["Optimus Prime"] = "Leader"
	nestedMap["Autobots"]["Bumblebee"] = "Guardian"
	nestedMap["Decepticons"]["Megatron"] = "Leader"
	nestedMap["Decepticons"]["Starscream"] = "Air Commander"
	fmt.Println("Nested Map:", nestedMap)

	// Example 15: Map with slices as values
	transformerTeams := make(map[string][]string)
	transformerTeams["Autobots"] = []string{"Optimus Prime", "Bumblebee"}
	transformerTeams["Decepticons"] = []string{"Megatron", "Starscream"}
	fmt.Println("Transformer Teams:", transformerTeams)

	// Example 16: Copying a map
	copiedMap := make(map[string]string)
	for key, value := range autobots {
		copiedMap[key] = value
	}
	fmt.Println("Copied Autobots Map:", copiedMap)

	// Example 17: Map with boolean keys
	booleanMap := make(map[bool]string)
	booleanMap[true] = "Good"
	booleanMap[false] = "Evil"
	fmt.Println("Boolean Map:", booleanMap)

	// Example 18: Map with range of keys
	rangeMap := make(map[int]string)
	for i := 1; i <= 10; i++ {
		rangeMap[i] = fmt.Sprintf("Transformer %d", i)
	}
	fmt.Println("Range Map:", rangeMap)

	// Example 19: Map with range of values
	for key, value := range rangeMap {
		rangeMap[key] = value + " is powerful"
	}
	fmt.Println("Updated Range Map:", rangeMap)

	// Example 20: Map with range and delete
	for key := range rangeMap {
		if key%2 == 0 {
			delete(rangeMap, key)
		}
	}
	fmt.Println("Range Map after deleting even keys:", rangeMap)

	// Example 21: Map with range and modify
	for key := range rangeMap {
		rangeMap[key] = "New Transformer"
	}
	fmt.Println("Modified Range Map:", rangeMap)

	// Example 22: Map with range and break
	for key, value := range rangeMap {
		fmt.Printf("Key: %d, Value: %s\n", key, value)
		if key == 5 {
			break
		}
	}

	// Example 23: Map with range and continue
	for key, value := range rangeMap {
		if key%2 == 0 {
			continue
		}
		fmt.Printf("Key: %d, Value: %s\n", key, value)
	}

	// Example 24: Map with range and nested loop
	for team, transformers := range transformerTeams {
		fmt.Println(team, "Transformers:")
		for _, transformer := range transformers {
			fmt.Println("- ", transformer)
		}
	}

	// Example 25: Map with range and switch case
	for name, role := range autobots {
		switch role {
		case "Leader":
			fmt.Printf("%s is the leader\n", name)
		case "Scout":
			fmt.Printf("%s is the scout\n", name)
		default:
			fmt.Printf("%s has the role of %s\n", name, role)
		}
	}

	// Example 26: Map with range and if-else
	for name, role := range autobots {
		if role == "Leader" {
			fmt.Printf("%s is a powerful leader\n", name)
		} else {
			fmt.Printf("%s is a skilled %s\n", name, role)
		}
	}

	// Example 27: Map with range and function call
	for name, role := range autobots {
		uppercaseName := toUppercase(name)
		fmt.Printf("%s is a %s\n", uppercaseName, role)
	}

		// Example 1: Concatenating strings using the + operator
		str1 := "Hello"
		str2 := "World"
		result := str1 + " " + str2
		fmt.Println("Example 1: Concatenation using + operator:", result)
	
		// Example 2: Getting the length of a string
		str := "Hello, World!"
		length := len(str)
		fmt.Println("Example 2: Length of a string:", length)
	
		// Example 3: Accessing individual characters in a string
		fmt.Println("Example 3: Accessing individual characters:")
		for i := 0; i < len(str); i++ {
			fmt.Printf("%c ", str[i])
		}
		fmt.Println()
	
		// Example 4: Checking if a string starts with a prefix
		fmt.Println("Example 4: Checking prefix:")
		fmt.Println(strings.HasPrefix(str, "Hello"))
	
		// Example 5: Checking if a string ends with a suffix
		fmt.Println("Example 5: Checking suffix:")
		fmt.Println(strings.HasSuffix(str, "World"))
	
		// Example 6: Checking if a string contains a substring
		fmt.Println("Example 6: Checking substring:")
		fmt.Println(strings.Contains(str, "World"))
	
		// Example 7: Counting the occurrences of a substring in a string
		fmt.Println("Example 7: Counting occurrences of substring:")
		fmt.Println(strings.Count(str, "o"))
	
		// Example 8: Finding the index of a substring in a string
		fmt.Println("Example 8: Finding index of substring:")
		fmt.Println(strings.Index(str, "World"))
	
		// Example 9: Replacing substrings in a string
		fmt.Println("Example 9: Replacing substrings:")
		newStr := strings.ReplaceAll(str, "World", "Gopher")
		fmt.Println(newStr)
	
		// Example 10: Converting a string to uppercase
		fmt.Println("Example 10: Uppercase conversion:")
		fmt.Println(strings.ToUpper(str))
	
		// Example 11: Converting a string to lowercase
		fmt.Println("Example 11: Lowercase conversion:")
		fmt.Println(strings.ToLower(str))
	
		// Example 12: Trimming whitespace from a string
		fmt.Println("Example 12: Trimming whitespace:")
		trimmedStr := strings.TrimSpace("   Hello, World!   ")
		fmt.Println(trimmedStr)
	
		// Example 13: Splitting a string into substrings based on a delimiter
		fmt.Println("Example 13: Splitting a string:")
		splitStr := strings.Split(str, ",")
		fmt.Println(splitStr)
	
		// Example 14: Joining substrings into a single string using a delimiter
		fmt.Println("Example 14: Joining substrings:")
		joinedStr := strings.Join(splitStr, "-")
		fmt.Println(joinedStr)
	
		// Example 15: Checking if a string is empty
		fmt.Println("Example 15: Checking if a string is empty:")
		emptyStr := ""
		fmt.Println(strings.TrimSpace(emptyStr) == "")
	
		// Example 16: Checking if a string is numeric
		fmt.Println("Example 16: Checking if a string is numeric:")
		numericStr := "12345"
		isNumeric := true
		for _, ch := range numericStr {
			if ch < '0' || ch > '9' {
				isNumeric = false
				break
			}
		}
		fmt.Println(isNumeric)
	
		// Example 17: Getting the substring between two indices
		fmt.Println("Example 17: Substring between indices:")
		substr := str[7:12]
		fmt.Println(substr)
	
		// Example 18: Reversing a string
		fmt.Println("Example 18: Reversing a string:")
		reversedStr := reverseString(str)
		fmt.Println(reversedStr)
	
		// Example 19: Checking if a string is a palindrome
		fmt.Println("Example 19: Checking if a string is a palindrome:")
		isPalindrome := isStringPalindrome("madam")
		fmt.Println(isPalindrome)
	
		// Example 20: Checking if a string is an anagram
		fmt.Println("Example 20: Checking if strings are anagrams:")
		isAnagram := areStringsAnagrams("listen", "silent")
		fmt.Println(isAnagram)
	
		// Example 21: Counting the words in a string
		fmt.Println("Example 21: Counting words in a string:")
		wordCount := countWordsInString("Hello, World!")
		fmt.Println(wordCount)
	
		// Example 22: Checking if a string is a valid email address
		fmt.Println("Example 22: Checking if a string is a valid email address:")
		isValidEmail := isValidEmailAddress("example@example.com")
		fmt.Println(isValidEmail)
	
		// Example 23: Getting the ASCII value of characters in a string
		fmt.Println("Example 23: ASCII values of characters:")
		asciiValues := getASCIICodes("Hello, World!")
		fmt.Println(asciiValues)
	
		// Example 24: Checking if a string is a valid URL
		fmt.Println("Example 24: Checking if a string is a valid URL:")
		isValidURL := isValidURL("https://www.example.com")
		fmt.Println(isValidURL)
	
		// Example 25: Removing duplicate characters from a string
		fmt.Println("Example 25: Removing duplicate characters:")
		uniqueStr := removeDuplicatesFromString("Hello, World!")
		fmt.Println(uniqueStr)
	
		// Example 26: Checking if a string contains only letters
		fmt.Println("Example 26: Checking if a string contains only letters:")
		isAlpha := isStringAlpha("Hello")
		fmt.Println(isAlpha)
	
		// Example 27: Checking if a string contains only digits
		fmt.Println("Example 27: Checking if a string contains only digits:")
		isNumeric = isStringNumeric("12345")
		fmt.Println(isNumeric)
	
		// Example 28: Checking if a string contains only alphanumeric characters
		fmt.Println("Example 28: Checking if a string contains only alphanumeric characters:")
		isAlphaNumeric := isStringAlphaNumeric("Hello123")
		fmt.Println(isAlphaNumeric)
	
		// Example 29: Capitalizing the first letter of each word in a string
		fmt.Println("Example 29: Capitalizing first letters of words:")
		capitalizedStr := capitalizeWords("hello, world!")
		fmt.Println(capitalizedStr)
	
		// Example 30: Checking if a string is a valid IP address
		fmt.Println("Example 30: Checking if a string is a valid IP address:")
		isValidIP := isValidIPAddress("192.168.0.1")
		fmt.Println(isValidIP)
	
		// Example 31: Removing leading and trailing zeros from a string
		fmt.Println("Example 31: Removing leading and trailing zeros:")
		trimmedZeros := trimLeadingTrailingZeros("00123.4500")
		fmt.Println(trimmedZeros)
	
		// Example 32: Checking if a string is a valid hexadecimal number
		fmt.Println("Example 32: Checking if a string is a valid hexadecimal number:")
		isValidHex := isValidHexadecimal("1A2B3C")
		fmt.Println(isValidHex)
	
		// Example 33: Checking if a string is a valid binary number
		fmt.Println("Example 33: Checking if a string is a valid binary number:")
		isValidBinary := isValidBinary("010101")
		fmt.Println(isValidBinary)
	
		// Example 34: Checking if a string is a valid octal number
		fmt.Println("Example 34: Checking if a string is a valid octal number:")
		isValidOctal := isValidOctal("01234567")
		fmt.Println(isValidOctal)
	
		// Example 35: Extracting numbers from a string
		fmt.Println("Example 35: Extracting numbers from a string:")
		numbers := extractNumbers("abc123def456ghi")
		fmt.Println(numbers)
	
		// Example 36: Extracting letters from a string
		fmt.Println("Example 36: Extracting letters from a string:")
		letters := extractLetters("abc123def456ghi")
		fmt.Println(letters)
	
		// Example 37: Padding a string with leading zeros
		fmt.Println("Example 37: Padding a string with leading zeros:")
		paddedStr := padWithZeros("42", 6)
		fmt.Println(paddedStr)
	
		// Example 38: Checking if a string is a valid palindrome permutation
		fmt.Println("Example 38: Checking if a string is a valid palindrome permutation:")
		isValidPalPerm := isValidPalindromePermutation("Tact Coa")
		fmt.Println(isValidPalPerm)
	
		// Example 39: Checking if a string is a valid pangram
		fmt.Println("Example 39: Checking if a string is a valid pangram:")
		isValidPangram := isValidPangram("The quick brown fox jumps over the lazy dog")
		fmt.Println(isValidPangram)
	
		// Example 40: Repeating a string n times
		fmt.Println("Example 40: Repeating a string:")
		repeatedStr := repeatString("Hello", 3)
		fmt.Println(repeatedStr)
	
		// Example 41: Checking if a string is a valid Roman numeral
		fmt.Println("Example 41: Checking if a string is a valid Roman numeral:")
		isValidRoman := isValidRomanNumeral("XIV")
		fmt.Println(isValidRoman)
	
		// Example 42: Checking if a string is a valid IPv4 address
		fmt.Println("Example 42: Checking if a string is a valid IPv4 address:")
		isValidIPv4 := isValidIPv4Address("192.168.0.1")
		fmt.Println(isValidIPv4)
	
		// Example 43: Checking if a string is a valid IPv6 address
		fmt.Println("Example 43: Checking if a string is a valid IPv6 address:")
		isValidIPv6 := isValidIPv6Address("2001:0db8:85a3:0000:0000:8a2e:0370:7334")
		fmt.Println(isValidIPv6)
	
		// Example 44: Getting the frequency of characters in a string
		fmt.Println("Example 44: Frequency of characters in a string:")
		charFreq := getCharacterFrequency("Hello, World!")
		fmt.Println(charFreq)
	
		// Example 45: Checking if a string is a valid credit card number
		fmt.Println("Example 45: Checking if a string is a valid credit card number:")
		isValidCreditCard := isValidCreditCard("4111-1111-1111-1111")
		fmt.Println(isValidCreditCard)
	
		// Example 46: Checking if a string is a valid US phone number
		fmt.Println("Example 46: Checking if a string is a valid US phone number:")
		isValidPhoneNumber := isValidPhoneNumber("(123) 456-7890")
		fmt.Println(isValidPhoneNumber)
	
		// Example 47: Checking if a string is a valid social security number (SSN)
		fmt.Println("Example 47: Checking if a string is a valid SSN:")
		isValidSSN := isValidSSN("123-45-6789")
		fmt.Println(isValidSSN)
	
		// Example 48: Checking if a string is a valid MAC address
		fmt.Println("Example 48: Checking if a string is a valid MAC address:")
		isValidMAC := isValidMACAddress("01:23:45:67:89:AB")
		fmt.Println(isValidMAC)
	
		// Example 49: Checking if a string is a valid ISBN-10 or ISBN-13 number
		fmt.Println("Example 49: Checking if a string is a valid ISBN number:")
		isValidISBN := isValidISBN("978-3-16-148410-0")
		fmt.Println(isValidISBN)
	
		// Example 50: Checking if a string is a valid password
		fmt.Println("Example 50: Checking if a string is a valid password:")
		isValidPassword := isValidPassword("P@ssw0rd")
		fmt.Println(isValidPassword)


		// Addition
	addition := 5 + 3
	fmt.Println("Addition:", addition)

	// Subtraction
	subtraction := 10 - 4
	fmt.Println("Subtraction:", subtraction)

	// Multiplication
	multiplication := 6 * 7
	fmt.Println("Multiplication:", multiplication)

	// Division
	division := 12 / 3
	fmt.Println("Division:", division)

	// Modulo
	modulo := 17 % 5
	fmt.Println("Modulo:", modulo)

	// Exponentiation
	exponentiation := math.Pow(2, 5)
	fmt.Println("Exponentiation:", exponentiation)

	// Square Root
	squareRoot := math.Sqrt(25)
	fmt.Println("Square Root:", squareRoot)

	// Trigonometric Functions
	angle := 30.0
	radians := angle * math.Pi / 180.0
	sine := math.Sin(radians)
	cosine := math.Cos(radians)
	tangent := math.Tan(radians)
	fmt.Printf("Trigonometric Functions (Angle: %f degrees):\n", angle)
	fmt.Println("Sine:", sine)
	fmt.Println("Cosine:", cosine)
	fmt.Println("Tangent:", tangent)

	// Logarithmic Functions
	number := 100.0
	logarithm := math.Log10(number)
	naturalLog := math.Log(number)
	fmt.Printf("Logarithmic Functions (Number: %f):\n", number)
	fmt.Println("Logarithm (base 10):", logarithm)
	fmt.Println("Natural Logarithm:", naturalLog)

	// Rounding Functions
	value := 7.6
	rounded := math.Round(value)
	ceil := math.Ceil(value)
	floor := math.Floor(value)
	fmt.Printf("Rounding Functions (Value: %f):\n", value)
	fmt.Println("Rounded:", rounded)
	fmt.Println("Ceiling:", ceil)
	fmt.Println("Floor:", floor)

	// Absolute Value
	absolute := math.Abs(-10)
	fmt.Println("Absolute Value:", absolute)

	// Minimum and Maximum
	minimum := math.Min(5, 10)
	maximum := math.Max(7, 3)
	fmt.Println("Minimum:", minimum)
	fmt.Println("Maximum:", maximum)

	// Random Number
	random := math.Rand()
	fmt.Println("Random Number:", random)

	// Factorial
	factorial := 1
	n := 5
	for i := 1; i <= n; i++ {
		factorial *= i
	}
	fmt.Printf("Factorial of %d: %d\n", n, factorial)

	// Fibonacci Series
	fibonacci := []int{0, 1}
	n = 10
	for i := 2; i <= n; i++ {
		fibonacci = append(fibonacci, fibonacci[i-1]+fibonacci[i-2])
	}
	fmt.Printf("Fibonacci Series (First %d numbers): %v\n", n, fibonacci)

	// Prime Numbers
	primeNumbers := []int{}
	limit := 100
	for i := 2; i <= limit; i++ {
		isPrime := true
		for j := 2; j <= int(math.Sqrt(float64(i))); j++ {
			if i%j == 0 {
				isPrime = false
				break
			}
		}
		if isPrime {
			primeNumbers = append(primeNumbers, i)
		}
	}
	fmt.Printf("Prime Numbers (Up to %d):\n", limit)
	fmt.Println(primeNumbers)

	// Sum of Digits
	number = 12345
	sum := 0
	for number > 0 {
		sum += number % 10
		number /= 10
	}
	fmt.Println("Sum of Digits:", sum)

	// Greatest Common Divisor (GCD)
	a := 36
	b := 48
	gcd := getGCD(a, b)
	fmt.Printf("Greatest Common Divisor of %d and %d: %d\n", a, b, gcd)

	// Least Common Multiple (LCM)
	lcm := getLCM(a, b)
	fmt.Printf("Least Common Multiple of %d and %d: %d\n", a, b, lcm)

	// Binary to Decimal Conversion
	binary := "10101"
	decimal := convertBinaryToDecimal(binary)
	fmt.Printf("Binary to Decimal Conversion (%s): %d\n", binary, decimal)

	// Decimal to Binary Conversion
	decimal = 42
	binary = convertDecimalToBinary(decimal)
	fmt.Printf("Decimal to Binary Conversion (%d): %s\n", decimal, binary)

	// Hexadecimal to Decimal Conversion
	hexadecimal := "1A"
	decimal = convertHexadecimalToDecimal(hexadecimal)
	fmt.Printf("Hexadecimal to Decimal Conversion (%s): %d\n", hexadecimal, decimal)

	// Decimal to Hexadecimal Conversion
	decimal = 26
	hexadecimal = convertDecimalToHexadecimal(decimal)
	fmt.Printf("Decimal to Hexadecimal Conversion (%d): %s\n", decimal, hexadecimal)

	// Octal to Decimal Conversion
	octal := "32"
	decimal = convertOctalToDecimal(octal)
	fmt.Printf("Octal to Decimal Conversion (%s): %d\n", octal, decimal)

	// Decimal to Octal Conversion
	decimal = 26
	octal = convertDecimalToOctal(decimal)
	fmt.Printf("Decimal to Octal Conversion (%d): %s\n", decimal, octal)

	// Average Calculation
	numbers := []float64{5, 7, 2, 9, 4}
	average := calculateAverage(numbers)
	fmt.Println("Average:", average)

	// Median Calculation
	numbers = []float64{7, 5, 9, 2, 4}
	median := calculateMedian(numbers)
	fmt.Println("Median:", median)

	// Mode Calculation
	numbers = []float64{5, 7, 2, 9, 4, 5}
	mode := calculateMode(numbers)
	fmt.Println("Mode:", mode)

	// Standard Deviation Calculation
	numbers = []float64{4, 2, 9, 5, 7}
	standardDeviation := calculateStandardDeviation(numbers)
	fmt.Println("Standard Deviation:", standardDeviation)

	// Permutation Calculation
	n = 5
	r := 3
	permutation := calculatePermutation(n, r)
	fmt.Printf("Permutation (n=%d, r=%d): %d\n", n, r, permutation)

	// Combination Calculation
	combination := calculateCombination(n, r)
	fmt.Printf("Combination (n=%d, r=%d): %d\n", n, r, combination)

	// Logarithmic Exponential Calculation
	base := 2.0
	exponent := 3.0
	logarithmicExponential := calculateLogarithmicExponential(base, exponent)
	fmt.Printf("Logarithmic Exponential (Base: %f, Exponent: %f): %f\n", base, exponent, logarithmicExponential)


	// Create a new file
	file, err := os.Create("example.txt")
	if err != nil {
		log.Fatal(err)
	}
	defer file.Close()

	// Write data to the file
	data := []byte("Hello, World!")
	_, err = file.Write(data)
	if err != nil {
		log.Fatal(err)
	}

	// Read data from the file
	readData, err := ioutil.ReadFile("example.txt")
	if err != nil {
		log.Fatal(err)
	}
	fmt.Println("Read data:", string(readData))

	// Rename the file
	err = os.Rename("example.txt", "new_example.txt")
	if err != nil {
		log.Fatal(err)
	}

	// Check if a file exists
	exists := fileExists("new_example.txt")
	fmt.Println("File exists:", exists)

	// Get file information
	fileInfo, err := os.Stat("new_example.txt")
	if err != nil {
		log.Fatal(err)
	}
	fmt.Println("File name:", fileInfo.Name())
	fmt.Println("File size:", fileInfo.Size())
	fmt.Println("Is directory:", fileInfo.IsDir())
	fmt.Println("File mode:", fileInfo.Mode())
	fmt.Println("Last modified:", fileInfo.ModTime())

	// Remove the file
	err = os.Remove("new_example.txt")
	if err != nil {
		log.Fatal(err)
	}

	// Create a new directory
	err = os.Mkdir("example_dir", 0755)
	if err != nil {
		log.Fatal(err)
	}

	// Rename the directory
	err = os.Rename("example_dir", "new_example_dir")
	if err != nil {
		log.Fatal(err)
	}

	// Get directory information
	dirInfo, err := os.Stat("new_example_dir")
	if err != nil {
		log.Fatal(err)
	}
	fmt.Println("Directory name:", dirInfo.Name())
	fmt.Println("Is directory:", dirInfo.IsDir())
	fmt.Println("Directory mode:", dirInfo.Mode())
	fmt.Println("Last modified:", dirInfo.ModTime())

	// Remove the directory
	err = os.Remove("new_example_dir")
	if err != nil {
		log.Fatal(err)
	}

	// List files in a directory
	files, err := ioutil.ReadDir(".")
	if err != nil {
		log.Fatal(err)
	}
	fmt.Println("Files in current directory:")
	for _, f := range files {
		fmt.Println(f.Name())
	}

	// Open a file for reading
	readFile, err := os.Open("example.txt")
	if err != nil {
		log.Fatal(err)
	}
	defer readFile.Close()

	// Read file content using a buffer
	buffer := make([]byte, 1024)
	bytesRead, err := readFile.Read(buffer)
	if err != nil {
		log.Fatal(err)
	}
	fmt.Println("Read bytes:", string(buffer[:bytesRead]))

	// Write data to a file using a buffer
	writeFile, err := os.Create("example_write.txt")
	if err != nil {
		log.Fatal(err)
	}
	defer writeFile.Close()
	bufferData := []byte("Buffered write example")
	bytesWritten, err := writeFile.Write(bufferData)
	if err != nil {
		log.Fatal(err)
	}
	fmt.Println("Bytes written:", bytesWritten)

	// Append data to a file
	appendFile, err := os.OpenFile("example_write.txt", os.O_APPEND|os.O_WRONLY, 0644)
	if err != nil {
		log.Fatal(err)
	}
	defer appendFile.Close()
	appendData := []byte(" Appended data")
	_, err = appendFile.Write(appendData)
	if err != nil {
		log.Fatal(err)
	}

	// Read file content line by line
	lineFile, err := os.Open("example.txt")
	if err != nil {
		log.Fatal(err)
	}
	defer lineFile.Close()
	scanner := bufio.NewScanner(lineFile)
	for scanner.Scan() {
		line := scanner.Text()
		fmt.Println("Line:", line)
	}
	if err := scanner.Err(); err != nil {
		log.Fatal(err)
	}

	// Copy file content to another file
	srcFile, err := os.Open("example.txt")
	if err != nil {
		log.Fatal(err)
	}
	defer srcFile.Close()
	destFile, err := os.Create("example_copy.txt")
	if err != nil {
		log.Fatal(err)
	}
	defer destFile.Close()
	bytesCopied, err := io.Copy(destFile, srcFile)
	if err != nil {
		log.Fatal(err)
	}
	fmt.Println("Bytes copied:", bytesCopied)

	// Check if a directory exists
	dirExists := dirExists("example_dir")
	fmt.Println("Directory exists:", dirExists)

	// Read a CSV file
	csvFile, err := os.Open("data.csv")
	if err != nil {
		log.Fatal(err)
	}
	defer csvFile.Close()
	reader := csv.NewReader(csvFile)
	records, err := reader.ReadAll()
	if err != nil {
		log.Fatal(err)
	}
	fmt.Println("CSV records:")
	for _, record := range records {
		fmt.Println(record)
	}

	// Write data to a CSV file
	csvData := [][]string{
		{"Name", "Age", "City"},
		{"John", "25", "New York"},
		{"Alice", "30", "London"},
		{"Bob", "35", "Paris"},
	}
	csvWriteFile, err := os.Create("data_write.csv")
	if err != nil {
		log.Fatal(err)
	}
	defer csvWriteFile.Close()
	writer := csv.NewWriter(csvWriteFile)
	for _, record := range csvData {
		err := writer.Write(record)
		if err != nil {
			log.Fatal(err)
		}
	}
	writer.Flush()
	if err := writer.Error(); err != nil {
		log.Fatal(err)
	}

	// Create a Character pointer
	var harry *Character

	// Assign values to the fields using the pointer
	harry = &Character{
		Name:   "Harry Potter",
		House:  "Gryffindor",
		Role:   "Student",
		Points: 100,
	}

	// Access and modify fields using the pointer
	harry.Role = "Auror"
	harry.Points += 50

	// Print the character's details
	fmt.Printf("Name: %s\n", harry.Name)
	fmt.Printf("House: %s\n", harry.House)
	fmt.Printf("Role: %s\n", harry.Role)
	fmt.Printf("Points: %d\n", harry.Points)

	// Create a pointer to an integer
	var numPtr *int

	// Create an integer variable and assign its address to the pointer
	num := 42
	numPtr = &num

	// Print the value and memory address of the variable using the pointer
	fmt.Printf("Value: %d\n", *numPtr)
	fmt.Printf("Address: %p\n", numPtr)

	// Update the value of the variable using the pointer
	*numPtr = 99

	// Print the updated value
	fmt.Printf("Updated Value: %d\n", num)

	// Create an array of pointers to characters
	characters := []*Character{
		{Name: "Hermione Granger", House: "Gryffindor", Role: "Student"},
		{Name: "Ron Weasley", House: "Gryffindor", Role: "Student"},
		{Name: "Draco Malfoy", House: "Slytherin", Role: "Student"},
	}

	// Iterate over the array and print each character's details
	for _, character := range characters {
		fmt.Printf("Name: %s\n", character.Name)
		fmt.Printf("House: %s\n", character.House)
		fmt.Printf("Role: %s\n", character.Role)
	}

	// Function that takes a pointer to a character as an argument
	updatePoints := func(c *Character, points int) {
		c.Points += points
	}

	// Update Harry's points using the function
	updatePoints(harry, 20)

	// Print Harry's updated points
	fmt.Printf("Harry's Points: %d\n", harry.Points)

	// Create a pointer to an array
	numbers := []int{1, 2, 3, 4, 5}
	numbersPtr := &numbers

	// Print the array using the pointer
	fmt.Printf("Numbers: %v\n", *numbersPtr)

	// Update the array using the pointer
	(*numbersPtr)[0] = 10

	// Print the updated array
	fmt.Printf("Updated Numbers: %v\n", numbers)

	// Create a map of character names to their pointers
	characterMap := map[string]*Character{
		"Harry":   harry,
		"Hermione": {Name: "Hermione Granger", House: "Gryffindor", Role: "Student"},
		"Ron":     {Name: "Ron Weasley", House: "Gryffindor", Role: "Student"},
	}

	// Print the details of characters in the map
	for name, character := range characterMap {
		fmt.Printf("Name: %s\n", name)
		fmt.Printf("House: %s\n", character.House)
		fmt.Printf("Role: %s\n", character.Role)
	}


	// Example 1: Returning an error from a function
	result, err := divide(10, 0)
	if err != nil {
		fmt.Println("Error:", err)
	} else {
		fmt.Println("Result:", result)
	}

	// Example 2: Handling specific errors using type assertion
	err = validateAge(15)
	if invalidAgeErr, ok := err.(InvalidAgeError); ok {
		fmt.Println("Invalid age:", invalidAgeErr.Age)
	} else {
		fmt.Println("No error or different error occurred")
	}

	// Example 3: Creating a custom error type
	customErr := CustomError{"Custom error occurred"}
	fmt.Println(customErr.Error())

	// Example 4: Wrapping an error with additional context
	wrappedErr := fmt.Errorf("Wrapped error: %w", customErr)
	fmt.Println(wrappedErr.Error())

	// Example 5: Checking if an error is of a specific type
	if errors.Is(wrappedErr, customErr) {
		fmt.Println("Wrapped error is of type CustomError")
	}

	// Example 6: Unwrapping an error to access the root cause
	cause := errors.Unwrap(wrappedErr)
	if cause != nil {
		fmt.Println("Root cause:", cause)
	}

	// Example 7: Handling multiple errors using error variables
	err1 := errors.New("Error 1")
	err2 := errors.New("Error 2")
	err3 := errors.New("Error 3")

	var multiErr error = MultiError{err1, err2, err3}
	if multiErr != nil {
		fmt.Println("Multiple errors occurred:", multiErr)
	}

	// Example 8: Recovering from a panic and converting it to an error
	defer func() {
		if r := recover(); r != nil {
			err := fmt.Errorf("Panic occurred: %v", r)
			fmt.Println("Recovered error:", err)
		}
	}()
	panic("Something went wrong")

	// Example 9: Handling errors in a loop and continuing execution
	for i := 1; i <= 5; i++ {
		err := processItem(i)
		if err != nil {
			fmt.Println("Error processing item", i, ":", err)
			continue
		}
		fmt.Println("Item", i, "processed successfully")
	}

	// Example 10: Custom error types with additional methods
	validationErr := ValidationErr{Field: "username", Message: "Invalid characters"}
	fmt.Println(validationErr.Error())
	fmt.Println(validationErr.ValidationMessage())

	// Example 11: Checking for specific error types using type switch
	switch err := validateEmail("test@example"); err.(type) {
	case InvalidEmailError:
		fmt.Println("Invalid email:", err)
	default:
		fmt.Println("No error or different error occurred")
	}

	// Example 12: Handling errors with defer statements
	err = openFile("nonexistent.txt")
	defer handleError(err)
	// Perform file operations

	// Example 13: Ignoring errors using the blank identifier _
	_, _ = divide(10, 0)

	// Example 14: Recovering from a panic and returning an error
	result, err = divideWithRecovery(10, 0)
	if err != nil {
		fmt.Println("Error:", err)
	} else {
		fmt.Println("Result:", result)
	}

	// Example 15: Handling errors with context using the "pkg/errors" package
	err = processRequest()
	if err != nil {
		fmt.Println("Error:", err)
	}

	// Example 16: Defining error codes and messages as constants
	errCode := ErrorCode(404)
	errMsg := ErrorMessage(errCode)
	fmt.Println("Error code:", errCode)
	fmt.Println("Error message:", errMsg)

	// Example 17: Returning an error from a method of a custom type
	user := User{Name: ""}
	err = user.Validate()
	if err != nil {
		fmt.Println("Error:", err)
	}

	// Example 18: Handling errors using a custom error handler function
	err = handleAPIError("API request failed", func(err error) {
		fmt.Println("Custom error handler:", err)
	})
	if err != nil {
		fmt.Println("Error:", err)
	}

	// Example 19: Handling errors using a recoverable error type
	file, err := OpenFile("nonexistent.txt")
	if err != nil {
		fmt.Println("Error:", err)
	} else {
		fmt.Println("File opened successfully:", file)
	}

	// Example 20: Using error variables to handle multiple errors
	err1 = errors.New("Error 1")
	err2 = errors.New("Error 2")
	err3 = errors.New("Error 3")

	var multiErr2 error = MultiError2{[]error{err1, err2, err3}}
	if multiErr2 != nil {
		fmt.Println("Multiple errors occurred:", multiErr2)
	}

	// Example 21: Recovering from a panic and converting it to an error with context
	err = processWithPanic()
	if err != nil {
		fmt.Println("Error:", err)
	}

	// Example 22: Handling errors using a custom error handler interface
	err = handleWithHandler("error", customHandler{})
	if err != nil {
		fmt.Println("Error:", err)
	}

	// Example 23: Handling errors with context using the "pkg/errors" package (with stack trace)
	err = processWithStack()
	if err != nil {
		fmt.Println("Error:", err)
	}

	// Example 24: Defining error types as constants
	errType := ErrorType("NotFound")
	fmt.Println("Error type:", errType)

	// Example 25: Handling errors using a custom error handler interface (with stack trace)
	err = handleWithHandlerAndStack("error", customHandlerWithStack{})
	if err != nil {
		fmt.Println("Error:", err)
	}

	// Example 1: Reading a single command-line argument
	arg := os.Args[1]
	fmt.Println("Command-line argument:", arg)

	// Example 2: Reading multiple command-line arguments
	args := os.Args[1:]
	fmt.Println("Command-line arguments:", args)

	// Example 3: Using the flag package to parse command-line arguments
	var name string
	flag.StringVar(&name, "name", "", "Specify a name")
	flag.Parse()
	fmt.Println("Name:", name)

	// Example 4: Using positional command-line arguments
	if len(os.Args) < 4 {
		fmt.Println("Usage: program <arg1> <arg2> <arg3>")
		return
	}
	arg1 := os.Args[1]
	arg2 := os.Args[2]
	arg3 := os.Args[3]
	fmt.Println("Argument 1:", arg1)
	fmt.Println("Argument 2:", arg2)
	fmt.Println("Argument 3:", arg3)

	// Example 5: Using flag arguments with different types
	var (
		intFlag    int
		floatFlag  float64
		boolFlag   bool
		stringFlag string
	)
	flag.IntVar(&intFlag, "int", 0, "An integer flag")
	flag.Float64Var(&floatFlag, "float", 0.0, "A float flag")
	flag.BoolVar(&boolFlag, "bool", false, "A boolean flag")
	flag.StringVar(&stringFlag, "string", "", "A string flag")
	flag.Parse()
	fmt.Println("Integer Flag:", intFlag)
	fmt.Println("Float Flag:", floatFlag)
	fmt.Println("Boolean Flag:", boolFlag)
	fmt.Println("String Flag:", stringFlag)

	// Example 6: Using flag arguments with shorthand notation
	var (
		iFlag int
		fFlag float64
		bFlag bool
		sFlag string
	)
	flag.IntVar(&iFlag, "i", 0, "An integer flag")
	flag.Float64Var(&fFlag, "f", 0.0, "A float flag")
	flag.BoolVar(&bFlag, "b", false, "A boolean flag")
	flag.StringVar(&sFlag, "s", "", "A string flag")
	flag.Parse()
	fmt.Println("Integer Flag (shorthand):", iFlag)
	fmt.Println("Float Flag (shorthand):", fFlag)
	fmt.Println("Boolean Flag (shorthand):", bFlag)
	fmt.Println("String Flag (shorthand):", sFlag)

	// Example 7: Using flag arguments with default values
	var (
		defaultIntFlag    int
		defaultFloatFlag  float64
		defaultBoolFlag   bool
		defaultStringFlag string
	)
	flag.IntVar(&defaultIntFlag, "default-int", 100, "An integer flag with default value")
	flag.Float64Var(&defaultFloatFlag, "default-float", 3.14, "A float flag with default value")
	flag.BoolVar(&defaultBoolFlag, "default-bool", true, "A boolean flag with default value")
	flag.StringVar(&defaultStringFlag, "default-string", "default", "A string flag with default value")
	flag.Parse()
	fmt.Println("Default Integer Flag:", defaultIntFlag)
	fmt.Println("Default Float Flag:", defaultFloatFlag)
	fmt.Println("Default Boolean Flag:", defaultBoolFlag)
	fmt.Println("Default String Flag:", defaultStringFlag)

	// Example 8: Using flag arguments with required values
	var requiredFlag string
	flag.StringVar(&requiredFlag, "required", "", "A required flag")
	flag.Parse()
	if requiredFlag == "" {
		fmt.Println("Error: Required flag not provided")
		return
	}
	fmt.Println("Required Flag:", requiredFlag)

	// Example 9: Using flag arguments with custom usage message
	var customFlag string
	flag.StringVar(&customFlag, "custom", "", "A custom flag")
	flag.Usage = func() {
		fmt.Println("Usage: program -custom <value>")
	}
	flag.Parse()
	fmt.Println("Custom Flag:", customFlag)

	// Example 10: Using flag arguments with shorthand notation and custom usage message
	var shorthandFlag string
	flag.StringVar(&shorthandFlag, "shorthand", "", "A shorthand flag")
	flag.StringVar(&shorthandFlag, "s", "", "A shorthand flag (shorthand)")
	flag.Usage = func() {
		fmt.Println("Usage: program -shorthand <value>")
	}
	flag.Parse()
	fmt.Println("Shorthand Flag:", shorthandFlag)

	// Example 1: Goroutine
	go func() {
		fmt.Println("Hello from Goroutine!")
	}()

	// Example 2: WaitGroup
	var wg sync.WaitGroup
	wg.Add(1)
	go func() {
		defer wg.Done()
		fmt.Println("Hello from WaitGroup!")
	}()
	wg.Wait()

	// Example 3: Channels (Unbuffered)
	ch := make(chan string)
	go func() {
		ch <- "Hello from Unbuffered Channel!"
	}()
	msg := <-ch
	fmt.Println(msg)

	// Example 4: Channels (Buffered)
	ch2 := make(chan string, 1)
	ch2 <- "Hello from Buffered Channel!"
	msg2 := <-ch2
	fmt.Println(msg2)

	// Example 5: Channel Synchronization
	done := make(chan bool)
	go func() {
		time.Sleep(time.Second)
		fmt.Println("Work done!")
		done <- true
	}()
	<-done

	// Example 6: Select Statement
	ch3 := make(chan string)
	ch4 := make(chan string)
	go func() {
		time.Sleep(500 * time.Millisecond)
		ch3 <- "Hello"
	}()
	go func() {
		time.Sleep(1 * time.Second)
		ch4 <- "World"
	}()
	select {
	case msg3 := <-ch3:
		fmt.Println(msg3)
	case msg4 := <-ch4:
		fmt.Println(msg4)
	}

	// Example 7: Buffered Channel with Goroutine
	ch5 := make(chan int, 5)
	go func() {
		for i := 0; i < 5; i++ {
			ch5 <- i
		}
		close(ch5)
	}()
	for num := range ch5 {
		fmt.Println(num)
	}

	// Example 8: Select Statement with Timeout
	ch6 := make(chan string)
	go func() {
		time.Sleep(2 * time.Second)
		ch6 <- "Hello from Select with Timeout!"
	}()
	select {
	case msg6 := <-ch6:
		fmt.Println(msg6)
	case <-time.After(1 * time.Second):
		fmt.Println("Timeout!")
	}

	// Example 9: Mutex
	var counter int
	var mu sync.Mutex
	var wg2 sync.WaitGroup
	for i := 0; i < 10; i++ {
		wg2.Add(1)
		go func() {
			defer wg2.Done()
			mu.Lock()
			counter++
			mu.Unlock()
		}()
	}
	wg2.Wait()
	fmt.Println("Counter:", counter)

	// Example 10: RWMutex
	var data int
	var rwMu sync.RWMutex
	var wg3 sync.WaitGroup
	wg3.Add(2)
	go func() {
		defer wg3.Done()
		rwMu.RLock()
		fmt.Println("Data:", data)
		rwMu.RUnlock()
	}()
	go func() {
		defer wg3.Done()
		rwMu.Lock()
		data = 42
		rwMu.Unlock()
	}()
	wg3.Wait()

	// Example 11: Atomic Operations
	var value int32
	var wg4 sync.WaitGroup
	wg4.Add(2)
	go func() {
		defer wg4.Done()
		for i := 0; i < 1000; i++ {
			value++
		}
	}()
	go func() {
		defer wg4.Done()
		for i := 0; i < 1000; i++ {
			value--
		}
	}()
	wg4.Wait()
	fmt.Println("Value:", value)

	// Example 12: Worker Pool
	type Job struct {
		ID  int
		Msg string
	}
	jobs := make(chan Job)
	results := make(chan string)
	var wg5 sync.WaitGroup
	const numWorkers = 5
	wg5.Add(numWorkers)
	for i := 0; i < numWorkers; i++ {
		go func(id int) {
			defer wg5.Done()
			for job := range jobs {
				result := processJob(job)
				results <- result
			}
		}(i)
	}
	go func() {
		for i := 0; i < 10; i++ {
			job := Job{
				ID:  i,
				Msg: fmt.Sprintf("Job %d", i),
			}
			jobs <- job
		}
		close(jobs)
	}()
	go func() {
		wg5.Wait()
		close(results)
	}()
	for result := range results {
		fmt.Println(result)
	}

	// Example 13: Fan-Out/Fan-In
	input := make(chan int)
	output := make(chan int)
	const numWorkers2 = 5
	for i := 0; i < numWorkers2; i++ {
		go worker(input, output)
	}
	go func() {
		for i := 0; i < 10; i++ {
			input <- i
		}
		close(input)
	}()
	for i := 0; i < 10; i++ {
		result := <-output
		fmt.Println(result)
	}

	// Example 14: Context
	ctx := setupContext()
	go doWorkWithContext(ctx)

	// Example 15: Context Cancellation
	ctx2, cancel := setupContextWithCancellation()
	go doWorkWithContextCancellation(ctx2)
	time.Sleep(2 * time.Second)
	cancel()

	// Example 16: Context Timeout
	ctx3, cancel2 := setupContextWithTimeout()
	go doWorkWithContextTimeout(ctx3)
	time.Sleep(2 * time.Second)
	cancel2()

	// Example 17: Context Deadline
	ctx4, cancel3 := setupContextWithDeadline()
	go doWorkWithContextDeadline(ctx4)
	time.Sleep(2 * time.Second)
	cancel3()

	// Example 18: Rate Limiting
	const numRequests = 10
	const requestsPerSecond = 2
	rateLimit := time.Tick(time.Second / requestsPerSecond)
	for i := 0; i < numRequests; i++ {
		<-rateLimit
		fmt.Println("Request", i+1)
	}

	// Example 19: Semaphore
	semaphore := make(chan struct{}, 3)
	var wg6 sync.WaitGroup
	const numTasks = 5
	wg6.Add(numTasks)
	for i := 0; i < numTasks; i++ {
		go func(id int) {
			defer wg6.Done()
			semaphore <- struct{}{}
			doTask(id)
			<-semaphore
		}(i)
	}
	wg6.Wait()

	// Example 20: Atomic Counter
	var counter2 int64
	var wg7 sync.WaitGroup
	const numIncrements = 1000
	wg7.Add(numIncrements)
	for i := 0; i < numIncrements; i++ {
		go func() {
			defer wg7.Done()
			atomicIncrement(&counter2)
		}()
	}
	wg7.Wait()
	fmt.Println("Counter:", counter2)

	// Example 21: Buffered Channel with Worker Pool
	jobs2 := make(chan int, 10)
	results2 := make(chan int, 10)
	const numWorkers3 = 5
	var wg8 sync.WaitGroup
	wg8.Add(numWorkers3)
	for i := 0; i < numWorkers3; i++ {
		go func(id int) {
			defer wg8.Done()
			for job := range jobs2 {
				result := processJob2(job)
				results2 <- result
			}
		}(i)
	}
	go func() {
		for i := 0; i < 10; i++ {
			jobs2 <- i
		}
		close(jobs2)
	}()
	go func() {
		wg8.Wait()
		close(results2)
	}()
	for result := range results2 {
		fmt.Println(result)
	}

	// Example 22: Context with Deadline and Cancellation
	ctx5, cancel4 := setupContextWithDeadlineAndCancellation()
	go doWorkWithContextDeadlineAndCancellation(ctx5)
	time.Sleep(2 * time.Second)
	cancel4()

	// Example 23: Context with Value
	ctx6 := setupContextWithValue()
	go doWorkWithContextValue(ctx6)

	// Example 24: Select Statement with Default Case
	ch7 := make(chan string)
	go func() {
		time.Sleep(2 * time.Second)
		ch7 <- "Hello from Select with Default Case!"
	}()
	select {
	case msg7 := <-ch7:
		fmt.Println(msg7)
	default:
		fmt.Println("No message received")
	}

	// Example 25: Non-blocking Channel Operations
	ch8 := make(chan int)
	select {
	case <-ch8:
		fmt.Println("Received from channel")
	default:
		fmt.Println("No message received")
	}
	ch8 <- 42

	// Wait for goroutines to complete
	time.Sleep(2 * time.Second)
}