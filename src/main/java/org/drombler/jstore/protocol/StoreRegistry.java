package org.drombler.jstore.protocol;


import org.drombler.jstore.protocol.json.Store;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class StoreRegistry {

    private final Map<String, Store> stores = new HashMap<>();

    public boolean containsStore(String storeId) {
        return stores.containsKey(storeId);
    }

    public void registerStore(Store store) {
        if (stores.containsKey(store.getId())) {
            throw new IllegalArgumentException("Store with store id " + store.getId() + " already registered!");
        }
        stores.put(store.getId(), store);
    }

    public Collection<Store> getStores() {
        return stores.values();
    }

    public Store getStore(String storeId) {
        return stores.get(storeId);
    }

    public void unregisterStore(String storeId) {
        stores.remove(storeId);
    }
}
