package org.project.member.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.project.global.exceptions.BadRequestException;
import org.project.global.libs.Utils;
import org.project.member.services.MemberUpdateService;
import org.project.member.validators.JoinValidator;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final Utils utils;
    private final MemberUpdateService updateService;
    private final JoinValidator joinValidator;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/join")
    public void join(@RequestBody @Valid RequestJoin form, Errors errors) {

        joinValidator.validate(form, errors);

        if (errors.hasErrors()) {
            throw new BadRequestException(utils.getErrorMessages(errors));
        }

        updateService.process(form);
    }
    @PostMapping("/login")
    public void login(@RequestBody @Valid RequestLogin form, Errors errors){

    }
}
