#!/usr/bin/env python

import re

def match(matcher="ho", matchAgainst=["homo", "home", "hat", "hairy", "homosapien"]):
    return[match for match in matchAgainst if re.search(matcher, match)] 

if __name__ == "__main__":
    print match()    
