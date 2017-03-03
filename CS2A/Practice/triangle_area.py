def triangle_area(a,b,c,d):
    """
    triangle_area(a,b,c,d)
        finds the are of the triangle_area
        with vertices (0,0), (a,b), (c,d)
        using the formula (ad-cb)/2
        Sample inputs are:
            (1,0) (0,1) -> 0.5
            (4,0) (4,3) -> 6.0
            (10,0) (5,2) -> 5.0
    """
    area = (a*d-b*c)/2
    return area

if __name__=="__main__":
    print("Enter two points (a,b) and (c,d): ")
    a = int(input("a: "))
    b = int(input("b: "))
    c = int(input("c: "))
    d = int(input("d: "))
    area = triangle_area(a,b,c,d)
    print("The points are: ")
    print(a,b,"and",c,d)
    print("The area of the triangle is",area)
