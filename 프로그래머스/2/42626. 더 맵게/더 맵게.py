import heapq
from typing import List

def solution(scoville: List[int], K: int) -> int:
    answer = 0
    pq = []
    
    for scov in scoville:
        heapq.heappush(pq, scov)
        
    while len(pq) >= 2 and pq[0] < K:
        first = heapq.heappop(pq)
        second = heapq.heappop(pq)
        
        heapq.heappush(pq, first + (second * 2))
        
        answer += 1
        
    if pq[0] < K:
        return -1
    
    return answer