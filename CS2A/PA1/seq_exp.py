def seq_exp(nums):
    """
    Iteration - Takes in a list of numbers as input, and then exponentiates
    each element in the list starting at the first element by exponentiating
    it by 0, then incrementing the exponent by one for the next element, and
    so on until the end of the list. Returns new list after exponentiating.
    Example answers:
        seq_exp([2,3,4,5,6,7]) = [1, 3, 16, 125, 1296, 16807]
        seq_exp([3,6,9,12,15]) = [1, 6, 81, 1728, 50625]
        seq_exp([5,10,15,20,25]) = [1, 10, 225, 8000, 390625]
    """
    count = 0
    for i in nums:
        nums[count] = i**count
        count += 1
    return nums

if __name__ =="__main__":
    print("This program will exponentiate each element in the list beginning")
    print("with 0, then incrementing the exponent by 1 after each element.")
    nums = []
    user_input = input("Enter a number: ")
    while user_input != "X":
        number = int(user_input)
        nums.append(number)
        user_input = input("Enter a number, or type X to exit: ")
    result = seq_exp(nums)
    print("Sequential exponentiation result = "+str(result))
