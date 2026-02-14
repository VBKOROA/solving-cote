from typing import List


def solution(N: int, stages: List[int]):
    COMPLETE_STAGES_NUMBER = N+1
    
    fail_rates = {}
    
    for i in range(N):
        fail_rates[i+1] = 0.0
    
    sorted_stages = sorted(stages, reverse=True)
    current_stage = COMPLETE_STAGES_NUMBER
    passed_users = 0
    fails = 0
    users = len(sorted_stages)
    user_idx = 0
    
    while current_stage > 0 and user_idx < users:
        if sorted_stages[user_idx] == current_stage:
            if current_stage != COMPLETE_STAGES_NUMBER:
                fails += 1
            passed_users += 1
            user_idx += 1
        else:
            if fails != 0:
                fail_rates[current_stage] = fails / passed_users
                fails = 0
            current_stage -= 1
            
    # 만약 모든 stage를 순회하기 전에 user를 전부 순회했다면
    if fails != 0:
        fail_rates[current_stage] = fails / passed_users
            
    return [item[0] for item in sorted(fail_rates.items(), key=lambda item: -item[1])]
    

if __name__ == "__main__":
    print(solution(4, [4,4,4,4,4]))