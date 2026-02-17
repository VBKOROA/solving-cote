import heapq
from typing import List

class Job:
    def __init__(self, requested_time: int, turnaround_time: int):
        self.requested_time = requested_time
        self.turnaround_time = turnaround_time
        
    def __lt__(self, other: 'Job'):
        return self.turnaround_time < other.turnaround_time

def solution(jobs: List[List[int]]):
    # 일단 시간 순으로 정렬
    sorted_jobs = sorted(jobs, key=lambda job: job[0])
    jobs_len = len(sorted_jobs)
    turnaround_times = []
    pq: List[Job] = []
    jobs_idx = 0
    current_time = 0
    
    while not (jobs_idx >= jobs_len and not pq):
        
        while jobs_idx < jobs_len and sorted_jobs[jobs_idx][0] <= current_time:
            heapq.heappush(pq, Job(sorted_jobs[jobs_idx][0], sorted_jobs[jobs_idx][1]))
            jobs_idx += 1
            
        if not pq:
            current_time = sorted_jobs[jobs_idx][0]
            continue
                
        job = heapq.heappop(pq)
        
        current_time += job.turnaround_time
        turnaround_times.append(current_time - job.requested_time)
        
    return sum(turnaround_times) // jobs_len