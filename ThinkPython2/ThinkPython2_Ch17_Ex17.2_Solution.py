"""This exercise is a cautionary tale about one of the most common, and difficult to
find, errors in Python. Write a definition for a class named Kangaroo with the methods:
1.  An __init__ method that initializes an attribute named pouch_contents to an empty list.
2.  A method named put_in_pouch that takes an object of any type and adds it to pouch_contents.
3.  A __str__ method that returns a string representation of the Kangaroo object and the
contents of the pouch.

Test your code by creating two Kangaroo objects, assigning them to variables named kanga and
roo, and then adding roo to the contents of kanga’s pouch.

Skills:
-OOP
-Testing

Status: Complete
"""

# Kangaroo class
class Kangaroo:
    def __init__(self, name):           # no need for another parameter as not taking in other variables
        self.pouch_contents = []        # use the self keyword to bind the variable to the instance of the class
        self.name = name

    def put_in_pouch(self, item):       # takes an object of any type so added an additional parameter 'item'
        self.pouch_contents.append(item)
        return self.pouch_contents

    def __str__(self):
        t = [ self.name + ' has pouch contents: ']
        for obj in self.pouch_contents:
            s = '    ' + object.__str__(obj)
            t.append(s)
        return '\n'.join(t)
        # return f"Kangaroo Object: {self.pouch_contents}"

# Creating two Kangaroo objects
kanga = Kangaroo('Kanga')
roo = Kangaroo('Roo')

# Methods to put values into 'pouch'
kanga.put_in_pouch('wallet')
kanga.put_in_pouch('car keys')
kanga.put_in_pouch(roo)

# Add roo to the contents of kanga's pouch
# add_kang_roo = new_kanga.put_in_pouch(new_roo) # this is wrong; method returns the Kangaroo object

# Printing results
print(kanga)
print(roo)

"""
Download http: // thinkpython2. com/ code/ BadKangaroo. py . It contains a solution to the
previous problem with one big, nasty bug. Find and fix the bug

class Kangaroo:
    
    def __init__(self, name, contents=[]):  # THE BUG IS HERE!
        self.name = name
        self.pouch_contents = contents

In Python, default arguments are evaluated once when the function is created. 
This won't be noticed with immutable datatypes but it is a noticeable problem in mutable datatypes.
But if it set to None, it is evaluated once but it is not mutable. 
So it is not getting changed everytime the function is being run.

This code can be fixed by setting contents = None and then an if-else statement like this:

    def __init__(self, name, contents=None):
        self.name = name
        if contents is None:
            contents = []
        self.pouch_contents = contents

"""

