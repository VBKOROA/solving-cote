from typing import List

class PriceInfo:
    def __init__(self, idx: int, price: int):
        self.idx = idx
        self.price = price

def solution(prices: List[int]) -> List[int]:
    answer = [i for i in reversed(range(len(prices)))]
    price_stack: List[PriceInfo] = []
    
    for idx, price in enumerate(prices):
        while price_stack and price_stack[-1].price > price:
            lower_price = price_stack.pop()
            answer[lower_price.idx] = idx - lower_price.idx
            
        price_stack.append(PriceInfo(idx, price))
        
    return answer