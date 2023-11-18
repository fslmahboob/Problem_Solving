"""
Link: https://www.coderbyte.com/editor/Find%20Intersection:Python3

Have the function FindIntersection(strArr) read the array of strings
stored in strArr which will contain 2 elements: the first element will
represent a list of comma-separated numbers sorted in ascending order,
the second element will represent a second list of comma-separated
numbers (also sorted). Your goal is to return a comma-separated string
containing the numbers that occur in elements of strArr in sorted order.
If there is no intersection, return the string false.

Status: Complete but can be improved, re-do

Skills:
 -Manipulating strings and lists
 -Looping with conditionals
"""


def FindIntersection(strArr):
    # code goes here
    a = strArr
    b1 = []
    b2 = []
    c1 = []
    c2 = []
    d1 = []
    d2 = []
    e1 = []

    # Split into two lists
    for i in range(2):
        if i == 0:
            b1.append(a[i])
        else:
            b2.append(a[i])

    # Create individual elements in the list
    for i in b1:
        c1 = i.split()
    for j in b2:
        c2 = j.split()

    # Remove commas
    for i in c1:
        d1.append(i.replace(',', ""))
    for j in c2:
        d2.append(j.replace(',', ""))

    # Nested loop to go through both lists at the same time
    for i in d1:
        for j in d2:
            if i == j:
                e1.append(i)

    # Create a string from the list
    e2 = ','.join(e1)

    if len(e2) > 0:
        return e2
    else:
        return print('False')


# keep this function call here
print(FindIntersection(input()))