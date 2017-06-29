package freya.moneytextwatcher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Displays one EditText, displaying text of the format "x.xx"=
 */

public class MainActivity extends AppCompatActivity {

    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (EditText) findViewById(R.id.valueInput);

        // Disable and lock EditText selection so input is always added from the right
        input.setCursorVisible(false);
        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setSelection(input.getText().length());
            }
        });

        input.setSelection(input.length());

        // Set TextWatcher
        input.addTextChangedListener(new MoneyTextWatcher(input));
    }
}
