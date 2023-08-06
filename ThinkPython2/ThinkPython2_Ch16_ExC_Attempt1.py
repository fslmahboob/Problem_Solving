"""As an exercise,  write a correct version of increment that doesn’t contain any loops.

Skills:
-OOP
-Manipulating time objects and variables

Status: Incomplete
"""


class Time:
    """Represents the time of day.
    attributes: hour, minute, second
    """
    pass


def increment(time, seconds):
    if seconds >= 60:
        time.second += (seconds % 60)  # modulus operator to get remaining seconds to add back to attribute
        time.minute += (seconds // (60 * 60))  # integer division operator to minutes to add back to attribute
        time.hour += (seconds // (60 * 60 * 60))
    # if time.minute >= 60:
    # time.minute -= (time.minute // 60)
    # time.hour += (time.minute // 60)
    # time.minute += (time.minute % 60)
    # time.hour += (seconds // 3600) # same as above applied to minutes/hours

    return time  # Return the updated Time Object


def print_time(t):
    """Prints a string representation of the time.
    t: Time object
    """
    print(f"{t.hour:02d}:{t.minute:02d}:{t.second:02d}")


start = Time()
start.hour = 7
start.minute = 45
start.second = 0

x = increment(start, 218580)
print_time(x)
