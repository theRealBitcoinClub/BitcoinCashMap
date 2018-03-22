package club.therealbitcoin.bchmap;

import com.google.android.gms.maps.model.LatLng;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import club.therealbitcoin.bchmap.club.therealbitcoin.bchmap.model.Venue;
import club.therealbitcoin.bchmap.persistence.VenueFacade;

@RunWith(RobolectricTestRunner.class)
public class VenueFacadeTest {

    @Test
    public void testAddFavorite() throws IOException {
        Venue v = new Venue("name",1,2,"jkdhuifew",0,4.7,new LatLng(3.4,4.5));
        VenueFacade.getInstance().addFavoriteVenue(v,RuntimeEnvironment.application,true);
        List<Venue> favoriteVenues = VenueFacade.getInstance().getFavoriteVenues(RuntimeEnvironment.application);
        Assert.assertEquals(favoriteVenues.size(),1);
    }


    @Test
    public void testAddMoreFavorites() throws IOException {
        Venue v = new Venue("name",1,2,"jkdhuifew",0,4.7,new LatLng(3.4,4.5));
        VenueFacade.getInstance().addFavoriteVenue(v,RuntimeEnvironment.application,true);
        List<Venue> favoriteVenues = VenueFacade.getInstance().getFavoriteVenues(RuntimeEnvironment.application);
        Assert.assertEquals(favoriteVenues.size(),1);
    }

    @Test
    public void testGetVenueTitles() throws IOException {
        Venue v = new Venue("name",1,2,"jkdhuifew",0,4.7,new LatLng(3.4,4.5));
        ArrayList<String> venueTitles = VenueFacade.getInstance().getVenueTitles();
        Assert.assertEquals(venueTitles.size(),0);
        VenueFacade.getInstance().addVenue(v);
        venueTitles = VenueFacade.getInstance().getVenueTitles();
        Assert.assertEquals(venueTitles.size(),1);
    }
}