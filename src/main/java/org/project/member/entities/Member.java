package org.project.member.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.apache.tomcat.jni.FileInfo;
import org.project.global.entities.BaseEntity;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Member extends BaseEntity implements Serializable {
    @Id @GeneratedValue
    private Long seq; // 회원 번호

    @Column(length=65, nullable = false, unique = true)
    private String email; // 이메일

    @Column(length=65)
    private String password;

    @Column(length=40, nullable = false)
    private String name;

    @Column(length=100)
    private String addressSub;

    private boolean requiredTerms1;

    private boolean requiredTerms2;

    private boolean requiredTerms3;

    @Column(length=50)
    private String optionalTerms; // 선택 약관

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "member")
    private List<Authorities> authorities;

    // 비밀번호 변경 일시
    private LocalDateTime credentialChangedAt;

}