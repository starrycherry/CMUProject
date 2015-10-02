'''
Created on Oct 28, 2012

@author: Cherrie
'''
def date(month, day):
    """Given numbers month and day, returns a string of the form '2/12', with the month followed by the day."""
    return str(month) + "/" + str(day)

print date(2, 12)

def count(str):
    print str.count("1")
    
count("1lll1l1l1l1ll1l111ll1l1ll1l1ll1ll111ll1ll1ll1l1ll1ll1ll1ll1lll1l1l1l1l1l1l1l1l1l1l1l1ll1lll1l111ll1l1l1l1l1")
    
print "abccdaabcabcabc".count("abc")

print "1lll1l1l1l1ll1l111ll1l1ll1l1ll1ll111ll1ll1ll1l1ll1ll1ll1ll1lll1l1l1l1l1l1l1l1l1l1l1l1ll1lll1l111ll1l1l1l1l1".count("1")

print int("5")

print float("5")

import simplegui

# define draw handler
def draw(canvas):
    canvas.draw_circle([90, 200], 20, 10, "White")
    canvas.draw_circle([210, 200], 20, 10, "White")
    canvas.draw_line([50,180],[250,180],40,"Red")
    canvas.draw_line([55,170],[90,120],5,"Red")
    canvas.draw_line([90,120],[130,120],5,"Red")
    canvas.draw_line([180,108],[180,160],140,"Red")

# create frame
frame = simplegui.create_frame("Text drawing", 300, 300)

# register draw handler    
frame.set_draw_handler(draw)

# start frame
frame.start()



# Takes input n and computes output named result

import simplegui

# global state

n=217

# helper functions

    
def get_next(result):
   if result==1:
        timer.stop()

# timer callback

def update():
    """???  Part of mystery computation."""
    global n
    if n%2 == 0:
        n=n/2
    else:
        n= n*3+1
    print str(n)
    get_next(n)

# register event handlers

timer = simplegui.create_timer(1, update)

# start program
timer.start()
#http://www.codeskulptor.org/#user4-Om8FesdlZa-0.py