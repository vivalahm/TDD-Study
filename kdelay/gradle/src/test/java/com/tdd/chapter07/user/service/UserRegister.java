package com.tdd.chapter07.user.service;

import com.tdd.chapter07.user.domain.User;
import com.tdd.chapter07.user.exception.DupIdException;
import com.tdd.chapter07.user.exception.WeakPasswordException;
import com.tdd.chapter07.user.repository.UserRepository;
import com.tdd.chapter07.user.validation.EmailNotifier;
import com.tdd.chapter07.user.validation.WeakPasswordChecker;

public class UserRegister {

    private WeakPasswordChecker passwordChecker;
    private UserRepository userRepository;
    private EmailNotifier emailNotifier;

    public UserRegister(WeakPasswordChecker passwordChecker, UserRepository userRepository, EmailNotifier emailNotifier) {
        this.passwordChecker = passwordChecker;
        this.userRepository = userRepository;
        this.emailNotifier = emailNotifier;
    }

    public void register(String id, String pw, String email) {
        //약한 암호일 경우 exception 발생
        if (passwordChecker.checkPasswordWeak(pw)) {
            throw new WeakPasswordException();
        }

        //이미 같은 ID가 존재할 경우 exception 발생
        User user = userRepository.findById(id);
        if (user != null) {
            throw new DupIdException();
        }
        //같은 ID가 없으면 회원 가입
        userRepository.save(new User(id, pw, email));

        //이메일 발송 기능 호출
        emailNotifier.sendRegisterEmail(email);
    }
}
