"""As an exercise, write a “pure” version of increment that creates
 and returns a new Time object rather than modifying the parameter.

Skills:
-OOP
-Manipulating time objects and variables

Status: Complete
"""

# Process was to just create a deep copy; another approach could have been to
# just create another instantiation of Time class

import copy


class Time(object):
    """Represents the time of day.
    attributes: hour, minute, second"""


def increment(time, seconds):
    time2 = copy.deepcopy(time)
    time2.second += seconds

    add_mins, remain_seconds = divmod(time2.second, 60)
    time2.minute += add_mins
    time2.second = remain_seconds

    add_hours, remain_minute = divmod(time2.minute, 60)
    time2.hour += add_hours
    time2.minute = remain_minute

    return time2


def print_time(time):
    """Prints a string representation of the time.
    t: Time object
    """
    print(f"{time.hour:02d}:{time.minute:02d}:{time.second:02d}")


start = Time()
start.hour = 7
start.minute = 45
start.second = 30

# x = increment(start, 3600)
# x = increment(start, 9245)
x = increment(start, 21580)
print_time(x)