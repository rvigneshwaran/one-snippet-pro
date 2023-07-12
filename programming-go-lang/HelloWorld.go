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

	// Call a version-specific example
	versionSpecificExample()
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