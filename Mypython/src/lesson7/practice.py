'''
Created on Dec 4, 2012

@author: Cherrie
'''
class Point2D:
    def __init__(self, x=0, y=0):
        self.x = x
        self.y = y

    def translate(self, deltax=0, deltay=0):
        """Translate the point in the x direction by deltax
           and in the y direction by deltay."""
        self.x += deltax
        self.y += deltay

#point = Point2D(3, 6)
#lst = list(point)


import math

print int(math.pow(24, 500))