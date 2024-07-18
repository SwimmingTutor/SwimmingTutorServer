# 루틴 관련 페이지 흐름

## 1 새 루틴 생성

### Controller

- METHOD: `POST`
- URI: `/routine`

### 필요 정보 (RequestBody로 전달)

- 소셜 로그인 아이디
- 소셜 로그인 플랫폼
- 루틴 이름
- 레인 길이: 드롭다운 (25m, 50m)
- 목표 거리: default(1,000), 100 단위로 입력
- 영법 선택: '자유형, 배영, 평영, 접영' 중 사용자가 선택한 영법명

### 루틴 생성 로직

- 세션 구분
    - 워밍업 (30%)
        - `training_level`: 쉬움 100%
    - 코어 (60%)
        - `training_level`: 보통 30% > 어려움 40% > 보통 30% 순서
    - 쿨다운 (10%)
        - `training_level`: 쉬움 100%
- 훈련 구성
    - 하나의 루틴에서 동일한 훈련이 반복되지 않도록 배정
    - 루틴 생성 클릭 전 선택한 영법으로 `training_levle`에 맞춰 랜덤 배정
    - AI 활용 시 세션에 맞는 훈련으로 팔동작, 발차기 연습을 포함하여 다양하게 제공 및 추천 사유 제공

### 학인 필요

- 루틴 생성 시 세션별 `training_level` 고려 필요
- `training_for_routine` 적재 시 `session` 순서대로 정렬 필요
    - `session` 순서대로 정렬 필요
    - 현재 `training_id` 순서대로 정렬되어 있음

## 2 생성 루틴 목록

### Controller

- METHOD: `GET`
- URI: `/routine`

### DTO

- `routine_name`
- `pool_length`
- `target_distance`
- `sel_strokess`
- `created`
- `updated`

### 생성 로직

- `oauth_login` 정보를 기준으로 모든 정보 조회

### 확인 필요

- 조회 기준 변경 또는 추가 필요
    - 현재는 `findAll`로 전체 조회 (admin 페이지 구현 시 필요)
    - `oauth_login` 정보를 기준으로 조회 필요

## 3 루틴 상세 내용

### Controller

- METHOD: `GET`
- URI: `/routine/{routineNo}`

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
- `training`
    - `training_name`
    - `distance`
    - `sets`

### 생성 로직

- `routineId`를 기준으로 `routine`, `training_for_routine`, `training` 정보 조회
- `training_for_routine`의 `session` 순서대로 `training` 정보 조회

### 확인 필요

- `training` 정보는 `session` 순서대로 정렬 필요
    - 1번의 확인 필요사항 수정 시 같이 수정될 수 있음