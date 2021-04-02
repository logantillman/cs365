# Author: Logan Tillman

class Golfer:
    def __init__(self, lastName):
        self.lastName = lastName
        self.scores = []
        self.times = []
        self.courses = []

    # Adding information to the lists
    def addScore(self, score, time, course):
        self.scores.append(score)
        self.times.append(time)
        self.courses.append(course)

    # Sorting the lists based on time
    def sortLists(self):
        self.sortedScores = [x for (y, x) in sorted(zip(self.times, self.scores), key=lambda pair: pair[0])]
        self.sortedCourses = [x for (y,x) in sorted(zip(self.times, self.courses), key=lambda pair: pair[0])]

    # Calculating the golfer's handicap
    def calculateHandicap(self, courseDict):

        # Grabbing the 20 most recent scores
        scoresList = self.sortedScores[-20:]
        coursesList = self.sortedCourses[-20:]

        diffList = []

        # Calculating the differential and adding it to the list
        for score, course in zip(scoresList, coursesList):
            rating = courseDict[course].rating
            slope = courseDict[course].slope
            differential = (score - rating) * 113 / slope
            diffList.append(differential)

        # Sorting the differentials and grabbing the 10 lowest
        sortedDiffs = sorted(diffList)
        sortedDiffs = sortedDiffs[:10]
        
        # Calculating the average of the differentials
        sumDiffs = 0
        for diff in sortedDiffs:
            sumDiffs += diff
        sumDiffs /= 10

        # Returning 96% of the average 
        return (sumDiffs * .96)
        
class Course:
    def __init__(self, name, rating, slope):
        self.name = name
        self.rating = rating
        self.slope = slope