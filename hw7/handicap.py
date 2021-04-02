# Author: Logan Tillman

from golfer import Golfer, Course
import sys
import datetime

# Reading the command line arguments for the files
scoreFile = sys.argv[1]
courseFile = sys.argv[2]

# Creating the empty golfer dictionary
golferDict = {}

# Reading the score file
with open(scoreFile, 'r') as f:
    for line in f:
        splitLine = line.split()
        month = splitLine[0]
        day = splitLine[1]
        year = splitLine[2]
        time = datetime.datetime(int(year), int(month), int(day))
        name = splitLine[3]
        score = int(splitLine[4])
        courseArray = splitLine[5:]
        course = courseArray[0]

        # Building the course name
        for i, word in enumerate(courseArray):
            if i != 0:
                course += ' ' + word

        # Check the dictionary to see if the golfer exists
        golfer = golferDict.get(name, 0)

        # If the golfer doesn't exist, we create it and add it to the dictionary
        if golfer == 0:
            golfer = Golfer(name)
            golferDict.update({name: golfer})
        
        # Adding the score, time, and course to the golfer's lists
        golfer.addScore(score, time, course)
        
# Creating the empty course dictionary
courseDict = {}

# Reading the course file
with open(courseFile, 'r') as f: 
    courseName = ''
    rating = 0
    slope = 0
    for line in f:
        splitLine = line.split()

        # Checking to make sure the list isn't empty
        if len(splitLine) > 0:

            # If we're reading the 'Course' line, concatenate the course name together
            if splitLine[0] == 'Course':
                courseName = splitLine[1]
                for i, word in enumerate(splitLine):
                    if i != 0 and i != 1:
                        courseName += ' ' + word
            
            # If we're reading the 'Rating' line, create an instance of the course class and store it in the dictionary
            elif splitLine[0] == 'Rating':
                rating = float(splitLine[1])
                slope = float(splitLine[3])
                course = Course(courseName, rating, slope)
                courseDict.update({courseName: course})

# Create our empty handicap and golfer lists
handicapList = []
golferList = []

# Calculate the handicaps for each golfer
for golfer in golferDict:
    golferDict[golfer].sortLists()
    handicapList.append(golferDict[golfer].calculateHandicap(courseDict))
    golferList.append(golferDict[golfer].lastName)

# Sort the handicap and golfer lists
sortedGolfers = [x for (y, x) in sorted(zip(handicapList, golferList), key=lambda pair: pair[0])]
sortedHandicaps = sorted(handicapList)

# Print out the handicaps with their respective golfer in ascending order
for handicap, golfer in zip(sortedHandicaps, sortedGolfers):
    output = '{0:5.2f} {1:s}'.format(handicap, golfer)
    print(output)