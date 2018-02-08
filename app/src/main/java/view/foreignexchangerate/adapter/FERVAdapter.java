package view.foreignexchangerate.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.software.huaman.visaprep.R;
import view.checkout2.Checkout2Activity;
import view.foreignexchangerate.model.FERResponse;

/**
 * Created by kiwic on 2/8/2018.
 */

public class FERVAdapter extends RecyclerView.Adapter<FERVAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";
    Context context;
    boolean greenView = true;

    FERResponse ferResponse = new FERResponse();

    public FERVAdapter(FERResponse ferResponse, Context context) {
        this.ferResponse = ferResponse;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvAdress;
        private TextView tvMarkupRate;
        private TextView tvRetrRefNumber;
        private TextView tvSourceAmount;
        private TextView tvSourceCurrencyCode;
        private TextView tvSysTraceAuditNumber;
        private CardView cvMerchId;


        public ViewHolder(View itemView) {
            super(itemView);
            tvAdress = itemView.findViewById(R.id.tvAdress);
            tvMarkupRate = itemView.findViewById(R.id.tvMarkupRate);
            tvRetrRefNumber = itemView.findViewById(R.id.tvRetrRefNumber);
            tvSourceAmount = itemView.findViewById(R.id.tvSourceAmount);
            tvSourceCurrencyCode = itemView.findViewById(R.id.tvSourceCurrencyCode);
            tvSysTraceAuditNumber = itemView.findViewById(R.id.tvSysTraceAuditNumber);
            cvMerchId = itemView.findViewById(R.id.cvMerchId);
        }
    }

    @Override
    public FERVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");

        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.rv_fervsearch_item, parent, false);
        greenView = false;
        return new FERVAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final FERVAdapter.ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder position: " + position);

        holder.tvAdress.setText(ferResponse.getCardAcceptor().getAddress().getState());
        holder.tvMarkupRate.setText(ferResponse.getMarkUpRate());
        holder.tvRetrRefNumber.setText(ferResponse.getRetrievalReferenceNumber());
        holder.tvSourceAmount.setText(ferResponse.getSourceAmount());
        holder.tvSourceCurrencyCode.setText(ferResponse.getSourceCurrencyCode());
        holder.tvSysTraceAuditNumber.setText(ferResponse.getSystemsTraceAuditNumber());


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
        return 1;
    }


}
