package com.bolo1.tweet_app.bean;

import android.content.Entity;

import java.io.Serializable;
import java.util.List;

public interface ListEntity<T extends Entity> extends Serializable {

    public List<T> getList();
}
