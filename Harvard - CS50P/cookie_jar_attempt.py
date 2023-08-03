class Jar:
    def __init__(self, capacity = 12):
        if capacity <= 0:
            raise ValueError("Needs to be non-negative")
        self.capacity = capacity
        self.size = 0 # set the initial size to zero
        
    def __str__(self):
        return "🍪"*n # n should be replaced by self.size
    
    def deposit(self, n):
        if n < 0:
            raise ValueError("Cannot deposit negative")
        if n > self.capacity: # should be n + self.size > self.capacity
            raise ValueError("Cookiejar full")
        self.size = self.size + n
        return self.size
    
    def withdraw(self, n):
        if n < 0:
            raise ValueError("Cannot withdraw negative")
                              # need to add self.size - n < 0
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
#print("# of cookies: ", check_size)
#new_size = oJar.deposit(4)
#print("Current size: ", new_size)
#print("# of cookies: ", check_size)