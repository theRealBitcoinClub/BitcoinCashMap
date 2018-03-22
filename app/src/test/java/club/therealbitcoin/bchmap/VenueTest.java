package club.therealbitcoin.bchmap;

import com.google.android.gms.maps.model.LatLng;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

import java.io.IOException;
import java.util.List;

import club.therealbitcoin.bchmap.club.therealbitcoin.bchmap.model.Venue;
import club.therealbitcoin.bchmap.persistence.VenueFacade;


@RunWith(RobolectricTestRunner.class)
public class VenueTest {
    String testName = "name";
    int testIconRes = R.drawable.ic_action_add_location;
    int type = 0;
    LatLng cord = new LatLng(3.4,5.6);
    String placesId = "4543tdfg34";
    int rev = 234;
    double stras = 4.8;

    @Test
    public void testIsFavorite() throws IOException {
        Venue v = new Venue(testName, testIconRes, type, placesId, rev, stras, cord);
        VenueFacade.getInstance().addFavoriteVenue(v,RuntimeEnvironment.application,true);
        List<Venue> favoriteVenues = VenueFacade.getInstance().getFavoriteVenues(RuntimeEnvironment.application);
        Assert.assertEquals(1, favoriteVenues.size());
        boolean favorite = v.isFavorite(RuntimeEnvironment.application);
        Assert.assertEquals(true, favorite);
    }

    @Test
    public void createVenue() {
        Venue venue = new Venue(testName, testIconRes, type, placesId, rev, stras, cord);
        Assert.assertEquals(testName, venue.name);
        Assert.assertNotSame(testName + "fdsfds", venue.name);
        Assert.assertEquals(testIconRes, venue.iconRes);
        Assert.assertEquals(type, venue.type);
        Assert.assertEquals(placesId, venue.placesId);
        Assert.assertEquals(rev, venue.reviews);
        Assert.assertEquals(stras, venue.stars);
    }
}
