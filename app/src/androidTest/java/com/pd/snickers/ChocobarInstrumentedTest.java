package com.pd.snickers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import com.google.android.material.snackbar.Snackbar;
import androidx.test.rule.ActivityTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import android.widget.TextView;

import com.pd.chocobar.ChocoBar;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Unit tests {@link ChocoBar}.
 */
@RunWith(AndroidJUnit4.class)
public class ChocobarInstrumentedTest {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(
            MainActivity.class);

    /**
     * Verifies the default Chocobar type.
     */
    @Test
    public void testDefaultChocobar() {
        // Given chocobar builder
        ChocoBar.Builder chocoBarBuilder = ChocoBar.builder()
                .setView(activityTestRule.getActivity().getCurrentFocus());

        // When building a default Snackbar
        Snackbar chocoBar = chocoBarBuilder.build();

        // Then it matches the expected configuration
        Snackbar.SnackbarLayout chocolateLayout = (Snackbar.SnackbarLayout) chocoBar.getView();
        TextView snackbarText = chocolateLayout.findViewById(R.id.snackbar_text);
        assertEquals("Snackbar text did not match the expected.", "", snackbarText.getText());

        assertEquals("Snackbar duration did not match the expected.", Snackbar.LENGTH_SHORT, chocoBar.getDuration());

        assertTrue(chocolateLayout.getBackground() instanceof GradientDrawable);

        // and that it can be shown
        chocoBar.show();
        assertTrue(chocoBar.isShown());
        thenWait(1000);
    }

    /**
     * Verifies the green Chocobar type.
     */
    @Test
    public void testGreenChocobar() {
        // Given chocobar builder
        ChocoBar.Builder chocoBarBuilder = ChocoBar.builder()
                .setView(activityTestRule.getActivity().getCurrentFocus());

        // When building a green Snackbar
        Snackbar chocoBar = chocoBarBuilder.green();

        // Then it matches the expected configuration
        Snackbar.SnackbarLayout chocolateLayout = (Snackbar.SnackbarLayout) chocoBar.getView();

        TextView snackbarText = chocolateLayout.findViewById(R.id.snackbar_text);
        assertEquals(
                "Snackbar text did not match the expected.",
                "SUCCESS !",
                snackbarText.getText());

        assertEquals("Snackbar duration did not match the expected.",
                Snackbar.LENGTH_SHORT,
                chocoBar.getDuration());

        assertEquals("Expected background color for snackbar layout to be #388E3C.",
                Color.parseColor("#388E3C"),
                ((ColorDrawable) chocolateLayout.getBackground()).getColor());

        // and that it can be shown
        chocoBar.show();
        assertTrue(chocoBar.isShown());
        thenWait(1000);
    }

    /**
     * Verifies the red Chocobar type.
     */
    @Test
    public void testRedChocobar() {
        // Given chocobar builder
        ChocoBar.Builder chocoBarBuilder = ChocoBar.builder()
                .setView(activityTestRule.getActivity().getCurrentFocus());

        // When building a red Snackbar
        Snackbar chocoBar = chocoBarBuilder.red();

        // Then it matches the expected configuration
        Snackbar.SnackbarLayout chocolateLayout = (Snackbar.SnackbarLayout) chocoBar.getView();

        TextView snackbarText = chocolateLayout.findViewById(R.id.snackbar_text);
        assertEquals(
                "Snackbar text did not match the expected.",
                "ERROR !",
                snackbarText.getText());

        assertEquals("Snackbar duration did not match the expected.",
                Snackbar.LENGTH_SHORT,
                chocoBar.getDuration());

        assertEquals("Expected background color for snackbar layout to be #D50000.",
                Color.parseColor("#D50000"),
                ((ColorDrawable) chocolateLayout.getBackground()).getColor());

        // and that it can be shown
        chocoBar.show();
        assertTrue(chocoBar.isShown());
        thenWait(1000);
    }

    /**
     * Verifies the cyan Chocobar type.
     */
    @Test
    public void testCyanChocobar() {
        // Given chocobar builder
        ChocoBar.Builder chocoBarBuilder = ChocoBar.builder()
                .setView(activityTestRule.getActivity().getCurrentFocus());

        // When building a cyan Snackbar
        Snackbar chocoBar = chocoBarBuilder.cyan();

        // Then it matches the expected configuration
        Snackbar.SnackbarLayout chocolateLayout = (Snackbar.SnackbarLayout) chocoBar.getView();

        TextView snackbarText = chocolateLayout.findViewById(R.id.snackbar_text);
        assertEquals(
                "Snackbar text did not match the expected.",
                "CYAN",
                snackbarText.getText());

        assertEquals("Snackbar duration did not match the expected.",
                Snackbar.LENGTH_SHORT,
                chocoBar.getDuration());

        assertEquals("Expected background color for snackbar layout to be #e0ffff.",
                Color.parseColor("#e0ffff"),
                ((ColorDrawable) chocolateLayout.getBackground()).getColor());

        // and that it can be shown
        chocoBar.show();
        assertTrue(chocoBar.isShown());
        thenWait(1000);
    }

