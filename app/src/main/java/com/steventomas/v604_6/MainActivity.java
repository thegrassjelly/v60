package com.steventomas.v604_6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void Brew(View view) {
        EditText grounds = findViewById(R.id.txtGrounds);
        EditText water = findViewById(R.id.txtWater);
        EditText ratio = findViewById(R.id.txtRatio);

        double groundsAmnt = 0;
        double waterAmnt = 0;
        double brewRatio = 0;

        if (grounds.getText().toString() != null) {
            groundsAmnt = Double.parseDouble(grounds.getText().toString());
        }
        else {
            ToastValidator("grounds amount");
        }

        if (water.getText().toString().length() > 1) {
            waterAmnt = Double.parseDouble(water.getText().toString());
        }
        else {
            ToastValidator("water amount");
        }

        if (ratio.getText().toString().length() > 1) {
            brewRatio = Double.parseDouble(ratio.getText().toString());
        }
        else {
            ToastValidator("brew ratio");
        }

        ShowResult(groundsAmnt, waterAmnt, brewRatio);
    }

    private void ShowResult(double groundsAmnt, double waterAmnt, double brewRatio) {
        Toast showInput = null;
        if (showInput != null) {
            showInput.cancel();
        } else {
            showInput = Toast.makeText(this, groundsAmnt + " " + waterAmnt + " " + brewRatio, Toast.LENGTH_LONG);
            showInput.setGravity(Gravity.TOP|Gravity.LEFT,30,190);
            showInput.show();
        }
    }

    private void ToastValidator(String inputField) {
        Toast validatorToast = null;

        if (validatorToast != null) {
            validatorToast.cancel();
        } else {
            validatorToast = Toast.makeText(this, "The " + inputField + " field is empty", Toast.LENGTH_SHORT);
            validatorToast.setGravity(Gravity.TOP|Gravity.RIGHT,30,190);
            validatorToast.show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }
}
