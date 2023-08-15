"""
Write a Deck method called deal_hands that takes two parameters, the number of
hands and the number of cards per hand.  It should create the appropriate number
of Hand objects, deal the appropriate number of cards per hand, and return a list
of Hands.

Skills:
-OOP
-Inheritance

Status: Complete
"""

import random

class Card:
    """Represents a standard playing card."""

    suit_names = ['Clubs', 'Diamonds', 'Hearts', 'Spades']
    rank_names = [None, 'Ace', '2', '3', '4', '5', '6', '7',
                  '8', '9', '10', 'Jack', 'Queen', 'King']

    def __init__(self, suit=0, rank=2):
        self.suit = suit
        self.rank = rank

    def __str__(self):
        return "{} of {}".format(Card.rank_names[self.rank], Card.suit_names[self.suit])

    def __lt__(self, other):
        # check the suits
        if self.suit < other.suit:
            return True
        if self.suit > other.suit:
            return False

        # suits are the same...check ranks
        return self.rank < other.rank

class Deck:

    def __init__(self):
        self.cards = []
        for suit in range(4):
            for rank in range(1, 14):
                card = Card(suit, rank)
                self.cards.append(card)

    def __str__(self):
        res = []
        for card in self.cards:
            res.append(str(card))
        return '\n'.join(res)

    def pop_card(self):
        return self.cards.pop()

    def add_card(self, card):
        return self.cards.append(card)

    def shuffle(self):
        random.shuffle(self.cards)

    def move_cards(self, hand, num):
        for i in range(num):
            hand.add_card(self.pop_card())

    def deal_hands(self, numH, numC):
        temp_list = []
        for i in range(numH):
            temp_list.append(Hand())
        for c in range(numC):
            for h in temp_list:
                card = self.pop_card()
                h.add_card(card)
        return temp_list

class Hand(Deck):
    """Represents a hand of playing cards."""

    def __init__(self, label=''):
        self.cards = []
        self.label = label

# Create a deck object
deck = Deck()

# Deal out deck to 3 hand objects with 2 cards per hand
list_h = deck.deal_hands(3, 2)

# Print results by looping over each object in the list of Hand objects

for i in range(len(list_h)):
    hand = list_h[i]
    print(f"Hand{i + 1}: {hand}")
