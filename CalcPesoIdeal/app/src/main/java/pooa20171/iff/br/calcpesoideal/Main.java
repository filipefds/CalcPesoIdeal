package pooa20171.iff.br.calcpesoideal;

import android.support.annotation.IdRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import static android.widget.RadioGroup.*;

public class Main extends AppCompatActivity {

    private RadioGroup rgSexo;
    private ImageView imgSexo;
    private Integer []imagens = { R.drawable.homem, R.drawable.mulher};
    private Button btCalcular;
    private EditText etAltura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.imgSexo = (ImageView) findViewById(R.id.imgSexo);
        this.rgSexo = (RadioGroup) findViewById(R.id.rgSexo);

        this.rgSexo.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton = (RadioButton) radioGroup.findViewById(i);
                int index = radioGroup.indexOfChild(radioButton);
                imgSexo.setImageResource(imagens[index]);
            }
        });

        this.btCalcular = (Button) findViewById(R.id.btCalcular);
        this.etAltura = (EditText) findViewById(R.id.etAltura);

        btCalcular.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                String mensagem = "Erro!";
                float p = 0;
                float h = Float.parseFloat(etAltura.getText().toString());
                int k = rgSexo.getCheckedRadioButtonId();
                if(k == R.id.rbHomem){
                    p = ((h - 100) - ((h - 150)/4));
                    mensagem = String.valueOf(p) + "Kg";
                }
                if(k == R.id.rbMulher){
                    p = ((h - 100) - ((h - 150)/2));
                    mensagem = String.valueOf(p) + "Kg";
                }

                AlertDialog.Builder dlg = new AlertDialog.Builder(Main.this);
                dlg.setTitle("Peso Ideal");
                dlg.setMessage(mensagem);
                dlg.setNeutralButton("OK", null);
                dlg.show();
            }
        });
    }
}
