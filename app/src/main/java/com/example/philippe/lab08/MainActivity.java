package com.example.philippe.lab08;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.philippe.lab08.R.drawable.*;

public class MainActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menumain, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button boutonChoisirUnite = (Button) findViewById(R.id.button_choisirUnite);
        boutonChoisirUnite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ChoisirUnite.class);
                view.getContext().startActivity(intent);
            }
        });

        Button boutonEffectuerConversion = (Button) findViewById(R.id.button_EffectuerConversion);
        boutonEffectuerConversion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Calculs
                try {
                    float multiplier;
                    String units;
                    Bundle extras = getIntent().getExtras();
                    if (extras != null) {
                        multiplier = extras.getFloat("nbBananes");
                        units = extras.getString("unites");
                    } else {
                        throw new MissingDataException("Veuillez choisir une unité");
                    }

                    EditText et = (EditText) findViewById(R.id.Input);
                    String text = et.getText().toString();
                    float input = 0;
                    try{
                         input = Float.parseFloat(text);
                    }catch (NumberFormatException e){
                        throw new MissingDataException("Veuillez entrer une valeur à convertir");
                    }
                    float resultat = input * multiplier;
                    ((TextView)findViewById(R.id.resultat)).setText(String.valueOf(resultat));
                    System.out.println("units =" + units);
                    ((TextView)findViewById(R.id.unites)).setText(units);
                } catch (MissingDataException e) {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                }
            }
        });


    }

    public void aPropos(MenuItem item) {
        //Si on clique sur à propos
        View toastView = getLayoutInflater().inflate(R.layout.customtoast, (ViewGroup) findViewById(R.id.toastLayout));
        ImageView imageView = (ImageView) toastView.findViewById(R.id.image);

        imageView.setImageResource(R.drawable.toast);
        //    imageView.setBackgroundDrawable(bitmapDrawable);

        TextView textView = (TextView) toastView.findViewById(R.id.text);

        textView.setText("Yes, a Toast with an image!");

        Toast toast = new Toast(this);

        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(toastView);
        toast.show();

        Toast.makeText(this, "Veuillez choisir une unité et entrer une valeur", Toast.LENGTH_SHORT).show();

    }


}
