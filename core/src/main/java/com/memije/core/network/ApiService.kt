package com.memije.core.network

import com.memije.core.response.PokemonListResponse
import com.memije.core.response.PokemonDetailResponse
import com.memije.core.response.PokemonAbilityResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("pokemon")
    suspend fun getPokemonList(@Query("limit") limit: Int = 20, @Query("offset") offset: Int = 0): PokemonListResponse

    @GET("pokemon/{name}")
    suspend fun getPokemonDetail(@Path("name") name: String): PokemonDetailResponse

    @GET("ability/{name}")
    suspend fun getPokemonAbility(@Path("name") name: String): PokemonAbilityResponse
}
