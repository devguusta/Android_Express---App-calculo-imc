package com.example.fitnnes;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.fitnnes.validators.ValidatorsInputs;

public class ImcActivity extends AppCompatActivity {

    private EditText editHeight;
    private EditText editWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);
        editHeight = findViewById(R.id.edit_imc_height);
        editWeight = findViewById(R.id.edit_imc_weight);

        Button btnSend = findViewById(R.id.btn_imc_send);

        btnSend.setOnClickListener(view -> {
            if (!validate()) {
                Toast.makeText(ImcActivity.this, R.string.fields_message, Toast.LENGTH_LONG).show();
                return;
            }

            String sHeight = editHeight.getText().toString();
            String sWeight = editWeight.getText().toString();

            int height = Integer.parseInt(sHeight);
            int weight = Integer.parseInt(sWeight);
            double result = calculeImc(height, weight);
            Log.d("TESTE", "resultado" + result);
            int imcResponseId = new ValidatorsInputs().imcResponse(result);

            AlertDialog dialog = new AlertDialog.Builder(ImcActivity.this).
                    setTitle(getString(R.string.imc_response, result))
                    .setMessage(imcResponseId)
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                    .create();

            dialog.show();

       InputMethodManager imputMethodManager;
            imputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imputMethodManager.hideSoftInputFromWindow(editWeight.getWindowToken(), 0);
            imputMethodManager.hideSoftInputFromWindow(editHeight.getWindowToken(), 0);

        });
    }


    private double calculeImc(int height, int weight) {
        return weight / (((double) height / 100) * ((double) height / 100));

    }


    private boolean validate() {
        String height = editHeight.getText().toString();
        String weight = editWeight.getText().toString();

        return (!height.startsWith("0")
                && !weight
                .startsWith("0") && !weight.isEmpty() && !height.isEmpty());


    }

}