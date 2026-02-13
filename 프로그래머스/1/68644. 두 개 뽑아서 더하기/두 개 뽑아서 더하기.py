from typing import List


def solution(numbers: List[int]) -> List[int]:
    numbers_length = len(numbers)
    result = set()
    for i in range(numbers_length):
        for j in range(i+1, numbers_length):
            result.add(numbers[i] + numbers[j])
    return sorted(list(result))