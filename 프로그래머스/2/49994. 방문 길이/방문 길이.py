from typing import List

MIN_XY = -5
MAX_XY = 5
DIRECTION = {
    "U": (0, 1),
    "D": (0, -1),
    "R": (1, 0),
    "L": (-1, 0)
}

def is_valid_coor(x, y):
    if MAX_XY < x or x < MIN_XY:
        return False
    elif MAX_XY < y or y < MIN_XY:
        return False
    return True

def solution(dirs: str):
    moved_set: set[tuple[int, int, int, int]] = set()
    
    cur_x = 0
    cur_y = 0
    
    for dir in dirs:
        to_x = cur_x+DIRECTION[dir][0]
        to_y = cur_y+DIRECTION[dir][1]
        
        if not is_valid_coor(to_x, to_y): continue
        
        moved_set.add((cur_x, cur_y, to_x, to_y))
        moved_set.add((to_x, to_y, cur_x, cur_y))
        
        cur_x = to_x
        cur_y = to_y
        
    return int(len(moved_set)/2)
        
    
if __name__ == "__main__":
    print(solution("ULURRDLLU"))