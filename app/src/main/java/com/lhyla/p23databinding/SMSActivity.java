package com.lhyla.p23databinding;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SMSActivity extends AppCompatActivity {


    EditText numerTelefonu;
    EditText tekstWiadomosci;
    Button btnSMS;
    Button btnObliczeniowy;

    // stala dzieki ktorej po odpowiedzi od aplikacji o statusie przyznania dostepu bedziemy
    // wiedziec ze jest to odpowiedz na dane nasze wywolanei
    final int MY_PERMISSIONS_REQUEST_WRITE_SMS = 1;

    // nasz TAG za pomoca ktorego bedziemy mogli filtrowac wiadomosci w Android Monitor
    public static final String TAG = "DarekApp";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        ButterKnife.bind(this);

        numerTelefonu = (EditText) findViewById(R.id.numerTelefonu);
        tekstWiadomosci = (EditText) findViewById(R.id.textWiadomosci);

        btnSMS = (Button) findViewById(R.id.btnSMS);
        Button btnDostep = (Button) findViewById(R.id.btnDostep);
        btnDostep.setOnClickListener(onDostepClick);

        btnObliczeniowy = (Button) findViewById(R.id.btnOblicz);
        btnObliczeniowy.setOnClickListener(onObliczClick);


    }

    public View.OnClickListener onObliczClick = new View.OnClickListener() {
        public void onClick(View v) {

            String numerPobrany = numerTelefonu.getText().toString();
            int numerDoDzialan = Integer.valueOf(numerPobrany);
            int wynik_1 = numerDoDzialan / 8;
            String wycieteLiczby = numerPobrany.substring(0, 3);
            int wynik_2 = wynik_1 + Integer.valueOf(wycieteLiczby);
            String wycieteLiczby_2 = numerPobrany.substring(3, 5);
            int wynik_3 = wynik_2 - Integer.valueOf(wycieteLiczby_2);
            btnObliczeniowy.setText(String.valueOf(wynik_3));

        }
    };

    @OnClick(R.id.sms_act_send_sms_fab_btn)
    public void onSendSmsFabBtnClick(){
        sendSms(numerTelefonu.getText().toString(), tekstWiadomosci.getText().toString());

    }

    // wlasna funkcja ktora przyjmuje numer telefonu i tresc wiadomosci
    private void sendSms(String phoneNo, String msg) {
        try {
            //wykorzystujemy smsmanager czyli wbudowane api do zarzadzania smsami
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, msg, null, null);

            // za pomoca Log mozemy zrobic log momencie wyslania SMS . Ten log jest widoczny w ANdroid Monitorze.
            Log.d(TAG, "SMS Wysłany");


            Snackbar.make
                    (getCurrentFocus(), "SMS Successfully sent", Snackbar.LENGTH_LONG)
                    .show();

            // ponizej na dwa sposoby czyscimy wpisane kontrolki
            numerTelefonu.setText("");
            tekstWiadomosci.getText().clear();
        } catch (Exception ex) {
            Log.d(TAG, "SMS Nie wysłany");
            ex.printStackTrace();
        }
    }

    public View.OnClickListener onDostepClick = new View.OnClickListener() {
        public void onClick(View v) {

            // sprawdzamy czy jest przyznay dostep
            if (android.support.v4.app.ActivityCompat.checkSelfPermission(SMSActivity.this, Manifest.permission.SEND_SMS)
                    != PackageManager.PERMISSION_GRANTED) {

                // za pomoca tej funkcji sprawdzamy czy uzytkownik po raz pierwszy juz blokowal dostep do sms
                if (ActivityCompat.shouldShowRequestPermissionRationale(SMSActivity.this,
                        Manifest.permission.SEND_SMS)) {
                    // jesli dostep blokowal pokazujemy po co nam to potrzebne
                    showExplanation("Potrzebujemy pozwolenia", "Chcemy wysłać SMS który napisałeś, więc potrzebujemy pozwolenia",
                            Manifest.permission.SEND_SMS, MY_PERMISSIONS_REQUEST_WRITE_SMS);
                } else {
                    // pokazujemy okienko z prosba za pierwszym razem odrazu systemowe
                    requestPermissions(Manifest.permission.SEND_SMS, MY_PERMISSIONS_REQUEST_WRITE_SMS);
                }
            } else {
                // wlaczamy przycisk sms jesli dostep przyznay ( mozna to sprawdzac z automatu w oncreate aby za kazdym razem nie sprawdzac tutaj)
                btnSMS.setEnabled(true);
            }
        }
    };

    // funkcja ktora pokazuje okienko systemowe z prosba o dany kod
    private void requestPermissions(String permissionName, int permissionRequestCode) {
        ActivityCompat.requestPermissions(this, new String[]{permissionName}, permissionRequestCode);
    }

    // wlasna funkcja ktora pokazuje okienko z wyjasnieniem prosby o dostep
    private void showExplanation(String title, String message, final String permission, final int permissionRequestCode) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                requestPermissions(permission, permissionRequestCode);
            }
        });
        builder.show();
    }


    // metoda wywolywana za kazdym razem gdy uzytkownik podejmie decyzje o dostepie
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_WRITE_SMS: {
                // jesli uzytkownik dal anuluj to dlugosc listy bedzie pusta
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    btnSMS.setEnabled(true);
                    // dostep przyznany - mozemy zrobic co chcemy
                    Log.d(TAG, "Dostęp przyznany");
                } else {
                    Log.d(TAG, "Dostęp nie przyznany");
                    //  dostep nie przyznany ! musimy obsluzyc ten problem w aplikacji
                    // ponizej dodatkowo sprawdzamy czy zaznaczyl never ask again
                    if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
                        // user rejected the permission
                        boolean showRationale = ActivityCompat.shouldShowRequestPermissionRationale(SMSActivity.this,
                                Manifest.permission.SEND_SMS);
                        if (!showRationale) {
                            Log.d(TAG, "Uzytkownik zaznaczyl never ask again");
                        }
                    }
                }
                return;
            }

            // za pomoca swticha mozna przejrzec czasmi wiele prosb
        }

    }
}

