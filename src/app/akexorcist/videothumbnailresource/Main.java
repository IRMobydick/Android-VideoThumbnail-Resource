package app.akexorcist.videothumbnailresource;

import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

public class Main extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Bitmap bm = getVideoThumbnail(this, R.raw.vid);
		
		ImageView iv = (ImageView)findViewById(R.id.imageView1);
		iv.setImageBitmap(bm);
	}
	
	public Bitmap getVideoThumbnail(Context context, int resId) {
		String pkgName = context.getPackageName();
		Uri uri = Uri.parse("android.resource://" + pkgName + "/" + resId);
		MediaMetadataRetriever retriever = new MediaMetadataRetriever();
		retriever.setDataSource(context, uri);
		Bitmap bitmap = retriever.getFrameAtTime(100000
				, MediaMetadataRetriever.OPTION_PREVIOUS_SYNC);
        return bitmap;
     }
}
