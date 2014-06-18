#!/usr/bin/env python

from structs import *
import re

def paras(fileName):
    textFromFile =""# this is declaring a null string 
    with open(fileName) as f: #this opens the file as f
        for line in f: # this reads each line in the file 1 by 1
            textFromFile += re.sub('#.*',"",line.strip()+ "\n") #adds the line to the string while removing whitespace and comments
    return re.split('\n\n+', textFromFile) # this turns each paragraph into and element in an array


def _parser():
  n= 0
  for para in paras("310st.txt"):
    print "\n--|",n,"|----------------------"
    print para
    print "<end>"
    n += 1

_parser()


def graph(f) :
  g = Graph()
  for para in paras(f):
    lines = para.split("\n")  # split para into lines
    here  = g.newNode(lines[0])                      # the current node
    for currentLine in lines:   # for all the other lines
      if not ">" in currentLine:
        here.also(currentLine)              # update heres' description
      else:
        words       = currentLine.split(" ")           # split a goto line
        destination = words[1]           # where is the pointyLine sayign is our destination
        txt         = words[2:]           # what is the explanation text on the line
        there       = g.node(destination)       # where are we going?
        Edge(here,there,txt)          # connect here to there
  return g

print graph("310st.txt")
