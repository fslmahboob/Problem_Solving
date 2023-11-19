"""
Source: https://allinpython.com/python-program-to-sort-a-list-without-using-sort-function/

Write a program to sort a list in ascending order without using the sort() function.

Status:

Skills:
 -Bubble sort
 -Pointer system
"""

# user input for a list
my_list = []
i = 0

while i < 6:
    a = int(input("Enter an integer: "))
    i += 1
    my_list.append(a)

print("Unsorted List: ", my_list)

# Bubble Sort - O(n^2)

tmp = 0
for i in range(0, len(my_list)):
    for j in range(0, len(my_list)):
        # Compare with two pointers
        if my_list[i] < my_list[j]:
        # Swap them if in wrong order
            tmp = my_list[i]            # value at index i stored in tmp
            my_list[i] = my_list[j]     # value of index j stored instead of value of index i
            my_list[j] = tmp            # value of initial index i now stored instead of value of index j

print("Sorted List: ", my_list)

# This swapping process is repeated for all pairs of elements in the list, effectively "bubbling up"
# the largest elements to their correct positions in the list.
