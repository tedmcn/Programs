def findLines(word,file):
    for line in file:
        if line.find(word)>=0:
            print(line)

if __name__=="__main__":
    word = input("Enter a word to search for in R and J\n")
    file = open("romeo_and_juliet.txt",'r')
    findLines(word,file)
