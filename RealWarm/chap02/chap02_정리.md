[1] Tdd의 핵심은
- 기능을 검증하는 최소한의 테스트 케이스를 먼저 작성하고 이를 통과하기위한 최소한의 구현을 하는것이다.

[2] Tdd 개발절차
Red 단계에서는 실패하는 테스트 코드를 먼저 작성한다. 
Green 단계에서는 테스트 코드를 성공시키기 위한 실제 코드를 작성한다.   
Blue 단계에서는 중복 코드 제거, 일반화 등의 리팩토링을 수행한다.
 
중요한 것은 실패하는 테스트 코드를 작성할 때까지 실제 코드를 작성하지 않는 것과, 
실패하는 테스트를 통과할 정도의 최소 실제 코드를 작성해야 하는 것이다. 
이를 통해, 실제 코드에 대해 기대되는 바를 보다 명확하게 정의함으로써 불필요한 설계를 피할 수 있고, 
정확한 요구 사항에 집중할 수 있다.


 
