package com.example.hello.domain;

import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

// Entity가 자동으로 컬럼으로 인식합니다.
@MappedSuperclass
// 생성/변경 시간을 자동으로 업데이트합니다.
@EntityListeners(AuditingEntityListener.class)
public class Timestamped {

@CreatedDate
@JsonSerialize
private LocalDateTime createdAt;

@LastModifiedDate
@JsonSerialize
private LocalDateTime modifiedAt;
}
