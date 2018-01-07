package prachi14075.iiitd.ac.in.sportsmanagementapp.adapters;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import prachi14075.iiitd.ac.in.sportsmanagementapp.R;
import prachi14075.iiitd.ac.in.sportsmanagementapp.dtos.ContactDetailsDTO;

public class ContactDetailsAdapter extends RecyclerView.Adapter<ContactDetailsAdapter.ViewHolder>{

    private Context mContext;
    private ArrayList<ContactDetailsDTO> mContactsList;

    public ContactDetailsAdapter(Context mContext, ArrayList<ContactDetailsDTO> mContactsList) {
        this.mContext = mContext;
        this.mContactsList = mContactsList;
    }

    @Override
    public ContactDetailsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_contact_coordinator_details, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ContactDetailsAdapter.ViewHolder holder, int position) {
        final ContactDetailsDTO contactDetailsDTO = mContactsList.get(position);

        holder.contactNumber .setText(contactDetailsDTO.getContactNumber());
        holder.contactName   .setText(contactDetailsDTO.getContactName());
        holder.contactEmail  .setText(contactDetailsDTO.getContactEmail());
        holder.mailImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("message/rfc822");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"palaksh15153@iiitd.ac.in"});
                mContext.startActivity(Intent.createChooser(intent,"Send Email"));
            }
        });

        holder.callImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uri = "tel:9999876545" ;
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse(uri));
                mContext.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mContactsList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        CardView  contactContainer;
        TextView  contactName;
        TextView  contactEmail;
        TextView  contactNumber;
        ImageView callImage;
        ImageView mailImage;

        ViewHolder(View itemView) {
            super(itemView);
            contactContainer = (CardView) itemView.findViewById(R.id.item_contact_coordinator_details);
            contactEmail     = (TextView) itemView.findViewById(R.id.item_contact_coordinator_details_coordinator_email);
            contactName      = (TextView) itemView.findViewById(R.id.item_contact_coordinator_details_coordinator_name);
            contactNumber    = (TextView) itemView.findViewById(R.id.item_contact_coordinator_details_coordinator_number);
            callImage        = (ImageView)itemView.findViewById(R.id.item_contact_coordinator_details_call_icon);
            mailImage        = (ImageView)itemView.findViewById(R.id.item_contact_coordinator_details_email_icon);
        }
    }
}
