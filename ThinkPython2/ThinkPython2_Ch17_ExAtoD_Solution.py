"""
Skills:
-OOP
-classes and methods
-__init__ and __str__
-operator overloading

Status: Complete
"""


"""Exercise 17.0A: As an exercise, rewrite time_to_int (from Section 16.4) as a method. 
You might be tempted to rewrite int_to_time as a method, too, but that doesn’t really
 make sense because there would be no object to invoke it on. """

def time_to_int(self): # made a mistake here; remember we are passing the object as self
    minutes = self.hour * 60 + self.minute # we are taking attributes of the object, doing calculations on them and
    seconds = minutes * 60 + self.second # then storing them in variables
    return seconds

"""
Exercise 17.0B: As an exercise, rewrite an init method for the Point class that takes x and y as optional
parameters and assigns them to the corresponding attributes.

Exercise 17.0C: As an exercise, write a str method for the Point class. Create a Point object and print it.

Exercise 17.0D: Write an add method for the Point Class
"""

class Point:
    def __init__(self, x=0, y=0):
        self.x = x
        self.y = y

    def __str__(self):
        return f"x: {self.x:02d}, y: {self.y:02d}"

    # example of operator overloading
    def __add__(self, other):
        return (self.x + other.x), (self.y + other.y)

oPoint1 = Point(32, 88)
oPoint2 = Point(3, 5)
print(oPoint1)

# print __add__ method
print(oPoint1 + oPoint2)