package com.example.pomik.nytmobipaper.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.text.format.Time;
import android.widget.ImageView;
import com.example.pomik.nytmobipaper.model.database.DatabaseHandler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class ImageSaver {
    private Context context;

    private static volatile ImageSaver instance;

    private ImageSaver(Context context) {
        this.context = context;
    }

    private ImageSaver() {

    }

    public static ImageSaver getInstance(Context context) {
        if (instance == null)
            synchronized (ImageSaver.class) {
                if (instance == null)
                    instance = new ImageSaver(context);
            }
        return instance;
    }

    public static ImageSaver getInstance() {
        if (instance == null)
            synchronized (ImageSaver.class) {
                if (instance == null)
                    instance = new ImageSaver();
            }
        return instance;
    }

    public String saveImage(ImageView imageView) {
        String folder = context.getCacheDir().toString();

        OutputStream fOut = null;
        Time time = new Time();
        time.setToNow();
        String filePath = null;

        try {
            filePath = folder + Integer.toString(time.year)
                    + Integer.toString(time.month) + Integer.toString(time.monthDay)
                    + Integer.toString(time.hour) + Integer.toString(time.minute)
                    + Integer.toString(time.second) +".jpg";
            File file = new File(filePath);

            fOut = new FileOutputStream(file);

            Bitmap bitmap = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 85, fOut);

            fOut.flush();
            fOut.close();

        } catch (Exception e) {

        }
        return filePath;
    }

    public Bitmap loadImage(String imagePath) {
        Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
        return bitmap;
    }
}
