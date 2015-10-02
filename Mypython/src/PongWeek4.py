# Implementation of classic arcade game Pong

import simplegui
import random

# initialize globals - pos and vel encode vertical info for paddles
WIDTH = 600
HEIGHT = 400       
BALL_RADIUS = 20
PAD_WIDTH = 8
PAD_HEIGHT = 80
HALF_PAD_WIDTH = PAD_WIDTH / 2
HALF_PAD_HEIGHT = PAD_HEIGHT / 2
ball_pos=[WIDTH/2,HEIGHT/2]
ball_vel=[random.randrange(120, 240)/WIDTH,random.randrange(60, 180)/HEIGHT]
paddle1_pos=[HALF_PAD_WIDTH,HEIGHT/2]
paddle2_pos=[WIDTH-HALF_PAD_WIDTH,HEIGHT/2]
paddle1_vel=10
paddle2_vel=10
score1=0
score2=0

# helper function that spawns a ball, returns a position vector and a velocity vector

# if right is True, spawn to the right, else spawn to the left
def ball_init(right):
    global ball_pos, ball_vel # these are vectors stored as lists
    ball_pos=[WIDTH/2,HEIGHT/2] 
    ball_vel=[1,1]
    if right==True:
        ball_vel=[random.randrange(120, 240)/WIDTH,random.randrange(60, 180)/HEIGHT]
    else:
        ball_vel=[random.randrange(120, 240)/WIDTH,-random.randrange(60, 180)/HEIGHT]
   
    pass

# define event handlers
def init():
    global paddle1_pos, paddle2_pos, paddle1_vel, paddle2_vel,ball_pos,ball_vel  # these are floats
    global score1, score2  # these are ints
    ball_pos=[WIDTH/2,HEIGHT/2]
    ball_vel=[random.randrange(120, 240)/WIDTH,random.randrange(60, 180)/HEIGHT]
    paddle1_pos=[HALF_PAD_WIDTH,HEIGHT/2]
    paddle2_pos=[WIDTH-HALF_PAD_WIDTH,HEIGHT/2]
    paddle1_vel=10
    paddle2_vel=10
    score1=0
    score2=0
    pass

def draw(c):
    global score1, score2, paddle1_pos, paddle2_pos, ball_pos, ball_vel
 
    # update paddle's vertical position, keep paddle on the screen
    ball_pos[0]+=ball_vel[0]
    ball_pos[1]+=ball_vel[1]
    if ball_pos[0]<=BALL_RADIUS+PAD_WIDTH:
        if ball_pos[1]<=paddle1_pos[1]+HALF_PAD_HEIGHT-BALL_RADIUS and ball_pos[1]>=paddle1_pos[1]-HALF_PAD_HEIGHT-BALL_RADIUS:
            ball_vel[0]=-ball_vel[0]*(1+0.1)
        else:
            score2+=1
            ball_init(True)
    elif ball_pos[0]>=WIDTH-BALL_RADIUS-PAD_WIDTH:
        if ball_pos[1]<=paddle2_pos[1]+HALF_PAD_HEIGHT-BALL_RADIUS and ball_pos[1]>=paddle2_pos[1]-HALF_PAD_HEIGHT-BALL_RADIUS:
            ball_vel[0]=-ball_vel[0]*(1+0.1)
        else:
            score1+=1
            ball_init(False)
    if ball_pos[1]<=BALL_RADIUS or ball_pos[1]>=HEIGHT-BALL_RADIUS:
        ball_vel[1]=-ball_vel[1]
    
    # draw mid line and gutters
    c.draw_line([WIDTH / 2, 0],[WIDTH / 2, HEIGHT], 1, "White")
    c.draw_line([PAD_WIDTH, 0],[PAD_WIDTH, HEIGHT], 1, "White")
    c.draw_line([WIDTH - PAD_WIDTH, 0],[WIDTH - PAD_WIDTH, HEIGHT], 1, "White")
    c.draw_circle(ball_pos, BALL_RADIUS, 2, "Red", "White")
    
    # draw paddles
    c.draw_polygon([[0,(paddle1_pos[1]-HALF_PAD_HEIGHT)],[PAD_WIDTH,(paddle1_pos[1]-HALF_PAD_HEIGHT)],[PAD_WIDTH,(paddle1_pos[1]+HALF_PAD_HEIGHT)],[0,(paddle1_pos[1]+HALF_PAD_HEIGHT)]],1,"White","White")
    c.draw_polygon([[WIDTH - PAD_WIDTH,(paddle2_pos[1]-HALF_PAD_HEIGHT)],[WIDTH,(paddle2_pos[1]-HALF_PAD_HEIGHT)],[WIDTH,(paddle2_pos[1]+HALF_PAD_HEIGHT)],[WIDTH - PAD_WIDTH,(paddle2_pos[1]+HALF_PAD_HEIGHT)]],1,"White","White")
    # update ball
            
    # draw ball and scores
    c.draw_text(str(score1),[250,150],24,"White")
    c.draw_text(str(score2),[350,150],24,"White")    
    
def keydown(key):
    global paddle1_vel, paddle2_vel
    if key == simplegui.KEY_MAP["up"]:
        if paddle2_pos[1]>=HALF_PAD_HEIGHT:
            paddle2_pos[1] -= paddle2_vel
    elif key == simplegui.KEY_MAP["down"]:
        if paddle2_pos[1]<=HEIGHT-HALF_PAD_HEIGHT:
            paddle2_pos[1] += paddle2_vel
    elif key == simplegui.KEY_MAP["w"]:
        if paddle1_pos[1]>=HALF_PAD_HEIGHT:
            paddle1_pos[1] -= paddle1_vel
    elif key == simplegui.KEY_MAP["s"]:
        if paddle1_pos[1]<=HEIGHT-HALF_PAD_HEIGHT:
            paddle1_pos[1] += paddle1_vel
   
def keyup(key):
    global paddle1_vel, paddle2_vel
    if key == simplegui.KEY_MAP["up"]:
        if paddle2_pos[1]>=HALF_PAD_HEIGHT:
            paddle2_pos[1] -= paddle2_vel
    elif key == simplegui.KEY_MAP["down"]:
        if paddle2_pos[1]<=HEIGHT-HALF_PAD_HEIGHT:
            paddle2_pos[1] += paddle2_vel
    elif key == simplegui.KEY_MAP["w"]:
        if paddle1_pos[1]>=HALF_PAD_HEIGHT:
            paddle1_pos[1] -= paddle1_vel
    elif key == simplegui.KEY_MAP["s"]:
        if paddle1_pos[1]<=HEIGHT-HALF_PAD_HEIGHT:
            paddle1_pos[1] += paddle1_vel


# create frame
frame = simplegui.create_frame("Pong", WIDTH, HEIGHT)
frame.set_draw_handler(draw)
frame.set_keydown_handler(keydown)
frame.set_keyup_handler(keyup)
frame.add_button("Restart", init, 100)


# start frame
init()
frame.start()

#http://www.codeskulptor.org/#user4-i4bdxacNXf-3.py

