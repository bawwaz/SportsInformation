package com.example.sportinformation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailTeamPage extends AppCompatActivity {
    Intent i;
    EPLTeamModel eplTeamModel;
    private TextView Name,Desc;
    private ImageView Logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_team_page);

        Name = findViewById(R.id.Tname);
        Desc = findViewById(R.id.Tdesc);
        Logo = findViewById(R.id.Tlogo);

        Intent i = getIntent();
        eplTeamModel = (EPLTeamModel) i.getParcelableExtra("myteam");

        Name.setText(eplTeamModel.getTeamname());
        Desc.setText(eplTeamModel.getTeamdescription());
        Glide.with(this).load(eplTeamModel.getStrTeamBadge()).into(Logo);
    }
}