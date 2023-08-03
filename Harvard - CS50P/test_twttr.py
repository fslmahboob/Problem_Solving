"""CS50P: Problem Set 5: Just setting up my twttr
Link: https://cs50.harvard.edu/python/2022/psets/5/test_twttr/

In a file called twttr.py, reimplement Setting up my twttr from Problem Set 2,
restructuring your code per the below, wherein shorten expects a str as input
and returns that same str but with all vowels (A, E, I, O, and U) omitted,
whether inputted in uppercase or lowercase.
Then, in a file called test_twttr.py, implement one or more functions that
collectively test your implementation of shorten thoroughly, each of whose
names should begin with test_ so that you can execute your tests with:
pytest test_twttr.py

Skills:
 -Unit Testing
 -Pytest
 -Thinking of edge/boundary cases

"""

from twttr import shorten

def test_capital():
    assert shorten('FAISAL') == 'FSL'
def test_small():
    assert shorten('faisal') == 'fsl'
def test_mix():
    assert shorten('MhIoeRaTOlWExcZB') == 'MhRTlWxcZB'
    assert shorten('hello, WORLD') == 'hll, WRLD'

def test_numbers():
    assert shorten('34128') == '34128'
    assert shorten('CS50') == 'CS50'

if __name__ == "__main__":
    main()