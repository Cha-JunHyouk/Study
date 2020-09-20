'''
딕셔너리 자료형
연관 배열을 나타내는 자료형
key값과 value값으로 나뉨
{key1:value1,key2:value2,key3:value3,...}
'''
a={1:'hi'}          # 기본적인 딕셔너리의 형태
a={'a':[1,2,3]}     # 리스트도 요소로 사용 가능

#딕셔너리 쌍 추가 및 삭제
#딕셔너리 쌍 추가
a={1:'a'}           # 딕셔너리 정의
a[2]='b'            # 2라는 key 값과 b라는 value 값이 입력
print(a)            # {1: 'a', 2: 'b'}
a['name']='Pey'     # name이라는 key 값과 pey라는 value 값이 입력
print(a)            # {1: 'a', 2: 'b', 'name': 'Pey'}
a[3]=[1,2,3]        # 3이라는 key 값과 [1,2,3]이라는 value 값이 입력
print(a)            # {1: 'a', 2: 'b', 'name': 'Pey', 3: [1, 2, 3]}

#딕셔너리 요소 추가
del a[1]
print(a)            # {2: 'b', 'name': 'Pey', 3: [1, 2, 3]}

#딕셔너리에서 key 사용해서 value 얻기
grade = {'pey': 10, 'julliet': 99}
print(grade['pey'])                 # 10
print(grade['julliet'])             # 99

'''
중복된 key값을 사용했다면 print할 시 무작위의 value 값이 봅혀나온다.
key값에 리스트를 사용할 수는 없다.(Typeerror 발생)
'''

#딕셔너리 관련 함수들
#key 리스트 만들기(keys)
a={'name':'pey','phone':'0119993323','birth':'1118'}
print(a.keys())                                         # 객체 리턴, dict_keys(['name', 'phone', 'birth'])
print(list(a.keys()))                                   # 리스트 리턴, ['name', 'phone', 'birth']

#Value 리스트 만들기(values)
print(a.values())                                       # 객체 리턴, dict_values(['pey', '0119993323', '1118'])
print(list(a.values()))                                 # 리스트 리턴, ['pey', '0119993323', '1118']

#Key: Value 쌍 모두 지우기(clear)
a.clear()                                               # 딕셔너리 안의 모든 요소를 삭제
print(a)                                                # {}

#Key로 Value얻기(get)
a={'name':'pey','phone':'0119993323','birth':'1118'}
print(a.get('name'))                                    # a 딕셔너리 안의 name이라는 key의 value를 반환, pey
print(a.get('phone'))                                   # a 딕셔너리 안의 phone이라는 key의 value를 반환, 0119993323
print(a.get('foo', 'bar'))                              # 딕셔너리 안에 찾는 값이 없으므로 오른쪽의 default 값을 출력한다.

#해당 Key가 딕셔너리 안에 있는지 조사하기(in)
a={'name':'pey','phone':'0119993323','birth':'1118'}
print('name' in a)                                      # True
print('email' in a)                                     # False