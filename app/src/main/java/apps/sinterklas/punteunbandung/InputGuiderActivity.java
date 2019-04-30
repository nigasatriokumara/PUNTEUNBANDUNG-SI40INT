package apps.sinterklas.punteunbandung;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class InputGuiderActivity extends AppCompatActivity {

    EditText eTNamaGuider;
    EditText eTDestinasi;
    EditText eTNotelpon;
    EditText eTEmail;
    EditText eTBahasa;
    Button btnPilihFoto;
    Button btnInputGuider;
    private int PLACE_PICKER_REQUEST = 1;
    ImageView imageView;
    DatabaseReference databasePuntenBandung;
    private Uri filePath;
    public static FirebaseStorage storage;
    public static StorageReference storageRef;
    private StorageReference refProdukImage;
    private final int PICK_IMAGE_REQUEST = 71;
    private ProgressDialog pbDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_guider);

        eTNamaGuider = (EditText) findViewById(R.id.editNamaGuider);
        eTDestinasi = (EditText) findViewById(R.id.editDestinasi);
        eTNotelpon = (EditText) findViewById(R.id.editNotelpon);
        eTEmail = (EditText) findViewById(R.id.editEmail);
        eTBahasa = (EditText) findViewById(R.id.editBahasa);
        btnPilihFoto = (Button) findViewById(R.id.pilihFotoGuider);
        btnInputGuider = (Button) findViewById(R.id.inputGuider);

        imageView = (ImageView) findViewById(R.id.slideimg5);
        databasePuntenBandung = FirebaseDatabase.getInstance().getReference("GuiderData");
        storage = FirebaseStorage.getInstance();
        storageRef = storage.getReference();

        btnPilihFoto.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                chooseImage();


            }
        });

        btnInputGuider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addGuider();
            }
        });

    }

    private void addGuider() {

        final String nama = eTNamaGuider.getText().toString().trim();
        final String dest = eTDestinasi.getText().toString().trim();
        final String telp = eTNotelpon.getText().toString().trim();
        final String email = eTEmail.getText().toString().trim();
        final String bhs = eTBahasa.getText().toString().trim();

        if (!TextUtils.isEmpty(nama)) {

            //melakukan proses update foto
            refProdukImage = storageRef.child("gambar/" + System.currentTimeMillis() + ".jpg"); //akses path dan filename storage di firebase untuk menyimpan gambar
            UploadTask uploadTask = refProdukImage.putFile(filePath);
            Log.wtf("ImageURL", refProdukImage.toString());

            //Upload image
            if(filePath != null)
            {

                Task<Uri> uriTask = uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                    @Override
                    public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                        if (!task.isSuccessful())
                        {
                            throw task.getException();
                        }

                        return refProdukImage.getDownloadUrl();
                    }

                }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                    @Override
                    public void onComplete(@NonNull Task<Uri> task) {
                        //progressBar.setVisibility(View.GONE);
                        if(task.isSuccessful()) {
                            String img_url = task.getResult().toString();
                            String id = databasePuntenBandung.push().getKey();
                            Guider guider = new Guider(id,nama,dest,telp,email,bhs,img_url);
                            databasePuntenBandung.child(id).setValue(guider);
                            eTNamaGuider.setText("");
                            eTDestinasi.setText("");
                            eTNotelpon.setText("");
                            eTEmail.setText("");
                            eTBahasa.setText("");
                            imageView.setImageDrawable(null);
                        }
                    }
                });
            }

        } else {
            Toast.makeText(this, "masukan nama ", Toast.LENGTH_LONG).show();
        }

    }

    private void chooseImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null )
        {
            filePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                imageView.setImageBitmap(bitmap);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
