package org.project.member.entities;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.project.member.constants.Authority;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class AuthoritiesId {
    private Member member;
    private Authority authority;
}

