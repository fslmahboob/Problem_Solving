"""
As an exercise, write a Deck method named sort that uses the list method sort to sort the
cards in a Deck. sort uses the __lt__ method we defined to determine the order

Skills:
-OOP
-Sort methods with operator overloading

Status: Complete
"""
import random

class Card:
    """Represents a standard playing card."""
    suit_names = ['Clubs', 'Diamonds', 'Hearts', 'Spades']
    rank_names = [None, 'Ace', '2', '3', '4', '5', '6', '7',
                  '8', '9', '10', 'Jack', 'Queen', 'King']

    def __init__(self, suit=0, rank=2):  # default card is 2 of clubs
        self.suit = suit
        self.rank = rank

    def __str__(self):
        return f"{Card.rank_names[self.rank]} of {Card.suit_names[self.suit]}"

    def __lt__(self, other):  # overriding operator to make comparisons easier
        if self.suit < other.suit: return True
        if self.suit > other.suit: return False

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
        self.cards.append(card)

    def shuffle(self):
        random.shuffle(self.cards)

    def sort(self):
        return self.cards.sort(reverse=True)


# queen_of_diamonds = Card(1, 12)
# print(queen_of_diamonds)
deck = Deck()
deck.shuffle()
deck.sort()
print(deck)


