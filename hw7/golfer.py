class Golfer:
    def __init__(self, lastName):
        self.lastName = lastName
        self.scores = []
        self.times = []

    def addScore(self, score, time):
        self.scores.append(score)
        self.times.append(time)
