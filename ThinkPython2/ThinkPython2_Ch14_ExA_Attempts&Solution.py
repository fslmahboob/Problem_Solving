"""
Think Python 2, page 140, section 14.4
The os module provides a function called walk that is similar to this one but more
versatile. As an exercise, read the documentation and use it to print
the names of the files  in  a  given  directory  and  its  subdirectories.

Skills:
-os module
-working with directories and files
-reading documentation

Status: Complete
"""

# My Attempt

import os

cwd = os.getcwd()

# for root, dirs, files in os.walk(cwd, topdown=True):
#     print("Root: ", root)
#     print("Dirs: ", dirs)
#     print("Files: ", files)
#     print('--------------------------------')

# for root, dirs, files in os.walk(".", topdown=False):
#    for name in files:
#       print(os.path.join(root, name))
#    for name in dirs:
#       print(os.path.join(root, name))

# Solution
for root, dirs, files in os.walk('.'):
    for filename in files:
        print(os.path.join(root, filename))