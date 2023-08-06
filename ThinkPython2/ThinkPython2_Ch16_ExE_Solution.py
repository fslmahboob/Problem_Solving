"""As  an  exercise,  rewrite increment using time_to_int and int_to_time.

Skills:
-OOP
-Manipulating time objects and variables

Status: Complete
"""

# Very simple, just need to convert everything to seconds -> sum -> convert back to time
class Time(object):
    """Represents the time of day.
    attributes: hour, minute, second"""
    pass

start = Time()
start.hour = 7
start.minute = 45
start.second = 30

seconds = 21580

def print_time(time):
    """Prints a string representation of the time.
    t: Time object
    """
    print(f"{time.hour:02d}:{time.minute:02d}:{time.second:02d}")

def time_to_int(time):
    minutes = time.hour * 60 + time.minute
    seconds = minutes * 60 + time.second
    return seconds

def int_to_time(seconds):
    time = Time()
    minutes, time.second = divmod(seconds, 60)
    time.hour, time.minute = divmod(minutes, 60)
    return time

def increment(time, seconds):
    s = time_to_int(time) # convert starting time to seconds
    seconds += s # add the converted seconds to incremented seconds
    return int_to_time(seconds) # return the converted total seconds to time

x = increment(start, seconds)
print_time(x)