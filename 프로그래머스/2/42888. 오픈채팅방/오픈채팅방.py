from typing import List


def solution(record: List[str]) -> List[str]:
    user_map = {}
    system_logs: List[List[str]] = []
    
    for i in record:
        strings = i.split(" ")
        
        if strings[0] == "Enter":
            user_map[strings[1]] = strings[2]
            system_logs.append(strings[:2])
        elif strings[0] == "Leave":
            system_logs.append(strings)
        elif strings[0] == "Change":
            user_map[strings[1]] = strings[2]
            
    final_logs = []
    
    for log in system_logs:
        if log[0] == "Enter":
            final_logs.append(f"{user_map[log[1]]}님이 들어왔습니다.")
        else:
            final_logs.append(f"{user_map[log[1]]}님이 나갔습니다.")
            
    return final_logs