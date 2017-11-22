package com.example.user013050.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

import static com.example.user013050.justjava.R.id.decrease_quantity_button;


/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static int quantity = 1;
    public static int whippedCreamPrice = 1;
    public static int chocolateToppingPrice = 2;
    public static int coffeeCupPrice = 5;
    public static boolean checked;
    public static boolean checked1;
    public static String name;

    /**
     * This method is called when quantity increment button is clicked.
     */
    public void increment(View view){
        Button decreaseButton = (Button)findViewById(R.id.decrease_quantity_button);
        Button increaseButton = (Button)findViewById(R.id.increase_quantity_button);
        if (quantity >= 1){
            decreaseButton.setEnabled(true);
        }
        if (quantity >=99){
            increaseButton.setEnabled(false);
        }
        display(quantity=quantity+1);
    }

    /**
     * This method is called when quantity decrement button is clicked
     */
    public void decrement(View view) {
        Button decreaseButton = (Button)findViewById(R.id.decrease_quantity_button);
        if (quantity <=2){
            decreaseButton.setEnabled(false);
        }
        display(quantity=quantity-1);
    }

    /**
     * This method is called when the order button is clicked, displays total order info
     */
    public void submitOrder(View view) {
            EditText sometext = (EditText) findViewById(R.id.add_name_text_input);
            name = sometext.getText().toString();
//        String priceMessage = "Name: " + name + "\nAdd whipped cream? " + checked + "\nAdd chocolate? " + checked1 + "\nQuantity: " + quantity + "\nTotal: " + "$" + quantity * coffeeCupPrice + "\nThank you!";
//        displayMessage(priceMessage);
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("*/*");
            intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java order to " + name);
            intent.putExtra(Intent.EXTRA_TEXT, "Name: " + name + "\nAdd whipped cream? " + checked + "\nAdd chocolate? " + checked1 + "\nQuantity: " + quantity + "\nTotal: " + "$" + quantity * coffeeCupPrice + "\nThank you!");
            if (intent.resolveActivity(getPackageManager()) != null){
                startActivity(intent);
            }
    }

    /**
     * This method saves state of whipped cream checkbox
     */
    public void onCheckboxClicked (View view){
            checked = ((CheckBox) view).isChecked();

            if (checked == true){
                coffeeCupPrice = coffeeCupPrice +whippedCreamPrice;
            }

    }

    /**
     * This method saves state of chocolate checkbox
     */
    public void hasChocolate (View view){
        checked1 = ((CheckBox) view).isChecked();
            if (checked1 == true){
                coffeeCupPrice = coffeeCupPrice +chocolateToppingPrice;
            }
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

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_count_text_view);
        priceTextView.setText(message);
    }

}
