package com.example.lenovo.edulight;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DefaultSignUp extends AppCompatActivity implements View.OnFocusChangeListener {
    private Typeface boldFont, thinFont, normalFont;

    private TextView default_signup_header_title,default_signup_header_content;
    private TextView default_signup_term_of_service_title,default_signup_term_of_service_content;

    private EditText default_signup_gmail_address,default_signup_password,default_signup_confirm_password;

    private Button default_signup_confirm_btn;
    private Toolbar default_signup_toolbar;
    private AppBarLayout default_signup_action_bar;
    private CollapsingToolbarLayout default_signup_collapse_toolbar;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default_signup);
        boldFont = Typeface.createFromAsset(getAssets(), "oxygen.bold.ttf");
        thinFont = Typeface.createFromAsset(getAssets(), "oxygen.light.ttf");
        normalFont = Typeface.createFromAsset(getAssets(), "oxygen.regular.ttf");
        setTextFont();
        setEditTextFont();
        setButtonTextFont();
        setUpToolbar();
        setUpCollapseEditText();
        setUpCollapsingToolbar();
    }

    private void setUpCollapsingToolbar() {
        default_signup_collapse_toolbar = (CollapsingToolbarLayout)findViewById(R.id.default_sign_up_collapse_toolbar);
        default_signup_collapse_toolbar.setBackgroundColor(Color.parseColor("#00000000"));
        default_signup_collapse_toolbar.setCollapsedTitleTypeface(normalFont);

        default_signup_action_bar = (AppBarLayout)findViewById(R.id.default_sign_up_action_bar);
        default_signup_action_bar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = true;
            int scrollRange = -1;
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if(scrollRange == -1)
                {
                    scrollRange = default_signup_action_bar.getTotalScrollRange();
                }
                if(scrollRange + verticalOffset == 0)
                {
                    default_signup_collapse_toolbar.setTitle("Sign up");
                    isShow = true;
                }
                else if(isShow)
                {
                    default_signup_collapse_toolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });


    }

    private void setUpCollapseEditText() {
        default_signup_gmail_address.setOnFocusChangeListener(this);
        default_signup_password.setOnFocusChangeListener(this);
        default_signup_confirm_password.setOnFocusChangeListener(this);

    }

    private void setUpToolbar() {
        default_signup_toolbar = (Toolbar)findViewById(R.id.default_sign_up_toolbar);
        setSupportActionBar(default_signup_toolbar);
        default_signup_toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_toolbar_back_24dp,null));
        default_signup_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    private void setButtonTextFont() {
        default_signup_confirm_btn = (Button)findViewById(R.id.default_signup_confirm_btn);
        default_signup_confirm_btn.setTypeface(normalFont);
    }

    private void setEditTextFont() {
        default_signup_gmail_address = (EditText)findViewById(R.id.default_signup_gmail_address);
        default_signup_password = (EditText)findViewById(R.id.default_signup_password);
        default_signup_confirm_password = (EditText)findViewById(R.id.default_signup_confirm_password);
        default_signup_gmail_address.setTypeface(normalFont);
        default_signup_password.setTypeface(normalFont);
        default_signup_confirm_password.setTypeface(normalFont);
    }
    private void setTextFont() {
        default_signup_header_title = (TextView)findViewById(R.id.default_signup_header_title);
        default_signup_header_content = (TextView)findViewById(R.id.default_signup_header_content);
        default_signup_term_of_service_title = (TextView)findViewById(R.id.default_signup_term_of_service_title);
        default_signup_term_of_service_content = (TextView)findViewById(R.id.default_signup_term_of_service_content);
        default_signup_header_title.setTypeface(boldFont);
        default_signup_header_content.setTypeface(normalFont);
        default_signup_term_of_service_title.setTypeface(normalFont);
        default_signup_term_of_service_title.setText(Html.fromHtml("<u>Terms of Service</u>"));
        default_signup_term_of_service_content.setTypeface(normalFont);
    }

    @Override
    public void onFocusChange(View view, boolean focus) {
        switch(view.getId())
        {
            case R.id.default_signup_gmail_address:
                if(focus)
                {
                    default_signup_action_bar.setExpanded(false);
                }
                break;
            case R.id.default_signup_password:
                if(focus)
                {
                    default_signup_action_bar.setExpanded(false);
                }
                break;
            case R.id.default_signup_confirm_password:
                if(focus)
                {
                    default_signup_action_bar.setExpanded(false);
                }
                break;
        }
    }
}