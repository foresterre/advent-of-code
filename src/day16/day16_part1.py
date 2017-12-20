# rev 1: removed regex matchers

import re
import string

input = ""

with open('../../resources/day16/input.in') as file:
    input = file.read()

moves = input.split(",")

positions = list(string.ascii_lowercase[:16])

for move in moves:
    typeOfMove = move[0]

    if typeOfMove == "s":
        pos = int(move[1:])
        positions = positions[-pos:] + positions[:-pos]

    elif typeOfMove == "x":
        i, j = move[1:].split("/")
        positions[int(i)], positions[int(j)] = positions[int(j)], positions[int(i)]

    elif typeOfMove == "p":
        a, b = move[1:].split("/")
        index_a = positions.index(a)
        index_b = positions.index(b)
        positions[index_a], positions[index_b] = positions[index_b], positions[index_a]

print("res = ", "".join(positions))



