"""
Exercise 80: Prime Factors
(27 Lines)

Write a program that reads an integer from the user.
If the value entered by the user is less than 2 then
your program should display an appropriate error message.
Otherwise, your program should display the prime numbers
that can be multiplied together to compute n, with one
factor appearing on each line.

Status: Incomplete

Skills:
 -Looping
 -Mathematical thinking
"""



n = int(input("Enter an integer: "))

f = 2

while f <= n:
    if n % f == 0:
        print(f"{f} is a factor")
        f += 1
        m = n // f
    else:
        f += 1