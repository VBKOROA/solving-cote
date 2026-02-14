from collections import Counter
from typing import List

def solution(want: List[str], number: List[int], discount: List[str]):
    want_map = {}
    
    for wannt, num in zip(want, number):
        want_map[wannt] = num
        
    want_counter = Counter(want_map)
    discount_counter = Counter()
        
    for i in range(9):
        discount_counter.update([discount[i]])
        
    start_idx = 0
    end_idx = 9
    result = 0
    
    while end_idx < len(discount):
        discount_counter.update([discount[end_idx]])
        
        if len(want_counter - discount_counter) == 0: result += 1
        
        discount_counter.subtract([discount[start_idx]])
        start_idx += 1
        end_idx += 1
        
    return result