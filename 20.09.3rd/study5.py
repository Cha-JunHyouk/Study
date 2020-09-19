#문자열 포매팅
int="I eat %d apples." %5                       # I eat 5 apples.
print(int)
string="I eat %s apples." %"five"               # I eat five apples.
print(string)
num=5                                           # 변수에 값 대입 후 문자열 포매팅
number="I eat %d apples." % num
print(number)                                   # I eat 5 apples.
cnt=10
day="three"
sentence="I ate %d apples. So I was sick for %s days." %(cnt,day)   #2개 이상의 값 넣기
print(sentence)                                 # I ate 10 apples. So I was sick for three days.
"""
%s : 문자열(String)
%c : 문자 1개(Character)
%d : 정수(Integer)
%f : 부동소수(Floating-point)
%o : 8진수
%x : 16진수
%% : Literal % (문자 % 자체)
"""

# 포맷코드와 숫자 함께 사용하기
# 정렬 및 공백
sort1="%10s" %"hi"          # 전체 길이가 10개인 문자열 공간에서 hi를 오른쪽으로 정렬하고 나머지는 공백으로
print(sort1)                #         hi
sort2="%10s" %"hihihihihi"  # 전체 길이가 10개인 문자열 공간에서 hihihihihi를 오른쪽으로 정렬하고 나머지는 공백으로 -> 10문자이므로 공백 없음
print(sort2)                # hihihihihi
sort3="%-10s" %"hi"         # 전체 길이가 10개인 문자열 공간에서 hi를 왼쪽으로 정렬하고 나머지는 공백으로
print(sort3)                # hi
sort4="%-10s" %"hihihihihi" # 전체 길이가 10개인 문자열 공간에서 hihihihihi를 왼쪽으로 정렬하고 나머지는 공백으로 -> 10문자이므로 공백 없음
print(sort4)                # hihihihihi
sort5="%-10sJane." %'hi'    # 전체 길이가 10개인 문자열 공간에서 hi를 오른쪽으로 정렬하고 나머지는 공백으로(jane은 범위에 들어가지 않음)
print(sort5)                # hi        Jane

# 소수점 표현하기
dcml1="%0.4f" %3.42134234   # .으로 소수점임을 나타내고 4로 표현할 소숫점 자릿수를 나타낸다.
print(dcml1)                # 3.4213
dcml2="%10.4f" %3.42134234  # 전체 길이가 10개인 문자열 공간에서 3.4213을 오른쪽으로 정렬하고 나머지는 공백으로
print(dcml2)                #     3.4213
