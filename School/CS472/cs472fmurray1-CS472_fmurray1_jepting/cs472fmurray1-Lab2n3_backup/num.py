import random
import math


class Num():
    def __init__(self, name, low, high):
        self.name = name
        self.low = low
        self.high = high
        self.value = random.uniform(low, high)
  
    def mutate(self):
        return random.uniform(self.low, self.high)

class Model():
    def __init__(self):
        self.ivars = []
        self.dmax = []
        self.dmin = []
