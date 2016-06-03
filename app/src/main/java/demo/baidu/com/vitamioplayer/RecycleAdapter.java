package demo.baidu.com.vitamioplayer;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2016/05/31.
 */
public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder> {
    private final Resources resources;
    Context context;
    List<String> list;
    List<String> list1;
    OnItemClickListener listener;

    public RecycleAdapter(Context context, List<String> list, List<String> list1) {
        this.context = context;
        this.list = list;
        this.list1 = list1;
        resources = context.getResources();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

//        holder.pic.setImageResource(list1.get(position));
//        Glide.with(context).load(list1.get(position)).into(holder.pic);
        DraweeController draweeController1 = Fresco.newDraweeControllerBuilder().setUri(Uri.parse(list1.get(position))).setAutoPlayAnimations(true).build();
        holder.pic.setController(draweeController1);
//
//  Bitmap bitmap = BitmapFactory.decodeResource(resources, list1.get(position));
//        //异步获得bitmap图片颜色值
//        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
//            @Override
//            public void onGenerated(Palette palette) {
//                Palette.Swatch vibrant = palette.getVibrantSwatch();//有活力
//                Palette.Swatch c = palette.getDarkVibrantSwatch();//有活力 暗色
//                Palette.Swatch d = palette.getLightVibrantSwatch();//有活力 亮色
//                Palette.Swatch f = palette.getMutedSwatch();//柔和
//                Palette.Swatch a = palette.getDarkMutedSwatch();//柔和 暗色
//                Palette.Swatch b = palette.getLightMutedSwatch();//柔和 亮色
//
//                if (vibrant != null) {
//                    int color1 = vibrant.getBodyTextColor();//内容颜色
//                    int color2 = vibrant.getTitleTextColor();//标题颜色
//                    int color3 = vibrant.getRgb();//rgb颜色
//
//                    holder.title.setBackgroundColor(
//                            vibrant.getRgb());
//                    holder.title.setTextColor(
//                            vibrant.getTitleTextColor());
//                }
//            }
//        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onItemClick(position, list.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    /**
     * 内部接口回调方法
     */
    public interface OnItemClickListener {
        void onItemClick(int position, Object object);
    }

    /**
     * 设置监听方法
     *
     * @param listener
     */
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private SimpleDraweeView pic;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.name);
            pic = (SimpleDraweeView) view.findViewById(R.id.pic);
        }
    }
}
