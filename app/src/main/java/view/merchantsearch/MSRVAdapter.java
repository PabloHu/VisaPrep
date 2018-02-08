package view.merchantsearch;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.software.huaman.visaprep.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import model.MerchSearch;
import view.checkout2.Checkout2Activity;

/**
 * Created by kiwic on 2/3/2018.
 */

public class MSRVAdapter extends RecyclerView.Adapter<MSRVAdapter.ViewHolder> {


    private static final String TAG = "RecyclerViewAdapter";
    List<MerchSearch> merchSearchList = new ArrayList<>();
    Context context;
    boolean greenView = true;

    public MSRVAdapter(List<MerchSearch> merchSearchList, Context context) {
        this.merchSearchList = merchSearchList;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvMerchName;
        private TextView tvMerchCity;
        private TextView tvMerchState;
        private TextView tvMerchPostal;
        private CardView cvMerchId;
        private ImageView ivMerchLogo;


        public ViewHolder(View itemView) {
            super(itemView);
            tvMerchName = itemView.findViewById(R.id.tvMerchName);
            tvMerchCity = itemView.findViewById(R.id.tvMerchCity);
            tvMerchState = itemView.findViewById(R.id.tvMerchState);
            tvMerchPostal = itemView.findViewById(R.id.tvMerchPostal);
            cvMerchId = itemView.findViewById(R.id.cvMerchId);
            ivMerchLogo = itemView.findViewById(R.id.ivMerchLogo);

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        if (greenView == true) {
            View view = LayoutInflater
                    .from(parent.getContext())
                    .inflate(R.layout.rv_merchsearch_item, parent, false);
            greenView = false;
            return new ViewHolder(view);
        } else {
            View view = LayoutInflater
                    .from(parent.getContext())
                    .inflate(R.layout.rv_merchsearch_item2, parent, false);
            greenView = true;
            return new ViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder position: " + position);
        MerchSearch merchSearch = merchSearchList.get(position);

        holder.cvMerchId.setId(merchSearch.getId());
        holder.tvMerchName.setText(merchSearch.getName());
        holder.tvMerchCity.setText(merchSearch.getCity());
        holder.tvMerchState.setText(String.valueOf(merchSearch.getState()));
        holder.tvMerchPostal.setText(String.valueOf(merchSearch.getPostalCode()));
        Log.d(TAG, "onBindViewHolder: " + merchSearch.getLogo());

        Picasso.with(context)
                .load(merchSearch.getLogo())
                .error(R.drawable.ic_launcher_background)
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.ivMerchLogo);

        holder.cvMerchId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent checkoutIntent = new Intent(context, Checkout2Activity.class);
                context.startActivity(checkoutIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return merchSearchList.size();
    }


}
