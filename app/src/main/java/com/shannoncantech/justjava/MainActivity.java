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

    /*
    * This adds 1 to the quantity
    * */
    public void increment(View view) {
/*        finalNumberOfCoffee = numOfCoffee + 1;
        display(finalNumberOfCoffee);*/
        quantity = quantity + 1;
        display(quantity);
        displayPrice(quantity * 5);
    }

    /*
    * Subtract 1 from the quantity but never lets the quantity be less than 0.
    * */
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

    /*
    * Value for the "Add Notes" onClick feature
    * */
    public void showEditText(View view){
        displayEditText();
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

    /*
    * Displays the notes the user enters underneath the "Price" segment
    * */
    private void displayNotes(){
        EditText notesEditText = (EditText) findViewById(R.id.notes_edit_text);
        String ed_text = notesEditText.getText().toString().trim();
        TextView notesTextView = (TextView) findViewById(R.id.notes_text_view);
        TextView otherNotesTextView = (TextView) findViewById(R.id.othernotes_text_view);
        notesTextView.setText(notesEditText.getText().toString());
        notesTextView.setVisibility(View.VISIBLE);
        otherNotesTextView.setVisibility(View.VISIBLE);
        if(ed_text.isEmpty()){
            notesTextView.setVisibility(View.GONE);
            otherNotesTextView.setVisibility(View.GONE);
        }
    }

    /*
    * Displayed the EditText field onClick of "Add Note" button
    * */
    private void displayEditText(){
        EditText notesEditText = (EditText) findViewById(R.id.notes_edit_text);
        notesEditText.setVisibility(notesEditText.getVisibility() == View.GONE ? View.VISIBLE
                : View.GONE);

//        The commented code below made the EditText view visible when the "Add Note" button was clicked, then gone when the button was clicked again but this was only executed once. The code above is a shorter and more complete version.
/*        notesEditText.setVisibility(View.VISIBLE);
        Button thisButton = (Button) findViewById(R.id.add_notes_button);
        thisButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText notesEditText = (EditText) findViewById(R.id.notes_edit_text);
                notesEditText.setVisibility(View.GONE);
            }
        });*/
    }
}
