def contents(f):
	with open (f) as f1:
		return f1.read()

def sexp(s) :
	level,keep = 0,""
	while s:
		if s[0] == ";": # XXX3
			s = s[s.find("\n"):]
		if s[0] == "(": 
			level += 1
		if level > 0 and s[0] != "\n" and s[0] != " ": # XXXX1
			keep += s[0]
		if s[0] == ")": 
			level -= 1
			if level == 0: # XXX2
				yield keep
				keep = ""
		s = s[1:]
	if keep:
		yield keep

print "This is the output form 1.lisp"
for s in sexp(contents("1.lisp")):
	print s

print "This is the output from 2.lisp"
for s in sexp(contents("2.lisp")):
	print s

