package br.com.roadmaps.mylibspinnersearch_2;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


public class SpinnerSearch extends LinearLayout {

    private Context mContext;
    private AttributeSet mAttrs;
    private TextView textViewTitle;
    private EditText editTextSearch;
    private ImageView imageViewArrow;
    private RecyclerView recycleView;




    public SpinnerSearch(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        this.mAttrs = attrs;

        InitView();
        bindView();
    }



    private void InitView(){
        this.setBackgroundColor(Color.WHITE);
        this.setOrientation(VERTICAL);


        LinearLayout linearLayoutTextImageArrow = new LinearLayout(mContext, mAttrs);
        linearLayoutTextImageArrow.setOrientation(HORIZONTAL);
        LayoutParams paramsLinearLayoutTextImageArrow = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        linearLayoutTextImageArrow.setLayoutParams(paramsLinearLayoutTextImageArrow);
        linearLayoutTextImageArrow.setGravity(Gravity.CENTER_VERTICAL);

        LinearLayout linearLayoutText = new LinearLayout(mContext, mAttrs);
        linearLayoutText.setOrientation(VERTICAL);
        LayoutParams paramsLinearText = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        paramsLinearText.weight = 8.0f;
        linearLayoutText.setLayoutParams(paramsLinearText);


        textViewTitle = new TextView(mContext, mAttrs);
        textViewTitle.setText("Selecione um item.");
        textViewTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
        textViewTitle.setPadding(16,50,16,50);
        textViewTitle.setTextColor(Color.BLACK);

        editTextSearch = new EditText(mContext, mAttrs);
        editTextSearch.setHint("Refine sua busca.");
        editTextSearch.setTextColor(Color.GRAY);
        editTextSearch.setHintTextColor(Color.GRAY);
        editTextSearch.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
        editTextSearch.setSingleLine(true);
        editTextSearch.setPadding(10,40,16,40);
        ColorStateList colorStateList = ColorStateList.valueOf(Color.TRANSPARENT);
        editTextSearch.setBackgroundTintList(colorStateList);
        Drawable img;
        Resources res = getResources();
        img = res.getDrawable(android.R.drawable.ic_menu_search);
        img.setBounds(0, 0, 60, 60);
        editTextSearch.setCompoundDrawables(img, null, null, null);
        editTextSearch.setCompoundDrawablePadding(16);
        editTextSearch.setVisibility(GONE);

        imageViewArrow = new ImageView(mContext, mAttrs);
        imageViewArrow.setBackgroundResource(R.drawable.ic_arrow_down);
        LayoutParams paramsImageView = new LinearLayout.LayoutParams(60, 60);
        paramsImageView.rightMargin = 30;
        paramsImageView.leftMargin = 20;
        paramsImageView.weight = 0.0f;
        imageViewArrow.setLayoutParams(paramsImageView);

        recycleView = new RecyclerView(mContext, mAttrs);
        LayoutParams paramsRecycle = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, 500);
        recycleView.setLayoutParams(paramsRecycle);
        recycleView.setVisibility(GONE);


        linearLayoutText.addView(textViewTitle);
        linearLayoutText.addView(editTextSearch);
        linearLayoutTextImageArrow.addView(linearLayoutText);
        linearLayoutTextImageArrow.addView(imageViewArrow);
        this.addView(linearLayoutTextImageArrow);
        this.addView(recycleView);
    }


    private void bindView(){
        textViewTitle.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                expandsOrRetractView();
            }
        });

        imageViewArrow.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                expandsOrRetractView();
            }
        });
    }


    private void expandsOrRetractView(){
        if (textViewTitle.getVisibility() == VISIBLE) {
            imageViewArrow.setBackgroundResource(R.drawable.ic_arrow_up);
            textViewTitle.setVisibility(GONE);
            editTextSearch.setVisibility(VISIBLE);
            recycleView.setVisibility(VISIBLE);
        }
        else{
            imageViewArrow.setBackgroundResource(R.drawable.ic_arrow_down);
            textViewTitle.setVisibility(VISIBLE);
            editTextSearch.setVisibility(GONE);
            recycleView.setVisibility(GONE);
        }
    }





    private void setPopulateList(){

    }




}
