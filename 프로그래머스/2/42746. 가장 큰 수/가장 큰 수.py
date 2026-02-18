from functools import cmp_to_key
from typing import List

def solution(numbers: List[int]):
    return str(int("".join(sorted([str(num) for num in numbers], key=cmp_to_key(lambda me, other: -1 if me+other > other+me else 1)))))