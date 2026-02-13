from typing import List

def solution(answers: List[int]) -> List[int]:
    PATTERN_ONE = [1,2,3,4,5]
    PATTERN_TWO = [2,1,2,3,2,4,2,5]
    PATTERN_THREE = [3,3,1,1,2,2,4,4,5,5]
    
    scores = [0, 0, 0]
    
    for i, answer in enumerate(answers):
        if PATTERN_ONE[i % len(PATTERN_ONE)] == answer:
            scores[0] += 1
        if PATTERN_TWO[i % len(PATTERN_TWO)] == answer:
            scores[1] += 1
        if PATTERN_THREE[i % len(PATTERN_THREE)] == answer:
            scores[2] += 1
    
    max_scores = max(scores)
    
    return [i+1 for i, score in enumerate(scores) if score == max_scores]