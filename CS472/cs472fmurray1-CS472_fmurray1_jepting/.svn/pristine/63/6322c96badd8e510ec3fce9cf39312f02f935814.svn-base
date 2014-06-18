import random
import math

def kursawe():
    l = [random.uniform(-5,5) for x in range(8)]
    l+=[0,0]
    for i in range (0, 8):
        ##print round(l[i], 2), i
        l[8]+=(-10*(math.e)**((-0.2)*math.sqrt((l[i])**2+(l[i+1])**2)))
    l[9]=0 ##using 9th index for thr score
    return l

def getMean(numSet):
    mean = 0
    meanRuns = 25
    x = [0,0,0,0]
    x[0] = -9999 ##quick fix due to some logic problems with finding the max value
    for i in range(meanRuns): 
        if x[0] < numSet[8]:
            x[0]=numSet[8]
        if x[1] > numSet[8]:
            x[1]=numSet[8] 
       ## if x[0] < k[9]: ##Technically this is not needed nor any other k[9]
         ##   x[2]=k[9] 
       ## if x[0] > k[9]: ##Technically we don't need this
         ##   x[3]=k[9]
        mean += numSet[8]
        ##print "Run " +`i` +": " + `k[8]` +", "
    ##print "Max1: " + `x[0]`
    ##print "Min1: " + `x[1]`
   ## print "Max2: " + `x[2]`
   ## print "Min2: " + `x[3]`
    mean /=meanRuns
    ##print "Mean: " + `mean`
    return mean



def mutate(mutateSol, rate):
    for i in range(0, 8):
        if random.random() > rate:
            mutateSol[i] = random.uniform(-5,5)
        mutateSol[8]+=(-10 * (math.e)**
                    ((-0.2) * math.sqrt((mutateSol[i])**2 + (mutateSol[i+1])**2))
                    )

        ##print round(mutateSol[k], 2)
    ##print '---'
    return mutateSol


def p(old,new,t): 
    return math.e**((old-new)/t)

def sa(kmax=33, rate=0.33):
    targetSol= kursawe()
    getMean(targetSol)
    
    k = 1.0 
    start = kursawe()
    start[9] = 100 - abs(targetSol[8] - start[8])
    bestSol = start 
    while k < kmax:
        if k%11 == 0:
            print ''
        neighbor = mutate(start, rate)
        neighbor[9] = 100 - abs(targetSol[8] - neighbor[8])
        print "Current E: ", round(neighbor[9]), "Best E: ", round(bestSol[9]),'\n'
        if neighbor[9] > bestSol[9]:      
            bestSol = neighbor
         ##   print round(neighbor[9]),
        elif p(bestSol[8], neighbor[8], k/kmax) > random.random() and neighbor[9] > 0: ##I think to make this jump you have to call kursawe again
            print '!',
            start = kursawe()
            start[9] = 100 - abs(targetSol[8] - start[8])
            if start[9] < bestSol[9]:
                print '?',
       ## print '.',
        k +=1
    print 'end'
    return  bestSol[9] 


print 'Best Solution \n'
print sa()
print ''
