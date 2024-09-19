package domain.component

import java.util.prefs.Preferences

fun getTokenFromPreferences(): String? =
    Preferences.userRoot().get(AUTH_TOKEN, null)

fun saveTokenToPreferences(
    token: String,
) =
    Preferences.userRoot().put(AUTH_TOKEN, token)

fun logout() =
    Preferences.userRoot().remove(AUTH_TOKEN)

private const val AUTH_TOKEN = "auth_token"