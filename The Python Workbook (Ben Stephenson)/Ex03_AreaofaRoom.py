"""
Exercise 3: Area of a Room
(Solved, 13 Lines)

Write a program that asks the user to enter the width and length of a room. Once
these values have been read, your program should compute and display the area of
the room. The length and the width will be entered as floating-point numbers. Include
units in your prompt and output message; either feet or meters, depending on which
unit you are more comfortable working with.

Status: Complete

Skills:
 -Input from user
 -Float operator
"""

w = float(input("Width in  cm? "))
l = float(input("Length in cm? "))
a = l * w
print(f"Area is {a} cm^2")