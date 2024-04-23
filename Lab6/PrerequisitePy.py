'''
Created on Apr 22, 2024

@author: downtownwonton
'''
from collections import deque


def canFinish(numCourses, prerequisites):
    canFinish = True
    adjList = [[] for _ in range(numCourses)]
    inDegree = [0] * numCourses
        
    for prerequisite in prerequisites:
        outDegNode, inDegNode = prerequisite
        adjList[outDegNode].append(inDegNode)
        inDegree[inDegNode] += 1
            
    queue = deque()
    for i in range(numCourses):
        if inDegree[i] == 0:
            queue.append(i)
                
    count = 0
    while queue:
        course = queue.popleft()
        count += 1
        for neighbor in adjList[course]:
            inDegree[neighbor] -= 1
            if inDegree[neighbor] == 0:
                queue.append(neighbor)
                
    if count != numCourses:
        canFinish = False
            
    return canFinish
    
def printArray(array):
    for num in array:
        print(f"[{num[0]} {num[1]}] ", end='')
    print()

def main():
    hasCycle = [[1, 2], [2, 3], [3, 1]]
    printArray(hasCycle)
    print(canFinish(4, hasCycle))
    
    loop = [[1, 1]]
    printArray(loop)
    print(canFinish(2, loop))
    
    noCycle = [[1, 2], [2, 3], [3, 4], [2, 5]]
    printArray(noCycle)
    print(canFinish(6, noCycle))

if __name__ == "__main__":
    main()