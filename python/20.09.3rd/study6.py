# 문자 개수 세기(count)
a="hobby"                       # 변수에 String 저장
cnt=a.count('b')                # 변수 내 b의 갯수를 카운트
print(cnt)                      # 2

#위치 알려주기1(find)
a="Python is best choice"       # 변수에 String 저장
find1=a.find('b')               # 변수 내 b의 위치를 탐색
print(find1)                    # 0부터 세어 11번째이므로 10
find2=a.find('k')               # 변수 내 k의 위치를 탐색
print(find2)                    # 존재하지 않으므로 -1

#위치 알려주기2(index)
a="Life is too short"           # 변수에 String 저장
index1=a.index('t')             # 변수 내 t가 처음 나온 위치를 탐색
print(index1)                   # 8
'''
index2=a.index('k')             # 변수 내 k가 처음 나온 위치를 탐색
print(index2)                   # 존재하지 않으므로 에러 발생
'''

#문자열 삽입(join)
a=","                           # 변수에 String 저장
join=a.join('abcd')             # 변수 내 각각 문자 사이에 ',' 삽입
print(join)                     # a,b,c,d

#소문자를 대문자로 바꾸기
a='hi'                          # 변수에 String 저장
b=a.upper()                     # 변수 내 문자를 대문자로 전환
print(b)                        # HI

#대문자를 소문자로 바꾸기
a=b.lower()                     # 앞서 선언한 b를 소문자로 변환
print(a)                        # hi

#공백 지우기
a=" hi "                        # 변수에 String 저장
lstrip=a.lstrip()               # 왼쪽의 연속된 모든 공백 지우기
print(lstrip)                   # 'hi '
rstrip=a.rstrip()               # 오른쪽의 연속된 모든 공백 지우기
print(rstrip)                   # ' hi'
strip=a.strip()                 # 양쪽의 연속된 모든 공백 지우기
print(strip)                    # 'hi'

#문자열 바꾸기(replace)
a="Life is too short"                   # 변수에 String 저장
replace=a.replace("Life","Your leg")    # 왼쪽의 String을 오른쪽의 String으로 치환
print(replace)                          # Ypur leg is too short

#문자열 나누기(split)
a="Life is too short"                   # 변수에 String 저장
split1=a.split()                        # 괄호 안에 아무것도 없을 시 공백 기준으로 문자열 나누기
print(split1)                           # ['Life', 'is', 'too', 'short']
b="ap:p:l:e"                            # 변수에 String 저장
split2=b.split(':')                     # 괄호 안에 들어간 문자를 기준으로 문자열 나누기
print(split2)                           # ['ap', 'p', 'l', 'e']
