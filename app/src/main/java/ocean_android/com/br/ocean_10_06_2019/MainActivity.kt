package ocean_android.com.br.ocean_10_06_2019

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnBuscar.setOnClickListener {
            val language = editBusca.text.toString()
            efetuarBuscar(language)
        }

    }

    fun efetuarBuscar(language:String){

        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create()) // Informo como sera convertida o retorno
                .build()

        val service = retrofit.create(ApiService::class.java)

        //val call = service.buscarRepositorios("language:kotlin")
        val call = service.buscarRepositorios("language=${language}")

        call.enqueue(object: Callback<GitHubResult>{
            override fun onFailure(call: Call<GitHubResult>, t: Throwable) {

            }

            override fun onResponse(call: Call<GitHubResult>, response: Response<GitHubResult>) {
                var result = response.body()

                if(result != null){
                    var nomes = ""
                    result.items.forEach {
                        nomes += "Nome: ${it.name} Login: ${it.owner.login}\n"
                    }
                    tvRepositorios.text = nomes;
                }
            }

        })

    }
}
