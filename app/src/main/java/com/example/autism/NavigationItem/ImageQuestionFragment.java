package com.example.autism.NavigationItem;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.autism.DeliveryResultListener;
import com.example.autism.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ImageQuestionFragment extends Fragment {


    int[] emotionArray = {R.drawable.tired256x256, R.drawable.loved256x256, R.drawable.sad256x256,
            R.drawable.surprised256x256, R.drawable.angry256x256, R.drawable.happy256x256};

    int[] foodArray = {R.drawable.biscuit256x256, R.drawable.bread256x256, R.drawable.chicken256x256,
            R.drawable.egg256x256, R.drawable.noodle256x256, R.drawable.rice256x256};

    int[] drinksArray = {R.drawable.coffee256x256, R.drawable.coke256x256, R.drawable.juice256x256,
            R.drawable.milk256x256, R.drawable.milkshake256x256, R.drawable.tea256x256};

    int[] vehicleArray = {R.drawable.auto256x256, R.drawable.bus256x256, R.drawable.car256x256,
            R.drawable.rickshaw256x256, R.drawable.train256x256, R.drawable.truck256x256};

    int[] diseasesArray = {R.drawable.allergy256x256, R.drawable.cold256x256, R.drawable.fever256x256,
            R.drawable.stomachache256x256, R.drawable.toothache256x256, R.drawable.wound256x256};

    int[] actionArray = {R.drawable.cleaning256x256, R.drawable.giving256x256, R.drawable.jumping256x256,
            R.drawable.riding256x256, R.drawable.running256x256, R.drawable.throwing256x256};


    int questionNumber = 1;
    int marks = 0;

    ImageView imageView, imageOne, imageTwo, imageThree, imageFour;
    TextView textView,question_number_tv,marks_tv;
    ImageView selectedImageView;

    Button submit_btn;
    LinearLayout main_layout;

    private Context context;
    private DeliveryResultListener deliveryResultListener;

    public static ImageQuestionFragment getInstance(String questionNumber, String marks){

        Bundle bundle = new Bundle();
        /*bundle.putString("questionNumber",questionNumber);
        bundle.putString("marks",marks);*/
        ImageQuestionFragment imageQuestionFragment = new ImageQuestionFragment();
        imageQuestionFragment.setArguments(bundle);
        return imageQuestionFragment;

    }

    public ImageQuestionFragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        deliveryResultListener = (DeliveryResultListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_image_question, container, false);


        //Layout
        main_layout = view.findViewById(R.id.main_layout);

        textView = view.findViewById(R.id.textView);
        question_number_tv = view.findViewById(R.id.question_number_tv);
        marks_tv = view.findViewById(R.id.marks_tv);
        submit_btn = view.findViewById(R.id.submit_btn);
        imageView = view.findViewById(R.id.target);
        imageOne = view.findViewById(R.id.imageOne);
        imageTwo = view.findViewById(R.id.imageTwo);
        imageThree = view.findViewById(R.id.imageThree);
        imageFour = view.findViewById(R.id.imageFour);


        setUpLayout(emotionArray);


        imageOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imageOne.setBackgroundResource(R.drawable.answer_selected_backgroud);
                imageTwo.setBackgroundResource(R.drawable.answer_item_backgournd);
                imageThree.setBackgroundResource(R.drawable.answer_item_backgournd);
                imageFour.setBackgroundResource(R.drawable.answer_item_backgournd);
                selectedImageView = imageOne;
            }
        });
        imageTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageOne.setBackgroundResource(R.drawable.answer_item_backgournd);
                imageTwo.setBackgroundResource(R.drawable.answer_selected_backgroud);
                imageThree.setBackgroundResource(R.drawable.answer_item_backgournd);
                imageFour.setBackgroundResource(R.drawable.answer_item_backgournd);
                selectedImageView = imageTwo;

            }
        });
        imageThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imageOne.setBackgroundResource(R.drawable.answer_item_backgournd);
                imageTwo.setBackgroundResource(R.drawable.answer_item_backgournd);
                imageThree.setBackgroundResource(R.drawable.answer_selected_backgroud);
                imageFour.setBackgroundResource(R.drawable.answer_item_backgournd);
                selectedImageView = imageThree;

            }
        });
        imageFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageOne.setBackgroundResource(R.drawable.answer_item_backgournd);
                imageTwo.setBackgroundResource(R.drawable.answer_item_backgournd);
                imageThree.setBackgroundResource(R.drawable.answer_item_backgournd);
                imageFour.setBackgroundResource(R.drawable.answer_selected_backgroud);
                selectedImageView = imageFour;

            }
        });

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ( selectedImageView != null) {
                    //Answer Selected
                    selectedImageView.setBackgroundResource(R.drawable.answer_item_backgournd);
                    questionNumber = questionNumber + 1;

                    if (selectedImageView.getTag().equals(imageView.getTag())) {
                        //Answer Right
                        marks = marks + 1;
                        main_layout.setVisibility(LinearLayout.INVISIBLE);
                        Snackbar.make(view,"Correct",Snackbar.LENGTH_INDEFINITE)
                                .setAction("OK", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        main_layout.setVisibility(LinearLayout.VISIBLE);
                                    }
                                }).show();

                    } else {
                        //Answer Wrong
                        main_layout.setVisibility(LinearLayout.INVISIBLE);
                        Snackbar.make(view,"You choose the wrong image",Snackbar.LENGTH_INDEFINITE)
                                .setAction("OK", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        main_layout.setVisibility(LinearLayout.VISIBLE);
                                    }
                                }).show();
                    }
                    switch (questionNumber){

                        case 1:
                            setUpLayout(emotionArray);
                            break;
                        case 2:
                            setUpLayout(foodArray);
                            break;
                        case 3:
                            setUpLayout(drinksArray);
                            break;
                        case 4:
                            setUpLayout(vehicleArray);
                            break;
                        case 5:
                            setUpLayout(diseasesArray);
                            break;
                        case 6:
                            setUpLayout(actionArray);
                            break;
                            default:
                                Fragment fragment = AudioFragment.getInstance((questionNumber),marks);
                                deliveryResultListener.
                                        deliverResult(fragment);
                                break;
                    }


                }
                else {
                    //image not selected
                    Toast.makeText(context, "Please Select Image First", Toast.LENGTH_SHORT).show();
                }

            }

        });


        return view;
    }

    public void shuffle(int[] imageArray) {

        int numberOfElement = imageArray.length;

        for (int i = 0; i < numberOfElement; i++) {
            int s = i + (int) (Math.random() * (numberOfElement - i));
            int temp = imageArray[s];
            imageArray[s] = imageArray[i];
            imageArray[i] = temp;

        }

    }

    public void setUpLayout(int[] imageArray) {

        selectedImageView = null;
        question_number_tv.setText("Question Number : "+String.valueOf(questionNumber));
        marks_tv.setText("Marks Gain : "+String.valueOf(marks));

        shuffle(imageArray);
        int[] finalArray = {imageArray[0], imageArray[1], imageArray[2], imageArray[3]};

        imageView.setImageResource(finalArray[0]);
        imageView.setTag(finalArray[0]);

        shuffle(finalArray);


        //Setting answer image
        imageOne.setImageResource(finalArray[0]);
        imageTwo.setImageResource(finalArray[1]);
        imageThree.setImageResource(finalArray[2]);
        imageFour.setImageResource(finalArray[3]);

        //Setting answer tag
        imageOne.setTag(finalArray[0]);
        imageTwo.setTag(finalArray[1]);
        imageThree.setTag(finalArray[2]);
        imageFour.setTag(finalArray[3]);

    }



}
