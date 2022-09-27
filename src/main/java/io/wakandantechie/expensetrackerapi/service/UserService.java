package io.wakandantechie.expensetrackerapi.service;

import io.wakandantechie.expensetrackerapi.model.User;
import io.wakandantechie.expensetrackerapi.model.UserModel;

public interface UserService {

    User createUser(UserModel user);

    User read(Long id);

    User update(User user, Long id);
}
