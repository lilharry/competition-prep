def maxsubarrayH(A, i, solution):
    

def maxsubarray(A):
    
    solution = [A[0]]

    for i in range(1, n):
        solution.append(maxsubarrayH(A, i))
    
    return max(solution)

A = [-2, 1, -3, 4, -1, 2, 1, -5, 4]



print(maxsubarray(A, 0))


