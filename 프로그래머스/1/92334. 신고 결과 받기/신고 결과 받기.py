from typing import List

def solution(id_list: List[str], report: List[str], k: int):
    banned_users: set[str] = set()
    user_reported: dict[str, set[str]] = {
        id: set()
        for id in id_list
    }
    reported_counts: dict[str, int] = {
        id: 0
        for id in id_list
    }
    
    for entry in report:
        report_detail = entry.split(" ")
        reporter = report_detail[0]
        reported = report_detail[1]
        
        if not reported in user_reported[reporter]:
            user_reported[reporter].add(reported)
            reported_counts[reported] += 1
            
            if reported_counts[reported] == k:
                banned_users.add(reported)

    answer = []
                
    for id in id_list:
        total_mails = 0
        
        for banned_user in banned_users:
            if banned_user in user_reported[id]:
                total_mails += 1
                
        answer.append(total_mails)
        
    return answer