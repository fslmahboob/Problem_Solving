"""
As an exercise, write a function called print_time that takes a Time object and prints it in
the form hour:minute:second. Hint: the format sequence '%.2d' prints an integer using
at least two digits, including a leading zero if necessary.
(Think Python 2, page 155)

Skills:
 -F-Strings
 -Working with Time objects

Status: Complete
"""
class Time:
    """Represents the time of day.
    attributes: hour, minute, second
    """

time = Time()
time.hour = 11
time.min = 59
time.sec = 30

print(f"{time.hour:02d}:{time.min:02d}:{time.sec:02d}") # good cheat sheet with examples: https://www.pythonmorsels.com/string-formatting/#cheat-sheets

# SOLUTION - more efficient using a function
def print_time(t):
    """Prints a string representation of the time.
    t: Time object
    """
    print(f"{t.hour:02d}:{t.min:02d}:{t.sec:02d}")

