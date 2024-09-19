package domain.model

data class Authorization(
    val accessToken: String?,
    val expiredAt: Long?,
) {
    val hasToken: Boolean
        get() = accessToken != null

    val isExpired: Boolean
        get() = expiredAt != null && expiredAt < System.currentTimeMillis()
}