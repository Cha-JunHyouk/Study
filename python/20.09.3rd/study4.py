# 문자열 연산

# 문자열 더해서 연결하기
head="Python"
tail=" is fun"
print(head+tail)    # Python is fun

# 문자열 곱하기
a="Python"
print(a*2)          #PythonPython

# 문자열 곱하기 응용
multiString="My Program"
print("="*50)
print(multiString)
print("="*50)
"""
==================================================
My Program
==================================================
"""

#문자열 인덱싱
a="Life is too short, You need Python."
print(a[3])                             # 0부터 세서 4번째글자인 e가 출력
print(a[-1])                            # 뒤에서부터 세서 첫번째 글자인 .가 출력

#문자열 슬라이싱
#"Life"만 잘라서 출력하기
b=a[0]+a[1]+a[2]+a[3]
print(b)                                        #Life
print(a[0:4])                                   #Life   0<=a<3
print(a[:4])                                    #Life   앞을 생략할 경우 처음부터
print(a[:-31])                                  #Life
print(a[:])                                     #Life is too short, You need Python.
#문자열 슬라이싱 실사용 예
info="20200331Rainy"
date=info[:8]
weather=info[8:]
print(date)                                     #20200331
print(weather)                                  #Rainy

