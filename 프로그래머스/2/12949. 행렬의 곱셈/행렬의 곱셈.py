from typing import List

def solution(arr1: List[List[int]], arr2: List[List[int]]) -> List[List[int]]:
    answer_width = len(arr2[0])
    answer_height = len(arr1)
    arr1_width = len(arr1[0])
    answer = [[] for _ in range(answer_height)]
    
    for i in range(answer_height):
        for j in range(answer_width):
            sums = 0
            for k in range(arr1_width):
                sums += arr1[i][k] * arr2[k][j]
            answer[i].append(sums)
        
    return answer