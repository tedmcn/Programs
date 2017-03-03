def variance(nums):
    """
    Calculator - Takes a list of values inputted by the user, then the list is
    traversed for each value in order to compute the average, and ultimately
    calculates the population variance by traversing again. Once found, it
    returns the float value of the variance.
    Example answers:
        variance([7,12,14,20]) = 21.6875
        variance([50,55,60,65,70,75,80]) = 100.0
        variance([123,234,345,456]) = 15401.25
    """
    average = 0
    variance = 0
    length = len(nums)
    for i in nums:
        average += i
    average = float(average)/length
    for i in nums:
        variance += (i-average)**2
    variance /= length
    return variance


if __name__ =="__main__":
    print("This program will calculate the variance of an inputted list.")
    nums = []
    user_input = input("Enter a number: ")
    while user_input != "X":
        number = int(user_input)
        nums.append(number)
        user_input = input("Enter a number, or type X to exit: ")
    result = variance(nums)
    print("The variance of the values is "+str(result)+".")
