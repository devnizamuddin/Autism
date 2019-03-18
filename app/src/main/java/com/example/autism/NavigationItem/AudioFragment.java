package com.example.autism.NavigationItem;


import android.content.Context;
import android.media.MediaPlayer;
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
import com.example.autism.PoJo.AudioImagePoJo;
import com.example.autism.R;

import java.util.ArrayList;
import java.util.Collections;


/**
 * A simple {@link Fragment} subclass.
 */
public class AudioFragment extends Fragment {


    private Context context;

    private Button play_btn, submit_btn;
    private MediaPlayer mediaPlayer;
    ArrayList<AudioImagePoJo> foodImageAudioArrayList, animalsImageAudioArrayList,
            colorImageAudioArrayList, objectsImageAudioArrayList;

    ImageView selectedImageView, imageOne, imageTwo, imageThree, imageFour;
    int seletedAudio;
    int questionNumber = 1;
    int marks = 0;
    TextView question_number_tv, marks_tv;

    LinearLayout linearLayout;
    DeliveryResultListener deliveryResultListener;

    public static AudioFragment getInstance(int question, int marks) {

        Bundle bundle = new Bundle();
        bundle.putInt("question", question);
        bundle.putInt("marks", marks);
        AudioFragment audioFragment = new AudioFragment();
        audioFragment.setArguments(bundle);
        return audioFragment;
    }

