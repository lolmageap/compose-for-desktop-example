package domain.component

import java.util.prefs.Preferences

fun getTokenFromPreferences(): String? =
    Preferences.userRoot().get("auth_token", null)

fun saveTokenToPreferences(
    token: String,
) =
    Preferences.userRoot().put("auth_token", token)
