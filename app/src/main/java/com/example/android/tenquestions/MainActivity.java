
package com.example.android.tenquestions;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String result_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the submit button is clicked.
     */
    public void submitAnswers(View view) {

        // Clear message
        result_message = "";

        int answers_correct = 0;
        int answers_incorrect = 0;

        // Question 1, Answer = Andorra
        RadioButton radioButtonView = (RadioButton) findViewById(R.id.radioButton_1_Andorra);
        boolean checked = radioButtonView.isChecked();

        if (checked) {
            answers_correct++;
            result_message += getString(R.string.answer_1_correct) + "\n";
        } else {
            answers_incorrect++;
            result_message += getString(R.string.answer_1_not_correct) + "\n";
        }

        // Question 2, Answer = Belgium
        radioButtonView = (RadioButton) findViewById(R.id.radioButton_2_Belgium);
        checked = radioButtonView.isChecked();

        if (checked) {
            answers_correct++;
            result_message += getString(R.string.answer_2_correct) + "\n";
        } else {
            answers_incorrect++;
            result_message += getString(R.string.answer_2_not_correct) + "\n";
        }

        // Question 3, Answer = Austria, Switzerland
        CheckBox checkBoxView = (CheckBox) findViewById(R.id.checkBox_3_Austria);
        checked = checkBoxView.isChecked();

        int correctly_checked = 0;
        if (checked) {
            correctly_checked++;
        }

        checkBoxView = (CheckBox) findViewById(R.id.checkBox_3_Switzerland);
        checked = checkBoxView.isChecked();

        if (checked) {
            correctly_checked++;
        }

        checkBoxView = (CheckBox) findViewById(R.id.checkBox_3_Germany);
        checked = checkBoxView.isChecked();

        if (!checked) {
            correctly_checked++;
        }

        checkBoxView = (CheckBox) findViewById(R.id.checkBox_3_Italy);
        checked = checkBoxView.isChecked();

        if (!checked) {
            correctly_checked++;
        }

        if (correctly_checked == 4) {
            answers_correct++;
            result_message += getString(R.string.answer_3_correct) + "\n";
        } else

        {
            answers_incorrect++;
            result_message += getString(R.string.answer_3_not_correct) + "\n";
        }

        // Question 4, Answer = Spain
        EditText editTextView = (EditText) findViewById(R.id.country_input);
        String countryName = editTextView.getText().toString();
        String lowercaseCountryName = countryName.toLowerCase();

        boolean countryCorrect = lowercaseCountryName.contentEquals(getString(R.string.spain).toLowerCase());

        if (countryCorrect) {
            answers_correct++;
            result_message += getString(R.string.answer_4_correct) + "\n";
        } else {
            answers_incorrect++;
            result_message += getString(R.string.answer_4_not_correct) + "\n";
        }

        if (answers_correct == 4) {
            result_message += "\n" + getString(R.string.answers_all_correct) + "\n";

            Toast.makeText(this, getString(R.string.answers_all_correct), Toast.LENGTH_SHORT).show();
        } else

        {
            result_message += "\n" + getString(R.string.answers_not_all_correct) + "\n";

            Toast.makeText(this, getString(R.string.answers_not_all_correct), Toast.LENGTH_SHORT).show();
        }

        TextView resultTextView = (TextView) findViewById(R.id.result_text);
        resultTextView.setText(result_message);


    }
}