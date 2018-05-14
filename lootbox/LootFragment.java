package com.mcs270.lootbox;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.File;
import java.util.UUID;

public class LootFragment extends Fragment{

    private static final String ARG_LOOT_ID = "loot_id";

    private Box mBox;


    public static LootFragment newInstance(UUID lootId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_LOOT_ID, lootId);

        LootFragment fragment = new LootFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onPause() {
        super.onPause();

        LootLab.get(getActivity())
                .updateBox(mBox);
    }

}
