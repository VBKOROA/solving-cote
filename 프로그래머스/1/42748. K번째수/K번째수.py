from typing import List

def solution(array: List[int], commands: List[List[int]]):
    return [sorted(array[cmd[0] - 1:cmd[1]])[cmd[2] - 1] for cmd in commands]