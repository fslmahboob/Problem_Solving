"""As an exercise,  write a correct version of increment that doesn’t contain any loops.

Skills:
-OOP
-Manipulating time objects and variables

Status: Complete

Refactoring: use divmod function with tuple packing/unpacking! See someone else's solution code below.
"""


class Time:
    """Represents the time of day.
    attributes: hour, minute, second
    """
    pass


def increment(time, seconds):
    time.hour += seconds // (60 * 60)  # Integer division to get total hours
    rem_secs = seconds % (60 * 60)  # Remainder of seconds after removing hours
    time.minute += rem_secs // 60  # integer division to get total mins
    time.second += rem_secs % 60  # Remainder of seconds after removing minutes

    if time.second >= 60:
        time.minute += 1  # add 1 minute to mins
        time.second -= 60  # subtract 60 seconds from secs
    if time.minute >= 60:
        # print(time.minute)
        time.hour += 1  # add 1 hr to hour
        # print(time.hour)
        time.minute -= 60  # subtract 60 mins from minute

    return time  # Return the updated Time Object


def print_time(t):
    """Prints a string representation of the time.
    t: Time object
    """
    print(f"{t.hour:02d}:{t.minute:02d}:{t.second:02d}")


start = Time()
start.hour = 7
start.minute = 45
start.second = 30

# x = increment(start, 3600)
# x = increment(start, 21580)
x = increment(start, 9245)
print_time(x)


"""SOLUTION CODE FROM HERE: https://paigelearnscode.wordpress.com/2015/09/page/2/
class Time(object):
    ""Represents the time of day.
    attributes: hour, minute, second""

time = Time()
time.hour = 11
time.minute = 59
time.second = 30

def increment(time, seconds):
    time.second += seconds

    add_mins, remain_seconds = divmod(time.second, 60)
    time.minute += add_mins
    time.second = remain_seconds

    add_hours, remain_minute = divmod(time.minute, 60)
    time.hour += add_hours
    time.minute = remain_minute
"""