    public AudioFragment() {
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
        final View view = inflater.inflate(R.layout.fragment_audio, container, false);

        play_btn = view.findViewById(R.id.play_audio_btn);
        imageOne = view.findViewById(R.id.imageOne);
        imageTwo = view.findViewById(R.id.imageTwo);
        imageThree = view.findViewById(R.id.imageThree);
        imageFour = view.findViewById(R.id.imageFour);
        submit_btn = view.findViewById(R.id.submit_btn);
        question_number_tv = view.findViewById(R.id.question_number_tv);
        marks_tv = view.findViewById(R.id.marks_tv);

        linearLayout = view.findViewById(R.id.main_layout);

        questionNumber = getArguments().getInt("question");
        marks = getArguments().getInt("marks");

        foodImageAudioArrayList = new ArrayList<>();
        foodImageAudioArrayList.add(new AudioImagePoJo(R.raw.apple, R.drawable.apple256x256));
        foodImageAudioArrayList.add(new AudioImagePoJo(R.raw.banana, R.drawable.banana256x256));
        foodImageAudioArrayList.add(new AudioImagePoJo(R.raw.grape, R.drawable.grape256x256));
        foodImageAudioArrayList.add(new AudioImagePoJo(R.raw.mango, R.drawable.mango256x256));
        foodImageAudioArrayList.add(new AudioImagePoJo(R.raw.watermelon, R.drawable.watermelon256x256));
        foodImageAudioArrayList.add(new AudioImagePoJo(R.raw.guava, R.drawable.whiteguava1690144256x256));

        animalsImageAudioArrayList = new ArrayList<>();
        animalsImageAudioArrayList.add(new AudioImagePoJo(R.raw.cat, R.drawable.cat256x256));
        animalsImageAudioArrayList.add(new AudioImagePoJo(R.raw.cow, R.drawable.cow256x256));
        animalsImageAudioArrayList.add(new AudioImagePoJo(R.raw.dog, R.drawable.dog256x256));
        animalsImageAudioArrayList.add(new AudioImagePoJo(R.raw.elephant, R.drawable.ele256x256));
        animalsImageAudioArrayList.add(new AudioImagePoJo(R.raw.goat, R.drawable.goat256x256));
        animalsImageAudioArrayList.add(new AudioImagePoJo(R.raw.tiger, R.drawable.tiger256x256));

        colorImageAudioArrayList = new ArrayList<>();
        colorImageAudioArrayList.add(new AudioImagePoJo(R.raw.blue, R.drawable.blue256x256));
        colorImageAudioArrayList.add(new AudioImagePoJo(R.raw.green, R.drawable.green256x256));
        colorImageAudioArrayList.add(new AudioImagePoJo(R.raw.orange, R.drawable.orange256x256));
        colorImageAudioArrayList.add(new AudioImagePoJo(R.raw.red, R.drawable.red256x256));
        colorImageAudioArrayList.add(new AudioImagePoJo(R.raw.violet, R.drawable.purple256x256));
        colorImageAudioArrayList.add(new AudioImagePoJo(R.raw.yellow, R.drawable.yellow256x256));

        objectsImageAudioArrayList = new ArrayList<>();
        objectsImageAudioArrayList.add(new AudioImagePoJo(R.raw.ball, R.drawable.ball256x256));
        objectsImageAudioArrayList.add(new AudioImagePoJo(R.raw.book, R.drawable.book256x256));
        objectsImageAudioArrayList.add(new AudioImagePoJo(R.raw.chair, R.drawable.chair2256x256));
        objectsImageAudioArrayList.add(new AudioImagePoJo(R.raw.pencil, R.drawable.pencil256x256));
        objectsImageAudioArrayList.add(new AudioImagePoJo(R.raw.school_bag, R.drawable.schoolbag256x256));
        objectsImageAudioArrayList.add(new AudioImagePoJo(R.raw.table, R.drawable.table256x256));


        //ArrayList<AudioImagePoJo> finalArrayList = generateArrayList(foodImageArray,foodAudioArray);

        setUpLayout(foodImageAudioArrayList);

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

        play_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer = MediaPlayer.create(context, seletedAudio);
                mediaPlayer.start();
            }
        });

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (selectedImageView != null) {
                    //Answer Selected
                    selectedImageView.setBackgroundResource(R.drawable.answer_item_backgournd);

                    questionNumber = questionNumber + 1;
                    if (selectedImageView.getTag().equals(play_btn.getTag())) {
                        //Answer Right
                        marks = marks + 1;

                        linearLayout.setVisibility(LinearLayout.INVISIBLE);
                        Snackbar.make(view, "Correct", Snackbar.LENGTH_INDEFINITE)
                                .setAction("OK", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        linearLayout.setVisibility(LinearLayout.VISIBLE);
                                    }
                                }).show();

                    } else {
                        //answer wrong
                        linearLayout.setVisibility(LinearLayout.INVISIBLE);
                        Snackbar.make(view, "You choose the wrong image", Snackbar.LENGTH_INDEFINITE)
                                .setAction("OK", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        linearLayout.setVisibility(LinearLayout.VISIBLE);
                                    }
                                }).show();
                    }
                    switch (questionNumber) {

                        case 7:
                            setUpLayout(foodImageAudioArrayList);
                            break;
                        case 8:
                            setUpLayout(animalsImageAudioArrayList);
                            break;
                        case 9:
                            setUpLayout(colorImageAudioArrayList);
                            break;
                        case 10:
                            setUpLayout(objectsImageAudioArrayList);
                            break;
                        default:
                            ResultFragment resultFragment = ResultFragment
                                    .getInstance(String.valueOf(questionNumber - 1), String.valueOf(marks));
                            deliveryResultListener.deliverResult(resultFragment);
                            break;
                    }

                } else {
                    //image not selected
                    Toast.makeText(context, "Please Select Image First", Toast.LENGTH_SHORT).show();
                }

            }
        });

        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
    }

    void setUpLayout(ArrayList<AudioImagePoJo> audioImagePoJos) {

        selectedImageView = null;
        question_number_tv.setText("Question Number : " + String.valueOf(questionNumber));
        marks_tv.setText("Marks Gain : " + String.valueOf(marks));

        Collections.shuffle(audioImagePoJos);
        audioImagePoJos.remove(audioImagePoJos.size() - 1);
        audioImagePoJos.remove(audioImagePoJos.size() - 2);
        seletedAudio = audioImagePoJos.get(0).getAudioId();
        play_btn.setTag(audioImagePoJos.get(0).getImageId());
        Collections.shuffle(audioImagePoJos);
        imageOne.setImageResource(audioImagePoJos.get(0).getImageId());
        imageTwo.setImageResource(audioImagePoJos.get(1).getImageId());
        imageThree.setImageResource(audioImagePoJos.get(2).getImageId());
        imageFour.setImageResource(audioImagePoJos.get(3).getImageId());

        imageOne.setTag(audioImagePoJos.get(0).getImageId());
        imageTwo.setTag(audioImagePoJos.get(1).getImageId());
        imageThree.setTag(audioImagePoJos.get(2).getImageId());
        imageFour.setTag(audioImagePoJos.get(3).getImageId());


    }

}
