"""
As an exercise, write an __lt__ method for Time objects. You can use tuple comparison,
but you also might consider comparing integers.

Skills:
-OOP
-operator overloading/magic methods

Status: Complete
"""

class Time:
    def __init__(self, hour=0, minute=0, second=0):
        self.hour = hour
        self.minute = minute
        self.second = second

    def __lt__(self, other):
        t1 = self.hour, self.minute, self.second
        t2 = other.hour, other.minute, other.second
        return t2 > t1


start = Time(9, 45, 28)
end = Time(9, 45, 56)

print(start < end)
print(end < start)