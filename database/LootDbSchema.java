package com.mcs270.lootbox.database;

public class LootDbSchema {
    public static final class LootTable {
        public static final String NAME = "loot";

        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String NUM = "num";
            public static final String TIER = "tier";
            public static final String RARITY = "rarity";
            public static final String PRICE = "price";
            public static final String KEPT = "kept";
        }
    }
}
