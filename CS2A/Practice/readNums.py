def readNums():
    print("Enter a sequence of numbers")
    print("end with a zero")
    x = int(input("> "))
    vals = []
    while (x != 0):
        vals.append(x);
        x = int(input("> "))
    return(vals)
