package clempie.suivistock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Clem on 26/04/2016.
 */
public class NewItemTabsAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public NewItemTabsAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {

        switch (position) {
            case 0:
                NewItemTabCreateItem createItemTab = new NewItemTabCreateItem();
                return createItemTab;
            case 1:
                NewItemTabExistingItem existingItemsTab = new NewItemTabExistingItem();
                return existingItemsTab;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
