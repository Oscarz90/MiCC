package oms.myexamples.views.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import oms.myexamples.entities.NavDrawerItem;
import oms.myexamples.R;

/**
 * Created by 430004587 on 03/09/2015.
 */
public class NavigationDrawerAdapter extends RecyclerView.Adapter<NavDrawerItem> {

  class MyViewHolder extends RecyclerView.ViewHolder{
    TextView title;

    public MyViewHolder(View itemView){
      super(itemView);
      title = (TextView)itemView.findViewById(R.id.title);
    }
  }
}
