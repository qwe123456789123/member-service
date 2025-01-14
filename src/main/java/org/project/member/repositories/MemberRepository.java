package org.project.member.repositories;

import org.project.member.entities.Member;
import org.project.member.entities.QMember;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long>, QuerydslPredicateExecutor<Member> {
    @EntityGraph("authorities")
    Optional<Member> findByEmail(String email);
    default boolean exists(String email) {
        QMember member = QMember.member;

        return exists(member.email.eq(email));
    }
}
