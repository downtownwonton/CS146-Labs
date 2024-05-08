'''
Created on May 7, 2024

@author: downtownwonton
'''

def coinChange(coins, amount: int) -> int:
    total = [float('inf')] * (amount + 1)
    total[0] = 0
    
    for i in range(1, amount + 1):
        for coin in coins:
            if i >= coin and total[i - coin] != 'inf':
                total[i] = min(total[i], total[i - coin] + 1)
            
    if total[amount] == 'inf':
        return -1
    return total[amount]

def main():
    coins = [2, 3, 5, 7]
    
    print(coinChange(coins, 0))
    
if __name__ == '__main__':
    main()
    
    