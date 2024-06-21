# 루틴 관련 페이지 흐름

## 1 새 루틴 생성

### Controller

- METHOD: `POST`
- URI: `/routine`

### 필요 정보 (RequestBody로 전달)

- 레인 길이: 드롭다운 (25m, 50m)
- 목표 거리: default(1,000), 100 단위로 입력
- 영법 선택: 자유형, 배영, 평영, 접영

### 루틴 생성 로직

- 세션 구분
    - 워밍업 (30%)
        - `training_level` 구성: 쉬움 100%
    - 코어 (50%)
        - `training_level` 구성: 보통 30% > 어려움 40% > 보통 30% 순서
    - 쿨다운 (15%)
        - `training_level` 구성: 쉬움 100%
- 훈련 구성
    - 루틴 생성 클릭 전 선택한 영법으로 `training_level`에 맞춰 랜덤 배정
    - AI 활용 시 세션에 맞는 훈련으로 팔동작, 발차기 연습을 포함하여 다양하게 제공 가능

## 2 생성 루틴 목록

### Controller

- METHOD: `GET`
- URI: `/routine`

### DTO

- `routine`
    - `routine_name`
    - `created`

### 생성 로직

- `oauth_login` 정보를 기준으로 모든 정보 조회

## 3 루틴 상세 내용

### Controller

- METHOD: `GET`
- URI: `/routine/{routineId}`

### DTO

- `routine`
    - `routine_name`
    - `pool_length`
    - `target_distance`
    - `sel_strokess`
    - `created`
    - `updated`
- `training_for_routine`
    - `session`
    - `training_id`
- `training`
    - `training_name`
    - `distance`
    - `sets`

### 생성 로직

- 새 루틴 생성루틴 또는 루틴 목록에서 `routine_name`이나 `created` 선택
- `routine_id`로 `requestRoutineDTO`, `trainingForRoutineDTO` 가져오기
- `training_id`로 세션별 `trainingDTO` 가져오기