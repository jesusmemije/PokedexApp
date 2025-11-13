package com.memije.pdxcore.network

import com.memije.pdxcore.network.response.PDXPokemonListResponse
import com.memije.pdxcore.network.response.PDXDetailResponse
import com.memije.pdxcore.network.response.PDXAbilitiesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PDXApiService {
    @GET("pokemon")
    suspend fun getPokemonList(@Query("limit") limit: Int = 20, @Query("offset") offset: Int = 0): PDXPokemonListResponse

    @GET("pokemon/{name}")
    suspend fun getPokemonDetail(@Path("name") name: String): PDXDetailResponse

    @GET("ability/{name}")
    suspend fun getPokemonAbility(@Path("name") name: String): PDXAbilitiesResponse
}
