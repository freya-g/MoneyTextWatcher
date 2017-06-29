package freya.moneytextwatcher;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * Class used to modify input field of money values so user is "inserting" into the "0.00" format.
 * Fore example, if user enters 0, 1, 2 in order to "0.00", it will become:
 * "0.01"
 * "0.12"
 * "1.23"
 */

public class MoneyTextWatcher implements TextWatcher {

    private final EditText input;
    private String text;

    public MoneyTextWatcher(EditText input) {
        this.input = input;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        text = s.toString();
        int decimalPos = text.indexOf(".");

        if (decimalPos == -1) {
            // If there's no decimal (has been deleted)
            if (text.length() < 3) {
                // Keep pattern of x.xx
                String template = "0.00";
                text = template.substring(0, template.length() - text.length()) + text;
            } else {
                // String length > 2, add decimal
                text = text.substring(0, text.length()-2) + "." + text.substring(text.length()-2);
            }


        } else if (decimalPos != (text.length() - 3)) {
            // If decimal is not positioned at the correct position: remove and fix
            text = text.replace(".", "");
            while (text.length() < 3) {
                // Add paddings to left
                text = "0" + text;
            }
            String s1 = text.substring(0, text.length()-2);
            String s2 = text.substring(text.length()-2);
            text = s1 + "." + s2;
        }

        // Get rid of extra 0s on the left
        while (text.charAt(0) == '0' & text.length() > 4) {
            text = text.substring(1, text.length());
        }


    }

    @Override
    public void afterTextChanged(Editable editable) {

        input.removeTextChangedListener(this);
        input.setText(text);
        input.addTextChangedListener(this);
        input.setSelection(input.length()); // Move cursor to end of input
    }
}
