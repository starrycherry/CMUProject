'''
Created on Nov 26, 2012

@author: Cherrie
'''
my_list=[1,2,3,4]
my_list+[10,20]
print my_list

print range(2, 16, 3)

def reverse_string(s):
    """Returns the reversal of the given string."""
    result = ""
    for char in s:
        result = char + result
    return result

print reverse_string("hello")

list=[0,1]
for i in range(39):
    list.append(int(list[i])+int(list[i+1]))
print list