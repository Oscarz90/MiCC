package oms.myexamples.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import oms.myexamples.R;
import oms.myexamples.entities.NavDrawerItem;
import oms.myexamples.views.adapters.NavigationDrawerAdapter;

/**
 * Created by 430004587 on 04/09/2015.
 */
public class FragmentDrawer extends Fragment{
  private static String Tag = FragmentDrawer.class.getSimpleName();

  private RecyclerView recyclerView;
  private ActionBarDrawerToggle mDrawerToggle;
  private DrawerLayout mDrawerLayout;
  private NavigationDrawerAdapter adapter;
  private View containerView;
  private static String[] titles=null;
  private FragmentDrawerListener drawerListener;

  public FragmentDrawer(){

  }

  public static List<NavDrawerItem> getData(){
    List<NavDrawerItem> data = new ArrayList<>();

    for(int i=0; i < titles.length;i++){
      NavDrawerItem navItem = new NavDrawerItem();
      navItem.setTitle(titles[i]);
      data.add(navItem);
    }
    return data;
  }

  @Override
  public void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);

    titles=getActivity().getResources().getStringArray(R.array.nav_drawer_labels);

  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
    View layout = inflater.inflate(R.layout.fragment_nav_drawer,container,false);
    recyclerView=(RecyclerView)layout.findViewById(R.id.drawerList);
    adapter = new NavigationDrawerAdapter(getActivity(),getData());

    recyclerView.setAdapter(adapter);
    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
      @Override
      public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

        return false;
      }

      @Override
      public void onTouchEvent(RecyclerView rv, MotionEvent e) {

      }

      @Override
      public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

      }
    });

    return layout;
  }

  public interface FragmentDrawerListener{
    public void onDrawerItemSelected(View view, int position);
  }

  public void setDrawerLinstener(FragmentDrawerListener listener){
    this.drawerListener=listener;
  }
}
