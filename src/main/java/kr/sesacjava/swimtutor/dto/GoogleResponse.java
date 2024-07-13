package kr.sesacjava.swimtutor.dto;

import java.util.Map;

public class GoogleResponse implements OAuth2Response{

  // 구글 데이터
  // {
  //   resultcode=00, message=success, id=123456789, name=홍길동
  // }

  private final Map<String, Object> attribute;

  public GoogleResponse(Map<String, Object> attribute) {
    this.attribute = attribute;
  }

  @Override
  public String getProvider() {
    return "google";
  }

  @Override
  public String getProviderId() {
    return attribute.get("sub").toString();
  }

  @Override
  public String getEmail() {
    return attribute.get("email").toString();
  }

  @Override
  public String getName() {
    return attribute.get("name").toString();
  }
}
