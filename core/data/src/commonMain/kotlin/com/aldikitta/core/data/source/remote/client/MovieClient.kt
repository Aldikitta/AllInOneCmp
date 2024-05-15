package com.aldikitta.core.data.source.remote.client

import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json

object MovieClient {
    @OptIn(ExperimentalSerializationApi::class)
    fun createHttpClient() : HttpClient {
        return HttpClient {
            defaultRequest {
                url("https://api.github.com/")
            }
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                    explicitNulls = false
                })
                engine {
                    // TODO: Specify time out
                }
            }
            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
//                        Napier.v(tag = "httpclient", message = message)
                    }
                }
                level = LogLevel.BODY
            }
            install(Auth) {
                bearer {
                    loadTokens {
                        BearerTokens(
                            "",
                            ""
                        )
                    }
                }
            }
            install(HttpTimeout) {
                connectTimeoutMillis = 30_000L
                requestTimeoutMillis = 30_000L
                socketTimeoutMillis = 30_000L
            }
        }
    }
}