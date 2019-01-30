package com.ingic.ezhalbatek.technician.ui.binders;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;

import com.ingic.ezhalbatek.technician.R;
import com.ingic.ezhalbatek.technician.entities.SubscriberEnt;
import com.ingic.ezhalbatek.technician.global.AppConstants;
import com.ingic.ezhalbatek.technician.interfaces.RecyclerItemListener;
import com.ingic.ezhalbatek.technician.ui.viewbinders.abstracts.RecyclerViewBinder;
import com.ingic.ezhalbatek.technician.ui.views.AnyTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created on 6/25/18.
 */
public class RegisteredUserJobsBinder extends RecyclerViewBinder<SubscriberEnt> implements View.OnClickListener {
    private RecyclerItemListener listener;

    public RegisteredUserJobsBinder(RecyclerItemListener listener) {
        super(R.layout.row_item_register_user_jobs);
        this.listener = listener;
    }


    @Override
    public BaseViewHolder createViewHolder(View view) {
        return new ViewHolder(view);
    }

    @Override
    public void bindView(SubscriberEnt entity, int position, Object viewHolder, Context context) {
        ViewHolder holder = (ViewHolder) viewHolder;
        holder.btnDetails.setTag(R.integer.key_object, entity);
        holder.btnDetails.setTag(R.integer.key_position, position);
        holder.btnReport.setTag(R.integer.key_object, entity);
        holder.btnReport.setTag(R.integer.key_position, position);
        switch (entity.getType()) {
            case AppConstants.DETAILS:
                holder.btnDetails.setVisibility(View.VISIBLE);
                holder.btnReport.setVisibility(View.VISIBLE);
                holder.btnSeperatorLine.setVisibility(View.VISIBLE);
                holder.btnDetails.setBackground(getDrawable(R.drawable.button_red, context));
                holder.btnReport.setBackground(getDrawable(R.drawable.button_gray, context));
                break;
            case AppConstants.REPORT:
                holder.btnDetails.setVisibility(View.VISIBLE);
                holder.btnReport.setVisibility(View.VISIBLE);
                holder.btnSeperatorLine.setVisibility(View.VISIBLE);
                holder.btnDetails.setBackground(getDrawable(R.drawable.button_gray, context));
                holder.btnReport.setBackground(getDrawable(R.drawable.button_red, context));
                break;
        }
    }

    private Drawable getDrawable(int resID, Context context) {
        return context.getResources().getDrawable(resID);
    }

    @Override
    public void onClick(View v) {
        if (listener != null) {
            listener.onItemClicked(v.getTag(R.integer.key_object), (int) v.getTag(R.integer.key_position), v.getId());
        }
    }

    static class ViewHolder extends BaseViewHolder {
        @BindView(R.id.txtCustomerNoText)
        AnyTextView txtCustomerNoText;
        @BindView(R.id.txtDate)
        AnyTextView txtDateTimeText;
        @BindView(R.id.btnReport)
        Button btnReport;
        @BindView(R.id.btnDetails)
        Button btnDetails;
        @BindView(R.id.btnSeperatorLine)
        View btnSeperatorLine;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
