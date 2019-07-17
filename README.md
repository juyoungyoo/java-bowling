# 볼링 게임 점수판
## 진행 방법
* 볼링 게임 점수판 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)


normalFrame
bowl(in: downPin, out: currentFrame)
    currentFrame.isFinish(out: boolean) // 현 프레임을 완료하는 지?
        currentFrame.next(out: nextFrame) createFrame
getState(in: index, out: state)

finalFrame
bowl(in: downPin, out: currentFrame)
    currentFrame.isFinish(out: boolean)
        currentFrame.next(out: X)
         
Frame 
 -> bowl(in: downPin, out: currentFrame)
 -> getState(out: frameState)
 -> isFinish(out: boolean)
 
----
- Step2. 기능 요구사항
- 사용자 1명의 볼링 게임 점수를 관리할 수 있는 프로그램을 구현한다.
각 프레임이 스트라이크이면 "X"
스페어이면 "9 | /"
미스이면 "8 | 1"과 같이 출력하도록 구현한다.

- 스트라이크(strike) : 프레임의 첫번째 투구에서 모든 핀(10개)을 쓰러트린 상태
- 스페어(spare) : 프레임의 두번재 투구에서 모든 핀(10개)을 쓰러트린 상태
- 미스(miss) : 프레임의 두번재 투구에서도 모든 핀이 쓰러지지 않은 상태
- 거터(gutter) : 핀을 하나도 쓰러트리지 못한 상태. 거터는 "-"로 표시
- 스트라이크는 다음 2번의 투구까지 점수를 합산해야 한다. 
- 스페어는 다음 1번의 투구까지 점수를 합산해야 한다.
- 10 프레임은 스트라이크이거나 스페어이면 한 번을 더 투구할 수 있다.
스페어는 다음 1번의 투구까지 점수를 합산해야 한다.

점수를 구하는 역할을 각 Frame 이 담당할 수 있도록 구현해 본다. 
Frame 이 자신의 점수를 구하려면 다음 Frame 에 접근할 수 있어야 한다. 
Frame 이 LinkedList 와 같은 자료 구조 기반으로 구현해 본다.

Frame 외부에서 점수를 계산해 set 하는 것이 아니라 
Frame 자체가 점수를 계산할 수 있도록 한다.

# 출력 결과
```
10 프레임 투구 : 10

|  NAME  |   01   |   02   |   03   |   04   |   05   |   06   |   07   |   08   |   09   |   10   |
|   10   |   X    |   X    |   X    |   X    |   X    |   X    |   X    |   X    |   X    | X|X|X  |
|        |   30   |   60   |   90   |  120   |  150   |  180   |  210   |  240   |  270   |  300   |
```
