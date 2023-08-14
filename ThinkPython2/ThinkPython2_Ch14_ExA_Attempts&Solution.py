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