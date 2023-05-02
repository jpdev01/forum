package br.com.jpdev.forum.config

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.*

@Component
class JwtUtil {

    private val expirationInMillis: Long = 60000 // 1 min

    @Value("\${jwt.secret}")
    private lateinit var secret: String // só vai inicializar quando chamar a primeira vez

    fun generateToken(username: String): String? {
        return Jwts.builder()
                .setSubject(username) // identificar o cliente
                .setExpiration(Date(System.currentTimeMillis() + expirationInMillis))
                .signWith(SignatureAlgorithm.HS512, secret.toByteArray()) // o que vai devolver pro cliente quando decodificar
                .compact()
    }
}