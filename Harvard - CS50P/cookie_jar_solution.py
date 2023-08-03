class Jar:
    def __init__(self, capacity = 12):
        if capacity <= 0:
            raise ValueError("Needs to be non-negative")
        self.capacity = capacity
        self.size = 0 # set the initial size to zero
        
    def __str__(self):
        return "🍪" * self.size
    
    def deposit(self, n):
        if n < 0:
            raise ValueError("Cannot deposit negative")
        if n + self.size > self.capacity:
            raise ValueError("Cookiejar full")
        self.size = self.size + n
        return self.size
    
    def withdraw(self, n):
        if n < 0:
            raise ValueError("Cannot withdraw negative")
        if self.size - n < 0:
            raise ValueError("No cookies left!")
        self.size = self.size - n
        return self.size
    
    def capacity(self):
        return self.capacity
    
    def size(self):
        return self.size
    
oJar = Jar(6)
oJar.deposit(3)
oJar.withdraw(1)
print(oJar.size)
print(oJar)