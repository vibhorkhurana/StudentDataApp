package cdac.in.studentdataapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by vibhor on 26/4/17.
 */

public class SecondActivity extends Activity
{
    TextView inpGender,inpName,inpAge,inpPhone,inpEmail,inpPrnNo;
    ImageView ivDispImg;
    Button btConfirm;
    Bundle bdmRecvImg;
    Bitmap bmRecvImg;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        inpName= (TextView) findViewById(R.id.tvName);
        inpAge = (TextView) findViewById(R.id.tvAge);
        inpPhone = (TextView) findViewById(R.id.tvPhoneNo);
        inpEmail = (TextView) findViewById(R.id.tvEmailId);
        inpPrnNo = (TextView) findViewById(R.id.tvPrnNo);
        inpGender = (TextView) findViewById(R.id.tvGender);
        ivDispImg = (ImageView) findViewById(R.id.ivStImg);
        btConfirm = (Button) findViewById(R.id.btConfirm);



        Intent RevdInt = getIntent();
        Bundle ob = RevdInt.getExtras();
        //RevdInt.getStringExtra("key_Name");
        bdmRecvImg = ob.getBundle("key_ImgBundle");
        inpName.setText(ob.getString("key_Name"));
        inpAge.setText(ob.getString("key_Age"));
        inpPhone.setText(ob.getString("key_Phone"));
        inpEmail.setText(ob.getString("key_Emlid"));
        inpPrnNo.setText(ob.getString("key_PRN"));
        inpGender.setText(ob.getString("key_Gender"));
        bmRecvImg = (Bitmap) bdmRecvImg.get("data");
        ivDispImg.setImageBitmap(bmRecvImg);
        //ivDispImg.setText(RevdInt.getStringExtra("key_Name"));
        //btConfirm = (Button) findViewById(R.id.btConfirm);
        btConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondActivity.this.finish();
            }
        });
    }
}
