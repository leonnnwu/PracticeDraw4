package com.hencoder.hencoderpracticedraw4;

import android.os.Bundle;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import android.view.Menu;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager2 pager;
    List<PageModel> pageModels = new ArrayList<>();

    {
        pageModels.add(new PageModel(R.layout.sample_clip_rect, R.string.title_clip_rect, R.layout.practice_clip_rect));
        pageModels.add(new PageModel(R.layout.sample_clip_path, R.string.title_clip_path, R.layout.practice_clip_path));
        pageModels.add(new PageModel(R.layout.sample_translate, R.string.title_translate, R.layout.practice_translate));
        pageModels.add(new PageModel(R.layout.sample_scale, R.string.title_scale, R.layout.practice_scale));
        pageModels.add(new PageModel(R.layout.sample_rotate, R.string.title_rotate, R.layout.practice_rotate));
        pageModels.add(new PageModel(R.layout.sample_skew, R.string.title_skew, R.layout.practice_skew));
        pageModels.add(new PageModel(R.layout.sample_matrix_translate, R.string.title_matrix_translate, R.layout.practice_matrix_translate));
        pageModels.add(new PageModel(R.layout.sample_matrix_scale, R.string.title_matrix_scale, R.layout.practice_matrix_scale));
        pageModels.add(new PageModel(R.layout.sample_matrix_rotate, R.string.title_matrix_rotate, R.layout.practice_matrix_rotate));
        pageModels.add(new PageModel(R.layout.sample_matrix_skew, R.string.title_matrix_skew, R.layout.practice_matrix_skew));
        pageModels.add(new PageModel(R.layout.sample_camera_rotate, R.string.title_camera_rotate, R.layout.practice_camera_rotate));
        pageModels.add(new PageModel(R.layout.sample_camera_rotate_fixed, R.string.title_camera_rotate_fixed, R.layout.practice_measure_text));
        pageModels.add(new PageModel(R.layout.sample_camera_rotate_hitting_face, R.string.title_camera_rotate_hitting_face, R.layout.practice_camera_rotate_hitting_face));
        pageModels.add(new PageModel(R.layout.sample_flipboard, R.string.title_flipboard, R.layout.practice_flipboard));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = (ViewPager2) findViewById(R.id.pager);
        pager.setAdapter(new FragmentStateAdapter(this) {

            @Override
            public int getItemCount() {
                return pageModels.size();
            }

            @NonNull
            @Override
            public Fragment createFragment(int position) {
                PageModel pageModel = pageModels.get(position);
                return PageFragment.newInstance(pageModel.sampleLayoutRes, pageModel.practiceLayoutRes);
            }
        });

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        new TabLayoutMediator(tabLayout, pager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(pageModels.get(position).titleRes);
            }
        }).attach();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    private class PageModel {
        @LayoutRes int sampleLayoutRes;
        @StringRes int titleRes;
        @LayoutRes int practiceLayoutRes;

        PageModel(@LayoutRes int sampleLayoutRes, @StringRes int titleRes, @LayoutRes int practiceLayoutRes) {
            this.sampleLayoutRes = sampleLayoutRes;
            this.titleRes = titleRes;
            this.practiceLayoutRes = practiceLayoutRes;
        }
    }
}
