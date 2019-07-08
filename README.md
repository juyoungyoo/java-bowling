# 볼링 게임 점수판
## 진행 방법
* 볼링 게임 점수판 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

---
# 요구사항

## 기능 요구사항

1. 최종 목표는 볼링 점수를 계산하는 프로그램을 구현한다. 
1단계 목표는 점수 계산을 제외한 볼링 게임 점수판을 구현하는 것이다.

2. 각 프레임이 스트라이크이면 "X", 스페어이면 "9 | /", 미스이면 "8 | 1", 과 같이 출력하도록 구현한다.
round 1
- 스트라이크(strike) : 프레임의 첫번째 투구에서 모든 핀(10개)을 쓰러트린 상태  / none
round 2   
- 스페어(spare) : 프레임의 두번재 투구에서 모든 핀(10개)을 쓰러트린 상태      / first  
- 미스(miss) : 프레임의 두번재 투구에서도 모든 핀이 쓰러지지 않은 상태        / first, second 

round 당 
- 치다(hit) : 핀을 쓰러트렸을 경우 
    - strike 
    - spare
    - miss 
- 거터(gutter) : 핀을 하나도 쓰러트리지 못한 상태. 거터는 "-"로 표시
    - miss
            
10 프레임은 스트라이크이거나 스페어이면 한 번을 더 투구할 수 있다.

```
플레이어 이름은(3 english letters)?: PJS
| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |
|  PJS |      |      |      |      |      |      |      |      |      |      |

1프레임 투구 : 10
| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |
|  PJS |  X   |      |      |      |      |      |      |      |      |      |

2프레임 투구 : 8
| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |
|  PJS |  X   |  8   |      |      |      |      |      |      |      |      |

2프레임 투구 : 2
| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |
|  PJS |  X   |  8|/ |      |      |      |      |      |      |      |      |

3프레임 투구 :  7
| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |
|  PJS |  X   |  8|/ |  7   |      |      |      |      |      |      |      |

3프레임 투구 :  : 0
| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |
|  PJS |  X   |  8|/ |  7|- |      |      |      |      |      |      |      |
```

# 요구사항
1. 플레이어의 이름을 입력받는다. (in: string)
- [x] (exception) 플레이어의 이름이 3글자 초과할 시 예외 처리 
 
2. 볼링게임을 시작한다.      
2-0. 10개의 프레임을 생성한다.        
- [ ] 프레임은 2번의 핀을 칠 기회가 있다. (round 2)
- [ ] 마지막 프레임은 라운드 3개를 갖는다. + round

- [ ] 프레임은 최대 2번의 라운드를 갖는다. (0 - 9)
- [ ] 10frame 에서 2번째 라운드까지 10 모두 처리 시 한번의 기회가 더 주어진다.
 
2-1.한 프레임 볼링을 친다.
- [ ] Bowling (in: pin count, out: FrameResult)
2-2. 현 프레임의 결과를 반환한다.
- [ ] getState (in: frameIndex, out: Result)

bowling (in: downPin, out: frameResult)


-- 볼링을 친다 -->bowling(in: downPin, out: frameResult)
-- frameResult -> 
 - gutter : current frame
 - hit  : current frame
 
 - strike : move frame
 - miss : move frame
 - spare : move frame 






Bowling Pin (추후)

Result Type
- [ ] strike : 다음 프레임으로 이동한다 / total score = 10 and round = 1
- [ ] spare : total score  == 10, round = 2
- [ ] miss  : total score  < 10 
- [ ] gutter : 프레임 total score : 0  

