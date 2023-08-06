"""Write a function that draws a grid like the following:
+ - - - - + - - - - +
| | |
| | |
| | |
| | |
+ - - - - + - - - - +
| | |
| | |
| | |
| | |
+ - - - - + - - - - +

Skills:
-functions

Status: Complete
"""


# Assigning grid elements to variables; Brandon mentioned not a good idea to store as a variable for using loops

x = '+'
y = '-'
z = '|'
a = '    '

# Defining the various functions; NEEDS PARAMETERS
def do_hor(): #NEEDS PARAMETERS
    print(x, end=' ')
    print(4 * y, end=' ')
    print(x, end=' ')
    print(4 * y, end=' ')
    print(x, end=' ')
    print(4 * y, end=' ')
    print(x)
def do_vert(): #NEEDS PARAMETERS
    print(z, end=' ')
    print(a, end=' ')
    print(z, end=' ')
    print(a, end=' ')
    print(z, end=' ')
    print(a, end=' ')
    print(z)
def grid():
    do_hor()
    do_vert()
    do_vert()
    do_vert()
    do_vert()

def do_3_3_grid(f):
    f()
    f()
    do_hor()

def do_4_4_grid(f):
    f()
    f()
    f()
    do_hor()


# Calling the functions
# do_3_3_grid(grid)
do_4_4_grid(grid)