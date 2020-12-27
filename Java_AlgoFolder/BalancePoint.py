#  Write a function that takes an array 'function balancePoint(arr)' and returns true if there exists a 'balance point' in the array
#  between indicies, where one side's sum is equal to the others
# Example [1, 2, 4, 4, -1, 4] should return 'true'
# 1 + 2 + 4 = 7
# 4 + -1 + 4 = 7


def balancePoint(arr):
    sum = 0
    sum2 = 0
    for i in range(len(arr)):
        sum += arr[i]
    sum /= 2
    print (sum)
    for j in range(len(arr)):
        sum2 += arr[j]
        print (sum2)
        if sum2 == sum:
            return True
    return False





print(balancePoint([1, 2, 4, 4, -1, 4]))
print(balancePoint([1, 2, 4, 4, 4]))



