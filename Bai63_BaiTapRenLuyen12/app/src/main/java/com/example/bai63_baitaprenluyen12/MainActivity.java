package com.example.bai63_baitaprenluyen12;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.adapter.MyFileAdapter;
import com.example.model.FileSupport;
import com.example.model.MyFile;
import com.example.util.Converter;

import java.io.File;

import static com.example.model.FileSupport.MP3;
import static com.example.model.FileSupport.MP4;
import static com.example.model.FileSupport.NOTSUPPORT;

public class MainActivity extends AppCompatActivity {

    ListView lvMyFile;
    MyFileAdapter myFileAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
        
        readFolderFromSDCard();
    }

    private void readFolderFromSDCard() {
        String root = Environment.getExternalStorageDirectory().getAbsolutePath();
        Intent intentParent = getIntent();
        if(intentParent != null){
            if(intentParent.hasExtra("PARENT")){
                root = intentParent.getStringExtra("PARENT");
            }
        }
        File f = new File(root);
        File []dsFileFolder = f.listFiles();
        myFileAdapter.clear();
        for(File fileOrFolder:dsFileFolder){
            MyFile myFile = new MyFile();
            myFile.setPath(fileOrFolder.getAbsolutePath());
            myFile.setDisplay(fileOrFolder.getName());
            if(fileOrFolder.isDirectory()){
                myFile.setFileType(FileSupport.FOLDER);
                myFile.setDesc("Có " + fileOrFolder.list().length + " tập tin con");
                myFile.setHasChild(true);
            }
            else {
                if(fileOrFolder.getPath().toLowerCase().endsWith(".mp3")){
                    myFile.setFileType(MP3);
                }
                else if(fileOrFolder.getPath().toLowerCase().endsWith(".mp4")){
                    myFile.setFileType(MP4);
                }
                else {
                    myFile.setFileType(NOTSUPPORT);
                }
                String s = Converter.humanReadableByteCount(fileOrFolder.length(), true);
                myFile.setDesc(s);
            }
            myFileAdapter.add(myFile);
        }
    }

    private void addEvents() {

    }

    private void addControls() {
        lvMyFile = findViewById(R.id.lvMyFile);
        myFileAdapter = new MyFileAdapter(MainActivity.this, R.layout.item);
        lvMyFile.setAdapter(myFileAdapter);
    }
}
