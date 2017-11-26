package com.example.mohamed.merinal;

        import android.content.Context;
        import android.support.v4.view.PagerAdapter;
        import android.support.v4.view.ViewPager;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;

    public class SwipeActivity extends AppCompatActivity {

    String pageData[];
    LayoutInflater inflater;
    ViewPager vp;
    mySwipeAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe);

        pageData = getResources().getStringArray(R.array.desserts);
        inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        vp = (ViewPager) findViewById(R.id.viewPager);
        adapter = new mySwipeAdapter();
        vp.setAdapter(adapter);


    }
    private class mySwipeAdapter extends PagerAdapter {


        @Override
        public int getCount() {
            return pageData.length ;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == (View) object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View page = inflater.inflate(R.layout.view_layout, null);
            ((TextView)page.findViewById(R.id.textMessage)).setText(pageData[position]);
            ImageView imageView = page.findViewById(R.id.imageView);
            imageView.setImageResource(R.mipmap.ic_launcher_round);
            ((ViewPager) container).addView(page , 0 );
            return page;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            // super.destroyItem(container, position, object);
            ((ViewPager) container).removeView((View) object);
            object=null;
        }
    }
}
