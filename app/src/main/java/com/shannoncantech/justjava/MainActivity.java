package com.shannoncantech.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

/*    public int finalNumberOfCoffee;
    public int numOfCoffee = finalNumberOfCoffee;
    public int priceOfCoffee = 5;*/

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increment(View view) {
/*        finalNumberOfCoffee = numOfCoffee + 1;
        display(finalNumberOfCoffee);*/
        quantity = quantity + 1;
        display(quantity);
        displayPrice(quantity * 5);
    }

    public void decrement(View view) {
        if (quantity > 1) {
            quantity = quantity - 1;
        } else {
            quantity = 0;
        }
        /*quantity = quantity - 1;*/
        display(quantity);
        displayPrice(quantity * 5);

    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
//        displayPrice(quantity * 5);
        String priceMessage = "Today's Total: $";
        int price = quantity * 5;
        if (quantity == 0){
            displayPrice(price);
        } else {
            displayMessage(priceMessage + price + '\n' + "Thank You!");
        }
        displayNotes();
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);

    }

    private void displayNotes(){
        EditText notesEditText = (EditText) findViewById(R.id.notes_edit_text);
        TextView notesTextView = (TextView) findViewById(R.id.notes_text_view);
        TextView otherNotesTextView = (TextView) findViewById(R.id.othernotes_text_view);
        notesTextView.setText(notesEditText.getText().toString());
        notesTextView.setVisibility(View.VISIBLE);
        otherNotesTextView.setVisibility(View.VISIBLE);
    }
}
