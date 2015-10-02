'''
Created on Nov 4, 2012

@author: Cherrie
'''
a=["this","course","is","great"]
print a[1:3]

import math
x=[4,7]
y=[2,9]
dis=math.sqrt((x[0]-y[0])**2+(x[1]-y[1])**2)-2
print dis

a = [49, 27, 101, -10]
b = a
c = list(a)
d = c
a[3] = 68
c[2] = a[1]
b = a[1:3]
b[1] = c[2]
print b

position = [50,50]
delta = [1,-2]
position = position + delta
print position

#http://www.codeskulptor.org/#user4-scdrmqFjLy-0.py

#http://www.codeskulptor.org/#user4-MgvwTNF1DV-0.py