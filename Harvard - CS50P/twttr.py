"""CS50P: Problem Set 2: Just setting up my twttr
Link: https://cs50.harvard.edu/python/2022/psets/2/twttr/

When texting or tweeting, it’s not uncommon to shorten words to
save time or space, as by omitting vowels, much like Twitter was
originally called twttr. In a file called twttr.py, implement a
program that prompts the user for a str of text and then outputs
that same text but with all vowels (A, E, I, O, and U) omitted,
whether inputted in uppercase or lowercase.

Skills:
 -loops
 -conditional
 -list methods

"""


def main():
    print(shorten(str(input("Put in a string: "))))

def shorten(word):
    vowels1 = 'AEIOU'
    vowels2 = 'aeiou'
    word_list = []
    for letter in word:
        if (letter not in vowels1) and (letter not in vowels2):
            word_list.append(letter)
    final_str = ''.join(word_list)
    return final_str


if __name__ == "__main__":
    main()
