package com.mcs270.lootbox;

import java.util.UUID;

public class Box {

    private UUID mId;
    private String mTier;
    private String mRarity;
    private boolean mKept;
    private String mPrice;

    public Box(){
        this(UUID.randomUUID());
    }

    public Box(UUID id) {
        mId = id;
    }

    public UUID getId() {
        return mId;
    }

    public String getTier() {
        return mTier;
    }

    public void setTier(String tier) {
        mTier = tier;
    }

    public String getRarity() {
        return mRarity;
    }

    public void setRarity(String rarity) {
        mRarity = rarity;
    }

    public boolean isKept() {
        return mKept;
    }

    public void setKept(boolean kept) {
        mKept = kept;
    }

    public String getPrice() {
        return mPrice;
    }

    public void setPrice(String price) {
        mPrice = price;
    }

}
