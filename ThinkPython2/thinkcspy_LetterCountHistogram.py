def histogram(s):
    # Creating the dictionary and lists
    d = {}
    a = []
    b = []
    
    # Populating the dictionary
    for char in s:
        if char not in d:
            d[char] = 1
        else:
            d[char] += 1

    a = list(d.keys())
    
    # Sort the keys as per requirement for alphabetical order
    a.sort() 
    
    # Go through each letter in list a and match with value in dictionary d
    for q in a:
        b.append(d.get(q))
    
    # Create the histogram by using *
    for j in range(0,len(b)):
        b[j] = b[j]*"*"
    
    # Line them up next to each other to make it look like a histogram
    for k,v in zip(a,b):
        print(k,v)
        
histogram("b bbAcrceaz tezbbbbbzzzbzbb")