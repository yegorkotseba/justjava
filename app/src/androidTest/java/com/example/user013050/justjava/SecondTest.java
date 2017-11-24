package com.example.user013050.justjava;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by user013050 on 24.11.17.
 */

@android.test.suitebuilder.annotation.LargeTest
@RunWith(AndroidJUnit4.class)

public class SecondTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testEnteredValueDisplay(){
        onView(withId(R.id.add_name_text_input)).perform(click());
        onView(withId(R.id.add_name_text_input)).perform(replaceText("First"), closeSoftKeyboard());

        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
