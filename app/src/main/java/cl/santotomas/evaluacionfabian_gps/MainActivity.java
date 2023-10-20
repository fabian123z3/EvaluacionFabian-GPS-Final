package cl.santotomas.evaluacionfabian_gps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText direccion1;
    EditText direccion2;
    EditText direccion3;
    Button agregar;
    Button limpiar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        direccion1 = findViewById(R.id.Direccion1);
        direccion2 = findViewById(R.id.Direccion2);
        direccion3 = findViewById(R.id.Direccion3);
        agregar = findViewById(R.id.Agregar);
        limpiar = findViewById(R.id.Limpiar);

        limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                direccion1.setText("");
                direccion2.setText("");
                direccion3.setText("");
            }
        });

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cordenadas1 = direccion1.getText().toString();
                String cordenadas2 = direccion2.getText().toString();
                String cordenadas3 = direccion3.getText().toString();

                Intent intent = new Intent(MainActivity.this, MapaMain.class);

                intent.putExtra("cordenadas 1", cordenadas1);
                intent.putExtra("cordenadas 2", cordenadas2);
                intent.putExtra("cordenadas 3", cordenadas3);

                startActivity(intent);
            }
        });


    }
}