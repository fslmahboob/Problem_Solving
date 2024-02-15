"""
Exercise 36: Dog Years
(22 Lines)

It is commonly said that one human year is equivalent to 7 dog years. However this
simple conversion fails to recognize that dogs reach adulthood in approximately two
years. As a result, some people believe that it is better to count each of the first two
human years as 10.5 dog years, and then count each additional human year as 4 dog
years.

Write a program that implements the conversion from human years to dog years
described in the previous paragraph. Ensure that your program works correctly for
conversions of less than two human years and for conversions of two or more human
years. Your program should display an appropriate error message if the user enters
a negative number.

Status: Complete

Skills:
 -Conditionals
"""

# Read float number from user

age = float(input("What is age? "))

n_age = (age - 2) * 4

if age == 0:
    print("Please enter a number > 0")
elif age < 3:
    print("Your dog years is 10.5")
else:
    print(f"Your dog years is {10.5 + n_age}")