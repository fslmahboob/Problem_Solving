"""
Change the attributes of Time to be a single integer representing seconds
since midnight. Then modify the methods (and the function int_to_time) to
work with the new implementation. You should not have to modify the test
code in main. When you are done, the output should be the same as before.

Skills:
-OOP
-Implementation vs Interface

Status: Complete
"""

from __future__ import print_function, division


class Time:
    """Represents the time of day.

    attributes: hour, minute, second
    """

    def __init__(self, hour=0, minute=0, second=0): # need to keep the parameter list the same so that the objects get sent with hr/min/sec
        """Initializes a time object.

        hour: int
        minute: int
        second: int or float
        """
        #self.hour = hour
        #self.minute = minute
        # not self.hour because we are only looking to do calculations to the arguments that get sent
        self.second = (hour * 60 * 60) + (minute * 60) + second

    def __str__(self):
        """Returns a string representation of the time."""
        # second = self.second % 60
        # minute = self.second // 60
        # hour = minute // 60
        # minute = minute % 60

        minutes, second = divmod(self.second, 60)
        hour, minute = divmod(minutes, 60)

        return '%.2d:%.2d:%.2d' % (hour, minute, second)

    def print_time(self):
        """Prints a string representation of the time."""
        print(str(self))

    def time_to_int(self):
        """Computes the number of seconds since midnight."""
        return self.second # now we only have the seconds attribute and we can just return that

    def is_after(self, other):
        """Returns True if t1 is after t2; false otherwise."""
        return self.time_to_int() > other.time_to_int()

    def __add__(self, other):
        """Adds two Time objects or a Time object and a number.

        other: Time object or number of seconds
        """
        if isinstance(other, Time):
            return self.add_time(other)
        else:
            return self.increment(other)

    def __radd__(self, other):
        """Adds two Time objects or a Time object and a number."""
        return self.__add__(other)

    def add_time(self, other):
        """Adds two time objects."""
        assert self.is_valid() and other.is_valid()
        seconds = self.time_to_int() + other.time_to_int()
        return int_to_time(seconds)

    def increment(self, seconds):
        """Returns a new Time that is the sum of this time and seconds."""
        seconds += self.time_to_int()
        return int_to_time(seconds)

    # Allen also checks for self.second >= 0 and self.second < 24*60*60
    def is_valid(self):
        """Checks whether a Time object satisfies the invariants."""
        # removed self.hour and self.minutes since we don't need them
        if self.second < 0:
            return False
        else:
            return True


def int_to_time(seconds):
    """Makes a new Time object.

    seconds: int seconds since midnight.
    """
    time = Time(0, 0, seconds) # need 3 parameters as class has 3 parameters of hr-min-sec
    return time


def main():
    start = Time(9, 45, 00)
    start.print_time()

    end = start.increment(1337)
    # end = start.increment(1337, 460)
    end.print_time()

    print('Is end after start?')
    print(end.is_after(start))

    print('Using __str__')
    print(start, end)

    start = Time(9, 45)
    duration = Time(1, 35)
    print(start + duration)
    print(start + 1337)
    print(1337 + start)

    print('Example of polymorphism')
    t1 = Time(7, 43)
    t2 = Time(7, 41)
    t3 = Time(7, 37)
    total = sum([t1, t2, t3])
    print(total)


if __name__ == '__main__':
    main()