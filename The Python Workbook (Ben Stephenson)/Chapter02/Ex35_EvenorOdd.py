"""
Exercise 35: Even or Odd?
(13 Lines)

Write a program that reads an integer from the user. Then your program should
display a message indicating whether the integer is even or odd.

Status: Complete

Skills:
 -Conditionals
"""
# Read integer from user
a = int(input("Enter an integer: "))

# Determine odd or even using modulus operator
if a % 2 == 0:
    print("Number is even")
else:
    print("Number is odd")