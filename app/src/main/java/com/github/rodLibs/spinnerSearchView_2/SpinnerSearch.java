package com.github.rodLibs.spinnerSearchView_2;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import com.github.rodLibs.spinnerSearchView_2.adapter.AdapterSpinnerSearch;
import com.github.rodLibs.spinnerSearchView_2.adapter.BaseAdapter;
import com.github.rodLibs.spinnerSearchView_2.listener.OnItemClickSpinnerSearch;


public class SpinnerSearch extends LinearLayout {

    private Context mContext;
    private AttributeSet mAttrs;
    private TextView textViewTitle;
    private EditText editTextSearch;
    private ImageView imageViewArrow;
    private RecyclerView recycleView;
    private BaseAdapter adapter;
    private OnItemClickSpinnerSearch listener;


    public SpinnerSearch(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        this.mAttrs = attrs;

        InitView();
        bindView();
    }


    /**
     * @Method that initializes all components,
     * TextView, EditText, ImageView, RecycleView,
     * setting their default values.
     */
    private void InitView(){
        this.setBackgroundColor(Color.WHITE);
        this.setOrientation(VERTICAL);


        LinearLayout linearLayoutTextImageArrow = new LinearLayout(mContext, mAttrs);
        linearLayoutTextImageArrow.setOrientation(HORIZONTAL);
        LayoutParams paramsLinearLayoutTextImageArrow = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        linearLayoutTextImageArrow.setLayoutParams(paramsLinearLayoutTextImageArrow);
        linearLayoutTextImageArrow.setGravity(Gravity.CENTER_VERTICAL);

        LinearLayout linearLayoutText = new LinearLayout(mContext, mAttrs);
        linearLayoutText.setOrientation(VERTICAL);
        LayoutParams paramsLinearText = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        paramsLinearText.weight = 8.0f;
        linearLayoutText.setLayoutParams(paramsLinearText);


        textViewTitle = new TextView(mContext, mAttrs);
        textViewTitle.setText("Selecione um item");
        textViewTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
        textViewTitle.setPadding(16,35,16,35);
        textViewTitle.setTextColor(Color.BLACK);

        editTextSearch = new EditText(mContext, mAttrs);
        editTextSearch.setHint("Refine sua busca");
        editTextSearch.setTextColor(Color.GRAY);
        editTextSearch.setHintTextColor(Color.GRAY);
        editTextSearch.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
        editTextSearch.setSingleLine(true);
        editTextSearch.setPadding(10,34,16,34);

        //TODO: lançar exeções
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ColorStateList colorStateList = ColorStateList.valueOf(Color.TRANSPARENT);
            editTextSearch.setBackgroundTintList(colorStateList);
        }
        Drawable img;
        Resources res = getResources();
        img = res.getDrawable(android.R.drawable.ic_menu_search);
        img.setBounds(0, 0, 60, 60);
        editTextSearch.setCompoundDrawables(img, null, null, null);
        editTextSearch.setCompoundDrawablePadding(16);
        editTextSearch.setVisibility(GONE);

        imageViewArrow = new ImageView(mContext, mAttrs);
        imageViewArrow.setBackgroundResource(R.drawable.ic_arrow_down);
        LayoutParams paramsImageView = new LayoutParams(45, 45);
        paramsImageView.rightMargin = 30;
        paramsImageView.leftMargin = 20;
        paramsImageView.weight = 0.0f;
        imageViewArrow.setLayoutParams(paramsImageView);

        recycleView = new RecyclerView(mContext, mAttrs);
        LayoutParams paramsRecycle = new LayoutParams(LayoutParams.MATCH_PARENT, 450);
        recycleView.setLayoutParams(paramsRecycle);
        recycleView.setVisibility(GONE);


