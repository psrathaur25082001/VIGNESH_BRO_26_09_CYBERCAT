package com.cybercat.user.entity;

import lombok.Data;

@Data
public class UserRoleEntity {

	private boolean client;
    private boolean insurer;
    private boolean underwriter;
    private boolean intermediary;
    private boolean superadmin;
}
