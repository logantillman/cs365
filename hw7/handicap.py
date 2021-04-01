# Author: Logan Tillman

from golfer import Golfer
import sys
import datetime

scoreFile = sys.argv[1]
courseFile = sys.argv[2]

golferDict = {}

with open(scoreFile, 'r') as f:
    for line in f:
        splitLine = line.split()
        month = splitLine[0]
        day = splitLine[1]
        year = splitLine[2]
        time = datetime.datetime(int(year), int(month), int(day))
        name = splitLine[3]
        score = splitLine[4]
        courseArray = splitLine[5:]
        course = courseArray[0]
        for word in courseArray:
            if course != word:
                course += " " + word
        print(time, name, score, course)

        # Check the dictionary to see if the golfer exists
        golfer = golferDict.get(name, 0)

        # If the golfer doesn't exist, we create it and add it to the dictionary
        if golfer == 0:
            golfer = Golfer(name)
            golferDict.update({name: golfer})
        
        # If the golfer already exists, we add the score and time to their lists
        else:
            golfer.addScore(score, time)
        print(golfer.lastName, golfer.scores, golfer.times)
        