        linearLayoutText.addView(textViewTitle);
        linearLayoutText.addView(editTextSearch);
        linearLayoutTextImageArrow.addView(linearLayoutText);
        linearLayoutTextImageArrow.addView(imageViewArrow);
        this.addView(linearLayoutTextImageArrow);
        this.addView(recycleView);
    }


    /**
     * @Method that has all the events(listeners) of the components used.
     *
     * TextView and ImageView listener, to open and close the component.
     * EditText listener, for the filter on the RecycleView adapter.
     *
     * RecycleView adapter listener.
     * This listener is used to close the component when an item in the list
     * is chosen and pass this listener on to user activity.
     */
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

        editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if(adapter != null)
                    adapter.getFilter().filter(s.toString());
            }
            @Override
            public void afterTextChanged(Editable editable) {}
        });

        if(adapter != null) {
            adapter.setListener(new OnItemClickSpinnerSearch() {
                @Override
                public void onItemClickSpinner(String iten, int position) {
                    textViewTitle.setText(iten);
                    expandsOrRetractView();
                    if (listener != null) {
                        listener.onItemClickSpinner(iten, position);
                    }
                }
            });
        }
    }


    /**
     * @Method responsible for opening and closing the component.
     */
    private void expandsOrRetractView(){
        if (textViewTitle.getVisibility() == VISIBLE) {
            imageViewArrow.setBackgroundResource(R.drawable.ic_arrow_up);
            textViewTitle.setVisibility(GONE);
            editTextSearch.setVisibility(VISIBLE);
            recycleView.setVisibility(VISIBLE);
        } else{
            imageViewArrow.setBackgroundResource(R.drawable.ic_arrow_down);
            textViewTitle.setVisibility(VISIBLE);
            editTextSearch.setVisibility(GONE);
            recycleView.setVisibility(GONE);
        }
        editTextSearch.setText("");
    }



    /**
     * @Method responsible for filling the RecycleView.
     *
     * You will receive a list of String,
     * create the adapter and set the adapter in the recycleView.
     */
    public void setPopulateRecycleView(List<String> mListItens){
        if (mListItens != null) {
            adapter = new AdapterSpinnerSearch(mListItens, getContext());
            recycleView.setLayoutManager(new LinearLayoutManager(getContext()));
            recycleView.setAdapter(adapter);
            bindView();
        }else {
            throw new NullPointerException("List cannot be null");
        }
    }


    /**
     * @Method responsible for filling the RecycleView, with the user's adapter.
     * You will receive an adapter that must extend from the BaseAdapter Class
     * and implement the methods of the Filterable interface,
     * and implement the Listener for the OnItemClickSpinnerSearch interface.
     * This adapter will be set in RecycleView.
     */
    public void setPopulateRecycleViewANDSetAdapter(BaseAdapter mAdapter){
        if (mAdapter != null) {
            adapter = mAdapter;
            recycleView.setLayoutManager(new LinearLayoutManager(getContext()));
            recycleView.setAdapter(adapter);
            bindView();
        }else {
            throw new NullPointerException("Adapter cannot be null");
        }
    }


    /**
     * @Method responsible for sending the adapter's click listener to the user's activity.
     */
    public void setOnItemClickSpinner(OnItemClickSpinnerSearch listener){
        this.listener = listener;
    }



    /**
     * @Method for changing the TextView component
     * The font, color, background, text can be changed.
     */
    public void setTextTextView(String text){
        textViewTitle.setText(text);
    }
    public void setTypeFaceTextView(Typeface face){
        textViewTitle.setTypeface(face);
    }
    public void setColorTextView(int color){
        textViewTitle.setTextColor(color);
    }
    public void setSizeTextView(int size){
        textViewTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
    }
    public void setBackgroundColorTextView(int color){
        textViewTitle.setBackgroundColor(color);
    }
    public void setBackgroundResourceTextView(int res){
        textViewTitle.setBackgroundResource(res);
    }


    /**
     * @Method for changing the EditText component
     * The font, color, background, text can be changed.
     */
    public void setTextHintEditText(String hint){
        editTextSearch.setHint(hint);
    }
    public void setTypeFaceEditText(Typeface face){
        editTextSearch.setTypeface(face);
    }
    public void setColorEditText(int color){
        editTextSearch.setTextColor(color);
    }
    public void setColorHintEditText(int color){
        editTextSearch.setHintTextColor(color);
    }
    public void setSizeEditText(int size){
        editTextSearch.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
    }
    public void setBackgroundColorEditText(int color){
        editTextSearch.setBackgroundColor(color);
    }
    public void setBackgroundResourceEditText(int res){
        editTextSearch.setBackgroundResource(res);
    }
    public void setBackgroundTintListEditText(ColorStateList colorStateList){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            editTextSearch.setBackgroundTintList(colorStateList);
        }
    }
    public void setComponentDrawable(Drawable img){
        if (img != null) {
            img.setBounds(0, 0, 60, 60);
            editTextSearch.setCompoundDrawables(img, null, null, null);
            editTextSearch.setCompoundDrawablePadding(16);
        }else {
            editTextSearch.setCompoundDrawables(null, null, null, null);
            editTextSearch.setCompoundDrawablePadding(0);
        }
    }


    /**
     * @Method for changing the ImageView component
     * The image can be changed
     */
    public void setImageResourceImageView(int res){
        imageViewArrow.setImageResource(res);
    }
    public void setBitmapImageView(Bitmap bitmap){
        imageViewArrow.setImageBitmap(bitmap);
    }
    public void setSizeImageView(LayoutParams paramsImageView){
        imageViewArrow.setLayoutParams(paramsImageView);
    }


    /**
     * @Method for changing the RecycleView size component
     */
    public void setSizeRecycleView(int size){
        if (size >= 100) {
            LayoutParams paramsRecycle = new LayoutParams(LayoutParams.MATCH_PARENT, size);
            recycleView.setLayoutParams(paramsRecycle);
        }
    }
}