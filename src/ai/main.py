import json
import os

# 모듈 불러오기
from fastapi import FastAPI
from langchain.chains import LLMChain
from langchain.prompts import PromptTemplate
from langchain_openai import ChatOpenAI
from pydantic import BaseModel


# JSON 페이로드의 예상 구조를 정의하는 Pydantic 모델
class Query(BaseModel):
    prompt: str
    stroke: str
    distance: int
    speed: int
    technique: str


# security 파일 불러오기
def load_secrets():
    script_dir = os.path.dirname(os.path.abspath(__file__))
    file_path = os.path.join(script_dir, 'security.json')
    with open(file_path, 'r') as file:
        return json.load(file)


# llm 객체 생성
def get_llm_model(name="gpt-4o-mini"):
    # llm 객체 생성
    llm = ChatOpenAI(
        temperature=0.1,  # 창의성 (0.0 ~ 2.0)
        max_tokens=2048,  # 최대 토큰수
        model_name=name,  # 모델명
    )
    return llm


# template을 이용하여 prompt 객체 생성
def get_prompt():
    # template 정의
    template = """
    다음은 수영 영법별 수준을 평가하는 기준입니다. md 태그로 제공합니다.
    -----
    # 수영 루틴
    
    ## 자유형
    
    ### 거리 (50분 동안 완주 가능 거리)
    - **초급**: 400m 보다 작음
    - **중급**: 800m 보다 작음
    - **상급**: 800m 와 같거나 큼
    
    ### 속도 (50m 완주)
    - **초급**: 60초 와 같거나 큼
    - **중급**: 45초 보다 크거나 같고, 60초 보다 작음
    - **상급**: 45초 보다 작음
    
    ### Technique
    - **초급**: 기본 자세
    - **중급**: 양측 호흡, 사이드 턴
    - **상급**: 플립 턴
    
    ## 배영
    
    ### 거리 (50분 동안 완주 가능 거리)
    - **초급**: 300m 보다 작음
    - **중급**: 500m 보다 작음
    - **상급**: 500m 와 같거나 큼
    
    ### 속도 (50m 완주)
    - **초급**: 75초 와 같거나 큼
    - **중급**: 55초 보다 크거나 같고, 75초 보다 작음
    - **상급**: 55초 보다 작음
    
    ### 기술
    - **초급**: 기본 자세
    - **중급**: 안정적 자세, 배영 턴
    - **상급**: 크로스 오버 턴
    
    ## 평영
    
    ### 거리 (50분 동안 완주 가능 거리)
    - **초급**: 300m 보다 작음
    - **중급**: 500m 보다 작음
    - **상급**: 500m 와 같거나 큼
    
    ### 속도 (50m 완주)
    - **초급**: 80초 와 같거나 큼
    - **중급**: 60초 보다 크거나 같고, 80초 보다 작음
    - **상급**: 60초 보다 작음
    
    ### 기술
    - **초급**: 글라이딩
    - **중급**: 돌핀 킥
    - **상급**: 물 속 스타트
    
    ## 접영
    
    ### 거리 (50분 동안 완주 가능 거리)
    - **초급**: 100m 보다 작음
    - **중급**: 300m 보다 작음
    - **상급**: 300m 와 같거나 큼
    
    ### 속도 (50m 완주)
    - **초급**: 70초 와 같거나 큼
    - **중급**: 50초 보다 크거나 같고, 70초 보다 작음
    - **상급**: 50초 보다 작음
    
    ### 기술
    - **초급**: 한팔 접영
    - **중급**: 양팔 접영
    - **상급**: 무호흡 양팔 접영 (25m)
    
    다음은 각 기준별 중요도를 퍼센테이지로 나타낸 것입니다.
    ### 중요도
    - 거리: 40,
    - 속도: 35,
    - 기술: 25
    -----
    출력형식: JSON
    출력예시: 
        영법: 접영
        수준: 초급
        설명: 거리 기준은 초급에 가까운 중급, 속도 기준은 초급 중에서도 느린 수준, 기술 기준은 중급으로 기준별 중요도와 보다 근접한 수준을 고려하였을 때 접영 수준은 초급으로 판단됩니다.
    json 속성: stroke, level, description
    -----
    instrcution: 위 기준을 참고하여 질의에 답변해 주세요. 만약 명확하지 않다면 판정불가 판정을 내려주세요.
    ------
    질문: {stroke}의 경우 50분 동안 {distance}미터를 수영할 수 있고 속도는 {speed}초입니다. 최근 {technique} 기술을 배웠습니다.
    """
    prompt = PromptTemplate.from_template(template=template)
    return prompt


def get_llm_chain():
    return LLMChain(prompt=get_prompt(), llm=get_llm_model())


app = FastAPI()


@app.post("/prompt/")
async def create_item(item: Query):
    secrets = load_secrets()
    os.environ['OPENAI_API_KEY'] = secrets['OPENAI_API_KEY']

    # 연결된 체인(Chain) 객체 생성
    llm_chain = get_llm_chain()

    # llm_chain에 맞게 inputs 전달
    response = llm_chain.invoke({
        "prompt": item.prompt,
        "stroke": item.stroke,
        "distance": item.distance,
        "speed": item.speed,
        "technique": item.technique
    })

    return {"completion": response}


if __name__ == "__main__":
    import uvicorn

    uvicorn.run(app, host="127.0.0.1", port=8000)
    # uvicorn.run(app, host="52.195.187.190", port=8000)
