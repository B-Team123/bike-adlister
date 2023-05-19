package com.codeup.adlister.dao;

import com.codeup.adlister.models.Feature;

import java.util.List;

public interface Features {
// get a list of all the features
    List<Feature> all();
    // insert a new feature and return the new feature's id
    Long insert(Feature feature);

    List<Feature> findByAdId(long adId);
}
