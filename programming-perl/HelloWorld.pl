#!/usr/bin/perl

# Basic Concepts

# Variables
my $character_name = "Harry Potter";  # Store character name
my $age = 17;  # Store character's age
my $is_wizard = 1;  # Store whether character is a wizard

# Printing Variables
print "Character Name: $character_name\n";
print "Age: $age\n";
print "Is Wizard: $is_wizard\n";

# Control Flow
if ($age >= 17) {
    print "You are eligible to participate in the Triwizard Tournament.\n";
} else {
    print "You are not old enough to participate in the Triwizard Tournament.\n";
}

# Subroutines
sub greet {
    my ($name) = @_;
    print "Hello, $name!\n";
}

greet($character_name);

# Arrays
my @spells = ("Expelliarmus", "Lumos", "Accio", "Wingardium Leviosa");
print "All Spells: @spells\n";
print "First Spell: $spells[0]\n";
print "Number of Spells: " . scalar(@spells) . "\n";

# Advanced Concepts and Examples

# Loops
foreach my $spell (@spells) {
    print "Casting $spell...\n";
    # Add additional logic for spell casting
    print "Spell cast.\n";
}

# Hashes
my %friends = (
    Ron => "Weasley",
    Hermione => "Granger",
    Neville => "Longbottom"
);
print "All Friends: " . join(", ", keys %friends) . "\n";
print "Ron's Last Name: $friends{Ron}\n";
print "Number of Friends: " . scalar(keys %friends) . "\n";

# File Input/Output
open(my $fh, "<", "spells.txt") or die "Cannot open file: $!";
while (my $line = <$fh>) {
    chomp($line);
    print "Spell: $line\n";
}
close($fh);

# Regular Expressions
my $text = "Harry Potter and the Philosopher's Stone";
if ($text =~ /Harry/) {
    print "Text contains 'Harry'.\n";
}

# Modules
use strict;
use warnings;
use Data::Dumper;

my $data = {name => "Hermione Granger", age => 18};
print Dumper($data);

# Object-Oriented Programming
package Wand;

sub new {
    my ($class, $wood, $core) = @_;
    my $self = bless {
        wood => $wood,
        core => $core
    }, $class;
    return $self;
}

sub describe {
    my ($self) = @_;
    print "This wand is made of $self->{wood} with a $self->{core} core.\n";
}

package main;

my $wand = Wand->new("Holly", "Phoenix Feather");
$wand->describe();

# Error Handling
eval {
    # Code that may throw an exception
    die "Something went wrong.";
};
if ($@) {
    print "An error occurred: $@\n";
}

# Version-Specific Snippets

# Perl 5.10 and above: Say Function
say "Expecto Patronum!";

# Perl 5.14 and above: Unicode Characters
use feature 'unicode_strings';
my $unicode_string = "⚡️";
print "Unicode String: $unicode_string\n";

# Perl 5.20 and above: Postfix Dereference
my $characters = [
    {name => "Harry Potter", house => "Gryffindor"},
    {name => "Hermione Granger", house => "Gryffindor"},
    {name => "Ron Weasley", house => "Gryffindor"}
];
print "First Character: $characters->[0]{name}\n";

# More Advanced Concepts and Examples

# Regular Expressions: Capture Groups
my $address = "12 Grimmauld Place";
if ($address =~ /^(\d+)\s+(.+)/) {
    my $number = $1;
    my $street = $2;
    print "Number: $number\n";
    print "Street: $street\n";
}

# File Input/Output: Writing to a File
open(my $output_fh, ">", "output.txt") or die "Cannot open file: $!";
print $output_fh "The Dark Mark\n";
close($output_fh);

# Data Structures: Multidimensional Arrays
my @matrix = (
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
);
print "Element at (1, 2): $matrix[1][2]\n";

# Command-Line Arguments
my $arg1 = $ARGV[0];
my $arg2 = $ARGV[1];
print "Argument 1: $arg1\n";
print "Argument 2: $arg2\n";

# Functional Programming: Map and Reduce
my @numbers = (1, 2, 3, 4, 5);
my @squared_numbers = map { $_ ** 2 } @numbers;
my $sum = reduce { $a + $b } @numbers;
print "Squared Numbers: @squared_numbers\n";
print "Sum: $sum\n";
