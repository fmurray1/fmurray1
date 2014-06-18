import random
import math
from num import *

class Kursawe(Model):    
    def has(self):
        return [Num("!1", -5, 5),
                Num("!2", -5, 5),
                Num("!3", -5, 5),
                Num("!4", -5, 5),
                Num("!5", -5, 5),
                Num("!6", -5, 5),
                Num("!7", -5, 5),
                Num("!8", -5, 5),
                Num("+g1", 0, 0),
                Num("+g2", 0, 0),]
    def score(self, dataSet):
        g1 = g2 = 0.0
        for x in range(0, 8): 
            g1 += -10 * math.e**(-0.2 * (dataSet[x].value**2
                                  + dataSet[x+1].value**2)**0.5)
        for x in dataSet:
            if "!" in x.name:
                g2 += abs(x.value)**0.8 + (5 * math.sin(x.value**3))
        return [g1, g2]

class Fonseca(Model):
    def has(self):
        return [Num("!1", -4, 4),
                Num("!2", -4, 4),
                Num("!3", -4, 4),
                Num("+g1", 0, 0),
                Num("+g2", 0, 0),]

    def score(self, dataSet):
        g1 = g2 = 0.0
        for x in dataSet:
            if "!" in x.name:
                g1 += (x.value - 3**(-0.5))**2
                g1 = 1 - math.e**(g1 * -1)
        for x in dataSet:
            if "!" in x.name:
                g2 += (x.value + 3**(-0.5))**2
                g2 = 1 - math.e**(g2 * -1)
        return [g1, g2]

def sa(model, kmax, rate):
    bestSol = model.has()
    best = model.score(bestSol)
    k = 1.0 
    start = model.has() 
    bestSol = list(start) 
    print "start"
    while k < kmax:
        if k%50 == 0:
            print ''
        neighbor = list(start)
        for x in neighbor:
            if "!" in x.name and random.random() > rate:
               x.value =  x.mutate()
        nscore = model.score(neighbor)       
        if nscore > best:      
            bestSol = list(neighbor)
            best = nscore
            print round(best[0]),
        elif math.e**((best[0]-nscore[0])/k) >  (10 * random.random()):
            start = model.has()
            nscore = model.score(start)
            if nscore < best:
                print '?',
        print '.',
        k += 1
    print 'end'
    return 1
k = Kursawe()
f = Fonseca()
print sa(k,1000,0.33)
print sa(f,1000,0.33)

