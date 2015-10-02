'''
Created on Oct 15, 2012

@author: Cherrie
'''
print "Hello World!"

print 1+2

my_name="cherrie"
print my_name

print 'She shouted "Hello!" very loudly.'

n=1236.45
print ((n - n % 10) % 100) / 10

def function(x):
    x=-5*x**5+69*x**2-47
    return x

print function(0)
print function(1)
print function(2)
print function(3)
    
def future_value(present_value, annual_rate, periods_per_year, years):
    rate_per_period = annual_rate / periods_per_year
    periods = periods_per_year * years
    
    
    # Put your code here.
    future_value=present_value*(1+rate_per_period)**periods
    return future_value

print future_value(500, .04, 10, 10)

print "$1000 at 2% compounded daily for 3 years yields $", future_value(1000, .02, 365, 3)
import math

def polygon_area(n,s):
    area=0.25*n*s**2/math.tan(math.pi/n)
    return area

print polygon_area(7,3)

def max_of_2(a, b):
    if a > b:
        return a
    else:
        return b

def max_of_3(a, b, c):
   return max_of_2(a, max_of_2(b, c))

print max_of_3(1,2,3)


def project_to_distance(point_x, point_y, distance):
    dist_to_origin = math.sqrt(point_x**2 + point_y**2)
    scale = distance / dist_to_origin
    print point_x * scale, point_y * scale
    
project_to_distance(2,7,4)

print -1%5


count = 0

def square(x):
    global count
    count += 1
    return x**2

print square(square(square(square(3))))
print count


buck=raw_input("Enter name:")
print buck


cherry=input("Enter a number:")
print cherry

import time

print time.gmtime(0)

