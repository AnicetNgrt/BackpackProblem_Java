# Test data generator for the Backpack problem by Anicet Nougaret
# How to run ?
#   - Install python 3
#   - linux/mac:  `python3 jdt_generator.txt`
#   - win:        `py jdt_generator.txt`
import random
import os

dir_path = os.path.dirname(os.path.realpath(__file__))

f = open(os.path.join(dir_path,'item_names.txt'),mode='r')
names = f.read().split(";")
f.close()

f = open(os.path.join(dir_path,'jdt.txt'), "+w")

itemCount = int(input("item count ? [>200 => JVM kapput]: "))
useNormal = input("Use uniform law [default] or normal law [N] ?: ").lower() == "n"

if(useNormal):
    pass
else:
    maxCost = float(input("max cost ?: "))
    minCost = float(input("min cost ?: "))
    maxWeight = float(input("max weight ?: "))
    minWeight = float(input("min weight ?: "))
    for i in range(0, itemCount):
        string = names[random.randint(0, len(names)-1)]
        string += " ; "+str(random.uniform(minWeight, maxWeight))
        string += " ; "+str(random.uniform(minCost, maxCost))
        string += "\n"
        f.write(string)

f.close()