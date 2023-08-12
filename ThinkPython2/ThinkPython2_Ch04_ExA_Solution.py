"""
1.  Write a function called square that takes a parameter named t, which is a turtle.
It should use the turtle to draw a square. Write  a  function  call  that  passes
bob as  an  argument  to  square,  and  then  run  the program again.
2.  Add another parameter, named length, to square. Modify the body so length of the
sides is length, and then modify the function call to provide a second argument. Run
the program again. Test your program with a range of values for length.
3.  Make a copy of square and change the name to polygon.  Add another parameter
named n and modify the body so it draws an n-sided regular polygon.
Hint:  The exterior angles of an n-sided regular polygon are 360/n degrees.
4.  Write a function called circle that takes a turtle, t, and radius, r, as parameters
and that draws an approximate circle by calling polygon with an appropriate length and
number of sides. Test your function with a range of values of r.
Hint:  figure out the circumference of the circle and make sure that length * n =
circumference.
5.  Make a more general version of circle called arc that takes an additional parameter
angle, which determines what fraction of a circle to draw. angle is in units of degrees,
so when angle=360, arc should draw a complete circle.

Skills:
-Functions
-Turtle module
-Interface design

Status: Complete
"""


import turtle                   # bring in turtle module

PI = 3.1416

def square(t,length):           # creating a function called square
    for i in range(4):
        t.fd(length)            # call methods to move turtle around
        t.lt(90)
    turtle.mainloop()           # make window wait for user to do something

def polygon(t,length,n):        # creating a function called polygon with equal angles
    for i in range(360//n):
        t.fd(length)            # call methods to move turtle around
        t.lt(n)
    turtle.mainloop()           # make window wait for user to do something

def circle(t,r):                # creating a function called circle with equal angles
    circumf = 2 * PI * r
    polygon(t,circumf/n,n)

def arc(t,r,angle):             # creating a function called circle with equal angles
    circumf = 2 * PI * r
    L = (angle * PI * r)/180
    polygon(t,circumf/L,n)

bob = turtle.Turtle()           # create a Turtle object which is assigned to variable bob

# Parameters
length = 2000
n = 5                          # Has to be divisible by 360; by definition equal angles polygon!
r = 5000

angle = 360                      # angle is in units of degrees, 360 degrees -> complete circle

# square(bob,length)            # call function square with the object bob with type Turtle

# polygon(bob,length,n)         # call function polygon with the object bob with type Turtle

# circle(bob,r)                 # call function circle with the object bob with type Turtle

arc(bob,r,angle)                 # call function circle with the object bob with type Turtle