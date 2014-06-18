#!/usr/bin/env python
""" This code contains no error checking -_-
it needs it for the user input
"""
for node in graph.nodes
	currentNode=node if node.start

while currentNode.stop is false
	print currentNode.description
	for node in currentNode.out
		print currentNode.out.index(node.name) + ") " + node.description
	nextNode = raw_input("Choose: ")
	currentNode = currentNode[int(nextNode)]
print currentNode.description
