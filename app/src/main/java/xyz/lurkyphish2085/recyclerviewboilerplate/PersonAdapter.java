package xyz.lurkyphish2085.recyclerviewboilerplate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {

    List<PersonModel> personModels = new ArrayList<>();

    @NonNull
    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.ViewHolder holder, int position) {
        PersonModel currentItem = personModels.get(position);
        holder.setData(currentItem.getName(), currentItem.getDescription());
    }

    @Override
    public int getItemCount() {
        return personModels.size();
    }

    public void setPersonModels(List<PersonModel> personModels) {
        this.personModels = personModels;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView itemImage;
        TextView itemName, itemDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.item_image);
            itemName = itemView.findViewById(R.id.item_name);
            itemDescription = itemView.findViewById(R.id.item_desc);
        }

        void setData(int imageResourceID, String name, String description) {
            itemImage.setImageResource(imageResourceID);
            itemName.setText(name);
            itemDescription.setText(description);
        }
        void setData(String name, String description) {
            setData(R.drawable.ic_android_black_24dp, name, description);
        }
    }
}