package org.project.member.exceptions;

import org.project.global.exceptions.CommonException;
import org.springframework.http.HttpStatus;

public class MemberNotFoundException extends CommonException {
    public MemberNotFoundException(){
        super("NotFound.member", HttpStatus.NOT_FOUND);
        setErrorCode(true);
    }
}
