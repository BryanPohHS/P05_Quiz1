package sg.edu.rp.c346.p05_quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Confirmation extends AppCompatActivity
{

  //Declare fields
  TextView tvCost, tvTicketType;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_confirmation);

    //Linking
    tvCost = findViewById(R.id.tv_cost);
    tvTicketType = findViewById(R.id.tv_tripSelection);

    Intent intentRecieved = getIntent();
    String ticketType = intentRecieved.getStringExtra("ticket");
    double totalPrice = intentRecieved.getDoubleExtra("price", 0.00);

    tvTicketType.setText("You have selected " + ticketType);
    tvCost.setText("Your air ticket costs $" + totalPrice);
  }
}
