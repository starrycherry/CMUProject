'''
Created on Oct 21, 2012

@author: Cherrie
'''
# template for "Guess the number" mini-project
# input will come from buttons and an input field
# all output for the game will be printed in the console
import random
import simplegui

# initialize global variables used in your code

secret=0
count=0

# define event handlers for control panel
def compare(guess):
    global secret
    if guess>secret:
        print "Lower!"
    if guess<secret:
        print "Higher!"
    if guess==secret:
        print "Correct!"
    print " "
        
def mycounting():
    global count
    count=count-1
    print "Number of remaining guesses is",count
    
def range100():
    # button that changes range to range [0,100) and restarts
    global secret,count
    count=7
    print "New Game,range is from 0 to 100"
    print "Number of remaining guesses is", count
    print " "
    
    secret=random.randrange(0,101)
    
def range1000():
    # button that changes range to range [0,1000) and restarts
    global secret,count
    count=10
    print "New Game,range is from 0 to 1000"
    print "Number of remaining guesses is", count
    print " "
    secret=random.randrange(0,1001)
    
def get_input(guess):
    # main game logic goes here    
    global secret
    print "Guess was",guess
    mycounting()
    compare(int(guess))
    
# create frame
f=simplegui.create_frame("Guess_The_Number",300,300)

# register event handlers for control elements
f.add_button("Range is (0,100)",range100,200)
f.add_button("Range is (0,1000)",range1000,200)
f.add_input("Enter a guess number:",get_input,100)

# start frame
f.start()

# always remember to check your completed program against the grading rubric
#http://www.codeskulptor.org/#user2-Vl5zSJWXh1-0.py

