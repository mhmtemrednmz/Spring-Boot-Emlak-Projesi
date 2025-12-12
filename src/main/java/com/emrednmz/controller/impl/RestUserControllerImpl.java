package com.emrednmz.controller.impl;

import com.emrednmz.controller.RestBaseController;
import com.emrednmz.controller.RestUserController;
import com.emrednmz.controller.RootEntity;
import com.emrednmz.dto.response.UserResponse;
import com.emrednmz.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest/api/user")
public class RestUserControllerImpl extends RestBaseController implements RestUserController {
    @Autowired
    private IUserService userService;

    @GetMapping("{id}")
    @Override
    public RootEntity<UserResponse> getUserById(@PathVariable Long id) {
        return ok(userService.getUserById(id));
    }
}
