from typing import List

def solution(citations: List[int]):
    citations.sort()
    total_papers = len(citations)
    
    for idx in range(total_papers):
        h = total_papers - idx
        
        if h <= citations[idx]:
            return h

    return 0