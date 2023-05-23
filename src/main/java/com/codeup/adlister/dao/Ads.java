package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();
    // insert a new ad and return the new ad's id
    Long insert(Ad ad);
    // get a list of all the ads for a given user
    List<Ad> userAds(Long userId);
    // filter by bike type
    List<Ad> filterByType(String type);
    // filter by bike size
    List<Ad> filterBySize(String size);
    // delete an ad
    void removeAd(Long adId);

    List<Ad> searchAd(String search);

    // get ad by id
    Ad getAdById(Long adId);

    // update an ad
    void update(Ad ad);


}
