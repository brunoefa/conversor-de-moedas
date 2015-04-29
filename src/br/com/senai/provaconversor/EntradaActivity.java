package br.com.senai.provaconversor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EntradaActivity extends Activity {

	private String valor;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_entrada);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.entrada, menu);
		return true;
	}
	
	public void capturarClique(View view) {
		mostrarCotacao();
	}
	
	private void mostrarCotacao() {
		if (capturarValor()) { 
			Intent i = new Intent(this, ResultadoActivity.class);
			i.putExtra("valor", valor);
			startActivity(i);
		}
	}
	
	private boolean capturarValor() {
		EditText etValor = (EditText)findViewById(R.id.et_valor);
		valor = etValor.getText().toString();
		return validarEntrada(valor);
	}
	
	private boolean validarEntrada(String valor) {
		if ("".equals(valor.trim())) {
			Toast.makeText(this, "Por favor, informe um valor.", Toast.LENGTH_LONG).show();
			return false;
		}
		Double real = Double.parseDouble(valor);
		if (real <= 0) {
			Toast.makeText(this, "Você deve digitar um valor maior que zero.", Toast.LENGTH_LONG).show();
			return false;
		}
		return true;
	}
	

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_efetuar_cotacao) {
			mostrarCotacao();
		}
		return super.onOptionsItemSelected(item);
	}
}
