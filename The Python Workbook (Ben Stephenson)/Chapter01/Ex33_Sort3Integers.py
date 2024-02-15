"""
Exercise 33: Sort 3 Integers
(Solved, 19 Lines)
Create a program that reads three integers from the user and displays them in sorted
order (from smallest to largest). Use the min and max functions to find the smallest
and largest values. The middle value can be found by computing the sum of all three
values, and then subtracting the minimum value and the maximum value.

Status: Complete

Skills:
 -Min, Max functions
 -User inputs and storage in a list/array
"""

i = 0
b = []

while i < 3:
    a = int(input("Enter an integer: "))
    i += 1
    b.append(a)

print("Unsorted: ", b)

# For lists, the function sort can do the trick
# b.sort()
# print("Sorted: ", b)

# Attempt without using special functions like that
x = max(b)
y = min(b)
z = sum(b) - x - y

print("Sorted: ", y,',', z, ',', x)

"""
Solution
(much easier implementation!)


a = int(input("Enter the 1st number: "))
b = int(input("Enter the 2nd number: "))
c = int(input("Enter the 3rd number: "))

mn = min(a, b, c)
mx = max(a, b, c)
md = a + b + c - mn - mx

print("The numbers in sorted order are:")
print(" ", mn)
print(" ", md)
print(" ", mx)
"""