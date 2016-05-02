package movil.musica.Attrs;

import android.databinding.BindingAdapter;
import android.net.Uri;
import android.widget.ImageView;

import com.makeramen.roundedimageview.RoundedTransformationBuilder;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

/**
 * Created by Dario Chamorro on 25/04/2016.
 */
public class Attrs {

    private static Transformation transformation = new RoundedTransformationBuilder()
            .scaleType(ImageView.ScaleType.CENTER_CROP)
            .oval(true)
            .build();

    @BindingAdapter("app:imgUrl")
    public static void loadImage(ImageView view, String url){
        Picasso.with(view.getContext())
                .load(Uri.parse(url))
                .into(view);
    }

    @BindingAdapter("app:imgCircleUrl")
    public static void loadCircleImage(ImageView view, String url){
        Uri uri = Uri.parse(url);
        int size =  view.getLayoutParams().width;
        Picasso.with(view.getContext()).load(uri).resize(size, size)
                .centerCrop()
                .transform(transformation).into(view);
    }

}