    /**
     * Verifies the orange Chocobar type.
     */
    @Test
    public void testOrangeChocobar() {
        // Given chocobar builder
        ChocoBar.Builder chocoBarBuilder = ChocoBar.builder()
                .setView(activityTestRule.getActivity().getCurrentFocus());

        // When building a orange Snackbar
        Snackbar chocoBar = chocoBarBuilder.orange();

        // Then it matches the expected configuration
        Snackbar.SnackbarLayout chocolateLayout = (Snackbar.SnackbarLayout) chocoBar.getView();

        TextView snackbarText = chocolateLayout.findViewById(R.id.snackbar_text);
        assertEquals(
                "Snackbar text did not match the expected.",
                "WARNING !",
                snackbarText.getText());

        assertEquals("Snackbar duration did not match the expected.",
                Snackbar.LENGTH_SHORT,
                chocoBar.getDuration());

        assertEquals("Expected background color for snackbar layout to be #ffa500.",
                Color.parseColor("#ffa500"),
                ((ColorDrawable) chocolateLayout.getBackground()).getColor());

        // and that it can be shown
        chocoBar.show();
        assertTrue(chocoBar.isShown());
        thenWait(1000);
    }

    /**
     * Verifies the good Chocobar type.
     */
    @Test
    public void testGoodChocobar() {
        // Given chocobar builder
        ChocoBar.Builder chocoBarBuilder = ChocoBar.builder()
                .setView(activityTestRule.getActivity().getCurrentFocus());

        // When building a good Snackbar
        Snackbar chocoBar = chocoBarBuilder.good();

        // Then it matches the expected configuration
        Snackbar.SnackbarLayout chocolateLayout = (Snackbar.SnackbarLayout) chocoBar.getView();

        TextView snackbarText = chocolateLayout.findViewById(R.id.snackbar_text);
        assertEquals(
                "Snackbar text did not match the expected.",
                "GRAY_GOOD",
                snackbarText.getText());

        assertEquals("Snackbar duration did not match the expected.",
                Snackbar.LENGTH_SHORT,
                chocoBar.getDuration());

        assertEquals("Expected background color for snackbar layout to be #C5BEBE.",
                Color.parseColor("#C5BEBE"),
                ((ColorDrawable) chocolateLayout.getBackground()).getColor());

        // and that it can be shown
        chocoBar.show();
        assertTrue(chocoBar.isShown());
        thenWait(1000);
    }

    /**
     * Verifies the bad Chocobar type.
     */
    @Test
    public void testBadChocobar() {
        // Given chocobar builder
        ChocoBar.Builder chocoBarBuilder = ChocoBar.builder()
                .setView(activityTestRule.getActivity().getCurrentFocus());

        // When building a bad Snackbar
        Snackbar chocoBar = chocoBarBuilder.bad();

        // Then it matches the expected configuration
        Snackbar.SnackbarLayout chocolateLayout = (Snackbar.SnackbarLayout) chocoBar.getView();

        TextView snackbarText = chocolateLayout.findViewById(R.id.snackbar_text);
        assertEquals(
                "Snackbar text did not match the expected.",
                "GRAY_BAD",
                snackbarText.getText());

        assertEquals("Snackbar duration did not match the expected.",
                Snackbar.LENGTH_SHORT,
                chocoBar.getDuration());

        assertEquals("Expected background color for snackbar layout to be #C5BEBE.",
                Color.parseColor("#C5BEBE"),
                ((ColorDrawable) chocolateLayout.getBackground()).getColor());

        // and that it can be shown
        chocoBar.show();
        assertTrue(chocoBar.isShown());
        thenWait(1000);
    }

