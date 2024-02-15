"""
Exercise 37: Average
(26 Lines)

In this exercise you will create a program that computes the average of a collection
of values entered by the user. The user will enter 0 as a sentinel value to indicate
that no further values will be provided. Your program should display an appropriate
error message if the first value entered by the user is 0.

Status: Complete

Skills:
 -Nested conditionals
 -While loop for continuous user entry
"""
# Initialise a
a = 1
# Initialise sum
sum = float(0)
# Create an empty list to store the collection of values
l = []

# Continuous loop for entering values until 0
while a != 0:
    a = float(input("Enter a collection of numbers (0 to quit): "))
    l.append(a)

# Conditional for error message and for calculating average
if l[0] == 0:
    print("Error message!")
else:
    for i in l:
        if i == 0:
            length = len(l) - 1
        else:
            sum += i
    print("Average: ", sum/length)

