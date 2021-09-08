package org.ada.school.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Constants {

	public static final String CLAIMS_ROLES_KEY = "ada_roles";

	public static final int TOKEN_DURATION_MINUTES = 240;

	public static final int ADMIN_TOKEN_DURATION_MINUTES = 10;

	public static final String COOKIE_NAME = "ada-JWT";

	public static final String ADMIN_ROLE = "ADMIN";

	public static final String USER_ROLE = "USER";
}
