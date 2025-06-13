package com.example.LogIT_Server.domain;

import com.example.LogIT_Server.domain.common.BaseEntity;
import com.example.LogIT_Server.domain.enums.Gender;
import com.example.LogIT_Server.domain.enums.LoginType;
import com.example.LogIT_Server.domain.enums.UserStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@DynamicUpdate
@DynamicInsert
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Users extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column(nullable = false, length = 8)
    private String nickname;

    @Column(length = 15)
    private String username;

    @Column(length = 100)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column
    private LoginType loginType;

    @Column(length = 50)
    private String email;

    @Column(columnDefinition = "TEXT")
    private String profileImage;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column
    private UserStatus status;



    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<Records> recordsList = new ArrayList<>();

    // 변경 사항!!

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Owner> ownerList = new ArrayList<>();

}
