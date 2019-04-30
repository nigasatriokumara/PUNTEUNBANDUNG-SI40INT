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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.ui.PlacePicker;
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

public class InputHotelActivity extends AppCompatActivity {

    TextView eTTitile;
    TextView eTLokasi;
    Button btnPilihFoto;
    Button btnInputHotel;
    Button btPlacesAPI;
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
        setContentView(R.layout.activity_input_hotel);
        eTTitile = (TextView) findViewById(R.id.editTitleHotel);
        eTLokasi = (TextView) findViewById(R.id.editLocationHotel);
        btnPilihFoto = (Button) findViewById(R.id.pilihFotoHotel);
        btnInputHotel = (Button) findViewById(R.id.inputHotel);
        btPlacesAPI = (Button) findViewById(R.id.btn_place);
        imageView = (ImageView) findViewById(R.id.slideimg7);
        databasePuntenBandung = FirebaseDatabase.getInstance().getReference("HotelData");
        storage = FirebaseStorage.getInstance();
        storageRef = storage.getReference();

        btnPilihFoto.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                chooseImage();


            }
        });

        btnInputHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addHotel();
            }
        });

        btPlacesAPI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // membuat Intent untuk Place Picker

                PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();

                try {
                    //menjalankan place picker

                    startActivityForResult(builder.build(InputHotelActivity.this), PLACE_PICKER_REQUEST);

                    // check apabila <a title="Solusi Tidak Bisa Download Google Play Services di Android" href="http://www.twoh.co/2014/11/solusi-tidak-bisa-download-google-play-services-di-android/" target="_blank">Google Play Services tidak terinstall</a> di HP
                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    private void addHotel() {

        final String nama = eTTitile.getText().toString().trim();
        final String lokasi = eTLokasi.getText().toString().trim();

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
                            Hotel hotel = new Hotel(id,nama,lokasi,img_url);
                            databasePuntenBandung.child(id).setValue(hotel);
                            Toast.makeText(InputHotelActivity.this, "berhasil ditambahkan", Toast.LENGTH_SHORT).show();
                            eTTitile.setText("");
                            eTLokasi .setText("");
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
        else if (requestCode == PLACE_PICKER_REQUEST){
            if (resultCode == RESULT_OK) {
                com.google.android.gms.location.places.Place place = PlacePicker.getPlace(InputHotelActivity.this, data);
                String toastMsg = String.format(
                        "%s \n", place.getAddress());
                String toastMsg2= String.format(
                        "%s \n",place.getName());

//                String toastMsg3= String.format(
//                        "Place: %s \n" +
//                                "Alamat: %s \n" +
//                                "Latlng %s \n",
//                        place.getName(), place.getAddress(),
//                        place.getLatLng().latitude+" "+place.getLatLng().longitude);

                eTLokasi.setText(toastMsg);
                eTTitile.setText(toastMsg2);
            }
        }
    }
}