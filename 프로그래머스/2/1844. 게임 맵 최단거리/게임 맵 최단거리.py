from collections import deque
from typing import List, Tuple

class State:
    __slots__ = ('coor', 'steps')
    
    def __init__(self, coor: Tuple[int, int], steps: int):
        self.coor = coor
        self.steps = steps
        
    def move_to(self, coor: Tuple[int ,int]):
        return State(coor[:], self.steps + 1)

MOVES = [
    (1, 0),
    (-1, 0),
    (0, 1),
    (0, -1)
]

def solution(maps: List[List[int]]):
    min_coor = (0, 0)
    max_coor = (len(maps[0]), len(maps))
    
    dest = (len(maps[0]) - 1, len(maps) - 1)
    cur_coor = (0, 0)
    
    visited: set[Tuple[int, int]] = {cur_coor}
    q: deque[State] = deque([State(cur_coor, 1)])
    
    while q:
        cur_state = q.popleft()
        cur_coor = cur_state.coor[:]
        
        if cur_coor == dest:
            return cur_state.steps
    
        for move in MOVES:
            new_coor = (cur_coor[0] + move[0], cur_coor[1] + move[1])
            
            if min_coor[0] > new_coor[0] or new_coor[0] >= max_coor[0] \
                or min_coor[1] > new_coor[1] or new_coor[1] >= max_coor[1]:
                continue
            
            if new_coor in visited:
                continue
            
            if maps[new_coor[1]][new_coor[0]] == 1:
                new_state = cur_state.move_to(new_coor)
                visited.add(new_coor)
                q.append(new_state)
                
    return -1