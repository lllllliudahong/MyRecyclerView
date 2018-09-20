package android.my.com.myrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private Context context;
    private ArrayList<String> datas;

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView id_image;
        TextView tvTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.id_num);
            id_image = (ImageView) itemView.findViewById(R.id.id_image);
        }
    }

    public RecyclerViewAdapter(Context context, ArrayList<String> datas) {
        this.context = context;
        this.datas = datas;
    }

    /**
     * 相当于getView方法中View和ViewHolder
     * @param viewGroup
     * @param i
     * @return
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = View.inflate(context, R.layout.item_home, null);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        itemView.setLayoutParams(lp);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
    //根据position得到对应的数据
        final int position = i;
        String data = datas.get(i);
        viewHolder.tvTitle.setText(data);
        viewHolder.tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "点击text ---- " + position, Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.id_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "点击image ---- " + position, Toast.LENGTH_SHORT).show();
            }
        });

        setItemClick( viewHolder.itemView,viewHolder.tvTitle,position);
    }

    public void setItemClick(View view, final TextView textView, final int position){
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("点击 ---- " + position);
                datas.set(position,"点击 ---- " + position);
                Toast.makeText(context, "点击 ---- " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 总条数
     * @return
     */
    @Override
    public int getItemCount() {
        return datas.size();
    }
}
