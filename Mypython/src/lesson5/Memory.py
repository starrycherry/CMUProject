'''
Created on Nov 26, 2012

@author: Cherrie
'''
# implementation of card game - Memory

import simplegui
import random
memory=[]
exposed=[]
count=0

# helper function to initialize globals
def init():
    global memory,exposed,count
    memory=[(i%8) for i in range(16)]
    random.shuffle(memory)
    exposed=[False for i in range(16)]
    global state
    state = 0
    count=0
    l.set_text("Moves="+str(count))
  
# define event handlers
def mouseclick(pos):
    global exposed,state,first,second,memory,count
    i=int(pos[0]/50)
    if exposed[i]==False:
        if state == 0:
            exposed[i]=True
            first=i
            state = 1
        elif state == 1:
            exposed[i]=True
            second=i
            state = 2
        else:
            if memory[first]!=memory[second] and first!=second:
                exposed[i]=True
                exposed[first]=False
                exposed[second]=False
                first=i
            else:
                exposed[i]=True
                first=i
            state = 1
            count+=1
            l.set_text("Moves="+str(count))
    
                        
# cards are logically 50x100 pixels in size    
def draw(canvas):
    for i in range(16):
        if exposed[i]==True:
            canvas.draw_text(str(memory[i]), ((10+i*50), 70), 50, "White")
        else:
            canvas.draw_polygon([(0+i*50,0), (50+i*50, 0), (50+i*50, 100),[0+i*50,100]], 5, "Brown","Green")


# create frame and add a button and labels
frame = simplegui.create_frame("Memory", 800, 100)
frame.add_button("Restart", init)
l=frame.add_label("Moves = 0")

# initialize global variables
init()

# register event handlers
frame.set_mouseclick_handler(mouseclick)
frame.set_draw_handler(draw)

# get things rolling
frame.start()


# Always remember to review the grading rubric
#http://www.codeskulptor.org/#user6-Ry9HEWupTb4BpYA-0.py