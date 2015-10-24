package oms.myexamples.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import oms.myexamples.fragments.MessagesFragment;
import oms.myexamples.R;
import oms.myexamples.fragments.DrawerFragment;
import oms.myexamples.fragments.FriendsFragment;
import oms.myexamples.fragments.HomeFragment;

public class MainActivity extends AppCompatActivity implements DrawerFragment.FragmentDrawerListener {
  private Toolbar toolbar;
  private DrawerFragment drawerFragment;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    toolbar= (Toolbar)findViewById(R.id.toolbar);

    if(toolbar!=null){
      setSupportActionBar(toolbar);
      getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    drawerFragment=(DrawerFragment)getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
    drawerFragment.setUp(R.id.fragment_navigation_drawer,(DrawerLayout)findViewById(R.id.drawer_layout),toolbar);
    drawerFragment.setDrawerListener(this);

    // display the first navigation drawer view on app launch
    displayView(0);

  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if(id == R.id.action_search){
      Toast.makeText(getApplicationContext(), "Search action is selected!", Toast.LENGTH_SHORT).show();
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
  @Override
  public void onDrawerItemSelected(View view, int position){
    displayView(position);
  }

  private void displayView(int position){
    Fragment fragment=null;
    String title = getString(R.string.app_name);
    switch (position){
      case 0:
        fragment = new HomeFragment();
        title = getString(R.string.title_home);
        break;
      case 1:
        fragment = new FriendsFragment();
        title = getString(R.string.title_friends);
        break;
      case 2:
        fragment = new MessagesFragment();
        title = getString(R.string.title_friends);
        break;
      default:
        break;
    }

    if(fragment!=null){
      FragmentManager fragmentManager = getSupportFragmentManager();
      FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
      fragmentTransaction.replace(R.id.container_body, fragment);
      fragmentTransaction.commit();

      // set the toolbar title
      getSupportActionBar().setTitle(title);
    }

  }
}
