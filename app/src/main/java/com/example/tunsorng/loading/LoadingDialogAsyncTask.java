package com.example.tunsorng.loading;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class LoadingDialogAsyncTask extends AsyncTask<Void,Integer,Boolean> {

    AlertDialog alertDialog;
    Context mContext;
    ProgressBar progressBar;
    TextView tvresult;
    public LoadingDialogAsyncTask(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        AlertDialog.Builder builder=new AlertDialog.Builder(mContext);
        View view =LayoutInflater.from(mContext).inflate(R.layout.progressbar_layout,null);
        progressBar=view.findViewById(R.id.progressBar);
        tvresult=view.findViewById(R.id.result);
        builder.setView(view);
        alertDialog = builder.create();
        alertDialog.show();
    }



    @Override
    protected Boolean doInBackground(Void... voids) {
        try {
            for(int i=0;i<=100;i++){
                publishProgress(i);
                Thread.sleep(50);
            }

            alertDialog.dismiss();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        progressBar.setProgress(values[0]);
        tvresult.setText(values[0]+"%");
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        Toast.makeText(mContext, "completed", Toast.LENGTH_SHORT).show();
    }
}
