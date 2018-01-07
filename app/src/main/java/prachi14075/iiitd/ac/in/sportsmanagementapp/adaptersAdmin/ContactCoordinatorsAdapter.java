package prachi14075.iiitd.ac.in.sportsmanagementapp.adaptersAdmin;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;

import prachi14075.iiitd.ac.in.sportsmanagementapp.R;
import prachi14075.iiitd.ac.in.sportsmanagementapp.dtos.ContactDetailsDTO;

public class ContactCoordinatorsAdapter extends RecyclerView.Adapter<ContactCoordinatorsAdapter.ViewHolder>{

    private Context mContext;
    private ArrayList<ContactDetailsDTO> mContactsList;

    public ContactCoordinatorsAdapter(Context mContext, ArrayList<ContactDetailsDTO> mContactsList) {
        this.mContext = mContext;
        this.mContactsList = mContactsList;
    }

    @Override
    public ContactCoordinatorsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_add_event_contact, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ContactCoordinatorsAdapter.ViewHolder holder, int position) {
        final ContactDetailsDTO contactDetailsDTO = mContactsList.get(position);

        holder.contactPhone  .setText(contactDetailsDTO.getContactNumber());
        holder.contactName   .setText(contactDetailsDTO.getContactName());
        holder.contactEmail  .setText(contactDetailsDTO.getContactEmail());
    }

    @Override
    public int getItemCount() {
        return mContactsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        EditText contactName;
        EditText contactEmail;
        EditText contactPhone;
        public ViewHolder(View itemView) {
            super(itemView);
            contactName  = (EditText) itemView.findViewById(R.id.add_event_name_coordinator);
            contactEmail = (EditText) itemView.findViewById(R.id.add_event_email_coordinator);
            contactPhone = (EditText) itemView.findViewById(R.id.add_event_contact_coordinator);
        }
    }
}
