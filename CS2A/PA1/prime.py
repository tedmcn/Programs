def prime(num):
    """
    Tester - Takes an input number from the user and tests whether it is prime
    or not. Then, it returbns True or False depending on the number and prompts
    the user if it is prime or not. Returns True or False if prime or not.
    Example answers:
        prime(10)
        prime(227)
        prime(617)
    """
    for i in range(2, num):
        if num%i == 0 and i != num:
            return False
    return True

if __name__ =="__main__":
    print("This program will check if the inputted number is prime.")
    user_num = int(input("Enter value: "))
    if prime(user_num) == False:
        print("It is not a prime number.")
    else:
        print("It is a prime number.")
