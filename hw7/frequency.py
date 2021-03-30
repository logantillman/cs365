# Author: Logan Tillman

import sys

# Reading in the file name
file = sys.argv[1]

# Reading the data from the file
with open(file, 'r') as f:
    data = f.read()

# Splitting the words into a list
splitData = data.split()

# Creating the dictionary to hold our information
wordDict = {}

# Populating the dictionary
for word in splitData:

    # Grabbing the current word count, 0 if the word isn't found in the dictionary
    count = wordDict.get(word, 0)

    # Incrementing the word's count in the dictionary (inserting if it didn't already exist)
    wordDict.update({word: count + 1})

# Sorting the dictionary based on frequency, then the word itself
sortedDict = sorted(wordDict.items(), key=lambda word: (word[1], word[0]))

# Formatting and printing the information
for pair in sortedDict:
    line = '{0:20s} {1:5d}'.format(pair[0], pair[1])
    print(line)