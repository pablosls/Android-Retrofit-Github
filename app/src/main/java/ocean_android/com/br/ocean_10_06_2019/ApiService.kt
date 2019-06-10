package ocean_android.com.br.ocean_10_06_2019

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    /*
     Apena defini que ira existir o metodo
    */
    @GET("search/repositories")
    fun buscarRepositorios(@Query("q") query: String): Call<GitHubResult> /* Ira retornar um GitHub result*/

}