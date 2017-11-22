package com.example.user013050.justjava;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by user013050 on 22.11.17.
 */
@android.test.suitebuilder.annotation.LargeTest
@RunWith(AndroidJUnit4.class)

public class FirstTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp() throws Exception{

    }

    @Test
    public void test1ChatId(){
        onView(withText("TOPPINGS")).check(matches(isDisplayed()));
    }
}
