# template for "Stopwatch: The Game"
import simplegui
import math

# define global variables
time=0
message="0:00:0"
score="0/0"
c=0
x=0
y=0

# define helper function format that converts integer
# counting tenths of seconds into formatted string A:BC.D
def format(t):
    global message,c
    a=int(t/600)
    b=int((t-a*600)/10)
    if b<10:
        bstr="0"+str(b)
    c=int((t%600)-b*10)
    message=str(a)+":"+bstr+"."+str(c)
    
def getScore():
    global x,y,score
    score=str(x)+"/"+str(y)
    
# define event handler for timer with 0.1 sec interval
def tick():
    global time
    time=time+1
  
#define event handler for draw
def draw(canvas):
    global time,score
    format(time)
    canvas.draw_text(message,[100,100],36,"Red")
    canvas.draw_text(score,[260,20],16,"Red")
    
# define event handler for start game
def start():
    timer.start()

# define event handler for stop game
def stop():
    global c,x,y
    y=y+1
    if c==0:
        x=x+1
    getScore()
    timer.stop()
    
# define event handler for restart game
def reset():
    global time,socre,x,y
    time=0
    score="0/0"
    x=0
    y=0
    getScore()
    timer.start()

# create frame
frame = simplegui.create_frame("Stopwatch", 300, 200)

# register event handlers
timer=simplegui.create_timer(100,tick)
frame.set_draw_handler(draw)
frame.add_button("Start",start,100)
frame.add_button("Stop",stop,100)
frame.add_button("Reset",reset,100)

# start timer and frame
frame.start()



# remember to review the grading rubric
http://www.codeskulptor.org/#user4-GDNYl9Gd0e-4.py


# remember to review the grading rubric