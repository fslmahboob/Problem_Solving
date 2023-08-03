"""CS50P - Problem Set 8: Cookie Jar
Link: https://cs50.harvard.edu/python/2022/psets/8/jar/

Suppose that you’d like to implement a cookie jar in which to store cookies.
In a file called jar.py, implement a class called Jar with these methods:

__init__ should initialize a cookie jar with the given capacity, which represents
 the maximum number of cookies that can fit in the cookie jar. If capacity is not
 a non-negative int, though, __init__ should instead raise a ValueError.
__str__ should return a str with  🍪, where  is the number of cookies in the cookie jar.

For instance, if there are 3 cookies in the cookie jar, then str should return "🍪🍪🍪"

deposit should add n cookies to the cookie jar. If adding that many would exceed the cookie
jar’s capacity, though, deposit should instead raise a ValueError.
withdraw should remove n cookies from the cookie jar. Nom nom nom. If there aren’t that many
cookies in the cookie jar, though, withdraw should instead raise a ValueError.
capacity should return the cookie jar’s capacity.
size should return the number of cookies actually in the cookie jar.

Skills:
 -Object Oriented Programming
 -raise for errors
 -__str__ method
 -Decorators
 -getters and setters
"""

class Jar:
    def __init__(self, capacity = 12):
        if capacity <= 0:
            raise ValueError("Needs to be non-negative")
        self.capacity = capacity
        self.size = 0 # set the initial size to zero
        
    def __str__(self):
        return "🍪"*n # n should be replaced by self.size
    
    def deposit(self, n):
        if n < 0:
            raise ValueError("Cannot deposit negative")
        if n > self.capacity: # should be n + self.size > self.capacity
            raise ValueError("Cookiejar full")
        self.size = self.size + n
        return self.size
    
    def withdraw(self, n):
        if n < 0:
            raise ValueError("Cannot withdraw negative")
                              # need to add self.size - n < 0
        self.size = self.size - n
        return self.size
    
    def capacity(self):
        return self.capacity
    
    def size(self):
        return self.size
    
oJar = Jar(6)
oJar.deposit(3)
oJar.withdraw(1)
print(oJar.size)
print(oJar)
#print("# of cookies: ", check_size)
#new_size = oJar.deposit(4)
#print("Current size: ", new_size)
#print("# of cookies: ", check_size)