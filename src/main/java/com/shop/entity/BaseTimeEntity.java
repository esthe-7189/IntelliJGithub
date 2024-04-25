package com.shop.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@EntityListeners(value = {AuditingEntityListener.class}) //Auditing를 사용하기 위해
@MappedSuperclass //공통매핑 정보 필요시, 부모 클래스 상속받는 자식 클래스에 매핑 정보만 제고
@Getter @Setter
public abstract class BaseTimeEntity {

    @CreatedDate //엔티티 생성,저장 시간으로 자동 저장
    @Column(updatable = false)
    private LocalDateTime regTime; 

    @LastModifiedDate //엔티티값 변경시 시간으로 자동 저장
    private LocalDateTime updateTime;
}
