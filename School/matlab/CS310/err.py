def ihaveSomeerrors(lst):
	"""run down the list, adding the
       first, third, firth etc items to output
    """
	out=""
	for x in xrange(0,len(lst)):
		if x%2 != 0:
			out +=lst[x] +" "
	return out


print ihaveSomeerrors(["one", "two", "three", "four", "five"])
