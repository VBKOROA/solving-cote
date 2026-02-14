from collections import Counter
from typing import List
from itertools import combinations


def solution(orders: List[str], course: List[int]) -> List[str]:
    answer = []
    
    sorted_orders = [sorted(order) for order in orders]

    for course_item_count in course:
        course_combs: List[str] = []
        
        for order in sorted_orders:
            combs = combinations(order, course_item_count)
            course_combs += ["".join(comb) for comb in combs]

        counts = Counter(course_combs)
        
        if len(counts) == 0:
            continue
        
        max_count = max(counts.values())
        
        if max_count < 2:
            continue
        
        answer += [k for k, count in counts.items() if count == max_count]
        
    return sorted(answer)