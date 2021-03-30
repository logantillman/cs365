# Author: Logan Tillman

import sys

# Grabbing the file name and number of lines to print
file = sys.argv[1]
n = int(sys.argv[2])

# Printing the last n lines of the file
with open(file, 'r') as f:
    data = f.readlines()
    print(''.join(data[-n:]))