    /**
     * Verifies the bad Chocobar type.
     */
    @Test
    public void testBlackChocobar() {
        // Given chocobar builder
        ChocoBar.Builder chocoBarBuilder = ChocoBar.builder()
                .setView(activityTestRule.getActivity().getCurrentFocus());

        // When building a black Snackbar
        Snackbar chocoBar = chocoBarBuilder.black();

        // Then it matches the expected configuration
        Snackbar.SnackbarLayout chocolateLayout = (Snackbar.SnackbarLayout) chocoBar.getView();

        TextView snackbarText = chocolateLayout.findViewById(R.id.snackbar_text);
        assertEquals(
                "Snackbar text did not match the expected.",
                "Black",
                snackbarText.getText());

        assertEquals("Snackbar duration did not match the expected.",
                Snackbar.LENGTH_SHORT,
                chocoBar.getDuration());

        assertEquals("Expected background color for snackbar layout to be #000000.",
                Color.parseColor("#000000"),
                ((ColorDrawable) chocolateLayout.getBackground()).getColor());

        // and that it can be shown
        chocoBar.show();
        assertTrue(chocoBar.isShown());
        thenWait(1000);
    }

    /**
     * Verifies the love Chocobar type.
     */
    @Test
    public void testLoveChocobar() {
        // Given chocobar builder
        ChocoBar.Builder chocoBarBuilder = ChocoBar.builder()
                .setView(activityTestRule.getActivity().getCurrentFocus());

        // When building a black Snackbar
        Snackbar chocoBar = chocoBarBuilder.love();

        // Then it matches the expected configuration
        Snackbar.SnackbarLayout chocolateLayout = (Snackbar.SnackbarLayout) chocoBar.getView();

        TextView snackbarText = chocolateLayout.findViewById(R.id.snackbar_text);
        assertEquals(
                "Snackbar text did not match the expected.",
                "LOVE",
                snackbarText.getText());

        assertEquals("Snackbar duration did not match the expected.",
                Snackbar.LENGTH_SHORT,
                chocoBar.getDuration());

        assertEquals("Expected background color for snackbar layout to be #E8290B.",
                Color.parseColor("#E8290B"),
                ((ColorDrawable) chocolateLayout.getBackground()).getColor());

        // and that it can be shown
        chocoBar.show();
        assertTrue(chocoBar.isShown());
        thenWait(1000);
    }

    /**
     * Verifies the love Chocobar type.
     */
    @Test
    public void testNotificationOnChocobar() {
        // Given chocobar builder
        ChocoBar.Builder chocoBarBuilder = ChocoBar.builder()
                .setView(activityTestRule.getActivity().getCurrentFocus());

        // When building a black Snackbar
        Snackbar chocoBar = chocoBarBuilder.notificationsOn();

        // Then it matches the expected configuration
        Snackbar.SnackbarLayout chocolateLayout = (Snackbar.SnackbarLayout) chocoBar.getView();

        TextView snackbarText = chocolateLayout.findViewById(R.id.snackbar_text);
        assertEquals(
                "Snackbar text did not match the expected.",
                "NOTIFICATIONS ON",
                snackbarText.getText());

        assertEquals("Snackbar duration did not match the expected.",
                Snackbar.LENGTH_SHORT,
                chocoBar.getDuration());

        assertEquals("Expected background color for snackbar layout to be #000000.",
                Color.parseColor("#000000"),
                ((ColorDrawable) chocolateLayout.getBackground()).getColor());

        // and that it can be shown
        chocoBar.show();
        assertTrue(chocoBar.isShown());
        thenWait(1000);
    }

    /**
     * Verifies the blocked Chocobar type.
     */
    @Test
    public void testBlockedChocobar() {
        // Given chocobar builder
        ChocoBar.Builder chocoBarBuilder = ChocoBar.builder()
                .setView(activityTestRule.getActivity().getCurrentFocus());

        // When building a blocked Snackbar
        Snackbar chocoBar = chocoBarBuilder.blocked();

        // Then it matches the expected configuration
        Snackbar.SnackbarLayout chocolateLayout = (Snackbar.SnackbarLayout) chocoBar.getView();

        TextView snackbarText = chocolateLayout.findViewById(R.id.snackbar_text);
        assertEquals(
                "Snackbar text did not match the expected.",
                "BLOCKED",
                snackbarText.getText());

        assertEquals("Snackbar duration did not match the expected.",
                Snackbar.LENGTH_SHORT,
                chocoBar.getDuration());

        assertEquals("Expected background color for snackbar layout to be #E8290B.",
                Color.parseColor("#E8290B"),
                ((ColorDrawable) chocolateLayout.getBackground()).getColor());

        // and that it can be shown
        chocoBar.show();
        assertTrue(chocoBar.isShown());
        thenWait(1000);
    }

    private void thenWait(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
