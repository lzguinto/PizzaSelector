package commrhardman23.httpsgithub.pizzaselector;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;

public class PizzaPreferences extends AppCompatActivity {

    private CheckBox[] toppings;
    private RadioButton rdobtnIndividual;
    private RadioButton rdobtnSmall;
    private RadioButton rdobtnMedium;
    private RadioButton rdobtnLarge;
    private RadioButton rdobtnExtraLarge;
    private RadioButton rdobtnThin;
    private RadioButton rdobtnThick;
    private RadioButton rdobtnCheeseFilled;
    private CheckBox chkboxGarlic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_preferences);

        toppings = new CheckBox[]{
                (CheckBox)findViewById(R.id.chkboxPepperoni),
                (CheckBox)findViewById(R.id.chkboxHam),
                (CheckBox)findViewById(R.id.chkboxBacon),
                (CheckBox)findViewById(R.id.chkboxSausage),
                (CheckBox)findViewById(R.id.chkboxMushrooms),
                (CheckBox)findViewById(R.id.chkboxGreenPeppers),
                (CheckBox)findViewById(R.id.chkboxOnions),
                (CheckBox)findViewById(R.id.chkboxOlives),
                (CheckBox)findViewById(R.id.chkboxTomatoes),
                (CheckBox)findViewById(R.id.chkboxExtraCheese)
        };

        rdobtnIndividual = (RadioButton)findViewById(R.id.rdobtnIndividual);
        rdobtnSmall = (RadioButton)findViewById(R.id.rdobtnSmall);
        rdobtnMedium = (RadioButton)findViewById(R.id.rdobtnMedium);
        rdobtnLarge = (RadioButton)findViewById(R.id.rdobtnLarge);
        rdobtnExtraLarge = (RadioButton)findViewById(R.id.rdobtnExtraLarge);
        rdobtnThin = (RadioButton)findViewById(R.id.rdobtnThin);
        rdobtnThick = (RadioButton)findViewById(R.id.rdobtnThick);
        rdobtnCheeseFilled = (RadioButton)findViewById(R.id.rdobtnCheeseFilled);
        chkboxGarlic = (CheckBox)findViewById(R.id.chkboxGarlic);
    }

    /**
     * calculateCost will loop through the topping array, check size of the pizza, and check the
     * crust options for the pizza so that the CostCalculator activity can give a full description
     * of costs.
     * @param vw is the button associated with the calculateCost method
     */
    public void calculateCost(View vw) {

        Intent calculatePizzaCost = new Intent(this, CostCalculator.class);
        boolean[] hasToppings = new boolean[toppings.length];
        String pizzaSize;
        String crustType;
        String garlic;

        //insert your code here
        for (int i = 0; i < toppings.length; i++) {
            if (toppings[i].isChecked()) {
                hasToppings[i] = true;
            } else {
                hasToppings[i] = false;
            }
        }

        if (rdobtnIndividual.isChecked()) {
            pizzaSize = "Individual";
        } else if (rdobtnSmall.isChecked()) {
            pizzaSize = "Small";
        } else if (rdobtnMedium.isChecked()) {
            pizzaSize = "Medium";
        } else if (rdobtnLarge.isChecked()) {
            pizzaSize = "Large";
        } else if (rdobtnExtraLarge.isChecked()) {
            pizzaSize = "Extra Large";
        } else
            pizzaSize = "No size has been selected.";

        if (rdobtnThin.isChecked()) {
            crustType = "Thin";
        } else if (rdobtnThick.isChecked()) {
            crustType = "Thick";
        } else if (rdobtnCheeseFilled.isChecked()) {
            crustType = "Cheese Filled";
        } else {
            crustType = "No crust type selected.";
        }

        if (chkboxGarlic.isChecked()) {
            garlic = "Garlic";
        } else {
            garlic = "No garlic";
        }

        calculatePizzaCost.putExtra("TOPPINGS_BOOLEANS", hasToppings);
        calculatePizzaCost.putExtra("SIZE_SELECTION", pizzaSize);
        calculatePizzaCost.putExtra("CRUST_SELECTION", crustType);
        calculatePizzaCost.putExtra("HAS_GARLIC_CRUST", garlic);
        startActivityForResult(calculatePizzaCost, 0);

        }

    /**
     * onActivityResult is the code that is run upon completion of the Intent linked to this
     * activity. The code below deselects all checkboxes and radio buttons for another selection
     * @param requestCode is the number linking the original activity and the intent created
     * @param resultCode is the number that represents whether the operation was successful
     *                   or unsuccessful
     * @param data is the intent used to return back to the original activity
     */
    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        for(int i = 0; i < toppings.length; i++){
            toppings[i].setChecked(false);
        }
        rdobtnIndividual.setChecked(false);
        rdobtnSmall.setChecked(false);
        rdobtnMedium.setChecked(false);
        rdobtnLarge.setChecked(false);
        rdobtnExtraLarge.setChecked(false);
        rdobtnThin.setChecked(false);
        rdobtnThick.setChecked(false);
        rdobtnCheeseFilled.setChecked(false);
        chkboxGarlic.setChecked(false);
    }
}
