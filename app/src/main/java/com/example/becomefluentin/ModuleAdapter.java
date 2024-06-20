package com.example.becomefluentin;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.becomefluentin.modules.Module;

import java.util.List;

public class ModuleAdapter extends RecyclerView.Adapter<ModuleAdapter.ModuleViewHolder> {
    private List<Module> moduleList;

    public ModuleAdapter(List<Module> moduleList) {
        this.moduleList = moduleList;
    }

    @NonNull
    @Override
    public ModuleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_module, parent, false);
        return new ModuleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ModuleViewHolder holder, int position) {
        Module module = moduleList.get(position);
        holder.textViewName.setText(module.getName());
        holder.textViewDescription.setText(module.getDescriptions());
    }

    @Override
    public int getItemCount() {
        return moduleList.size();
    }

    public class ModuleViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        TextView textViewDescription;

        public ModuleViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.module_name);
            textViewDescription = itemView.findViewById(R.id.word_count);

            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    Module module = moduleList.get(position);

                    Intent intent = new Intent(itemView.getContext(), ModuleWordsActivity.class);
                    intent.putExtra("moduleId", module.getId()); // Передаем ID модуля в новую активность
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}
