package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * MainActivity Hosts the Recycler View which lists the details about Social Media Platforms
 * **/

public class MainActivity extends AppCompatActivity {

    private ArrayList<SocialMediaItem> socialMediaItems;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private SocialMediaAdapter socialMediaAdapter;
    private Button insertButton, deleteButton;
    private EditText insertPosition, deletePosition;
    private String[] inputOptionMenu;
    private AutoCompleteTextView acTextView;
    private final String tag = "Logging Message";
    private PlatformDetailsHolder platformDetailsHolder;
    private ArrayAdapter<String> autoCompleteTextAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Initialization of different view from the Layout
        insertButton = (Button) findViewById(R.id.insertButton);
        insertPosition = (EditText) findViewById(R.id.insertPosition);
        acTextView = (AutoCompleteTextView) findViewById(R.id.insertText);
        acTextView.setThreshold(1);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

//       Method to create the initial list for the Recycler View to display
        createRecyclerViewItems();

//      Create a static Input Menu list for the user's ease
        createTextInputOptionMenuAttachAdapter();

//      Configure the RecyclerView with Adapter and Layout Manager
        configureRecyclerView();

//       Register the Insert Button to the On Click Event
        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              Validate user input
                Boolean valid = validateInput();

//               If Valid, check if the position is valid and get the position and
//               Social Media Platform to be inserted to the RecyclerView
                if (valid == true) {
                    Resources res = getResources();
                    if (Integer.parseInt(insertPosition.getText().toString()) > socialMediaItems.size()) {
                        Toast.makeText(getApplicationContext(), res.getString(R.string.invalid_position), Toast.LENGTH_SHORT);
                    } else {
                        handleItemInsert(Integer.parseInt(insertPosition.getText().toString()), acTextView.getText().toString());
                    }
                }
            }
        });
    }

    void createRecyclerViewItems(){
//     Create a new ArrayList of type SocialMediaItem
        socialMediaItems = new ArrayList<>();
       socialMediaItems.add(new SocialMediaItem("Instagram"));
       socialMediaItems.add(new SocialMediaItem("Facebook"));
       socialMediaItems.add(new SocialMediaItem("WhatsApp"));
    }

    void configureRecyclerView(){
//      Configure the RecyclerView with the custom Adapter (SocialMediaAdapter) and Layout Manager
        socialMediaAdapter = new SocialMediaAdapter(socialMediaItems);
        recyclerView.setAdapter(socialMediaAdapter);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

//      Register the custom adapter for the Item Click event and implement the methods
        socialMediaAdapter.setOnItemClickListenr(new SocialMediaAdapter.OnItemClickListener() {

//            Implement OnItemClick() method of the interface OnItemClickListener
            @Override
            public void onItemClick(int position) {
//                  Start a new Activity which displays details of each Social Media Platforms
                    Intent intent = new Intent(getApplicationContext(), PlatformDetailsActivity.class);
                    intent.putExtra("platformDetails", socialMediaItems.get(position).getPlatformDetails());
                    startActivity(intent);
                }

//             Implement onItemDelete() method of the interface OnItemClickListener
            @Override
            public void onItemDelete(int position) {
                handleDeleteItem(position);
            }
        });
    }

//  When the user enters the position, desired Social Media Platform Name and clicks Insert,
//  insert the new platform into the ArrayList socialMediaItems at the given position and notify the
//   Adapter that the ArrayList has new elements and has to be displayed
    void  handleItemInsert(int position, String platformName){
    socialMediaItems.add(position, new SocialMediaItem(platformName));
    socialMediaAdapter.notifyItemInserted(position);
    }

//   When the user hits the trash icon in the list item level, remove the platfrom from the ArrayLIst socialMediaItems
//    and notify the adapter that an item has been removed and the RecyclerView has to also remove that entry
    void handleDeleteItem(int position){
        socialMediaItems.remove(position);
        socialMediaAdapter.notifyItemRemoved(position);
    }

//   When the User clicks on the EditText to enter the desired platform name, display this list for ease
//   of user selection. Only a limited Platform names are included to show the functionality
    void createTextInputOptionMenuAttachAdapter(){

//      Class PlatformDetailsHolder holds the details of 6 social media platforms.
//      Get an instance of this class to obtain the private details
        platformDetailsHolder = new PlatformDetailsHolder();
        inputOptionMenu = new String[6];
            inputOptionMenu[0] = platformDetailsHolder.getInstagramPlatformName();
            inputOptionMenu[1] = platformDetailsHolder.getFacebookPlatformName();
            inputOptionMenu[2] = platformDetailsHolder.getMessangerPlatformName();
            inputOptionMenu[3] = platformDetailsHolder.getTumblrPlatformName();
            inputOptionMenu[4] = platformDetailsHolder.getWhatsAppPlatformName();
            inputOptionMenu[5] = platformDetailsHolder.getYouTubePlatformName();

//      Create a new Array Adapter of type String and provide
//      the Context, Layout file for the input menu list and the String Array to be displayed
        autoCompleteTextAdapter = new ArrayAdapter<String>(this, R.layout.input_text_option_menu,inputOptionMenu);

//      Attach the adapter to the autocomplete textview
        acTextView.setAdapter(autoCompleteTextAdapter);
    }

//    Check if the user has entered anything in the position and platform name edit texts.
//    If not, throw and error via Toast message
    Boolean validateInput(){
        Boolean valid = true;
        String temp1 = insertPosition.getText().toString();
        String temp2 = acTextView.getText().toString();
        if (temp1.matches("")){
            Log.i(tag, "Invalid Position");
            Toast.makeText(getApplicationContext(),"Invalid Position Input", Toast.LENGTH_SHORT).show();
            valid = false;
        }
        if (temp2.matches("")){
            Log.i(tag, "Invalid option");
            Toast.makeText(getApplicationContext(),"Invalid option", Toast.LENGTH_SHORT).show();
            valid = false;
        }
        return valid;
    }
}
