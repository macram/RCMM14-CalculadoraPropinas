package es.macram.estadosmartphone;

import android.support.v7.app.ActionBarActivity;
import android.telephony.TelephonyManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	TelephonyManager tm;
	
	TextView textViewidDispositivo;
	TextView textViewnumeroTelefono;
	TextView textViewversionSoftware;
	TextView textViewNombreOperador;
	TextView textViewCodigoPaisSim;
	TextView textViewOperadorSim;
	TextView textViewNumeroSerieSim;
	TextView textViewSuscriptorId;
	TextView textViewTipoRedMovil;
	TextView textViewTipoRadioVoz;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		inicializarComponentes();
	}
	
	private void inicializarComponentes() {
		textViewidDispositivo = (TextView)findViewById(R.id.textViewIdDispositivo);
		textViewnumeroTelefono = (TextView)findViewById(R.id.textViewNumerotelefono);
		textViewversionSoftware = (TextView)findViewById(R.id.textViewVersionSoftware);
		textViewNombreOperador = (TextView)findViewById(R.id.textViewNombreOperador);
		textViewCodigoPaisSim = (TextView)findViewById(R.id.textViewCodigoPaisSim);
		textViewOperadorSim = (TextView)findViewById(R.id.textViewOperadorSim);
		textViewNumeroSerieSim = (TextView)findViewById(R.id.textViewNumeroSerieSim);
		textViewSuscriptorId = (TextView)findViewById(R.id.textViewSuscriptorID);
		textViewTipoRedMovil = (TextView)findViewById(R.id.textViewTipoRedMovil);
		textViewTipoRadioVoz = (TextView)findViewById(R.id.textViewTipoRadioVoz);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	private String getNetworkType(int i) {
		String tipoRedMovil = "";
		switch (i) {
		case 7: tipoRedMovil="1xRTT"; break;
		case 4: tipoRedMovil="CDMA"; break;
		case 2: tipoRedMovil="EDGE"; break;
		case 14: tipoRedMovil="EHRPD"; break;
		case 5: tipoRedMovil="EVDO 0"; break;
		case 6: tipoRedMovil="EVDO A"; break;
		case 8: tipoRedMovil="HSDPA"; break;
		case 10: tipoRedMovil="HSPA"; break;
		case 15: tipoRedMovil="HSPAP"; break;
		case 9: tipoRedMovil="HSUPA"; break;
		case 11: tipoRedMovil="IDEN"; break;
		case 13: tipoRedMovil="LTE"; break;
		case 3: tipoRedMovil="UMTS"; break;
		case 1: tipoRedMovil="GPRS"; break;
		case 12: tipoRedMovil="EVDO B"; break;
		default: tipoRedMovil="Eing?"; break;
		}
		return tipoRedMovil;
	}
	
	private String getPhoneType(int i) {
		String tipoRadioVoz="";
		switch (i) {
		case 0: tipoRadioVoz="Ninguno"; break;
		case 1: tipoRadioVoz="GSM"; break;
		case 2: tipoRadioVoz="CDMA"; break;
		case 3: tipoRadioVoz="SIP"; break;
		default: tipoRadioVoz="Eing?"; break;
		}
		return tipoRadioVoz;
	}
	
	public void obtenerDatos(View v) {
		tm = (TelephonyManager)getSystemService(TELEPHONY_SERVICE); 
	
		textViewidDispositivo.setText(tm.getDeviceId());
		textViewnumeroTelefono.setText(tm.getLine1Number());
		textViewversionSoftware.setText(tm.getDeviceSoftwareVersion());
		textViewNombreOperador.setText(tm.getSimOperatorName());
		textViewCodigoPaisSim.setText(tm.getNetworkCountryIso());
		textViewOperadorSim.setText(tm.getSimOperator());
		textViewNumeroSerieSim.setText(tm.getSimSerialNumber());
		textViewSuscriptorId.setText(tm.getSubscriberId());
		textViewTipoRedMovil.setText(this.getNetworkType(tm.getNetworkType()));
		textViewTipoRadioVoz.setText(this.getPhoneType(tm.getPhoneType()));
	}
}
