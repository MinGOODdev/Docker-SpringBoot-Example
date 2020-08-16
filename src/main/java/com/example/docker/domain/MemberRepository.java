package com.example.docker.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 설명 : N/A
 *
 * @author Minkuk Jo / mingood92@gmail.com / https://velog.io/@mingood
 * @since 2020. 08. 16.
 */
public interface MemberRepository extends JpaRepository<Member, Long> {
}
