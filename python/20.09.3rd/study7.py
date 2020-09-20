#고급 문자열 포매팅
#숫자 바로 대입하기
a="I eat {0} apples." .format(3)            # format 함수 사용. {0}부분에 대입
print(a)                                    # I eat 3 apples.

#문자열 바로 대입하기
a="I eat {0} apples." .format("five")       # format 함수 사용. {0}부분에 대입
print(a)                                    # I eat five apples.

#숫자 값을 가진 변수로 대입하기
num=4                                       # 변수에 숫자 입력
a="I eat {0} apples." .format(num)          # format 함수 사용. {0}부분에 대입
print(a)                                    # I eat 4 apples.

#2개 이상의 값 넣기
num=10                                      # 변수에 숫자 입력
day="three"                                 # 변수에 String 입력
sentence="I ate {0} apples. So I was sick for {1} days." .format(num,day)   #{0}부터 순차적으로 변수 대입
print(sentence)                             # I ate 10 apples. So I was sick for three days.
sentence="I ate {num} apples. So I was sick for {day} days." .format(num=10,day="three")    # {name}형태로 값 직접 입력
print(sentence)                             # I ate 10 apples. So I was sick for three days.
sentence="I ate {0} apples. So I was sick for {day} days." .format(10,day="three")   #혼용도 가능함
print(sentence)                             # I ate 10 apples. So I was sick for three days.

#문자열 정렬
a="{0:>10}" .format("hi")                   # 공간이 문자 10개인 문자열에서 hi를 오른쪽으로 정렬하여 출력함
print(a)                                    # '        hi'
a="{0:<10}" .format("hi")                   # 공간이 문자 10개인 문자열에서 hi를 왼쪽으로 정렬하여 출력함
print(a)                                    # 'hi        '
a="{0:^10}" .format("hi")                   # 공간이 문자 10개인 문자열에서 hi를 가운데로 정렬하여 출력함
print(a)                                    # '    hi    '
a="{0:=^10}" .format("hi")                  # 공간이 문자 10개인 문자열에서 hi를 가운데로 정렬하고, 공백을 =로 채움
print(a)                                    # '====hi===='
a="{0:*>10}" .format("hi")                  # 공간이 문자 10개인 문자열에서 hi를 오른쪽으로 정렬하고, 공백을 *로 채움
print(a)                                    # '********hi'
a="{0:@<10}" .format("hi")                  # 공간이 문자 10개인 문자열에서 hi를 왼쪽으로 정렬하고, 공백을 @로 채움
print(a)                                    # 'hi@@@@@@@@'

#소수점 표현하기
y=3.42134234                                # 변수에 숫자 입력
decimal="{0:10.4f}" .format(y)              # 공간이 문자 10개인 문자열에서 소수점 이하 4자리인 소수를 왼쪽으로 정렬하여 표현
print(decimal)                              # '    3.4213'

#{} 표현하기
a="{{and}}" .format()                       # 중괄호를 이중으로 넣어 중괄호 출력
print(a)                                    # {and}