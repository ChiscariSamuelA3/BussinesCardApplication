package com.MyCard.bussinescardapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.util.UUID;

public class savedActivity extends AppCompatActivity {
    private static final int SELECT_PICTURE = 100;
    private static final String TAG = "savedActivity";
    private TextView finalName, finalJob, finalEmail, finalPhone, finalAdress, finalSite, finalCompany;
    private ImageView templateImg;
    private ImageView finalImgProfile;
    public Uri imgUri;

    private FirebaseStorage storage;
    private StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved);

            finalName = findViewById(R.id.savedNume);
            finalJob = findViewById(R.id.savedJob);
            finalEmail = findViewById(R.id.savedEmail);
            finalPhone = findViewById(R.id.savedPhone);
            finalAdress = findViewById(R.id.savedAdress);
            finalSite = findViewById(R.id.savedSite);
            finalCompany = findViewById(R.id.savedCompany);
            templateImg = findViewById(R.id.savedtemplateCard);
            finalImgProfile = findViewById(R.id.savedImgProfile);


        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

        StorageReference profileRef = storageReference.child("profile.jpg");

        profileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(finalImgProfile);
            }
        });


        SharedPreferences myPref = getSharedPreferences("myKey", MODE_PRIVATE);
            String nameSaved = myPref.getString("savename","Name");
            String jobSaved = myPref.getString("savejob", "Job");
            String companySaved = myPref.getString("savecompany", "Company");
            String emailSaved = myPref.getString("saveemail", "Email");
            String phoneSaved = myPref.getString("savephone", "Phone number");
            String adressSaved = myPref.getString("saveadress", "Adress");
            String siteSaved = myPref.getString("savesite", "Website");


            finalName.setText(nameSaved);
            finalJob.setText(jobSaved);
            finalCompany.setText(companySaved);
            finalEmail.setText(emailSaved);
            finalPhone.setText(phoneSaved);
            finalAdress.setText(adressSaved);
            finalSite.setText(siteSaved);

            String idcardSaved = myPref.getString("savecardid","c1");

        switch (idcardSaved)
        {
            case "c1" :
                templateImg.setImageResource(R.mipmap.card1);
                break;
            case "c2":
                templateImg.setImageResource(R.mipmap.card2);
                break;
            case "c3":
                templateImg.setImageResource(R.mipmap.card3);
                break;
            case "c4":
                templateImg.setImageResource(R.mipmap.card4);
                break;
            case "c5":
                templateImg.setImageResource(R.mipmap.card5);
                break;
            case "c6":
                templateImg.setImageResource(R.mipmap.card6);
                break;
        }

    }


}
