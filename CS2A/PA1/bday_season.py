def bday_season(month, day):
    """
    Conditional Execution - Takes in the number of month and day user was
    born, then checks if it was after or before an equinox or solstice to
    determine the season. It ultimately returns the name of season represented
    as a String.
    Example answers:
        bday_season(3, 30) = "Spring"
        bday_season(8, 12) = "Summer"
        bday_season(12, 25) = "Winter"
    """
    if month == 3 or month == 4 or month == 5:
        if month == 3 and day < 20:
            return "Winter"
        else:
            return "Spring"
    elif month == 6 or month == 7 or month == 8:
        if month == 6 and day < 21:
            return "Spring"
        else:
            return "Summer"
    elif month == 9 or month == 10 or month == 11:
        if month == 9 and day < 22:
            return "Summer"
        else:
            return "Fall"
    else:
        if month == 12 and day < 21:
            return "Fall"
        else:
            return "Winter"


if __name__ == "__main__":
    print("This program will find what season your birthday is during.")
    user_month = int(input("Please enter your birth month (1-12): "))
    user_day = int(input("Please enter your birth day (1-28 or 30 or 31): "))
    print("Your birthday season is "+bday_season(user_month, user_day)+".")
