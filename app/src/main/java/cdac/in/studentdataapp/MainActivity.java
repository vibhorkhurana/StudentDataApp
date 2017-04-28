package cdac.in.studentdataapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    EditText edName,edPrn,edEmailId,edPhoneNo;
    TextView tvAge,imCapture;
    SeekBar sbAge;
    RadioGroup rbGender;
    ImageButton ivCapture;
    Button btSubmit;
    Bitmap bmImage;
    Bundle bdCamImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edName = (EditText) findViewById(R.id.EdStName);
        edPrn = (EditText) findViewById(R.id.ecPrnNo);
        edEmailId = (EditText) findViewById(R.id.edEmlId);
        edPhoneNo = (EditText)findViewById(R.id.edMobNo);
        tvAge = (TextView) findViewById(R.id.tvAgetxt);
        imCapture = (TextView) findViewById(R.id.tvCaptureIm);
        sbAge = (SeekBar) findViewById(R.id.sbAge);
        rbGender = (RadioGroup) findViewById(R.id.rdGen);
        ivCapture = (ImageButton) findViewById(R.id.btimgCapture);
        btSubmit = (Button) findViewById(R.id.btfnlSubmit);
        btSubmit.setVisibility(View.INVISIBLE);
        sbAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(progress < 18)
                {
                    seekBar.setProgress(18);
                }
                tvAge.setText("Age: "+progress);
           //     completeData.append(tvAge.getText());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Name = edName.getText().toString();
                String PhoneNo = edPhoneNo.getText().toString();
                String EmailId = edEmailId.getText().toString();
                String PrnNo = edPrn.getText().toString();
                String Age = tvAge.getText().toString();
                String Gender;
                int rbid = rbGender.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton) findViewById(rbid);
                if(rbid>0)
                {
                    Gender = rb.getText().toString();

                }
                else {
                    Gender = rb.getText().toString();
                    Toast.makeText(MainActivity.this,"Taking gender as default", Toast.LENGTH_SHORT).show();
                }
                Intent itNextAct = new Intent(MainActivity.this,SecondActivity.class);

                Bundle ob = new Bundle();
                ob.putString("key_Name",Name);
                ob.putString("key_Age",Age);
                ob.putString("key_Emlid",EmailId);
                ob.putString("key_Gender",Gender);
                ob.putString("key_PRN",PrnNo);
                ob.putString("key_Phone",PhoneNo);
                ob.putBundle("key_ImgBundle",bdCamImg);
                itNextAct.putExtras(ob);
                startActivity(itNextAct);
            }


        });
        ivCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(itCamera,111);
                btSubmit.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==111 && resultCode == RESULT_OK)
        {
            bdCamImg = data.getExtras();
          //  bmImage = (Bitmap) bdCamImg.get("data");

        }
    }
}
