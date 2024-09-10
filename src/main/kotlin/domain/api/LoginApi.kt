package domain.api

import domain.model.LoginResponse
import domain.model.User
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*

suspend fun requestToLogin(
    client: HttpClient,
    email: String,
    password: String,
) =
    try {
        val response = client.post("https://example.com/api/login") {
            contentType(ContentType.Application.Json)
            setBody(mapOf("email" to email, "password" to password))
        }

        if (response.status == HttpStatusCode.OK) {
            val token = response.headers["Authorization"]
                ?: throw IllegalHeaderValueException("Authorization header not found", 0)

            val body: User = response.body()
            LoginResponse.success(token, body)
        } else {
            LoginResponse.failure("Login failed")
        }
    } catch (e: Exception) {
        LoginResponse.failure(e.message!!)
    }