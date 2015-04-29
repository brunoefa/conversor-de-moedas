package br.com.senai.provaconversor;

import java.text.DecimalFormat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class ResultadoActivity extends Activity {

	private Double blr;
	private Double usd;
	private Double eur;
	private Double yen;
	private Double gbp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_resultado);
		capturarValor();
		efetuaCotacao();
		mostraCotacao();
	}
	
	private void capturarValor() {
		Intent intent = getIntent();
		String valor = intent.getStringExtra("valor");
		blr = Double.parseDouble(valor);
	}
	
	private void mostraCotacao() {
		DecimalFormat df = new DecimalFormat("###,###,##0.00");
				
		TextView tvReal = (TextView)findViewById(R.id.tv_real);
		tvReal.setText("BLR " + df.format(blr));
		TextView tvDolar = (TextView)findViewById(R.id.tv_dolar);
		tvDolar.setText("USD " + df.format(usd));
		TextView tvEuro = (TextView)findViewById(R.id.tv_euro);
		tvEuro.setText("EUR " + df.format(eur));
		TextView tvYen = (TextView)findViewById(R.id.tv_yen);
		tvYen.setText("YEN " + df.format(yen));
	}
	
	private void efetuaCotacao() {
		usd = getUsd(blr);
		eur = getEur(blr);
		yen = getYen(blr);
		gbp = getGbp(blr);
	}
	
	private Double getUsd(Double blr2) {
		return blr * 0.34;
	}
	
	private Double getEur(Double blr2) {
		return blr * 0.31;
	}
	
	private Double getYen(Double blr2) {
		return blr * 40.44;
	}
	
	private Double getGbp(Double blr2) {
		return blr * 0.22;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.resultado, menu);
		return true;
	}

	public void novaCotacao(View view) {

	}
	
	private void efetuarNovaCotacao() {
		Intent i = new Intent(this, EntradaActivity.class);
		startActivity(i);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_novacotacao) {
			efetuarNovaCotacao();
		}
		return super.onOptionsItemSelected(item);
	}
}
