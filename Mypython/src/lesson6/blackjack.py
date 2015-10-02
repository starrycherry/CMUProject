'''
Created on Nov 28, 2012

@author: Cherrie
'''
# Mini-project #6 - Blackjack

import simplegui
import random

# load card sprite - 949x392 - source: jfitz.com
CARD_SIZE = (73, 98)
CARD_CENTER = (36.5, 49)
card_images = simplegui.load_image("http://commondatastorage.googleapis.com/codeskulptor-assets/cards.jfitz.png")

CARD_BACK_SIZE = (71, 96)
CARD_BACK_CENTER = (35.5, 48)
card_back = simplegui.load_image("http://commondatastorage.googleapis.com/codeskulptor-assets/card_back.png")    

# initialize some useful global variables
in_play = False
outcome = ""
score = 0
message="Hit or Stand?"

# define globals for cards
SUITS = ('C', 'S', 'H', 'D')
RANKS = ('A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K')
VALUES = {'A':1, '2':2, '3':3, '4':4, '5':5, '6':6, '7':7, '8':8, '9':9, 'T':10, 'J':10, 'Q':10, 'K':10}


# define card class
class Card:
    def __init__(self, suit, rank):
        if (suit in SUITS) and (rank in RANKS):
            self.suit = suit
            self.rank = rank
        else:
            self.suit = None
            self.rank = None
            print "Invalid card: ", suit, rank

    def __str__(self):
        return self.suit + self.rank

    def get_suit(self):
        return self.suit

    def get_rank(self):
        return self.rank

    def draw(self, canvas, pos):
        card_loc = (CARD_CENTER[0] + CARD_SIZE[0] * RANKS.index(self.rank), 
                    CARD_CENTER[1] + CARD_SIZE[1] * SUITS.index(self.suit))
        canvas.draw_image(card_images, card_loc, CARD_SIZE, [pos[0] + CARD_CENTER[0], pos[1] + CARD_CENTER[1]], CARD_SIZE)
        
# define hand class
class Hand:
    def __init__(self):
        self.cardList=[]

    def __str__(self):
        i=0
        s=""
        while i<len(self.cardList):
            s+=str(self.cardList[i])
            i+=1
        return s

    def add_card(self, card):
        self.cardList.append(card)

    # count aces as 1, if the hand has an ace, then add 10 to hand value if it doesn't bust
    def get_value(self):
        value=0
        for i in range(len(self.cardList)):
            value+=VALUES[self.cardList[i].get_rank()]
        rankList=[self.cardList[i].get_rank() for i in range(len(self.cardList))]
        for j in range(len(rankList)):
            if ('A' in rankList) and (value+10)<=21:
                value+=10
        return value
        

    def busted(self):
        if self.get_value()>21:
            return True
    
    def draw(self, canvas, p):
        if p=="player":
            for i in range (len (self.cardList)):
                canvas.draw_image(card_images,
    (CARD_CENTER[0]+RANKS.index(self.cardList[i].get_rank())*CARD_SIZE[0],CARD_CENTER[1]+SUITS.index(self.cardList[i].get_suit())*CARD_SIZE[1]),
     CARD_SIZE, (100+i*(CARD_SIZE[0]+40),450), CARD_SIZE)
        if p=="dealer":
            if in_play==True:
                canvas.draw_image(card_back,CARD_BACK_CENTER,
     CARD_BACK_SIZE, (100,250),CARD_SIZE)
                for i in range (1,len (self.cardList)):
                    canvas.draw_image(card_images,
        (CARD_CENTER[0]+RANKS.index(self.cardList[i].get_rank())*CARD_SIZE[0],CARD_CENTER[1]+SUITS.index(self.cardList[i].get_suit())*CARD_SIZE[1]),
         CARD_SIZE, (100+i*(CARD_SIZE[0]+40),250),CARD_SIZE)
            if in_play==False:
                for i in range (len (self.cardList)):
                    canvas.draw_image(card_images,
        (CARD_CENTER[0]+RANKS.index(self.cardList[i].get_rank())*CARD_SIZE[0],CARD_CENTER[1]+SUITS.index(self.cardList[i].get_suit())*CARD_SIZE[1]),
         CARD_SIZE, (100+i*(CARD_SIZE[0]+40),250),CARD_SIZE)
 
        
# define deck class
class Deck:
    def __init__(self):
        self.deckList=[]
        for i in range(len(SUITS)):
            for j in range (len(RANKS)):
                self.deckList.append(Card(SUITS[i],RANKS[j]))
        

    # add cards back to deck and shuffle
    def shuffle(self):
        random.shuffle(self.deckList)

    def deal_card(self):
        return self.deckList.pop(0)
    
    def __str__(self):
        i=0
        s=""
        while i<len(self.deckList):
            s+=str(self.deckList[i])
            i+=1
        return s



#define event handlers for buttons
def deal():
    global outcome, in_play,player,dealer,deck,message,score
    if in_play==True:
        score-=1
    outcome=""
    message="Hit or Stand?"
    player=Hand()
    dealer=Hand()
    deck=Deck()
    deck.shuffle()
    player.add_card(deck.deal_card())
    dealer.add_card(deck.deal_card())
    player.add_card(deck.deal_card())
    dealer.add_card(deck.deal_card())
  

    # your code goes here
    
    in_play = True

def hit():
    global in_play,player,deck,outcome,score
    if in_play==True:
        if player.get_value()<=21:
            player.add_card(deck.deal_card())
            if player.get_value()>21:
                outcome= "You went busted and lose."
                score-=1
                in_play=False
    
 
    # if the hand is in play, hit the player
   
    # if busted, assign an message to outcome, update in_play and score
       
def stand():
    global dealer,in_play,deck,player,outcome,message,score
    if in_play==True:
        while dealer.get_value()<17:
            dealer.add_card(deck.deal_card())
        if dealer.busted():
            outcome= "Dealer went busted and you win."
            score+=1
            in_play=False
        elif player.get_value()<=dealer.get_value():
            outcome= "You lose."
            score-=1
            in_play=False
        else:
            outcome= "You win."
            score+=1
            in_play=False
        message="New deal?"
   
    # if hand is in play, repeatedly hit dealer until his hand has value 17 or more

    # assign a message to outcome, update in_play and score

# draw handler    
def draw(canvas):
    # test to make sure that card.draw works, replace with your code below
    
    player.draw(canvas,"player")
    dealer.draw(canvas,"dealer")
    canvas.draw_text("Blackjack", (80, 100), 40, "Aqua")
    canvas.draw_text("Dealer", (60, 170), 20, "Black")
    canvas.draw_text("Player", (60, 370), 20, "Black")
    canvas.draw_text(message, (230, 370), 20, "Black")
    canvas.draw_text(outcome, (230, 170), 20, "Black")
    canvas.draw_text("Score "+str(score), (400, 100), 20, "Black")


# initialization frame
frame = simplegui.create_frame("Blackjack", 600, 600)
frame.set_canvas_background("Green")

#create buttons and canvas callback
frame.add_button("Deal", deal, 200)
frame.add_button("Hit",  hit, 200)
frame.add_button("Stand", stand, 200)
frame.set_draw_handler(draw)

# deal an initial hand
deal()

# get things rolling
frame.start()


# remember to review the gradic rubric
#http://www.codeskulptor.org/#user6-ZqPa6ZeRJo-2.py