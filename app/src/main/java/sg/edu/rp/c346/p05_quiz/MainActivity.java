package sg.edu.rp.c346.p05_quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
  //Declaring fields
  CheckBox cbOneWay, cbRound;
  Button btnMinus, btnPlus, btnSubmit;
  TextView numberofPax;

  int counter = 1;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //Linking the fields
    cbOneWay = findViewById(R.id.cb_oneWay);
    cbRound = findViewById(R.id.cb_round);
    btnMinus = findViewById(R.id.btn_minus);
    btnPlus = findViewById(R.id.btn_plus);
    btnSubmit = findViewById(R.id.btn_submit);
    numberofPax = findViewById(R.id.tv_numberOfPax);

    btnPlus.setOnClickListener(new View.OnClickListener()
    {
      @Override
      public void onClick(View view)
      {
        counter++;
        numberofPax.setText(Integer.toString(counter));
      }
    });

    btnMinus.setOnClickListener(new View.OnClickListener()
    {
      @Override
      public void onClick(View view)
      {
        counter--;
        numberofPax.setText(Integer.toString(counter));
      }
    });

    btnSubmit.setOnClickListener(new View.OnClickListener()
    {
      @Override
      public void onClick(View view)
      {
        Intent intent = new Intent(MainActivity.this, Confirmation.class);

        String ticketType = "";
        int totalPax = Integer.parseInt(numberofPax.getText().toString());

        double totalPrice = 0.00;
        if(cbOneWay.isChecked() && !cbRound.isChecked())
        {
          ticketType = "One Way Trip";
          totalPrice = 100 * totalPax;
        }
        else if(cbRound.isChecked() && !cbOneWay.isChecked())
        {
          ticketType = "Round Trip";
          totalPrice = (100 * totalPax) * 2;
        }
        else
        {
          Toast.makeText(MainActivity.this, "Please choose only one ticket type!", Toast.LENGTH_SHORT).show();
        }

        intent.putExtra("ticket", ticketType);
        intent.putExtra("price", totalPrice);
        startActivity(intent);
      }
    });
  }
}
