"""
Exercise 17.0E: As an exercise, write an add method for Points that works with
either a Point object or a tuple:
• If  the  second  operand  is  a  Point,  the  method  should  return  a  new
  Point  whose  x coordinate is the sum of the  x coordinates of the operands,
  and likewise for the y coordinates.
• If the second operand is a tuple, the method should add the first element of
  the tuple to the  x coordinate and the second element to the y coordinate,  and
  return a new Point with the result.

Skills:
-OOP
-Type based dispatch (isinstance)
-Operator overloading

Status: complete
"""

class Point:
    def __init__(self, x=0, y=0):
        self.x = x
        self.y = y
    def __str__(self):
        return f"x: {self.x:02d}, y: {self.y:02d}"

    def __add__(self, other):
        if isinstance(other, Point):
            return (self.x + other.x), (self.y + other.y)
        elif isinstance(other, tuple):
            self.x, self.y = other[0], other[1]
            return self.x + self.y

# Test 1: two Point objects
oPoint1 = Point(32, 88)
oPoint2 = Point(3, 5)
print(oPoint1 + oPoint2)

# Test 2: two Tuple objects
oTup1 = Point((32), (88))
oTup2 = Point((3), (5))
print(oTup1 + oTup2)

#Test 3: one Tuple object and one Point object
print(oPoint1+oTup2)