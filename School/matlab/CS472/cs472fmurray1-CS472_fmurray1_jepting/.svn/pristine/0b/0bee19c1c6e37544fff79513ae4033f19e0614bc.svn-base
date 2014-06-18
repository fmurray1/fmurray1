#!/usr/bin/env python
import random
import math

class kursawe:
    def __init__(self, l=None):
        if (l is None):
            self.l = [random.uniform(-5.0,5.0) for x in range(9)]
	    self.l[8] = 0.0
	    self.calc()
        else:
            self.l = l
    def __str__(self):
	print self.l

    def calc(self):
        for i in range (0, 8):
            self.l[8]+=(-10*(math.e)**((-0.2)*math.sqrt((self.l[i])**2+(self.l[i+1])**2)))
                       
    def mutate(self, rate):
        imax = len(self.l) - 1
        for i in range(imax):
            if random.random() <= rate:
                self.l[i] = random.uniform(-5.0,5.0)
        self.calc()

    def getObj(self):
        return self.l[8]
    def dup(self):
        return kursawe(l=self.l)

def getMean(meanRuns=25): ## this should work now... I hope
    mean = 0.0
    tiny = 10**-32
    x = [-1.0*tiny,tiny]
    for i in range(meanRuns):
        k = kursawe()
        if x[0] < k.getObj():
            x[0]= k.getObj()
        if x[1] > k.getObj():
            x[1]= k.getObj()
        mean += k.getObj()
        print "Run " +`i` +": " + `k.getObj()`
    print "Min: " + `x[0]`
    print "Max: " + `x[1]`
    mean /=meanRuns
    print "Mean: " + `mean`
    test = [mean]+x
    return test


def p(old,new,t):
    return math.e**((old-new)*1.0/t) ## according to menzies this is math.e, so its back to that, I need to normalize my scores now not sure where now

def normalize(x, val):
    if val < x[1]: x[1] = val
    if val > x[2]: x[2] = val
    return ((val - x[1])/((1.0*(x[2]-x[1]))+(10**(-32))))

def sa(kmax=1000.0, rate=0.33):
    x = getMean()
    curSol= kursawe()
    bestSol = curSol
    curSol = curSol.dup()
    initE = normalize(x,curSol.getObj())
    bestE = initE
    k = 1.0
    while k < kmax:
        if k%50 == 0:
            print ''
        neighborSol = curSol
	neighborSol.dup()
        neighborSol.mutate(rate)
        if normalize(x, neighborSol.getObj()) > bestE:
            bestE = normalize(x, neighborSol.getObj())
            bestSol = neighborSol
            print `round(bestE, 2)`,
        elif p(bestE, normalize(x, neighborSol.getObj()), ((k*1.0)/kmax)) > random.random(): ##this never jumps?!?! or jumps way too much (may have fixed it with the new score fxn
            curSol = neighborSol
            print '?',
        print '.',
        k +=1
    return bestSol.getObj()

print 'Best Solution \n'
print sa()
