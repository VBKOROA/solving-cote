from collections import Counter
from typing import List

def solution(participant: List[str], completion: List[str]) -> str:
    participant_counter = Counter(participant)
    completion_counter = Counter(completion)
    
    return next(iter(participant_counter - completion_counter))