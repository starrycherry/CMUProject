'''
Created on Nov 27, 2012

@author: Cherrie
'''
class Overload:
    def __init__(self,name):
        pass
    
   # def __init__(self,first,second):
        pass
    
a=Overload("a")
#b=Overload("b","c")


#class BankAccount:
#    def __init__(self, initial_balance=0):
#        """Creates an account with the given balance."""
#        self.account=initial_balance
#        self.fee=0
#
#    def deposit(self, amount):
#        """Deposits the amount into the account."""
#        self.account+=amount
#    
#    def withdraw(self, amount):
#        """Withdraws the amount from the account.  Each withdrawal resulting in a negative balance also deducts a fee of 5 dollars from the balance."""
#        self.fee+=5
#        self.account=self.account-amount-5
#            
#    def get_balance(self):
#        """Returns the current balance in the account."""
#        return self.account
#    
#    def get_fees(self):
#        """Returns the total fees ever accrued in the account."""
#        return self.fee
#    
#my_account = BankAccount(10)
#my_account.withdraw(5)
#my_account.deposit(10)
#my_account.withdraw(5)
#my_account.withdraw(15)
#my_account.deposit(20)
#my_account.withdraw(5) 
#my_account.deposit(10)
#my_account.deposit(20)
#my_account.withdraw(15)
#my_account.deposit(30)
#my_account.withdraw(10)
#my_account.withdraw(15)
#my_account.deposit(10)
#my_account.withdraw(50) 
#my_account.deposit(30)
#my_account.withdraw(15)
#my_account.deposit(10)
#my_account.withdraw(5) 
#my_account.deposit(20)
#my_account.withdraw(15)
#my_account.deposit(10)
#my_account.deposit(30)
#my_account.withdraw(25) 
#my_account.withdraw(5)
#my_account.deposit(10)
#my_account.withdraw(15)
#my_account.deposit(10)
#my_account.withdraw(10) 
#my_account.withdraw(15)
#my_account.deposit(10)
#my_account.deposit(30)
#my_account.withdraw(25) 
#my_account.withdraw(10)
#my_account.deposit(20)
#my_account.deposit(10)
#my_account.withdraw(5) 
#my_account.withdraw(15)
#my_account.deposit(10)
#my_account.withdraw(5) 
#my_account.withdraw(15)
#my_account.deposit(10)
#my_account.withdraw(5) 
#print my_account.get_balance(), my_account.get_fees()


print [1,2]+[3]

def test(a):
    n=a
    numbers=[i for i in range(2,n)]
    results=[]
    while len(numbers)>0:
        results.append(numbers[0])
        j=1
        while j<len(numbers):
            if numbers[j]%numbers[0]==0 and j!=i:
                numbers.pop(j)
            j+=1
        numbers.pop(0)
    return len(results)
            
print test(5000)

def question8():
    slow=1000
    fast=1
    year=0
    while slow>=fast:
        slow=slow*2
        fast=fast*2
        slow=slow*(1-0.4)
        fast=fast*(1-0.3)
        year+=1
    return year

print question8()
    
            
            
        