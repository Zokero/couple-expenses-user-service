package com.kukit.platform.registration.domain.assemblers.user;

import com.kukit.platform.registration.domain.user.User;

public interface UserEmailAssembler {

    User withEmail(String email);
}
