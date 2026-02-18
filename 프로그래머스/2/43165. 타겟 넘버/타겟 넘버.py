import sys
from typing import List

sys.setrecursionlimit(2 ** 20)

answer: int = 0

class State:
    __slots__ = ['total']
    
    nodes: List[int] = []
    nodes_len: int = 0
    
    def __init__(self, total: int):
        self.total = total
        
    @staticmethod
    def of(other: 'State'):
        return State(other.total)
    
    @staticmethod
    def set_nodes(nodes: List[int]):
        State.nodes = nodes[:]
        State.nodes_len = len(nodes)
    
def dfs(state: State, target: int, step: int):
    if step == State.nodes_len:
        if state.total == target:
            global answer
            answer += 1
        return
    
    new_state = State.of(state)
    new_state.total += State.nodes[step]
    dfs(new_state, target, step+1)
    
    new_state = State.of(state)
    new_state.total -= State.nodes[step]
    dfs(new_state, target, step+1)

def solution(numbers: List[int], target: int):
    State.set_nodes(numbers)
    dfs(State(0), target, 0)
    global answer
    return answer