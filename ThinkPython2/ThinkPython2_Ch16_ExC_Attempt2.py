"""As an exercise,  write a correct version of increment that doesn’t contain any loops.

Skills:
-OOP
-Manipulating time objects and variables

Status: Complete

Personal notes: This is version that wasn't working. I was confusing myself with the following:
 -Conversion of just the increment and then forgetting to take into account the start time
 -Not realising that I should start from top to bottom i.e. go to hours, figure out the remainder etc
 -Trying to do all the steps together

I was finally able to solve it (in a long way) by breaking down the problem. Sample code at the end.

"""

class Time:
    """Represents the time of day.
    attributes: hour, minute, second
    """
    pass


def increment(time, seconds):
    time.second += (seconds % 60) # modulus operator to get remaining seconds and increment to original attribute
    time.minute += (seconds // 60) # integer division operator for total mins
    time.hour += (seconds // 3600) # integer division for total hours

    if time.second >= 60:
        time.minute += (time.second // 60) # update mins with the extra secs
        time.second = time.second % 60 # make the seconds as the remainder of secs
    if time.minute >= 60:
        print(time.minute)
        time.hour += (time.minute // 60) # update hours with the extra mins
        print(time.hour)
        time.minute = time.minute % 60 # make the mins as the remainder of mins

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

"""Sample Code of breaking down the problem which allowed me to solve it"""
# start time
s_hr = 7
s_min = 45
s_sec = 50

# increment starting seconds
s = 9245

# 1) Find the number of hours
hr = s // (60 * 60)

# 2) Find the remainder from the hours -> that is the remaining total seconds
rem_secs = s % (60 * 60)

# 3) Convert the remaining seconds into minutes and seconds
mins = rem_secs // 60
secs = rem_secs % 60

# 5) Print it out
print("Hours: ", hr)
print("Minutes: ", mins)
print("Seconds: ", secs)
