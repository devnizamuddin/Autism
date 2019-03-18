package com.example.autism.NavigationItem;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.autism.Adapter.ImageAdapter;
import com.example.autism.PoJo.ImagePoJo;
import com.example.autism.R;

import java.util.ArrayList;
import java.util.Collections;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReArrangeImageFragment extends Fragment implements ImageAdapter.ImageClickListener {


    private int[] imageArray = {R.drawable.step_1,R.drawable.step_2,R.drawable.step_3,R.drawable.step_4,R.drawable.step_5,
    R.drawable.step_6,R.drawable.step_7,R.drawable.step_8,R.drawable.step_9,R.drawable.step_10};

    private RecyclerView recyclerView;

    private Context context;
    private int serialNumber = 1;
    private ImageAdapter imageAdapter;
    private ArrayList<ImagePoJo>imagePoJos = new ArrayList<>();
    private ArrayList<ImagePoJo> oderImagePoJos = new ArrayList<>();
    private int score = 0;
    private int wrong = 0;
    private TextView wrong_tv,score_tv;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    public ReArrangeImageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rearrange_image, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        score_tv = view.findViewById(R.id.score_tv);
        wrong_tv = view.findViewById(R.id.wrong_tv);

        score_tv.setText("Score : "+String.valueOf(score));
        wrong_tv.setText("Wrong : "+String.valueOf(wrong));

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(context,2);
        recyclerView.setLayoutManager(layoutManager);

        imagePoJos.add(new ImagePoJo(1,imageArray[0]));
        imagePoJos.add(new ImagePoJo(2,imageArray[1]));
        imagePoJos.add(new ImagePoJo(3,imageArray[2]));
        imagePoJos.add(new ImagePoJo(4,imageArray[3]));
        imagePoJos.add(new ImagePoJo(5,imageArray[4]));
        imagePoJos.add(new ImagePoJo(6,imageArray[5]));
        imagePoJos.add(new ImagePoJo(7,imageArray[6]));
        imagePoJos.add(new ImagePoJo(8,imageArray[7]));
        imagePoJos.add(new ImagePoJo(9,imageArray[8]));
        imagePoJos.add(new ImagePoJo(10,imageArray[9]));

        oderImagePoJos = imagePoJos;

       // Collections.shuffle(imagePoJos);

        Collections.shuffle(imagePoJos);
        imageAdapter = new ImageAdapter(context,imagePoJos,this);
        recyclerView.setAdapter(imageAdapter);
        return view;
    }

    @Override
    public void onImageClick(ImagePoJo imagePoJo) {

        switch (serialNumber){
            case 1:
                updateRecyclerView(imagePoJo,1);
                break;
            case 2:
                updateRecyclerView(imagePoJo,2);
                break;
            case 3:
                updateRecyclerView(imagePoJo,3);
                break;
            case 4:
                updateRecyclerView(imagePoJo,4);
                break;
            case 5:
                updateRecyclerView(imagePoJo,5);
                break;
            case 6:
                updateRecyclerView(imagePoJo,6);
                break;
            case 7:
                updateRecyclerView(imagePoJo,7);
                break;
            case 8:
                updateRecyclerView(imagePoJo,8);
                break;
            case 9:
                updateRecyclerView(imagePoJo,9);
                break;
            case 10:
                updateRecyclerView(imagePoJo,10);
                break;

                default:
                    Toast.makeText(context, "Ok", Toast.LENGTH_SHORT).show();
                    break;
        }

    }
    void updateRecyclerView(ImagePoJo imagePoJo,int currentStep){

        if (imagePoJo.getImageDrawableId() == imageArray[serialNumber-1]){
            imagePoJos.remove(imagePoJo);
            imageAdapter.updateImage(imagePoJos);
            Toast.makeText(context, "Correct", Toast.LENGTH_SHORT).show();
            serialNumber =serialNumber+1;
            score = score+1;
            score_tv.setText("Score : "+String.valueOf(score));

        }
        else {
           /* showCorrectImage(imageArray[serialNumber-1]);
            ArrayList<ImagePoJo> tempImagePojos = oderImagePoJos;
            Toast.makeText(context, ""+tempImagePojos.size(), Toast.LENGTH_SHORT).show();
            tempImagePojos.remove(currentStep);
            Collections.shuffle(tempImagePojos);
            imageAdapter.updateImage(tempImagePojos);
            Toast.makeText(context, "You choose the wrong one", Toast.LENGTH_SHORT).show();*/

           ImagePoJo imagePoJo1 = findPoJoByProperties(currentStep);
           showCorrectImage(imagePoJo1.getImageDrawableId());
           imagePoJos.remove(imagePoJo1);
           imageAdapter.updateImage(imagePoJos);

            serialNumber =serialNumber+1;
            wrong = wrong+1;
            wrong_tv.setText("Wrong : "+String.valueOf(wrong));
        }
    }
    void showCorrectImage(int drawableId){

        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View view = LayoutInflater.from(context).inflate(R.layout.correct_image_layout,null);
        builder.setView(view);
        Button close = view.findViewById(R.id.close_right_image_btn);
        ImageView rightImage = view.findViewById(R.id.correct_image_iv);

        rightImage.setImageResource(drawableId);
        final AlertDialog dialog = builder.show();
       close.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               dialog.dismiss();
           }
       });

    }
  public  ImagePoJo findPoJoByProperties(int step){

        ImagePoJo rImagePoJo = new ImagePoJo();
        for ( int i =0; i<imagePoJos.size();i++){

            ImagePoJo imagePoJo = imagePoJos.get(i);
            if (imagePoJo.getSerialNumber() == step){
               rImagePoJo = imagePoJo;
            }

        }

        return rImagePoJo;

    }

}
