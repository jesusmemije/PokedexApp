package com.memije.pdxcore.network

import com.memije.pdxcore.network.response.PDXPokemonListResponse
import com.memije.pdxcore.network.response.PDXSpeciesResponse
import com.memije.pdxcore.network.response.PDXAbilitiesResponse
import com.memije.pdxcore.network.response.PDXDetailResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PDXApiService {
    @GET("pokemon")
    suspend fun getPokemonList(@Query("limit") limit: Int = 20, @Query("offset") offset: Int = 0): PDXPokemonListResponse

    @GET("pokemon/{name}")
    suspend fun getPokemonDetail(@Path("name") name: String): PDXDetailResponse

    @GET("pokemon-species/{name}")
    suspend fun getPokemonSpecies(@Path("name") name: String): PDXSpeciesResponse

    @GET("ability/{name}")
    suspend fun getPokemonAbility(@Path("name") name: String): PDXAbilitiesResponse
}
