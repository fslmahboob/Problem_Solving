"""
Exercise 37: Vowel or Consonant
(16 Lines)

In this exercise you will create a program that reads a letter of the alphabet from the
user. If the user enters a, e, i, o or u then your program should display a message
indicating that the entered letter is a vowel. If the user enters y then your program
should display a message indicating that sometimes y is a vowel, and sometimes y is
a consonant. Otherwise your program should display a message indicating that the
letter is a consonant.


Status: Complete

Skills:
 -Conditionals and operators
"""

# Read input letter from user
letter = str(input("Please enter a letter "))

# Check if letter is either a,e,i,o,u
if letter in ('a', 'e', 'i', 'o', 'u'):
    print("Letter is a vowel")
elif letter == 'y':
    print("Sometimes y is a vowel, sometimes y is a consonant")
else:
    print("Letter is a consonant")
