#  Write a function that takes an array 'function balanceIndex(arr)' that checks for a balance point 'on' a given index
#  and returns the index if it exists and '-1' if there is no balance point
# Example [-2, 5, 7, 0, 3] should return '2'
# -2 + 5 = 3 
# 0 + 3 = 3
# the value at the index is not counted when considering the balance for this function


def balanceIndex(arr):
    leftSum= 0
    rightSum=0
    n=len(arr)
    for i in range (n):
        leftSum=0
        rightSum=0
        for j in range(i):
            leftSum +=arr[j]
        for j in range(i+1, n):
            rightSum+=arr[j]
        if leftSum==rightSum:
            return i
    return -1


print(balanceIndex( [-2, 5, 7, 0, 3]  ))
print(balanceIndex( [9, 9] ))
print(balanceIndex( [1,2,3] ))