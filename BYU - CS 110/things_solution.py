"""
To practice these concepts, write a program that prompts a person to input things. After they are done, print the list of things.

The number of things to input and the prompt text should be specified on the command line as arguments. For example:
python things.py 3 Fruit
Fruit: apple
Fruit: pear
Fruit: banana

- apple
- pear
- banana

Link: https://winter2023.byucs110.org/guide/unit4/program-arguments/

Skills:
-Command Line
-sys module & argv

Status: Complete
"""
# MY ATTEMPT THAT WORKS
import sys
#
# def fruit(num):
#     fruits = []
#     for i in range(num):
#         fruit = str(input("Enter Fruit: "))
#         fruits.append(fruit)
#     for f in fruits:
#         print('- ', f)
#
# if __name__ == '__main__':
#     num = int(sys.argv[1]) # every argument in sys.argv is a string
#     fruit(num)

# SOLUTION
def main (how_many, prompt):
    items = get_items(how_many, prompt)
    display_items(items)

def get_items(how_many, prompt):
    items = []
    while len(items) < how_many:
        item = input(prompt + ':')
        items.append(item)
    return items

def display_items(items):
    for item in items:
        print(f'- {item}')

if __name__ == '__main__':
    how_many = int(sys.argv[1])
    prompt = sys.argv[2]
    main(how_many, prompt)

