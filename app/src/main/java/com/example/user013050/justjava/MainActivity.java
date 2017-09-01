package com.example.user013050.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;


/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when quantity increment button is clicked.
     */
    public static int quantity = 0;

    public void increment(View view){
        display(quantity=quantity+1);
    }

    /**
     * This method is called when quantity decrement button is clicked
     */
    public void decrement(View view){
        display(quantity=quantity-1);
    }

    /**
     * This method is called when the order button is clicked.
     */

    public void submitOrder(View view) {


        displayPrice(quantity*5);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityCountTextView = (TextView) findViewById(R.id.quantity_count_text_view);
        quantityCountTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_count_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
}
