"""
Link: https://coderbyte.com/editor/Codeland%20Username%20Validation:Python3

Have the function CodelandUsernameValidation(str) take the str parameter being passed and determine if the string is a valid username according to the following rules:

1. The username is between 4 and 25 characters.
2. It must start with a letter.
3. It can only contain letters, numbers, and the underscore character.
4. It cannot end with an underscore character.

If the username is valid then your program should return the string true, otherwise return the string false.

Status: Complete

Skills:
 -Looping with a counter
 -Multiple Chained Conditionals
"""

def CodelandUsernameValidation(strParam):
    # code goes here
    count = 0
    for i in strParam:
        # number 3 condition
        if isinstance(i, str or int or '_'):
            count += 1
        else:
            return False

    if count < 4 or count > 25:  # number 1 condition
        return False
    elif (strParam[-1]) == '_':  # number 4 condition
        return False
    elif not strParam[0].isalpha():  # number 2 condition
        return False
    else:
        return True


# keep this function call here
print(CodelandUsernameValidation(input()))