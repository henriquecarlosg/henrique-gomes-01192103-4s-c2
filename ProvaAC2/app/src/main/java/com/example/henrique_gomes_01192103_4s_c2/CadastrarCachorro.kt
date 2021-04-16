package com.example.henrique_gomes_01192103_4s_c2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.ThreadLocalRandom

class CadastrarCachorro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrar_cachorro)

    }

    fun criarCachorro(view: View) {
        val apiCachorros = ConexaoApiCachorros.criar()
        val id:Int = 0
        val raca:EditText = findViewById(R.id.et_raca)
        val preco:EditText = findViewById(R.id.et_precoMedio)
        val precoMedio = preco.toString().toDouble()
        val indicado:EditText = findViewById(R.id.et_indicado)
        val criancaIndicado = indicado.toString().toBoolean()
        val res:TextView = findViewById(R.id.tv_res)
        val novoCachorro = Cachorro(0, raca.toString(), precoMedio, criancaIndicado)


        apiCachorros.post(novoCachorro).enqueue(object : Callback<Cachorro>{
            override fun onResponse(call: Call<Cachorro>, response: Response<Cachorro>) {
                if(response.code() == 404){
                    res.text = "Não foi possível cadastrar um cachorro"
                }else{
                    val cachorro = response.body()
                    
                }
            }

            override fun onFailure(call: Call<Cachorro>, t: Throwable) {
                Toast.makeText(baseContext, "Não foi possível", Toast.LENGTH_SHORT).show()
            }
        })

    }
}