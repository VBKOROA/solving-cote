test_cases_number = int(input())
answer = []

for i in range(test_cases_number):
    string = input()
    answer.append(f"{string[0]}{string[-1]}")
    
print("\n".join(answer))