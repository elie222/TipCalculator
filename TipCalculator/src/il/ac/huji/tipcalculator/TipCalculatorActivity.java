package il.ac.huji.tipcalculator;

import java.text.DecimalFormat;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalculatorActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
        
        final Button button = (Button) findViewById(R.id.btnCalculate);
        button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				final CheckBox chkRound = (CheckBox) findViewById(R.id.chkRound);
				final EditText editBillAmount = (EditText) findViewById(R.id.edtBillAmount);
				final TextView txtTipResult = (TextView) findViewById(R.id.txtTipResult);

				double tipResult = Double.parseDouble(editBillAmount.getText().toString()) * 0.12;
				
				if (chkRound.isChecked()) {
					txtTipResult.setText("Tip: $" + Integer.toString((int) Math.round(tipResult)));
				} else {
					DecimalFormat df = new DecimalFormat("#.##");
					txtTipResult.setText("Tip: $" + df.format(tipResult));
				}
			}
        });
    }
    
}
